import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

//FOR TESTING PURPOSES
import javax.swing.JFrame;
 
public class ImplementationArea extends JPanel implements MouseListener, MouseMotionListener
{
  //***********************
  //to be stored in the block class to make one single array of blocks
  //****************************
  private Image[] block = new Image[4];
  private int[] blockPosX = new int[4];
  private int[] blockPosY = new int[4];

  //********************
  //Implementation Area global private variables
  //************************
  private int selectedBlock = 0;
  private boolean selected = false;
  private int mouseRelativePosX = 0;
  private int mouseRelativePosY = 0;
  
  public ImplementationArea()
  {
    setPreferredSize(new Dimension(700, 600));
    setBackground(Color.WHITE);
    addMouseListener(this);
    addMouseMotionListener(this);
    
    //*******************************
    //FOR TESTING PURPOSES
    //********************************
    ImageIcon blockIcon = new ImageIcon(this.getClass().getResource("block.png"));
    block[0] = blockIcon.getImage(); blockPosX[0] = 10; blockPosY[0] = 10;
    block[1] = blockIcon.getImage(); blockPosX[1] = 10; blockPosY[1] = 200;
    block[2] = blockIcon.getImage(); blockPosX[2] = 10; blockPosY[2] = 400;
    block[3] = blockIcon.getImage(); blockPosX[3] = 10; blockPosY[3] = 600;
  }

  //**************************
  //called everytime the area is painted
  //********************************
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
     Graphics2D g2 = (Graphics2D) g;

     //FOR TESTING PURPOSES
    for(int i = 0; i < block.length; i++) 
     g2.drawImage(block[i], blockPosX[i], blockPosY[i], null);
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
  

  //*************************
  //FOR TESTING PURPOSES
  //*******************************
  public static void main(String[] args)
  { 
    JFrame testFrame = new JFrame();
    testFrame.add(new ImplementationArea());
    testFrame.setSize(new Dimension(700,600));
    testFrame.setVisible(true);
  }

}
