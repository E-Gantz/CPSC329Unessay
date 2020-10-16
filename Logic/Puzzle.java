package Logic;

public class Puzzle {
    private int phase;
    private String challengeText;
    private String solvedText;
    private String rewardText;
    private String solution;
    private String challengeName;

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