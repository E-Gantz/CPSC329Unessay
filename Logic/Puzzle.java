package Logic;

public class Puzzle {
    private int phase;  //phase of the puzzle, 0 is unsolved, 1 is solved, 2 means its not a puzzle but an examinable object.
    private String challengeText;   //the 'question' that gets output to the user.
    private String solvedText;  //solvedText is what the user sees when they correctly solve a puzzle the first time.
    private String rewardText;  //reward text is what the user sees when they try to examine a puzzle that has already been solved, i.e. it's their reward
    private String solution;    //the solution for the puzzle
    private String challengeName;   //the name of the puzzle, used for the '2. examine ______' part of the output when a user is selecting a puzzle to examine.
    private String hintText1;   //regular hint
    private String hintText2;   //super hint
    private String incorrectText;   //the text output when the user inputs the incorrect answer, defaults to incorrect! and can be overwritten per puzzle for a custom output.

    //how to add a new puzzle:add the puzzle here with its texts and solution, create new puzzle object (ex. p1, puzzle 1) in puzzleList if this puzzle's number is higher than the highest already in puzzleList (currently 4) as well as getPuzzle, then update the puzzleMax in Room
    public Puzzle(int roomNumber, int puzzleNumber) {
        //demo room puzzles
        incorrectText = "Incorrect!";
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

        else if (roomNumber == 1 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the books";
            challengeText = "“Passwords and You: A Digest”. It is a collection of articles and statements pertaining to password and password protection. As to why such a book was published, you have no idea. Upon flipping through the book, one statement says:\n“Make sure you change your combination upon purchase. Most 5-number locks have a default combination that is very simple. However, to prevent easy access, the following riddle must be solved:\nThe 5 digits are 1, 2, 3, 4, and 5, but not necessarily in that order.\nThe first digit plus the second digit equals the third digit.\nThe second digit is double the first digit.\nThe second digit is half the fourth digit.\nThe fifth digit is the sum of the first and fourth digits.\nYou continue reading.\n“When using a text-based password, it is recommended to have the following:\nYou must have between 7-16 characters.\nIt must contain a capital and lowercase letter.\nIt can contain up to 3 numbers.\nIt must contain a special character (Like ‘!’, for example)\nMake sure it is memorable. A name of a loved one is recommended.\nThe book notes that very often it is sufficient to add a sequence of digits and a symbol, for example '12!' onto the end of some word or name to create a password.\nWhile you doubt the author’s purpose into writing these guidelines, considering all are stupid in every respect, you imagine the password creator must literally be the most lazy person ever, it does get a laugh out of you, through sheer enjoyment or agony, you cannot tell.\nThe last statement you found interesting was as follows:\n“Hashing is one method of encrypting passwords, and is considered widely popular among authentication services. One common algorithm back in the day is MD5 hashing, which was used to encrypt most passwords.”\nWhile true, this is easily decoded as long as you have the internet at your side.";
        }
        else if (roomNumber == 1 && puzzleNumber == 2){
            phase = 0;
            challengeName = "the box";
            challengeText = "A simple locked box. It seems attached to the floor, and you cannot hope to move it. On the black box is a simple 5-number combination lock.\nPerhaps if you figure out the lock combination, the box can be opened. You assume, anyways.";
            hintText1 = "Where have you heard about these combinations before?";
            hintText2 = "The books say something about these things, don’t they? try pages 1 to 5";
            solvedText = "After aligning the numbers and a quick tug on the lock, a ‘click’ sound is heard as you pop the LOCK off of the BOX. After unlocking the box, you peer into it. You see a small book inside.\nThe book is actually a small pamphlet of a small size.\n“You won’t BELIEVE these 50 AMAZING Dog Facts! You can’t guess the Last 3!”\nWell, the nerve of this author! You’ll show them! You decide to read those last 3 facts to disprove that phony author.\nFact 48: The Beatles song ‘A Day in the Life’ has a frequency only dogs can hear.\nFact 49: Dogs are colorblind, the most common type in humans, is red-green colorblindness. At least they can see blue!\nFact 50: Three dogs survived the Titanic sinking.";
            rewardText = "You look at the small book about dog facts, it reads:\nFact 48: The Beatles song ‘A Day in the Life’ has a frequency only dogs can hear.\nFact 49: Dogs are colorblind, the most common type in humans, is red-green colorblindness. At least they can see blue!\nFact 50: Three dogs survived the Titanic sinking.";
            solution = "12345";
            incorrectText = "You attempt to open the lock with your guess, but the lock remains stalwart in your attempts.";
        }
        else if (roomNumber == 1 && puzzleNumber == 3){
            phase = 0;
            challengeName = "the text on the walls";
            challengeText = "Various sections of text are sprawled along the walls of the room, each in different colours. They read:\n“82a08dfbbc2a9515bc6962cd307507cd” is in the color Red\n“8fb645e200b5986d7cdfb4a5d2542a7f” is in the color Green\n“6d309d764aefcda1d279eb3a32d3e7f7” is in the color Blue\nYou realise the writing must be a code for something, if only you knew how to Decode it.";
            hintText1 = "the book includes a hashbrown or something, doesn’t it?";
            hintText2 = "Your answer must be in the form Decode Algorithm";
            solvedText = "you attempt to decode the message. Afterwards, the following is shown:\n“Max” is in the color Red\n“Buddy” is in the color Green\n“Mocha” is in the color Blue";
            rewardText = "you look back at the messages you decoded:\n“Max” is in the color Red\n“Buddy” is in the color Green\n“Mocha” is in the color Blue";
            solution = "decode md5";
            incorrectText = "Your solution was not correct, perhaps you should try a decode algorithm";
        }
        else if (roomNumber == 1 && puzzleNumber == 4){
            phase = 0;
            challengeName = "the terminal";
            challengeText = "You view the terminal, a plain keyboard attached to it. It still has the following prompt in plain white text: “PASSWORD:”";
            hintText1 = "Did you decode something? Did your dog decode something?";
            hintText2 = "One of the books you read said something about passwords didn't it? You also may have decoded a name or three.";
            solvedText = "After typing in your answer and pressing enter, the following is printed: “Correct. Puzzle solved.”";
            rewardText = "The terminal still says“Correct. Puzzle solved.”";
            solution = "mocha12!";
            incorrectText = "After typing in your answer and pressing enter, the following is printed: “Incorrect. Try again.” And then returns to the previous prompt.";
        }
    }


    /*
    else if (roomNumber == x && puzzleNumber == y){
            phase = 0;
            challengeName = "";
            challengeText = "";
            hintText1 = "";
            hintText2 = "";
            solvedText = "";
            rewardText = "";
            solution = "";
            incorrectText = "";
        }
    else if (roomNumber == x && puzzleNumber == y) {
            phase = 2;
            challengeName = "";
            challengeText = "";
        }*/

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

    public String getIncorrectText() {
        return incorrectText;
    }

    //setter methods
    public void setNewPhase(int newPhase) {
        phase = newPhase;
    }

}