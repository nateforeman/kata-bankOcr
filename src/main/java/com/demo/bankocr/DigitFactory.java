package com.demo.bankocr;

import java.util.List;

import com.google.common.collect.Lists;

public class DigitFactory {

	public List<Digit> makeDigitsFor(Iterable<String> patterns) {
		List<Digit> result = Lists.newArrayList();
		for (String pattern : patterns) {
			result.add(makeDigitFor(pattern));
		}
		return result;
	}
	
	public Digit makeDigitFor(String pattern) {
		Digit found = findMatchingWellKnownDigit(pattern);
		if (null != found) {
			return found;
		}
		else {
			return new Digit(pattern);
		}
	}

	private Digit findMatchingWellKnownDigit(String pattern) {
		Digit found = null;
		for (Digit curDigit : Digits.ALL_DIGITS) {
			if (curDigit.isMatch(pattern)) {
				found = curDigit;
			}
		}
		return found;
	}

}
