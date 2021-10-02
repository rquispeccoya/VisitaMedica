package com.lab03.visitamedica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MenuPrincipalActivity.class.getSimpleName();
    //definimos las variables
    Button btnRegistrarPaciente;
    Button btnVisitaPaciente;
    Button btnCorreoPaciente;
    TextView txtInformacionPaciente;

    //creamos un arreglo de objetos de tamaño 8 correspondiente a los atributos
    Object paciente[] = new Object[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG,"onCreate");

        btnRegistrarPaciente = findViewById(R.id.buttonRegistroPaciente);
        btnVisitaPaciente = findViewById(R.id.buttonVisitaPaciente);
        btnCorreoPaciente = findViewById(R.id.buttonCorreoPaciente);
        txtInformacionPaciente = findViewById(R.id.textViewInforacionPaciente);

        //evento de los botones
        btnRegistrarPaciente.setOnClickListener(this);
        btnVisitaPaciente.setOnClickListener(this);
        btnCorreoPaciente.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;

        if (view.getId() == R.id.buttonRegistroPaciente) {//boton registro paciente
            intent = new Intent(MenuPrincipalActivity.this, FormularioPacienteActivity.class);
            startActivityForResult(intent, 0);

        } else if (view.getId() == R.id.buttonVisitaPaciente) {//boton Visita paciente
            //verificamos si se ingreso un paciente
            if (paciente[0] != null) {

                intent = new Intent(MenuPrincipalActivity.this, VisitaPacienteActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("dni", paciente[0].toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 2);
            } else {
                Toast.makeText(getApplicationContext(), "Registre un paciente", Toast.LENGTH_LONG).show();
            }

        } else if (view.getId() == R.id.buttonCorreoPaciente) {//boton envio de correo
            //verificamos si se ingreso un paciente
            if (paciente[0] != null) {
                intent = new Intent(MenuPrincipalActivity.this, CorreoPacienteActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Registre un paciente", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 0) {
            paciente[0] = data.getStringExtra("dni");
            paciente[1] = data.getStringExtra("nombres");
            paciente[2] = data.getStringExtra("apellidos");
            paciente[3] = data.getStringExtra("direccion");
            paciente[4] =0.0;
            paciente[5]=0.0;
            paciente[6]=0.0;
            paciente[7]=0.0;
            txtInformacionPaciente.setText("Dni: " + paciente[0] + "\n " +
                    "Nombres: " + paciente[1] + "\n " +
                    "Apellidos: " + paciente[2] + "\n " +
                    "Direccion: " + paciente[3]);
        } else if (resultCode == 2) {
            paciente[4] = data.getStringExtra("peso");
            paciente[5] = data.getStringExtra("temperatura");
            paciente[6] = data.getStringExtra("presion");
            paciente[7] = data.getStringExtra("saturacion");

        }
        txtInformacionPaciente.setText("Dni: " + paciente[0] + "\n " +
                "Nombres: " + paciente[1] + "\n " +
                "Apellidos: " + paciente[2] + "\n " +
                "Direccion: " + paciente[3] + "\n " +
                "Peso: " + paciente[4] + "\n " +
                "Temperatura: " + paciente[5] + "\n " +
                "Presion: " + paciente[6] + "\n " +
                "Saturacion: " + paciente[7]);


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