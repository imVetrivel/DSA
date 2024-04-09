package Searching;

public class BinarySearch {
	public static void main(String[] args)
	{
		int arr[] = {1,3,4,5,7,8,13,14,17,19};

		int find = 13;

		int left = 0,right = arr.length-1, mid = 0;

		while(left<=right)
		{
			mid = (left+right)/2;

			if(find == arr[mid])
			{
				System.out.println("Found at position "+mid);
				return;
			}
			else if(find < arr[mid])
			{
				right = mid-1;
			}
			else
			{
				left = mid+1;
			}
		}
		System.out.print("Element Not Found");
	}
}
