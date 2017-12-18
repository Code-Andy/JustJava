package com.examples.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
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
    int cupprice = 2;

    boolean checked = false;
    boolean checked1 = false;


    public void hasChecked(View view) {
        CheckBox cream = (CheckBox) findViewById(R.id.whippedCream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);

        if (cream.isChecked()){
            cream.setChecked(true);
            cupprice = 3;
            checked = true;
        }

        else{
            checked = false;
        }

        if (chocolate.isChecked()){
            chocolate.setChecked(true);
            cupprice = 4;
            checked1 = true;
        }

        else{
            checked1 = false;
        }

        if (cream.isChecked() && chocolate.isChecked()){
            cupprice = 5;
        }

        if (!checked && !checked1){
            cupprice = 2;
        }

}

    public void submitOrder(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        String Name = name.getText().toString();
        String msg = createOrderSummary(Name);
        displaySummary(msg);
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "zhangandy915@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Order for Imacdonalds");
        intent.putExtra(Intent.EXTRA_TEXT, msg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void increment(View view) {
        if (numberOfCoffee == 101){
            return;
        }
        displayQuantity(numberOfCoffee);
        numberOfCoffee = numberOfCoffee + 1;
    }

    public void decrement(View view) {
        if (numberOfCoffee == 0){
            return;
        }
        numberOfCoffee = numberOfCoffee - 1;
        displayQuantity(numberOfCoffee);
    }
    /**

     This method displays the given quantity value on the screen.\
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

    private String createOrderSummary(String person){
        String summaryOrder = "Name: " + person + "\n";
        if(checked){
            summaryOrder += "Add Whipped Cream" + "\n";
        }
        if(checked1){
            summaryOrder += "Add Chocolate" + "\n";
        }
        summaryOrder += "Quantity: " + numberOfCoffee + "\n";
        summaryOrder += "Total: " + "$" + calculatePrice(numberOfCoffee, cupprice) + "\n";
        summaryOrder += "Thank you!";
        return summaryOrder;
    }
}