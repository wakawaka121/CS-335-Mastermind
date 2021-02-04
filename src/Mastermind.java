import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Derek Tominaga
 *
 */
public class Mastermind {

	public static void main(String[] args) {
		// This class represents the view, it should be how uses play the game
		System.out.println("Welcome to Mastermind!");
		System.out.print("Would you like to play? ");
		Scanner input = new Scanner(System.in);
		String willPlay = input.next().toLowerCase();
		System.out.println();
		while(!willPlay.equals("no")) {
			MastermindModel gameSolution = new MastermindModel();
			MastermindController gameController = new MastermindController(gameSolution);
			int attempt = 1;
			while(attempt <=10) {
				System.out.print("Enter guess number " + attempt + ": " );
				String guess = input.next().toLowerCase();
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
		System.out.println("Thank you for playing.");
		input.close();
	}

}
