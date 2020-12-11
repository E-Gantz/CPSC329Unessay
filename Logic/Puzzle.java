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

    //how to add a new puzzle:add the puzzle here with its texts and solution, create new puzzle object (ex. p1, puzzle 1) in puzzleList if this puzzle's number is higher than the highest already in puzzleList (currently 5) as well as getPuzzle, then update the puzzleMax in Room
    public Puzzle(int roomNumber, int puzzleNumber) {
        /* you may be wondering: Why are these all hard coded, when IO could be used?
            well, the justification is that real life escape rooms are physically built in a room, and are very rarely changed or updated
            so, in a way, real life escape rooms are also hard coded
        */

        incorrectText = "Incorrect!";   //default setting
        hintText1 = "No hints for this one";    //default setting
        hintText2 = "No super hint available, sorry chief"; //default setting, chief

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

        //room 1
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

        //room 2
        else if (roomNumber == 2 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the table";
            challengeText = "It appears to be a conversion table, in which different numbers could be converted to other different numbers… you suppose.\nhttp://www.asciitable.com/\nThank heavens you actually understand this, however, for the uninitiated, there are also a set of INSTRUCTIONS written below the table.";
        }
        else if (roomNumber == 2 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the instructions";
            challengeText = "There are four main columns you should be concerned about.\nThere is decimal, ‘Dec’, in base 10, which are standard counting numbers, which have no prefix.\nThere is octet, ‘Oct’, in which the base number is 8, most notably used in permission notations, and has the ‘0o’ prefix.\nThere is hex, ‘Hx’, in base 16, usually used to simplify notations, occasionally used in colours, with the ‘0x’ prefix.\nLastly is ‘Char’, which relates to ASCII, used in basic text.";
        }
        else if (roomNumber == 2 && puzzleNumber == 3) {
            phase = 2;
            challengeName = "the pedestal";
            challengeText = "On the hexagonal pedestal is five KEYHOLES of similar size, split evenly across the six sections of the room, barring one section facing the opposite door, in which a KEYBOARD is placed, and a simple screen above it. There is also a piece of paper which has a conversion TABLE placed on it. On each side of the pedestal, a simple gold plaque. In a counter-clockwise direction, the engravings on each plaque lists:\n‘0x65’\n‘0x63’\n‘0x69’\n‘0x6c’\n‘0x41’";
        }
        else if (roomNumber == 2 && puzzleNumber == 4) {
            phase = 2;
            challengeName = "the keyholes";
            challengeText = "A set of keyholes placed inside of the PEDESTAL in the center. It seems each keyhole is the same, but once a key is placed inside, it would be locked in place, and could not be removed.";
        }
        else if (roomNumber == 2 && puzzleNumber == 5){
            phase = 0;
            challengeName = "the keyboard";
            challengeText = "A simple keyboard in-laid in the PEDESTAL. While there is no full-sized monitor attached to it, an LED screen is directly above it, with a prompt saying “INPUT:”";
            hintText1 = "the input seems to require some sort of sequence of ASCII characters";
            hintText2 = "The more you know: Hex characters can represent ASCII characters";
            //note: change the total amount of scrolls at the end of this text depending on how many rooms there are total in this section, would also require changes pretty much everywhere after room 2
            solvedText = "You type in “Alice”. After submitting your answer, a small compartment opens in the center of the PEDESTAL. A simple SCROLL rises from the compartment, small enough to be held in your hand.\nUpon picking it up, the compartment becomes hidden once again, hiding whatever secrets it holds back into the PEDESTAL. The SCROLL reads as follows:\n“Prologue: In a certain town, in a certain street, on a certain time, there lived a group of neighbors, and, quite possibly, a group of friends. However, at this certain time, in this certain street, in this certain town, this group is quite suspicious of one another. One of these people is Eve. Eve was your run-of-the-mill person, liked your everyday things, and liked her everyday life. However, one hobby she has is gossip. \nShe desires gossip to such a level that she tends to spy on her neighbors to learn anything and everything she could ever want. Two people in particular are her neighbors on the same street, Alice, who lives next to her, and Bob, who lives across. Every morning, Eve looks out the window to find a box on Bob’s door, and every night, she finds Alice writing something to put in a box. \nOn this very day, she decides to find out what is in this box.”\nUpon finishing reading this, SCROLLS of similar size are risen from the PEDESTAL once more, colour-coded to each section of the room. There are 5 in total";
            rewardText = "You have your 5 scrolls and you're ready to set off into the first of the wedge rooms.";
            solution = "alice";
            incorrectText = "Nothing happens. Figures.";
        }

        //room 3
        else if (roomNumber == 3 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the toolkit";
            challengeText = "A toolkit meant to be fit inside of a pocket. It includes your basic tools: A screwdriver, hammer, wrench, pliers, the like. There doesn’t appear to be anything of particular interest. \nHowever, upon closer inspection, once all of the tools are removed, an inscription in the back of the box reads: “Remember: An attackers greatest tool is their ingenuity. The easiest way in is the way to go!”";
        }
        else if (roomNumber == 3 && puzzleNumber == 2){
            phase = 0;
            challengeName = "the drawer";
            challengeText = "A small drawer, about waist height, with three COMPARTMENTS. While the top and bottom parts are completely empty, the middle has a PADLOCK attached to it. There are screws attached to the drawer, rendering the removal of the compartment impossible. \nYou decide to give each compartment a number, the name the top one 1, the middle 2, and the bottom 3.\nApart from the compartments feeling loose, nothing else strikes you about the drawer is odd.\n You attempt to use the various tools in the toolkit, but you don’t have a strong desire to destroy the drawer, however, if you do, you’re pretty sure that the owner of the drawer would be very upset with you, and so, you restrain yourself. \nApart from destruction, the toolkit’s various tools seem to be of no effect. You might think a screwdriver would work on the lock, but the screw head appears to be different.\n You decide that your best course of action will be to try to do something nondestructive with the compartments";
            hintText1 = "when solving a problem it often helps to follow the RCN principle. Remove Compartmentalize Number. Remove unhelpful things, Compartmentalize the problem, Number.";
            hintText2 = "if there were a 5th compartment in this drawer and it were full of stinky cheese, I would probably want to Remove Compartment 5 to get rid of the stank";
            solvedText = "You remove the upper section of the drawer with ease, granting you access to the middle section of the drawer. Within the drawer is a KEY to the PEDESTAL, and a sheet of paper, which oddly seems to have a rip across the top that is the same shape as the rip across the bottom of your first scroll, weird. It reads:\n“It turns out, that Eve did not need the toolkit at all! It only took her wits and creativity to get to her drawer. Now that she could reach what was inside, she took out a special decoder. She never could fully remember the code, and since the code was rewritten every time it was used, this decoder could calculate even the strangest of problems.”\nYou take the key and sheet of paper, and return the compartment back to its rightful place.";
            rewardText = "Having gotten everything you need out of it, you take a moment to appreciate the varnish on the wooden drawer. Beautifully done.";
            solution = "remove compartment 1";
            incorrectText = "Unfortunately you're no closer to a solution";
        }

        //room 4
        else if (roomNumber == 4 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the first plaque";
            challengeText = "A simple metal plaque to the left of the SWITCHES. It contains a variety of names and numbers.\nAlice:\n01000001 01101100 01101001 01100011 01100101\nBob:\n01000010 01101111 01100010\nCarol:\n01000011 01100001 01110010 01101111 01101100\nDave:\n01000100 01100001 01110110 01100101\nEve:\n01000101 01110110 01100101\nFaye:\n01000110 01100001 01111001 01100101\nPip:\n01010000 01101001 01110000";
        }
        else if (roomNumber == 4 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the second plaque";
            //text formatting with the table here works for me, may or may not work for everyone
            challengeText = "A simple metal plaque to the right of the SWITCHES. You find yourself looking at the truth tables of logical operations. \nFour basic ones are shown, an AND operator, an OR operator, an XOR operator (called exclusive or), and a NOT operator.\nA |  B |    A AND B	    A |  B |     A OR B		A |  B |    A XOR B	    A |     NOT A	    \n0 |  0 |       0      	    0 |  0 |       0      	0 |  0 |       0      	    0 |       1      	\n0 |  1 |       0      	    0 |  1 |       1      	0 |  1 |       1      	    1 |       0      	\n1 |  0 |       0      	    1 |  0 |       1      	1 |  0 |       1      	                    \n1 |  1 |       1            1 |  1 |       1      	1 |  1 |       0      	                    "; 
        }
        else if (roomNumber == 4 && puzzleNumber == 3){
            phase = 0;
            challengeName = "the switches";
            challengeText = "A large array of switches, in three rows of eight. Each one has an ‘on’ position and an ‘off’ position. A red BUTTON is placed underneath. Whenever a switch is flipped to the ‘on’ position, a corresponding light is turned on. Currently, the switches are on in the following positions:\n00000000 00000000 00000000";
            hintText1 = "You find it interesting how the firt plaque has arrays of numbers, and the switches are also represented as arrays of numbers";
            hintText2 = "remember what you read earlier? exclusively bob or eve can use they keycard. Additionally you may note that with the light switches and plaque numbers, there's a space between every 8 binary digits";
            solvedText = "You push the button, and then, from where the button is, splits in half, opening up into a small crevice inside, holding a KEY and a SCROLL. It reads:\n“To unlock the secrets of the card, she went back inside and went on her computer. With her expertise in finding information, she was able to obtain the information with ease. Within it, holds some item, inaccessible in its current form, a type of virtual lock on it. \nHowever, Eve does know it could be one of two things; Something for Bob, or something for herself. ‘Curious,’ she thinks. What might Alice be thinking into giving this? What could it possibly mean? \nPerhaps it has to do with the box? With this information in hand, she puts the card away in her pocket, and once again, pursues the box.”\nYou take the key and scroll, satisfied with the results at hand.";
            rewardText = "You stand back and enjoy the new lighting arrangement you've created";
            solution = "00000111 00011001 00000111";
            incorrectText = "You flip the following switches, and the lights turn on or off respectively, but when you push the button nothing seems to happen";
        }

        //room 5
        else if (roomNumber == 5 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the Chair";
            challengeText = "A plain wooden chair. It sits squarely in front of the TELEVISION, with nothing else around it. So creepy, you believe, the light reflecting off the chair’s surface. \nThe chair itself is worn down, scratches and cuts all over it. All around it are various engravings. On the backrest has “Z” on the front side, and “F” on the other. \nThe legs have one as well, “H” on the top-left and “S” on the top-right, with “R” on the bottom left” and “T” on the bottom right. On the seat itself is the letter “Y” and on the other side, the underside of the seat, is the engraving “Q”.";
        }
        else if (roomNumber == 5 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the Television";
            challengeText = "A simple television set, one of the older models, a CRT, laying on the floor. This thing is too heavy to lift on your own, unmovable as CRTs tend to be. It is currently playing some video on loop. \nIt isn’t very entertaining though, the only video is one where a whole bunch of letters are flashing up on the screen every so often. Because of its looping nature, you memorize the letters eventually.\nthe message is: XubbeMehbt";
        }
        else if (roomNumber == 5 && puzzleNumber == 3) {
            phase = 0;
            challengeName = "the Dials";
            challengeText = "Two circular dials are on the wall, one outer, one inner, creating a shift decoder of sorts. Labelled around both dials are the alphabet, lettered A-Z in its standard order. The inner dial can be turned. \nIf you knock on top of the dial, you hear a hollow sound ring back. Perhaps there is more to this decoder than meets the eye. The ‘A’ letter on the outer dial is highlighted and bolded, claiming importance on the dial. \nThrough utter confusion, you decide to stick to only aligning the inner dial with the letter A - keeping track of the other letters is too confusing. It is currently set to: A=A. \n You decide to start trying letters on the inner wheel to align with A on the outer wheel.";
            hintText1 = "You decide that taking a rest and sitting on the CHAIR may help you find the correct letter.";
            hintText2 = "“bottom of your bottom”. So, where you sit. What is the bottom of that?";
            solvedText = "You align Q on the inner dial with A on the outer dial, resulting in the cipher\nABCDEFGHIJKLMNOPQRSTUVWXYZ\nQRSTUVWXYZABCDEFGHIJKLMNOP\n and attempt to use the resulting cipher on the message from the television, XubbeMehbt";
            rewardText = "you look back at the cipher\nthe cipher\nABCDEFGHIJKLMNOPQRSTUVWXYZ\nQRSTUVWXYZABCDEFGHIJKLMNOP\nand the message 'XubbeMehbt', revelling in your apparent success";
            solution = "q";
            incorrectText = "You attempt to align the inner dial and use the resulting cipher on the message from the television, but you end up with gibberish.";
        }
        else if (roomNumber == 5 && puzzleNumber == 4){
            phase = 0;
            challengeName = "the Console";
            challengeText = "The console awaits an input, you suppose it wants some sort of password.";
            hintText1 = "perhaps the password is an encoded message somewhere";
            hintText2 = "solving the cipher with the dials may help with finding the password";
            solvedText = "You enter the password and the console displays the message 'Correct!', and you hear a loud noise from the dials. \ndial opens up to reveal a space behind it. Upon inspection, all that is there is a KEY and a SCROLL.\n“Of course, it must mean her chair! She quickly went to her living room, and looked underneath her chair. There was a slip of paper under the leg, Eve never noticed. Perhaps she wasn’t as good at information as she had previously thought. Regardless, she read the note.\n“Hello Eve! Alice here. If you’re reading this, you’re probably trying to find out what’s in that box of ours. Well, it isn’t anything dangerous, we can assure you that. Just be careful with it, there is something really important inside! Once you do open it, please bring it over to my house, it’ll be worth it, promise. Oh, and the code to use is ‘SPECIAL”.\nHow terrible! Alice and Bob already know that Eve is trying to break into their box! They already know so much about who Eve is, and she was supposed to be the one who knows things! Feeling quite dejected over her control of information, she inserted the code word into her decoder. \nThe output ended up being ‘1234’. Ironic, she went through so much hassle for such a simple password. Putting the code into the box, the contents were finally revealed: Another box. A cake box, to be exact, from her local cake shop. Eve still does not know what’s inside however, as all she knows is, it’s a cake, or something cake-like, at least. Deciding to follow Alice’s instructions, she begins to bring the box to Alice’s house.”\n with the puzzle solved, you head on to the next room";
            rewardText = "you sit back and admire you handywork, good work, you!";
            solution = "helloworld";
            incorrectText = "you enter your guess, but the console displays the message 'Incorrect!' and returns to the input screen";
        }

        //room 6
        else if (roomNumber == 6 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the first table";
            challengeText = "A simple round table, about waist height with a digital monitor on top. On the table has the plaque: “LOCK”. Five series of numbers are displayed on the monitor:\n-0, 0, 0, 0, 0\n-0, 9, 9, 9, 0\n-9, 0, 9, 0, 9\n-9, 0, 0, 9, 0\n-9, 9, 9, 9, 9";
        }
        else if (roomNumber == 6 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the second table";
            challengeText = "A simple round table, about waist height with a digital monitor on top. On the table has the plaque: “KEY”. There are only question marks on this monitor:\n??, ??, ??, ??, ??";
        }
        else if (roomNumber == 6 && puzzleNumber == 3) {
            phase = 2;
            challengeName = "the third table";
            challengeText = "A simple round table, about waist height with a digital monitor on top. On the table has the plaque: “MESSAGE”. \nA series of numbers is displayed on the monitor: 14,7,17,9,11";
        }
        else if (roomNumber == 6 && puzzleNumber == 4) {
            phase = 0;
            challengeName = "the Panel";
            challengeText = "Five BUTTONS line the panel. Above each button, a series of numbers are displayed.\n-Button 1: 0, 0, 0, 0, 0\n-Button 2: 0, 9, 9, 9, 0\n-Button 3: 9, 0, 9, 0, 9\n-Button 4: 9, 0, 0, 9, 0\n-Button 5: 9, 9, 9, 9, 9\nAt the top of the panel is the plaque: “UNLOCK”. A set of instructions is laid below.\n“A message from table 1 is chosen, with numbers 0 and 9, such that it is added from the mystery sequence on table 2, with numbers 0-12. The result is what is displayed on table 3. So, Table 1 + Table 2 = Table 3. What is the randomly chosen message from table 1?";
            hintText1 = "input should be of the form: 'button x', where x is a number. Randomly guessing might get you the answer if you’re desperate. However, there is a trick to it. \nSince table 1 can only be 0 or 9, there should be a limit to how far the message in table 3 can be, if you add table 1 and table 2 together.";
            hintText2 = "If you can find numbers past 12 or below 9 in table 3, then that must force the answer.";
            solvedText = "You push the button. Every display says: “CORRECT, EJECTING…” After a few seconds, a compartment slides out from below the panel. In it holds a key and a scroll.\n“Eve was able to figure out the key, it wasn’t as difficult as it seemed. Once she realized that the message did go past 12, the message was easier to find. With the message decoded, she was able to enter Alice’s house. \nWhat did Alice want with her, and why did Eve have to bring Alice the item? It was sent to Bob, didn’t it? Why didn’t he send it? Regardless, Eve got the front door to open, and she could enter inside.”\nwith the puzzle solved, you head to the next room";
            rewardText = "Before you go, you look at the buttons and reflect, a job well done indeed";
            solution = "button 3";
            incorrectText = "You push the button. Every display says: “INCORRECT, RESETTING.” It seems you got it wrong,";
        }

        //room 7
        else if (roomNumber == 7 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the Door";
            challengeText = "A small wooden door, so small in fact, that only your arm can fit through. The door is locked however, with a 4-number combination LOCK. A LETTERBOX is screwed onto the front.";
        }
        else if (roomNumber == 7 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the Letterbox";
            challengeText = "A metal letterbox screwed onto a small door. Upon looking inside, you see a torn page of a manual, however, the page itself is laiden with holes and stains, making some of the text unreadable.\n“---X base- systems use a per--ssion system in ---h of its f--es. This can be re---sented in base-8 or ba---2 nu---ation. The basic l-----t in whic- -ase-2 -----entation is as --llows:\n---Rwx--xrwx\nWhe-- -=read, w=wri--, and x=e-----e. The r---t-most gr--- of three b--s are the per----ions for three differ--- cl---es. The first is f-- --e user, the second for t-- --oup, and the th--d for others. The l--t-most bit- are --ed in sp--ial c--es, and by d---ult, is s-t to 0. Each g--up of th--- bits in base-2 can be c--verted to a si-gle base-8 d--it.”";
        }
        else if (roomNumber == 7 && puzzleNumber == 3) {
            phase = 0;
            challengeName = "the Padlock";
            challengeText = "Second verse, same as the first. Another combination lock, except this time, goes to four numbers. The password is not something like 1234, unfortunately.";
            hintText1 = "the notes give a hint as to how to solve the room. This one talks about users, groups, and others. Who would be what in this case?";
            hintText2 = "Here is the un-ruined text:\n“UNIX based systems use a permission system in each of its files. This can be represented in base-8 or base-2 numeration. The basic layout in which base-2 representation is as follows:\n---Rwxrwxrwx\nWhere r=read, w=write, and x=execute. The right-most group of three bits are the permissions for three different classes. The first is for the user, the second for the group, and the third for others. The left-most bits are used in special cases, and by default, is set to 0. Each group of three bits in base-2 can be converted to a single base-8 digit.”";
            solvedText = "You put the numbers in, and with a click, you pop the lock off. You attempt to open the door, in which it does so effortlessly. Inside is a dark recess with a key and scroll in the back. You reach in, and you barely come into contact with it. After a small while struggling to reach, you successfully obtain the key and scroll.\n“Being able to open the basement door, Eve stepped inside, and down the steps she went. It was dark, Eve couldn’t see her feet on the ground. She blindly wandered around the basement, attempting to find a light source of some kind. She eventually found one, a light bulb switch above her. Pulling on it, the room sprang to life. BANG!\n“Surprise! Happy birthday, Eve!”\nAlice and Bob popped up in front of Eve, giving no evidence as to their hiding location. What was happening? A birthday? For Eve? Upon reflection, Eve was so absorbed in the secrets of the box she remembered - oh, right! How could she forget? It was Eve’s birthday today, no wonder she couldn’t find those two. They must have prepared while Eve was puzzling out the way over here. “Here, have some of that cake you brought over!... Oh, right, locked, my bad. I love locks, don’t you know?” She does, Eve believes. “In any case, once again, happy birthday!” Eve then spends the rest of the day (night?) with Alice and Bob, celebrating her birthday. The end.”\nConcluding with the puzzle, you pocket the key and the scroll, and having finished each of the wedge rooms, the door leads back to the center room.";
            rewardText = "You've really done it, also: remember to stay hydrated! Homies don't let homies dehydrate";
            solution = "0751";
            incorrectText = "You tried to put in your numbers, but the lock will not budge. Good thing you didn't try to use the combination: 1234 , that would be embarassing, really really embarassing.";
        }

        //room 8
        else if (roomNumber == 8 && puzzleNumber == 1) {
            phase = 2;
            challengeName = "the table";
            challengeText = "It appears to be a conversion table, in which different numbers could be converted to other different numbers… you suppose.\nhttp://www.asciitable.com/\nThank heavens you actually understand this, however, for the uninitiated, there are also a set of INSTRUCTIONS written below the table.";
        }
        else if (roomNumber == 8 && puzzleNumber == 2) {
            phase = 2;
            challengeName = "the instructions";
            challengeText = "There are four main columns you should be concerned about.\nThere is decimal, ‘Dec’, in base 10, which are standard counting numbers, which have no prefix.\nThere is octet, ‘Oct’, in which the base number is 8, most notably used in permission notations, and has the ‘0o’ prefix.\nThere is hex, ‘Hx’, in base 16, usually used to simplify notations, occasionally used in colours, with the ‘0x’ prefix.\nLastly is ‘Char’, which relates to ASCII, used in basic text.";
        }
        else if (roomNumber == 8 && puzzleNumber == 3) {
            phase = 2;
            challengeName = "the pedestal";
            challengeText = "On the hexagonal pedestal is five KEYHOLES of similar size, split evenly across the six sections of the room, barring one section facing the opposite door, in which a KEYBOARD is placed, and a simple screen above it. There is also a piece of paper which has a conversion TABLE placed on it. On each side of the pedestal, a simple gold plaque. In a counter-clockwise direction, the engravings on each plaque lists:\n‘0x65’\n‘0x63’\n‘0x69’\n‘0x6c’\n‘0x41’";
        }
        else if (roomNumber == 8 && puzzleNumber == 4) {
            phase = 0;
            challengeName = "the keyholes";
            challengeText = "A set of keyholes placed inside of the PEDESTAL in the center. It seems each keyhole is the same, but once a key is placed inside, it would be locked in place, and could not be removed.";
            hintText1 = "place keys";
            hintText2 = "place keys";
            solvedText = "You place all the keys you've collected on your journey into the keyholes, you also notice a door hidden in the wall that you had not seen before.";
            rewardText = "congrats!";
            solution = "place keys";
            incorrectText = "try placing the keys you've collected.";
        }
        else if (roomNumber == 8 && puzzleNumber == 5){
            phase = 2;
            challengeName = "the keyboard";
            challengeText = "A simple keyboard in-laid in the PEDESTAL. While there is no full-sized monitor attached to it, an LED screen is directly above it, the screen still says 'unlocked' from when you were here earlier.";
        }

        //That's it for us! However, dear reader, feel free to add more rooms or change existing ones! blank templates are below
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