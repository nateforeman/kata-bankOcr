package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MakeDigitFor_UnknownPattern_Tests {
	
	protected DigitFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new DigitFactory();
	}
		
	private void verifyDigitMadeFromUnknownPattern(String pattern) {
		Digit digit = factory.makeDigitFor(pattern);
		assertThat(digit, notNullValue());
		assertThat(digit.getPattern(), is(pattern));
		assertThat(digit.getIntValue(), is(-1));
		assertThat(digit.getStringValue(), is("?"));
		assertThat(digit.isLegal(), is(false));
	}
	
	@Test
	public void unknownPattern_1() throws Exception {
		String pattern = UnknownPatternsForTesting.UNKNOWN_PATTERN_1;
		verifyDigitMadeFromUnknownPattern(pattern);
	}
	
	@Test
	public void unknownPattern_2() throws Exception {
		String pattern = UnknownPatternsForTesting.UNKNOWN_PATTERN_2;
		verifyDigitMadeFromUnknownPattern(pattern);
	}
	
	@Test
	public void unknownPattern_3() throws Exception {
		String pattern = UnknownPatternsForTesting.UNKNOWN_PATTERN_3;
		verifyDigitMadeFromUnknownPattern(pattern);
	}
}
