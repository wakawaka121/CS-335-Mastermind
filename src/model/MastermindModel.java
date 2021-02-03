package model;
/**
 * 
 * @author YOUR NAME HERE
 *
 */
public class MastermindModel {
	//private variable(s) to store the answer

	// Only these methods may be public - you may not create any additional 
	// public methods (and NO public fields)
    public MastermindModel() { 
    	// TODO Make the answer  
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
    	// TODO Take answer and somehow store it as your answer. Make sure the getColorAt method 
    	// still works
    }


    public char getColorAt(int index) {
          /* Return color at position index as a char
           (first converted if stored as a number) */
    	
    	return 'r'; //Just returning something to make sure the code compiles
    }
    
    // Create as many private methods as you like

}
