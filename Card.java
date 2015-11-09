// This class represents one playing card.
public class Card
{
	// Card suits (provided for your convenience - use is optional)
	public static final int SPADES   = 0;
	public static final int HEARTS   = 1;
	public static final int CLUBS    = 2;
	public static final int DIAMONDS = 3;

	// Card faces (provided for your convenience - use is optional)
	public static final int ACE      = 1;
	public static final int TWO      = 2;
	public static final int THREE    = 3;
	public static final int FOUR     = 4;
	public static final int FIVE     = 5;
	public static final int SIX      = 6;
	public static final int SEVEN    = 7;
	public static final int EIGHT    = 8;
	public static final int NINE     = 9;
	public static final int TEN      = 10;
	public static final int JACK     = 11;
	public static final int QUEEN    = 12;
	public static final int KING     = 13;


	// define fields here
	private int suit;
	private int face;

	// This constructor builds a card with the given suit and face, turned face down.
	public Card(int cardSuit, int cardFace)
	{
		switch(cardSuit){
			case 0: this.suit = SPADES;
				break;
			case 1: this.suit = HEARTS;
				break;
			case 2: this.suit = CLUBS;
				break;
			case 3: this.suit = DIAMONDS;
				break;
			default: this.suit = -1; //Should never happen, Card suit shouldn't be something other than 0-3
				break;
		}
		switch(cardFace){
			case 1: this.face = ACE;
				break;
			case 2: this.face = TWO;
				break;
			case 3: this.face = THREE;
				break;
			case 4: this.face = FOUR;
				break;
			case 5: this.face = FIVE;
				break;
			case 6: this.face = SIX;
				break;
			case 7: this.face = SEVEN;
				break;
			case 8: this.face = EIGHT;
				break;
			case 9: this.face = NINE;
				break;
			case 10: this.face = TEN;
				break;
			case 11: this.face = JACK;
				break;
			case 12: this.face = QUEEN;
				break;
			case 13: this.face = KING;
				break;
			default: this.face = -1; //Should never happen
				break;
		}

	}

	// This method retrieves the suit (spades, hearts, etc.) of this card.
	public int getSuit()
	{
		switch(this.suit){
			case 0: return SPADES;
			//	break;
			case 1: return HEARTS;
			//	break;
			case 2: return CLUBS;
		//		break;
			case 3: return DIAMONDS;
		//		break;
			default: return -1; //Should never happen, Card suit shouldn't be something other than 0-3
		//		break;
		}
	}

	// This method retrieves the face (ace through king) of this card.
	public int getFace()
	{
		switch(this.face){
			case 1: return ACE;
		//		break;
			case 2: return TWO;
		//		break;
			case 3: return THREE;
		//		break;
			case 4: return FOUR;
		//		break;
			case 5: return FIVE;
		//		break;
			case 6: return SIX;
		//		break;
			case 7: return SEVEN;
		//		break;
			case 8: return EIGHT;
		//		break;
			case 9: return NINE;
		//		break;
			case 10: return TEN;
		//		break;
			case 11: return JACK;
		//		break;
			case 12: return QUEEN;
		//		break;
			case 13: return KING;
			//	break;
			default: return -1; //Should never happen
		//		break;
		}
	}

	// This method retrieves the numerical value of this card
	// (usually same as card face, except 1 for ace and 10 for jack/queen/king)
	public int getValue()
	{
		switch(this.face){
			case 1: return 1;
		//		break;
			case 2: return 2;
		//		break;
			case 3: return 3;
		//		break;
			case 4: return 4;
		//		break;
			case 5: return 5;
		//		break;
			case 6: return 6;
		//		break;
			case 7: return 7;
		//		break;
			case 8: return 8;
		//		break;
			case 9: return 9;
		//		break;
			case 10: return 10;
		//		break;
			case 11: return 10; //Jack returns 10
	  //		break;
			case 12: return 10;//Queen returns 10
		//		break;
			case 13: return 10;//King returns 10
		//		break;
			default: return -1; //Should never happen
		// 		break;
		}
	}

	public String toString(){
		String faceCard;
		String suitCard;
		switch(this.suit){
			case 0: suitCard = "SPADES";
				break;
			case 1: suitCard = "HEARTS";
				break;
			case 2: suitCard = "CLUBS";
				break;
			case 3: suitCard = "DIAMONDS";
				break;
			default: suitCard = "ERROR!"; //Should never happen, Card suit shouldn't be something other than 0-3
				break;
		}

		switch(this.face){
			case 1: faceCard = "ACE";
				break;
			case 2: faceCard = "TWO";
				break;
			case 3: faceCard = "THREE";
				break;
			case 4: faceCard = "FOUR";
				break;
			case 5: faceCard = "FIVE";
				break;
			case 6: faceCard = "SIX";
				break;
			case 7: faceCard = "SEVEN";
				break;
			case 8: faceCard = "EIGHT";
				break;
			case 9: faceCard = "NINE";
				break;
			case 10: faceCard = "TEN";
				break;
			case 11: faceCard = "JACK";
				break;
			case 12: faceCard = "QUEEN";
				break;
			case 13: faceCard = "KING";
				break;
			default: faceCard = "ERROR!"; //Should never happen
				break;
		}

		return(faceCard + " of " + suitCard);

	}

}
