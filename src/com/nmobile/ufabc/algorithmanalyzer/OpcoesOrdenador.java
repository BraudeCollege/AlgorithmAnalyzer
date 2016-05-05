package com.nmobile.ufabc.algorithmanalyzer;

import com.actionbarsherlock.app.SherlockActivity;

import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class OpcoesOrdenador extends SherlockActivity 
{
	
	String nomeOrdenador = "";
	int ordenador = 0;
	
	ProgressDialog cancelDialog;
	
	TextView txtTitulo;
	Button botaoGeraRelatorio;
	Button botaoRodaAlgoritmo;
	EditText txtNumeroTestes;
	
	CheckBox chkAleatorio;
	CheckBox chkCrescente;
	CheckBox chkDecrescente;
	
	private Handler mHandler = new Handler();
	
	int valorN = 0;
	int tipo = 0;
	String tipoDeDadosEntrada = "";
	
	int[] valoresOrdenados;
	static int[] arrayInicio;
	
	String nomeAlgoritmo = "";
	long startTime;
	long estimatedTime;
	
	String retornoTodos = "";
	
	@Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opcoes_ordenador);
        
        Bundle bundle = getIntent().getExtras();
        nomeOrdenador = bundle.getString("ordenador");
        
        txtTitulo = (TextView) findViewById(R.id.txtTitulo);
        botaoGeraRelatorio = (Button) findViewById(R.id.botaoGeraRelatorio);
        botaoRodaAlgoritmo = (Button) findViewById(R.id.botaoRodaAlgoritmo);
        txtNumeroTestes = (EditText) findViewById(R.id.txtNumeroTestes);
        
        chkAleatorio = (CheckBox) findViewById(R.id.checkBox1);
        chkCrescente = (CheckBox) findViewById(R.id.checkBox2);
        chkDecrescente = (CheckBox) findViewById(R.id.checkBox3);

        txtNumeroTestes.setVisibility(View.INVISIBLE);
        botaoGeraRelatorio.setEnabled(false);
        
        if(nomeOrdenador.equalsIgnoreCase("merge"))
        {
        	ordenador = 1;
        	txtTitulo.setText("MergeSort");
        	nomeAlgoritmo = "MergeSort";
        }
        else if(nomeOrdenador.equalsIgnoreCase("selection"))
        {
        	ordenador = 2;
        	txtTitulo.setText("SelectionSort");
        	nomeAlgoritmo = "SelectionSort";
        }
        else if(nomeOrdenador.equalsIgnoreCase("insertion"))
        {
        	ordenador = 3;
        	txtTitulo.setText("InsertionSort");
        	nomeAlgoritmo = "InsertionSort";
        }
        else if(nomeOrdenador.equalsIgnoreCase("bubble"))
        {
        	ordenador = 4;
        	txtTitulo.setText("BubbleSort");
        	nomeAlgoritmo = "BubbleSort";
        }
        else if(nomeOrdenador.equalsIgnoreCase("heap"))
        {
        	ordenador = 5;
        	txtTitulo.setText("HeapSort");
        	nomeAlgoritmo = "HeapSort";
        }
        else if(nomeOrdenador.equalsIgnoreCase("quick"))
        {
        	ordenador = 6;
        	txtTitulo.setText("QuickSort");
        	nomeAlgoritmo = "QuickSort";
        }
        else
        {
        	ordenador = 7;
        	txtTitulo.setText("Todos Algoritmos");
        	nomeAlgoritmo = "Todos Algoritmos";
        }
        //Toast.makeText(this, "Nome do Ordenador: " + nomeOrdenador, Toast.LENGTH_SHORT).show();
    }
	
	public void setValorN(View v)
	{
		AlertDialog.Builder alert = new AlertDialog.Builder(this);

		alert.setTitle("Entrar com valor");
		alert.setMessage("Digite o valor de N");

		final EditText input = new EditText(this);
		alert.setView(input);

		alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int whichButton) 
			{
				Editable value = input.getText();
				valorN = Integer.parseInt(value.toString());
			}
		});

		alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() 
		{
			public void onClick(DialogInterface dialog, int whichButton) 
			{

			}
		});

		alert.show();
	}
	
	public void rodaAlgoritmo(View v)
	{
		String erro = "";
		
		botaoRodaAlgoritmo.setEnabled(false);
		
		if(valorN == 0)
		{
			erro += "Você precisa definir o tamanho de N!\n\n";
		}
		
		if(tipo == 0)
		{
			erro += "Você precisa definir a organização dos dados!\n";
		}
		
		if(tipo == 1)
		{
			if(txtNumeroTestes.getText().toString().equalsIgnoreCase(""))
			{
				erro += "Você precisa definir o número t de testes!\n";
			}
		}
		
		if(ordenador != 7)
		{
			if(erro.equalsIgnoreCase(""))
			{
				createCancelProgressDialog("Rodando Algoritmo", "Por favor aguarde...", "Cancelar Algoritmo", 1);
			}
			else
			{
				AlertDialog alertDialog;
				alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Erro ao rodar Algoritmo");
				alertDialog.setMessage(erro);
				alertDialog.show();
			}
		}
		else
		{
			if(erro.equalsIgnoreCase(""))
			{
				createCancelProgressDialog("Rodando Algoritmo", "Por favor aguarde...", "Cancelar Algoritmo", 2);
			}
			else
			{
				AlertDialog alertDialog;
				alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("Erro ao rodar Algoritmo");
				alertDialog.setMessage(erro);
				alertDialog.show();
			}
		}
	}
	
    @SuppressWarnings("deprecation")
	private void createCancelProgressDialog(String title, String message, String buttonText, int tipo)
    {
        cancelDialog = new ProgressDialog(this);
        cancelDialog.setTitle(title);
        cancelDialog.setMessage(message);
        cancelDialog.setButton(buttonText, new DialogInterface.OnClickListener() 
        {
            public void onClick(DialogInterface dialog, int which) 
            {
                return;
            }
        });
        cancelDialog.show();
        
        Handler handler = new Handler(); 
        handler.postDelayed(new Runnable() 
        { 
             public void run() 
             { 
            	 mHandler.postDelayed(runnable, 1);
             } 
        }, 1000);
    }
    
    
    private Runnable runnable = new Runnable() 
    {
        public void run() 
        {
        	int[] arrayMomento = null;
        	
        	switch(tipo)
        	{
        		case 1:
	        		arrayInicio = gerarValoresAleatorios(valorN);
	        		arrayMomento = arrayInicio;
	        		break;
        		
        		case 2:
	        		arrayInicio = gerarValoresCrescentes(valorN);
	        		arrayMomento = arrayInicio;
	        		break;
	        	
        		case 3:
	        		arrayInicio = gerarValoresDecrescentes(valorN);
	        		arrayMomento = arrayInicio;
	        		break;
        	}

	        switch(ordenador)
	        {
		        case 1:
		        	MergeSort mergeSort = new MergeSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = mergeSort.mergeSort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 2:
		        	SelectionSort selectionSort = new SelectionSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = selectionSort.sort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 3:
		        	InserctionSort insertionSort = new InserctionSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = insertionSort.insertionSort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 4:
		        	BubbleSort bubbleSort = new BubbleSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = bubbleSort.bubbleSort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 5:
		        	HeapSort heapSort = new HeapSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = heapSort.sort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 6:
		        	QuickSort quickSort = new QuickSort();
		        	startTime = System.nanoTime();
		        	valoresOrdenados = quickSort.sort(arrayMomento);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
		        
		        case 7:
		        	retornoTodos = rodarParaTodosAlgoritmos(1);
		        	botaoRodaAlgoritmo.setEnabled(false);
		        	botaoGeraRelatorio.setEnabled(true);
		        	break;
	        }

        	cancelDialog.dismiss();
        	botaoRodaAlgoritmo.setEnabled(true);
        	
        	estimatedTime = System.nanoTime() - startTime;
        	
        }
    };
    
    public void enviaRelatorio(View v)
    {
    	if(ordenador != 7)
    	{
	    	Intent intent = new Intent(OpcoesOrdenador.this, VerRelatorio.class);
	    	intent.putExtra("dados", mostrarValores(valoresOrdenados));
	    	startActivity(intent);
    	}
    	else
    	{
    		Intent intent = new Intent(OpcoesOrdenador.this, VerRelatorio.class);
	    	intent.putExtra("dados", retornoTodos);
	    	startActivity(intent);
    	}
    }
    
    public int[] gerarValoresAleatorios(int tamanho)
    {
    	int[] valores = new int[tamanho];
    	
    	for(int i = 0; i < tamanho; i++)
    	{
    		int valor = (int) (Math.random() * 1001);
    		valores[i] = valor;
    	}
    	return valores;	
    }
    
    public int[] gerarValoresCrescentes(int tamanho)
    {
    	int[] valores = new int[tamanho];
    	
    	for(int i = 0; i < tamanho; i++)
    	{
    		valores[i] = i;
    	}
    	
    	return valores;	
    }
    
    public int[] gerarValoresDecrescentes(int tamanho)
    {
    	int[] valores = new int[tamanho];
    	
    	for(int i = 0; i < tamanho ; i++)
    	{
    		valores[i] = tamanho - i;
    	}
    	
    	return valores;	
    }
    
    public String mostrarValores(int[] valoresOrdenados)
    {
    	String retorno = "Dados para o algoritmo: " + nomeAlgoritmo + "\n";
    	retorno += "Valor de n: " + valorN + "\n";
    	retorno += "Tipo de dados de entrada: " + tipoDeDadosEntrada + "\n";
    	
    	double seconds = (double)estimatedTime / 1000000000.0;
    	
    	retorno += "Tempo passado: " + seconds + " s\n\n";
    	
    	retorno += "OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
    	retorno += "\nOS API Level: " + android.os.Build.VERSION.SDK;
    	retorno += "\nDevice: " + android.os.Build.DEVICE;
    	retorno += "\nModel (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
    	//retorno += "Desorganizado\tOrganizado\n\n";
    	
    			
    	/*for(int i = 0; i < valoresOrdenados.length; i++)
    	{
    		retorno += arrayInicio[i] + "\t\t\t\t\t\t\t\t\t\t" + valoresOrdenados[i] + "\n";
    	}*/
    	return retorno;
    }
    
    public void mudaCheckboxAleatorio(View v)
    {
    	if(chkCrescente.isChecked())
    	{
    		chkCrescente.setChecked(false);
    	}
    	
    	if(chkDecrescente.isChecked())
    	{
    		chkDecrescente.setChecked(false);
    	}
    	
    	tipo = 1;
    	tipoDeDadosEntrada = "Aleatório";
    	
    	if(chkAleatorio.isChecked())
    	{
    		txtNumeroTestes.setVisibility(View.VISIBLE);
    	}
    	else
    	{
    		txtNumeroTestes.setVisibility(View.INVISIBLE);
    	}
    }
    
    public void mudaCheckboxCrescente(View v)
    {
    	if(chkAleatorio.isChecked())
    	{
    		chkAleatorio.setChecked(false);
    	}
    	
    	if(chkDecrescente.isChecked())
    	{
    		chkDecrescente.setChecked(false);
    	}
    	
    	tipoDeDadosEntrada = "Crescente";
    	
    	tipo = 2;
    	txtNumeroTestes.setVisibility(View.INVISIBLE);
    }
    
    public void mudaCheckboxDecrescente(View v)
    {
    	if(chkAleatorio.isChecked())
    	{
    		chkAleatorio.setChecked(false);
    	}
    	
    	if(chkCrescente.isChecked())
    	{
    		chkCrescente.setChecked(false);
    	}
    	
    	tipoDeDadosEntrada = "Decrescente";
    	
    	tipo = 3;
    	txtNumeroTestes.setVisibility(View.INVISIBLE);
    }
    
    public void limparTexto(View v)
    {
    	txtNumeroTestes.setText("");
    }
    
    public String rodarParaTodosAlgoritmos(int tVezes)
    {
    	String retorno = "";
    	
    	if(tVezes == 1)
    	{   
    		if(tipo == 1)
    		{
    			int[] arrayMergeAleatorio = new int[valorN];
	    		int[] arraySelectionAleatorio = new int[valorN];
	    		int[] arrayInsertionAleatorio = new int[valorN];
	    		int[] arrayBubbleAleatorio = new int[valorN];
	    		int[] arrayHeapAleatorio = new int[valorN];
	    		int[] arrayQuickAleatorio = new int[valorN];
	    		
	    		int[] arrayInicial = gerarValoresAleatorios(valorN);
	    		
	    		for(int i = 0; i < valorN; i++)
	    		{
	    			arrayMergeAleatorio[i] = arrayInicial[i];
	    			arraySelectionAleatorio[i] = arrayInicial[i];
	    			arrayInsertionAleatorio[i] = arrayInicial[i];
	    			arrayBubbleAleatorio[i] = arrayInicial[i];
	    			arrayHeapAleatorio[i] = arrayInicial[i];
	    			arrayQuickAleatorio[i] = arrayInicial[i];
	    		}
	    		
	    		MergeSort mergeSort = new MergeSort();
	        	long startTimeMerge = System.nanoTime();
	        	int[] valoresMerge = mergeSort.mergeSort(arrayMergeAleatorio);
	        	long estimatedTimeMerge = System.nanoTime() - startTimeMerge;
	        	
	        	BubbleSort bubbleSort = new BubbleSort();
	        	long startTimeBubble = System.nanoTime();
	        	int[] valoresBubble = bubbleSort.bubbleSort(arrayBubbleAleatorio);
	        	long estimatedTimeBubble = System.nanoTime() - startTimeBubble;
	        	
	        	InserctionSort insertionSort = new InserctionSort();
	        	long startTimeInsertion = System.nanoTime();
	        	int[] valoresInsertion = insertionSort.insertionSort(arrayInsertionAleatorio);
	        	long estimatedTimeInsertion = System.nanoTime() - startTimeInsertion;
	        	
	        	SelectionSort selectionSort = new SelectionSort();
	        	long startTimeSelection = System.nanoTime();
	        	int[] valoresSelection = selectionSort.sort(arraySelectionAleatorio);   		
	        	long estimatedTimeSelection = System.nanoTime() - startTimeSelection;
	        	
	        	HeapSort heapSort = new HeapSort();
	        	long startTimeHeap = System.nanoTime();
	        	int[] valoresHeap = heapSort.sort(arrayHeapAleatorio);   		
	        	long estimatedTimeHeap = System.nanoTime() - startTimeHeap;
	        	
	        	QuickSort quickSort = new QuickSort();
	        	long startTimeQuick = System.nanoTime();
	        	int[] valoresQuick = heapSort.sort(arrayQuickAleatorio);   		
	        	long estimatedTimeQuick = System.nanoTime() - startTimeQuick;
	        	
	        	retorno = "Dados para o algoritmo: " + nomeAlgoritmo + "\n";
	        	retorno += "Valor de n: " + valorN + "\n";
	        	retorno += "Tipo de dados de entrada: " + tipoDeDadosEntrada + "\n\n";
	        	
	        	double secondsMerge = (double)estimatedTimeMerge / 1000000000.0;
	        	double secondsBubble = (double)estimatedTimeBubble / 1000000000.0;
	        	double secondsInsertion = (double)estimatedTimeInsertion / 1000000000.0;
	        	double secondsSelection = (double)estimatedTimeSelection / 1000000000.0;
	        	double secondsHeap = (double)estimatedTimeHeap / 1000000000.0;
	        	double secondsQuick = (double)estimatedTimeQuick / 1000000000.0;
	        	
	        	retorno += "Tempo gasto pelo MergeSort: " + secondsMerge + " s\n";
	        	retorno += "Tempo gasto pelo BubbleSort: " + secondsBubble + " s\n";
	        	retorno += "Tempo gasto pelo InsertionSort: " + secondsInsertion + " s\n";
	        	retorno += "Tempo gasto pelo HeapSort: " + secondsHeap + " s\n";
	        	retorno += "Tempo gasto pelo QuickSort: " + secondsQuick + " s\n";
	        	retorno += "Tempo gasto pelo SelectionSort: " + secondsSelection + " s\n\n";	        	
	        	
	        	retorno += "OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
	        	retorno += "\nOS API Level: " + android.os.Build.VERSION.SDK;
	        	retorno += "\nDevice: " + android.os.Build.DEVICE;
	        	retorno += "\nModel (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
	    		
    		}
    		else if(tipo == 2)
    		{
	    		int[] arrayMergeCrescente = new int[valorN];
	    		int[] arraySelectionCrescente = new int[valorN];
	    		int[] arrayInsertionCrescente = new int[valorN];
	    		int[] arrayBubbleCrescente = new int[valorN];
	    		int[] arrayHeapCrescente = new int[valorN];
	    		int[] arrayQuickCrescente = new int[valorN];
	    		
	    		for(int i = 0; i < valorN; i++)
	    		{
	    			arrayMergeCrescente[i] = i;
	    			arraySelectionCrescente[i] = i;
	    			arrayInsertionCrescente[i] = i;
	    			arrayBubbleCrescente[i] = i;
	    			arrayHeapCrescente[i] = i;
	    			arrayQuickCrescente[i] = i;
	    		}
	    		
	    		MergeSort mergeSort = new MergeSort();
	        	long startTimeMerge = System.nanoTime();
	        	int[] valoresMerge = mergeSort.mergeSort(arrayMergeCrescente);
	        	long estimatedTimeMerge = System.nanoTime() - startTimeMerge;
	        	
	        	BubbleSort bubbleSort = new BubbleSort();
	        	long startTimeBubble = System.nanoTime();
	        	int[] valoresBubble = bubbleSort.bubbleSort(arrayBubbleCrescente);
	        	long estimatedTimeBubble = System.nanoTime() - startTimeBubble;
	        	
	        	InserctionSort insertionSort = new InserctionSort();
	        	long startTimeInsertion = System.nanoTime();
	        	int[] valoresInsertion = insertionSort.insertionSort(arrayInsertionCrescente);
	        	long estimatedTimeInsertion = System.nanoTime() - startTimeInsertion;
	        	
	        	SelectionSort selectionSort = new SelectionSort();
	        	long startTimeSelection = System.nanoTime();
	        	int[] valoresSelection = selectionSort.sort(arraySelectionCrescente);  		
	        	long estimatedTimeSelection = System.nanoTime() - startTimeSelection;
	        	
	        	HeapSort heapSort = new HeapSort();
	        	long startTimeHeap = System.nanoTime();
	        	int[] valoresHeap = heapSort.sort(arrayHeapCrescente);   		
	        	long estimatedTimeHeap = System.nanoTime() - startTimeHeap;
	        	
	        	QuickSort quickSort = new QuickSort();
	        	long startTimeQuick = System.nanoTime();
	        	int[] valoresQuick = heapSort.sort(arrayQuickCrescente);   		
	        	long estimatedTimeQuick = System.nanoTime() - startTimeQuick;
	        	
	        	retorno = "Dados para o algoritmo: " + nomeAlgoritmo + "\n";
	        	retorno += "Valor de n: " + valorN + "\n";
	        	retorno += "Tipo de dados de entrada: " + tipoDeDadosEntrada + "\n\n";
	        	
	        	double secondsMerge = (double)estimatedTimeMerge / 1000000000.0;
	        	double secondsBubble = (double)estimatedTimeBubble / 1000000000.0;
	        	double secondsInsertion = (double)estimatedTimeInsertion / 1000000000.0;
	        	double secondsSelection = (double)estimatedTimeSelection / 1000000000.0;
	        	double secondsHeap = (double)estimatedTimeHeap / 1000000000.0;
	        	double secondsQuick = (double)estimatedTimeQuick / 1000000000.0;
	        	
	        	retorno += "Tempo gasto pelo MergeSort: " + secondsMerge + " s\n";
	        	retorno += "Tempo gasto pelo BubbleSort: " + secondsBubble + " s\n";
	        	retorno += "Tempo gasto pelo InsertionSort: " + secondsInsertion + " s\n";
	        	retorno += "Tempo gasto pelo HeapSort: " + secondsHeap + " s\n";
	        	retorno += "Tempo gasto pelo QuickSort: " + secondsQuick + " s\n";
	        	retorno += "Tempo gasto pelo SelectionSort: " + secondsSelection + " s\n\n";	        	
	        	
	        	retorno += "OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
	        	retorno += "\nOS API Level: " + android.os.Build.VERSION.SDK;
	        	retorno += "\nDevice: " + android.os.Build.DEVICE;
	        	retorno += "\nModel (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
    		}
    		else if(tipo == 3)
    		{
    			int[] arrayMergeDecrescente = new int[valorN];
	    		int[] arraySelectionDecrescente = new int[valorN];
	    		int[] arrayInsertionDecrescente = new int[valorN];
	    		int[] arrayBubbleDecrescente = new int[valorN];
	    		int[] arrayHeapDecrescente = new int[valorN];
	    		int[] arrayQuickDecrescente = new int[valorN];
	    		
	    		for(int i = 0; i < valorN; i++)
	    		{
	    			arrayMergeDecrescente[i] = valorN - i;
	    			arraySelectionDecrescente[i] = valorN - i;
	    			arrayInsertionDecrescente[i] = valorN - i;
	    			arrayBubbleDecrescente[i] = valorN - i;
	    			arrayHeapDecrescente[i] = valorN - i;
	    			arrayQuickDecrescente[i] = valorN - i;
	    		}
	    		
	    		MergeSort mergeSort = new MergeSort();
	        	long startTimeMerge = System.nanoTime();
	        	int[] valoresMerge = mergeSort.mergeSort(arrayMergeDecrescente);
	        	long estimatedTimeMerge = System.nanoTime() - startTimeMerge;
	        	
	        	BubbleSort bubbleSort = new BubbleSort();
	        	long startTimeBubble = System.nanoTime();
	        	int[] valoresBubble = bubbleSort.bubbleSort(arrayBubbleDecrescente);
	        	long estimatedTimeBubble = System.nanoTime() - startTimeBubble;
	        	
	        	InserctionSort insertionSort = new InserctionSort();
	        	long startTimeInsertion = System.nanoTime();
	        	int[] valoresInsertion = insertionSort.insertionSort(arrayInsertionDecrescente);
	        	long estimatedTimeInsertion = System.nanoTime() - startTimeInsertion;
	        	
	        	SelectionSort selectionSort = new SelectionSort();
	        	long startTimeSelection = System.nanoTime();
	        	int[] valoresselection = selectionSort.sort(arraySelectionDecrescente);    		
	        	long estimatedTimeSelection = System.nanoTime() - startTimeSelection;
	        	
	        	HeapSort heapSort = new HeapSort();
	        	long startTimeHeap = System.nanoTime();
	        	int[] valoresHeap = heapSort.sort(arrayHeapDecrescente);   		
	        	long estimatedTimeHeap = System.nanoTime() - startTimeHeap;
	        	
	        	QuickSort quickSort = new QuickSort();
	        	long startTimeQuick = System.nanoTime();
	        	int[] valoresQuick = heapSort.sort(arrayQuickDecrescente);   		
	        	long estimatedTimeQuick = System.nanoTime() - startTimeQuick;
	        	
	        	retorno = "Dados para o algoritmo: " + nomeAlgoritmo + "\n";
	        	retorno += "Valor de n: " + valorN + "\n";
	        	retorno += "Tipo de dados de entrada: " + tipoDeDadosEntrada + "\n\n";
	        	
	        	double secondsMerge = (double)estimatedTimeMerge / 1000000000.0;
	        	double secondsBubble = (double)estimatedTimeBubble / 1000000000.0;
	        	double secondsInsertion = (double)estimatedTimeInsertion / 1000000000.0;
	        	double secondsSelection = (double)estimatedTimeSelection / 1000000000.0;
	        	double secondsHeap = (double)estimatedTimeHeap / 1000000000.0;
	        	double secondsQuick = (double)estimatedTimeQuick / 1000000000.0;
	        	
	        	retorno += "Tempo gasto pelo MergeSort: " + secondsMerge + " s\n";
	        	retorno += "Tempo gasto pelo BubbleSort: " + secondsBubble + " s\n";
	        	retorno += "Tempo gasto pelo InsertionSort: " + secondsInsertion + " s\n";
	        	retorno += "Tempo gasto pelo HeapSort: " + secondsHeap + " s\n";
	        	retorno += "Tempo gasto pelo QuickSort: " + secondsQuick + " s\n";
	        	retorno += "Tempo gasto pelo SelectionSort: " + secondsSelection + " s\n\n";	        	
	        	
	        	retorno += "OS Version: " + System.getProperty("os.version") + "(" + android.os.Build.VERSION.INCREMENTAL + ")";
	        	retorno += "\nOS API Level: " + android.os.Build.VERSION.SDK;
	        	retorno += "\nDevice: " + android.os.Build.DEVICE;
	        	retorno += "\nModel (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
    		}
    	}
    	else
    	{
    		for(int i = 0; i < tVezes; i++)
    		{
    			
    		}
    	}
    	
    	return retorno;
    }
}
