package org.codeaurora.apw.settings.fragments;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.widget.Toast;
import androidx.preference.PreferenceCategory;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.utils.AboutUtils;

public class FragmentAbout extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle arg0, String arg1) {
        setPreferencesFromResource(R.xml.about_pref, arg1);
        PreferenceCategory cat1 = findPreference("basic_info");
        PreferenceCategory cat2 = findPreference("versions");
        PreferenceCategory cat3 = findPreference("device_info");
        PreferenceCategory cat4 = findPreference("extra");
        cat1.setIconSpaceReserved(false);
        cat2.setIconSpaceReserved(false);
        cat3.setIconSpaceReserved(false);
        cat4.setIconSpaceReserved(false);
        Preference pref1 = findPreference("Device_name");
        Preference pref2 = findPreference("Android_version");
        Preference pref3 = findPreference("Security_patch");
        Preference pref4 = findPreference("Baseband_version");
        Preference pref5 = findPreference("Kernel_version");
        Preference pref6 = findPreference("screen_size");
        Preference pref7 = findPreference("Processor");
        Preference pref8 = findPreference("more_settings");
        Preference pref9 = findPreference("Os_version");
        pref1.setIconSpaceReserved(false);
        pref2.setIconSpaceReserved(false);
        pref3.setIconSpaceReserved(false);
        pref4.setIconSpaceReserved(false);
        pref5.setIconSpaceReserved(false);
        pref6.setIconSpaceReserved(false);
        pref7.setIconSpaceReserved(false);
        pref8.setIconSpaceReserved(false);
        pref9.setIconSpaceReserved(false);
        pref1.setSummary(AboutUtils.getModelName());
        pref2.setSummary(AboutUtils.getAndroidVersion());
        pref3.setSummary(AboutUtils.getSecurityPatchLevel());
        pref4.setSummary(AboutUtils.getBasebandVersion());
        pref5.setSummary(AboutUtils.getKernelVersion());
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
        pref6.setSummary(width + "x" + height);
        pref7.setSummary(AboutUtils.getHardwareVersion());
        pref8.setSummary("more device info settings");
        pref8.setOnPreferenceClickListener(
                new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference arg0) {
                        try {
                            startActivity(new Intent(Settings.ACTION_DEVICE_INFO_SETTINGS));
                        } catch (Exception err) {
                            Toast.makeText(
                                            getActivity().getApplicationContext(),
                                            "an error occured",
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                        return true;
                    }
                });
        pref2.setOnPreferenceClickListener(
                new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference arg0) {
                        try {
                            Intent intent = new Intent();
                            intent.setComponent(
                                    new ComponentName(
                                            "com.android.egg",
                                            "com.android.egg.paint.PaintActivity"));
                            startActivity(intent);
                        } catch (Exception err) {
                            Toast.makeText(
                                            getActivity().getApplicationContext(),
                                            "an error occured",
                                            Toast.LENGTH_SHORT)
                                    .show();
                        }
                        return true;
                    }
                });
    }
}
