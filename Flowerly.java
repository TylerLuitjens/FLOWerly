import java.awt.*;
import javax.swing.*;

public class Flowerly extends JPanel{
	private static Point startPoint;
	private static Point endPoint;
  public static void main(String[] args) {

	Checkpoint chkpt = new Checkpoint();
	chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a storyt that will be told interactively through the command line. The next step is to make the GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that might get fixed with the gui itself being able to wrap the text nicely");
	chkpt.setName("Test checkpoint");

	JScrollPane scrollPane = new JScrollPane(chkpt.getTextArea());
    	scrollPane.setComponentZOrder(scrollPane.getVerticalScrollBar(), 0);
    	scrollPane.setComponentZOrder(scrollPane.getViewport(), 1);
    	scrollPane.getVerticalScrollBar().setOpaque(false);

    	scrollPane.setLayout(new ScrollPaneLayout() {
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


      scrollPane.getVerticalScrollBar().setUI(new MyScrollBarUI());
    
      JFrame frame = new JFrame("FLOWerly - Find Your Flow");

	    JPanel panel = new JPanel();
	    //panel.setBorder(new EmptyBorder(10,10,10,10));
	    //panel.setLayout(null);
	    panel.setBackground(Color.DARK_GRAY);
        	panel.setBounds(485,10,300,100);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame.getContentPane().setBackground(Color.DARK_GRAY);
	    frame.getContentPane().setLayout(null);
     	panel.add(scrollPane); 

	    JPanel testPanel = new JPanel();
	    testPanel.setBackground(Color.cyan);
	    testPanel.setBounds(485, 170, 300, 100);
	    startPoint = new Point(testPanel.getX(), testPanel.getY());
	    endPoint = new Point(panel.getX(), panel.getY());
	    //drawLine(startPoint,endPoint);

	    frame.add(panel);
	    frame.add(testPanel);
    	frame.setSize(1280, 720);
    	frame.setVisible(true);
  }




}

