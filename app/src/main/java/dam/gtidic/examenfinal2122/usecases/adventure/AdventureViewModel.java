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

    public AdventureViewModel() {
        this.livesTv = new MutableLiveData<>();
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        this.livesTv.setValue(String.valueOf(lives) + " vides");
    }

    public void purchaseALive(){
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        PreferencesProvider.providePreferences().edit().putInt("lives", lives + 1).commit();
        this.lives = PreferencesProvider.providePreferences().getInt("lives", 0);
        this.livesTv.setValue( String.valueOf(lives) + " vides");
    }
}
