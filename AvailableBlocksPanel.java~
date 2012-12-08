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


public class AvailableBlocksPanel extends JPanel
{
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
}
    
