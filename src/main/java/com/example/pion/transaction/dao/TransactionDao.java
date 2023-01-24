package com.example.pion.transaction.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.pion.transaction.domain.Transaction;

@Mapper
public interface TransactionDao {
	public void save(Transaction transaction);
	
	public List<Transaction> findAll();
	
	public void deleteAll();
}
