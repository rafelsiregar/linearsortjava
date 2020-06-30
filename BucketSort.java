package sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {
	//Get the maximum value of array
	public static int getMax(int arr[]) {
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}

	public static void sort(int arr[], int bucket, int div) {
		List<Integer> count[] = new List[bucket];
		//int output[] = new int[arr.length];
		for(int i=0;i<bucket;i++) {
			count[i] = new LinkedList<>();
		}
		
		for(int i=0;i<arr.length;i++) {
			count[(int) Math.floor(arr[i]/div)].add(arr[i]);
		}
		//Sort the list
		for(int i=0;i<bucket;i++) {
			if(count[i]!=null) Collections.sort(count[i]);
			else continue;
		}
		//Show the sorted list
		int j=0;
		for(int i=0;i<bucket;i++) {
			if(count[i]!=null) {
			Iterator<Integer> iterator = count[i].iterator();
			while(iterator.hasNext()) {
				arr[j++] = iterator.next();
			}
		} else continue;
	}
		
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
	}
}
	

	public static void bucketsort(int arr[], int bucket) {
		double maxValue = (double) getMax(arr);
		int div = (int) Math.ceil((float)(maxValue+1)/bucket);
		sort(arr, bucket, div);
	}
	
	public static void main(String[] args) {
		int toSortArray[] = {22, 45, 12, 8, 10, 6, 72, 81, 33, 18, 50, 14};
		bucketsort(toSortArray, 10);
	}
}
