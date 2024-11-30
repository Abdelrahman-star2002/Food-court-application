package com.example.foody;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class mapcoustmer extends AppCompatActivity {

    CardView arabiatacard;
    CardView amsaadcard;
    CardView Tbscard;
    CardView prontocard;
    CardView Freiendscard;
    CardView laromacard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapcoustmer);
        arabiatacard=findViewById(R.id.arabiatacard);
        amsaadcard=findViewById(R.id.amsaadcard);
        Tbscard=findViewById(R.id.tbscard);
        prontocard=findViewById(R.id.prontocard);
        Freiendscard=findViewById(R.id.friendscard);
        laromacard=findViewById(R.id.laromacard);

        arabiatacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, arabiatacoustmer.class);
                startActivity(intent);
                finish();
            }
        });


        amsaadcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, amsaadcoustmer.class);
                startActivity(intent);
                finish();
            }
        });

        Tbscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, tbscoustmer.class);
                startActivity(intent);
                finish();
            }
        });

        prontocard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, prontocoustmer.class);
                startActivity(intent);
                finish();
            }
        });

        Freiendscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, friendscoustmer.class);
                startActivity(intent);
                finish();
            }
        });

        laromacard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mapcoustmer.this, laromacoustmer.class);
                startActivity(intent);
                finish();
            }
        });
    }
}