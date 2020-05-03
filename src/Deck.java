import java.util.ArrayList;

public class Deck {
    ArrayList cards = new ArrayList();
    ArrayList highCards = new ArrayList();

    public Deck(ArrayList args){
        this.cards = args;
    }

    public int rankOfCardAt(int a){
        if ((a == 0 && cards.size() > 0) || (a == 2 && cards.size() > 2)) {
            Card found = (Card) cards.get(a);
            return found.rank;
        }
        return 0;
    }

    public ArrayList highRankingCards(){
        ArrayList highCards = new ArrayList();
        for(int counter = 0; counter < cards.size(); counter++) {
            Card currentCard = (Card) cards.get(counter);
            if (currentCard.rank >= 11) {
                highCards.add(currentCard);
            }
        }
        return highCards;
    }

    public float percentHighRanking(){
        float a = highRankingCards().size();
        float b = cards.size();
        float z = ( a / b) * 100;
        return z;
    }

    public Card removeCard(){
        Card currentCard = (Card) cards.get(0);
        cards.remove(0);
        return currentCard;
    }

    public void addCard(Card a){
        cards.add(a);
    }
}
