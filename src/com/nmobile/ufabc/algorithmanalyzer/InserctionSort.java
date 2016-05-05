package com.nmobile.ufabc.algorithmanalyzer;

public class InserctionSort 
{

	public InserctionSort() 
	{

	}

	public int[] insertionSort(int[] valores) 
	{
		int temp;
		for (int i = 1; i < valores.length; i++) 
		{
			for (int j = i; j > 0; j--) 
			{
				if (valores[j] < valores[j - 1]) 
				{
					temp = valores[j];
					valores[j] = valores[j - 1];
					valores[j - 1] = temp;
				}
			}
		}
		return valores;
	}

}
