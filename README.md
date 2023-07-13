==ValueAtRiskCalculator==


== Description and contents ==


Contains functionality to calculate historical value at risk (VAR) for a single trade, and a portfolio.

User edits/creates a List<Double> object containing the historical percentage returns on a trade, in time-order, written as a decimal. 


User edits/creates a Trade object containing the above List and a weight 
- the weight is the percentage value of the trade, relative to the portfolio value
- the weight is only needed for a portfolio


User specifies a desired confidence level, expressed as a decimal. 


User specifies the value of the trade/ portfolio.

Outputs the VAR for a single trade/ VAR at portfolio level.
-  output is displayed as a positive value for convenience. 

== How to use ==

Clone the project from git.
Import maven project in IDE (See online guide).
In Runner.java file, adapt historical returns and Trades as necessary. Hit run to obtain calculations.
