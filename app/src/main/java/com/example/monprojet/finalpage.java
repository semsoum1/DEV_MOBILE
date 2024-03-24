package com.example.monprojet;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Intent;
import androidx.fragment.app.FragmentContainerView;

import android.content.Intent;
import android.os.Bundle;


public class finalpage extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        Bundle b=getIntent().getExtras();

        Intent intent = new Intent(getApplicationContext(), finalpage.class);
        startActivity(intent);

        String spinnerville=b.getString("spinnerville");
         class MyData {
            public String toString() {
                return "il ya actuellement " + DB.getSingleValue() + "\nla ville de: " + spinnerville;
            }
        }


    }
}