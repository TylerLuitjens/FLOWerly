import java.util.ArrayList; 
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Color;

public class Checkpoint{
	
	private String text, name;
	private Checkpoint parent;
	private ArrayList<Checkpoint> children, parents;
	private int x,y;
	private JTextArea textArea;
	public Checkpoint(){
		text = null;
		name = null;
		parents = new ArrayList<Checkpoint>();
		children = new ArrayList<Checkpoint>();
		x = -1;
		y = -1;
		setTextArea();
	}
	
	public void setX(int x){
		this.x = x;
	}

	public int getX(){
		return x;
	}

	public void setY(int y){
		this.y = y;
	}

	public int getY(){
		return y;
	}

	public void setLoc(int x, int y){
		this.x = x;
		this.y = y;
	}

	public void setText(String newText){
		text = newText;
		textArea.setText(this.toString());
	}
	
	public String getText(){
		return text;
	}

	public void addChild(Checkpoint child){
		children.add(child);
		textArea.setText(this.toString());
	}
	
	public ArrayList<Checkpoint> getChildren(){
		return children;
	}

	public void addParent(Checkpoint parent){
		parents.add(parent);
		textArea.setText(this.toString());
	}

	public ArrayList<Checkpoint> getParents(){
		return parents;
	}
	
	public void setName(String name){
		this.name = name;
		textArea.setText(this.toString());
	}

	public String getName(){
		return name;
	}

	private void setTextArea(){
		JTextArea textArea = new JTextArea(5,15);
		textArea.setMargin( new Insets(0,10,0,10) );
		textArea.setText(this.toString());
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		this.textArea = textArea;
	}

	public JTextArea getTextArea(){
		return textArea;
	}

	public String toString(){
		String chkpt = "";
		if(name != null)
			chkpt = "Name: " + name + "\n\n";
		else
			chkpt = "--No name set-- \n\n";
		if(text != null)
			chkpt = chkpt.concat("Contents: \n" + text + "\n\n");
		else
			chkpt = chkpt.concat("--No text added--\n\n");
		chkpt = chkpt.concat("Number of parents: " + parents.size() + "\n");
		chkpt = chkpt.concat("Number of children: " + children.size() + "\n");
		return chkpt;
	}

}
