package app;

import java.net.*;
import java.io.*;
import java.lang.*;

public interface SpellingCheck
{
	public boolean checkSpelling(String word) throws MalformedURLException, IOException;
}