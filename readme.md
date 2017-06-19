This project was assigned as one of the final exams for the Spring 2017 Software Design Course at University of Houston. The course was taught by Venkat Subramaniam, who is one of the founders of Agile.

The goal of this project was to employ Gradle and test-driven design to create a command line interface game where a user is presented a scrambled version of a word from a text file word bank and the user tries to correctly guess the word. This project was originally meant to be used in conjunction with a spellchecker service, but that service isn't currently functioning, so the spellchecker tests and checks have been commented out. The project details are listed in the "readme.txt" file.

To tackle this project, I thought about what components would be required. There would need to be the core logic, file handling, spell checking service, and user interface. I then set out to write tests for each of these components and implement the methods that would make the tests pass, starting with the logic and ending on the user interface.  

The final result is a modular application built around test-driven design and abstraction. 


************* TO RUN *************

Clone the JAR file in the build/libs directory and run with "java -jar GuessingGame.jar"