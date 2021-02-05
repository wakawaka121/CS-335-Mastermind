package model;

import java.util.Random;

/**
 * 
 * @author Derek Tominaga
 * Description: This class contains methods to create and access a MastermindModel object.
 * Constructors: array of 4 chars generated, randomly or by string input.
 * Methods: 
 * - getColorAt: returns char at a specific index.
 *  
 *
 */
public class MastermindModel {
	private final int MODEL_SIZE = 4;
	private final char[] colorPool = {'r','o','y','g','b','p'};
	private char[] computerAnswer = new char[MODEL_SIZE];
	
	/*
	 * This function is the zero argument constructor. 
	 * when called this constructor generates a random computerAnswer
	 * by choosing 4 of the 6 possible colors.
	 * computerAnswer: char array of size 4, that represents the order of the 
	 * generated solution to be solved for.
	 * */
    public MastermindModel() { 
    	for(int index = 0; index < MODEL_SIZE; index++) {
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
    	if(answer.length() != MODEL_SIZE) {
    		throw new IllegalArgumentException("Invalid string input. String must be of length 4.");
    	}
    	else {
    		answer = answer.toLowerCase();
    		for(int index = 0; index < answer.length();index++) {
    			computerAnswer[index] = answer.charAt(index);
    		}
    	}
    }

    /*
     * This method takes one parameter to determine the char
     * at a specific int value.
     * return: char at given index of computerAnswer. 
     * */
    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	
    	return computerAnswer[index]; //Just returning something to make sure the code compiles
    }
    
}
