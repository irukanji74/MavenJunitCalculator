package servlet;

import java.util.logging.Logger;

import utility.Calculations;
import utility.DigitsPointOperators;

public class ExpressionHolder2 {

	Logger LOGGER = Logger.getLogger(getClass().getSimpleName());
	private StringBuilder firstNum = new StringBuilder();
	private StringBuilder secondNum = new StringBuilder();

	public String getExpression() {
		return firstNum.toString() + secondNum.toString();
	}

	public void setExpression(String symbol) {
		if ((firstNum.length() == 0 || (!Calculations.isMatchOperator(firstNum
				.substring(firstNum.length() - 1, firstNum.length()))))
				&& (!Calculations.isMatchOperator(symbol))) {
			firstNum.append(symbol);
			if (Calculations.isMatchDigit(firstNum.toString())) {
				return;
			} else {
				firstNum.delete(firstNum.length() - 1, firstNum.length());
			}
		}
		if (firstNum.length() != 0
				&& Calculations.isMatchOperator(firstNum.substring(
						firstNum.length() - 1, firstNum.length()))
				&& (!Calculations.isMatchOperator(symbol))) {
			secondNum.append(symbol);
			if (Calculations.isMatchDigit(secondNum.toString())) {
				return;
			} else {
				secondNum.delete(secondNum.length() - 1, secondNum.length());
			}
		}
		if ((Calculations.isMatchOperator(symbol) && secondNum.length() == 0)
				&& Calculations.isMatchNumber(firstNum.toString())) {
			firstNum.append(symbol);
			return;
		}
		if (Calculations.isMatchOperator(symbol)
				&& Calculations.isMatchNumber(secondNum.toString())
				&& Calculations.isMatchOperator(firstNum.substring(
						firstNum.length() - 1, firstNum.length()))) {
			String result = Calculations.calculateResult(firstNum, secondNum);
			if (symbol.equals(DigitsPointOperators.Equal.symbol())) {
				secondNum.append(symbol).append(result);
				return;
			}
			secondNum.delete(0, secondNum.length());
			firstNum.delete(0, firstNum.length());
			firstNum.append(result).append(symbol);
		}

		if (symbol.equals(DigitsPointOperators.Clear.symbol())) {
			if (secondNum.length() != 0) {
				secondNum.delete(0, secondNum.length());
			}
			if (firstNum.length() != 0) {
				firstNum.delete(0, firstNum.length());
			}
		}
	}

	public StringBuilder getFirstNum() {
		return firstNum;
	}

	public StringBuilder getSecondNum() {
		return secondNum;
	}

}
