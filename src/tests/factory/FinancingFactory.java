package tests.factory;

import aula_junit.entities.Financing;

public class FinancingFactory {

	public static Financing createValidFinancing(Double totalAmount, Double income, Integer months) {
		return new Financing(totalAmount, income, months);
	}
}