package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testEmptyString() {
    	try {
		assertEquals(0, Calculator.add(""));
		}catch(Exception e){}
	}

	@Test
	public void testOneNumber() {
		try {
		assertEquals(1, Calculator.add("1"));
		}catch(Exception e){}
	}

	@Test
	public void testTwoNumbers() {
		try {
		assertEquals(3, Calculator.add("1,2"));
		}catch(Exception e){}
	}

	@Test
    public void testMultipleNumbers(){
    	try {
    	assertEquals(6, Calculator.add("1,2,3"));
    	}catch(Exception e){}
    }

    @Test
    public void testNewLine(){
    	try {
    	assertEquals(6, Calculator.add("1\n2\n3"));
    	}catch(Exception e){}
    }

    @Test
    public void testNegativeNumbers(){
    	try {
    		assertEquals("Negatives not allowed: -1", Calculator.add("1,-2"));
    		throw new Exception( "Should have thrown an exception" );
    	}
    	catch (Exception e) {
    		String expectedMessage = "Negatives not allowed: -2";
    		assertEquals( "Exception message must be correct", expectedMessage, e.getMessage() );
		}   
    }

    @Test
    public void testIgnoreLargeNumbers(){
    	try {
    	assertEquals(2, Calculator.add("1001,2"));
    	}catch(Exception e){}
    }


}