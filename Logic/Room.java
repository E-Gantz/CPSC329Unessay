package Logic;

public class Room {
    public PuzzleList roomPuzzles;  //the list of puzzles for this room
    public int puzzleMin;   //the minimum amount of puzzles in this room, should always be 1
    public int puzzleMax;   //the maximum amount of puzzles in this room
    public int roomNumber;  //which room we're in
    public String entryText;    //the 'welcome' text shown upon first entering a room

    //contructor for the Room object, puzzlemin = 1, puzzleMax is the amount of puzzles that are in the room
    //ex. demo room has 2 puzzles and 1 examinable object
    public Room(int roomNumberInput) {
        if (roomNumberInput == 0) {
            puzzleMin=1;
            puzzleMax=3;
            entryText = "You walk into the Demo room.";
        }
        else if (roomNumberInput == 1) {
            puzzleMin=1;
            puzzleMax=4;
            entryText = "You walk into the first room.\nThe walls are matte black, with randomized TEXT sprawled along them. In front of you is a simple TERMINAL, with the single prompt in plain white text: “PASSWORD:”. \nTo your right is a small rectangular black BOX. A LOCK is placed on it, and the BOX is immovable. On your left is a stack of BOOKS of various sizes and lengths.";
        }
        roomNumber = roomNumberInput;
        roomPuzzles = new PuzzleList(roomNumber);
    }
}