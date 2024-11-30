package com.example.foody;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class password extends AppCompatActivity {

    private Button enter;

    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        enter = findViewById(R.id.Enterbutton);
        password=findViewById(R.id.password);




        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                db.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String pass1 = dataSnapshot.child("arabiata").child("password").getValue().toString();
                        String pass2 = dataSnapshot.child("pronto").child("password").getValue().toString();
                        String pass3 = dataSnapshot.child("tbs").child("password").getValue().toString();
                        String pass4 = dataSnapshot.child("amsaad").child("password").getValue().toString();
                        String pass5 = dataSnapshot.child("lamora").child("password").getValue().toString();
                        String pass6 = dataSnapshot.child("friends").child("password").getValue().toString();
                        String z=password.getText().toString();
                        if(z.equals(pass1)){
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,arabiata.class);
                            startActivity(intent);

                        } else if (z.equals(pass2)) {
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,pronto.class);
                            startActivity(intent);
                        }else if (z.equals(pass3)) {
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,tbs.class);
                            startActivity(intent);
                        }else if (z.equals(pass4)) {
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,amsaad.class);
                            startActivity(intent);
                        }else if (z.equals(pass5)) {
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,laroma.class);
                            startActivity(intent);
                        }else if (z.equals(pass6)) {
                            Toast.makeText(password.this,"correct password",Toast.LENGTH_SHORT).show();
                            Intent intent =new Intent(password.this,friends.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(password.this, "WRONG PASSWORD", Toast.LENGTH_SHORT).show();
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }

        });

    }
}