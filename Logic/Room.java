package Logic;

public class Room {
    public PuzzleList roomPuzzles;
    public int puzzleMin;
    public int puzzleMax;

    //contructor for the Room object, puzzlemin = 1, puzzleMax is the amount of puzzles that are in the room
    //ex. demo room has 2 puzzles
    public Room(int roomNumber) {
        if (roomNumber == 0) {
            puzzleMin=1;
            puzzleMax=2;
        }

        roomPuzzles = new PuzzleList(roomNumber);
    }
}