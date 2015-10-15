package in.raveesh.permissionsdemo;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import in.raveesh.permissions.Permissions;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView permission = (TextView)findViewById(R.id.permission);
        Button request = (Button)findViewById(R.id.requestPermission);
        if (Permissions.havePermission(this, Manifest.permission.READ_CONTACTS)){
            permission.setText("Have permission");
        }
        else{
            permission.setText("Don't have permission");
            request.setVisibility(View.VISIBLE);
        }
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Permissions.requestPermission(MainActivity.this, Manifest.permission.READ_CONTACTS, 1);
            }
        });
        Log.d("MainActivity", "Code:"+BuildConfig.VERSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult (int requestCode, String[] permissions, int[] grantResults){
        Log.d("MainActivity", "Permissions:" + permissions.toString());
    }
}
