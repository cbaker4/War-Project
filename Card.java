import javax.swing.*;
/*
   Caitlin Baker
   CS 110
   Card Class
*/

/**
   A class to compare each individual card.
*/

public class Card implements CardInterface
{     
    // Constants     
    // suits
    public final static int SPADES = 0,      
                            HEARTS = 1,
                            DIAMONDS = 2,
                            CLUBS = 3;
    // ranks
    // Cards 2 through 9 have face value
    public final static int ACE = 1,          
                            JACK = 11,        
                            QUEEN = 12,       
                            KING = 13;
                            
    // instance variables
    private int suit; 
                              
    private int rank;
    
    private String pic;
                             
   /**
      Creates a new playing card.
      @param suit the suit value of this card.
      @param rank the rank rank of this card.
   */
    public Card(int rank, int suit) 
    {
        this.rank = rank;
        this.suit = suit;
        pic = null;
    }
    
   /**
      Creates a new playing card as exact copy of otherCard
      @param otherCard the card to be copied
   */
    public Card(Card otherCard) 
    {
         this.rank = otherCard.rank;
         this.suit = otherCard.suit;
         //this.pic = otherCard.pic;
    }
    
   /**
      Returns the suit of the card.
      @return a Suit constant representing the suit value of the card.
   */
  
    public int getSuit() 
    {
      return suit;
    }
   
   /**
      Returns the rank of the card.
      @return a Rank constant representing the rank value of the card.
   */
    public int getRank() 
    {
        return rank;
    }
    
   /**
      Returns a description of the suit of this card.
      @return the suit value of the card as a string.
   */
   
    public String getSuitAsString() 
    {
        switch ( suit ) 
        {
           case SPADES:   return "s";
           case HEARTS:   return "h";
           case DIAMONDS: return "d";
           case CLUBS:    return "c";
           default:       return "Invalid";
        }
    }
   
   /**
      Returns a description of the rank of this card.
      @return the rank value of the card as a string.
   */
   public String getRankAsString() 
   {
        switch ( rank ) {
           case 1:   return "ace";
           case 2:   return "2";
           case 3:   return "3";
           case 4:   return "4";
           case 5:   return "5";
           case 6:   return "6";
           case 7:   return "7";
           case 8:   return "8";
           case 9:   return "9";
           case 10:  return "10";
           case 11:  return "jack";
           case 12:  return "queen";
           case 13:  return "king";
           default:  return "??";
        }
    }
    
   /**
      Compares two cards to determine if they have the same value.
      @param otherCard the other card
      @return true if the two cards have the same rank and suitvalues,
      falseotherwise.
   */
   public boolean equals(Card otherCard ) 
   {
      if ( ( rank != otherCard.rank ) || ( suit != otherCard.suit ) )
         return false;
      else
         return true;
   }
   
   // method to get pictures
   public ImageIcon getPic()
   {
      
      pic = getRankAsString() + getSuitAsString() + ".jpg";
      
      ImageIcon p = new ImageIcon(pic);
      
      return p;
   }
}
    


