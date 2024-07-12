package org.codeaurora.apw.settings.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.databinding.ActivityPermissionBinding;
import org.codeaurora.apw.settings.fragments.FragmentPermission;

public class PermissionActivity extends AppCompatActivity {
    private ActivityPermissionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPermissionBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v ->{
            onBackPressed();
        });
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,new FragmentPermission()).commit();
    }
}
