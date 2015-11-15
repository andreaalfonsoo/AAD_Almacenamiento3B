package com.example.andrea.almacenamiento3b;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity2 extends Activity {
    TextView nombre;
    TextView dni;
    TextView fecha;
    TextView sexo;

    //String nombre;
    //String dni;
    //String fecha;
    //String sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        SharedPreferences mySharedPreferences = getSharedPreferences(getIntent().getExtras().getString("Preferencias"), Activity.MODE_PRIVATE);

        nombre = (TextView) findViewById(R.id.tv_nombre);
        nombre.setText(mySharedPreferences.getString("Nom ", ""));

        dni = (TextView) findViewById(R.id.tv_dni);
        dni.setText(mySharedPreferences.getString("Dni ", ""));

        fecha = (TextView) findViewById(R.id.tv_fecha);
        fecha.setText(mySharedPreferences.getString("Fecha de nacimiento ", ""));

        sexo = (TextView) findViewById(R.id.tv_sexo);
        sexo.setText(mySharedPreferences.getString("Sexo", ""));

        //Toast.makeText(getApplicationContext(), "He recuperado: " + nombre + "\n" + dni + "\n" + fecha + "\n" + sexo, Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity2, menu);
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
