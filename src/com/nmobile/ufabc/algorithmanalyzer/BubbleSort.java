package com.nmobile.ufabc.algorithmanalyzer;

public class BubbleSort 
{
	public int[] bubbleSort(int[] valores) 
	{
		int[] valoresTemp = valores;
		boolean swapped = true;
		int j = 0;
		int tmp;
		while (swapped) 
		{
			swapped = false;
			j++;
			for (int i = 0; i < valoresTemp.length - j; i++) 
			{                                       
				if (valoresTemp[i] > valoresTemp[i + 1]) 
				{                          
					tmp = valoresTemp[i];
					valoresTemp[i] = valoresTemp[i + 1];
					valoresTemp[i + 1] = tmp;
					swapped = true;
				}
			}                
		}
		return valoresTemp;
	}
}
