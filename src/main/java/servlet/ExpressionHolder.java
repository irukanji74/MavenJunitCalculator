package servlet;

import utility.Calculations;
import utility.DigitsPointOperators;

public class ExpressionHolder {

	// private static final Logger LOGGER =
	// Logger.getLogger(ExpressionHolder.getClass().getSimpleName());
	private StringBuilder expression = new StringBuilder();
	private StringBuilder firstNum = new StringBuilder();
	private StringBuilder secondNum = new StringBuilder();
	private String operator = null;

	public StringBuilder getExpression() {
		return expression;
	}

	public void setExpression(String symbol) {
		if (firstNum.length() == 0) {
			expression.append(symbol);
			if (Calculations.isMatchDigit(expression.toString())) {
				return;
			} else {
				expression.delete(expression.length() - 1, expression.length());
			}

		} else {
			secondNum.append(symbol);
			if (Calculations.isMatchDigit(secondNum.toString())) {
				expression.append(symbol);
			} else {
				secondNum.delete(secondNum.length() - 1, secondNum.length());
			}
		}

		if (Calculations.isMatchOperator(symbol)) {

			if (Calculations.isMatchNumber(expression.toString())
					&& firstNum.length() == 0) {
				firstNum.append(expression);
				operator = symbol;
				expression.append(operator);

			} else if (Calculations.isMatchNumber(secondNum.toString())) {

				String result = Calculations.calculateResult(getFirstNum(), getSecondNum());
				if (result.equals(DigitsPointOperators.Zerodiv.symbol())) {
					expression.delete(0, expression.length()).append(
							DigitsPointOperators.Zerodiv.symbol());
					firstNum.delete(0, firstNum.length());
					secondNum.delete(0, secondNum.length());
					return;
				}
				if (symbol.equals(DigitsPointOperators.Equal.symbol())) {
					expression.append(DigitsPointOperators.Equal.symbol())
							.append(result);
					return;
				}
				operator = symbol;
				firstNum.delete(0, firstNum.length());
				firstNum.append(result);
				expression.delete(0, expression.length());
				expression.append(result).append(symbol);
				secondNum.delete(0, secondNum.length());
			}
		}

		if (symbol.equals(DigitsPointOperators.Clear.symbol())) {
			getFirstNum().delete(0, firstNum.length());
			getSecondNum().delete(0, secondNum.length());
			getExpression().delete(0, expression.length());
			operator = null;
		}

	}

	public StringBuilder getFirstNum() {
		return firstNum;
	}


	public StringBuilder getSecondNum() {
		return secondNum;
	}


}
