public class BlackJack{
  public static void main(String[] args){

    Card a = new Card(0,1);
    Card j = new Card(1,11);
    Card q = new Card(2,12);
    Card k = new Card(3,13);


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


  int index = 1;

  System.out.println("------------------------------------------------------------------");
  System.out.println("Normal Deck");
  System.out.println("------------------------------------------------------------------");

  Deck deck = new Deck();
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
  System.out.println("------------------------------------------------------------------");
  System.out.println("Shuffle Deck Again");
  System.out.println("------------------------------------------------------------------");
  while(!deck.isEmpty()){
    System.out.println(index + " " + deck.deal());
    index++;
  }

  }
}
