package com.example.pion.transaction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.example.pion.transaction.domain.Transaction;

@Mapper
public interface TransactionDao {
	@Transactional(readOnly = false)
	public void save(Transaction transaction);
	
	public List<Transaction> findAll();
	
	public void deleteAll();
}
