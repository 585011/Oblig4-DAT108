package no.hvl.dat108;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {

	@Test
	public void validFirstnamesOk() {
		assertTrue(Deltagerliste.isValidFirstname("Ole"));
		assertTrue(Deltagerliste.isValidFirstname("Ole-Martin"));
		assertTrue(Deltagerliste.isValidFirstname("Jens Kristian"));
	}
	
	@Test
	public void validLastnamesOk() {
		assertTrue(Deltagerliste.isValidLastname("Olsen"));
		assertTrue(Deltagerliste.isValidLastname("Olsen-Olsen"));
		assertTrue(Deltagerliste.isValidLastname("Åge-Øyær"));
	}

	@Test
	public void norwegianLettersAllowed() {
		assertTrue(Deltagerliste.isValidFirstname("ÆØÅæøå"));
		assertTrue(Deltagerliste.isValidLastname("ÆØÅæøå"));
	}
	
	@Test
	public void shortFirstnamesNotOk() {
		assertFalse(Deltagerliste.isValidFirstname(""));
		assertFalse(Deltagerliste.isValidFirstname("A"));
		assertFalse(Deltagerliste.isValidFirstname(null));
		assertFalse(Deltagerliste.isValidFirstname("martin"));
		assertFalse(Deltagerliste.isValidFirstname("1Martin"));
	}
	
	@Test
	public void notOkLastnames() {
		assertFalse(Deltagerliste.isValidLastname(""));
		assertFalse(Deltagerliste.isValidLastname("A"));
		assertFalse(Deltagerliste.isValidLastname(null));
		assertFalse(Deltagerliste.isValidLastname("Olsen Ols"));
		assertFalse(Deltagerliste.isValidLastname("olsen"));
		assertFalse(Deltagerliste.isValidLastname("5olsen"));
	}
	
	@Test
	public void validMobileOk() {
		assertTrue(Deltagerliste.isValidMobil("12345678"));
		assertFalse(Deltagerliste.isValidMobil("1b3f567a"));
	}
	
	@Test
	public void validMinLengthPass() {
		assertTrue(Deltagerliste.passordMinlengde("pass"));
		assertTrue(Deltagerliste.passordMinlengde("1234"));
		assertFalse(Deltagerliste.passordMinlengde("123"));
		assertFalse(Deltagerliste.passordMinlengde(""));
		assertFalse(Deltagerliste.passordMinlengde(null));
	}
	
	@Test
	public void samePasswordTest() {
		assertTrue(Deltagerliste.liktPassord("Pass", "Pass"));
		assertTrue(Deltagerliste.liktPassord("12345", "12345"));
		assertFalse(Deltagerliste.liktPassord("Pass", "Pass1"));
		
	}
}
