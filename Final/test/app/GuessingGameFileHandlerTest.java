package app;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import org.junit.*;
import static org.junit.Assert.*;

public class GuessingGameFileHandlerTest
{
	GuessingGameFileHandler fileHandler;

	@Before
	public void setup()
	{
		fileHandler = new GuessingGameFileHandler();
	}

	@Test
	public void readsFileAndReturnsWordList()
	{
		List<String> expectedWords = Arrays.asList("monkey", "fruit",  "banana", "morning", "afternoon", 
			"evening", "category", "guess", "automobile", "diploma");
		try
		{ assertEquals(expectedWords, fileHandler.populateWordList("words.txt")); }
		catch(IOException e)
		{ fail("IOException thrown but not expected"); }
	}

	@Test
	public void readBadFileThrowsException()
	{
		List<String> expectedWords = new ArrayList<String>();
		try
		{ assertEquals(expectedWords, fileHandler.populateWordList("badfile")); }
		catch(IOException e)
		{ assertTrue(true); }
	}
}