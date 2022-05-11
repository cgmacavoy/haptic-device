package edu.stanford.cmacavoy.hapticfeedback;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;

import static android.Manifest.permission.RECORD_AUDIO;
import static java.lang.Thread.sleep;


public class MainActivity extends AppCompatActivity {

    public void stopVibrating(Vibrator v) {
        v.cancel();
    }
    public void normalPattern(Vibrator v) {
        stopVibrating(v);
        long[] pattern = {0, 50, 450};
        v.vibrate(VibrationEffect.createWaveform(pattern,0));
    }
    public void fastPattern(Vibrator v) {
        stopVibrating(v);
        long[] pattern = {0, 50, 350};
        v.vibrate(VibrationEffect.createWaveform(pattern,0));
    }
    public void slowPattern(Vibrator v) {
        stopVibrating(v);
        long[] pattern = {0, 50, 550};
        v.vibrate(VibrationEffect.createWaveform(pattern,0));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        normalPattern(v);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        fastPattern(v);
        try {
            sleep(3200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        slowPattern(v);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopVibrating(v);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}