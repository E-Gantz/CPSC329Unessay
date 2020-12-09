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
        else if (roomNumberInput == 2) {
            puzzleMin=1;
            puzzleMax=5;
            entryText = "You walk into a large room. The room is a regular hexagonal shape, with six walls around. The ROOM is clearly marked in six different colours, with a low-saturated rainbow in each section, changing clockwise. A chandelier hangs in the ceiling, the six bulbs in a corresponding colour to the room. \nIn the center is a similarly hexagonal pedestal, risen to the bottom of your ribs, large enough to seat a person on each side. Laid in the PEDESTAL are a series of KEYHOLEs, spread apart evenly across the surface, with each point perpendicular to its corresponding wall, barring one directed at the opposing door, a KEYBOARD in its place. \nIn the center is a sheet of paper. On one side seems to be conversion TABLE of sorts. ";
        }
        else if (roomNumberInput == 3) {
            puzzleMin=1;
            puzzleMax=2;
            entryText = "Upon entering the first of the wedge rooms, you decide to read the first scroll. It reads:\n“Chapter 1: Eve needed something from her drawer first, however, to find out what was in that box. Unfortunately, that certain drawer is locked. Thankfully, she knows how to gain entrance to the contents of that locker. With her trusty toolkit in hand, she was confident that getting into the locker would be no problem.”\nYou note that there's a rip across the bottom of the scroll, as if it's missing a piece.\nThe room section is a wedge in a red hue. There is a multi-layered DRAWER with a TOOLKIT of some sort on top.";
        }
        else if (roomNumberInput == 4) {
            puzzleMin=1;
            puzzleMax=3;
            entryText = "Upon entering the second of the wedge rooms, you decide to read the second scroll. It reads:\n“Chapter 2: With her special tool in hand, Eve went to her front door. Upon opening it, she found something in her letterbox. It was written by Alice! What a surprise! \nUpon seeing her name, Eve set about to opening the letter as fast as she could. However, upon opening it, she found a simple folded card, with no graphic of any sort, along with a keycard. She began reading.\n‘Hello Eve! This is a special card meant exclusively for you. Bob was supposed to get one as well, but, well, someone did an oopsie, and now there is only one card. Please share this card with Bob when you have the chance. \nPlease remember, there is a key to it (A key to a keycard! Isn’t that crazy?), such that only one of you can use it. So, whether it is me, you, Bob, Or anyone else, they have Exclusive rights to that card!’\nEve, being the ever curious person that she is, decided to hold off on the box heist for but a brief moment. This is her card, after all. Who would know what is inside? Eve would, that is who.\n The room section is a wedge in an orange hue. On the wall is a large number of SWITCHES. There is two PLAQUES on each side";
        }
        else if (roomNumberInput == 5) {
            puzzleMin=1;
            puzzleMax=3;
            entryText = "As you enter the third wedge room you whip out the third scroll. \n“Chapter 3: Back to the task at hand, Eve proceeded to claim the box on Bob’s doorstep. Walking across the street, Eve approached Bob’s house. \nIn front of the entrance lies Alice’s box for Bob. What mysteries could be inside, Eve wonders. Thankfully, neither Alice nor Bob was present at the moment, so she could swiftly take the box and examine its contents at her leisure. However, the box was locked, as it always has been whenever Alice gives the box to Bob. \nBut, thanks to Eve’s nature in spying, she knows how to unlock it. Taking out her decoder, she begins to unlock the box. Now, how to use it? She remembers Alice and Bob’s most recent conversation, at Eve’s place. Something about the bottom of your bottom, at least, that’s what it sounded like.”\nThe section is a wedge in a dull yellow hue, only the residual light from the other sections entering the space. The simple wooden CHAIR is placed in the center of the section, with a TELEVISION in front. On the wall is a DIAL of sorts.";
        }
        else if (roomNumberInput == 6) {
            puzzleMin=1;
            puzzleMax=4;
            entryText = "You walk into the fourth wedge room, scroll already in hand. \n“Chapter 4: With the object at hand, Eve went over to Alice’s house. Whatever could Alice be planning, Eve could not tell. \nBefore she could enter, however, Alice left a note for Eve on the front door. Eve wonders why Alice would go through all this trouble, if Alice could just tell her herself? Maybe she could have given her a box as well, wouldn’t that be something. On the note reads:\n“Hello again Eve! This will be the last thing, I promise! Remember that thing I gave you as a letter? Yes, it’s that card. You’re going to use it to get in my house. Think of that card as lending my key to you, except it’s One-Time only. Though, I think something went wrong with the key, I don’t think there should be over twenty of them.”\nThe section is a wedge in a green hue. In front of you are three TABLES, each one behind the other, a PANEL of buttons are placed on the wall.";
        }
        else if (roomNumberInput == 7) {
            puzzleMin=1;
            puzzleMax=3;
            entryText = "You stride into the fifth and final wedge room, bumping into the doorframe as you are already reading the fifth scroll.\n“Chapter 5: Having arrived at Alice’s house, Eve wonders where Alice could be. Having stepped inside, the house was completely blank, save for the kitchen, with a lone light overhead. \nEntering the room, she finds the spotlight shining upon a singular spot, with a folded piece of paper, saying, “Read me!” Having to put down the cake, Eve placed it onto the table, and read the piece of paper.\n“Hi Eve! If you’re reading this, then we’re late! So sorry! Just bring the cake to the basement, and we’ll be right over! - Alice”\nEve sighs at the letter. She hasn’t seen Alice all day, granted, she was trying to figure out what was in Alice and Bob’s box, but even so, the day was almost over, to give such an attempt. She took the cake in hand and went downstairs. \nHowever, the door was locked with a 4 number PIN code. ‘1234’? Eve thought. It wasn’t. In frustration, she sat down next to the table, simply waiting for Alice to arrive. She then noticed some other writing on the note.\n“Oh right, you don’t know the passcode. This is something only I can Write down, and I will only let myself and my friends, that’s the group, so, me, Bob, and you, to Read it. Anyone can eXecute this code into the lock though…”";
        }
        roomNumber = roomNumberInput;
        roomPuzzles = new PuzzleList(roomNumber);
    }
}

//Template:
/*else if (roomNumberInput == x) {
    puzzleMin=1;
    puzzleMax=y;
    entryText = "";
}*/