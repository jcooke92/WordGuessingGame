package app;

import java.util.List;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class GuessingGameFileHandler implements FileHandler
{
    @Override
	public List<String> populateWordList(String pathToFile) throws IOException
	{
        return Files.lines(Paths.get(pathToFile))
            .map(line -> line.trim())
            .collect(toList());
	}
}