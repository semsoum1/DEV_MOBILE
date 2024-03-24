package com.example.monprojet;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.monprojet.MainActivity2;


public class finalpage extends AppCompatActivity {
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalpage);
        Bundle b=getIntent().getExtras();
        String spinnerville=b.getString("spinnerville");
         class MyData {
            public String toString() {
                return "il ya actuellement " + DB.getSingleValue() + "\nla ville de: " + spinnerville;
            }
        }


    }
}