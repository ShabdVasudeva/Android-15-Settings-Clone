package org.codeaurora.apw.settings.ui;
import android.app.Application;
import com.google.android.material.color.DynamicColors;

public class AppTheme extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DynamicColors.applyToActivitiesIfAvailable(this);
    }
}