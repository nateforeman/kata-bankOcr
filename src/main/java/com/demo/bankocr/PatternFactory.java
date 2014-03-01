package com.demo.bankocr;

import java.util.List;

import com.google.common.collect.Lists;

public class PatternFactory {
	
	public static final int PATTERN_WIDTH = 3;
	
	public List<String> makePatternsFrom(String... lines) {
		List<String> result = Lists.newArrayList();
		List<String> sourceLines = Lists.newArrayList(lines);
		for (int i=0; i<calculatePatternCount(sourceLines); ++i) {
			result.add(getPatternAtIndex(i, sourceLines));
		}
		return result;
	}
	
	private int calculatePatternCount(List<String> sourceLines) {
		int minLineLength = Integer.MAX_VALUE;
		for (String line : sourceLines) {
			minLineLength = Math.min(minLineLength, line.length());
		}
		return minLineLength / PATTERN_WIDTH;
	}

	private String getPatternAtIndex(int i, List<String> sourceLines) {
		int beginIndex = i * PATTERN_WIDTH;
		int endIndex = beginIndex + PATTERN_WIDTH;
		StringBuilder builder = new StringBuilder();
		for (String line : sourceLines) {
			builder.append(line.substring(beginIndex, endIndex));
		}
		return builder.toString();
	}
}
