package sorting;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BucketSortForString {
	//Get the maximum value of array
	/*public static String getMax(String arr[]) {
		String max = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i].compareTo(max)>0) max = arr[i];
		}
		return max;
	}*/
	

	public static void BucketSort(String arr[]) {
		List<String> count[] = new List[26];
		//int output[] = new int[arr.length];
		for(int i=0;i<26;i++) {
			count[i] = new LinkedList<>();
		}
		//Insert to the bucket
		for(int i=0;i<arr.length;i++) {
			count[(arr[i].toLowerCase().charAt(0)-97)].add(arr[i]);
		}
		
		//Sort the list
		for(int i=0;i<26;i++) {
			if(count[i]!=null) Collections.sort(count[i]);
			else continue;
		}
		//Show the sorted list
		int j=0;
		for(int i=0;i<26;i++) {
			if(count[i]!=null) {
			Iterator<String> iterator = count[i].iterator();
			while(iterator.hasNext()) {
				arr[j++] = iterator.next();
			}
		} else continue;
	}
		
	for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+" ");
	}
}
	public static void main(String[] args) {
		String toSortArray[] = {"Ali", "Ab", "Abi", "Budi", "Babi", "Charlie", "Cau"};
		//radixsort(toSortArray);
		//System.out.print(getMax(toSortArray));
		BucketSort(toSortArray);
	}
}
