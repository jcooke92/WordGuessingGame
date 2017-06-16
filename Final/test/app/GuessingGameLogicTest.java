package app;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

public class GuessingGameLogicTest
{
	GuessingGameLogic gameLogic;

	String word1;
	String word2;
	String expectedResult;
	String result;

	@Before
	public void setup()
	{
		gameLogic = new GuessingGameLogic();
	}

	@Test
	public void scrambledWordIsDifferentFromOriginal()
	{
		String unscrambled = "hello!";
		result = gameLogic.scramble(unscrambled);
		assertFalse(unscrambled.equals(result));
	}

	@Test
	public void scrambleEmptyWordReturnsEmptyWord()
	{
		String unscrambled = "";
		result = gameLogic.scramble(unscrambled);
		assertEquals(unscrambled, result);
	}

	@Test
	public void getRandomWordFromListReturnsRandomWordFromList()
	{
		List<String> words = Arrays.asList("hello", "morning", "afternoon");
		gameLogic.setWordList(words);
		result = gameLogic.getRandomWordFromList();
		for(String str : words)
			if(str.equals(result))
			{
				assertTrue(true);
				return;
			}

		fail("Word \"" + result + "\" did not match any word from list");
	}

	@Test
	public void getRandomWordFromEmptyWordListReturnsEmptyString()
	{
		List<String> words = Arrays.asList();
		gameLogic.setWordList(words);
		result = gameLogic.getRandomWordFromList();
		assertEquals("", result);
	}

	@Test
	public void checkCharactersInCommonWithWordReturnsCommonLetters()
	{
		word1 = "midnight";
		word2 = "morning";
		expectedResult = "gimn";
		result = gameLogic.getCommonCharacters(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void checkWordsWithNoCommonChractersReturnsNoCommonCharacters()
	{
		word1 = "midnight";
		word2 = "jello";
		expectedResult = "";
		result = gameLogic.getCommonCharacters(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void checkVowelsInCommonReturnsCommonVowels()
	{
		word1 = "midnight";
		word2 = "morning";
		expectedResult = "i";
		result = gameLogic.getCommonVowels(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void checkWordsWithNoCommonVowelsReturnsNoCommonVowels()
	{
		word1 = "jello";
		word2 = "hat";
		expectedResult = "";
		result = gameLogic.getCommonVowels(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void checkConsonantsInCommonReturnsCommonConsonants()
	{
		word1 = "midnight";
		word2 = "morning";
		expectedResult = "gmn";
		result = gameLogic.getCommonConsonants(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void checkWordsWithNoCommonConsonantsReturnsNoCommonConsonants()
	{
		word1 = "banana";
		word2 = "jazz";
		expectedResult = "";
		result = gameLogic.getCommonConsonants(word1, word2);
		assertEquals(expectedResult, result);
	}

	@Test
	public void calculatePointsReturnsPoints()
	{
		String guessWord = "money";
		String correctWord = "monkey";
		int expectedPoints = 7;
		int resultingPoints = gameLogic.calculatePoints(guessWord, correctWord);
		assertEquals(expectedPoints, resultingPoints);
	}

	@Test
	public void calculatePointsOfDifferentWordReturnsNoPoints()
	{
		String guessWord = "jar";
		String correctWord = "monkey";
		int expectedPoints = 0;
		int resultingPoints = gameLogic.calculatePoints(guessWord, correctWord);
		assertEquals(expectedPoints, resultingPoints);
	}

	@Test
	public void wonGameIfWordsAreSame()
	{
		String guessWord = "spell";
		String correctWord = "spell";
		gameLogic.calculatePoints(guessWord, correctWord);
		assertTrue(gameLogic.wonGame());
	}

	@Test
	public void didNotWinIfWordsAreDifferent()
	{
		String guessWord = "dry";
		String correctWord = "spell";
		gameLogic.calculatePoints(guessWord, correctWord);
		assertFalse(gameLogic.wonGame());
	}
}