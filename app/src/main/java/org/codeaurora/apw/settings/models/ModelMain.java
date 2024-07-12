package org.codeaurora.apw.settings.models;

import androidx.lifecycle.ViewModel;
import org.codeaurora.apw.settings.R;

public class ModelMain extends ViewModel {
    public String[] title = {
        "Network & internet",
        "Connected devices",
        "Apps",
        "Evolver",
        "Notifications",
        "Battery",
        "Storage",
        "Sound & vibrations",
        "Display",
        "Wallpaper & styles",
        "Accessibility",
        "Security",
        "Privacy",
        "Location",
        "Printing service",
        "Accounts",
        "Digital Wellbeing & parental controls",
        "System",
        "About phone",
        "Tips & support"
    };
    public String[] subtitle = {
        "Mobile, Wi-Fi, hotspot",
        "Bluetooth, pairing",
        "Manage, default apps",
        "Evolve your device",
        "Notification history, conversations",
        "Get your battery performace stats",
        "Storage stats, usage",
        "Volume, haptics, Do Not Disturb",
        "Dark theme, font, brightness",
        "Colors, wallpapers, solids",
        "Display, interaction, audio",
        "Screen lock, Find My Device, app security",
        "Permission, account activity, personal data",
        "Location, apps using gps",
        "Default printer service",
        "Synced accounts",
        "Screen time, app timers, bedtime schedules",
        "Languages, time, backup",
        "About your phone",
        "Help articles & about us"
    };
    public int[] imgid = {
        R.drawable.wifi_icon,
        R.drawable.bluetooth_pair,
        R.drawable.apps,
        R.drawable.extensions,
        R.drawable.notifications,
        R.drawable.battery_icon,
        R.drawable.storage,
        R.drawable.sound,
        R.drawable.display,
        R.drawable.styles,
        R.drawable.accessibility,
        R.drawable.security,
        R.drawable.privacy,
        R.drawable.location,
        R.drawable.print,
        R.drawable.account,
        R.drawable.digital,
        R.drawable.system,
        R.drawable.about,
        R.drawable.tips
    };
}