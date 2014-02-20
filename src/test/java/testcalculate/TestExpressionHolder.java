package testcalculate;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import servlet.ExpressionHolder2;
import utility.Calculations;

public class TestExpressionHolder extends Assert {
	ExpressionHolder2 expHolder;
	String realFirst;
	String realSecond;
	String realExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		expHolder = new ExpressionHolder2();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFirstNum() {
		expHolder.setExpression("0");
		expHolder.setExpression(".");
		expHolder.setExpression(".");
		expHolder.setExpression("+");
		String expectedFirst = "0.";
		realFirst = expHolder.getFirstNum().toString();
		assertEquals("Error1", expectedFirst, realFirst);
	}

	@Test
	public void testSecondNum() {
		expHolder.setExpression("0.2");
		expHolder.setExpression(".");
		expHolder.setExpression(".");
		expHolder.setExpression("+");
		expHolder.setExpression("-");
		expHolder.setExpression("66");
		String expectedSecond = "66";
		realSecond = expHolder.getSecondNum().toString();
		assertEquals("Error2", realSecond, expectedSecond);
	}

	@Test
	public void testGetExpression() {
		expHolder.setExpression("0");
		expHolder.setExpression("6");
		expHolder.setExpression(".");
		expHolder.setExpression(".");
		expHolder.setExpression("+");
		expHolder.setExpression("2");
		expHolder.setExpression("+");
		expHolder.setExpression("/");
		expHolder.setExpression("0.2");
		expHolder.setExpression("+");
		String expectedExpression = "0.4+";
		realExpression = expHolder.getExpression().toString();
		assertEquals("ERROR3", realExpression, expectedExpression);
	}

	@Test
	public void teatCalculateResult(){
	
		StringBuilder firstSb = new StringBuilder();
		StringBuilder secondSb = new StringBuilder();
		firstSb.append("22.5+");
		secondSb.append("3.3");
		String expectedResult = Calculations.calculateResult(firstSb, secondSb);
		
		expHolder.setExpression("2");
		expHolder.setExpression("2");
		expHolder.setExpression(".");
		expHolder.setExpression(".");
		expHolder.setExpression("5");
		expHolder.setExpression("+");
		expHolder.setExpression("-");
		expHolder.setExpression("3");
		expHolder.setExpression(".");
		expHolder.setExpression(".");
		expHolder.setExpression("3");
		expHolder.setExpression("+");
		realExpression = expHolder.getExpression().toString();
		String realResult = realExpression.substring(0, realExpression.length()-1);
		
		assertEquals("Error Calc", realResult, expectedResult);
	}
}
