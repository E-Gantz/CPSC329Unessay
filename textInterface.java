import java.util.Scanner;
import Logic.*;

public class textInterface {
    private Room currentRoom;
    private int roomNumber;
	private int puzzleChoice;
	private String puzzleActualAnswer;
	private String puzzleUserAnswer;

	public static void main (String[] args) {
        textInterface ti1 = new textInterface();
		ti1.play();
    }

	//constructor, does all the one time operations at the start(whatever that ends up being) and starts up the first room.
	public textInterface() {
        //0 for demo room, 1 for actual gameplay
        roomNumber=0;
        currentRoom = new Room(roomNumber);
    }
    
	//main gameplay loop.
	public void play() {
		boolean stillPlaying = true;
		boolean roomFinished = false;
		entryMessage(roomNumber);
		while (stillPlaying == true) {
			printOptions();
			puzzleChoice = chooseIntOption();
			while(puzzleChoice < currentRoom.puzzleMin || puzzleChoice > ((currentRoom.puzzleMax) + 2)) {
				System.out.println("please enter a valid choice.");
				puzzleChoice = chooseIntOption();
			}
			if (puzzleChoice == (currentRoom.puzzleMax) + 2) {
				stillPlaying = false;
			}
			else if (puzzleChoice == (currentRoom.puzzleMax) + 1 ) {
				if (roomFinished == false) {
					System.out.println("you cannot currently exit the room");
				}
				else if (roomNumber == 0 || roomNumber == 3) {
					System.out.println("You were able to exit the room.");
					System.out.println("Congratulations, you have escaped!");
					stillPlaying = false;
				}
				else {
					roomNumber++;
					entryMessage(roomNumber);
				}
			}
			else {
				if (currentRoom.roomPuzzles.getPhase(roomNumber, puzzleChoice) == 0) {
					tryPuzzle(puzzleChoice);
					roomFinished = !(completionTest());
				}
				else {printPuzzleText(puzzleChoice);}
			}
		}
		System.out.println("This concludes the demo");
    }

	public void tryPuzzle(int puzzleChoice) {
		printPuzzleText(puzzleChoice);
		puzzleActualAnswer = currentRoom.roomPuzzles.getSolution(roomNumber, puzzleChoice);
		boolean stillGuessing = true;
		while (stillGuessing == true) {
			puzzleUserAnswer = chooseStringOption();
			if (puzzleUserAnswer.equals("exit")) {
				stillGuessing = false;
			}
			else if (puzzleUserAnswer.equals(puzzleActualAnswer)) {
				currentRoom.roomPuzzles.setPhase(roomNumber, puzzleChoice, 1);
				System.out.println(currentRoom.roomPuzzles.getSolvedText(roomNumber, puzzleChoice));
				stillGuessing = false;
			}
			else {
				System.out.println("Incorrect! enter 'exit' if you would like to return to the previous menu");
			}
		}
	}

	public boolean completionTest() {
		Boolean uncomplete = true;
		int i;
        for (i = currentRoom.puzzleMin;i <= currentRoom.puzzleMax; i++) {
            if (currentRoom.roomPuzzles.getPhase(roomNumber, i) == 0) {
				uncomplete = true;
				i = currentRoom.puzzleMax;
			}
			else {
				uncomplete = false;
			}
		}
		if(uncomplete == false) {
			System.out.println("you hear a click come from somewhere in the room, as if something has unlocked");
		}
		return uncomplete;
	}

    public void printPuzzleText(int puzzleChoice) {
        System.out.println(currentRoom.roomPuzzles.getText(roomNumber, puzzleChoice));
    }

    public void printOptions(){
		int i;
		System.out.println("Please choose one of the following options:");
        for (i = currentRoom.puzzleMin;i <= currentRoom.puzzleMax; i++) {
            System.out.println(Integer.toString(i)+". Examine "+currentRoom.roomPuzzles.getName(roomNumber, i));
		}
		System.out.println(Integer.toString(i)+ ". Try to exit the room and move to the next room");
		System.out.println(Integer.toString(i+1)+ ". Give up");
    }
    /*
	entryMessage is used to display an entry message when the player enters a new room.
	the purpose of the roomNumber is to keep track of which room they are in.
	*/
	public void entryMessage(int roomNumber) {
		if (roomNumber == 0) {
			System.out.println("You step into the demo room.");
		}
		else if (roomNumber == 1){
			System.out.println("You step into the first room.");
		} else if (roomNumber == 2) {
			System.out.println("You step into the second room.");
		} else if (roomNumber == 3) {
			System.out.println("You step into the third room.");
		}
	}

	//chooseIntOption is used when we need the player to enter an integer as input.
	public int chooseIntOption() {
		Scanner keyboard1 = new Scanner(System.in);
		
		while (!keyboard1.hasNextInt()){
				keyboard1.next();
				System.out.println("Please enter a number: ");
			}
		
		int pickedOption = keyboard1.nextInt();
		return pickedOption;
		
	}
	
	//chooseStringOption is used when we need the player to enter a string as input.
	public String chooseStringOption() {
		Scanner keyboard2 = new Scanner(System.in);
		
		while (!keyboard2.hasNextLine()){
				keyboard2.next();
				System.out.println("Please enter a string: ");
			}
		
		String pickedOption = keyboard2.nextLine();		
		return pickedOption;
		
	}
}