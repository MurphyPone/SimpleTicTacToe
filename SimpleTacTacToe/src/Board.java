import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class Board extends JFrame implements ActionListener {

   public static final int ROWS = 3;
   public static final int COLS = 3;
   
	private JButton buttons[][];

	private String boardString = "";
   private static char whoseTurn;



// Constructors
	public Board(String title) {
		super(title);
      whoseTurn = 'x'; // x goes first
		setupFrame();
	}

	// required because of abstract method in ActionListener, but not used for TicTacToe
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	JPanel setupPanelOne() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		return panel;
	}

	private JPanel setupPanelTwo() {
		JButton b;
		JPanel panel = new JPanel();
		 panel.setLayout(new GridLayout(ROWS, COLS));
		buttons = new JButton[ROWS][COLS];

		int count = 1;

		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c <COLS; c++) {
				char ch = ' ';
				b = new JButton("" + ch);
				boardString += ch;
				b.setActionCommand("" + r + ", " + c);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
                  
						turn(btn);
					}
				});
				panel.add(b);
				buttons[r][c] = b;
			}

		return panel;
	}

	private JPanel setupPanelThree() {
		JButton resetButton;
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		resetButton = new JButton("Reset");

				resetButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						reset();
					}
				});
				panel.add(resetButton);
			

		return panel;
	}


	private void setupFrame() {
		JPanel panel2 = new JPanel();

		// Setup Frame
		super.setSize(250, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Setup Panels
		panel2 = setupPanelTwo(); // panelOne displays a value that requires panelTwo to be ready
		super.add(setupPanelOne());
		super.add(panel2);
      super.add(setupPanelThree());
		super.setVisible(true);
	}
   
   // Getters
   
   public char getWhoseTurn() {
     return whoseTurn;
   }
   
   // Setters
   
   public void setWhoseTurn(char ch) {
     whoseTurn = ch;
   }

	public char charAt(int row, int col) {
		String value = buttons[row][col].getText();
		if (value.length() > 0)
			return value.charAt(0);
		else
			return '*';
	}
  
	public void show(String s) {
		int pos = 0;
		String letter;
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < COLS; c++) {
				char ch = s.charAt(pos);
				switch (ch) {
				case '1':
					letter = "x";
					break;
				case '2':
					letter = "o";
					break;
				case '0':
					letter = " ";
					break;
				default:
					letter = "" + ch;
				}
				buttons[r][c].setText(letter);
				pos++;
			}
	   }

	public void setBoardString(String s) {
		boardString = s;
		show(s);
	}

	public String getBoardString() {
		return boardString;
	}
   
   public void clearBoard() {
     show("         ");
   }

   public int buttonRow(JButton btn) {
     for (int r = 0; r < ROWS; r++) 
       for (int c = 0; c < COLS; c++) 
         if (btn == buttons[r][c])
           return r;
     return -1;
   }

   public int buttonCol(JButton btn) {
     for (int r = 0; r < ROWS; r++) 
       for (int c = 0; c < COLS; c++) 
         if (btn == buttons[r][c])
           return c;
     return -1;
   }

    abstract void turn(JButton button);
    abstract void reset();    
}