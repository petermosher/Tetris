package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import tetris.entities.Board;

/**
 * Panel containing the instructions.
 * @author Pete
 * @version 42
 */
public class InstructionsPanel extends JPanel {

  /**
   * serializes ControlsPanel.
   */
  private static final long serialVersionUID = -4120992647683459524L;
/**
   * instructions for using the space bar in game.
   */
  private static final String SPACE_BAR = "space bar- drop piece down quickly";
  /**
   * instructions for using the down arrow in game.
   */
  private static final String DOWN_ARROW = "down arrow- moves piece down";
  /**
   * instructions for using the right arrow in game.
   */
  private static final String RIGHT_ARROW = "right arrow- moves piece right";
  /**
   * instructions for using the left arrow in game.
   */
  private static final String LEFT_ARROW = "left arrow- moves piece left";
  /**
   * instructions for using the up arrow in game.
   */
  private static final String UP_ARROW = "up arrow- rotates the current piece";
  /**
   * the Controls Panel really shouldn't need to use the board for anything.
   */
//  private Board b;
  /**
   * controls panel gives user instructions on how to play.
   * @param an_b
   */
//  public ControlsPanel() {
//    super();
//  }
  
  /**
   * does paint component things.
   * @param an_g modifies the graphics of the panel.
   */
  public void paintComponent(final Graphics an_g) {
    super.paintComponent(an_g);
    final Graphics2D g2d = (Graphics2D) an_g;
 
    final Font f1 = new Font("Times New Roman", Font.BOLD, 12);
    g2d.setFont(f1);
    g2d.setColor(Color.black);
    g2d.drawString(UP_ARROW, 0, 20);
    g2d.drawString(LEFT_ARROW, 0, 40);
    g2d.drawString(RIGHT_ARROW, 0, 60);
    g2d.drawString(DOWN_ARROW, 0, 80);
    g2d.drawString(SPACE_BAR, 0, 100);
    g2d.drawString("P- pauses the game", 0, 120);
  }
}
