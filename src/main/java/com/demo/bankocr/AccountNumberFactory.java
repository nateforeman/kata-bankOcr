package com.demo.bankocr;

public class AccountNumberFactory {
	private final PatternFactory patternFactory;
	private final DigitFactory digitFactory;
	
	public AccountNumberFactory(
			PatternFactory patternFactory,
			DigitFactory digitFactory) {
		this.patternFactory = patternFactory;
		this.digitFactory = digitFactory;
	}
	
	public PatternFactory getPatternFactory() {
		return patternFactory;
	}
	
	public DigitFactory getDigitFactory() {
		return digitFactory;
	}
	
	public AccountNumber makeAccountNumberFrom(String... lines) {
		return new AccountNumber(getDigitFactory().makeDigitsFor(getPatternFactory()
				.makePatternsFrom(lines)));
	}
}
