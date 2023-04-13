package com.example.w5;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // make a reference to buttons
    Button btn_add;
    EditText et_name, et_age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on create, give value
        btn_add = findViewById(R.id.btn_add);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);


        //Listeners:
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customerModel cm;
                try {
                    cm = new customerModel(-1, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()));
                    Toast.makeText(MainActivity.this, cm.toString() , Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                     cm = new customerModel(-1, "ERROR", 0);
                }
                DataBaseHelper dbh = new DataBaseHelper(MainActivity.this);
                boolean b = dbh.addOne(cm);
                Toast.makeText(MainActivity.this, "SUCCESS= " + b, Toast.LENGTH_SHORT).show();

            }

        });

    }

}