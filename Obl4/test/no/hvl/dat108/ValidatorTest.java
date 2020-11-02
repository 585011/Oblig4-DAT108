package no.hvl.dat108;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void validFirstnamesOk() {
		assertTrue(Validator.isValidFirstname("Ole"));
		assertTrue(Validator.isValidFirstname("Ole-Martin"));
		assertTrue(Validator.isValidFirstname("Jens Kristian"));
	}
	
	@Test
	public void validLastnamesOk() {
		assertTrue(Validator.isValidLastname("Olsen"));
		assertTrue(Validator.isValidLastname("Olsen-Olsen"));
		assertTrue(Validator.isValidLastname("Åge-Øyær"));
	}

	@Test
	public void norwegianLettersAllowed() {
		assertTrue(Validator.isValidFirstname("ÆØÅæøå"));
		assertTrue(Validator.isValidLastname("ÆØÅæøå"));
	}
	
	@Test
	public void shortFirstnamesNotOk() {
		assertFalse(Validator.isValidFirstname(""));
		assertFalse(Validator.isValidFirstname("A"));
		assertFalse(Validator.isValidFirstname(null));
		assertFalse(Validator.isValidFirstname("martin"));
		assertFalse(Validator.isValidFirstname("1Martin"));
	}
	
	@Test
	public void notOkLastnames() {
		assertFalse(Validator.isValidLastname(""));
		assertFalse(Validator.isValidLastname("A"));
		assertFalse(Validator.isValidLastname(null));
		assertFalse(Validator.isValidLastname("Olsen Ols"));
		assertFalse(Validator.isValidLastname("olsen"));
		assertFalse(Validator.isValidLastname("5olsen"));
	}
	
	@Test
	public void validMobileOk() {
		assertTrue(Validator.isValidMobil("12345678"));
		assertFalse(Validator.isValidMobil("1b3f567a"));
	}
	
	@Test
	public void validMinLengthPass() {
		assertTrue(Validator.passordMinlengde("pass"));
		assertTrue(Validator.passordMinlengde("1234"));
		assertFalse(Validator.passordMinlengde("123"));
		assertFalse(Validator.passordMinlengde(""));
		assertFalse(Validator.passordMinlengde(null));
	}
	
	@Test
	public void samePasswordTest() {
		assertTrue(Validator.liktPassord("Pass", "Pass"));
		assertTrue(Validator.liktPassord("12345", "12345"));
		assertFalse(Validator.liktPassord("Pass", "Pass1"));
		
	}
}
