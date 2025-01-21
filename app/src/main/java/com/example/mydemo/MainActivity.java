
package com.example.mydemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.widget.TextView;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private void showMessage(String msg) {
        Toast.makeText(this,"[" + TAG + "]: " + msg, Toast.LENGTH_SHORT).show();
    }

    private void postOnCreated() {
        // 1. bind id to java object
        TextView textView = findViewById(R.id.textView);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Hello world");
                String msg = "";
                for ( int i = 0 ; i < 30 ; i++) {
                    msg += "Hello world, on text box\n";
                }
                textView.setText(msg);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Auto gen boilerplate
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Actually code
        postOnCreated();
    }
}
