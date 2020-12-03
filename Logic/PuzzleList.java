package Logic;

public class PuzzleList {
    //list of puzzles, these can be hard coded instead of using IO because in a real escape room the puzzles are not changed, as they are physically built in a space.
    //list of puzzles, p0 to px, where a room has x puzzles in it, puzzle 0 is a default puzzle used in case of error.
    Puzzle p0;
    Puzzle p1;
    Puzzle p2;
    Puzzle p3;
    Puzzle p4;
    Puzzle p5;

    //constructor for the puzzleList object, sets the puzzles according to which room is being constructed.
    public PuzzleList(int roomNumber) {
        p0 = new Puzzle(0);
        if (roomNumber == 0) {
            p1 = new Puzzle(roomNumber, 1);
            p2 = new Puzzle(roomNumber, 2);
            p3 = new Puzzle(roomNumber, 3);
        }
        else if (roomNumber == 1) {
            p1 = new Puzzle(roomNumber, 1);
            p2 = new Puzzle(roomNumber, 2);
            p3 = new Puzzle(roomNumber, 3);
            p4 = new Puzzle(roomNumber, 4);
        }
        else if (roomNumber == 2) {
            p1 = new Puzzle(roomNumber, 1);
            p2 = new Puzzle(roomNumber, 2);
            p3 = new Puzzle(roomNumber, 3);
            p4 = new Puzzle(roomNumber, 4);
            p5 = new Puzzle(roomNumber, 5);
        }
        else if (roomNumber == 3) {
            p1 = new Puzzle(roomNumber, 1);
            p2 = new Puzzle(roomNumber, 2);
        }
        else if (roomNumber == 4) {
            p1 = new Puzzle(roomNumber, 1);
            p2 = new Puzzle(roomNumber, 2);
            p3 = new Puzzle(roomNumber, 3);
        }

        
    }

    //returns the chosen puzzle in this room.
    public Puzzle getPuzzle(int puzzleChoice) {
        if (puzzleChoice == 1) {
            return p1;
        }
        else if (puzzleChoice == 2) {
            return p2;
        }
        else if (puzzleChoice == 3) {
            return p3;
        }
        else if (puzzleChoice == 4) {
            return p4;
        }
        else if (puzzleChoice == 5) {
            return p5;
        }
        else {return p0;}
    }

}