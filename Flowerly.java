import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.*;
//from  w w w. j  a  va  2 s  .c  o m
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneLayout;
import javax.swing.WindowConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;



public class Flowerly {
  public static void main(String[] args) {

	Checkpoint chkpt = new Checkpoint();
	chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a storyt that will be told interactively through the command line. The next step is to make the GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that might get fixed with the gui itself being able to wrap the text nicely");
	chkpt.setName("Test checkpoint");

    	JTextArea textArea = new JTextArea(10,25);
	textArea.setText(chkpt.toString());
	textArea.setBackground(Color.LIGHT_GRAY);
	textArea.setEditable(false);
	textArea.setLineWrap(true);
	textArea.setWrapStyleWord(true);
	JScrollPane scrollPane = new JScrollPane(textArea);
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
	panel.setLayout(new FlowLayout());
	panel.setBackground(Color.DARK_GRAY);
    
	frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	frame.getContentPane().setBackground(Color.DARK_GRAY);
 	panel.add(scrollPane);   
	frame.add(panel);
    frame.setSize(1280, 720);
    frame.setVisible(true);
  }
}

