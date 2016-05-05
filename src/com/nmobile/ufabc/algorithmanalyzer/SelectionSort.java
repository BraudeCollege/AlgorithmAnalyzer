package com.nmobile.ufabc.algorithmanalyzer;

public class SelectionSort 
{
	
	public int[] sort(int[] data) 
	{
		int next, indexOfNext;

		for (next = 0; next < data.length - 1; next++) 
		{
			indexOfNext = min(data, next, data.length - 1);
			swap(data, indexOfNext, next);
		}
		
		return data;
	}

	public int min(int[] data, int start, int end) 
	{
		int indexOfMin = start; // initial guess

		for (int i = start + 1; i <= end; i++)
			if (data[i] < data[indexOfMin])
				indexOfMin = i; // found a smaller value
		return indexOfMin;
	}

	// swap to entries in an array
	public void swap(int[] data, int first, int second) 
	{
		int temp;

		temp = data[first];
		data[first] = data[second];
		data[second] = temp;
	}
}
