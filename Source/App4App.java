//General
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
//Specific
 
public class App4App extends JFrame
{
  private AvailableBlocksPanel availableBlocks = new AvailableBlocksPanel();
  private ImplementationArea implementationArea = new ImplementationArea();
    
  public App4App()
  {
    //Window Settings
    setSize(1000, 600);
    
    //Set the window content layout
    Container contents = getContentPane();
    contents.setLayout(new BorderLayout());
    
    //Create availableAvailableBlocksPanel container and adding its content
    //create containers
    Container availableAvailableBlocksPanel = new Container();
    availableAvailableBlocksPanel.setPreferredSize(new Dimension(280, 600));
    Container implementationAreaPanel = new Container();
    implementationAreaPanel.setPreferredSize(new Dimension(700, 600));
    //set layouts
    availableAvailableBlocksPanel.setLayout(new BorderLayout());
    implementationAreaPanel.setLayout(new BorderLayout());
    //add components
    availableAvailableBlocksPanel.add(new JScrollPane(availableBlocks), BorderLayout.CENTER);
    availableAvailableBlocksPanel.add(new JLabel("Available Blocks"), BorderLayout.NORTH);
    implementationAreaPanel.add(new JScrollPane(implementationArea), BorderLayout.CENTER);
    implementationAreaPanel.add(new JLabel("Implementation Area"), BorderLayout.NORTH);
    
    //Build main Window
    JLabel appTitle = new JLabel("App4App");
    appTitle.setFont(new Font("Dialog", 1, 40));
    contents.add(appTitle, BorderLayout.NORTH);
    contents.add(implementationAreaPanel, BorderLayout.CENTER);
    contents.add(availableAvailableBlocksPanel, BorderLayout.WEST);
    //create and add the label
    
  }
  
  public static void main(String[] args)
  {
    App4App mainWindow = new App4App();
    mainWindow.setVisible(true);
    
  }
}
  
