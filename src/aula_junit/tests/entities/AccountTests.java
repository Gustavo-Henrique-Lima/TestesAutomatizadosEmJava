package aula_junit.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aula_junit.entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {

	@Test
	public void depositShouldIncreaseBalanceWhenPositiveAmount() {
		Double amount = 200.0;
		Double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		Double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(100.0);
		Double amount = -200.0;
		acc.deposit(amount);
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void fullWithDrawShouldClearBalanceAndReturnFullBalance() {
		Double expectedValue = 0.0;
		Double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		Double result = acc.fullWithDraw();
		Assertions.assertEquals(expectedValue, acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	@Test
	public void withDrawShouldDecreaseBalanceWhenSufficientBalance() {
		Double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);
		acc.withDraw(500.0);
		Assertions.assertEquals(300, acc.getBalance());
	}

	@Test
	public void withDrawShouldThrowExcpetionWhenInsufficientBalance() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Double initialBalance = 800.0;
			Account acc = AccountFactory.createAccount(initialBalance);
			acc.withDraw(801.0);
		});
	}
}