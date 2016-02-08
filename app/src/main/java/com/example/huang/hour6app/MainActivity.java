package com.example.huang.hour6app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText e = (EditText) findViewById(R.id.editText);
        final EditText e2 = (EditText) findViewById(R.id.editText2);
        final TextView t = (TextView) findViewById(R.id.textView);
        Button b = (Button) findViewById(R.id.button);

        e.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (e.getText().length() >=0 )
                    t.setText(e.getText().toString() + e2.getText().toString());
            }
        });

        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText(e.getText().toString() + e2.getText().toString());
            }
        });
    }
}
