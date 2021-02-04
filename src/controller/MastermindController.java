package controller;
import java.util.ArrayList;
import java.util.List;

import model.MastermindModel;

/**
 * 
 * @author Derek Tominaga
 * Description: This class contains methods to control 
 * the mechanics of Mastermind.java
 * Constructor: creates MastermindController object
 * from a Mastermind model object.
 * Methods:
 * -isCorrect: tells if user answer is same as solution
 * -getRightColorRightPLace: determines number of colors in
 * correct position
 * -getrightColorWrongPlace: determines number of colors guessed
 * correctly but in wrong position.
 *
 */
public class MastermindController {
	private char[] solution = new char[4];
	
	/*This constructor takes one parameter, model, to create a 
	 *MastermindController object and set the one private
	 *field. model is a MastermindModel object that represents
	 *a solution to Mastermind.java
	 *solution: is a char array of size 4, represents the 
	 *solution that is being guessed.
	 **/
	public MastermindController(MastermindModel model) {
		for(int index = 0; index < 4; index++) {
			solution[index] = model.getColorAt(index);
		}
	}
 
	/*
	 * This method takes one parameter, guess, which is a string 
	 * that represents a user answer. compares the chars of
	 * solution with the chars of the guess string.
	 * return: true if guess matches, in order, the solution.
	 * */
    public boolean isCorrect(String guess) {
    	guess = guess.toLowerCase();
    	for(int index = 0; index < guess.length(); index++) {
    		if(solution[index] != guess.charAt(index)) {
    			return false;
    		}
    	}
    	return true; 
    }

    /*
     * This method takes one parameter, guess, which is a string
     * that represents a user answer. compares the chars of 
     * solution with the chars in guess string, to determine which 
     * chars in the guess string are correct and in the right position.
     * correctPlaces: is an int value that represents correct chars in 
     * correct position.
     * return: correctPlaces
     * */
    public int getRightColorRightPlace(String guess) {
    	int correctPlaces = 0;
    	guess = guess.toLowerCase();
    	for(int index = 0; index < guess.length();index++) {
    		if(solution[index] == guess.charAt(index)) {
    			correctPlaces++;
    		}
    	}
    	return correctPlaces; 
    }

    /*
     * This method takes one parameter, guess, which is a string
     * that represents a user answer. compares the chars of solution
     * with chars in guess string to determine which chars in guess string,
     * are in solution, but in wrong position. By creating a list of chars that
     * exist in the solution and in the guess, except if the guess char is correct
     * in the solution in the correct place. Then find the number of matches between 
     * guess chars and solution chars.
     * rightColor: int value that represent num of colors that are corrent
     * in the answer but in wrong place compared to solution.
     * return: rightColor
     * */
    public int getRightColorWrongPlace(String guess) {
    	int rightColor = 0;
    	guess = guess.toLowerCase();
    	List<Character> guessBank = new ArrayList<Character>();
    	List<Character> solutionBank = new ArrayList<Character>();
    	for(int index = 0; index < guess.length(); index++) {
    		if(solution[index] != guess.charAt(index)) {
    			guessBank.add(solution[index]);
    			solutionBank.add(guess.charAt(index));
    		}
    	}
    	for(char color : solutionBank) {
    		if(guessBank.contains(color)) {
    			guessBank.remove(Character.valueOf(color));
    			rightColor++;
    		}
    	}
    	
    	return rightColor;
    }


}
