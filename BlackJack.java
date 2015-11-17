public class BlackJack{
  public static void main(String[] args){

    boolean gameContinues = true;//: True when game is session, false when game ends.
    int numberOfPlayers = 0; //: User inputed number of players.
    double balance = 0;//: How much each player starts with(maybe later set each player differently).
    String [] players = {""};//: An array which contains the names of each player.
    int [] playerBalances = {0}; //: An array which will contain the balance of each player.
    int score = 0; //: Temporary variable for the scores.
    int [] bet = {0}; //: How much the players are going to bet for that round.// Possibly later change to array for multiple bets
    int []  playerScores = {0}; //: Keep score of the player.
    int dealerScore = 0; //: Score of the dealer.
    int round = 1;
    boolean notValidCommand = true;
    Card faceUpCard;
    String answer;
    boolean playerRound = true;

    Deck deck = new Deck();

    System.out.println();
    System.out.println("Welcome to the game of BlackJack");
    System.out.println("---------------------------------");
    System.out.println();

    System.out.println("How many player are going to be in the game?");
    numberOfPlayers = IO.readInt();

    while(numberOfPlayers > 6 || numberOfPlayers <= 0){
      if(numberOfPlayers == 0){
        System.out.println("How are you going to play with no players..." + "\n" + "Enter the number of players again.");
        numberOfPlayers = IO.readInt();
      }
      else if(numberOfPlayers < 0){
        System.out.println("Its not possible to have a negative number of people..." + "\n" + "Enter the number of players again.");
        numberOfPlayers = IO.readInt();
      }
      else{
        System.out.println("Sorry, there can only be a max of 6 players. Please decide again who will be playing");
        numberOfPlayers = IO.readInt();
      }
    }

    players = new String[numberOfPlayers];
    playerBalances = new int[numberOfPlayers];
    bet = new int[numberOfPlayers];
    playerScores = new int[numberOfPlayers];


    for(int i = 0; i < numberOfPlayers ; i++){
      System.out.println("Player " + (i + 1) + ", enter your name.");
      players[i] = IO.readString();
      System.out.println(players[i] + ", what is your balance?");
      playerBalances[i] = IO.readInt();
      if(playerBalances[i] <= 0){
        System.out.println(players[i] + ", you can't play with no money. Come back with something to bet with...");
        System.out.println("Now, do you have the money you want to bet with or are you going to stil keep you balance at 0?");
        playerBalances[i] = IO.readInt();
        if(playerBalances[i] <= 0){
          System.out.println();
          System.out.println("In that case, you will just watch as the game goes on.");
        }
      }
    }

/*
    for(int i = 0; i < numberOfPlayers ; i++){
      System.out.println("Player " + (i + 1) + "\n" + players[i] + ":" + playerBalances[i]);
    }
*/
  System.out.println("Now we will start the game of Black Jack.");

    while(gameContinues){
      System.out.println();
      System.out.println("First we will shuffle the deck.");

      deck.shuffle();

      System.out.println();
      System.out.println("**Shuffling Deck**");
      System.out.println();

      System.out.println("This is round " + round);

      for(int i = 0; i < numberOfPlayers; i++){
        System.out.println(players[i] + "'s turn:");  //User friendly output.
        if(playerBalances[i] == 0){
          System.out.println("You are bankrupt, nothing more for you to do. Should have been more carefull.");
          System.out.println();
        }
        else{
          System.out.println("How much are you betting for this round?");
          //code to check if bet is less than balance

          bet[i] = IO.readInt();

          while(bet[i] > playerBalances[i]){
            System.out.println("How are you going to bet more money than what you have... " +  "\n" + "Please enter a valid bet");
            bet[i] = IO.readInt();
          }
          System.out.println();

        //  playerBalances[i] -= bet[i];

  //---------------------------------------------------Start of Round Game Loop---------------------------------------------------------
          while(score <= 21 && playerRound){
            if(score > 0){
              faceUpCard = deck.deal();
              System.out.println("Dealer: The next face up card is " + faceUpCard);
              if(faceUpCard.getValue() == 1 && score <= 10){
                score += 11;
              }
              else
                score += faceUpCard.getValue();
              if(score > 21){
                System.out.println("Dealer: Too bad, you have busted. Your score for this round is now 0.");
                score = 0;
                break;
              }
              else
                System.out.println("Dealer: Do you want to hit? (Enter yes to hit and no to stand) ... " + "(Your current score is " + score + ")");
            }

            else{
              faceUpCard = deck.deal();
              if(faceUpCard.getValue() == 1 && score <= 10){
                score += 11;
              }
              else
                score += faceUpCard.getValue();

              System.out.println("Dealer: There a two cards here. The face up card is " + faceUpCard);
              System.out.println("Dealer: Do you want to hit? (Enter yes to hit and no to stand) ..." + "(Your current score is " + score + ")");
            }

            while(notValidCommand){
              answer = IO.readString();
              if(answer.equals("yes") || answer.equals("y") || answer.equals("YES") || answer.equals("Yes")){
                System.out.println("Dealer: Ok, hitting...");
                notValidCommand = false;
              }
              else if(answer.equals("no") || answer.equals("n") || answer.equals("NO") || answer.equals("No")){
                System.out.println("Dealer: Ok, this will be your final score.");
                notValidCommand = false;
                playerRound = false;
              }
              else{
                System.out.println("Dealer: Thats not a valid answer..." + "\n" + "Please enter again.");
              }
            }

            notValidCommand = true;
          }
          playerScores[i] = score; //assign the score to the player.
          score = 0; //reset the score to 0 for each player.
          playerRound = true;
      }
      //  deck.shuffle(). //shuffle the deck, could be done now or at each round.
      }
//---------------------------------------------------End of Round Game Loop---------------------------------------------------------


//---------------------------------------------------Start of Dealer Game Loop---------------------------------------------------------
      System.out.println("Dealer: Now it is my turn.");
      while(score <= 21){
        if(score > 0){
          faceUpCard = deck.deal();
          System.out.println("Dealer: My next face up card is " + faceUpCard);
          if(faceUpCard.getValue() == 1 && score <= 10){
            score += 11;
          }
          else
            score += faceUpCard.getValue();
          if(score > 21){
            System.out.println("Dealer: Huh, it seems I have busted. Everyone who did not bust will win for this round");
            score = 0;
            break;
          }
        }
        else{
          faceUpCard = deck.deal();
          if(faceUpCard.getValue() == 1 && score <= 10){
            score += 11;
          }
          else
            score += faceUpCard.getValue();
          System.out.println("Dealer: My first face up card is " + faceUpCard);
        }

        if(score >= 17){
          System.out.println("Dealer: I am going to stand now." + " My score is " + score);
          break;
        }
        else
          System.out.println("Dealer: I will hit.");
      }
      dealerScore = score;
//---------------------------------------------------Start of Dealer Game Loop---------------------------------------------------------

    System.out.println();

    for(int i = 0; i < numberOfPlayers ; i++){
      if(playerScores[i] == 0){
        System.out.println(players[i] + " has lost " + bet[i]);
        playerBalances[i] -= bet[i];
      }
      else if(playerScores[i] > dealerScore){
        System.out.println(players[i] + " has won " + bet[i]);
        playerBalances[i] += bet[i];
      }
      else if(playerScores[i] < dealerScore){
        System.out.println(players[i] + " has lost " + bet[i]);
        playerBalances[i] -= bet[i];
      }
      else{
        System.out.println(players[i] + " has tied with the dealer");
      }

    }

      System.out.println();
      System.out.println("Current Scores.");
      System.out.println("----------------");
      for(int i = 0; i < numberOfPlayers ; i++){
        System.out.println("Player " + (i + 1) + "\n" + players[i] + ":" + playerBalances[i]);
      }

      System.out.println("Dealer: Do you want to play another round?");
      while(notValidCommand){
        answer = IO.readString();
        if(answer.equals("yes") || answer.equals("y") || answer.equals("YES") || answer.equals("Yes")){
          notValidCommand = false;
          score = 0; //: Temporary variable for the scores.
          dealerScore = 0; //: Score of the dealer.
          round++;
          System.out.println("Dealer: Ok, starting Round " + round);
        }
        else if(answer.equals("no") || answer.equals("n") || answer.equals("NO") || answer.equals("No")){
          System.out.println("Dealer: Ok, I will now tell the final balances");
          notValidCommand = false;
          gameContinues = false;
        }
        else{
          System.out.println("Dealer: Thats not a valid answer..." + "\n" + "Please enter again.");
        }
      }
      notValidCommand = true;

    }
//---------------------------------------------------End of Main Game While Loop---------------------------------------------------------
    //System.out.println("Game Ends...");
    System.out.println();

    for(int i = 0; i < numberOfPlayers ; i++){
      System.out.println("Player " + (i + 1) + "\n" + players[i] + ":" + playerBalances[i]);
    }
  }
}
