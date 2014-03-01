package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MakeDigitFor_WellKnownPattern_Tests {

	protected DigitFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new DigitFactory();
	}
	
	@Test
	public void pattern0() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_0),
				sameInstance(Digits.DIGIT_0));
	}
	
	@Test
	public void pattern1() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_1),
				sameInstance(Digits.DIGIT_1));
	}
	
	@Test
	public void pattern2() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_2),
				sameInstance(Digits.DIGIT_2));
	}
	
	@Test
	public void pattern3() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_3),
				sameInstance(Digits.DIGIT_3));
	}
	
	@Test
	public void pattern4() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_4),
				sameInstance(Digits.DIGIT_4));
	}
	
	@Test
	public void pattern5() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_5),
				sameInstance(Digits.DIGIT_5));
	}
	
	@Test
	public void pattern6() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_6),
				sameInstance(Digits.DIGIT_6));
	}
	
	@Test
	public void pattern7() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_7),
				sameInstance(Digits.DIGIT_7));
	}
	
	@Test
	public void pattern8() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_8),
				sameInstance(Digits.DIGIT_8));
	}
	
	@Test
	public void pattern9() throws Exception {
		assertThat(
				factory.makeDigitFor(Patterns.PATTERN_9),
				sameInstance(Digits.DIGIT_9));
	}
}
