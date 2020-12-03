package Logic;

public class Puzzle {
    private int phase;  //phase of the puzzle, 0 is unsolved, 1 is solved, 2 means its not a puzzle but an examinable object.
    private String challengeText;   //the 'question' that gets output to the user.
    private String solvedText;  //solvedText is what the user sees when they try to examine a puzzle that has already been solved
    private String rewardText;  //reward text is what the user sees when they correctly solve a puzzle
    private String solution;    //the solution for the puzzle
    private String challengeName;   //the name of the puzzle, used for the '2. examine ______' part of the output when a user is selecting a puzzle to examine.
    private String hintText1;   //regular hint
    private String hintText2;   //super hint

    //how to add a new puzzle:add the puzzle here with its texts and solution, create new puzzle object (ex. p1, puzzle 1) in puzzleList if this puzzle's number is higher than the highest already in puzzleList (currently 3), then update the puzzleMax in Room
    public Puzzle(int roomNumber, int puzzleNumber) {
        //demo room puzzles
        if (roomNumber == 0 && puzzleNumber == 1){
            phase = 0;
            challengeName = "the first demo puzzle";
            challengeText = "what is 2+2?";
            hintText1 = "try doing addition";
            hintText2 = "the answer is 4";
            solvedText = "You are correct!";
            rewardText = "You sure did figure this one out";
            solution = "4";
        } 
        else if (roomNumber == 0 && puzzleNumber == 2){
            phase = 0;
            challengeName = "the second demo puzzle";
            challengeText = "what is 3+3?";
            hintText1 = "try doing addition";
            hintText2 = "the answer is 6";
            solvedText = "You are correct!";
            rewardText = "You sure did figure this one out";
            solution = "6";
        } 
        else if (roomNumber == 0 && puzzleNumber == 3) {
            phase = 2;
            challengeName = "the picture on the wall";
            challengeText = "the picture is a poster of a cat, saying 'Math is Fun!'";
        }

        //puzzles for other rooms go here
    }

    //constructor for puzzle 0, which is used for errors.
    public Puzzle(int defaultNum) {
        phase = 2;
        challengeName = "the whoopsies puzzle";
        challengeText = "whoopsies";
    }

    //getter methods
    public String getChallengeName() {
        return challengeName;
    }

    public int getPhase() {
        return phase;
    }

    public String getPuzzleText() {
        if (phase == 0 || phase == 2) {
            return getChallengeText();
        }
        if (phase == 1) {
            return getRewardText();
        }
        else {return "whoops!";}
    }

    public String getChallengeText() {
        return challengeText;
    }

    public String getSolvedText() {
        return solvedText;
    }

    public String getRewardText() {
        return rewardText;
    }

    public String getSolution() {
        return solution;
    }

    public String getHint1() {
        return hintText1;
    }

    public String getHint2() {
        return hintText2;
    }

    //setter methods
    public void setNewPhase(int newPhase) {
        phase = newPhase;
    }

}