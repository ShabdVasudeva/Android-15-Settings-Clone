package org.codeaurora.apw.settings.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.codeaurora.apw.settings.databinding.ActivityApplicationsBinding;
import org.codeaurora.apw.settings.fragments.FragmentApplications;
import org.codeaurora.apw.settings.R;

public class ApplicationsActivity extends AppCompatActivity {
    private ActivityApplicationsBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityApplicationsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v ->{
            onBackPressed();
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,new FragmentApplications()).commit();
    }
}