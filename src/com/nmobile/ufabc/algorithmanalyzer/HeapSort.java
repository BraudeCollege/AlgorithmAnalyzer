package com.nmobile.ufabc.algorithmanalyzer;

public class HeapSort
{
	private static int[] a;
    private static int heapSize;
    
	public int[] sort(int[] temp) 
	{
        a = temp;
        sort(0, a.length);
        return a;
    }

    private static void sort(int left, int right) 
    {
        int i = a.length - 1;

        buildMaxHeap();
        while (i > 0) {
            swap(0, i);
            heapSize -= 1; 
            maxHeapify(0);
            i--;
        }
    }

    private static int left(int i) 
    {
        return ((i + 1) * 2 - 1);
    }

    private static int right(int i) 
    {
        return ((i + 1) * 2);
    }

    private static int parent(int i) 
    {
        return ((i + 1) / 2 - 1);
    }
    
    private static void swap(int x, int y)
    {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static void buildMaxHeap() 
    {
        int i = a.length / 2 - 1;
        
        heapSize = a.length;
        while (i >= 0) {
            maxHeapify(i);
            i--;
        }
    }
    
    private static void maxHeapify(int i) 
    {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < heapSize) 
        {
            if (a[largest] < a[l]) 
            {
                largest = l;
            }
        }
        if (r < heapSize) 
        {
            if (a[largest] < a[r]) 
            {
                largest = r;
            }
        }
        if (largest != i) 
        {
            swap(i, largest);
            maxHeapify(largest);
        }                
    }
}