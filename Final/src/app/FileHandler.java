package app;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

public interface FileHandler
{
	public List<String> populateWordList(String pathToFile) throws IOException;
}