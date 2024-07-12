package org.codeaurora.apw.settings.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import org.codeaurora.apw.settings.Activities.ApplicationsActivity;
import org.codeaurora.apw.settings.Activities.BatteryActivity;
import org.codeaurora.apw.settings.Activities.EvolverActivity;
import org.codeaurora.apw.settings.Activities.MainActivity;
import org.codeaurora.apw.settings.Activities.SystemActivity;
import org.codeaurora.apw.settings.Activities.WallpaperActivity;
import org.codeaurora.apw.settings.databinding.ActivityMainBinding;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.models.ModelMain;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ModelMain util;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        intents();
        binding.searchbar.setOnClickListener(
                v -> {
                    startActivity(new Intent(Settings.ACTION_APP_SEARCH_SETTINGS));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                });
        util = new ViewModelProvider(this).get(ModelMain.class);
        setValue(
                binding.text1,
                binding.subtext1,
                binding.icon1,
                util.title[0],
                util.subtitle[0],
                util.imgid[0]);
        setValue(
                binding.text2,
                binding.subtext2,
                binding.icon2,
                util.title[1],
                util.subtitle[1],
                util.imgid[1]);
        setValue(
                binding.text3,
                binding.subtext3,
                binding.icon3,
                util.title[2],
                util.subtitle[2],
                util.imgid[2]);
        setValue(
                binding.text4,
                binding.subtext4,
                binding.icon4,
                util.title[3],
                util.subtitle[3],
                util.imgid[3]);
        setValue(
                binding.text5,
                binding.subtext5,
                binding.icon5,
                util.title[4],
                util.subtitle[4],
                util.imgid[4]);
        setValue(
                binding.text6,
                binding.subtext6,
                binding.icon6,
                util.title[5],
                util.subtitle[5],
                util.imgid[5]);
        setValue(
                binding.text7,
                binding.subtext7,
                binding.icon7,
                util.title[6],
                util.subtitle[6],
                util.imgid[6]);
        setValue(
                binding.text8,
                binding.subtext8,
                binding.icon8,
                util.title[7],
                util.subtitle[7],
                util.imgid[7]);
        setValue(
                binding.text9,
                binding.subtext9,
                binding.icon9,
                util.title[8],
                util.subtitle[8],
                util.imgid[8]);
        setValue(
                binding.text10,
                binding.subtext10,
                binding.icon10,
                util.title[9],
                util.subtitle[9],
                util.imgid[9]);
        setValue(
                binding.text11,
                binding.subtext11,
                binding.icon11,
                util.title[10],
                util.subtitle[10],
                util.imgid[10]);
        setValue(
                binding.text12,
                binding.subtext12,
                binding.icon12,
                util.title[11],
                util.subtitle[11],
                util.imgid[11]);
        setValue(
                binding.text13,
                binding.subtext13,
                binding.icon13,
                util.title[12],
                util.subtitle[12],
                util.imgid[12]);
        setValue(
                binding.text14,
                binding.subtext14,
                binding.icon14,
                util.title[13],
                util.subtitle[13],
                util.imgid[13]);
        setValue(
                binding.text15,
                binding.subtext15,
                binding.icon15,
                util.title[14],
                util.subtitle[14],
                util.imgid[14]);
        setValue(
                binding.text16,
                binding.subtext16,
                binding.icon16,
                util.title[15],
                util.subtitle[15],
                util.imgid[15]);
        setValue(
                binding.text17,
                binding.subtext17,
                binding.icon17,
                util.title[16],
                util.subtitle[16],
                util.imgid[16]);
        setValue(
                binding.text19,
                binding.subtext19,
                binding.icon19,
                util.title[17],
                util.subtitle[17],
                util.imgid[17]);
        setValue(
                binding.text20,
                binding.subtext20,
                binding.icon20,
                util.title[18],
                util.subtitle[18] =
                        Build.MANUFACTURER + " " + Build.MODEL.toLowerCase(),
                util.imgid[18]);
        setValue(
                binding.text21,
                binding.subtext21,
                binding.icon21,
                util.title[19],
                util.subtitle[19],
                util.imgid[19]);
    }

    public void clicked(Intent in, LinearLayout layout) {
        layout.setOnClickListener(
                v -> {
                    try {
                        startActivity(in);
                    } catch (Exception e) {
                        Toast.makeText(
                                        getApplicationContext(),
                                        "an error occured",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });
    }

    public void intents() {
        clicked(new Intent(Settings.ACTION_WIRELESS_SETTINGS), binding.list);
        clicked(new Intent(Settings.ACTION_BLUETOOTH_SETTINGS), binding.list1);
        binding.list2.setOnClickListener(
                v -> {
                    Intent ig = new Intent(this, ApplicationsActivity.class);
                    startActivity(ig);
                });
        binding.list3.setOnClickListener(
                v -> {
                    startActivity(new Intent(this, EvolverActivity.class));
                });
        clicked(new Intent(Settings.ACTION_ALL_APPS_NOTIFICATION_SETTINGS), binding.list4);
        binding.list5.setOnClickListener(
                v -> {
                    startActivity(new Intent(this, BatteryActivity.class));
                });
        clicked(new Intent(Settings.ACTION_INTERNAL_STORAGE_SETTINGS), binding.list6);
        clicked(new Intent(Settings.ACTION_SOUND_SETTINGS), binding.list7);
        clicked(new Intent(Settings.ACTION_DISPLAY_SETTINGS), binding.list8);
        binding.list9.setOnClickListener(
                v -> {
                    try {
                        startActivity(new Intent(this, WallpaperActivity.class));
                    } catch (Exception io) {
                        Toast.makeText(
                                        getApplicationContext(),
                                        "an error occured",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        clicked(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS), binding.list10);
        clicked(new Intent(Settings.ACTION_SECURITY_SETTINGS), binding.list11);
        clicked(new Intent(Settings.ACTION_PRIVACY_SETTINGS), binding.list12);
        clicked(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS), binding.list13);
        clicked(new Intent(Settings.ACTION_PRINT_SETTINGS), binding.list14);
        clicked(new Intent(Settings.ACTION_SYNC_SETTINGS), binding.list15);
        binding.list16.setOnClickListener(
                v -> {
                    Intent wellb = new Intent();
                    wellb.setClassName(
                            "com.google.android.apps.wellbeing",
                            "com.google.android.apps.wellbeing.settings.TopLevelSettingsActivity");
                    try {
                        startActivity(wellb);
                    } catch (Exception e) {
                        Toast.makeText(
                                        getApplicationContext(),
                                        "sorry your device not support this setting don't worry our team is working for you",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        binding.list18.setOnClickListener(
                v -> {
                    startActivity(new Intent(this, SystemActivity.class));
                });
        binding.list19.setOnClickListener(
                v -> {
                    try {
                        startActivity(new Intent(this, AboutActivity.class));
                    } catch (Exception io) {
                        Toast.makeText(
                                        getApplicationContext(),
                                        "an error occured",
                                        Toast.LENGTH_SHORT)
                                .show();
                    }
                });
        binding.list20.setOnClickListener(
                v -> {
                    MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(this);
                    builder.setTitle("About us")
                            .setMessage(
                                    "this applications is brought to you by the whole team of @AndroidPortWorld telegram channel and we are working evryday to make your device legendary we shall very happy if you join our channel thankiew ❤️")
                            .setNegativeButton("Back", null)
                            .setPositiveButton(
                                    "Visit our channel",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            startActivity(
                                                    new Intent(
                                                            Intent.ACTION_VIEW,
                                                            Uri.parse(
                                                                    "https://t.me/AndroidPortWorld")));
                                        }
                                    })
                            .show();
                });
    }

    public void setValue(
            TextView title,
            TextView subtitle,
            ImageView icon,
            String str1,
            String str2,
            int imgid) {
        title.setText(str1);
        subtitle.setText(str2);
        icon.setImageResource(imgid);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.binding = null;
    }
}