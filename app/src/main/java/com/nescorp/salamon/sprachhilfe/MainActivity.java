package com.nescorp.salamon.sprachhilfe;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;


import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.view.KeyEvent;


public class MainActivity extends AppCompatActivity {

    private Button jabutton;
    private Button neinbutton;

    private TextView ausgabe;
    private TextToSpeech tts;

    private EditText eigenertext;

    private Button painbutton;
    private Button getupbutton;
    private Button helpbutton;
    private Button hungrybutton;
    private Button toiletbutton;
    private Button silencebutton;
    private Button bedbutton;
    private Button thanksbutton;
    private Button thirstybutton;

    private Button getowntext;
    private Button deleteowntext;

    TextToSpeech t1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


     // GUIs
        neinbutton = (Button)   findViewById(R.id.btNein);
        jabutton   = (Button)   findViewById(R.id.btJa);
        ausgabe    = (TextView) findViewById(R.id.tvAusgabe);
        b1         = (Button)   findViewById(R.id.btLesen);

        eigenertext = (EditText) findViewById(R.id.etOwntext);
        getowntext = (Button) findViewById(R.id.btGetowntext);
        deleteowntext = (Button) findViewById(R.id.btDeleteText);



     // Zusatz btHilfe  btHunger btKlo btPain btFamilie btRuhe btGetup btBett
       helpbutton       = (Button)   findViewById(R.id.btHelp);
       hungrybutton     = (Button)   findViewById(R.id.btHungry);
       toiletbutton     = (Button)   findViewById(R.id.btToilet);
       painbutton       = (Button)   findViewById(R.id.btPain);
       silencebutton    = (Button)   findViewById(R.id.btSilence);
       getupbutton      = (Button)   findViewById(R.id.btGetup);
       bedbutton        = (Button)   findViewById(R.id.btBed);
       thanksbutton     = (Button)   findViewById(R.id.btThanks);
       thirstybutton    = (Button)   findViewById(R.id.btThirsty);


     // TTS
        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.GERMANY);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = ausgabe.getText().toString();
                //  Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show(); // für Visuelles Feedback
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });


        final EditText edittext = (EditText) findViewById(R.id.etOwntext);
        edittext.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    // Perform action on key press
                   // Toast.makeText(getApplicationContext(), edittext.getText(), Toast.LENGTH_SHORT).show();
                    ausgabe.setText(eigenertext.getText());
                    return true;
                }
                return false;
            }
        });


    }

    public void buttonGetowntextClick(View v){ausgabe.setText(eigenertext.getText());}
    public void buttonDeleteowntextClick(View v) {eigenertext.setText("");}


    public void buttonJAonClick(View v) {
        ausgabe.setText("Ja");
    }
    public void buttonNEINonClick(View v) {
        ausgabe.setText("Nein");
    }


    public void buttonHelpClick(View v){
        ausgabe.setText("Brauche Hilfe!");
    }
    public void buttonToiletClick(View v){
        ausgabe.setText("Toilette!");
    }
    public void buttonHungryClick(View v){
        ausgabe.setText("Habe Hunger!");
    }
    public void buttonPainClick(View v){
        ausgabe.setText("Schmerzen!");
    }
    public void buttonSilenceClick(View v){
        ausgabe.setText("Brauche Ruhe");
    }
    public void buttonGetupClick(View v){
        ausgabe.setText("Aufstehen!");
    }
    public void buttonBedClick(View v){
        ausgabe.setText("ins Bett!");
    }
    public void buttonThanksClick(View v){
        ausgabe.setText("Danke!");
    }
    public void buttonThirstyClick(View v){
        ausgabe.setText("Habe Durst!");
    }
}
