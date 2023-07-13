package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class VarCalculatorTests {
	
	private VarCalculator calculator = new VarCalculator();
	
	static final double confidenceLevel = 0.99;
	static final double investment = 500_000;
	
	List<Double> returns1 = Arrays.asList(0.11, 0.03, -0.06, 0.05, -0.07, 0.03);
	List<Double> returns2 = Arrays.asList(0.04, 0.07, 0.09, -0.01, -0.05, 0.03);
	Trade trade1 = new Trade(returns1, 0.8);
	Trade trade2 = new Trade(returns2, 0.2);
	List<Trade> portfolio = new ArrayList<>();
		
	@Test
	void test_ValueAtRiskForSingleTrade_ReturnsCorrectValue() {
		double var = calculator.valueAtRiskForSingleTrade(trade1, confidenceLevel, investment);
		double expectedValue = 35_000;
		assertEquals(expectedValue, var);
	}
	
	@Test
	void test_ValueAtRiskForPortfolio_ReturnsCorrectValue() {
		
		portfolio.add(trade1);
		portfolio.add(trade2);
		
		double var = calculator.valueAtRiskForPortfolio(portfolio, confidenceLevel, investment);
		double expectedValue = 33_000;
		assertEquals(expectedValue, var);
	}
}
