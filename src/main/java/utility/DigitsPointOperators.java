package utility;

public enum DigitsPointOperators {
	Minus("-"), Plus("+"), Divide("/"), Mul("*"), Clear("C"), Equal("="), Negate(
			"~"), Remove("<-"), Point("."), One("1"), Two("2"), Three("3"), Four(
			"4"), Five("5"), Six("6"), Seven("7"), Eight("8"), Nine("9"), Zero(
			"0"), Zerodiv("Can not divide by 0");

	private String symbol;

	private DigitsPointOperators(String symbol) {
		this.symbol = symbol;
	}

	public String symbol() {
		return symbol;
	}
}
