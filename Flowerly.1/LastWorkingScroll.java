import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.File;
import java.io.*;

public class LastWorkingScroll extends JPanel{

  private static Point startPoint;
  private static Point endPoint;
  private static ArrayList<Checkpoint> checkpoints;
  private static JFrame frame;


  public static void main(String[] args) {
    checkpoints = new ArrayList<Checkpoint>();

    Checkpoint chkpt = new Checkpoint();
    checkpoints.add(chkpt);
    chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a storyt that will be told interactively through the command line. The next step is to make the GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that might get fixed with the gui itself being able to wrap the text nicely");
    chkpt.setName("Test checkpoint");

    Checkpoint textField = new Checkpoint();
    checkpoints.add(textField);
    textField.addParent(chkpt);
    
    Checkpoint testField = new Checkpoint();
    checkpoints.add(testField);
    testField.addParent(chkpt);

    Checkpoint check = new Checkpoint();
    checkpoints.add(check);
    check.addParent(testField);
    check.setText("Hello from the final text box I will be adding text to this way. From now on I will be doing it through the input box I will be adding in at a later time"); 

    Checkpoint point = new Checkpoint();
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

    save();
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
    //TODO set bound mapping
    int numDrawn;
    int x = 0;
    if(checkpoints.size() > 0){
      if(checkpoints.size() == 1)
        x = 550;
      else  
        x = 1400 / checkpoints.size() - 305;
      if(x < 0)
        x = 0;
    }
    
    int y = 10;
    if(frame == null){
      frame = new JFrame("FLOWerly - Find Your Flow");
      frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
      frame.getContentPane().setBackground(Color.DARK_GRAY);
      frame.getContentPane().setLayout(null);
      frame.setSize(1400, 720);
    }
    else{
      frame.removeAll();
      frame.revalidate();
    }
    for(Checkpoint c : checkpoints){
      JPanel panel = new JPanel();
      panel.setBackground(Color.DARK_GRAY);
      panel.setBounds(x, y, 300, 100);
      JScrollPane pane = new JScrollPane(c.getTextArea());
      setLayout(pane);
      panel.add(pane);
      frame.add(panel);
      x += 350;
      if(x > 1400 - 300){
        x = 0;
        y += 150;
      }
    }
     frame.setVisible(true);
  }

}

