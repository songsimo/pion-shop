package com.example.pion.transaction.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OuterService {
	
	@Autowired
	private RuntimeExceptionService runtimeExceptionService;
	
	public void catchTransactionMethodThrowingRuntimeException(String content) {
		try {
			runtimeExceptionService.throwRuntimeExceptionAfterSave(content);
		}catch(RuntimeException e) {
			System.out.println("Caught runtime exception at outer");
			e.printStackTrace();
		}
	}
}
