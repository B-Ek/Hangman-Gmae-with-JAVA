import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		
		Scanner keyboard = new Scanner(System.in);
		String[] options = new String[]{"Custom", "Sports", "Electronics", "Java", "Categry4", "Categry5", "Categry6"};
		Hangman game; //Polymorphism
		
		//Start
		System.out.println("Welcome to Hangman.");
		
		int difficulty;
		System.out.println("Please choose a difficulty:");
		while (true) {
			System.out.println("[1] Easy - 10 Lives");
			System.out.println("[2] Medium - 8 Lives");
			System.out.println("[3] Hard - 6 Lives");
			
			System.out.print(">");
			
			try {
				String diffInput = keyboard.nextLine();
				System.out.println();
				difficulty = Integer.valueOf(diffInput);
				
			}catch(Exception e) {
				System.out.println("Please enter a valid number!\n");
				continue;
			}
			
			if (difficulty <= 3 && difficulty >=1) {
				break;
			}else {
				System.out.println("Please choose a valid difficulty!\n");
			}
		}
		
		
		
		while (true) {//Main body
			//Menu Selection
			int chosenOption;
			
			System.out.println("Please choose a category to play:");
			
			while(true) {  
				
				for (int i=0; i<options.length; i++) {
					System.out.format("[%d] %s\n", i+1, options[i]);
				}
				System.out.print("> ");
				String option = keyboard.nextLine();
				//chosenOption = Integer.parseInt(option);
				try {
					chosenOption = Integer.valueOf(option);
				}catch(Exception e) {
					System.out.println("\nPlease enter a valid number!\n");
					continue;
				}
				
				 if(chosenOption <= options.length && chosenOption >= 1) {//Cheek if option is in range
					 chosenOption = chosenOption - 1; //Start from 0
					 break;
				 }else {
					 System.out.println("\nPlease choose a valid option!\n");
				 }
			}

			String phrase = "";
			if(options[chosenOption].equals("Custom")) {
				//Get custom passphrase
				
				while (true) {//Take phrase input and check
					System.out.print("Please enter the custom passphrase: ");
					phrase = keyboard.nextLine();
					
					
					if (phrase.length() <= 0) {// Deny empty string
						System.out.println("Please enter a passphrase!\n");
						continue;
					}
					
					
					
					//Check if phrase is only made up of spaces
					int spaceCount = 0;
					for (int i=0; i<phrase.length(); i++) {//Count spaces
						if (phrase.charAt(i) == ' ') {
							spaceCount++;
						}
					}
					if (phrase.length() == spaceCount) {//Phrase is made up of only spaces
						System.out.println("\nPassphrase can't be empty!\n");
						continue;
					}
					
					
					if(Hangman.checkPhrase(phrase) == false) { 
						System.out.println("\nString has invalid characters.");
						continue;
					}
					
					//Check if phrase has guessable characters checkRevealedChars
					
					if(Hangman.checkRevealedChars(phrase) == false) {
						System.out.println("\nString has nothing to guess.\n");
						continue;
					}
					
					break; //Got custom phrase
				}

				
			}
				
			if (difficulty == 1) {//Create new game with phrase based on the difficulty
				game = new HangmanEasy(options[chosenOption],phrase);
			}else if (difficulty == 2) {
				game = new HangmanMedium(options[chosenOption],phrase);
			}else {
				game = new HangmanHard(options[chosenOption],phrase);
			}
			
			
			for (int i=0;i<20;i++) {//Clear screen
				System.out.println();
			}
			
			System.out.format("The game has started with the %s category!\n", game.category);
			System.out.println("Keep guessing until you find the secret. Capitalization is not important.");
			System.out.println("Type !q to return to menu");
			
			
			
	        while (game.livesLeft >= 0){
	        	game.print();
	        	System.out.print("Enter a letter to be guessed or type !g to guess the complete phrase: ");
	        	
	        	
	            String stringInput = keyboard.nextLine();
	            System.out.println();
	            
	            if (stringInput.toLowerCase().equals("!q")) {
	            	System.out.println("Quitting to menu...\n");
	            	break;
	            }
	            
	            //Checking input
	            if (stringInput.toLowerCase().equals("!g")) {// Starting guess
	            	//Guessing complete phrase
	            	System.out.print("Enter complete phrase to be guessed or type !c to cancel:");
	            	String fullGuess = keyboard.nextLine();
	            	if (fullGuess.toLowerCase().equals("!c")) {
	            		System.out.println("Cancelled guess.");
	            		continue;
	            	}else {
	            		boolean fullGuessReturn = game.guessPhrase(fullGuess);
	            		if (fullGuessReturn) {// Correct guess
	            			System.out.println("Congratulations! your guess was right, You won!");
	            			break;
	            		}else {
	            			System.out.println("Sorry, your guess was incorrect.");
	            			continue;
	            		}
	            	}
	            }
	            
	            if(stringInput.length()!=1) {
	            	System.out.println("Please enter a single character");
	            	continue;
	            }
	            
	            Character characterToGuess = stringInput.charAt(0);
	            int lettersGuessed =game.guessLetter(characterToGuess);
	            
	            if (lettersGuessed > 1) {
	            	System.out.format("\nYou have correctly guessed %d letters!\n",lettersGuessed);
	            }else if (lettersGuessed == 1) {
	            	System.out.println("\nYou have correctly guessed 1 letter!");
	            }else if (lettersGuessed == 0){
	            	System.out.println("Sorry wrong guess");
	            }
	            
	            if (game.won) {
	            	System.out.println("YOU WON!");
	            	break;
	            }
	        }
	        

            System.out.println("\nGame over");
            System.out.format("The phrase was: \"%s\"\n",game.getAnswer());
	        
	        
	        System.out.print("Do you want to play again? (y)/(n): ");
	        String endInput = keyboard.nextLine();
	        
	        if(endInput.toLowerCase().equals("n")) {
	        	System.out.println("Thanks for playing!!");
	        	//return;
	        	System.exit(0);
	        	keyboard.close();
	        }
	        System.out.println();
			
		}
		
	}
	
	
	
}

