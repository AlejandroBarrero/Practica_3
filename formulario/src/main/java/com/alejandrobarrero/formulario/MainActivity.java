package com.alejandrobarrero.formulario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private RadioButton male,female;
    CheckBox mus,spo,ar,rea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nombre = (EditText) findViewById(R.id.nombre);
        final EditText apellido = (EditText) findViewById(R.id.apellido);
        final EditText ident = (EditText) findViewById(R.id.ident);
        final TextView nombreout = (TextView ) findViewById(R.id.nombreout);
        final TextView apellidoout = (TextView ) findViewById(R.id.apellidoout);
        final TextView identout = (TextView ) findViewById(R.id.identout);
        final TextView sexout = (TextView ) findViewById(R.id.sexoout);
        final TextView cityout = (TextView ) findViewById(R.id.lugarout);
        final TextView hobby1 = (TextView ) findViewById(R.id.hobby1out);
        final TextView hobby2 = (TextView ) findViewById(R.id.hobby2out);
        final TextView hobby3 = (TextView ) findViewById(R.id.hobby3out);
        final TextView hobby4 = (TextView ) findViewById(R.id.hobby4out);
        mus = (CheckBox) findViewById(R.id.music);
        spo = (CheckBox) findViewById(R.id.sport);
        ar = (CheckBox) findViewById(R.id.art);
        rea = (CheckBox) findViewById(R.id.read);


        final Spinner spin = (Spinner) findViewById(R.id.ciudades);
        Button Guardar = (Button) findViewById(R.id.boton);

        male = (RadioButton)findViewById(R.id.masc);
        female= (RadioButton)findViewById(R.id.fem);

        Guardar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                nombreout.setText(nombre.getText());
                apellidoout.setText(apellido.getText());
                identout.setText(ident.getText());

                if (male.isChecked()) sexout.setText("M");
                else if(female.isChecked()) sexout.setText("F");

                cityout.setText(spin.getSelectedItem().toString());

                String mu,sp,a,le;
                if(Locale.getDefault().getLanguage().equals("en"))
                {
                    mu = "Music";
                    sp = "Sports";
                    a = "Arts";
                    le = "Reading";
                }
                else
                {
                    mu = "Música";
                    sp = "Deportes";
                    a = "Artes";
                    le = "Lectura";
                }

                if(mus.isChecked())hobby1.setText(mu);
                else hobby1.setText("");
                if(spo.isChecked())hobby2.setText(sp);
                else hobby2.setText("");
                if(ar.isChecked())hobby3.setText(a);
                else hobby3.setText("");
                if(rea.isChecked())hobby4.setText(le);
                else hobby4.setText("");
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
