package com.example.pion.utils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DatabaseCleanup implements InitializingBean {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<String> tableNames;
	
	@Override
	public void afterPropertiesSet() {
		tableNames = new ArrayList<>();
		try {
			DataSource dataSource = jdbcTemplate.getDataSource();
			DatabaseMetaData metaData = dataSource.getConnection().getMetaData();
			
			ResultSet rs = metaData.getTables(null, "PUBLIC", null, new String[]{"TABLE"});
			
			while(rs.next()) {                
				String tableName = rs.getString("TABLE_NAME");
				tableNames.add(tableName.toUpperCase());
			}
			
		}catch(Exception e) {
			System.out.println("Error : " + e);
		}
	}
	
	@Transactional
	public void execute() {
		jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY FALSE");
		
		for(String tableName: tableNames) {
			jdbcTemplate.execute("TRUNCATE TABLE " + tableName);
		}
		
		jdbcTemplate.execute("SET REFERENTIAL_INTEGRITY TRUE");
	}
}
