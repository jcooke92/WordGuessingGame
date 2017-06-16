package app;

import java.net.*;
import java.io.*;
import java.lang.*;

import org.mockito.*;
import static org.mockito.Mockito.*;

import org.junit.*;
import static org.junit.Assert.*;

public class SpellingCheckServiceTest
{
	SpellingCheckService mockService;
	SpellingCheckService service;
	boolean result;

	@Before
	public void setup()
	{
		mockService = Mockito.mock(SpellingCheckService.class);
		service = new SpellingCheckService();
		result = false;
	}

	@Test
	public void mockCorrectlySpelledWordReturnsTrue()
	{
		String word = "bridge";
		try
		{ 
			Mockito.when(mockService.checkSpelling("bridge")).thenReturn(true);
			result = mockService.checkSpelling(word); 
		}
		catch(MalformedURLException e)
		{ fail("MalformedURLException was thrown but not expected"); }
		catch(IOException e)
		{ fail("IOException was thrown but not expected"); }

		assertTrue(result);
	}

	@Test
	public void mockIncorrectlySpelledWordReturnsFalse()
	{
		String word = "brideg";
		try
		{ 
			Mockito.when(mockService.checkSpelling("brideg")).thenReturn(false);
			result = mockService.checkSpelling(word); 
		}
		catch(MalformedURLException e)
		{ fail("MalformedURLException was thrown but not expected"); }
		catch(IOException e)
		{ fail("IOException was thrown but not expected"); }

		assertFalse(result);
	}

	//////////////////////////////////
	// 								//
	// 								//
	// Spell check service is down.	//
	//								//
	//								//
	//////////////////////////////////

	// @Test
	// public void correctlySpelledWordReturnsTrue()
	// {
	// 	String word = "hello";
	// 	try
	// 	{ result = service.checkSpelling(word); }
	// 	catch(MalformedURLException e)
	// 	{ fail("MalformedURLException was thrown but not expected"); }
	// 	catch(IOException e)
	// 	{ fail("IOException was thrown but not expected"); }

	// 	assertTrue(result);
	// }

	// @Test
	// public void incorrectlySpelledWordReturnsFalse()
	// {
	// 	String word = "herro";
	// 	try
	// 	{ result = service.checkSpelling(word); }
	// 	catch(MalformedURLException e)
	// 	{ fail("MalformedURLException was thrown but not expected"); }
	// 	catch(IOException e)
	// 	{ fail("IOException was thrown but not expected"); }

	// 	assertFalse(result);
	// }
}