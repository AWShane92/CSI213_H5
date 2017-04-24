package H5;

public class Node {
	
	//Properties
		private String data;
		private Node previous;
		private Node next;
		private int id;	
		
		
		//Constructors
		public Node(String data){
			//Random number generator
			this.id = (int)(Math.random() * 100);
			this.data = data;
			this.previous = null;
			this.next = null;
			
		}
		public Node(int id, String data){
			this.id = id;
			this.data = data;
			this.previous = null;
			this.next = null;
		}	
		//Methods
		public String getData(){
			return this.data;
		}
		public void setData(String data){
			this.data = data;
		}
		public Node getNext(){
			return this.next;
		}
		public void setNext(Node next){
			this.next = next;
		}
		public Node getPrev(){
			return this.previous;
		}
		public void setPrev(Node previous){
			this.previous = previous;
		}
		public int getId(){
			return this.id;
		}
		public void setId(int id){
			this.id = id;
		}
		//Prints node's ID and data. 
		public void print(){
			
			System.out.println("This Number: "+ this.id+" "+ this.data);
		}
		//Compares the data of one node to another node. 
		public int compareTo(Node node){
			
			return this.data.compareTo(node.getData());
		}
		
		public boolean inLink(){
			
			return (this.next != null) || (this.previous != null);
		}
		
}
