import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JFrame;
public class Flowerly extends JFrame{
	public static void main(String [] args){
		Checkpoint chkpt = new Checkpoint();
		chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a storyt that will be told interactively through the command line. The next step is to make the \n	GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that\n	 might get fixed with the gui itself being able to wrap the text nicely");
		chkpt.setName("Test checkpoint");
		System.out.println(chkpt.toString());
	}
}
