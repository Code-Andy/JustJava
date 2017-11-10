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

    boolean WhippedCream = false;

    public void submitOrder(View view) {
        String msg = createOrderSummary();
        displaySummary(msg);

    }

    public void hasWhippedCream(View view){

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
    private void displaySummary(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

    private int calculatePrice(int number, int cupPrice) {
        int price = number * cupPrice;
        return price;
    }

    private String createOrderSummary(){
        String summaryOrder = "Name: CoffeeAddict\n";
        summaryOrder += "Quantity: " + numberOfCoffee + "\n";
        summaryOrder += "Total: " + calculatePrice(numberOfCoffee, 2) + "\n";
        summaryOrder += "Thank you!";
        return summaryOrder;
    }
}