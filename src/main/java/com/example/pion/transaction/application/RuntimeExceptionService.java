package com.example.pion.transaction.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.pion.transaction.dao.TransactionDao;
import com.example.pion.transaction.domain.Transaction;

@Service
public class RuntimeExceptionService {	
	@Autowired
	private TransactionDao transactionDao;
	
	@Transactional
	public void saveTransaction(String content) {
		transactionDao.save(new Transaction("Not Error", content));
	}
	
	@Transactional
	public void throwRuntimeExceptionAfterSave(String content) {
		transactionDao.save(new Transaction("RuntimeException", content));
		throw new RuntimeException();
	}
	
	@Transactional
	public void catchThrowingRuntimeExceptionAfterSave(String content) {
		transactionDao.save(new Transaction("RuntimeException", content));
		
		try {
			throw new RuntimeException();
		}catch(RuntimeException e) {
			System.out.println("Caught throwing runtime exception at runtimeExceptionServie");
			e.printStackTrace();
		}
	}
	
	public void throwRuntimeExceptionAfterCallPrivateInnerMethod(String content) {
		innerSaveMethod(content);
		throw new RuntimeException();
	}
	
	public void throwRuntimeExceptionAfterCallPublicInnerMethod(String content) {
		saveTransaction(content);
//		throwRuntimeExceptionAfterSave(content);
		throw new RuntimeException();
	}
	
	@Transactional
	private void innerSaveMethod(String content) {
		transactionDao.save(new Transaction("Not Error", content));
	}
}
