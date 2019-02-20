/*
TODO Make whole pane scrollable
TODO put a button at the bottom of each scroll pane to populate the children and the parents of each one
TODO single modal that is hidden until that button is clicked, and is populated as stated above
TODO Recieve input from user to add / delete checkpoints
TODO Figure out how to make an exe file to click on from the desktop
TODO Toolbar on left side with a plus sign and a minus sign and an edit button
TODO Make each checkpoint a button? then you can click on it, change the border color onclick then populate screen with children of clicked
TODO Find good layout manager for the buttons to match theme
TODO Explore other fonts as well
*/
import java.awt.Container;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;
import java.util.ArrayList;
import java.io.File;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Flowerly extends JPanel{

 // private static Point startPoint;
  //private static Point endPoint;
  private static ArrayList<Checkpoint> checkpoints;
  private static JFrame frame;
  private static JScrollPane mainPane;
  private static JPanel container;
  public static void main(String[] args) {
    checkpoints = new ArrayList<Checkpoint>();

    Checkpoint chkpt = new Checkpoint();
    checkpoints.add(chkpt);
    chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a story that will be told interactively through the command line. The next step is to make the GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that might get fixed with the gui itself being able to wrap the text nicely");
    chkpt.setName("Test checkpoint");

    Checkpoint textField = new Checkpoint();
    checkpoints.add(textField);
    textField.addParent(chkpt);
    textField.setName("textField");

    Checkpoint testField = new Checkpoint();
    checkpoints.add(testField);
    testField.addParent(chkpt);
    testField.setName("testField");

    Checkpoint check = new Checkpoint();
    checkpoints.add(check);
    check.addParent(testField);
    check.setText("Hello from the final text box I will be adding text to this way. From now on I will be doing it through the input box I will be adding in at a later time"); 
    check.setName("check");
    
    for(int i = 0; i<20; i++){
        checkpoints.add(new Checkpoint());
    }

    Checkpoint point = new Checkpoint();
    point.setName("point");
    createOrUpdate();
    checkpoints.add(point);
    createOrUpdate();
  }



  //sets up the scrollbar look
  private static void setLayout(JScrollPane scroller){
   
    scroller.setLayout(new ScrollPaneLayout() {
      @Override
      public void layoutContainer(Container parent) {
        JScrollPane scrollPane = (JScrollPane) parent;

        Rectangle availR = scrollPane.getBounds();
        availR.x = availR.y = 0;

        Insets parentInsets = parent.getInsets();
        availR.x = parentInsets.left;
        availR.y = parentInsets.top;
        availR.width -= parentInsets.left + parentInsets.right;
        availR.height -= parentInsets.top + parentInsets.bottom;

        Rectangle vsbR = new Rectangle();
        vsbR.width = 12;
        vsbR.height = availR.height;
        vsbR.x = availR.x + availR.width - vsbR.width;
        vsbR.y = availR.y;

        if (viewport != null) {
          viewport.setBounds(availR);
        }
        if (vsb != null) {
          vsb.setVisible(true);
          vsb.setBounds(vsbR);
        }
      }
    });

    scroller.setComponentZOrder(scroller.getVerticalScrollBar(), 0);
    scroller.setComponentZOrder(scroller.getViewport(), 1);
    scroller.getVerticalScrollBar().setOpaque(false);
    scroller.getVerticalScrollBar().setUI(new MyScrollBarUI());
  }

  private static void save(){
    try{
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("checkpoint.fly"));
      oos.writeObject(checkpoints);
    }
    catch (IOException e){
      e.printStackTrace();
    }
  }

  private static void createOrUpdate(){
    int numDrawn;
    int x = 15;
    if(checkpoints.size() > 0){
      if(checkpoints.size() == 1)
        x = 550;
      else  
        x = 1400 / checkpoints.size() - 305;
      if(x < 15)
        x = 15;
    }
    
    int y = 10;
    if(frame == null)
    {
      frame = new JFrame("FLOWerly - Find Your Flow");
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(Color.cyan);
      frame.setSize(1400, 720);

      container = new JPanel(null);
      container.setBackground(Color.DARK_GRAY);
     
    }
    else{
      container.removeAll();
      container.revalidate();
      container.repaint();
    }
    for(Checkpoint c : checkpoints){
      JScrollPane pane = new JScrollPane(c.getTextArea());
      setLayout(pane);
      pane.setBounds(x, y, 300, 100);
      container.add(pane);
      x += 350;
      if(x > 1100){
        x = 15;
        y += 150;
      }
    }

    mainPane = new JScrollPane(container);
    mainPane.setMaximumSize(new Dimension(1400, 720));
    setLayout(mainPane);
    mainPane.setBackground(Color.DARK_GRAY);
    frame.getContentPane().add(mainPane);
    frame.setVisible(true);
  }
}

