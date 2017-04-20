package H5;

public class Sort {
	
	public static int comparisons = 0;
	
	public static void bubbleSort(int [] input){
	
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
		else if(sorted){
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
	}

}
