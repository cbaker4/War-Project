import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
   Caitlin Baker
   CS 110
   War GUI
*/

/**

*/

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel, bottomPanel, centerPanel1, centerPanel2;
   private JLabel status, title;
   private Deck1 d;
   
   public WarGUI()
   {
      //create layout
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      topPanel = new JPanel();
      topPanel.setBackground(Color.cyan);
      title = new JLabel("Caitlin's Game of War");
      title.setFont(new Font("ARIAL",Font.BOLD,30));
      topPanel.add(title);
      bottomPanel = new JPanel();
      bottomPanel.setBackground(Color.cyan);
      status = new JLabel("Playing Game");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      bottomPanel.add(status);
      JButton left = new JButton("Flip Card : player 1");
      JButton right = new JButton("Flip Card : player 2");
      add(topPanel, BorderLayout.NORTH);
      add(left, BorderLayout.WEST);
      add(right, BorderLayout.EAST);
      add(bottomPanel, BorderLayout.SOUTH);

      // calling game of War
      game = new War(d);
      //game.game();
      //game.determineWinner();
      centerPanel1.add(game.game());
      centerPanel2.add(game.determineWinner());
      add(centerPanel1, BorderLayout.CENTER);
      add(centerPanel2, BorderLayout.CENTER);
         
   }
   
   // to handle the button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         String winner;
         
         //button
         
         // flipping
         
         
      }
   }

}