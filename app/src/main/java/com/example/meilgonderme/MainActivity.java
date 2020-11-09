package com.example.meilgonderme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText icerik, konu, mailAdres;
    Button button;
    String icerikText, konuText, mailAdresText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tanimla();
        GorVeGonder();
    }

    public void tanimla() {
        icerik = (EditText) findViewById(R.id.editTextMailIcerik);
        konu = (EditText) findViewById(R.id.editTextMailKonusu);
        mailAdres = (EditText) findViewById(R.id.editTextMailAdres);
        button = (Button) findViewById(R.id.mailAt);
    }

    public void bilgiAl() {
        icerikText = icerik.getText().toString();
        konuText = konu.getText().toString();
        mailAdresText = mailAdres.getText().toString();
    }

    public void GorVeGonder() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bilgiAl();
                try {
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("message/rfc822");
                    intent.putExtra(Intent.EXTRA_EMAIL, mailAdresText);
                    intent.putExtra(Intent.EXTRA_SUBJECT, konuText);
                    intent.putExtra(Intent.EXTRA_TEXT, icerikText);
                    startActivity(Intent.createChooser(intent,"MEsajınızı G,r,n,z."));
                } catch (
                        Exception e) {
                    //System.out.println("" + e);
                }
            }
        });
    }
}