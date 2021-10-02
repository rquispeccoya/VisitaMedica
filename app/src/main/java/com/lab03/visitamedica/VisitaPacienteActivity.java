package com.lab03.visitamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class VisitaPacienteActivity extends AppCompatActivity {
    public static final String TAG = VisitaPacienteActivity.class.getSimpleName();

    //definiendo variables
    TextView textViewVisitaPaciente;
    Button btnRegistrar;
    EditText editTextPeso;
    EditText editTextTemperatura;
    EditText editTextPresion;
    EditText editTextSaturacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visita_paciente);
        Log.d(TAG,"onCreate");

        textViewVisitaPaciente = findViewById(R.id.textViewDniVisitaPaciente);

        //extrayendo y mostrando el numero del DNI del paciente
        String dni = getIntent().getStringExtra("dni");
        textViewVisitaPaciente.setText("DNI:  " + dni);


        editTextPeso = findViewById(R.id.editTextPesoPaciente);
        editTextTemperatura = (EditText) findViewById(R.id.editTextTemperaturaPaciente);
        editTextPresion = findViewById(R.id.editTextPresionPaciente);
        editTextSaturacion = findViewById(R.id.editTextSaturacionPaciente);
        btnRegistrar = findViewById(R.id.buttonRegistrarVisitaPaciente);

        //funcionamiento del boton
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //extraemos el valor de los editText
                String peso = editTextPeso.getText().toString();
                String temperatura = editTextTemperatura.getText().toString();
                String presion = editTextPresion.getText().toString();
                String saturacion = editTextSaturacion.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("peso", peso);
                intent.putExtra("temperatura", temperatura);
                intent.putExtra("presion", presion);
                intent.putExtra("saturacion", saturacion);
                setResult(2, intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }
}