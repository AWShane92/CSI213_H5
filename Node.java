package H5;

public class Node {
	

	public int id;
	public String data;
	public Node next;
	
	//Constructors
	public Node(int id, String data){
		
		this.id = id;
		this.data = data;
		
	}
	//Getters and setter.
	public int getId(){		
		return this.id;
	}
	
	public void setId(int i){
		this.id = i;
	}
	
	public String getData(){	
		return this.data;
	}
	
	public void setData(String data){	
		this.data = data;
	}
	
	public void setNext(Node node){
		this.next = node;
	}
	
	public Node getNext(){	
		return this.next;
	}
	//Methods
	public String toSring(){
		// Returns the String "This Node is (Node: ID) (Node: DATA).
		return "This Node is: "+ this.id + " " + this.data;
	}

}
