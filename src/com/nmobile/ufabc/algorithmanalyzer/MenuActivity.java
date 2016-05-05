package com.nmobile.ufabc.algorithmanalyzer;

import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

import com.actionbarsherlock.view.MenuItem;

public class MenuActivity extends SherlockActivity 
{

    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    
    public void abreMerge(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "merge");
    	startActivity(intent);
    }
    
    public void abreSelection(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "selection");
    	startActivity(intent);
    }
    
    public void abreInsertion(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "insertion");
    	startActivity(intent);
    }
    
    public void abreBubble(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "bubble");
    	startActivity(intent);
    }
    
    public void abreHeap(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "heap");
    	startActivity(intent);
    }
    
    public void abreQuick(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "quick");
    	startActivity(intent);
    }
    
    public void abreTodos(View v)
    {
    	Intent intent = new Intent(MenuActivity.this, OpcoesOrdenador.class);
    	intent.putExtra("ordenador", "todos");
    	startActivity(intent);
    }
    
}
