package no.hvl.dat108;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValideringTest {
	public static final String ANY_LETTER = "[a-zA-ZæøåÆØÅ]";
	public static final String UPPERCASE_FIRST = "[A-ZÆØÅ]{1}";
	
	@Test
	public void validFirstnamesOk() {
		assertTrue("Ole".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertTrue("Ole-Martin".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertTrue("Jens Kristian".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertFalse("0le".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertFalse("Oooooollllleeeeeeeeee".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertFalse("o".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
		assertFalse("".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ\\s-]{1,19}$"));
	}
	
	@Test
	public void validLastnamesOk() {
		assertTrue("Olsen".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertTrue("Olsen-Olsen".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertTrue("Åge-Øyær".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertFalse("Åge Øyær".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertFalse("Å2ge-Øyær".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertFalse("O".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
		assertFalse("".matches("^" + UPPERCASE_FIRST + "[a-zA-ZæøåÆØÅ-]" + "{1,19}$"));
	}

	@Test
	public void norwegianLettersAllowed() {
		assertTrue("Æ".matches("^[a-zA-ZæøåÆØÅ]"));
		assertTrue("Ø".matches("^[a-zA-ZæøåÆØÅ]"));
		assertTrue("Å".matches("^[a-zA-ZæøåÆØÅ]"));
		assertTrue("æ".matches("^[a-zA-ZæøåÆØÅ]"));
		assertTrue("ø".matches("^[a-zA-ZæøåÆØÅ]"));
		assertTrue("å".matches("^[a-zA-ZæøåÆØÅ]"));
	}
	
	@Test
	public void validMobileOk() {
		assertTrue("12345678".matches("^\\d{8}$"));
		assertFalse("1b3f567a".matches("^\\d{8}$"));
		assertFalse("1234".matches("^\\d{8}$"));
	}
	
	@Test
	public void validMinLengthPass() {
		assertTrue("pass".matches("[a-zA-ZæøåÆØÅ0-9]{4,}$"));
		assertTrue("1234".matches("[a-zA-ZæøåÆØÅ0-9]{4,}$"));
		assertFalse("123".matches("[a-zA-ZæøåÆØÅ0-9]{4,}$"));
		assertFalse("".matches("[a-zA-ZæøåÆØÅ0-9]{4,}$"));
	}
}
