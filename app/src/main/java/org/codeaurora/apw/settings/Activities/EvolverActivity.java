package org.codeaurora.apw.settings.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import org.codeaurora.apw.settings.Activities.BatterySaver;
import org.codeaurora.apw.settings.R;
import org.codeaurora.apw.settings.databinding.ActivityEvolverBinding;
public class EvolverActivity extends AppCompatActivity {
    private ActivityEvolverBinding ext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ext = ActivityEvolverBinding.inflate(getLayoutInflater());
        setContentView(ext.getRoot());
        setSupportActionBar(ext.toolbar);
        ext.toolbar.setNavigationOnClickListener(v ->{
            onBackPressed();
        });
        TextsSub(ext.text1,ext.subtext1,ext.icon1,"Root checker","check your device is rooted or not",R.drawable.root);
        TextsSub(ext.text2,ext.subtext2,ext.icon2,"Developer options","access your device developer options",R.drawable.developer);
        TextsSub(ext.text3,ext.subtext3,ext.icon3,"Mobile Manager","manage your device performance with ported asus device manager by our team",R.drawable.manager);
        TextsSub(ext.text4,ext.subtext4,ext.icon4,"Power saver","kill background running apps instantly",R.drawable.power);
        TextsSub(ext.text5,ext.subtext5,ext.icon5,"System UI tuner","tune your device system ui style",R.drawable.tuner);
        TextsSub(ext.text6,ext.subtext6,ext.icon6,"Wallpaper plus","change your device wallpaper automatically based on battery behavior",R.drawable.styles);
        ig(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS),ext.developer);
        ext.tuner.setOnClickListener(v ->{
            Intent tune = new Intent();
                tune.setClassName("com.android.systemui",
                    "com.android.systemui.DemoMode");
                try{
                    startActivity(tune);
                }catch(Exception ii){
                    Toast.makeText(getApplicationContext(),"an error occured",Toast.LENGTH_SHORT).show();
                }
        });
        ext.activity.setOnClickListener(v ->{
            try {
            	startActivity(new Intent(this,WallpaperPlus.class));
            } catch(Exception err) {
            	Toast.makeText(getApplicationContext(),"an error occured",Toast.LENGTH_SHORT).show();
            }
        });
        ext.root.setOnClickListener(v ->{
            startActivity(new Intent(this,RootChecker.class));
        });
        ext.manager.setOnClickListener(v ->{
            Intent tune = new Intent();
                tune.setClassName("com.asus.mobilemanager",
                    "com.asus.mobilemanager.entry.FeatureWithBackKeyActivity");
                try{
                    startActivity(tune);
                }catch(Exception ii){
                    Toast.makeText(getApplicationContext(),"please install our asus mobile manager port first from the @AndroidPortWorld channel at telegram",Toast.LENGTH_SHORT).show();
                }
        });
        ext.power.setOnClickListener(v ->{
                try{
                    startActivity(new Intent(this,BatterySaver.class));
                }catch(Exception ii){
                    Toast.makeText(getApplicationContext(),"please install our asus mobile manager port first from the @AndroidPortWorld channel at telegram",Toast.LENGTH_SHORT).show();
                }
        });
    }
    public void TextsSub(TextView one,TextView two,ImageView on,String str1,String str2,int image){
        one.setText(str1);
        two.setText(str2);
        on.setImageResource(image);
    }
    public void ig(Intent in,LinearLayout ll){
        ll.setOnClickListener(v ->{
            try{
                startActivity(in);
            }catch(Exception io){
                Toast.makeText(getApplicationContext(),"an error occured",Toast.LENGTH_SHORT).show();
            }
        });
    }
}