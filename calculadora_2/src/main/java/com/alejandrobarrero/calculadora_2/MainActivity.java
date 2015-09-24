package com.alejandrobarrero.calculadora_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioButton sum,res,mul,div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        final EditText op1 = (EditText) findViewById(R.id.op_1);
        final EditText op2 = (EditText) findViewById(R.id.op_2);
        final TextView resu = (TextView) findViewById(R.id.result);
        Button Calcular = (Button) findViewById(R.id.boton);
        sum = (RadioButton)findViewById(R.id.suma);
        res = (RadioButton)findViewById(R.id.resta);
        mul = (RadioButton)findViewById(R.id.mult);
        div = (RadioButton)findViewById(R.id.div);

        
        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double op_1, op_2, result=0;
                int error = 0;

                op_1 = Double.parseDouble(op1.getText().toString());
                op_2 = Double.parseDouble(op2.getText().toString());

                if(sum.isChecked()) {
                    result = op_1 + op_2;}
                else if(res.isChecked()){
                         result = op_1 - op_2;}
                     else if(mul.isChecked()){
                              result = op_1*op_2;}
                          else if(div.isChecked()){
                                    if(op_2==0.0)
                                        error=1;
                                    else
                                        result = op_1/op_2;}

                if(error==0)
                    resu.setText(String.valueOf(result));
                else
                    resu.setText("ERROR");
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
