package es.vcarmen.sonido;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

/**
 * Created by matinal on 26/01/18.
 */

public class GestorSonido {

    SoundPool sndPool;
    Context pContext;
    private float frecuencia = 1.0f;



    public GestorSonido(Context appContext){
        sndPool = new SoundPool(16, AudioManager.STREAM_MUSIC,100);
        pContext = appContext;
    }

    public void unloadAll(){sndPool.release();}

    public int carga(int sound_id){
        return sndPool.load(pContext,sound_id,1);
    }

    public void suena(int sound_id){
        sndPool.play(sound_id,1,1,1,0,1);
    }

    public void ajustaFrecuencia(float speed){
        if(frecuencia < 0.01f) frecuencia = 0.01f;
        if(frecuencia > 2) frecuencia = 2.0f;

    }

}
