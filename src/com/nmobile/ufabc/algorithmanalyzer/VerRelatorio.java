package com.nmobile.ufabc.algorithmanalyzer;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class VerRelatorio extends SherlockActivity 
{
	
	String dados;
	TextView txtRelatorio;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_relatorio);
        
        Bundle bundle = getIntent().getExtras();
        dados = bundle.getString("dados");
        
        txtRelatorio = (TextView) findViewById(R.id.txtRelatorio);
        txtRelatorio.setText(dados);
    }
    
    public void salvarRelatorio(View v)
    {
    	try 
    	{
            File myFile = new File("/sdcard/relatorio.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(dados);
            myOutWriter.close();
            fOut.close();
            Toast.makeText(v.getContext(),"Done writing SD 'relatorio.txt'", Toast.LENGTH_SHORT).show();
        } 
        catch (Exception e) 
        {
            Toast.makeText(this, e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }

}
