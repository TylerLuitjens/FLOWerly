import java.util.ArrayList; 
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.Color;
import java.io.*;
public class Checkpoint implements Serializable{
	
	private String text, name;
	private Checkpoint parent;
	private ArrayList<Checkpoint> children, parents;
	private int x,y;
	private JTextArea textArea;
	public Checkpoint(){
		text = " --NO TEXT SET-- ";
		name = " --NO NAME SET-- ";
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
		parent.addChild(this);
	}

	public ArrayList<Checkpoint> getParents(){
		return parents;
	}
	
	public void setName(String name){
		this.name = "--" + name + "--";
		textArea.setText(this.toString());
	}

	public String getName(){
		return name;
	}

	private void setTextArea(){
		JTextArea textArea = new JTextArea(5,15);
		textArea.setMargin( new Insets(5,10,0,10) );
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
		String chkpt =   name + "\n\n";
		chkpt = chkpt.concat(text + "\n\n");
		chkpt = chkpt.concat("Num parents: " + parents.size() + "\n");
		chkpt = chkpt.concat("Num children: " + children.size());
		return chkpt;
	}

}
