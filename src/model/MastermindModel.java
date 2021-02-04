package model;

import java.util.Random;

/**
 * 
 * @author Derek Tominaga
 *
 */
public class MastermindModel {
	private final char[] colorPool = {'r','o','y','g','b','p'};
	private char[] computerAnswer = new char[4];
	
	//private variable(s) to store the answer

	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
    public MastermindModel() { 
    	for(int index = 0; index < 4; index++) {
    		Random colorSelect = new Random();
    		computerAnswer[index] = colorPool[colorSelect.nextInt(6)];
    	} 
    }
    
    /**
     * This method is a special constructor to allow us to use JUnit to test our model.
     * 
     * Instead of creating a random solution, it allows us to set the solution from a 
     * String parameter.
     * 
     * 
     * @param answer A string that represents the four color solution
     */
    public MastermindModel(String answer) {
    	answer = answer.toLowerCase();
    	for(int index = 0; index < answer.length();index++) {
    		computerAnswer[index] = answer.charAt(index);
    	}
    }


    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	
    	return computerAnswer[index]; //Just returning something to make sure the code compiles
    }
    
    // Create as many private methods as you like
}
