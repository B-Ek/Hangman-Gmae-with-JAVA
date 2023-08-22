
public class HangmanEasy extends Hangman{
    public HangmanEasy(String theme, String phrase){
    	super(theme, phrase);
    	this.livesLeft = 10;

    }
    
    public void print() {
    	switch (this.livesLeft) {
		case 10:
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("          _________");
			break;
    	
		case 9:
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
			System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("                   ");
	    	System.out.println("          =========");
			break;
			
		case 8:
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
			
		case 7:
			System.out.println("      _________    ");
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
			
		case 6:
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
			
		case 5:
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
	    	
		case 4:
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
			
		case 3:
			System.out.println("      _________    ");
			System.out.println("      |       |    ");
			System.out.println("      |       |    ");
			System.out.println("    (   )     |    ");
			System.out.println("      |       |    ");
			System.out.println("      |\\      |    ");
			System.out.println("      | \\     |    ");
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
