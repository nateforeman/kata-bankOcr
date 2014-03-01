package com.demo.bankocr;

import java.util.List;

import com.google.common.collect.ImmutableList;

public class AccountNumber {
	
	private final List<Digit> digits;
	
	public AccountNumber(Iterable<Digit> digits) {
		this.digits = ImmutableList.copyOf(digits);
	}
	
	public String getStringValue() {
		String result = "";
		for (Digit digit : digits) {
			result += digit.getStringValue();
		}
		return result;
	}

	public boolean hasIllegalDigits() {
		boolean result = false;
		for (Digit digit : digits) {
			if (!digit.isLegal()) {
				result = true;
			}
		}
		return result;
	}

	public int getCheckSum() {
		return hasIllegalDigits() ? -1 : doCalculateCheckSum();
	}
	
	public boolean isValid() {
		return getCheckSum() % 11 == 0;
	}

	private int doCalculateCheckSum() {
		int checksum = 0;
		int scalar = 1;
		int index = digits.size()-1;
		for (; index>=0; --index, ++scalar) {
			checksum += scalar * digits.get(index).getIntValue();
		}
		return checksum;
	}

}
