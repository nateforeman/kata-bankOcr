package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class MakeDigitsFor_ListOfPatterns {

	static final List<String> PATTERNS = ImmutableList.of(
			Patterns.PATTERN_0,
			UnknownPatternsForTesting.UNKNOWN_PATTERN_2,
			Patterns.PATTERN_9);
	
	static final List<Digit> EXPECTED_DIGITS = ImmutableList.of(
			Digits.DIGIT_0,
			new Digit(UnknownPatternsForTesting.UNKNOWN_PATTERN_2),
			Digits.DIGIT_9);
	
	DigitFactory factory;
	List<Digit> actualDigitList;

	@Before
	public void setUp() throws Exception {
		factory = new DigitFactory();
		actualDigitList = factory.makeDigitsFor(PATTERNS);
	}
	
	@Test
	public void createdCorrectDigitList() throws Exception {
		assertThat(actualDigitList, is(EXPECTED_DIGITS));
	}
	
}
