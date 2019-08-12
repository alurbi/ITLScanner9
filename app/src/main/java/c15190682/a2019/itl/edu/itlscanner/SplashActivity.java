package c15190682.a2019.itl.edu.itlscanner;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ImageView imageView;
    private TextView itl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //imageView = (ImageView) findViewById(R.id.splash);
        //itl = (TextView) findViewById(R.id.itl);
       //progressBar = (ProgressBar) findViewById(R.id.progressBar);
        //progressBar.setVisibility(progressBar.VISIBLE);

        new Handler().postDelayed(new Runnable() {

            public void run() {
                Intent i = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 4000);

    }
}
