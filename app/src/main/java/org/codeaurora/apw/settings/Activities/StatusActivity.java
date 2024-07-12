package org.codeaurora.apw.settings.Activities;

import android.os.Bundle;
import android.preference.SwitchPreference;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.databinding.ActivityStatusBinding;
import org.codeaurora.apw.settings.fragments.SettingsPreference;

public class StatusActivity extends AppCompatActivity {
    public ActivityStatusBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStatusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v ->{
            onBackPressed();
        });
        	getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,new SettingsPreference()).commit();
    }
}