package com.lab03.visitamedica;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuPrincipalActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnRegistrarPaciente ;
    Button btnVisitaPaciente;
    TextView txtInformacionPaciente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarPaciente=findViewById(R.id.buttonRegistroPaciente);
        btnVisitaPaciente=findViewById(R.id.buttonVisitaPaciente);

        btnRegistrarPaciente.setOnClickListener(this);
        //btnVisitaPaciente.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if (view.getId()==R.id.buttonRegistroPaciente){
            intent = new Intent(MenuPrincipalActivity.this, FormularioPacienteActivity.class);
            startActivityForResult(intent,0);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //txtInformacionPaciente.setText(data.getStringExtra("dni"));
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) { // Activity.RESULT_OK

                //txtInformacionPaciente.setText(data.getStringExtra("nombres"));
                txtInformacionPaciente.setText("HOLAAA");
            }
        }
    }
}