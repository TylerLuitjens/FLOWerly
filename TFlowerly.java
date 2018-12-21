


import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.util.Map.Entry;
public class Flowerly extends JFrame{
	public static void main(String [] args){

		Checkpoint chkpt = new Checkpoint();
		chkpt.setText("This is a test entry for the checkpoint system. Hopefully these contents will someday hold part of a storyt that will be told interactively through the command line. The next step is to make the GUI that will show the full tree of children and parents, as well as make a new child from a given parent.I also need to figure out how to print it to the terminal nicely without having words get cut in half, although that might get fixed with the gui itself being able to wrap the text nicely");
		chkpt.setName("Test checkpoint");
		System.out.println(chkpt.toString());
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		}
		catch(Exception e){
			System.err.println("Metal is not available on this platform");
			System.exit(1);
		}

		UIManager.put("ScrollBarUI", "MyMetalScrollBarUI");
		UIDefaults uid = UIManager.getDefaults();
		//UIManager.put("ScrollBar.track", Color.cyan);
		//UIManager.put("ScrollBar.background", Color.red);
		//UIManager.put("ScrollBar.thumb", Color.black);

		JFrame frame = new JFrame("FLOWerly- Find your Flow");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.DARK_GRAY);	

		JScrollPane scroller = new JScrollPane();
	//	JEditorPane textPane = new JEditorPane();
	//	textPane.setText(chkpt.toString());

		JTextArea field = new JTextArea(10,25);
		field.setBackground(Color.LIGHT_GRAY);
		field.setText(chkpt.toString());
		field.setEditable(false);
		field.setLineWrap(true);
		field.setWrapStyleWord(true);
		JLabel label = new JLabel(chkpt.toString());

		JButton button = new JButton();
		button.setText("Press me"); //make actionListener later
		
		scroller.setViewportView(field);

		panel.add(scroller);
		//panel.add(button);
	
		frame.add(panel);
		frame.setSize(1280,720);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void colorKeys(){
		ArrayList<String> keys = new ArrayList<String>();
		Set<Entry<Object, Object>> entries = UIManager.getLookAndFeelDefaults().entrySet();

		for(Entry entry : entries){
			if(entry.getValue() instanceof Color){
				keys.add((String) entry.getKey());
			}
		}
		
		Collections.sort(keys);
		for(String colorKey : keys){
			System.out.println(colorKey);
		}
	}

}
