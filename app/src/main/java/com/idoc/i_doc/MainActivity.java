package com.idoc.i_doc;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mUsername;
    private LinearLayout mBloodLayout;
    private LinearLayout mTemperatureLayout;
    private LinearLayout mPressureLayout;
    private LinearLayout mDiabetesLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = (TextView) findViewById(R.id.main_hello_username);
        mBloodLayout = (LinearLayout) findViewById(R.id.layout_blood);
        mTemperatureLayout = (LinearLayout) findViewById(R.id.layout_temperature);
        mPressureLayout = (LinearLayout) findViewById(R.id.layout_pressure);
        mDiabetesLayout = (LinearLayout) findViewById(R.id.layout_diabetes);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");
        mUsername.setText(Html.fromHtml("Hello<b> " + username + "</b>!"));

        mBloodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You selected: Blood Test - Not available yet.", Toast.LENGTH_SHORT).show();
            }
        });

        mTemperatureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BodyTemperatureActivity.class);
//                Toast.makeText(MainActivity.this, "You selected: Body Temperature", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        mPressureLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You selected: Blood Pressure - Not available yet.", Toast.LENGTH_SHORT).show();
            }
        });

        mDiabetesLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You selected: Diabetes - Not available yet.", Toast.LENGTH_SHORT).show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.connect_device:
                BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (mBluetoothAdapter == null) {
                    // Device does not support Bluetooth
                }

                if (!mBluetoothAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    startActivityForResult(enableBtIntent, 1);
                }

                return true;

            case R.id.edit_profile:
                Toast.makeText(this, "Not available yet.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.history:
                Toast.makeText(this, "Not available yet.", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.stats:
                Toast.makeText(this, "Not available yet.", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
