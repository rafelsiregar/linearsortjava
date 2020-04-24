package radix;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Radix {
	public static int getMax(int arr[]) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}
	
	public static void sort(int arr[], int exp) {
		List<Integer> count[] = new List[10];
		int output[] = new int[arr.length];
		for(int i=0;i<10;i++) {
			count[i] = new LinkedList<>();
		}
		
		for(int i=0;i<arr.length;i++) {
			count[(arr[i]/exp)%10].add(arr[i]);
		}
		//Show the sorted list
		int j=0;
		for(int i=0;i<10;i++) {
			Iterator<Integer> iterator = count[i].iterator();
			while(iterator.hasNext()) {
				//System.out.print(iterator.next()+" ");
				output[j++] = iterator.next();
			}
	}
		
	for(int i=0;i<output.length;i++) {
		arr[i] = output[i];
		System.out.print(arr[i]+" ");
	}
	
}
	
	public static void radixsort(int arr[]) {
		int maxValue = getMax(arr);
		int i = 1;
		for(int exp = 1; maxValue/exp>0;exp*=10, i++) {
			System.out.println("Iteration "+i+" : ");
			sort(arr, exp);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int toSortArray[] = {10, 29, 33, 46, 105, 86, 827, 82, 92, 12, 45};
		radixsort(toSortArray);
	}
}
