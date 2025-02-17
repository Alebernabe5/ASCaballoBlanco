package com.example.ejerciciopropuesto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected TextView texto1;
    protected EditText cajaRespuesta1;
    protected Button boton1;
    protected TextView texto2;

    protected ImageView ima1;

    protected String contenidoCaja1= "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


            texto1 = (TextView) findViewById(R.id.textViewPregunta_main);
            cajaRespuesta1 = (EditText) findViewById(R.id.cajaRespuesta_main);
            boton1 = (Button) findViewById(R.id.boton1_main);
            texto2 = (TextView) findViewById(R.id.textViewRespuesta_main);
            ima1 = (ImageView) findViewById(R.id.img1_main);



            boton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contenidoCaja1 = cajaRespuesta1.getText().toString().toLowerCase();
                    if (contenidoCaja1.equals("")){
                        texto2.setText("Escriba su respuesta");
                    }else {
                        if (contenidoCaja1.equals("blanco")){

                            texto2.setText("Respuesta Correcta");
                            ima1.setImageResource(R.drawable.correcto);
                            boton1.setEnabled(false);
                        }
                        else{
                            texto2.setText("Respuesta Incorrecta");
                            ima1.setImageResource(R.drawable.error);
                        }
                    }

                }
            });




    }
}