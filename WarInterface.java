/*
   Caitlin Baker
   CS 110
   War Interface
*/

/**
   Interface for methods of the war class.
**/
public interface WarInterface
{
   Card flipCard1();
   Card flipCard2();
   CardPile wFlipCard();
   boolean isEmpty();
   void shuffle();
}