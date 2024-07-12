package org.codeaurora.apw.settings.Activities;

import android.app.WallpaperManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.databinding.WallpaperPlusBinding;
import org.codeaurora.apw.settings.fragments.FragmentWallpaper;
import org.codeaurora.apw.settings.utils.BatteryReciever;

public class WallpaperPlus extends AppCompatActivity {
    private WallpaperPlusBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = WallpaperPlusBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(
                v -> {
                    onBackPressed();
                });
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new FragmentWallpaper())
                .commit();
        BatteryReciever util = new BatteryReciever();
        registerReceiver(util, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent status = registerReceiver(null, ifilter);
        Intent level = registerReceiver(null, ifilter);
        Intent scale = registerReceiver(null, ifilter);
        int batteryLevel = level != null ? level.getIntExtra(BatteryManager.EXTRA_LEVEL, -1) : -1;
        int batteryScale = scale != null ? scale.getIntExtra(BatteryManager.EXTRA_SCALE, -1) : -1;
        int batteryStatus =
                status != null ? status.getIntExtra(BatteryManager.EXTRA_STATUS, -1) : -1;
        int batteryPct = batteryLevel * 100 / (int) batteryScale;
        boolean isCharging =
                batteryStatus == BatteryManager.BATTERY_STATUS_CHARGING
                        || batteryStatus == BatteryManager.BATTERY_STATUS_FULL;
        binding.low.setBackgroundDrawable(getResources().getDrawable(R.drawable.low_battery));
        binding.normal.setBackgroundDrawable(getResources().getDrawable(R.drawable.normal_battery));
        binding.charging.setBackgroundDrawable(
                getResources().getDrawable(R.drawable.charging_battery));
        Boolean switchState =
                PreferenceManager.getDefaultSharedPreferences(this)
                        .getBoolean("switch_state", false);
        if (switchState == true) {
            binding.layout.setEnabled(true);
            if (isCharging) {
                setWallpaper(getResources().getDrawable(R.drawable.charging_battery));
            } else if (batteryPct <= 30 && isCharging == false) {
                setWallpaper(getResources().getDrawable(R.drawable.low_battery));
            } else {
                setWallpaper(getResources().getDrawable(R.drawable.normal_battery));
            }
        }
    }

    public void setWallpaper(Drawable img) {
        try {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(this);
            Drawable drawable = img;
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            wallpaperManager.setBitmap(bitmap);
        } catch (Exception err) {
            Toast.makeText(getApplicationContext(), "an error occured", Toast.LENGTH_LONG).show();
        }
    }
}