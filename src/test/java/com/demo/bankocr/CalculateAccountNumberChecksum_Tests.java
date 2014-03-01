package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CalculateAccountNumberChecksum_Tests {
AccountNumberFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new AccountNumberFactory(new PatternFactory(), new DigitFactory());
	}
	
	@Test
	public void goodChecksum_case1() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _    ",
				"| || || || || || || ||_   |",
				"|_||_||_||_||_||_||_| _|  |");
		assertThat(target.getStringValue(), is("000000051"));
		assertThat(target.hasIllegalDigits(), is(false));
		assertThat(target.getCheckSum(), is(11));
		assertThat(target.isValid(), is(true));
	}
	
	@Test
	public void goodChecksum_case2() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _  _  _  _  _  _  _ ",
				"|_||_   ||_ | ||_|| || || |",
				"  | _|  | _||_||_||_||_||_|");
		assertThat(target.getStringValue(), is("457508000"));
		assertThat(target.hasIllegalDigits(), is(false));
		assertThat(target.getCheckSum(), is(187));
		assertThat(target.isValid(), is(true));
	}
	
	@Test
	public void goodChecksum_case3() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"| || || || || || || || || |",
				"|_||_||_||_||_||_||_||_||_|");
		assertThat(target.getStringValue(), is("000000000"));
		assertThat(target.hasIllegalDigits(), is(false));
		assertThat(target.getCheckSum(), is(0));
		assertThat(target.isValid(), is(true));
	}
	
	@Test
	public void badChecksum_case1() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"                           ",
				"  |  |  |  |  |  |  |  |  |",
				"  |  |  |  |  |  |  |  |  |");
		assertThat(target.getStringValue(), is("111111111"));
		assertThat(target.hasIllegalDigits(), is(false));
		assertThat(target.getCheckSum(), is(45));
		assertThat(target.isValid(), is(false));
	}
	
	@Test
	public void badChecksum_case2() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _     _ ",
				"|_ |_|| ||_||_   |  |  ||_ ",
				" _| _||_||_||_|  |  |  | _|");
		assertThat(target.getStringValue(), is("590867715"));
		assertThat(target.hasIllegalDigits(), is(false));
		assertThat(target.getCheckSum(), is(251));
		assertThat(target.isValid(), is(false));
	}
	
	@Test
	public void checksumForAccountNumberWithIllegalDigits_IsNegative1() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_| _ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _ ");
		assertThat(target.hasIllegalDigits(), is(true));
		assertThat(target.getCheckSum(), is(-1));
		assertThat(target.isValid(), is(false));
	}
	
}
