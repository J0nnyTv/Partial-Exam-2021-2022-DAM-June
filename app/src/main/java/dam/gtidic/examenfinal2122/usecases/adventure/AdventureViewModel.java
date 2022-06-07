package dam.gtidic.examenfinal2122.usecases.adventure;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import dam.gtidic.examenfinal2122.utils.PreferencesProvider;

//El primer error viene de no extender la clase a ViewModel
public class AdventureViewModel extends ViewModel {

    public MutableLiveData<String> livesTv;
    public int lives;
        public MutableLiveData<Boolean> adventure_button;

    public AdventureViewModel() {
        this.livesTv = new MutableLiveData<>();
        this.adventure_button = new MutableLiveData<>();
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        this.livesTv.setValue(String.valueOf(lives) + " vides");
        this.adventure_button.setValue(true);
    }

    public void purchaseALive(){
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        PreferencesProvider.providePreferences().edit().putInt("lives", lives + 1).commit();
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        this.livesTv.setValue( String.valueOf(lives) + " vides");
    }

    public void showMathAdventureButton(){
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        if (lives <= 0){
            this.adventure_button.setValue(false);
        }
        else{
            this.adventure_button.setValue(true);
        }
    }
}
