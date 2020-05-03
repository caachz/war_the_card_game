
public class Card {
    public String suite;
    public String value;
    public int rank;

    public Card(String suite, String value, int rank){
        this.suite = suite;
        this.value = value;
        this.rank = rank;
    }

    public int cardRank(){
        return this.rank;
    }
}
