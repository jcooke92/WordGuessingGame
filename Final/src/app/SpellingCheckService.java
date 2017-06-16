package app;

import java.net.*;
import java.io.*;
import java.lang.*;

public class SpellingCheckService implements SpellingCheck
{
	@Override
	public boolean checkSpelling(String word) throws MalformedURLException, IOException
	{

		URL url = new URL("http://agile.cs.uh.edu/spell?check=" + word);

		InputStream stream = url.openStream();

		StringBuilder buffer = new StringBuilder();

		int index = stream.read();

		buffer.append((char) index);

		String result = buffer.toString();

		if(result != null)
		{
			if(result.charAt(0) == 't' || result.charAt(0) == 'T')
				return true;
		}

		return false;
	}	
}