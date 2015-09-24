package com.alejandrobarrero.notafinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText quiz = (EditText) findViewById(R.id.quiz);
        final EditText expo = (EditText) findViewById(R.id.expo);
        final EditText lab = (EditText) findViewById(R.id.lab);
        final EditText proyf = (EditText) findViewById(R.id.pfin);
        final TextView prom = (TextView) findViewById(R.id.nota);
        Button Calcular = (Button) findViewById(R.id.boton);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double qui,exp,plab,pf,nf;
                int error=0;
                DecimalFormat df = new DecimalFormat("0.00");
                qui = Double.parseDouble(quiz.getText().toString());
                if(qui>5)error=1;
                exp = Double.parseDouble(expo.getText().toString());
                if(exp>5)error=1;
                plab = Double.parseDouble(lab.getText().toString());
                if(plab>5)error=1;
                pf = Double.parseDouble(proyf.getText().toString());
                if(pf>5)error=1;

                if(error==0)
                {
                    nf = qui * 0.15 + exp * 0.1 + plab * 0.4 + pf * 0.35;
                    prom.setText(String.valueOf(df.format(nf)));
                }
                else prom.setText("ERROR");

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
