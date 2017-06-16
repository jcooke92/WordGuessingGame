package app.ui;

import app.*;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

public class GuessingGameUI
{
	public static void main(String[]args)
	{
		GuessingGameFileHandler fileHandler = new GuessingGameFileHandler();
		GuessingGameLogic gameLogic = new GuessingGameLogic();
		List<String> wordList = new ArrayList<String>();
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the word list file name: ");
		String pathToFile = scanner.nextLine();

		try
		{
			wordList = fileHandler.populateWordList(pathToFile);
		}
		catch(IOException e)
		{
			System.out.println("Specified file not found. Trying default word list file.");
			try
			{ wordList = fileHandler.populateWordList("words.txt"); }
			catch(IOException f)
			{ 
				System.out.println("No word list file found. Exiting"); 
				return;
			}
		}

		gameLogic.setWordList(wordList);
		String wordToGuess = gameLogic.getRandomWordFromList();
		String scrambledWord = gameLogic.scramble(wordToGuess);
		System.out.println("Welcome to the word guessing game!\n" +
			"Your task is to correctly guess a word given a scrambled version of that word. Partial points are awarded\n" +
			"to guesses that contain the letters as the original word. 1 point for each consonant and 2 points for each vowel.\n" +
			"(Normally, partial points are only awarded to guesses that are in the English dictionary, but the spell checker\n" +
			"service is not functioning at the moment.)");

		while(!gameLogic.wonGame())
		{
			System.out.println("Scrambled word: " + scrambledWord);
			System.out.print("Make a guess: ");
			String guess = scanner.nextLine();
			int points = gameLogic.calculatePoints(guess, wordToGuess);
			System.out.println("Partial points: " + points);
		}

		System.out.println("Congratulations! You've won the game!");
	}
}