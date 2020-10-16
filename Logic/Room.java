package Logic;

public class Room {
    public PuzzleList roomPuzzles;
    public int puzzleMin;
    public int puzzleMax;


    public Room(int roomNumber) {
        if (roomNumber == 0) {
            puzzleMin=1;
            puzzleMax=2;
        }

        roomPuzzles = new PuzzleList(roomNumber);
    }
}