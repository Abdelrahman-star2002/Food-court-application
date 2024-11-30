package com.example.foody;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class laromacoustmer extends AppCompatActivity {

    private Button min1;
    private Button plus1;
    private TextView order1;
    private Button min2;
    private Button plus2;
    private TextView order2;
    private Button min3;
    private Button plus3;
    private TextView order3;
    private Button min4;
    private Button plus4;
    private TextView order4;
    private Button min5;
    private Button plus5;
    private TextView order5;
    private Button min6;
    private Button plus6;
    private TextView order6;
    private Button min7;
    private Button plus7;
    private TextView order7;
    private Button min8;
    private Button plus8;
    private TextView order8;


    private Button checkout;
    TextView price1;
    TextView price2;
    TextView price3;
    TextView price4;
    TextView price5;
    TextView price6;
    TextView price7;
    TextView price8;

    TextView deliverystatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laromacoustmer);





        min1=findViewById(R.id.minus1);
        min2=findViewById(R.id.minus2);
        min3=findViewById(R.id.minus3);
        min4=findViewById(R.id.minus4);
        min5=findViewById(R.id.minus5);
        min6=findViewById(R.id.minus6);
        min7=findViewById(R.id.minus7);
        min8=findViewById(R.id.minus8);
        plus1=findViewById(R.id.plus1);
        plus2=findViewById(R.id.plus2);
        plus3=findViewById(R.id.plus3);
        plus4=findViewById(R.id.plus4);
        plus5=findViewById(R.id.plus5);
        plus6=findViewById(R.id.plus6);
        plus7=findViewById(R.id.plus7);
        plus8=findViewById(R.id.plus8);

        order1=findViewById(R.id.ordernumber1);
        order2=findViewById(R.id.ordernumber2);
        order3=findViewById(R.id.ordernumber3);
        order4=findViewById(R.id.ordernumber4);
        order5=findViewById(R.id.ordernumber5);
        order6=findViewById(R.id.ordernumber6);
        order7=findViewById(R.id.ordernumber7);
        order8=findViewById(R.id.ordernumber8);


        price1=findViewById(R.id.price1);
        price2=findViewById(R.id.price2);
        price3=findViewById(R.id.price3);
        price4=findViewById(R.id.price4);
        price5=findViewById(R.id.price5);
        price6=findViewById(R.id.price6);
        price7=findViewById(R.id.price7);
        price8=findViewById(R.id.price8);

        checkout=findViewById(R.id.checkout);
        deliverystatus=findViewById(R.id.deliverystatus);





        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");

        String delivery = "lamora";
        db.child(delivery).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String aa = snapshot.child("delivery").getValue().toString();
                deliverystatus.setText(aa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee1 = "lamora/items/americanespresso/price";
        db.child(pricee1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price1.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee2 = "lamora/items/capuccino/price";
        db.child(pricee2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price2.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee3 = "lamora/items/hotchocklate/price";
        db.child(pricee3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price3.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee4 = "lamora/items/latte/price";
        db.child(pricee4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price4.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee5 = "lamora/items/icecoffee/price";
        db.child(pricee5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price5.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee6 = "lamora/items/lemon/price";
        db.child(pricee6).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price6.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee7 = "lamora/items/water/price";
        db.child(pricee7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price7.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String pricee8 = "lamora/items/corassont/price";
        db.child(pricee8).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                price8.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/americanespresso/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order1.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order1.setText(xx);
                            plus1.setEnabled(false);
                            min1.setEnabled(true);
                        }else{
                            String z=order1.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order1.setText(xx);
                            min1.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/americanespresso/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order1.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order1.setText(xx);
                            plus1.setEnabled(true);
                            min1.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order1.setText(xx);
                            plus1.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/capuccino/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order2.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order2.setText(xx);
                            plus2.setEnabled(false);
                            min2.setEnabled(true);
                        }else{
                            String z=order2.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order2.setText(xx);
                            min2.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/capuccino/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        String z=order2.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order2.setText(xx);
                            plus2.setEnabled(true);
                            min2.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order2.setText(xx);
                            plus2.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });

        plus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/hotchocklate/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order3.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order3.setText(xx);
                            plus3.setEnabled(false);
                            min3.setEnabled(true);
                        }else{
                            String z=order3.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order3.setText(xx);
                            min3.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/hotchocklate/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order3.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order3.setText(xx);
                            plus3.setEnabled(true);
                            min3.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order3.setText(xx);
                            plus3.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });

        plus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/hotchocklate/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order4.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order4.setText(xx);
                            plus4.setEnabled(false);
                            min4.setEnabled(true);
                        }else{
                            String z=order4.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order4.setText(xx);
                            min4.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/americanespresso/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order4.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order4.setText(xx);
                            plus4.setEnabled(true);
                            min4.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order4.setText(xx);
                            plus4.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });

        plus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/icecoffee/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order5.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order5.setText(xx);
                            plus5.setEnabled(false);
                            min5.setEnabled(true);
                        }else{
                            String z=order5.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order5.setText(xx);
                            min5.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/icecoffee/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order5.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order5.setText(xx);
                            plus5.setEnabled(true);
                            min5.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order5.setText(xx);
                            plus5.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        plus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/lemon/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order6.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order6.setText(xx);
                            plus6.setEnabled(false);
                            min6.setEnabled(true);
                        }else{
                            String z=order6.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order6.setText(xx);
                            min6.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/lemon/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order6.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order6.setText(xx);
                            plus6.setEnabled(true);
                            min6.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order6.setText(xx);
                            plus6.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        plus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/water/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order7.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order7.setText(xx);
                            plus7.setEnabled(false);
                            min7.setEnabled(true);
                        }else{
                            String z=order7.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order7.setText(xx);
                            min7.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/water/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);

                        String z=order7.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order7.setText(xx);
                            plus7.setEnabled(true);
                            min7.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order7.setText(xx);
                            plus7.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        plus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/corassont/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        if (x==1){
                            String z=order8.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order8.setText(xx);
                            plus8.setEnabled(false);
                            min8.setEnabled(true);
                        }else{
                            String z=order8.getText().toString();
                            int zz=Integer.parseInt(z);
                            zz++;
                            x--;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order8.setText(xx);
                            min8.setEnabled(true);
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });
        min8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "lamora/items/corassont/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        String z=order8.getText().toString();
                        int zz=Integer.parseInt(z);
                        zz--;
                        if (zz==0){
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order8.setText(xx);
                            plus8.setEnabled(true);
                            min8.setEnabled(false);
                        }else{
                            x++;
                            db.child(path).setValue(x);
                            String xx=Integer.toString(zz);
                            order8.setText(xx);
                            plus8.setEnabled(true);

                        }



                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });



        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(laromacoustmer.this,"",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(laromacoustmer.this,checkout.class);
                startActivity(intent);
            }
        });



    }
}