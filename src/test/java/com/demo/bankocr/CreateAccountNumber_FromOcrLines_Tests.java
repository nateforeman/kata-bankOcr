package com.demo.bankocr;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CreateAccountNumber_FromOcrLines_Tests {

	AccountNumberFactory factory;
	
	@Before
	public void setUp() throws Exception {
		factory = new AccountNumberFactory(new PatternFactory(), new DigitFactory());
	}
	
	@Test
	public void all_0s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"| || || || || || || || || |",
				"|_||_||_||_||_||_||_||_||_|");
		assertThat(target.getStringValue(), is("000000000"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_1s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"                           ",
				"  |  |  |  |  |  |  |  |  |",
				"  |  |  |  |  |  |  |  |  |");
		assertThat(target.getStringValue(), is("111111111"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_2s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				" _| _| _| _| _| _| _| _| _|",
				"|_ |_ |_ |_ |_ |_ |_ |_ |_ ");
		assertThat(target.getStringValue(), is("222222222"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_3s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				" _| _| _| _| _| _| _| _| _|",
				" _| _| _| _| _| _| _| _| _|");
		assertThat(target.getStringValue(), is("333333333"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_4s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"                           ",
				"|_||_||_||_||_||_||_||_||_|",
				"  |  |  |  |  |  |  |  |  |");
		assertThat(target.getStringValue(), is("444444444"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_5s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
				" _| _| _| _| _| _| _| _| _|");
		assertThat(target.getStringValue(), is("555555555"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_6s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
				"|_||_||_||_||_||_||_||_||_|");
		assertThat(target.getStringValue(), is("666666666"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_7s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"  |  |  |  |  |  |  |  |  |",
				"  |  |  |  |  |  |  |  |  |");
		assertThat(target.getStringValue(), is("777777777"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_8s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"|_||_||_||_||_||_||_||_||_|",
				"|_||_||_||_||_||_||_||_||_|");
		assertThat(target.getStringValue(), is("888888888"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_9s() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				" _  _  _  _  _  _  _  _  _ ",
				"|_||_||_||_||_||_||_||_||_|",
				" _| _| _| _| _| _| _| _| _|");
		assertThat(target.getStringValue(), is("999999999"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void all_digits() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_||_ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _|");
		assertThat(target.getStringValue(), is("123456789"));
		assertThat(target.hasIllegalDigits(), is(false));
	}
	
	@Test
	public void oneIllegalDigit() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _  _  _  _  _     _ ",
				"|_||_|| || ||_   |  |  | _ ",
				"  | _||_||_||_|  |  |  | _|");
		assertThat(target.getStringValue(), is("49006771?"));
		assertThat(target.hasIllegalDigits(), is(true));
	}
	
	@Test
	public void someIllegalDigits() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _     _  _  _  _  _ ",
				"  | _| _||_| _ |_   ||_||_|",
				"  ||_  _|  | _||_|  ||_| _ ");
		assertThat(target.getStringValue(), is("1234?678?"));
		assertThat(target.hasIllegalDigits(), is(true));
	}
	
	@Test
	public void allIllegalDigits() throws Exception {
		AccountNumber target = factory.makeAccountNumberFrom(
				"    _  _     _  _  _  _  _ ",
				"  |  | _  _| _ |      _||_|",
				"   |_  _|  | _||_|  | _  _ ");
		assertThat(target.getStringValue(), is("?????????"));
		assertThat(target.hasIllegalDigits(), is(true));
	}
}
