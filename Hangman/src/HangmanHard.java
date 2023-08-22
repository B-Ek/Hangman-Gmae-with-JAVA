
public class HangmanHard extends Hangman{
    public HangmanHard(String theme, String phrase){
    	super(theme, phrase);
    	this.livesLeft = 6;


    }
    
    public void print() {
    	
    	switch (this.livesLeft) {

			
		case 6:
			System.out.println("                   ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;
			
			
		case 5:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;
			
		case 4:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (   )     |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
			System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
	    	break;
	    	
		case 3:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (   )     |    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
	    	System.out.println("      |       |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;
			
			
		case 2:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (   )     |    ");
			System.out.println("      |       |    ");
			System.out.println("     /|\\      |    ");
			System.out.println("    / | \\     |    ");
	    	System.out.println("      |       |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;
			
		case 1:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (   )     |    ");
			System.out.println("      |       |    ");
			System.out.println("     /|\\      |    ");
			System.out.println("    / | \\     |    ");
	    	System.out.println("      |       |    ");
	    	System.out.println("       \\      |    ");
	    	System.out.println("        \\     |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;
			
		case 0:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (x x)     |    ");
			System.out.println("      |       |    ");
			System.out.println("     /|\\      |    ");
			System.out.println("    / | \\     |    ");
	    	System.out.println("      |       |    ");
	    	System.out.println("     / \\      |    ");
	    	System.out.println("    /   \\     |    ");
	    	System.out.println("              |    ");
	    	System.out.println("          =========");
			break;

		}
    	
    	if (this.livesLeft >= 0) {
    		super.print();
    	}
    }
    

}
