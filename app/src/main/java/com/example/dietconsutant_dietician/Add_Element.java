package com.example.dietconsutant_dietician;

import androidx.annotation.NonNull;
//import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.StringJoiner;


public class Add_Element extends AppCompatActivity {
    EditText name ,carbohydrate,proteins,fat;
    Button btn;
    CheckBox chk1,chk2,chk3,chk4,chk5,chk6,chk7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__element);
        name=findViewById(R.id.text1);
        carbohydrate=findViewById(R.id.text2);
        fat=findViewById(R.id.text3);
        proteins=findViewById(R.id.text4);
        chk1=findViewById(R.id.ch1);
        chk2=findViewById(R.id.ch2);
        chk3=findViewById(R.id.ch3);
        chk4=findViewById(R.id.ch4);
        chk5=findViewById(R.id.ch5);
        chk6=findViewById(R.id.ch6);
        chk7=findViewById(R.id.ch7);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
           // @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {

                 StringJoiner msg = new StringJoiner(",");
                 if (chk1.isChecked())
                     msg = msg.add("Under Weight");
                 if (chk2.isChecked())
                     msg = msg.add("Healthy");
                 if (chk3.isChecked())
                     msg = msg.add("Over Weight");


                StringJoiner msg2=new StringJoiner(",");
                if(chk4.isChecked())
                    msg2.add("BreakFast");
                if(chk5.isChecked())
                    msg2.add("Lunch");
                if(chk6.isChecked())
                    msg2.add("Evening snacks");
                if(chk7.isChecked())
                    msg2.add("Dinner");

                HashMap<String,Object> map=new HashMap<>();
                map.put("Food_name",name.getText().toString());
                map.put("Carbohydrates",carbohydrate.getText().toString());
                map.put("Fats",fat.getText().toString());
                map.put("Proteins",proteins.getText().toString());
              map.put("Consumed_By",msg.toString());
                map.put("Consumed_For",msg2.toString());


                FirebaseDatabase.getInstance().getReference()
                        .child("Food List").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(Add_Element.this, "Completed", Toast.LENGTH_SHORT).show();

                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.d("yo","falire"+e.toString());
                            }
                        });

            }
        });



    }
}
