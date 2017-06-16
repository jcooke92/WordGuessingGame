package app;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GuessingGameLogic
{
	private List<String> words;
	private Random random;
	private boolean userWon;

	public GuessingGameLogic()
	{
		words = new ArrayList<String>();
		random = new Random();
		userWon = false;
	}

	public String scramble(String word)
	{
		if(word.length() < 1)
			return "";

		char[] scrambledWord = new char[word.length()];
		int scrambleNum = random.nextInt(word.length());
		List<Integer> scrambleOrder = new ArrayList<Integer>();

		for(int i = 0; i < word.length(); ++i)
		{
			while(scrambleOrder.contains(scrambleNum))
				scrambleNum = random.nextInt(word.length());

			scrambledWord[i] = (char) word.charAt(scrambleNum);
			scrambleOrder.add(scrambleNum);
		}

		return String.valueOf(scrambledWord);
	}

	public void setWordList(List<String> list)
	{
		words = list;
	}

	public List<String> getWordList()
	{
		return words;
	}

	public String getRandomWordFromList()
	{
		if(getWordList().size() > 0)
		{
			int index = random.nextInt(getWordList().size());
			return getWordList().get(index);
		}

		return "";
	}

	public String getCommonCharacters(String firstWord, String secondWord)
	{
		int[] firstCharHistogram = new int[256];
		int[] secondCharHistogram = new int[256];

		for(int i = 0; i < firstWord.length(); ++i)
		{
			int charIndex = (int) firstWord.charAt(i);
			firstCharHistogram[charIndex] += 1;
		}

		for(int i = 0; i < secondWord.length(); ++i)
		{
			int charIndex = (int) secondWord.charAt(i);
			secondCharHistogram[charIndex] += 1;
		}

		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < 256; ++i)
		{
			if(firstCharHistogram[i] != 0 && secondCharHistogram[i] != 0)
			{
				String characterString = Character.toString((char) i);
				stringBuilder.append(characterString);
			}
		}

		String result = stringBuilder.toString();

		return result;
	}

	public String getCommonVowels(String firstWord, String secondWord)
	{
		String result = getCommonCharacters(firstWord, secondWord);
		String regex = "[^aeiouAEIOU]";
		return result.replaceAll(regex, "");
	}

	public String getCommonConsonants(String firstWord, String secondWord)
	{
		String result = getCommonCharacters(firstWord, secondWord);
		String regex = "(a|A|e|E|i|I|o|O|u|U)";
		return result.replaceAll(regex, "");
	}

	public int calculatePoints(String guessWord, String correctWord)
	{
		if(guessWord.equals(correctWord))
		{
			userWon = true;
			return 0;
		}

		String commonVowels = getCommonVowels(guessWord, correctWord);
		int vowelPoints = 2 * commonVowels.length();

		String commonConsonants = getCommonConsonants(guessWord, correctWord);
		int consonantPoints = commonConsonants.length();

		return vowelPoints + consonantPoints;
	}

	public boolean wonGame()
	{
		return userWon;
	}
}