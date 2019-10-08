package demo.sort;

import java.util.Arrays;

public class QuickSort{
	public static int binarySearch(int[] arr,int target ){
		if(arr.length==0){
			return -1;
		}
		int low=0;
		int high=arr.length-1;
		while (low<=high){
			int mid=(low+high)/2;
			if(arr[mid]==target){
				return mid;
			}else if(arr[mid]<target){
				low=mid+1;
			}else {
				high=mid-1;
			}
		}
		return -1;
	}
	public static int[] quickSort(int[] arr,int low,int high){

		int mid=quicksort(arr,low,high);
		if(mid>low){
			quickSort(arr,low,mid-1);
		}
		if(mid<high){
			quickSort(arr,mid+1,high);
		}
		return arr;
	}

	private static int quicksort(int[] arr, int low, int high) {
		int partition = arr[low];
		while (low<high){
			while (low<high&&arr[high]>=partition){
				high--;
			}
			swap(arr,low,high);
			while ((low<high&&arr[low]<=partition)){
				low++;
			}
			swap(arr,low,high);
		}
		return low;
	}

	private static void swap(int[] arr, int low, int high) {
		int tmp=arr[low];
		arr[low]=arr[high];
		arr[high]=tmp;
	}

	public static void main(String[] args) {
		int[] arr={8,6,4,10,3,2,5,7,1};
		System.out.println(Arrays.toString(quickSort(arr,0,arr.length-1)));
	}
}
