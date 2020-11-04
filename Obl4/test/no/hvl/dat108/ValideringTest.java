package no.hvl.dat108;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValideringTest {
	public static final String ANY_LETTER = "[a-zA-Z������]";
	public static final String UPPERCASE_FIRST = "[A-Z���]{1}";
	
	@Test
	public void validFirstnamesOk() {
		assertTrue("Ole".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertTrue("Ole-Martin".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertTrue("Jens Kristian".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertFalse("0le".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertFalse("Oooooollllleeeeeeeeee".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertFalse("o".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
		assertFalse("".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������\\s-]{1,19}$"));
	}
	
	@Test
	public void validLastnamesOk() {
		assertTrue("Olsen".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertTrue("Olsen-Olsen".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertTrue("�ge-�y�r".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertFalse("�ge �y�r".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertFalse("�2ge-�y�r".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertFalse("O".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
		assertFalse("".matches("^" + UPPERCASE_FIRST + "[a-zA-Z������-]" + "{1,19}$"));
	}

	@Test
	public void norwegianLettersAllowed() {
		assertTrue("�".matches("^[a-zA-Z������]"));
		assertTrue("�".matches("^[a-zA-Z������]"));
		assertTrue("�".matches("^[a-zA-Z������]"));
		assertTrue("�".matches("^[a-zA-Z������]"));
		assertTrue("�".matches("^[a-zA-Z������]"));
		assertTrue("�".matches("^[a-zA-Z������]"));
	}
	
	@Test
	public void validMobileOk() {
		assertTrue("12345678".matches("^\\d{8}$"));
		assertFalse("1b3f567a".matches("^\\d{8}$"));
		assertFalse("1234".matches("^\\d{8}$"));
	}
	
	@Test
	public void validMinLengthPass() {
		assertTrue("pass".matches("[a-zA-Z������0-9]{4,}$"));
		assertTrue("1234".matches("[a-zA-Z������0-9]{4,}$"));
		assertFalse("123".matches("[a-zA-Z������0-9]{4,}$"));
		assertFalse("".matches("[a-zA-Z������0-9]{4,}$"));
	}
}
