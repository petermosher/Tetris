package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import tetris.entities.Board;

/**
 * The idea is that this panel will communicate with the others to display the score.
 * after a line is cleared a score is determined.
 * @author Peter
 *
 */
public class ScorePanel extends JPanel implements Observer {
  /**
   * variable to keep track of the score.
   */
  private long score;
  /**
   * passes a board object to the panel for usage of board methods.
   */
  private final Board my_b;

  
  public ScorePanel(final Board an_b) {
	    super();
	    my_b = an_b;
//	    score = 0;
	    my_b.addObserver(this);
  }
  /**
   * paints text to the Score Panel.
   * @return an_g the graghics object.
   */
  public void paintComponent(final Graphics an_g) {
    super.paintComponent(an_g);
    final Graphics2D g2d = (Graphics2D) an_g;
    
    
    if (my_b.lastLinesRemoved() == 1) {
      score = score + 1;
    } else if (my_b.lastLinesRemoved() == 2) {
      score = score + 10;
    } else if (my_b.lastLinesRemoved() == 3) {
      score = score + 100;
    } else if (my_b.lastLinesRemoved() == 4) {
      score = score + 1000;
    }
    	
 
    final Font f1 = new Font("Times New Roman", Font.BOLD, 14);
    g2d.setFont(f1);
    g2d.setColor(Color.black);
    g2d.drawString("The Score", 0, 20);
    g2d.drawString(score+"", 0, 40);
    g2d.drawString("1 line = 1 points", 0, 100);
    g2d.drawString("2 lines = 10 points", 0, 120);
    g2d.drawString("3 lines = 100 points", 0, 140);
    g2d.drawString("4 lines = 1000 points", 0, 160);
    System.out.println(score+ " : "+my_b.lastLinesRemoved());
  }

  @Override
  public void update(Observable arg0, Object arg1) {
    repaint();
  }

  public void setScore(long score) {
    this.score = score;
  }

  public long getScore() {
    return score;
  }
}
