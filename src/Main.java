import java.util.*;

public class Main {
    static Player player1;
    static Player player2;

    public static void main(String[] args) {
        System.out.println("Welcome to War! (or Peace) This game will be played with 52 cards.");
        System.out.println("The players today are Megan and Aurora.");
        System.out.println("Type 'GO' to start the game!");
        System.out.println("------------------------------------------------------------------\n");

        Scanner scan = new Scanner(System.in);
        String userInput = scan.nextLine();

        if (userInput.toLowerCase().equals("go")) {
            setUpGame();
            for(int i = 0; i <= 10000; ++i) {
                String output = String.format("Turn %s: %s", i, takeTurn());
                System.out.println(output);
                if(player1.hasLost()) {
                    System.out.println(String.format("*~*~*~* %s has won the game! *~*~*~*", player2.name));
                    break;
                } else if(player2.hasLost()) {
                    System.out.println(String.format("*~*~*~* %s has won the game! *~*~*~*", player1.name));
                    break;
                } else if(i == 10000) {
                    System.out.println("---- DRAW ----");
                }
            }
        } else {
            System.out.println("Sorry I thought you were here to play war.");
        }
    }

    public static void setUpGame() {
        Card card1 = new Card( "heart",  "Ace", 14);
        Card card2 = new Card( "heart",  "2", 2);
        Card card3 = new Card( "heart",  "3", 3);
        Card card4 = new Card( "heart",  "4", 4);
        Card card5 = new Card( "heart",  "5", 5);
        Card card6 = new Card( "heart",  "6", 6);
        Card card7 = new Card( "heart",  "7", 7);
        Card card8 = new Card( "heart",  "8", 8);
        Card card9 = new Card( "heart",  "9", 9);
        Card card10 = new Card( "heart",  "10", 10);
        Card card11 = new Card( "heart",  "Jack", 11);
        Card card12 = new Card( "heart",  "Queen", 12);
        Card card13 = new Card( "heart",  "King", 13);
        Card card14 = new Card( "Spade",  "Ace", 14);
        Card card15 = new Card( "Spade",  "2", 2);
        Card card16 = new Card( "Spade",  "3", 3);
        Card card17 = new Card( "Spade",  "4", 4);
        Card card18 = new Card( "Spade",  "5", 5);
        Card card19 = new Card( "Spade",  "6", 6);
        Card card20 = new Card( "Spade",  "7", 7);
        Card card21 = new Card( "Spade",  "8", 8);
        Card card22 = new Card( "Spade",  "9", 9);
        Card card23 = new Card( "Spade",  "10", 10);
        Card card24 = new Card( "Spade",  "Jack", 11);
        Card card25 = new Card( "Spade",  "Queen", 12);
        Card card26 = new Card( "Spade",  "King", 13);
        Card card27 = new Card( "Diamond",  "Ace", 14);
        Card card28 = new Card( "Diamond",  "2", 2);
        Card card29 = new Card( "Diamond",  "3", 3);
        Card card30 = new Card( "Diamond",  "4", 4);
        Card card31 = new Card( "Diamond",  "5", 5);
        Card card32 = new Card( "Diamond",  "6", 6);
        Card card33 = new Card( "Diamond",  "7", 7);
        Card card34 = new Card( "Diamond",  "8", 8);
        Card card35 = new Card( "Diamond",  "9", 9);
        Card card36 = new Card( "Diamond",  "10", 10);
        Card card37 = new Card( "Diamond",  "Jack", 11);
        Card card38 = new Card( "Diamond",  "Queen", 12);
        Card card39 = new Card( "Diamond",  "King", 13);
        Card card40 = new Card( "Diamond",  "Ace", 14);
        Card card41 = new Card( "club",  "2", 2);
        Card card42 = new Card( "club",  "3", 3);
        Card card43 = new Card( "club",  "4", 4);
        Card card44 = new Card( "club",  "5", 5);
        Card card45 = new Card( "club",  "6", 6);
        Card card46 = new Card( "club",  "7", 7);
        Card card47 = new Card( "club",  "8", 8);
        Card card48 = new Card( "club",  "9", 9);
        Card card49 = new Card( "club",  "10", 10);
        Card card50 = new Card( "club",  "Jack", 11);
        Card card51 = new Card( "club",  "Queen", 12);
        Card card52 = new Card( "club",  "King", 13);

        List<Card> cards = Arrays.asList(card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11,
                card12, card13, card14, card15, card16, card17, card18, card19, card20, card21, card22, card23, card24,
                card25, card26, card27, card28, card29, card30, card31, card32, card33, card34, card35, card36, card37,
                card38, card39, card40, card41, card42, card43, card44, card45, card46, card47, card48, card49, card50,
                card51, card52);

        Collections.shuffle(cards);

        ArrayList<Card> playerCards1 = new ArrayList<Card>();
        ArrayList<Card> playerCards2 = new ArrayList<Card>();

        for(int counter = 0; counter < cards.size(); counter++){
            if(counter % 2 == 0) {
                playerCards1.add(cards.get(counter));
            } else {
                playerCards2.add(cards.get(counter));
            }
        }

        Deck deck1 = new Deck(playerCards1);
        Deck deck2 = new Deck(playerCards2);

        Player playerOne = new Player("Megan", deck1);
        Player playerTwo = new Player("Aurora", deck2);
        player1 = playerOne;
        player2 = playerTwo;
    }

    public static String takeTurn(){
        if (player2.hasLost() || player1.hasLost()) {
            String output = "Someone Won!!!";
            return output;
        } else {
            Turn turn = new Turn(player1, player2);
            Player winner = turn.winner();
            String type = turn.type();
            turn.pileCards();
            turn.awardSpoils(winner);
            if (type == "basic") {
                String output = String.format("%s won 2 cards", winner.name);
                return output;
            } else if(type == "war") {
                String output = String.format("WAR - %s won 6 cards", winner.name);
                return output;
            } else {
                String output = "*mutually assured destruction* 6 cards removed from play";
                return output;
            }
        }
    }
}
