package H5;

import H3.Node;

public class DoublyLinkedList {
	
	private Node head = null;
	private Node tail = null;
	private int size = 0;
	
	//Getters and Setters
	public Node getHead(){
		return this.head;
	}
	public void setHead(Node head){
		this.head = head;
	}
	
	public Node getTail(){
		return this.tail;
	}
	public void setTail(Node tail){
		
		this.tail = tail;
	}
	
	public int getSize(){
		return this.size;
	}
	//Methods
	public void add(Node newNode){
		
		//Returns if the newNode added has no data.
		if(newNode == null){	
			return;
		}
		//Creates first node in list if the list is empty.
		if(this.isEmpty()){
			head = tail = newNode;	
		}
		/*Checks to see if there is only one node in the list
		 * and compares it to the head and the tail. 
		 */
		else if(head == tail){
			
				if(head.compareTo(newNode) > 0){
					tail.setPrev(newNode);
					this.head = newNode;
					this.head.setNext(tail);
				}else{
					head.setNext(newNode);
					this.tail = newNode;
					this.tail.setPrev(head);		
				}
			
		}
		//Adds a node in the list in the proper order.	 
		else{	
		Node link = head;
		Node temp = null;
		
		while(link != null){
			//Compares the node to head if head is larger newNode becomes new head.
			if(this.head.compareTo(newNode) > 0){
				this.head.setPrev(newNode);
				newNode.setNext(head);
				this.head = newNode;
				
			}
			//Compares node to tail if the tail is smaller newNode becomes new tail.
			else if(this.tail.compareTo(newNode) < 0){
				this.tail.setNext(newNode);
				newNode.setPrev(tail);
				this.tail = newNode;						
			}else{
				/* Organizes the nodes in appropriate order, checks current node
				 * if newNode is greater than the current node being compareTo
				 * and is less than that node's next, then it inserts that newNode
				 * between the current node and the current node's next. 
				 */
				if((link.compareTo(newNode) < 0)&&(link.getNext().compareTo(newNode) > 0)){
					temp = link.getNext();
					link.setNext(newNode);
					newNode.setPrev(link);
					newNode.setNext(temp);
					temp.setPrev(newNode);			
				}
				/*If newNode has data similar to an element already in the list
				 * then insert the newNode after that element.
				 */
				else if((link.compareTo(newNode) == 0) && (link != newNode)){			
					temp = link.getNext();
					link.setNext(newNode);
					newNode.setPrev(link);
					newNode.setNext(temp);	
					temp.setPrev(newNode);			
				}		
			}
			//Loops thru list to add node. 
			link = link.getNext();		
			}	
		}
	}
	
	public void delete(Node node){
		
		Node link = head;
		Node temp = null;
		
		//returns "The list is empty" if the list is empty. 
		if(this.isEmpty()){
			System.out.println("The list is Empty");
			return;	
		}
		//If node is not in list return.
		else if(!node.inLink()){ 
			System.out.println("This node" + node.getData() + "is not in this list");
			return;
		}
		//if the head is the node that wants to be deleted. 
		else if(this.head == node){
			/*Gets heads next node set it to temp
			 * sets head next to null and set the temp to the new head
			 * Sets the new head previous to null.
			 */
			temp = head.getNext();
			head.setNext(null);
			this.head = temp;
			head.setPrev(null);
		
		}
		//if the tail is the node that wants to be deleted. 
		else if(this.tail == node){
			/*Gets tail prev node set it to temp
			 * sets tail next to null and set the temp to the new head
			 * Sets the new tail next to null.
			 */
			temp = tail.getPrev();
			tail.setPrev(null);
			this.tail = temp;
			tail.setNext(null);		
		}
		//If node is in list do. 
		else if(node.inLink()){
			
			//Since list is in order traverse list forward.
			while(link != null){

					if(link == node){
						temp = node.getNext();
						link.setNext(temp);
						temp.setPrev(link);
						node.setPrev(null);
						node.setNext(null);		
						return;
					}
					link = link.getNext();
				}		
			}
		}
	public void deleteList(){
		this.head= null;
		this.tail= null;
	}
		
	public boolean findNode(Node node){
		
		Node find = head;
		//Checks if the node is in the list
		if(node.inLink()){
			
			//loop to cycle thru list
			while(find != null){
				//Returns true if find is equal to node wanted to be found. 
				if(find.compareTo(node) == 0){		
					return true;
				}		
				find = find.getNext();
			}
		}	
		return false;	
	}
	
	public void printList(){
		
		//returns "The list is empty" if the list is empty.
		if(this.isEmpty()){
			System.out.println("The list is Empty");
			return;	
		}
		
		Node temp = head;	
		//Prints list forward.
		while(temp != null){
			temp.print();
			temp = temp.getNext();			
		}
	}
	
	public void reverseList(){
		
		//returns "The list is empty" if the list is empty.
		if(this.isEmpty()){
			System.out.println("The list is Empty");
			return;	
		}
		
		Node temp = tail;
		//prints list backward
		while(temp != null){	
			temp.print();
			temp = temp.getPrev();			
		}
	}
	
	//Checks if the list is empty
	public boolean isEmpty(){
		if(head== null && tail == null){
			return true;
		}else{
			return false;
		}
	}
	public int size(){
				
		int counter = 0;
		Node temp = head;
	
		while(temp != null){
			counter++;
			temp = temp.getNext();
		}
		this.size = counter;
		return this.size;
	}

}
