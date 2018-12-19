import java.util.ArrayList; 

public class Checkpoint{
	
	private String text, name;
	private Checkpoint parent;
	private ArrayList<Checkpoint> children, parents;
	private int x,y;
	public Checkpoint(){
		text = null;
		name = null;
		parents = new ArrayList<Checkpoint>();
		children = new ArrayList<Checkpoint>();
		x = -1;
		y = -1;
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
	}
	
	public String getText(){
		return text;
	}

	public void addChild(Checkpoint child){
		children.add(child);
	}
	
	public ArrayList<Checkpoint> getChildren(){
		return children;
	}

	public void addParent(Checkpoint parent){
		parents.add(parent);
	}

	public ArrayList<Checkpoint> getParents(){
		return parents;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public String toString(){
		String chkpt = "";
		if(name != null)
			chkpt = "Name: " + name + "\n";
		else
			chkpt = "--No name set-- \n";
		if(text != null)
			chkpt = chkpt.concat("  Contents: " + text + "\n");
		else
			chkpt = chkpt.concat("  --No text added--\n");
		chkpt = chkpt.concat("  Number of parents: " + parents.size() + "\n");
		chkpt = chkpt.concat("  Number of children: " + children.size() + "\n");
		return chkpt;
	}

}
