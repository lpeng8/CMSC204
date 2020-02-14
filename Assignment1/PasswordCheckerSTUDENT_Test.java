
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Lang Peng
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> passwords;
	String password1, password2;
	@Before
	public void setUp() throws Exception {
		String[] a = {"3344525BB", "Im22cool4U", "AAAb123ZZ", "4sale1", "bertha22", "4wardMarch", 
				"august30"};
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(a));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Asdv1324"));
			PasswordCheckerUtility.isValidPassword("123");
			assertTrue("Did not throw LengthException", false);
		}
		catch(LengthException e)
		{
			assertTrue("it did throw a length Exception", true);
		}
		catch(Exception e) {
			assertTrue("Threw some other exception", false);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Ads231231"));
			PasswordCheckerUtility.isValidPassword("a21321313v");
			assertTrue("Did not throw NoUpperAlphaException", false);
		}
		catch(NoUpperAlphaException e)
		{
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("aB234342"));
			PasswordCheckerUtility.isValidPassword("ABC12314");
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("3123Baadd"));
			assertTrue(PasswordCheckerUtility.isWeakPassword("3123Baadd"));
		}
		
	
	catch(Exception e)
	{
		System.out.println(e.getMessage());
		assertTrue("Threw some incorrect exception",false);
	}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("1234aaAA"));
			PasswordCheckerUtility.isValidPassword("123456aAAA");
			assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}

	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("AAbb2134"));
			PasswordCheckerUtility.isValidPassword("Abcaseqw");
			assertTrue("Did not throw an NodigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("it did throw NoDigitException",true);
		}
		catch(Exception e)
		{
			
			assertTrue("Threw some other exception",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("AAbb2134"));
		}
		catch (Exception e)
		{
			assertTrue("this should not throw an exception", false);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.invalidPasswords(passwords);
		Scanner scan = new Scanner(results.get(0)); 
		assertEquals(scan.next(), "3344525BB");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		scan = new Scanner(results.get(1)); 
		assertEquals(scan.next(), "AAAb123ZZ");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("more than two"));
		
		scan = new Scanner(results.get(2)); 
		assertEquals(scan.next(), "4sale1");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("at least"));
		
		scan = new Scanner(results.get(3)); 
		assertEquals(scan.next(), "bertha22");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("upper"));
		
	}
	
}
