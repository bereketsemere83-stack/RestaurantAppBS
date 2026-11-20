package org.baltimorecityschools.restaurantappbs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.net.Uri;



import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // 1 Declare all variable
    Button welcomeBTN, menuBTN;
    TextView welcomeTV, addressTV;

    EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // 2. Initialize variables & inflate UI elements
        welcomeBTN = (Button) findViewById(R.id.welcomeBTN);
        menuBTN = (Button) findViewById(R.id.menuBTN);
        welcomeTV =(TextView) findViewById(R.id.welcomeTV);
        addressTV = (TextView) findViewById(R.id.addressTV);
        nameET =(EditText) findViewById(R.id.nameET);

        // 3. Do stuff

        welcomeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nameET.getText().toString();

                welcomeTV.setText("Welcome to Habeshan Food, " + name + "!");
            }
        });

        // ADDRESS - IMPLICIT INTENT
        addressTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri location = Uri.parse("geo:0,0?q=Addis,+Ethiopian,+Restaurant,+316+park+Ave,+Baltimore,+MD,+21201");


                Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

                startActivity(mapIntent);
            }
        });


        menuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menuIntent = new Intent(MainActivity.this, MenuActivity.class);

                startActivity(menuIntent);
            }
        });


    }
}