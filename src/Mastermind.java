import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Derek Tominaga
 * Description: This class represents the view of the Mastermind game. It contains
 * the logic in how mastermind is played. The game allows user to decide if 
 * they will play, allows player to make 10 guesses, and lets user know if they found 
 * the correct solution, or if they exceeded allowed attempts. Allows users to play 
 * multiple times, until they decide not to.
 *
 */
public class Mastermind {
	private static final int GUESS_LENGTH = 4;

	public static void main(String[] args) {
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
		Scanner input = new Scanner(System.in);
		String willPlay = input.next().toLowerCase();
		System.out.println();
		if(!isValidChoice(willPlay)) {
			while(!isValidChoice(willPlay)){
				System.out.print("Please input either 'yes' or 'no'. \n");
				willPlay = input.next().toLowerCase();
			}
		}
		while(!willPlay.equals("no")) {
			MastermindModel gameSolution = new MastermindModel();
			MastermindController gameController = new MastermindController(gameSolution);
			int attempt = 1;
			while(attempt <=10) {
				System.out.print("Enter guess number " + attempt + ": " );
				String guess = input.next().toLowerCase();
				if(!isValidGuess(guess)) {
					while(!isValidGuess(guess)) {
						System.out.print("Guess must be of length 4. Please re-enter your guess.");
						guess = input.next().toLowerCase();
					}
				}
				if(gameController.isCorrect(guess)) {
					System.out.println("Corect: your got it on attempt " + attempt);
					attempt = 12;
				}
				else {
					System.out.println("Colors in the correct place: " + gameController.getRightColorRightPlace(guess));
					System.out.println("Colors correct but in wrong position: " + gameController.getRightColorWrongPlace(guess));
					System.out.println();
					attempt++;
				}
			}
			if(attempt <=11) {
				System.out.print("Nice try, but you have exceeded maxinum number of attempts. \nWould you like to play again?");
			}
			else {
				System.out.print("Would you like to play again? ");
			}
			willPlay = input.next().toLowerCase();
			
		} 
		System.out.println("Thank you for playing. ");
		input.close();
	}
	
	/*This method validates user choice to if they will play the game by checking
	 * user input and ensuring the input is either yes or no.
	 * return: true if input is yes or no. */
	private static boolean isValidChoice(String userChoice) {
		userChoice = userChoice.toLowerCase();
		if(userChoice.equals(("yes")) || userChoice.equals("no")) {
			return true;
		}
		return false;
	}
	
	/*This method validate user guess, to ensure that it is of length 
	 * GUESS_LENGTH.
	 * return: true if input string is of length GUESS_LENGTH*/
	private static boolean isValidGuess(String userInput) {
		userInput = userInput.toLowerCase();
		if(userInput.length() != GUESS_LENGTH) {
			return false;
		}
		return true;
	}

}
