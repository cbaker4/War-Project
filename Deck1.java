import java.util.Random;
import java.util.ArrayList;
/*
   Caitlin Baker
   CS 110
   Deck1 Class
*/

/**
   A class for the deck of cards.
*/

public class Deck1 implements Deck1Interface
{
   final int CARDS_IN_DECK = 52;

   ArrayList<Card> deck;
   
   /**
      Constructor
      Calls fresh deck
   */
   public Deck1()
   {
      freshDeck();
   }
   
   /**
      Creates a new deck of cards
   */
   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      System.out.println(deck.size());

      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
   }
   
   /**
      @return c returns the card from the top of deck
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);
      return c;
   }
   
   /**
      @return The size of the deck
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   
   /**
      Shuffles the deck
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   
   /**
      Determines if the deck is empty
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
}

