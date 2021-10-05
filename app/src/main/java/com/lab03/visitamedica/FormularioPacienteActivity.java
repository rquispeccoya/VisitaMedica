package com.lab03.visitamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FormularioPacienteActivity extends AppCompatActivity {

    public static final String TAG = FormularioPacienteActivity.class.getSimpleName();

    Button btnRegistrar ;
    EditText editTextDni;
    EditText editTextNombres;
    EditText editTextApellidos;
    EditText editTextDireccion;
    EditText correoPaciente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_paciente);

        Log.d(TAG,"onCreate");

        editTextDni=findViewById(R.id.editTextNumber);
        editTextNombres=(EditText) findViewById(R.id.editTextNombresPaciente);
        editTextApellidos=findViewById(R.id.editTextApellidosPaciente);
        editTextDireccion=findViewById(R.id.editTextDireccionPaciente);
        correoPaciente=findViewById(R.id.correoPaciente);
        btnRegistrar=findViewById(R.id.buttonRegistrar);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dni = editTextDni.getText().toString();
                String nombres=editTextNombres.getText().toString();
                String apellidos=editTextApellidos.getText().toString();
                String direccion=editTextDireccion.getText().toString();
                String correo=correoPaciente.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("dni",dni);
                intent.putExtra("nombres",nombres);
                intent.putExtra("apellidos",apellidos);
                intent.putExtra("direccion",direccion);
                intent.putExtra("correo",correo);
                setResult(RESULT_OK, intent);
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