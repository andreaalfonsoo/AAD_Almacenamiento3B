package com.example.andrea.almacenamiento3b;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class Activity1 extends Activity {

    EditText nombre;
    EditText dni;
    EditText fecha;
    RadioGroup sexo;
    Button siguiente;
    final int activity2=1;

    private static final String PREFS = "Mis preferencias";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        nombre = (EditText) findViewById(R.id.et_nombre);
        dni = (EditText) findViewById(R.id.et_dni);
        fecha = (EditText) findViewById(R.id.et_fechaNac);
        sexo = (RadioGroup) findViewById(R.id.rg_sexo);
        siguiente = (Button) findViewById(R.id.bt_siguiente);



        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Activity2.class);

                //Creamos el objeto de preferencias compartidas
                SharedPreferences mySharedPreferences = getSharedPreferences(PREFS, Activity.MODE_PRIVATE);
                //Obtenemos un editor para modificar las preferencias
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                //Guardar los valores
                editor.putString("Nom ", nombre.getText().toString());
                editor.putString("Dni ", dni.getText().toString());
                editor.putString("Fecha de nacimiento ", fecha.getText().toString());
                switch (sexo.getCheckedRadioButtonId()) {
                    case R.id.rb_hombre:
                        editor.putString("Sexo", "Hombre");
                        break;
                    case R.id.rb_mujer:
                        editor.putString("Sexo", "Mujer");
                        break;
                }
                //Guardamos los cambios
                editor.commit();

                i.putExtra("Preferencias", PREFS);
                startActivityForResult(i, activity2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
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
