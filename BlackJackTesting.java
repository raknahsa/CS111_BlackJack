public class BlackJackTesting{
  public static void main(String[] args){

    Card a = new Card(0,1);
    Card j = new Card(1,11);
    Card q = new Card(2,12);
    Card k = new Card(3,13);


/*
Card tmp;
int count = 0;
for(int i = 0; i < 4; i++){
  for(int f = 1; f < 14; f++){
  tmp = new Card(i,f);
System.out.println(count + " " + tmp + " " + tmp.getSuit() + " " + tmp.getFace() + " " + tmp.getValue() + " " + i + " " + f);
    count++;
  }
}

*/


    System.out.println(a.getSuit());
    System.out.println(a.getFace());
    System.out.println(a.getValue());
    System.out.println(j.getSuit());
    System.out.println(j.getFace());
    System.out.println(j.getValue());
    System.out.println(q.getSuit());
    System.out.println(q.getFace());
    System.out.println(q.getValue());
    System.out.println(k.getSuit());
    System.out.println(k.getFace());
    System.out.println(k.getValue());

    Deck deck = new Deck();

    int index = 1;
    System.out.println("------------------------------------------------------------------");
    System.out.println("Normal Deck");
    System.out.println("------------------------------------------------------------------");

    while(!deck.isEmpty()){
      System.out.println(index + " " + deck.deal());
      index++;
    }

    index = 1;
    deck.shuffle();
    System.out.println("------------------------------------------------------------------");
    System.out.println("Shuffle Deck");
    System.out.println("------------------------------------------------------------------");

    while(!deck.isEmpty()){
      System.out.println(index + " " + deck.deal());
      index++;
    }

    index = 1;
    deck.shuffle();
    System.out.println("-------------------------------------------------------------------");
    System.out.println("Shuffle Deck Again");
    System.out.println("-------------------------------------------------------------------");

    while(!deck.isEmpty()){
      System.out.println(index + " " + deck.deal());
      index++;
    }

  }
}
