package com.lauraaragon.dendue;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.example.lauraaragon.dendue.R;

import java.util.ArrayList;
import java.util.Random;

import modelo.Letra;
import modelo.Reto;

public class ChallengeSixActivity extends Activity {

    private TextView[][] letters;
    private Reto reto;
    private int intentosPartida;
    private int intentosReto;
    private int indexRandom;
    private ArrayList<Letra> letras;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_six);

        intentosPartida = 1;
        intentosReto = 1;
        indexRandom = 0;
        reto = getIntent().getExtras().getParcelable("Reto");
        reto.setIntentos(intentosReto);
        letras = reto.getPalabra().getLetras();

        letters = new TextView[5][5];
        for (int i = 0; i<2; i++) {
            for (int j = 0; j<5; j++) {
                TextView textView = new Button(this);
                letters[i][j] = textView;
            }
        }

        createTextViews();
    }

    public void createTextViews(){

        letters[0][0] = (TextView)findViewById(R.id.letterOne);
        letters[0][1] = (TextView)findViewById(R.id.letterTwo);
        letters[0][2] = (TextView)findViewById(R.id.letterThree);
        letters[0][3] = (TextView)findViewById(R.id.letterFour);
        letters[0][4] = (TextView)findViewById(R.id.letterFive);
        letters[1][0] = (TextView)findViewById(R.id.letterSix);
        letters[1][1] = (TextView)findViewById(R.id.letterSeven);
        letters[1][2] = (TextView)findViewById(R.id.letterEight);
        letters[1][3] = (TextView)findViewById(R.id.letterNine);
        letters[1][4] = (TextView)findViewById(R.id.letterTen);

        for (int i = 0; i<2; i++){
            for (int j = 0; j<5; j++){

                setIForIndexRandom();
                letters[i][j].setText(letras.get(indexRandom).getLetra());

            }
        }
    }


    public void setIForIndexRandom(){
        int i = 0;
        Random random = new Random();
        i = random.nextInt(10)+1;

        if (i==indexRandom){
            i = random.nextInt(10)+1;
        }

        setIndexRandom(i);

    }


    public void setIndexRandom(int i){
        this.indexRandom = i;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_challenge_six, menu);
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
