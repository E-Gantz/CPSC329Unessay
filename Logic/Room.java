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
        roomNumber = roomNumberInput;
        roomPuzzles = new PuzzleList(roomNumber);
    }
}