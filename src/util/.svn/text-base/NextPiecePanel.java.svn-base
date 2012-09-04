package util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import tetris.entities.Board;

/**
 * displays the next piece to the user.
 * @author Pete
 * @version 42
 */
public class NextPiecePanel extends JPanel implements Observer  {

  /**
   * serialized.
   */
  private static final long serialVersionUID = -3117591912693115266L;
  /**
   * creates a gap between pieces.
   */
  private static final double GAP = 1;
/**
   * the board object.
   */
  private final Board my_b;
  /**
   * constructs a next piece panel.
   * @param an_b the board.
   */
  public NextPiecePanel(final Board an_b) {
    super();
    my_b = an_b;
    my_b.addObserver(this);
  }
 

  /**
   * Paints stuff to the board. 
   * @param an_g creates the graphics for paint component.
   */
  public void paintComponent(final Graphics an_g) {
//    final int squares = 0;
//    final double w = getWidth();
    final double h = getHeight();
    final double s = h / 4;
    super.paintComponent(an_g);
    final Graphics2D g2d = (Graphics2D) an_g;
    for (int x = 0; x <= 3; x++) {
      for (int y = 0; y <= 3; y++) { 
        an_g.setColor(Color.black);
        for (int i = 0; i <= 3; i++) {
          if (my_b.nextPiece().blocks()[i].x() == x && my_b.nextPiece().blocks()[i].y() == y) {
            final Color c2 = my_b.nextPiece().color();
            an_g.setColor(c2);
            g2d.fill(new Rectangle2D.Double(x * s + GAP, y * s + GAP, 
              s - GAP, s - GAP));
          }
        }
      }
    }
  }
 
  @Override
  public void update(final Observable an_arg0, final Object an_arg1) {
    repaint();
  }
}
