import java.awt.*;


import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;

class gameBoard extends JFrame implements ActionListener {	
	private JLabel playerX, playerO, itsTurn, labelLogo;
	private JPanel upPanel, middlePanel, downPanel;
	private JButton button[] = new JButton[9];
	private JButton buttonClicked;
	int i = 0;
	int clicked = 0;
	private ImageIcon imageLogo;
	private int playerXPoints = 0;
	private int playerOPoints = 0;
	
	gameBoard(){

		upPanel = new JPanel();
		upPanel.setBackground(Color.getHSBColor(230,255,170));
		add(upPanel, BorderLayout.NORTH);
		middlePanel = new JPanel();
		middlePanel.setBackground(Color.black);
		add(middlePanel, BorderLayout.CENTER);
		downPanel = new JPanel();	
		downPanel.setBackground(Color.getHSBColor(230,255,170));
		add(downPanel, BorderLayout.SOUTH);
		imageLogo = new ImageIcon(getClass().getResource("tttlogoo.png"));
    	labelLogo = new JLabel(imageLogo);
    	downPanel.add(labelLogo);
		
		
    	
		playerX = new JLabel("Player X Score: 0");
		upPanel.add(playerX);
		playerX.setFont(new Font("Sans", Font.BOLD, 20));
		itsTurn = new JLabel("   its X turn  ");
    	itsTurn.setForeground(Color.blue);
		upPanel.add(itsTurn);
		itsTurn.setFont(new Font("Sans", Font.BOLD, 20));
		playerO = new JLabel(" Player O Score: 0");
		upPanel.add(playerO);
		playerO.setFont(new Font("Sans", Font.BOLD, 20));
	
		
		for(i = 0; i < 9; i++) {
			button[i] = new JButton();
			middlePanel.add(button[i]);
			middlePanel.setLayout(new GridLayout(3, 0, 2, 2));
			button[i].addActionListener(this);
			
		}

	}
	
	   public void resetButtons() {
	        for(int i = 0; i <= 8; i++) {
	            button[i].setText("");
	        }
	        
	    }
	   
	   private void playerXWins() {
           int response = JOptionPane.showConfirmDialog(null, "Player X wins. Do you want to start the game?");
       			if (response == JOptionPane.YES_OPTION ) {
       				resetButtons();
       				
       			} else if (response == JOptionPane.NO_OPTION) {
       				dispose();
       				
       			}
	   }
	   
	   private void playerOWins() {
           int response = JOptionPane.showConfirmDialog(null, "Player O wins. Do you want to start the game?");
           		if (response == JOptionPane.YES_OPTION ) {
           			resetButtons();
       			
           		} else if (response == JOptionPane.NO_OPTION) {
           			dispose();
           		}
	   }

	       
	   public void actionPerformed(ActionEvent e) {
	            buttonClicked = (JButton)e.getSource();
	            
	            if (clicked % 2 == 0) {
	            	buttonClicked.setText("X");
	            	buttonClicked.setForeground(Color.blue);
	            	buttonClicked.setFont(new Font("Sans", Font.BOLD, 70));
	            	
	            } else {
	                buttonClicked.setText("O");
	            	buttonClicked.setForeground(Color.red);
	            	buttonClicked.setFont(new Font("Sans", Font.BOLD, 70));

	            }  clicked++;

	            
	            if (checkForWin()) {
	            	if(clicked % 2 == 0) {
	            		playerOWins();
	            		playerOPoints++;
	                    playerO.setText("Player O Score:" + playerOPoints++);

	          		   
	            	} else {
	            		playerXWins();
	            		playerXPoints++;
	                    playerX.setText("Player X Score:" + playerXPoints++);

	            	}
	            	
	            } 

	            
	            if (clicked % 2 == 0) {
	            	itsTurn.setText("   its X turn  ");
	            	itsTurn.setForeground(Color.blue);
	            	itsTurn.setFont(new Font("Sans", Font.BOLD, 20));

	            	
	            } else {
	            	itsTurn.setText("   its O turn  ");
	            	itsTurn.setForeground(Color.red);
	            	itsTurn.setFont(new Font("Sans", Font.BOLD, 20));



	            }
	        }
	        
	   
	        public boolean checkForWin()
	        {
	            /**
	             *      0 | 1 | 2
	             *      3 | 4 | 5
	             *      6 | 7 | 8
	             */
	        	
	        	
	            //Im ckecking th button in a horizontal.
	            if( buttonCheck(0,1) && buttonCheck(1,2) )
	                return true;
	            else if( buttonCheck(3,4) && buttonCheck(4,5) )
	                return true;
	            else if ( buttonCheck(6,7) && buttonCheck(7,8))
	                return true;
	            
	            //vertical win check
	            else if ( buttonCheck(0,3) && buttonCheck(3,6))
	                return true;  
	            else if ( buttonCheck(1,4) && buttonCheck(4,7))
	                return true;
	            else if ( buttonCheck(2,5) && buttonCheck(5,8))
	                return true;
	            
	            //diagonal win check
	            else if ( buttonCheck(0,4) && buttonCheck(4,8))
	                return true;  
	            else if ( buttonCheck(2,4) && buttonCheck(4,6))
	                return true;
	            else 
	                return false;
	            
	            
	        }
	        
	        public boolean buttonCheck(int a, int b)
	        {
	            if ( button[a].getText().equals(button[b].getText()) && !button[a].getText().equals("") )
	                return true;
	            else
	                return false;
	        }


}
