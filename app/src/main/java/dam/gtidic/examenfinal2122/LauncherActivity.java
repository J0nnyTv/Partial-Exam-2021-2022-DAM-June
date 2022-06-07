package dam.gtidic.examenfinal2122;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import dam.gtidic.examenfinal2122.usecases.adventure.AdventureActivity;
import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(this.getClass().getSimpleName(), " -> onCreate()");

        setup();
        data();
    }

    // Private methods
    private void setup(){
        Log.d(this.getClass().getSimpleName(), " -> setup()");
        Log.d(this.getClass().getSimpleName(), " ... init Shared Preferences()");
        PreferencesProvider.init(this);

        //Lives comienza a 0 al pasar por esta activity solo si no hay nada guardado en lives
        int lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        if (lives == 0){
            PreferencesProvider.providePreferences().edit().putInt("lives", 0).commit();
        }
    }

    private void data(){
        showHome();
        finish();
    }

    private void showHome(){
        startActivity(new Intent(this, AdventureActivity.class));
    }

}