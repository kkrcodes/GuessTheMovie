package com.company;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Game class containing the game logic and methods for the game - "Guess The Movie"
 */
public class Game {

    private String randomMovie = "";
    private String encryptedMovie = "";
    private String wrongGuesses = "";
    private String correctGuesses = "";
    private int wrongAttempts;

    /**
     * Loads a list of movies from a text file and returns it as a String array
     * @param path path to the text file containing the list of movies
     * @return a String array containing the list of movies
     * @throws FileNotFoundException if text file is not found
     */
    public String[] getMovieList(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner fileScanner = new Scanner(file);
        StringBuilder movieListReader = new StringBuilder();
        while (fileScanner.hasNextLine()) {
            movieListReader.append(fileScanner.nextLine());
            movieListReader.append("\n");
        }
        fileScanner.close();
        return movieListReader.toString().trim().split("\n");
    }

    /**
     * Returns a random movie from a given list of movies
     * @param movies a String array containing the list of movies
     * @return a String containing a random movie from the list
     */
    public String generateRandomMovie(String[] movies) {
        int movieIndex = (int) (Math.random() * movies.length);
        return movies[movieIndex].replaceAll("[^a-zA-Z\\s]", "").toLowerCase();
    }

    /**
     * Sets the value of the given String to the variable randomMovie
     * @param randomMovie a String containing the random movie title generated earlier
     */
    public void setRandomMovie(String randomMovie) {
        this.randomMovie = randomMovie;
    }

    /**
     * Returns the random movie title generated earlier
     * @return a String containing the random movie title
     */
    private String getRandomMovie() {
        return randomMovie;
    }

    /**
     * Encrpyts a given movie title by replacing letters in the title with '-' and returns the encrypted title
     * @param randomMovie a String containing the movie title to be encrypted
     * @return a String with the encrypted movie title
     */
    public String encryptMovie(String randomMovie) {
        return randomMovie.replaceAll("[a-zA-Z]", "-");
    }

    /**
     * Sets the value of the given String to the variable encryptedMovie
     * @param encryptedMovie a String containing the encrypted movie title encrypted earlier
     */
    public void setEncryptedMovie(String encryptedMovie) {
        this.encryptedMovie = encryptedMovie;
    }

    /**
     * Returns the encrypted movie title generated earlier
     * @return a String containing the encrypted movie title
     */
    public String getEncryptedMovie() {
        return encryptedMovie;
    }

    /**
     * Sets the value of the given integer to the variable wrongAttempts
     * @param wrongAttempts an integer representing the number of wrong attempts made
     */
    public void setWrongAttempts(int wrongAttempts) {
        this.wrongAttempts = wrongAttempts;
    }

    /**
     * Returns the number of wrong attempts made so far
     * @return an integer containing the number of wrong attempts
     */
    public int getWrongAttempts() {
        return wrongAttempts;
    }

    /**
     * Returns the number of wrong attempts left in the game
     * @return the difference of 10 (max wrong attempts allowed) and wrong attempts made so far
     */
    public int getAttemptsLeft() {
        return 10 - wrongAttempts;
    }

    /**
     * Sets the value of the given String to the variable wrongGuesses
     * @param wrongGuesses a String containing the wrongly guessed letters so far
     */
    public void setWrongGuesses(String wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }

    /**
     * Returns a list of wrongly guessed letters so far
     * @return a String containing the wrongly guessed letters
     */
    public String getWrongGuesses() {
        return wrongGuesses;
    }

    /**
     * Sets the value of the given String to the variable correctGuesses
     * @param correctGuesses a String containing the correctly guessed letters so far
     */
    public void setCorrectGuesses(String correctGuesses) {
        this.correctGuesses = correctGuesses;
    }

    /**
     * Returns a list of correctly guessed letters so far
     * @return a String containing the correctly guessed letters
     */
    public String getCorrectGuesses() {
        return correctGuesses;
    }

    /**
     * Checks if the given character is a valid guess (only characters allowed)
     * @param guess a character containing the player's guess
     * @return true if character is a letter, false otherwise
     */
    public boolean isValidGuess(char guess) {
        return guess >= 'a' && guess <= 'z';
    }

    /**
     * Checks if the given character has already been guessed
     * @param guess a character containing the player's guess
     * @return true if character has already been guessed, false otherwise
     */
    public boolean hasAlreadyGuessed(char guess) {
        return getWrongGuesses().indexOf(guess) >= 0 || getCorrectGuesses().indexOf(guess) >= 0;
    }

    /**
     * Checks if the given character containing the player's guess (1) exists in the movie title to be guessed and
     * (a) if it does, adds it to the list of correct guesses and updates the encrypted movie title with the character (all occurrences);
     * (b) if it doesn't, adds it to the list of wrong guesses and updates the wrong attempts counter.
     * @param guess a character containing the player's guess
     */
    public void checkGuess(char guess) {
        if (getRandomMovie().indexOf(guess) >= 0) {
            StringBuilder encryptedMovieTracker = new StringBuilder(getEncryptedMovie());
            for (int i = 0; i < encryptedMovie.length(); i++) {
                if (guess == randomMovie.charAt(i)) {
                    encryptedMovieTracker.setCharAt(i, guess);
                }
            }
            setEncryptedMovie(encryptedMovieTracker.toString());
            correctGuesses += guess + " ";
            setCorrectGuesses(correctGuesses);
        } else {
            wrongGuesses += guess + " ";
            setWrongGuesses(wrongGuesses);
            wrongAttempts++;
            setWrongAttempts(wrongAttempts);
        }
    }

    /**
     * Checks if player has won the game
     * @return true if there are no '-' (non-guessed slots) present in the encrypted title, false otherwise
     */
    public boolean gameWon() {
        return getEncryptedMovie().indexOf('-') < 0;
    }

    /**
     * Checks if player has lost the game
     * @return true if number of wrong attempts is equal to 10, false otherwise
     */
    public boolean gameLost() {
        return getWrongAttempts() == 10;
    }

    /**
     * Checks if the game has ended either because the player has won or lost the game
     * @return true if player has either won or lost, false otherwise
     */
    public boolean gameOver() {
        return gameWon() || gameLost();
    }
}
