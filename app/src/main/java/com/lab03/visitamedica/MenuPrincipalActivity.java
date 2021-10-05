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
    Object paciente[] = new Object[9];

    String informacionPaciente="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate");

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
                startActivityForResult(intent, 1);
            } else {
                Toast.makeText(getApplicationContext(), "Registre un paciente", Toast.LENGTH_LONG).show();
            }

        } else if (view.getId() == R.id.buttonCorreoPaciente) {//boton envio de correo
            //verificamos si se ingreso un paciente
            if (paciente[0] != null) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{paciente[4].toString()});
                email.putExtra(Intent.EXTRA_SUBJECT, "CORREO MEDICO");
                email.putExtra(Intent.EXTRA_TEXT, "Buenos dias paciente " + paciente[1].toString());

                //need this to prompts email client only
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            } else {
                Toast.makeText(getApplicationContext(), "Registre un paciente", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                paciente[0] = data.getStringExtra("dni");
                paciente[1] = data.getStringExtra("nombres");
                paciente[2] = data.getStringExtra("apellidos");
                paciente[3] = data.getStringExtra("direccion");
                paciente[4] = data.getStringExtra("correo");

                informacionPaciente=" Dni: " + paciente[0] + "\n " +
                        "Nombres: " + paciente[1] + "\n " +
                        "Apellidos: " + paciente[2] + "\n " +
                        "Direccion: " + paciente[3] + "\n " +
                        "Correo: " + paciente[4]+"\n ";

                txtInformacionPaciente.setText(informacionPaciente);
            }else{
                txtInformacionPaciente.setText("Informacion Pacientes");
                Toast.makeText(getApplicationContext(), "Registro cancelado", Toast.LENGTH_LONG).show();
            }


        } else if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                paciente[5] = data.getStringExtra("peso");
                paciente[6] = data.getStringExtra("temperatura");
                paciente[7] = data.getStringExtra("presion");
                paciente[8] = data.getStringExtra("saturacion");

                informacionPaciente += "Peso: " + paciente[5] + "\n " +
                        "Temperatura: " + paciente[6] + "\n " +
                        "Presion: " + paciente[7] + "\n " +
                        "Saturacion: " + paciente[8];

                txtInformacionPaciente.setText(informacionPaciente);
            }else{
                txtInformacionPaciente.setText(informacionPaciente);
                Toast.makeText(getApplicationContext(), "Visita Cancelada", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}