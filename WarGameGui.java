import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class WarGameGui extends JFrame
{
   public static void main (String[] args) 
   {
		// set up frame container
		JFrame frame = new WarGameGui();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      frame.pack();
	}
   //define variables
   private War game;
   private JPanel leftestPanel, lefterPanel, leftUpperPanel, rightUpperPanel, middleUpperPanel;
   private JLabel update, status, leftLabel, middleLabel, leftLabel2 ;
   
   private JButton roundButton;
   /**
   constructor setsup gui and creates object of war class
   */
   public WarGameGui()
   {
      setLayout(new FlowLayout());
      game = new War();
      
      leftestPanel = new JPanel();
      lefterPanel = new JPanel();
      leftUpperPanel = new JPanel();
      leftUpperPanel.setBackground(Color.red);
      rightUpperPanel = new JPanel();
      middleUpperPanel= new JPanel();
      middleUpperPanel.setBackground(Color.blue);
      

      
      roundButton = new JButton("start round");
      rightUpperPanel.add(roundButton);
      roundButton.addActionListener(new ButtonListener());
      ImageIcon player1Deck= new ImageIcon("back.jpg");
      ImageIcon player2Deck= new ImageIcon("back.jpg");
      
      update = new JLabel();
      update.setFont(new Font("ARIAL",Font.BOLD,24));
      leftestPanel.add(update);
      status= new JLabel("Game in Progress");
      status.setFont(new Font("ARIAL",Font.BOLD,24));
      lefterPanel.add(status);
      
      leftLabel = new JLabel(player1Deck);
      middleLabel = new JLabel(player2Deck);
      
      leftUpperPanel.add(leftLabel);
      middleUpperPanel.add(middleLabel);
      
      
      
      add(lefterPanel);
      
      add(leftUpperPanel);
      
      add(middleUpperPanel); 
      
      add(rightUpperPanel);
      
      add(leftestPanel);
   }    
      
  
   
   
   /** does a round of war every button press
   */
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      { 
         
            String p1c, p2c, win;
            Card card1, card2, warloot;
            int ct = 0;
            ArrayList<Card> loot = new ArrayList<Card>();
            
            
            loot.clear();
            card1 = game.getPlayer1Card();
            card2 = game.getPlayer2Card();
            p1c=(card1.toString() + ".jpg");
            p2c=(card2.toString() + ".jpg");
         

            ImageIcon player1Card= new ImageIcon(p1c);
            ImageIcon player2Card= new ImageIcon(p2c);
            
            
            
         
         
            leftLabel.setIcon(player1Card);
            middleLabel.setIcon(player2Card);
            update.setText("");   
            pack();
            
            
            while(card1.equals(card2))
            {
               update.setText("WAR! \nPlayer 1 and 2 place 1 card face down");
               pack();
               
                              
               ct++;
               
               
               //add first cards to pile
               
               loot.add(card1);
               loot.add(card2);
               
               //check to see if can put card down
               
               
               while(game.gameOver()==true)
               {
                  win = game.whoWon();
                  status.setText(win);
               
                  pack();
               }
             
               
               //get face down card
               card1 = game.getPlayer1Card();
               card2 = game.getPlayer2Card();
               
               
               
               
               //add facedown card to pile
               loot.add(card1);
               loot.add(card2);
               
               //check to make sure cards can be drawn
               
               while(game.gameOver()==true)
               {
                  win = game.whoWon();
                  status.setText(win);
               
                  pack();
               }
              
               
               //draw new cards for war showdown
               card1 = game.getPlayer1Card();
               card2 = game.getPlayer2Card();
               
               
               p1c=(card1.toString() + ".jpg");
               p2c=(card2.toString() + ".jpg");
         

               ImageIcon player1Card2 = new ImageIcon(p1c);
               ImageIcon player2Card2 = new ImageIcon(p2c);
            
            
            
         
         
               leftLabel.setIcon(player1Card2);
               middleLabel.setIcon(player2Card2);
        
               pack();
            }   
            
            if (ct>0)
            {
               win = game.cardWarWin(card1,card2);
               if(win.equalsIgnoreCase("player 1 won the war"))
               {
                  for(int i = 0; i < loot.size();i++)
                  {
                      
                     warloot = loot.get(i);
                        
                     game.addWinning1(warloot);
                  }
               }  
               
               
               if(win.equalsIgnoreCase("player 2 won the war"))
               {
                  for(int i = 0; i < loot.size();i++)
                  {
                      
                     warloot = loot.get(i);
                        
                     game.addWinning2(warloot);
                  }
               } 
                  
               status.setText(win);
               pack();  
            }      
            
            if (ct==0)
            {
               win = game.winner(card1,card2);
               status.setText(win);
            
               pack();
            }
         
            while(game.gameOver()==true)
            {
               win = game.whoWon();
               status.setText(win);
               
               pack();
            }   
         
        
      } 
   }     
}      
   