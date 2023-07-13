package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
	public static void main(String[] args) {

		VarCalculator varCalc = new VarCalculator();
	
		//NOTE: all Trades must follow the same time step, if a step is missed, a user would need to insert 0.0.
		
		List<Double> returns1 = Arrays.asList(0.02, -0.03, 0.01, 0.04, 0.01, -0.05);
		List<Double> returns2 = Arrays.asList(0.04, 0.07, 0.09, -0.01, -0.05, 0.03);
		List<Double> returns3 = Arrays.asList(0.02, 0.08, 0.06, -0.03, -0.03, -0.09);

		
		Trade trade1 = new Trade(returns1, 0.4);
		Trade trade2 = new Trade(returns2, 0.25);
		Trade trade3 = new Trade(returns3, 0.35);
			
		
		List<Trade> portfolio = new ArrayList<>();
		portfolio.add(trade1);
		portfolio.add(trade2);
		portfolio.add(trade3);
		
		
		
		double VaRForASingleTrade = varCalc.valueAtRiskForSingleTrade(trade1, 0.95, 100_000);
		System.out.println("The Value at Risk is $" + VaRForASingleTrade + ".");
			

		double VaRForPortfolio = varCalc.valueAtRiskForPortfolio(portfolio, 0.95, 1_000_000);
		System.out.println("The Value at Risk is  $" + VaRForPortfolio + ".");
	}
}
