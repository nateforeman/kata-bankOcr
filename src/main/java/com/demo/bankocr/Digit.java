package com.demo.bankocr;

public class Digit {
	
	private final String pattern;
	private final int intValue;
	
	public Digit(String pattern, int intValue) {
		this.pattern = pattern;
		this.intValue = intValue;
	}

	public Digit(String pattern) {
		this(pattern, -1);
	}

	public String getPattern() {
		return pattern;
	}

	public int getIntValue() {
		return intValue;
	}

	public String getStringValue() {
		return isLegal() ?
				String.valueOf(getIntValue()) :
				"?";
	}
	
	public boolean isLegal() {
		return getIntValue() != -1;
	}

	public boolean isMatch(String pattern) {
		return 0 == getPattern().compareTo(pattern);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + intValue;
		result = prime * result + ((pattern == null) ? 0 : pattern.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Digit other = (Digit) obj;
		if (intValue != other.intValue)
			return false;
		if (pattern == null) {
			if (other.pattern != null)
				return false;
		} else if (!pattern.equals(other.pattern))
			return false;
		return true;
	}

}
