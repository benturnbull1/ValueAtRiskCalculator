package calculator;

import java.util.List;

public class Trade {

	// Attributes
	private List<Double> returns;
	private double weight;

	/**
	 * 
	 * @param returns         List of historical returns (percentage change), in
	 *                        time-order, written as a decimal
	 *                        
	 * @param weight          The percentage value of the trade relative to
	 *                        portfolio value
	 */

	//Constructor for a single trade
	public Trade(List<Double> returns) {
		this.returns = returns;
	}

	// Constructor for a trade in a portfolio
	public Trade(List<Double> returns, double weight) {
		this.returns = returns;
		this.weight = weight;
	}

	public List<Double> getReturns() {
		return returns;
	}

	public void setReturns(List<Double> returns) {
		this.returns = returns;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
