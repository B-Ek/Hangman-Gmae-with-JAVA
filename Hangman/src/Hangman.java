import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Hangman{
    
	public int livesLeft;
	public boolean won = false;
	public String category;
	protected String secretPhrase; //Protected because of inheritance
    public String workingString;
    public ArrayList<Character> guessedLetters = new ArrayList<Character>(); //ARRAYLIST
    
    static Locale trLocale = new Locale("tr","TR");
    

    
    static Random random = new Random();
    public static Character[] charWhitelistArray = new Character[]{'A', 'B', 'C', 'Ã', 'D', 'E', 'F', 'G', 'Ä', 'H', 'I', 'Ä', 'J', 'K', 'L', 'M', 'N', 'O', 'Ã', 'P', 'Q', 'R', 'S', 'Å', 'T', 'U', 'Ã', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '&', ' ', ',',  '.'};
    
    public static List<Character> charWhitelist = Arrays.asList(charWhitelistArray); //Converts Array to ArrayList
    
    
    
    //Characters to automatically reveal:

//    public static List<Character> revealedChars = Arrays.asList(' ', '&',  ',', '.','0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
    public static Character[] revealedCharsArray = new Character[]{' ', '&',  ',', '.','0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    public static List<Character> revealedChars = Arrays.asList(revealedCharsArray); //Converts Array to ArrayList

    
    

    static String[] phraseListSports = new String[]{"Football", "Basketball", "Voleyball"};
    static String[] phraseListElectronics = new String[]{"Computer", "Television"};
    static String[] phraseListJava = new String[]{"String", "Integer", "Char"};
    static String[] phraseList4 = new String[]{"", "", ""};
    static String[] phraseList5 = new String[]{"", ""};
    static String[] phraseList6 = new String[]{" ", " ", " ", " "};

    
    
    
    
    public Hangman(String theme, String phrase){

    	this.category = theme;
    	
    	if (theme.equals("Custom")) {//If the custom mode is selected, use the provided custom Phrase
    		this.secretPhrase = phrase; 
    	}else {//Else, pick a random phrase
    		this.secretPhrase = generatePhrase(theme);
    	}
    	
        //Generate working string
    	this.generateWorkingString();

    }

    


    public void generateWorkingString() {
	String temp = "";
	for (int i=0; i<secretPhrase.length(); i++) {
		if (this.secretPhrase.charAt(i) == ' ') {//Keep spaces
			temp += ' ';
		}else {									//Replace other characters with underscore
			temp += '_';
		}
	}
	this.workingString = temp;
	
	int len = this.secretPhrase.length();
	for (int i=0; i<len; i++) {
		if (revealedChars.contains(this.secretPhrase.charAt(i))) { //Check each character of secretPhrase and see if it is included in revealedChars
			//Show char
			this.workingString = this.workingString.substring(0,i) + this.secretPhrase.charAt(i) + this.workingString.substring(i+1);
		}
	}
}
   
  
  
    public int guessLetter(Character c){
    	//Description: takes a user input and checks if the guessed character is  inside the hidden phrase.
    	c = characterUpper(c); //Working in capital letters
    	String c2 = String.valueOf(c);
    	
    	//First check if character legal
    	
    	if (charWhitelist.contains(c) == false) { //Check if whitelist doesn't contain character
    		System.out.println("\"" + c  + "\"" + " is an illegal character in this game.");
    		return -1;
    	}


    
    	if (revealedChars.contains(c)) { //Check if revealedChars contains character
    		System.out.println("This letter would have been revealed by default");
    		return -1;
    	}

    	
		if (this.guessedLetters.contains(c)) {
			System.out.println("This character has already been guessed before!");
			return -1;
		}

		//Starting Guess
		ArrayList<Integer> correctPositions = new ArrayList<Integer>();
		String tempPhrase = this.secretPhrase.toUpperCase(trLocale);
			
		while (tempPhrase.contains(c2)) { // Finds each occurrence of guessed character and record positions of correct guesses 
        	int index = tempPhrase.indexOf(c2);
        	correctPositions.add(index);
        	tempPhrase = tempPhrase.substring(0,index) + " " + tempPhrase.substring(index+1);
        }
		
    	int numberOfLetters = correctPositions.size(); 
    	for (Integer position : correctPositions) {
    		this.workingString = this.workingString.substring(0,position) + this.secretPhrase.charAt(position) + this.workingString.substring(position+1);
    		

		}
    	
		
		
		//Reveal correct characters
    	if (numberOfLetters == 0){//False guess
    		this.livesLeft -= 1;
    	}
    	
    	//System.out.println(this.workingString);
		this.guessedLetters.add(c);
		
    	if (this.workingString.equals(this.secretPhrase)) {//Phrase found!!!
    		this.won = true;
    		
    	}
    	
    	return numberOfLetters;
    }
    
    public boolean guessPhrase(String guess) {
    	//Description: takes a user input and checks if input guess is the same as the hidden phrase.
    	if (this.secretPhrase.toUpperCase(trLocale).equals(guess.toUpperCase(trLocale))) {
    		this.won = true;
    		return true;
    		
    	}else {
    		this.livesLeft -= 1;
    		return false;
    	}
    }
    
    


    
    public static boolean checkPhrase(String phrase) {//Only allow characters in charWhitelist
    	// Description: Checks if invalid characters were input as a custom phrase.
    	
    	phrase = phrase.toUpperCase(trLocale);
    	for(int i=0; i<phrase.length(); i++) {
    		if(charWhitelist.contains(phrase.charAt(i)) == false) { //If charWhitelist doesn't contain a character in phrase, then phrase has an illegal character.
    			return false;
    		}
    	}
    	return true;
    }
    
    public static boolean checkRevealedChars(String phrase) { //if phrase has a character other than characters in revealedChars return true
    	phrase = phrase.toUpperCase(trLocale);
    	for(int i=0; i<phrase.length(); i++) {
    		if(revealedChars.contains(phrase.charAt(i)) == false) { //If suggested phrase has characters other than the ones in revealedChars return true
    			return true;
    		}
    	}
    	return false;
    	
    } 
   
    

   
    
    static String generatePhrase(String theme) {
    	
    	//random.nextInt(x) returns number between o and x-1 (x not included)
    	switch(theme) {
	    	case "Sports":
	    		return phraseListSports[random.nextInt(phraseListSports.length)];
	
	    	case "Electronics":
	    		return phraseListElectronics[random.nextInt(phraseListElectronics.length)];
	    	case "Java":
	    		return phraseListJava[random.nextInt(phraseListJava.length)];
	    	case "Categry4":
	    		return phraseList4[random.nextInt(phraseList4.length)];
	    	case "Categry5":
	    		return phraseList5[random.nextInt(phraseList5.length)];
	    	case "Categry6":
	    		return phraseList6[random.nextInt(phraseList6.length)];
	    		
	    		
	    		
	    		
    	}
		return ""; //Not needed
    }
    

    public String getAnswer() {//Return answer
    	return this.secretPhrase;
    	
    }
    
    public void print() {
    	System.out.println("Guessed letters: " + this.guessedLetters.toString());
    	System.out.println("    " +this.category +" Category");
    	System.out.format("The current working phrase is: %s | You have %d live(s) left\n", this.workingString, this.livesLeft);
    }
    
    public static Character characterUpper(Character c) { //Fix upper Ä±, i conversion
    	if(c.equals('i')) {
    		return 'Ä';
    	}else {
    		return Character.toUpperCase(c);
    	}
    }
    

}