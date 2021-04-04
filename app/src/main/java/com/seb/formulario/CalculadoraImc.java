package com.seb.formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CalculadoraImc extends AppCompatActivity implements View.OnClickListener {

    private TextView tvInformation;
    private TextView tvResult;
    private EditText txtHeight;
    private EditText txtWeight;
    private Button btnCalculator;
    private ImageView imgState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_imc);

        Intent intent = getIntent();
        String name = intent.getStringExtra("nameCalculator");
        String surname = intent.getStringExtra("surnameCalculator");
        String email = intent.getStringExtra("emailCalculator");
        String message = "Hola "+ name + " " + surname +" es un gusto tenerte aca su correo para el informe es: "+email;
        tvInformation = findViewById(R.id.tvInformation);
        tvResult = findViewById(R.id.tvResult);
        txtHeight = findViewById(R.id.txtHeight);
        txtWeight = findViewById(R.id.txtWeight);
        btnCalculator = findViewById(R.id.btnCalculator);
        imgState = findViewById(R.id.imgState);
        tvInformation.setText(message);
        btnCalculator.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        double peso = Integer.parseInt(txtWeight.getText().toString());
        double estatura = Integer.parseInt(txtHeight.getText().toString());
        double resul = (peso/Math.pow(estatura,2))*10000;
        DecimalFormat df = new DecimalFormat("###.#");
        resul = Double.parseDouble(df.format(resul));
        if (resul < 18.5) {
            int img = getResources().getIdentifier("bajopeso","drawable", getPackageName());
            imgState.setImageResource(img);
            tvResult.setText("Su IMC es " + resul + " lo que indica que su peso está en la categoría PESO BAJO para adultos de su misma estatura");
        } else if (resul > 18.5 && resul < 24.9){
            int img = getResources().getIdentifier("normal","drawable", getPackageName());
            imgState.setImageResource(img);
            tvResult.setText("Su IMC es " + resul + " lo que indica que su peso está en la categoría NORMAL para adultos de su misma estatura");
        } else if (resul > 25.0 && resul < 29.9){
            int img = getResources().getIdentifier("sobrepeso","drawable", getPackageName());
            imgState.setImageResource(img);
            tvResult.setText("Su IMC es " + resul + " lo que indica que su peso está en la categoría SOBREPESO para adultos de su misma estatura");
        } else if (resul > 30.0){
            int img = getResources().getIdentifier("obesidad","drawable", getPackageName());
            imgState.setImageResource(img);
            tvResult.setText("Su IMC es " + resul + " lo que indica que su peso está en la categoría OBESO para adultos de su misma estatura");
        } else {
            tvResult.setText("Error verifique los datos");
        }

        if (v.getId() == R.id.btnCalculator) {

        }
    }
}

















