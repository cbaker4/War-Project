/*
   Caitlin Baker
   CS 110
   Card Pile Interface
*/

/**
   Interface for methods of the card pile class.
**/
public interface CardPileInterface
{
   void addCard(Card c);
   Card flipCard();
   int size();
}