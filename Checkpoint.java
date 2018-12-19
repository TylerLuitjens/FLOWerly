import java.util.ArrayList; 

public class Checkpoint{
	
	private String text;
	private Checkpoint parent;
	private ArrayList<Checkpoint> children;

	public Checkpoint(){
		text = null;
		parent = null;
		children = new ArrayList<Checkpoint>();
	}
	
	public void addText(String newText){


	}
	
	public void addChild(Checkpoint child){
		children.add(child);
	}
}
