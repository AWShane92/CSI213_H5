package H5;

import java.util.*;

public class Sort {
	
	public static int comparisons = 0;
	
	public static void bubbleSort(int [] input){
	
		//Assumes that the list is sorted
		boolean sorted = true;
		
		for(int i = 0; i < input.length - 1; i++){
			/*Compares current with next value in list 
			 * if Current value is higher then swap values
			 */
			if(input[i] > input[i + 1]){
				int temp = input[i + 1];
				input[i + 1] = input[i];
				input[i] = temp;
				sorted = false;
				comparisons= comparisons + 1;
			}	
		}
		/*If the list isn't sorted then continue running bubbleSort
		 * recursively.
		 */
		if(!sorted){
			bubbleSort(input);
		}
		//if the list is sorted then stop sorting
		else {
			return;
		}
		
	}
	
	public static void shakerSort(int [] input){
		
		boolean sorted = true;
		for(int i = 0; i < input.length - 1; i++){
			/*Compares current value with next value if current
			 * value is higher then swap values
			 */
			if(input[i] > input[i + 1]){
				int temp = input[i + 1];
				input[i + 1] = input[i];
				input[i] = temp;
				sorted = false;
				comparisons= comparisons + 1;
			}	
		}
		//Traverses the list backwards
		for(int i = input.length - 1; i != 0; i--){
			/*If current value is less than the previous value
			 * then swap values
			 */
			if(input[i] < input[(i-1)]){
				int temp = input[i-1];
				input[i-1] = input[i];
				input[i]= temp;
				sorted = false;
				comparisons= comparisons + 1;
			}
			
		}
		/*If the list isn't sorted then continue running bubbleSort
		 * recursively.
		 */
		if(!sorted){
			shakerSort(input);
		}
		//if the list is sorted then stop sorting
		else {
			return;
		}
		
	}
	
	public static void bbSort(DoublyLinkedList dll){
		
		
		boolean sorted = true;
		Node Next = null;
		Node Prev = null;
		Node temp = null;
		Node link = dll.getHead();
		
		while(link != dll.getTail()){
			
		 if((link == dll.getHead())&&(link.getId() > link.getNext().getId())){
				Next = link.getNext();
				temp = Next.getNext();
				link.setPrev(Next);
				Next.setNext(link);
				Next.setPrev(null);
				link.setNext(temp);
				temp.setPrev(link);
				dll.setHead(Next);
				link = Next.getNext();
				sorted = false;	
			}
		  else if((link.getNext() == dll.getTail())&&(link.getId() > link.getNext().getId())){
				Next = link.getNext();
				Prev = link.getPrev();
				Next.setPrev(Prev);
				link.setPrev(Next);
				Next.setNext(link);
				Prev.setNext(Next);	
				link.setNext(null);
				dll.setTail(link);
				link = Next.getNext();
				sorted = false;	
			}
			
			else if(link.getId() > link.getNext().getId()){
				Next = link.getNext();
				Prev = link.getPrev();
				temp = Next.getNext();
				Next.setPrev(Prev);
				link.setPrev(Next);
				Next.setNext(link);
				Prev.setNext(Next);
				link.setNext(temp);
				temp.setPrev(link);
				link = Next.getNext();		
				sorted = false;					
			}else{
			
				link = link.getNext();	
			}
			
		}
		if(!sorted){
			bbSort(dll);		
		}
		else{
			return;
			
		}
				
	}
	
	public static void cocktailShakerSort(DoublyLinkedList dll){
		
		boolean sorted = true;
		Node Next = null;
		Node Prev = null;
		Node temp = null;
		Node link = dll.getHead();
		
		while(link != dll.getTail()){
			
			if((link == dll.getHead())&&(link.getId() > link.getNext().getId())){
				Next = link.getNext();
				temp = Next.getNext();
				link.setPrev(Next);
				Next.setNext(link);
				Next.setPrev(null);
				link.setNext(temp);
				temp.setPrev(link);
				dll.setHead(Next);
				link = Next.getNext();
				sorted = false;	
			}
		  else if((link.getNext() == dll.getTail())&&(link.getId() > link.getNext().getId())){
				Next = link.getNext();
				Prev = link.getPrev();
				Next.setPrev(Prev);
				link.setPrev(Next);
				Next.setNext(link);
				Prev.setNext(Next);	
				link.setNext(null);
				dll.setTail(link);
				link = Next.getNext();
				sorted = false;	
			}
			
			else if(link.getId() > link.getNext().getId()){
				Next = link.getNext();
				Prev = link.getPrev();
				temp = Next.getNext();
				Next.setPrev(Prev);
				link.setPrev(Next);
				Next.setNext(link);
				Prev.setNext(Next);
				link.setNext(temp);
				temp.setPrev(link);
				link = Next.getNext();		
				sorted = false;					
			}else{
			
				link = link.getNext();	
			}
			
		}
		link = dll.getTail();
		while(link != dll.getHead()){
			
			if((link == dll.getTail())&&(link.getId() < link.getPrev().getId())){
				Prev = link.getPrev();
				temp = Prev.getPrev();
				link.setNext(Prev);
				Prev.setPrev(link);
				link.setPrev(temp);
				temp.setNext(link);
				Prev.setNext(null);
				dll.setTail(Prev);
				link = Prev.getPrev();
				sorted = false;
			}
			else if((link.getPrev() == dll.getHead())&&(link.getId() < link.getPrev().getId())){
				Prev = link.getPrev();
				Next = link.getNext();
				Prev.setNext(Next);
				link.setNext(Prev);
				Prev.setPrev(link);
				link.setPrev(null);
				dll.setHead(link);
				link = Prev.getPrev();
				sorted = false;
			}
			else if(link.getId() < link.getPrev().getId()){
				Prev = link.getPrev();
				Next = link.getNext();
				temp = Prev.getPrev();
				Prev.setNext(Next);
				link.setNext(Prev);
				Prev.setPrev(link);
				link.setPrev(temp);
				temp.setNext(link);
				Next.setPrev(Prev);
				link = Prev.getPrev();
				sorted = false;
			}
			else{
				
				link = link.getPrev();
			}
			
		}
		if(!sorted){
			cocktailShakerSort(dll);		
		}
		else if(sorted){
			return;
		}
		
		
	}
	public static void main(String[]args){
		
	
		//Instantiated arrays
		int [] a = new int [10];
		int [] b = new int [10];
		
		//Random number generator
		for(int i = 0; i < a.length; i++){
			
			a[i] = (int)(Math.random() * 100);
		}
		for(int i = 0; i < b.length; i++){
			
			b[i] = (int)(Math.random() * 100);
		}
		//Began test sorting methods
		//First method tested was bubbleSort
		System.out.println("First array using bubble sort");
		System.out.println("Before bubble sort: ");
		for(int i = 0; i < a.length;i++){
			System.out.print(a[i] + ", ");
		}
		bubbleSort(a);
		System.out.println(" ");
		System.out.println("After bubble sort: ");
		for(int i = 0; i < a.length;i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println(" ");
		System.out.println("Bubble Sort comparisons: "+ comparisons);
		//Resets the global comparison variable. 
		comparisons = 0;
		System.out.println(" ");
		//Began testing shakerSort method.
		System.out.println("Second array using Cocktail Shaker sort");
		System.out.println("Before Cocktail Shaker sort: ");
		for(int i = 0; i < b.length;i++){
			System.out.print(b[i] + ", ");
		}
		shakerSort(b);
		System.out.println(" ");
		System.out.println("After Cocktail Shaker sort: ");
		for(int i = 0; i < b.length;i++){
			System.out.print(b[i] + ", ");
		}
		System.out.println(" ");
		System.out.println("Cocktail Shaker Sort comparisons: "+ comparisons);
		System.out.println(" ");
		
		DoublyLinkedList dll = new DoublyLinkedList();
		
		Node a1 = new Node("is Awesome");
		Node b2 = new Node("is The Bees Knees");
		Node c3 = new Node("is Cool Beans");
		Node d4 = new Node("is The Dang Diggity");
		
		dll.unorderedAdd(a1);
		dll.unorderedAdd(b2);
		dll.unorderedAdd(c3);
		dll.unorderedAdd(d4);
		dll.printList();
		System.out.println(" ");
		//bbSort(dll);
		cocktailShakerSort(dll);
		dll.printList();
		
		
	}

}
