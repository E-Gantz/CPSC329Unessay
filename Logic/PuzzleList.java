package Logic;

public class PuzzleList {
    Puzzle r0p1;
    Puzzle r0p2;

    public PuzzleList(int roomNumber) {
        if (roomNumber == 0) {
            r0p1 = new Puzzle(roomNumber, 0);
            r0p2 = new Puzzle(roomNumber, 1);
        }
        else if (roomNumber == 1) {

        }
        else if (roomNumber == 2) {
            
        }
        else if (roomNumber == 3) {
            
        }

        
    }

    public void setPhase(int roomNumber, int puzzleChoice, int newPhase){
        if (roomNumber == 0 && puzzleChoice == 1) {
            r0p1.setNewPhase(1);
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            r0p2.setNewPhase(1);
        }
    }

    public int getPhase(int roomNumber, int puzzleChoice) {
        if (roomNumber == 0 && puzzleChoice == 1) {
            return r0p1.getPhase();
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            return r0p2.getPhase();
        }
        else {return 0;}
    }

    public String getSolvedText(int roomNumber, int puzzleChoice) {
        if (roomNumber == 0 && puzzleChoice == 1) {
            return r0p1.getSolvedText();
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            return r0p2.getSolvedText();
        }
        else {return "whoops";}
    }

    public String getText(int roomNumber, int puzzleChoice) {
        if (roomNumber == 0 && puzzleChoice == 1) {
            return r0p1.getPuzzleText();
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            return r0p2.getPuzzleText();
        }
        else {return "whoops";}
    }

    public String getName(int roomNumber, int puzzleNumber) {
        if (roomNumber == 0 && puzzleNumber == 1) {
            return r0p1.getChallengeName();
        }
        else if (roomNumber == 0 && puzzleNumber == 2) {
            return r0p2.getChallengeName();
        }
        else {return "whoops";}

    }

    public String getChallenge(int roomNumber, int puzzleChoice) {
        if (roomNumber == 0 && puzzleChoice == 1) {
            return r0p1.getChallengeText();
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            return r0p2.getChallengeText();
        }
        else {return "whoops";}
    }

    public String getSolution(int roomNumber, int puzzleChoice) {
        if (roomNumber == 0 && puzzleChoice == 1) {
            return r0p1.getSolution();
        }
        else if (roomNumber == 0 && puzzleChoice == 2) {
            return r0p2.getSolution();
        }
        else {return "whoops";}
    }


}