package com.example.foody;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class checkout extends AppCompatActivity {

    Button placeorder;
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        placeorder=findViewById(R.id.placeorder);

        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup
                        .OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group,
                                                 int checkedId)
                    {
                        RadioButton
                                radioButton
                                = (RadioButton)group
                                .findViewById(checkedId);
                    }
                });

        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(checkout.this,"",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(checkout.this,donecustomer.class);
                startActivity(intent);
            }
        });
    }
}