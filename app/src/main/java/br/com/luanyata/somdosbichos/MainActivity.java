package br.com.luanyata.somdosbichos;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView cachorro;
    private ImageView gato;
    private ImageView leao;
    private ImageView macaco;
    private ImageView vaca;
    private ImageView ovelha;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cachorro = (ImageView) findViewById(R.id.idCachorro);
        gato = (ImageView) findViewById(R.id.idGato);
        leao = (ImageView) findViewById(R.id.idLeao);
        macaco = (ImageView) findViewById(R.id.idMacaco);
        vaca = (ImageView) findViewById(R.id.idVaca);
        ovelha = (ImageView) findViewById(R.id.idOvelha);

        cachorro.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);
        vaca.setOnClickListener(this);
        ovelha.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idCachorro:
                mediaPlayer = MediaPlayer.create(this, R.raw.cao);
                tocarSom();
                break;
            case R.id.idGato:
                mediaPlayer = MediaPlayer.create(this, R.raw.gato);
                tocarSom();
                break;
            case R.id.idLeao:
                mediaPlayer = MediaPlayer.create(this, R.raw.leao);
                tocarSom();
                break;
            case R.id.idMacaco:
                mediaPlayer = MediaPlayer.create(this, R.raw.macaco);
                tocarSom();
                break;
            case R.id.idVaca:
                mediaPlayer = MediaPlayer.create(this, R.raw.vaca);
                tocarSom();
                break;
            case R.id.idOvelha:
                mediaPlayer = MediaPlayer.create(this, R.raw.ovelha);
                tocarSom();
                break;
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.release();
            }
        });
    }

    private void tocarSom() {
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
