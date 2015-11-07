package com.lauraaragon.dendue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.lauraaragon.dendue.R;

public class MapActivity extends Activity {

    private Button btnRetoUno;
    private Button btnRetoDos;
    private Button btnRetoTres;
    private Button btnRetoCuatro;
    private Button btnRetoCinco;
    private Button btnRetoSeis;
    private DataBaseOpenHelper dBHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        //dBHelper = new DataBaseOpenHelper(getContext());
        btnRetoUno = (Button) findViewById(R.id.btnRetoUno);
        btnRetoUno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeOneActivity.class);
                startActivity(intent);
            }
        });

        btnRetoDos = (Button) findViewById(R.id.btnRetoDos);
        btnRetoDos.setEnabled(false);
        btnRetoDos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeTwoActivity.class);
                startActivity(intent);
            }
        });

        btnRetoTres = (Button) findViewById(R.id.btnRetoTres);
        btnRetoTres.setEnabled(false);
        btnRetoTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeThreeActivity.class);
                startActivity(intent);
            }
        });

        btnRetoCuatro = (Button) findViewById(R.id.btnRetoCuatro);
        btnRetoCuatro.setEnabled(false);
        btnRetoCuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeFourActivity.class);
                startActivity(intent);
            }
        });

        btnRetoCinco = (Button) findViewById(R.id.btnRetoCinco);
        btnRetoCinco.setEnabled(false);
        btnRetoCinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeFiveActivity.class);
                startActivity(intent);
            }
        });

        btnRetoSeis = (Button) findViewById(R.id.btnRetoSeis);
        btnRetoSeis.setEnabled(false);
        btnRetoSeis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MapActivity.this, ChallengeSixActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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
