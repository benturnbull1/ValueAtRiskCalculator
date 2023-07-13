package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
	public static void main(String[] args) {

		VarCalculator varCalc = new VarCalculator();
		
		
		//The historical returns on a trade is written as a decimal (representing percentage change), in time order. 	
		//NOTE: All Trades must follow the same time series, if a step is missed, a user would need to insert 0.0.
		
		List<Double> returns1 = Arrays.asList(0.02, -0.03, 0.01, 0.04, 0.01, -0.05);
		List<Double> returns2 = Arrays.asList(0.04, 0.07, 0.09, -0.01, -0.05, 0.03);
		List<Double> returns3 = Arrays.asList(0.02, 0.08, 0.06, -0.03, -0.03, -0.09);

		//A trade is comprised of a historical returns list, and a weight. The weight is only used if the trade is a member of a portfolio.
		Trade trade1 = new Trade(returns1);
		Trade trade2 = new Trade(returns2, 0.25);
		Trade trade3 = new Trade(returns3, 0.35);
			
		//A portfolio stores Trades in a list
		List<Trade> portfolio = new ArrayList<>();
		portfolio.add(trade1);
		portfolio.add(trade2);
		portfolio.add(trade3);
		
			
		double VaRForASingleTrade = varCalc.valueAtRiskForSingleTrade(trade1, 0.95, 400_000);
		System.out.println("The Value at Risk is $" + VaRForASingleTrade + ".");
		
		//Setting weight after single trade to demonstrate that it is not needed for a single trade.
		trade1.setWeight(0.4);
		
		double VaRForPortfolio = varCalc.valueAtRiskForPortfolio(portfolio, 0.95, 1_000_000);
		System.out.println("The Value at Risk is $" + VaRForPortfolio + ".");
	}
}
