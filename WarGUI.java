import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/*
   Caitlin Baker
   CS 110
   War GUI
*/

/**
   The GUI is where you play the game of war. It displays the winner
   for each round and overall.
*/

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel, bottomPanel, centerPanel1, centerPanel2;
   private JLabel status, title, title1, title2, t1, t2,t3,t4;
   private Deck1 d;
   private JButton c3;
   
   public WarGUI()
   {
      //create layout
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(700,600);
      topPanel = new JPanel();
      topPanel.setBackground(Color.cyan);
      title = new JLabel("Caitlin's Game of War");
      title.setFont(new Font("ARIAL",Font.BOLD,30));
      topPanel.add(title);
      JPanel left = new JPanel(new FlowLayout());
      JPanel right = new JPanel(new FlowLayout());
      t1 = new JLabel("Player 1");
      //t3 = new JLabel();
      //t3.setIcon(new ImageIcon("back.jpg"));
      t2 = new JLabel("Player 2");
      //t4 = new JLabel();
      //t4.setIcon(new ImageIcon("back.jpg"));
      right.add(t2/*,t4*/);
      left.add(t1/*,t3*/);
      add(topPanel, BorderLayout.NORTH);
      add(left, BorderLayout.WEST);
      add(right, BorderLayout.EAST);
      
      c3 = new JButton("Flip");
      add(c3, BorderLayout.SOUTH);

      // calling game of War
      d = new Deck1();
      game = new War(d);
      title1 = new JLabel("Win");
      centerPanel1 = new JPanel(new FlowLayout());
      centerPanel1.add(title1);
      //title2 = new JLabel(game.determineWinner());
      //centerPanel2 = new JPanel();
      //centerPanel2.add(title2);
      add(centerPanel1, BorderLayout.CENTER);
      // display winner for round
      // display winner overall
      
      // divide center panel
      
      setVisible(true);
         
   }
   
   // to handle the button events
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent ae)
      {
         // click flip
            // react
               // display card
         
         
      }
   }
   
   public static void main(String [] args)
   {
      new WarGUI();
   }

}