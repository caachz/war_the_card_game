import java.util.ArrayList;

public class Turn {
    public Player player1;
    public Player player2;
    public ArrayList<Card> spoilsOfWar = new ArrayList<Card>();

    public Turn(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public ArrayList spoilsOfWar(){
        ArrayList spoils = new ArrayList();
        return spoils;
    }

    public String type(){
        int card1 = player1.deck.rankOfCardAt(0);
        int card2 = player2.deck.rankOfCardAt(0);
        int card3 = player1.deck.rankOfCardAt(2);
        int card4 = player2.deck.rankOfCardAt(2);
        if (card1 == card2 && card3 == card4 ) {
            return "mutually_assured_destruction";
        } else if(card1 == card2) {
            return "war";
        } else {
            return "basic";
        }
    }

    public Player winner(){
        int card1 = player1.deck.rankOfCardAt(0);
        int card2 = player2.deck.rankOfCardAt(0);
        int card3 = player1.deck.rankOfCardAt(2);
        int card4 = player2.deck.rankOfCardAt(2);
        if(type() == ("basic")){
            if(card1 > card2) {
                return player1;
            } else if(card2 > card1) {
                return  player2;
            } else {
                return null;
            }
        } else if(type() == ("mutually_assured_destruction")){
            return null;
        } else {
            if(card3 > card4) {
                return player1;
            } else if(card4 > card3) {
                return  player2;
            } else {
                return null;
            }
        }

    }

    public ArrayList pileCards(){
        String a = type();
        Card card1 = player1.deck.removeCard();
        Card card2 = player2.deck.removeCard();
        if(a == "basic") {
            this.spoilsOfWar.add(card1);
            this.spoilsOfWar.add(card2);
        } else if(a == "war") {
            if (player1.deck.cards.size() >= 3 && player2.deck.cards.size() >= 3) {
                Card card3 = player1.deck.removeCard();
                Card card4 = player1.deck.removeCard();
                Card card5 = player2.deck.removeCard();
                Card card6 = player2.deck.removeCard();
                this.spoilsOfWar.add(card1);
                this.spoilsOfWar.add(card2);
                this.spoilsOfWar.add(card3);
                this.spoilsOfWar.add(card4);
                this.spoilsOfWar.add(card5);
                this.spoilsOfWar.add(card6);
            }
        } else {
            player1.deck.removeCard();
            player1.deck.removeCard();
            player2.deck.removeCard();
            player2.deck.removeCard();
        }
        return spoilsOfWar;
    }

    public ArrayList awardSpoils(Player winner){
        if (spoilsOfWar.size() > 0) {
            for( Card a : spoilsOfWar){
                winner.deck.cards.add(a);
            }
            spoilsOfWar.clear();
        }
        return spoilsOfWar;
    }

}
