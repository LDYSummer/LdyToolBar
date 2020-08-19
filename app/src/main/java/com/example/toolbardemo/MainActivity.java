package com.example.toolbardemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LdyToolBar toolBar = findViewById(R.id.main_toolbar);
        toolBar.setBackClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"back click",Toast.LENGTH_SHORT).show();
            }
        });
        toolBar.setMenuLeftClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"add",Toast.LENGTH_SHORT).show();
            }
        });
        toolBar.setMenuRightClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"download",Toast.LENGTH_SHORT).show();
            }
        });
    }
}