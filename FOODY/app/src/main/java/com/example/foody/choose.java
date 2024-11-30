package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class choose extends AppCompatActivity {

    Button coustmer;
    Button seller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        coustmer=findViewById(R.id.coustmer);
        seller=findViewById(R.id.seller);

        coustmer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose.this, mapcoustmer.class));
                finish();
            }
        });
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(choose.this, map.class));
                finish();
            }
        });
    }
}