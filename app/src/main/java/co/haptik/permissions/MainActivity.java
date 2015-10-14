package co.haptik.permissions;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import co.haptik.permissions.lib.Permissions;

public class MainActivity extends AppCompatActivity {

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
    }
}
