package c15190682.a2019.itl.edu.itlscanner;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    private Button btnSalir;
    private Button btnAcercade;
    private Button btnScanner;
    private EditText edControl;
    private Button btnAceptar;
    private final int ACCESS_FINE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAcercade = (Button) findViewById( R.id.btnAcercaDe );
        btnSalir = (Button) findViewById( R.id.btnSalir);
        btnScanner = (Button) findViewById(R.id.btnScanear);
        btnAceptar = (Button) findViewById(R.id.btnOk);
        edControl = (EditText) findViewById(R.id.edtxtControl);

        btnScanner.setOnClickListener(this);
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, ACCESS_FINE);

        btnAcercade.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this
                        , AcercadeActivity.class);
                startActivity( intent);
            }
        });

        btnSalir.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }
        });
        btnAceptar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String ctrl = ((EditText)findViewById(R.id.edtxtControl)).getText().toString();
                String url = "http://apps.itlalaguna.edu.mx/servicios/escolares/estatus_alumno/estatuscbb.asp?ctr="+ctrl;
                Uri uri = Uri.parse(url);
                Intent intento = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intento);
                ((EditText)findViewById(R.id.edtxtControl)).setText("");
                ctrl ="";
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnScanear:
                if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                }else{
                    Intent i = new Intent( this, AbrirScan.class);
                    startActivity(i);
                }

                break;
        }
    }
}
