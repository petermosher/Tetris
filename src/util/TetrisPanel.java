package util;

//import gui.Grid;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;
import tetris.entities.Board;
import tetris.entities.Point;

/**
 * Creates the game board that you play on.
 * @version 42
 * @author Pete
 */
public class TetrisPanel extends JPanel implements Observer {
  
  /**
   * end of line print statement.
   */
  private static final String END_OF_LINE = "END OF LINE";
  /**
   * Times New Roman Font choice.
   */
  private static final String TIMES_NEW_ROMAN = "Times New Roman";
  /**
   * Now its serialized.
   */
  private static final long serialVersionUID = 8236260313771493800L;
  /**
   * Sets the scale for the tetris panel.
   */
  private static final double SCALE = 10;
  /**
   * passes a board object to the panel for usage of board methods.
   */
  private final Board my_b;
  /**
   * creates a timer for each increment that the piece moves down.
   */
  private final Timer my_t;

  /**
   * sends the timer to another class (I want to send it to the Frame).
   * @return returns the timer.
   */
  public Timer getTimer() {
    return my_t;
  }

/**
   * creates a tetris Panel.
   * @param an_b is the board that is inputted.
   */
  public TetrisPanel(final Board an_b) {
    super();
    my_b = an_b;

    my_b.addObserver(this);
    my_t = new Timer(1000, new updateListener());
    my_t.start();
  }

  /**
   * Paints to the window.
   * @param an_g the graphics variable that the paint component uses.
   */
  public void paintComponent(final Graphics an_g) {
    super.paintComponent(an_g);
    final Graphics2D g2d = (Graphics2D) an_g;
    Image img;
    try {
      img = ImageIO.read(new File("src/russib.jpg"));
      an_g.drawImage(img, 0, 0, null);
    } catch (final IOException e) {
 
      e.printStackTrace();
    }
 
    final Color c = Color.black;
    an_g.setColor(c);
    double s = SCALE;
//    final double w = getWidth();
    final double h = getHeight();
    final double gap = h / 200;
//        s = w/(10+1);
    s = h / 20;
 
    for (int x = 0; x <= 9; x++) {
      an_g.setColor(c);
      for (int y = 0; y <= 19; y++) {
        if (my_b.color(new Point(x, y)) != null) {
          final Color c2 = my_b.color(new Point(x, y));
          an_g.setColor(c2);
          g2d.fill(new Rectangle2D.Double(x * s + gap, (19 - y) * s + gap, s - gap, s - gap));
        }
      }
    } /*end x for statement*/

    if (!getTimer().isRunning()) {
        Font f1 = new Font(TIMES_NEW_ROMAN, Font.BOLD, 22);
        g2d.setFont(f1);
        g2d.setColor(Color.black);
        g2d.drawString("PAUSED", 50, 100);
    }
    
    if (my_b.isFull()) {
      my_t.stop();
//      System.err.println("GAMEOVER");
      Font f1 = new Font(TIMES_NEW_ROMAN, Font.BOLD, 22);
      g2d.setFont(f1);
      g2d.setColor(Color.black);
      g2d.drawString(END_OF_LINE, 50, 100);
 
      f1 = new Font(TIMES_NEW_ROMAN, Font.BOLD, 19);
      g2d.setFont(f1);
      g2d.setColor(Color.white);
      g2d.drawString(END_OF_LINE, 50, 100);
    }
  }

  /**
   * Returns the board to another class, to make use of its methods.
   * @return return the board.
   */
  public Board getB() {
    return my_b;
  }

  /**
   * updates the tetris panel. Repaints.
   * @param an_arg0 
   * @param an_arg1 
   */
  @Override
  public void update(final Observable an_arg0, final Object an_arg1) {
    repaint();
  }

  /**
   * at each time increment the current piece moves down.
   */
  private class updateListener implements ActionListener {
    @Override
    public void actionPerformed(final ActionEvent an_e) {
      my_b.moveDown();
    }
  } 
}

