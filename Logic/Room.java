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
            roomNumber = roomNumberInput;
            entryText = "You walk into the Demo room.";
        }

        roomPuzzles = new PuzzleList(roomNumber);
    }
}