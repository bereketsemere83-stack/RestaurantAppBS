package org.baltimorecityschools.restaurantappbs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;


import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    // 1. Declare variables
    Button minusBTN, plusBTN, addCartBTN, submitOrderBTN, backBTN;

    TextView quantityTV;
    TextView subtotalTV, taxTV, totalTV;

    RadioButton regularRB, largeRB;
    RadioButton noExtraRB, extraMeatRB, extraInjeraRB;

    Tibs tibs;

    double subtotal;
    double tax;
    double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);

        // 2. Initialize variables
        minusBTN = (Button) findViewById(R.id.minusBTN);
        plusBTN = (Button) findViewById(R.id.plusBTN);
        addCartBTN = (Button) findViewById(R.id.addCardBTN);
        backBTN = (Button) findViewById(R.id.backBTN);

        quantityTV = (TextView) findViewById(R.id.quantityTV);
        subtotalTV = (TextView) findViewById(R.id.subtotalTV);
        taxTV = (TextView) findViewById(R.id.taxTV);
        totalTV = (TextView) findViewById(R.id.totalTV);

        regularRB = (RadioButton) findViewById(R.id.regularRB);
        largeRB = (RadioButton) findViewById(R.id.largeRB);

        noExtraRB = (RadioButton) findViewById(R.id.noExtraRB);
        extraMeatRB = (RadioButton) findViewById(R.id.extraMeatRB);
        extraInjeraRB = (RadioButton) findViewById(R.id.extraInjeraRB);
        submitOrderBTN = (Button) findViewById(R.id.submitOrderBTN);

        // Create Tibs object
        tibs = new Tibs("Tibs", "Regular", "No Extra", 1, 15.00);



        // 3. Do stuff

        // PLUS BUTTON
        plusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = tibs.getQuantity();
                quantity = quantity + 1;
                tibs.setQuantity(quantity);
                quantityTV.setText("" + tibs.getQuantity());
            }
        });


        // MINUS BUTTON
        minusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity = tibs.getQuantity();
                if (quantity > 1) {
                    quantity = quantity - 1;
                    tibs.setQuantity(quantity);
                    quantityTV.setText("" + tibs.getQuantity());
                }
            }
        });


        // ADD TO CART BUTTON
        addCartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Start with base price of Tibs
                double itemPrice = tibs.getBasePrice();

                // SIZE
                if (largeRB.isChecked()) {
                    tibs.setSize("Large");
                    itemPrice = itemPrice + 3.00;
                }
                else {
                    tibs.setSize("Regular");
                }


                // EXTRA
                if (extraMeatRB.isChecked()) {tibs.setExtra("Extra Meat");
                    itemPrice = itemPrice + 4.00;
                }
                else if (extraInjeraRB.isChecked()) {tibs.setExtra("Extra Injera");
                    itemPrice = itemPrice + 2.00;
                }
                else {
                    tibs.setExtra("No Extra");
                }

                // SUBTOTAL
                subtotal = itemPrice * tibs.getQuantity();

                // TAX
                tax = subtotal * 0.06;

                // TOTAL
                total = subtotal + tax;

                // DISPLAY RESULTS
                subtotalTV.setText("Subtotal: $" + String.format("%.2f", subtotal));
                taxTV.setText("Tax: $" + String.format("%.2f", tax));
                totalTV.setText("Total: $" + String.format("%.2f", total));
            }
        });


        submitOrderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String subject = "Habeshan Food Order";

                String body = "Food: " + tibs.getName()
                                + "\nSize: " + tibs.getSize()
                                + "\nExtra: " + tibs.getExtra()
                                + "\nQuantity: " + tibs.getQuantity()
                                + "\nSubtotal: $" + String.format("%.2f", subtotal)
                                + "\nTax: $" + String.format("%.2f", tax)
                                + "\nTotal: $" + String.format("%.2f", total);

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                emailIntent.putExtra(Intent.EXTRA_TEXT, body);
                startActivity(emailIntent);
            }
        });

        // BACK BUTTON
        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
