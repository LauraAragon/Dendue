package com.lauraaragon.dendue;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.lauraaragon.dendue.R;

import java.util.ArrayList;
import java.util.Random;

import modelo.Aventura;
import modelo.Letra;
import modelo.Palabra;
import modelo.Reto;
import modelo.Silaba;

public class ChallengeTwoActivity extends Activity {

    private Reto reto;
    private Palabra palabra;
    private TextView txtViewUno;
    private TextView txtViewDos;
    private TextView txtViewTres;
    private TextView txtViewCuatro;
    private Button btnUno;
    private Button btnDos;
    private Button btnTres;
    private Button btnCuatro;
    private ArrayList<String> erroneas;
    private String[] arreglo;
    private TextView txtSeleccionado;
    private ArrayList<TextView> textViews;
    private int index;
    private int intentosPartida;
    private int intentosReto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        intentosPartida = 1;
        intentosReto = 1;
        index = 0;
        setContentView(R.layout.activity_challenge_two);
        txtViewUno = (TextView)findViewById(R.id.textViewOneChallengeTwo);
        txtViewDos = (TextView)findViewById(R.id.textViewTwoChallengeTwo);
        txtViewTres = (TextView)findViewById(R.id.textViewThreeChallengeTwo);
        txtViewCuatro = (TextView)findViewById(R.id.textViewFourChallengeTwo);
        btnUno = (Button) findViewById(R.id.btnPalabraUno);
        btnDos = (Button) findViewById(R.id.btnPalabraDos);
        btnTres = (Button) findViewById(R.id.btnPalabraTres);
        btnCuatro = (Button) findViewById(R.id.btnPalabraCuatro);

        reto = getIntent().getExtras().getParcelable("Reto");
        reto.setIntentos(intentosReto);
        ArrayList<Silaba> silabas = reto.getPalabra().getSilabas();
        txtViewUno.setText(silabas.get(0).getSilaba());
        txtViewDos.setText(silabas.get(1).getSilaba() + silabas.get(2).getSilaba());
        txtViewTres.setText(silabas.get(3).getSilaba());
        txtViewCuatro.setText(silabas.get(4).getSilaba()+silabas.get(5).getSilaba()+silabas.get(6).getSilaba());
        textViews = new ArrayList<TextView>();
        textViews.add(txtViewUno);
        textViews.add(txtViewDos);
        textViews.add(txtViewTres);
        textViews.add(txtViewCuatro);
        txtSeleccionado = textViews.get(index);

        erroneas = reto.getErroneas();
        arreglo = new String[4];
        arreglo = erroneas.get(0).split(";");

        btnUno.setText(arreglo[0]);
        btnDos.setText(arreglo[1]);
        btnTres.setText(arreglo[2]);
        btnCuatro.setText(arreglo[3]);

        btnUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnUno();
            }
        });

        btnDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnDos();
            }
        });

        btnTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnTres();
            }
        });

        btnCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBtnCuatro();
            }
        });
    }


    public void onClickBtnUno(){

        while(index<4 && intentosPartida < 4) {
            if (btnUno.getText().equals(txtSeleccionado.getText())) {
                index++;
                txtSeleccionado = textViews.get(index);
                int i = randomDos();
                //falta cambiar el estado del txt seleccionado.
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);
            } else {

                intentosPartida++;
                int i = randomUno();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);

                //falta mostrar un pop up de "intenta de nuevo".
            }


        }

        if(intentosPartida == 4){
            //mostrar imagen de "vuelve a empezar".
            intentosReto++;
            reto.setIntentos(intentosReto);
            txtSeleccionado = textViews.get(0);
            arreglo = erroneas.get(0).split(";");
            btnUno.setText(arreglo[0]);
            btnDos.setText(arreglo[1]);
            btnTres.setText(arreglo[2]);
            btnCuatro.setText(arreglo[3]);
        }

        else if(index>3){
            //mostrar mensaje de "reto superado"
            Button btnRetoSiguienteMapa = (Button) findViewById(R.id.btnRetoTres);
            btnRetoSiguienteMapa.setEnabled(true);
            int tipoMedalla = 0;
            int intentosreto = reto.getIntentos();
            if(intentosreto == 1){
                tipoMedalla = 1;
            }

            else if(intentosreto == 2){
                tipoMedalla = 2;
            }

            else if(intentosreto > 2){
                tipoMedalla = 3;
            }

            AdminBD.actualizarReto(2,1,tipoMedalla, intentosreto);


        }


    }

    public void onClickBtnDos() {
        while(index<4 && intentosPartida<4) {
            if (btnDos.getText().equals(txtSeleccionado.getText())) {
                index++;
                txtSeleccionado = textViews.get(index);
                //falta cambiar el estado del txt seleccionado.
                int i = randomTres();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);
            } else {

                intentosPartida++;
                int i = randomDos();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);

                //falta mostrar un pop up de "intenta de nuevo".
            }
        }

        if(intentosPartida == 4){
            //mostrar imagen de "vuelve a empezar".
            intentosReto++;
            reto.setIntentos(intentosReto);
            txtSeleccionado = textViews.get(0);
            arreglo = erroneas.get(0).split(";");
            btnUno.setText(arreglo[0]);
            btnDos.setText(arreglo[1]);
            btnTres.setText(arreglo[2]);
            btnCuatro.setText(arreglo[3]);
        }

        else if(index>3){
            //mostrar mensaje de "reto superado"
            Button btnRetoSiguienteMapa = (Button) findViewById(R.id.btnRetoTres);
            btnRetoSiguienteMapa.setEnabled(true);
            int tipoMedalla = 0;

            if(intentosReto == 1){
                tipoMedalla = 1;
            }

            else if(intentosReto == 2){
                tipoMedalla = 2;
            }

            else if(intentosReto > 2){
                tipoMedalla = 3;
            }

            int intentosreto = reto.getIntentos();
            AdminBD.actualizarReto(2,1,tipoMedalla, intentosreto);
        }
    }

    public void onClickBtnTres(){
        while(index<4 && intentosPartida<4) {
            if (btnTres.getText().equals(txtSeleccionado.getText())) {
                index++;
                txtSeleccionado = textViews.get(index);
                //falta cambiar el estado del txt seleccionado.
                int i = randomCuatro();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);
            } else {

                intentosPartida++;
                int i = randomTres();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);

                //falta mostrar un pop up de "intenta de nuevo".
            }
        }

        if(intentosPartida == 4){
            //mostrar imagen de "vuelve a empezar".
            intentosReto++;
            reto.setIntentos(intentosReto);
            txtSeleccionado = textViews.get(0);
            arreglo = erroneas.get(0).split(";");
            btnUno.setText(arreglo[0]);
            btnDos.setText(arreglo[1]);
            btnTres.setText(arreglo[2]);
            btnCuatro.setText(arreglo[3]);
        }

        else if(index>3){
            //mostrar mensaje de "reto superado"
            Button btnRetoSiguienteMapa = (Button) findViewById(R.id.btnRetoTres);
            btnRetoSiguienteMapa.setEnabled(true);
            int tipoMedalla = 0;

            if(intentosReto == 1){
                tipoMedalla = 1;
            }

            else if(intentosReto == 2){
                tipoMedalla = 2;
            }

            else if(intentosReto > 2){
                tipoMedalla = 3;
            }

            int intentosreto = reto.getIntentos();
            AdminBD.actualizarReto(2,1,tipoMedalla, intentosreto);
        }

    }

    public void onClickBtnCuatro(){

        while(index<4 && intentosPartida<4) {
            if (btnCuatro.getText().equals(txtSeleccionado.getText())) {
                index++;
                txtSeleccionado = textViews.get(index);
                //falta cambiar el estado del txt seleccionado.
                int i = randomCuatro();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);
            } else {

                intentosPartida++;
                int i = randomTres();
                arreglo = erroneas.get(i).split(";");
                btnUno.setText(arreglo[0]);
                btnDos.setText(arreglo[1]);
                btnTres.setText(arreglo[2]);
                btnCuatro.setText(arreglo[3]);

                //falta mostrar un pop up de "intenta de nuevo".
            }
        }

        if(intentosPartida == 4){
            //mostrar imagen de "vuelve a empezar".
            intentosReto++;
            reto.setIntentos(intentosReto);
            txtSeleccionado = textViews.get(0);
            arreglo = erroneas.get(0).split(";");
            btnUno.setText(arreglo[0]);
            btnDos.setText(arreglo[1]);
            btnTres.setText(arreglo[2]);
            btnCuatro.setText(arreglo[3]);
        }

        else if(index>3){
            //mostrar mensaje de "reto superado"
            Button btnRetoSiguienteMapa = (Button) findViewById(R.id.btnRetoTres);
            btnRetoSiguienteMapa.setEnabled(true);
            int tipoMedalla = 0;

            if(intentosReto == 1){
                tipoMedalla = 1;
            }

            else if(intentosReto == 2){
                tipoMedalla = 2;
            }

            else if(intentosReto > 2){
                tipoMedalla = 3;
            }

            int intentosreto = reto.getIntentos();
            AdminBD.actualizarReto(2,1,tipoMedalla, intentosreto);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge_two, menu);
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

    public int randomUno(){
        int i = 0;
        Random random = new Random();
        i = random.nextInt(3)+1;
        return i;
    }

    public int randomDos(){
        int i = 0;
        Random random = new Random();
        i = random.nextInt((6-4)+1)+4;
        return i;
    }

    public int randomTres(){
        int i = 0;
        Random random = new Random();
        i = random.nextInt((9-7)+1)+7;
        return i;
    }

    public int randomCuatro(){
        int i = 0;
        Random random = new Random();
        i = random.nextInt((12-10)+1)+10;
        return i;
    }
}
