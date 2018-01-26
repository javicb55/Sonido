package es.vcarmen.sonido;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class Sonido extends AppCompatActivity {

    private SeekBar sbVolumen, sbFrecuencia, sbBalance;
    private int laser,gato,disparo,explosion;
    GestorSonido snd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonido);

        sbVolumen = findViewById(R.id.sb_volumen);
        sbFrecuencia = findViewById(R.id.sb_frecuencia);
        sbBalance = findViewById(R.id.sb_balance);




        SeekBar.OnSeekBarChangeListener barChange;
        barChange = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (seekBar.getId()){
                    case R.id.sb_volumen:
                        break;
                    case R.id.sb_frecuencia:
                        break;
                    case R.id.sb_balance:
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        sbVolumen.setOnSeekBarChangeListener(barChange);
        sbFrecuencia.setOnSeekBarChangeListener(barChange);
        sbBalance.setOnSeekBarChangeListener(barChange);

        snd = new GestorSonido(getApplicationContext());
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);


        laser     = snd.carga(R.raw.laser);
        gato      = snd.carga(R.raw.gato);
        disparo   = snd.carga(R.raw.disparo);
        explosion = snd.carga(R.raw.explosion);

    }


    public void pulsado(View view){

        switch (view.getId()){
            case R.id.btn_bomba:
                snd.suena(explosion);
                break;
            case R.id.btn_disparo:
                snd.suena(disparo);
                break;
            case R.id.btn_laser:
                snd.suena(laser);
                break;
            case R.id.btn_maullido:
                snd.suena(gato);
                break;

        }

    }


}
