import java.util.ArrayList;

public class Player {
    public Deck deck;
    public String name;

    public Player(String name, Deck deck){
        this.name = name;
        this.deck = deck;
    }

    public boolean hasLost(){
        if(deck.cards.size() > 0){
            return false;
        }
        System.out.println(deck.cards.size());
        return true;
    }
}
