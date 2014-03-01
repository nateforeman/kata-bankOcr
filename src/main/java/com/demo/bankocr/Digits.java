package com.demo.bankocr;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class Digits {

	public static final Digit DIGIT_0 = new Digit(Patterns.PATTERN_0, 0);
	public static final Digit DIGIT_1 = new Digit(Patterns.PATTERN_1, 1);
	public static final Digit DIGIT_2 = new Digit(Patterns.PATTERN_2, 2);
	public static final Digit DIGIT_3 = new Digit(Patterns.PATTERN_3, 3);
	public static final Digit DIGIT_4 = new Digit(Patterns.PATTERN_4, 4);
	public static final Digit DIGIT_5 = new Digit(Patterns.PATTERN_5, 5);
	public static final Digit DIGIT_6 = new Digit(Patterns.PATTERN_6, 6);
	public static final Digit DIGIT_7 = new Digit(Patterns.PATTERN_7, 7);
	public static final Digit DIGIT_8 = new Digit(Patterns.PATTERN_8, 8);
	public static final Digit DIGIT_9 = new Digit(Patterns.PATTERN_9, 9);
	
	public static final Set<Digit> ALL_DIGITS = 
			ImmutableSet.of(
					DIGIT_0, DIGIT_1, DIGIT_2, DIGIT_3, DIGIT_4, 
					DIGIT_5, DIGIT_6, DIGIT_7, DIGIT_8, DIGIT_9);

}
