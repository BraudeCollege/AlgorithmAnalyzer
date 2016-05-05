package com.nmobile.ufabc.algorithmanalyzer;

public class QuickSort
{

	private static int[] a;
    private static int pivotIndex;

    public int[] sort(int[] aTemp) 
    {
        a = aTemp;
        sort(0, a.length - 1);
        return a;
    }

    public static void sort(int left, int right) {
        if (left < right) {
            findPivot(left, right);
            partition(left, right);
            if (left < pivotIndex)
                sort(left, pivotIndex - 1);
            if (pivotIndex < right)
             sort(pivotIndex + 1, right); 
        }

    }

    private static void findPivot(int left, int right) {
        int median = left;
        int mid = left + (right - left) / 2;

        if (a[median] < a[mid]) {
            if (a[mid] < a[right]) {
                median = mid;
            } else if (a[median] < a[right]) {
                median = right;
            }
        } else {
            if (a[right] < a[mid]) {
                median = mid;
            } else if (a[right] < a[median]) {
                median = right;
            }
        }
        pivotIndex = median;
    }

    private static void partition(int left, int right) {
        int i = left;
        int pivotValue = a[pivotIndex];
        int storeIndex = left;

        swap(right, pivotIndex);
        while (i < right) {
            if (a[i] < pivotValue) {
                swap(i, storeIndex);
                storeIndex++;
            }
            i++;
        }
        swap(storeIndex, right);
        pivotIndex = storeIndex;
    }
    
    private static void swap(int x, int y) {
        int temp;
        
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

}