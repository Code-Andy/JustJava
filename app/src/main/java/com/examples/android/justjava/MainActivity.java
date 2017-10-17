package com.examples.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;



/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
515
     This method is called when the order button is clicked.
     */

    int numberOfCoffee = 0;
    public void submitOrder(View view) {
        String priceMessage = "That Is $" + calculatePrice();
        priceMessage = priceMessage + " Thank You!";
        displayPrice(priceMessage);

    }

    public void increment(View view) {
        numberOfCoffee = numberOfCoffee + 1;
        displayQuantity(numberOfCoffee);

    }

    public void decrement(View view) {
        numberOfCoffee = numberOfCoffee - 1;
        displayQuantity(numberOfCoffee);
    }
    /**

     This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

    private int calculatePrice() {
        int price = 0;
        price = numberOfCoffee * 5;
        return price;
    }
}