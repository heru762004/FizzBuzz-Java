import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * FizzBuzz.java
 * Write a program that prints the numbers from 1 to 100. But for multiples of three print “Fizz” instead of the number and for the multiples of five print “Buzz”. For numbers which are multiples of both three and five print “FizzBuzz”
 * For a number which is not divisible by 3 or 5, print the number
 * 
 * Here's the sample of implementation of FizzBuzz Game
 * The rule is very simple
 * If you see Fizz, please Press A
 * If you see Buzz, please Press S
 * If you see FizzBuzz, please Press D
 * 
 * @author heru
 *
 */

public class FizzBuzz extends JFrame implements ActionListener, KeyListener{
	/**
	 * possible implementation 1 :
	 * @param start - number start
	 * @param end - end of number
	 * @return array of FizzBuzz result
	 */
	private static final int HEIGHT = 400;

	private static final int WIDTH = 400;
	private JLabel labelInfo;
	private JButton btnStart;
	
	private JLabel labelGame;
	private JLabel labelScore;
	private JTextField txtInput;
	private JFrame myFrame;
	int score;
	
	public FizzBuzz() {
		myFrame = this;
		setLayout(null);
		labelInfo = new JLabel("<html>If you see Fizz, please Press A<BR>If you see Buzz, please press S<BR>If you see FizzBuzz, please press D</html>");
		labelInfo.setBounds(1,1,WIDTH,80);
		
		btnStart = new JButton("START");
		btnStart.setBounds(1,85,100,50);
		
		labelGame = new JLabel("asd");
		labelGame.setBackground(Color.RED);
		labelGame.setBounds(1,140,WIDTH,80);
		
		txtInput = new JTextField();
		txtInput.setBounds(1, 225, WIDTH, 80);
		txtInput.addKeyListener(this);
		
		labelScore = new JLabel("Score : " + score);
		labelScore.setBounds(1, 310, WIDTH, 80);
		
		btnStart.addActionListener(this);
		
		this.add(labelInfo);
		this.add(btnStart);
		this.add(labelGame);
		this.add(txtInput);
		this.add(labelScore);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		
        setDefaultCloseOperation(EXIT_ON_CLOSE);


	}
	public String[] fizzBuzz_1(int start, int end) {
		// make array result to return the result
		// size is end - start
		String ans[] = new String[(end - start)];
		// to store the current position of the array result
		int pos = 0;
		for(int i=start; i < end; i++) {
			String a = "";
			// if its divisible by 5, print "Fizz"
			if(i % 3 == 0) a += "Fizz";
			// if its divisible by 5, print "Buzz"
			if(i % 5 == 0) a += "Buzz";
			// if its not divisible by 3 or 5, the a keeps empty
			if(a.length() == 0) a=i+"";
			ans[pos++] = a;
		}
		return ans;
	}
	
	/**
	 * possible implementation 2 :
	 * @param start - number start
	 * @param end - end of number
	 * @return array of FizzBuzz result
	 */
	public String[] fizzBuzz_2(int start, int end) {
		// make array result to return the result
		// size is end - start
		String ans[] = new String[(end - start)];
		// to store the current position of the array result
		int pos = 0;
		for(int i=start; i < end; i++) {
			String a = "";
			// if its divisible by 3 and 5, print "FizzBuzz"
			if(i % 3 == 0 && i % 5 == 0) a = "FizzBuzz";
			// if its divisible by 5, print "Fizz"
			else if(i % 3 == 0) a = "Fizz";
			// if its divisible by 5, print "Buzz"
			else if(i % 5 == 0) a = "Buzz";
			// if its not divisible by 3 or 5, the a keeps empty
			else a=i+"";
			ans[pos++] = a;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		FizzBuzz a = new FizzBuzz();
//		String result[] = a.fizzBuzz_1(1, 100);
//		for(int i=0; i < result.length; i++) {
//			System.out.println(result[i]);
//		}
//		String result2[] = a.fizzBuzz_2(1, 100);
//		for(int i=0; i < result2.length; i++) {
//			System.out.println(result2[i]);
//		}
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnStart) {
			btnStart.setEnabled(false);
			score = 0;
			startGame();
			this.addKeyListener(this);
		}
	}
	
	public void startGame() {
		Thread worker = new Thread() {
			  public void run() {
				  String result2[] = fizzBuzz_2(1, 100);
					for(int i=0; i < result2.length; i++) {
						labelGame.setText(result2[i]);
						labelGame.paintImmediately(labelGame.getVisibleRect());
						txtInput.setText("");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(myFrame, "Game Finished! Your Score = " + score);
					btnStart.setEnabled(true);
					score = 0;
					txtInput.setText("");
					labelScore.setText("Score : " + score);
			  }
		};
		worker.start();
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int id = e.getID();
        String keyString = null;
        char c = 0;
        if (id == KeyEvent.KEY_TYPED) {
            c = e.getKeyChar();
            keyString = "key character = '" + c + "'";
        }
        if(labelGame.getText().equalsIgnoreCase("Fizz") && c == 'a') {
        	score+=100;
        }
        if(labelGame.getText().equalsIgnoreCase("Buzz") && c == 's') {
        	score+=100;
        }
        if(labelGame.getText().equalsIgnoreCase("FizzBuzz") && c == 'd') {
        	score+=150;
        }
        labelScore.setText("Score : " + score);
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
