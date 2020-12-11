import java.util.Scanner;
import Logic.*;
import java.io.*;

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
        roomNumber=1;
        currentRoom = new Room(roomNumber);
    }
    
	//main gameplay loop.
	public void play() {
		boolean stillPlaying = true;
		boolean roomFinished = false;
		entryMessage();
		while (stillPlaying == true) {
			//print all the puzzle options.
			printOptions();
			//user chooses which puzzle option they want to examine
			puzzleChoice = chooseIntOption();
			//reprompt for input if user gave invalid input
			while(puzzleChoice < currentRoom.puzzleMin || puzzleChoice > ((currentRoom.puzzleMax) + 2)) {
				System.out.println("please enter a valid choice.");
				puzzleChoice = chooseIntOption();
			}
			//quit the game if user chose to give up
			if (puzzleChoice == (currentRoom.puzzleMax) + 2) {
				stillPlaying = false;
			}
			//if user chose the exit the room option but they havent completed all the puzzles, tell them they cannot exit
			else if (puzzleChoice == (currentRoom.puzzleMax) + 1 ) {
				if (roomFinished == false) {
					System.out.println("you cannot currently exit the room");
				}
				//if they have completed all the puzzles and are in the demo room, room 0, or the last room, (currently) room 4, then they have won and get to escape
				else if (roomNumber == 0 || roomNumber == 8) {
					System.out.println("You were able to exit the room.");
					System.out.println("Congratulations, you have escaped!");
					stillPlaying = false;
				}
				//if they have completed all the puzzles but arent in the demo room or last room, move to the next room, print the intro message for the next room.
				else {
					roomNumber++;
					currentRoom = new Room(roomNumber);
					entryMessage();
					//set room = new room(new roomnumber)
				}
			}
			//if user chose a puzzle option that wasnt give up or try to move to the next room, then they chose to examine a puzzle.
			else {
				//if they haven't already completed the puzzle then let them try
				if (currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getPhase() == 0) {
					tryPuzzle(puzzleChoice);
					roomFinished = !(completionTest());
				}
				//if the user is examining an object that isnt a puzzle but is just something to look at, then just print the description.
				else if (currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getPhase() == 2) {
					printPuzzleText(puzzleChoice);
				}
				//if they have already completed the puzzle then give them the output that reminds them of what they learned from completing that puzzle.
				else {printPuzzleText(puzzleChoice);}
			}
		}
		System.out.println("This concludes the Game");
    }

	//takes which puzzle option the user gave as input, prints the puzzle's challenge, and lets them guess the answer, exit back to the previous menu, or get a hint
	public void tryPuzzle(int puzzleChoice) {
		printPuzzleText(puzzleChoice);
		puzzleActualAnswer = currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getSolution();
		boolean stillGuessing = true;
		while (stillGuessing == true) {
			puzzleUserAnswer = chooseStringOption();
			//back to previous menu
			if (puzzleUserAnswer.equals("exit")) {
				stillGuessing = false;
			}
			//give normal hint
			else if (puzzleUserAnswer.equals("hint")){
				System.out.println(currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getHint1());
			}
			//give super hint
			else if (puzzleUserAnswer.equals("super hint")){
				System.out.println(currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getHint2());
			}
			//they input the correct answer, so set this puzzles phase to 1 for solved, print the first time solution text
			else if (puzzleUserAnswer.equals(puzzleActualAnswer)) {
				currentRoom.roomPuzzles.getPuzzle(puzzleChoice).setNewPhase(1);
				System.out.println(currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getSolvedText());
				stillGuessing = false;
			}
			else {
				System.out.println(currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getIncorrectText());
				System.out.println("Enter 'exit' to return the previous menu, 'hint' for a hint, or 'super hint' for an extra helpful hint");
			}
		}
	}

	//test if the user has completed all the puzzles in the current room.
	public boolean completionTest() {
		Boolean uncomplete = true;
		int i;
		//if any puzzles are in phase 0 then there's at least 1 puzzle unifinished, so the room is not complete
        for (i = currentRoom.puzzleMin;i <= currentRoom.puzzleMax; i++) {
            if (currentRoom.roomPuzzles.getPuzzle(i).getPhase() == 0) {
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

	//prints the puzzle's current output text.
    public void printPuzzleText(int puzzleChoice) {
        System.out.println(currentRoom.roomPuzzles.getPuzzle(puzzleChoice).getPuzzleText());
    }

	//prints all the puzzle options that the user can examine, including the try to exit and give up options.
    public void printOptions(){
		int i;
		System.out.println("Please choose one of the following options:");
        for (i = currentRoom.puzzleMin;i <= currentRoom.puzzleMax; i++) {
            System.out.println(Integer.toString(i)+". Examine "+currentRoom.roomPuzzles.getPuzzle(i).getChallengeName());
		}
		System.out.println(Integer.toString(i)+ ". Try to exit the room and move to the next room");
		System.out.println(Integer.toString(i+1)+ ". Give up");
	}
	
    /*
	entryMessage is used to display an entry message when the player enters a new room.
	the purpose of the roomNumber is to keep track of which room they are in.
	*/
	public void entryMessage() {
		System.out.println(currentRoom.entryText);
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
		
		String pickedOption = keyboard2.nextLine().toLowerCase();		
		return pickedOption;
		
	}
}