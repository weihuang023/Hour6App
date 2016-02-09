package com.example.huang.hour6app;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Context;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e = (EditText) findViewById(R.id.editText);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        final TextView t = (TextView) findViewById(R.id.textView);
        Button b = (Button) findViewById(R.id.button);
        Button b2 = (Button) findViewById(R.id.button2);

        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (e.getText().length() >= 0)
                    t.setText(e.getText().toString());
            }
        });

        e2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (e2.getText().length() >= 0)
                    t.setText(e.getText().toString() + e2.getText().toString());
            }
        });

        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText(e.getText().toString() + e2.getText().toString());
            }
        });

        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                e.getText().clear();
                e2.getText().clear();
                t.setText(null);
            }
        });
    }

    public void onRadioButtonClicked(View view){
            // import android.widget.RadioButton;
        RadioButton rb = (RadioButton) view;
        boolean checked = rb.isChecked();

        if(checked){
                // import android.content.context;
                // import android.widget.Toast;
                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                String output = rb.getText().toString();
                Toast toast = Toast.makeText(context,output,duration);
                toast.show();
            }

    }

    public void onCheckboxClicked(View view){
        // import android.content.Context
        Context context = getApplicationContext();
        // import android.widget.Toast
        int duration = Toast.LENGTH_SHORT;
        // import android.widget.checkbox
        CheckBox chkMeat = (CheckBox) findViewById(R.id.checkbox_meat);
        CheckBox chkCheese = (CheckBox) findViewById(R.id.checkbox_cheese);
        CheckBox chkVegetable = (CheckBox) findViewById(R.id.checkbox_vegetable);
        CheckBox chkFruit = (CheckBox) findViewById(R.id.checkbox_fruit);

        StringBuilder sb = new StringBuilder();
        if (chkMeat.isChecked()){
            sb.append(","+chkMeat.getText());
        }

        if (chkCheese.isChecked()){
            sb.append(","+chkCheese.getText());
        }

        if (chkVegetable.isChecked()){
            sb.append(","+chkVegetable.getText());
        }

        if (chkFruit.isChecked()){
            sb.append(","+chkFruit.getText());
        }

        if (sb.length() >0 ){
            // No toast if the string is empty
            // Remove the first comma
            String output = sb.deleteCharAt(sb.indexOf(",")).toString();
            // A small pop up box that contains a message for a limited amount of time
            Toast toast = Toast.makeText(context,output,duration);
            toast.show();
        }
    }

    public void onToggleClicked(View view){
        // import android.widget.ToggleButton
        boolean on =((ToggleButton) view).isChecked();
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);

        if (on && !wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(true);
        } else if (!on && wifiManager.isWifiEnabled()){
            wifiManager.setWifiEnabled(false);
        }
    }
}

