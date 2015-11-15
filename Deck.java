// This class represents the deck of cards from which cards are dealt to players.
public class Deck
{
	// define fields here
	public Card[] cards;
	private int index;

	// This constructor builds a deck of 52 cards.
	public Deck()
	{
		this.index = 0;
		this.cards = new Card[52];
		int count = 0;
		for(int i = 0; i < 4; i++){
			for(int j = 1; j < 14; j++){
				this.cards[count] = new Card(i,j);
		//		System.out.println(count + " " + new Card(i,j) + " " + i + " " + j);
				count++;
			}
		}
	}

	// This method takes the top card off the deck and returns it.
	public Card deal()
	{
		Card tmp = cards[index];
		index++;
		return tmp;
	}

	// this method returns true if there are no more cards to deal, false otherwise
	public boolean isEmpty()
	{
		if(index != 52)
			return false;
		else
			return true;
	}

	//this method puts the deck int some random order
	public void shuffle(){

		int count;
		Card tmp;
    for (int i = 51; i >= 0; i--)
    {
        count = (int)(Math.random() * 50 + 2);;
		//		System.out.println(count);
        tmp = cards[count];
        cards[count] = cards[i];
        cards[i] = tmp;
    }
		index = 0; 
	}
}
