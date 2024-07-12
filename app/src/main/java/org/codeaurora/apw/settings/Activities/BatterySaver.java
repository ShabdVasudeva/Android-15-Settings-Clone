package org.codeaurora.apw.settings.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.codeaurora.apw.settings.databinding.BatterySaverBinding;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.fragments.FragmentSaver;

public class BatterySaver extends AppCompatActivity {
    private BatterySaverBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BatterySaverBinding.inflate(getLayoutInflater());
        setSupportActionBar(binding.toolbar);
        binding.toolbar.setNavigationOnClickListener(v ->{
            onBackPressed();
        });
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction().replace(R.id.settings_container,new FragmentSaver()).commit();
    }
}