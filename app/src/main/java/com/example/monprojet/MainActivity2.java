package com.example.monprojet;
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



public class MainActivity2 extends AppCompatActivity {
    EditText titre, typecontract, descp;
    Button button2;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        titre = (EditText) findViewById(R.id.editTextText);
        typecontract = (EditText) findViewById(R.id.editTextText3);
        descp = (EditText) findViewById(R.id.editTextText2);
        button2 = (Button) findViewById(R.id.button2);



        Spinner spinnercat = findViewById(R.id.spinner_languages2);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this, R.array.cat, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnercat.setAdapter(adapter);

        Spinner spinnersecteur = findViewById(R.id.spinner_languages3);
        adapter = ArrayAdapter.createFromResource(this, R.array.secteur, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnersecteur.setAdapter(adapter);

        Spinner spinnerville = findViewById(R.id.spinner_languages1);
        adapter = ArrayAdapter.createFromResource(this, R.array.ville, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerville.setAdapter(adapter);

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DB.insertData4(String.valueOf(titre));

                spinnercat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity2.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                DB.insertData3(String.valueOf(spinnercat));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});

        spinnersecteur.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity2.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});

        spinnerville.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity2.this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                DB.insertData2(String.valueOf(spinnerville));

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}});

                    Intent intent = new Intent(getApplicationContext(), finalpage.class);
                    startActivity(intent);

                Bundle b=new Bundle();
                b.putString("spinnerville",spinnerville.toString());
                intent.putExtras(b);
                startActivity(intent);

    }
});}}