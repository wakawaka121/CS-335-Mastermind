package controller;
import java.util.ArrayList;
import java.util.List;

import model.MastermindModel;

/**
 * 
 * @author Derek Tominaga
 *
 */
public class MastermindController {
	private char[] solution = new char[4];
	
	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
	
	public MastermindController(MastermindModel model) {
		for(int index = 0; index < 4; index++) {
			solution[index] = model.getColorAt(index);
		}
	}
 

    public boolean isCorrect(String guess) {
    	guess = guess.toLowerCase();
    	for(int index = 0; index < guess.length(); index++) {
    		if(solution[index] != guess.charAt(index)) {
    			return false;
    		}
    	}
    	return true; //Just something for now to make sure the code compiles
    }


    public int getRightColorRightPlace(String guess) {
    	int correctPlaces = 0;
    	guess = guess.toLowerCase();
    	for(int index = 0; index < guess.length();index++) {
    		if(solution[index] == guess.charAt(index)) {
    			correctPlaces++;
    		}
    	}
    	return correctPlaces; //Just something for now to make sure the code compiles
    }


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
    	
    	return rightColor; //Just something for now to make sure the code compiles
    }


}
