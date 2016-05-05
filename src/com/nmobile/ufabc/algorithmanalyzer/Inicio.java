package com.nmobile.ufabc.algorithmanalyzer;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class Inicio extends Activity 
{
	
	private Timer timerAtual = new Timer();
    private TimerTask task;
    private final Handler handler = new Handler();
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        task = new TimerTask() 
        {
	        public void run() 
	        {
				handler.post(new Runnable() 
				{
					public void run() 
					{
						Intent intent = new Intent(Inicio.this,MenuActivity.class);
					    startActivity(intent);
					    timerAtual.cancel();
					}
				});
	        }
        };
        
        timerAtual.schedule(task, 1500);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.inicio, menu);
        return true;
    }
}
