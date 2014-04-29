import javax.swing.*;
/*
   Caitlin Baker
   CS 110
   Card Interface
*/

/**
   Interface for methods of the card class.
**/
public interface CardInterface
{
   int getSuit();
   int getRank();
   String getSuitAsString();
   String getRankAsString();
   boolean equals(Card otherCard );
   ImageIcon getPic();
}