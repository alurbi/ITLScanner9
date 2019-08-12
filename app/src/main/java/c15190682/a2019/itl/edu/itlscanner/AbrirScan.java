package c15190682.a2019.itl.edu.itlscanner;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class AbrirScan extends AppCompatActivity implements ZBarScannerView.ResultHandler  {

    private ZBarScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);    // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result result) {
        String cad = result.getContents();
        String subtext = cad.substring(83);
        String url = "http://apps.itlalaguna.edu.mx/servicios/escolares/estatus_alumno/estatuscbb.asp?ctr="+subtext;
        Uri uri = Uri.parse(url);
        /*AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resultado de escaner");
        builder.setMessage("Resultado "+ uri);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();*/
        Intent intento = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intento);
        //escaner.resumeCameraPreview(this);
    }
}
