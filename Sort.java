package H5;

public class Sort {
	
	public static int comparisons = 0;
	
	public static void bubbleSort(int [] input){
	
		for(int i = 0; i < input.length - 1; i++){
			
			if(input[i] > input[i + 1]){
				int temp = input[i + 1];
				input[i + 1] = input[i];
				input[i] = temp;
				comparisons= comparisons + 1;
			}	
		}
		
		if(!sortedList(input)){
			bubbleSort(input);
		}
		else if(sortedList(input)){
			return;
		}
		
	}
	
	public static void shakerSort(int [] input){
		
		for(int i = 0; i < input.length - 1; i++){
			
			if(input[i] > input[i + 1]){
				int temp = input[i + 1];
				input[i + 1] = input[i];
				input[i] = temp;
				comparisons= comparisons + 1;
			}	
		}
		for(int i = input.length - 1; i != 0; i--){
			
			if(input[i] < input[(i-1)]){
				int temp = input[i-1];
				input[i-1] = input[i];
				input[i]= temp;
				comparisons= comparisons + 1;
			}
			
		}
		if(!sortedList(input)){
			shakerSort(input);
		}
		else if(sortedList(input)){
			return;
		}
		
	}
	
	public static boolean sortedList(int [] a){
		
		boolean sorted = true;
		
		for(int i = 0; i < a.length -1; i++){
			
			if(a[i]>a[i + 1]){
				sorted =  false;
			}
		}	
		return sorted;
	}
	
	public static void main(String[]args){
		
		int [] a = new int [10];
		int [] b = new int [10];
		for(int i = 0; i < a.length; i++){
			
			a[i] = (int)(Math.random() * 100);
		}
		for(int i = 0; i < b.length; i++){
			
			b[i] = (int)(Math.random() * 100);
		}
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
		comparisons = 0;
		System.out.println(" ");
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
	}

}
