package demo.sort;

import java.util.Arrays;

public class MergeSort{
	public static int[] mergeSort(int arr[],int low,int high){
		if(low>=high){
			return null;
		}
		int mid=(low+high)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		merge(arr,low,mid,high);
		return arr;
	}

	private static void merge(int[] arr, int low, int mid, int high) {
		int cur=low;
		int middle=mid+1;
		int i=0;
		int[] tmp=new int[high-low+1];
		while (low<=mid&&middle<=high){
			if(arr[low]<=arr[middle]){
				tmp[i++]=arr[low++];
			}else {
				tmp[i++]=arr[middle++];
			}
		}
		while (low<=mid){
			tmp[i++]=arr[low++];
		}
		while ((middle<=high)){
			tmp[i++]=arr[middle++];
		}
		int len=high-cur+1;
		for(int j=0;j<len;j++){
			arr[cur++]=tmp[j];
		}
	}

	public static void main(String[] args) {
		int[] arr={8,6,4,10,3,2,5,7,1,9};
		System.out.println(Arrays.toString(mergeSort(arr,0,arr.length-1)));
	}
}