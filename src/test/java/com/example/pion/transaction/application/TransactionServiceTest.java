package com.example.pion.transaction.application;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.pion.transaction.dao.TransactionDao;
import com.example.pion.transaction.domain.Transaction;

@ActiveProfiles("test")
@SpringBootTest
public class TransactionServiceTest {
	
	@Autowired
	private RuntimeExceptionService runtimeExceptionService;
	
	@Autowired
	private OuterService outerService;
	
	@Autowired
	private TransactionDao transactionDao;
	
	@BeforeEach
    public void clear() {
		transactionDao.deleteAll();

		transactionDao.save(new Transaction("Error A Type", "Temp A Error"));
		transactionDao.save(new Transaction("Error B Type", "Temp B Error"));
    }
	
	@DisplayName("RuntimeException이 발생할 경우 트랜잭션 테스트")
	@Test
	void throwRuntimeException() {
		assertThatThrownBy(() -> {
			runtimeExceptionService.throwRuntimeExceptionAfterSave("Throw runtimeException");
		}).isInstanceOf(RuntimeException.class);
		
		List<Transaction> transasctions = transactionDao.findAll();
		
		System.out.println("=============== throwRuntimeException ===============");
		transasctions.stream().forEach(
				t -> System.out.printf("ErrorType : %s || ErrorContent : %s\n", t.getErrorType(), t.getContent())
		);
	}
	
	@DisplayName("Private 내부 메소드 실행후 RuntimeException이 발생할 경우 트랜잭션 테스트")
	@Test
	void throwRuntimeExceptionAfterCallPrivateInnerMethod() {
		assertThatThrownBy(() -> {
			runtimeExceptionService.throwRuntimeExceptionAfterCallPrivateInnerMethod("Throw runtimeException after call private inner method");
		}).isInstanceOf(RuntimeException.class);
		
		List<Transaction> transasctions = transactionDao.findAll();
		
		System.out.println("=============== throwRuntimeExceptionAfterCallPrivateInnerMethod ===============");
		transasctions.stream().forEach(
				t -> System.out.printf("ErrorType : %s || ErrorContent : %s\n", t.getErrorType(), t.getContent())
		);
	}
	
	@DisplayName("Public 내부 메소드 실행후 RuntimeException이 발생할 경우 트랜잭션 테스트")
	@Test
	void throwRuntimeExceptionAfterCallPublicInnerMethod() {
		assertThatThrownBy(() -> {
			runtimeExceptionService.throwRuntimeExceptionAfterCallPublicInnerMethod("Throw runtimeException after call private inner method");
		}).isInstanceOf(RuntimeException.class);
		
//		runtimeExceptionService.throwRuntimeExceptionAfterCallPublicInnerMethod("Throw runtimeException after call private inner method");
		
		List<Transaction> transasctions = transactionDao.findAll();
		
		System.out.println("=============== throwRuntimeExceptionAfterCallPublicInnerMethod ===============");
		transasctions.stream().forEach(
				t -> System.out.printf("ErrorType : %s || ErrorContent : %s\n", t.getErrorType(), t.getContent())
		);
	}

	@DisplayName("RuntimeException을 try-catch할 경우 트랜잭션 테스트")
	@Test
	public void catchThrowingRuntimeException() {
		runtimeExceptionService.catchThrowingRuntimeExceptionAfterSave("Catch throwing runtimeException");
		
		List<Transaction> transasctions = transactionDao.findAll();
		
		System.out.println("=============== catchThrowingRuntimeException ===============");
		transasctions.stream().forEach(
				t -> System.out.printf("ErrorType : %s || ErrorContent : %s\n", t.getErrorType(), t.getContent())
		);		
	}
	
	@DisplayName("A 서비스가 B서비스의 RuntimeException을 try-catch할 경우 트랜잭션 테스트")
	@Test
	void catchThrowingRuntimeExceptionAtOuterService() {		
		outerService.catchTransactionMethodThrowingRuntimeException("Catch throwing runtimeException At OuterService");
		
//		assertThatThrownBy(() -> {
//			outerService.catchTransactionMethodThrowingRuntimeException("Catch throwing runtimeException At OuterService");
//		});
		
		List<Transaction> transasctions = transactionDao.findAll();
		
		System.out.println("=============== catchThrowingRuntimeExceptionAtOuterService ===============");
		transasctions.stream().forEach(
				t -> System.out.printf("ErrorType : %s || ErrorContent : %s\n", t.getErrorType(), t.getContent())
		);		
	}
}
