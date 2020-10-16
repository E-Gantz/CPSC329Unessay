package Logic;

public class Puzzle {
    private int phase;  //phase of the puzzle, 0 is unsolved, 1 is solved, 2 means its not a puzzle but an examinable object.
    private String challengeText;   //the 'question' that gets output to the user.
    private String solvedText;  //solvedText is what the user sees when they try to examine a puzzle that has already been solved
    private String rewardText;  //reward text is what the user sees when they correctly solve a puzzle
    private String solution;    //the solution for the puzzle
    private String challengeName;   //the name of the puzzle, used for the '2. examine ______' part of the output when a user is selecting a puzzle to examine.

    public Puzzle(int roomNumber, int puzzleNumber) {
        phase = 0;
        if (roomNumber == 0 && puzzleNumber == 0){
            challengeName = "the first demo puzzle";
            challengeText = "what is 2+2?";
            solvedText = "You are correct!";
            rewardText = "You sure did figure this one out";
            solution = "4";
        } 
        else if (roomNumber == 0 && puzzleNumber == 1){
            challengeName = "the second demo puzzle";
            challengeText = "what is 3+3?";
            solvedText = "You are correct!";
            rewardText = "You sure did figure this one out";
            solution = "6";
        } 
    }





    //getter methods
    public String getChallengeName() {
        return challengeName;
    }

    public int getPhase() {
        return phase;
    }

    public String getPuzzleText() {
        if (phase == 0) {
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

    //setter methods
    public void setNewPhase(int newPhase) {
        phase = newPhase;
    }

}