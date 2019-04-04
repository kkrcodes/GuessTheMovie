# Guess The Movie

<b> Object Oriented Programming in Java (Udacity) - Guess The Movie [Project] </b>

This Java project was done as part of the curriculum of Udacity's <i> Object Oriented Programming in Java </i> course.

Project Summary
---------------
The goal of the project was to build a simple text game where the player gets to guess the movie name given the number of letters in it (pretty much like hangman but with movies). <br>

The rules are simple; the game randomly picks a movie title, and shows the player how many letters it's made up of. The player's goal is to try to figure out the movie by guessing one letter at a time. If a letter is indeed in the title the game will reveal its correct position in the word, if not, they lose a point. If they lose 10 points, the game is over.

The project is implemented through two classes and one text file:
<ul>
  <li> <b> <i> Game.java </i> </b> containing the game logic and methods </li>
  <li> <b> <i> Main.java </i> </b> implementing game logic and interaction with user </li>
  <li> <b> <i> movies.txt </i> </b> serving the list of movies to be considered for the game </li>
 </ul>

Example screenshots showing the game in action:


![Game intro](screenshots/1-gameIntro.PNG?raw=true "Game intro")

![Game in progress](screenshots/2-gameInProgress.PNG?raw=true "Game in progress")

![Game won](screenshots/3-gameWon.PNG?raw=true "Game won")

![Game lost](screenshots/4-gameLost.PNG?raw=true "Game lost")

