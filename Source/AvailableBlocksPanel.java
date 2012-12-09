import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
//mouse imports
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;


public class AvailableBlocksPanel extends JPanel implements MouseListener,
                                                       MouseMotionListener
{
  Image selectedImage;
  Image[] smile = new Image[10]; 
  int yPos = 10;
  
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
     Graphics2D g2 = (Graphics2D)g;
     g2.setColor(Color.WHITE);
     
     //draw test images
     for(int i = 0; i < smile.length; i++) 
       g2.drawImage(smile[i], 30, yPos , null);
  }

  public AvailableBlocksPanel()
  {
    //set AvailableBlocksPanel preferences
    //set the preferred size for the JScroll to work
    setPreferredSize (new Dimension (280, 1500));
    setBackground(Color.WHITE);
    
    //Create Test images
    ImageIcon ii = new ImageIcon(this.getClass().getResource("block.png"));
    smile[0] = ii.getImage();
    //smile[1] = ii.getImage();
    //smile[2] = ii.getImage();
    
  }
  
  //*******************
  //MOUSE EVENTS
  //**************************
  //Mouse Pressed - Select objects
  public void mousePressed(MouseEvent event) {
    for(int i = 0; i < block.length; i++)
      if(event.getPoint().getX() > blockPosX[i] &&  event.getPoint().getX() < blockPosX[i] + 220)
      {
        if(event.getPoint().getY() > blockPosY[i] &&  event.getPoint().getY() < blockPosY[i] + 130)
        {
          mouseRelativePosX = (int) event.getPoint().getX() - blockPosX[i];
          mouseRelativePosY = (int) event.getPoint().getY() - blockPosY[i];
          selected = true;
          selectedBlock = i;
        }
      }
  }
  
  //mouse released - diselect any image
  public void mouseReleased(MouseEvent event) { selected = false; }

  //mouse dragged - move selected image
  public void mouseDragged(MouseEvent event) {
    if(selected)
    {
      blockPosX[selectedBlock] = ((int) event.getPoint().getX()) - mouseRelativePosX; ;
      blockPosY[selectedBlock] = (int) event.getPoint().getY() - mouseRelativePosY;
      repaint();
    }
  }
 
  //unused mouse events
  public void mouseClicked(MouseEvent event) {}
  public void mouseExited(MouseEvent event) {}
  public void mouseEntered(MouseEvent event) {}
  public void mouseMoved(MouseEvent event) {}
}
    
