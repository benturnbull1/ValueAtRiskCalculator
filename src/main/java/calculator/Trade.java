package calculator;

import java.util.List;

public class Trade {
	
	//Attributes
	private List<Double> returns;
	private double weight;
	
	//Constructor
	public Trade(List<Double> returns, double weight) {
		this.returns = returns;
		this.weight = weight;
	}
	
	//Getters and Setters
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
