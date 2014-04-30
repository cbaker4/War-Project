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

/* This works for everything. I just don't have it operate when a
   war happens. */  

public class WarGUI extends JFrame
{
   private War game;
   private JPanel topPanel, bottomPanel, gamePanel, right, left;
   private JLabel status, title, ply1, ply2,b1,b2;
   private Deck1 d;
   private JButton c3;
   
   public WarGUI()
   {
      // create layout
      setLayout(new BorderLayout());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(700,600);
      
      // top panel
      topPanel = new JPanel();
      topPanel.setBackground(Color.cyan);
      title = new JLabel("Caitlin's Game of War");
      title.setFont(new Font("ARIAL",Font.BOLD,30));
      topPanel.add(title);
      add(topPanel, BorderLayout.NORTH);
      
      // left and right panel
      ImageIcon back;
      left = new JPanel();
      ply1 = new JLabel("Player 1");
      back = new ImageIcon("back.jpg");
      ply1.setIcon(back);
      left.add(ply1);
      right = new JPanel();
      ply2 = new JLabel("Player 2");
      ply2.setIcon(back);
      right.add(ply2);
      add(left, BorderLayout.WEST);
      add(right, BorderLayout.EAST);
      
      // center panel
      c3 = new JButton("Flip");
      gamePanel = new JPanel(new FlowLayout());
      b1 = new JLabel("Player 1");
      b2 = new JLabel("Player 2");
      c3.addActionListener(new ButtonListener());
      gamePanel.add(c3);
      gamePanel.add(b1);
      gamePanel.add(b2);
      add(gamePanel, BorderLayout.CENTER);
      
      // bottom panel
      bottomPanel = new JPanel();
      bottomPanel.setBackground(Color.cyan);
      status = new JLabel("Playing Game");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      bottomPanel.add(status);
      add(bottomPanel, BorderLayout.SOUTH);
      
      // call game of war
      d = new Deck1();
      game = new War(d);
      
      setVisible(true);
         
   }
   
   // to handle the button events
   private class ButtonListener implements ActionListener
   {
      // runs the game when you click flip
      public void actionPerformed(ActionEvent ae)
      {
         game.playerDeck();
         
         
         // winner of round
         if (game.isEmpty() == false)
         {
            game.play();
            
            b1.setIcon(game.flipCard1().getPic());
            b2.setIcon(game.flipCard2().getPic());
            
            if (game.winner() == 1)
               status.setText("Player 1 wins"); 
            else if (game.winner() == 2)
               status.setText("Player 2 wins");
            else
               status.setText("War");
            
            
         }
         
         // winner of game
         else if (game.isEmpty() == true)
         {
            if(game.determineWinner() == 1)
               status.setText("Player 1 wins game");
            else if(game.determineWinner() == 2)
               status.setText("Player 2 wins game");
            disableAll();
         } 
      }
   }
   
   // disable buttons
   public void disableAll()
   {
      c3.setEnabled(false);
   }
   
   public static void main(String [] args)
   {
      new WarGUI();
   }

}