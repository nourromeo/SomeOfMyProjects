import javax.swing.*;

public class mainGame extends JFrame {	
	JPanel upPanel, middlePanel, downPanel;
	JButton button[] = new JButton[9];
	int i = 0;
	
	
	public static void main(String[] args) {
		gameBoard g = new gameBoard();
		g.setTitle("TIC TOC GAME");
		g.setVisible(true);
		g.setSize(500, 550);
		g.setResizable(false);
		g.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}

