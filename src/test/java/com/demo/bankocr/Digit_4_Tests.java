package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class Digit_4_Tests {
	
	private Digit target;
	
	@Before
	public void setUp() throws Exception {
		target = Digits.DIGIT_4;
	}
	
	@Test
	public void hasCorrect_Pattern() throws Exception {
		assertThat(target.getPattern(), is(Patterns.PATTERN_4));
	}
	
	@Test
	public void hasCorrect_IntValue() throws Exception {
		assertThat(target.getIntValue(), is(4));
	}
	
	@Test
	public void hasCorrect_StringValue() throws Exception {
		assertThat(target.getStringValue(), is("4"));
	}
	
	@Test
	public void isLegal() throws Exception {
		assertThat(target.isLegal(), is(true));
	}
	
	@Test
	public void matchesPattern0() throws Exception {
		assertThat(target.isMatch(Patterns.PATTERN_4), is(true));
	}
	
	@Test
	public void doesntMatchAnyOtherWellKnownPatterns() throws Exception {
		assertThat(target.isMatch(Patterns.PATTERN_0), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_1), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_2), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_3), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_5), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_6), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_7), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_8), is(false));
		assertThat(target.isMatch(Patterns.PATTERN_9), is(false));
	}
	
	@Test
	public void doesntMatchAnyIllegalPatterns() throws Exception {
		assertThat(target.isMatch(UnknownPatternsForTesting.UNKNOWN_PATTERN_1), is(false));
		assertThat(target.isMatch(UnknownPatternsForTesting.UNKNOWN_PATTERN_2), is(false));
		assertThat(target.isMatch(UnknownPatternsForTesting.UNKNOWN_PATTERN_3), is(false));
	}
	
}
