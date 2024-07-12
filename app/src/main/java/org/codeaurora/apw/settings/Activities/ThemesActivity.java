package org.codeaurora.apw.settings.Activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.widget.CompoundButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.materialswitch.MaterialSwitch;
import com.google.android.material.transition.MaterialArcMotion;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.databinding.ActivityThemesBinding;

public class ThemesActivity extends AppCompatActivity {
    public ActivityThemesBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThemesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(
                v -> {
                    onBackPressed();
                });
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = getApplicationContext().registerReceiver(null, filter);
        int level = batteryStatus.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = batteryStatus.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int batteryPercent = (int) ((level / (float) scale) * 100);
        SharedPreferences sharedPreferences = getSharedPreferences("save", MODE_PRIVATE);
        binding.hello.setChecked(sharedPreferences.getBoolean("value", false));
        binding.hello.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("SWITCH_STATE", isChecked);
                        if (isChecked) {
                            ContentResolver contentResolver = getContentResolver();
                            SharedPreferences.Editor editor =
                                    getSharedPreferences("save", MODE_PRIVATE).edit();
                            editor.putBoolean("value", true);
                            editor.apply();
                            binding.hello.setChecked(true);
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            try {
                                Settings.Secure.putInt(contentResolver, "ui_night_mode", 2);
                                Toast.makeText(
                                                getApplicationContext(),
                                                "We suggest you to reboot your device to make changes visible",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            } catch (Exception err) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                "An error occured",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        } else {
                            SharedPreferences.Editor editor =
                                    getSharedPreferences("save", MODE_PRIVATE).edit();
                            editor.putBoolean("value", false);
                            editor.apply();
                            binding.hello.setChecked(false);
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            ContentResolver contentResolver = getContentResolver();
                            try {
                                Settings.Secure.putInt(contentResolver, "ui_night_mode", 1);
                                Toast.makeText(
                                                getApplicationContext(),
                                                "We suggest you to reboot your device to make changes visible",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            } catch (Exception err) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                "An error occured",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    }
                });
        SharedPreferences sharedPreferences2 = getSharedPreferences("save2", MODE_PRIVATE);
        binding.hello2.setChecked(sharedPreferences2.getBoolean("value2", false));
        binding.hello2.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            ContentResolver contentResolver = getContentResolver();
                            SharedPreferences.Editor editor =
                                    getSharedPreferences("save2", MODE_PRIVATE).edit();
                            editor.putBoolean("value2", true);
                            editor.apply();
                            binding.hello2.setChecked(true);
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                            try {
                                if (batteryPercent <= 50) {
                                    Settings.Secure.putInt(contentResolver, "ui_night_mode", 2);
                                    Toast.makeText(
                                                    getApplicationContext(),
                                                    "We suggest you to reboot your device to make changes visible",
                                                    Toast.LENGTH_SHORT)
                                            .show();
                                }
                            } catch (Exception err) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                "An error occured",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        } else {
                            SharedPreferences.Editor editor2 =
                                    getSharedPreferences("save2", MODE_PRIVATE).edit();
                            editor2.putBoolean("value2", false);
                            editor2.apply();
                            binding.hello2.setChecked(false);
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                            ContentResolver contentResolver = getContentResolver();
                            try {
                                Settings.Secure.putInt(contentResolver, "ui_night_mode", 1);
                                Toast.makeText(
                                                getApplicationContext(),
                                                "We suggest you to reboot your device to make changes visible",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            } catch (Exception err) {
                                Toast.makeText(
                                                getApplicationContext(),
                                                "An error occured",
                                                Toast.LENGTH_SHORT)
                                        .show();
                            }
                        }
                    }
                });
        int currentNightMode =
                getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (currentNightMode) {
            case Configuration.UI_MODE_NIGHT_NO:
                binding.light.setTextColor(
                        ContextCompat.getColor(
                                getApplicationContext(), android.R.color.system_accent1_600));
                binding.hello.setChecked(false);
                break;
            case Configuration.UI_MODE_NIGHT_YES:
                binding.dark.setTextColor(
                        ContextCompat.getColor(
                                getApplicationContext(), android.R.color.system_accent1_600));
                binding.hello.setChecked(true);
            
                break;
        }
    }
}