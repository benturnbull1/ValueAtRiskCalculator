package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VarCalculator {

	public double valueAtRiskForSingleTrade(Trade trade, double confidenceLevel, double purchaseValue) {

		List<Double> returns = new ArrayList<>(trade.getReturns());
		
		Collections.sort(returns);
		
		double returnIndex = Math.ceil((1 - confidenceLevel) * returns.size());

		double valueAtRisk = returns.get((int) returnIndex - 1) * purchaseValue;

		double roundedValueAtRisk = Math.round((valueAtRisk * 100) / 100);
		
		//Output multiplied by -1* to return a positive value at risk
		return -1*roundedValueAtRisk;
	}

	public double valueAtRiskForPortfolio(List<Trade> trades, double confidenceLevel, double investment) {
		
		int numberOfTimeSteps = trades.get(0).getReturns().size();
		
		double[] weightedReturns = new double[numberOfTimeSteps];
		
		for (Trade trade : trades) {
			for(int i=0; i<numberOfTimeSteps; i++) {
				weightedReturns[i] += trade.getReturns().get(i)*trade.getWeight();
			}
		}
		
		Arrays.sort(weightedReturns);

		double returnIndex = Math.ceil((1 - confidenceLevel) * numberOfTimeSteps);
		
		double valueAtRisk = weightedReturns[(int) returnIndex-1] * investment;
		
		double roundedValueAtRisk = Math.round((valueAtRisk * 100) / 100);
		
		//Output multiplied by -1* to return a positive value at risk
		return -1*roundedValueAtRisk;
	}

}
