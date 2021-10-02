package com.lab03.visitamedica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class FormularioPacienteActivity extends AppCompatActivity {
    Button btnRegistrar ;
    EditText editTextDni;
    EditText editTextNombres;
    EditText editTextApellidos;
    EditText editTextDireccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_paciente);

        editTextDni=findViewById(R.id.editTextNumber);
        editTextNombres=(EditText) findViewById(R.id.editTextNombresPaciente);
        editTextApellidos=findViewById(R.id.editTextApellidosPaciente);
        editTextDireccion=findViewById(R.id.editTextDireccionPaciente);
        btnRegistrar=findViewById(R.id.buttonRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //String dni = editTextDni.getText().toString();
                String nombres=editTextNombres.getText().toString();
                String apellidos=editTextApellidos.getText().toString();
                String direccion=editTextDireccion.getText().toString();

                Intent intent = new Intent();
                //intent.putExtra("dni",dni);
                intent.putExtra("nombres",nombres);
                //intent.putExtra("apellidos",apellidos);
                //intent.putExtra("direccion",direccion);
                setResult(0,intent);
                finish();
            }
        });
    }
}