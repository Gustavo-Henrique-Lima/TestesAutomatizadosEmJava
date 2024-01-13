package aula_junit.tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import aula_junit.entities.Financing;
import tests.factory.FinancingFactory;

public class FinancingTests {

	@Test
	public void financingShouldCreatedWhenValidData() {
		Financing entity = FinancingFactory.createValidFinancing(100000.0, 2000.0, 80);
		Assertions.assertEquals(100000.0, entity.getTotalAmount());
	}

	@Test
	public void financingShouldNotCreatedWhenNotValidData() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			@SuppressWarnings("unused")
			Financing enitity = new Financing(100000.0, 2000.0, 20);
		});
	}

	@Test
	public void amountShoudUpdateWhenValidData() {
		Double totalAmount = 150000.0;
		Financing entity = FinancingFactory.createValidFinancing(100000.0, 5000.0, 90);
		entity.setTotalAmount(totalAmount);
		Assertions.assertEquals(totalAmount, entity.getTotalAmount());
	}

	@Test
	public void amountShouldNotUpdateWhenNotValidData() {
		Double totalAmount = 180000.0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing enitity = new Financing(100000.0, 3200.0, 80);
			enitity.setTotalAmount(totalAmount);
		});
	}

	@Test
	public void incomeShouldUpdateWhenValidData() {
		Double totalIncome = 5500.0;
		Financing entity = FinancingFactory.createValidFinancing(150000.0, 5000.0, 90);
		entity.setIncome(totalIncome);
	}

	@Test
	public void incomeShouldNotUpdateWhenNotValidData() {
		Double totalIncome = 1000.0;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing entity = FinancingFactory.createValidFinancing(80000.0, 4500.0, 90);
			entity.setIncome(totalIncome);
		});
	}

	@Test
	public void monthsShouldUpdateWhenValidData() {
		Integer totalMonths = 91;
		Financing entity = FinancingFactory.createValidFinancing(80000.0, 3500.0, 50);
		entity.setMonths(totalMonths);
	}

	@Test
	public void monthsShouldNotUpdateWhenNotValidData() {
		Integer totalMonths = 10;
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Financing entity = FinancingFactory.createValidFinancing(80000.0, 3500.0, 50);
			entity.setMonths(totalMonths);
		});
	}
	
	@Test
	public void entryShouldCalculatedCorrectly() {
		Double totalEntry = 10000.0;
		Financing entity = FinancingFactory.createValidFinancing(50000.0, 3500.0, 50);
		Assertions.assertEquals(totalEntry, entity.entry());
	}
	
	@Test
	public void quotaShouldCalculatedCorrectly() {
		Double totalQuota = 800.0;
		Financing entity = FinancingFactory.createValidFinancing(50000.0, 3500.0, 50);
		Assertions.assertEquals(totalQuota, entity.quota());
	}
}