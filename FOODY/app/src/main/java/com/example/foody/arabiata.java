package com.example.foody;

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

public class arabiata extends AppCompatActivity {

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

    private Button deliveryyes;
    private Button deliveryno;

    private Button add;

    private TextView pricenumber1;
    private TextView pricenumber2;
    private TextView pricenumber3;
    private TextView pricenumber4;
    private TextView pricenumber5;
    private TextView pricenumber6;
    private TextView pricenumber7;
    private TextView pricenumber8;
    private Button priceminus1;
    private Button priceminus2;
    private Button priceminus3;
    private Button priceminus4;
    private Button priceminus5;
    private Button priceminus6;
    private Button priceminus7;
    private Button priceminus8;
    private Button priceplus1;
    private Button priceplus2;
    private Button priceplus3;
    private Button priceplus4;
    private Button priceplus5;
    private Button priceplus6;
    private Button priceplus7;
    private Button priceplus8;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabiata);





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

        deliveryyes=findViewById(R.id.deliveryyes);
        deliveryno=findViewById(R.id.deliveryno);
        add=findViewById(R.id.ADD);

        pricenumber1=findViewById(R.id.pricenumber1);
        pricenumber2=findViewById(R.id.pricenumber2);
        pricenumber3=findViewById(R.id.pricenumber3);
        pricenumber4=findViewById(R.id.pricenumber4);
        pricenumber5=findViewById(R.id.pricenumber5);
        pricenumber6=findViewById(R.id.pricenumber6);
        pricenumber7=findViewById(R.id.pricenumber7);
        pricenumber8=findViewById(R.id.pricenumber8);
        priceminus1=findViewById(R.id.priceminus1);
        priceminus2=findViewById(R.id.priceminus2);
        priceminus3=findViewById(R.id.priceminus3);
        priceminus4=findViewById(R.id.priceminus4);
        priceminus5=findViewById(R.id.priceminus5);
        priceminus6=findViewById(R.id.priceminus6);
        priceminus7=findViewById(R.id.priceminus7);
        priceminus8=findViewById(R.id.priceminus8);
        priceplus1=findViewById(R.id.priceplus1);
        priceplus2=findViewById(R.id.priceplus2);
        priceplus3=findViewById(R.id.priceplus3);
        priceplus4=findViewById(R.id.priceplus4);
        priceplus5=findViewById(R.id.priceplus5);
        priceplus6=findViewById(R.id.priceplus6);
        priceplus7=findViewById(R.id.priceplus7);
        priceplus8=findViewById(R.id.priceplus8);


        DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
        String path1 = "arabiata/items/folsada/price";
        db.child(path1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber1.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path2 = "arabiata/items/folbelbeed/price";
        db.child(path2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber2.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path3 = "arabiata/items/ta3meyasada/price";
        db.child(path3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber3.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path4 = "arabiata/items/ta3meyabelbeed/price";
        db.child(path4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber4.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path5 = "arabiata/items/batatesmahrosa/price";
        db.child(path5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber5.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path6 = "arabiata/items/batatesmehamara/price";
        db.child(path6).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber6.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path7 = "arabiata/items/water/price";
        db.child(path7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber7.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String path8 = "arabiata/items/cola/price";
        db.child(path8).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                pricenumber8.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });

        String quantity1 = "arabiata/items/folsada/quantity";
        db.child(quantity1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order1.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity2 = "arabiata/items/folbelbeed/quantity";
        db.child(quantity2).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order2.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity3 = "arabiata/items/ta3meyasada/quantity";
        db.child(quantity3).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order3.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity4 = "arabiata/items/folbelbeed/quantity";
        db.child(quantity4).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order4.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity5 = "arabiata/items/batatesmahrosa/quantity";
        db.child(quantity5).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order5.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity6 = "arabiata/items/batatesmehamara/quantity";
        db.child(quantity6).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order6.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity7 = "arabiata/items/water/quantity";
        db.child(quantity7).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order7.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });
        String quantity8 = "arabiata/items/cola/quantity";
        db.child(quantity8).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int x = snapshot.getValue(Integer.class);
                String xx=Integer.toString(x);
                order8.setText(xx);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle onCancelled if needed
            }
        });


        //plus price of order 1
        priceplus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folsada/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber1.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folsada/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber1.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folbelbeed/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber2.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folbelbeed/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber2.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyasada/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber3.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyasada/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber3.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyabelbeed/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber4.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyabelbeed/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber4.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmahrosa/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber5.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmahrosa/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber5.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmehamara/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber6.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmehamara/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber6.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/water/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber7.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/water/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber7.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceplus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/cola/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber8.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        priceminus8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/cola/price";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        pricenumber8.setText(xx);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });



        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folsada/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        order1.setText(xx);
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
                String path = "arabiata/items/folsada/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                        String xx=Integer.toString(x);
                        order1.setText(xx);
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
                int z = Integer.parseInt(order2.getText().toString());z++;
                String y = String.valueOf(z);
                order2.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folbelbeed/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order2.getText().toString());z--;
                String y = String.valueOf(z);
                order2.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/folbelbeed/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order3.getText().toString());z++;
                String y = String.valueOf(z);
                order3.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyasada/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order3.getText().toString());z--;
                String y = String.valueOf(z);
                order3.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyasada/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order4.getText().toString());z++;
                String y = String.valueOf(z);
                order4.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyabelbeed/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order4.getText().toString());z--;
                String y = String.valueOf(z);
                order4.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/ta3meyabelbeed/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order5.getText().toString());z++;
                String y = String.valueOf(z);
                order5.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmahrosa/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order5.getText().toString());z--;
                String y = String.valueOf(z);
                order5.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmahrosa/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order6.getText().toString());z++;
                String y = String.valueOf(z);
                order6.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmehamara/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order6.getText().toString());z--;
                String y = String.valueOf(z);
                order6.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/batatesmehamara/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order7.getText().toString());z++;
                String y = String.valueOf(z);
                order7.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/water/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order7.getText().toString());z--;
                String y = String.valueOf(z);
                order7.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/water/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order8.getText().toString());z++;
                String y = String.valueOf(z);
                order8.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/cola/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x++;
                        db.child(path).setValue(x);
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
                int z = Integer.parseInt(order8.getText().toString());z--;
                String y = String.valueOf(z);
                order8.setText(y);

                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/items/cola/quantity";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        int x = snapshot.getValue(Integer.class);
                        x--;
                        db.child(path).setValue(x);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });
            }
        });

        deliveryyes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/delivery";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        db.child(path).setValue("YES");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });
        deliveryno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference db = FirebaseDatabase.getInstance().getReference().child("FOODY");
                String path = "arabiata/delivery";
                db.child(path).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        db.child(path).setValue("NO");
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        // Handle onCancelled if needed
                    }
                });

            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(arabiata.this,"server updated",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(arabiata.this,done.class);
                startActivity(intent);
            }
        });



    }
}