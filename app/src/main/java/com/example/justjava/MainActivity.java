/**
 * The package in this file has to match the AndroidManifest.xml package found in the manifests
 * folder and if this files package is different then change this files package not the
 * AndroidManifest package
 */

package com.example.justjava;

import java.text.NumberFormat;
import java.util.jar.Attributes;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    /*
     * Setting Global Quantity
     */

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the Increment/Plus button is clicked
     */

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the Decrement/Minus button is clicked
     */

    public void decrement(View view){
        if(quantity>0) {
            quantity--;
            displayQuantity(quantity);
        }
    }


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //Get text from the EditText XML
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name: " + name);

        // Figure out if user wants Whipped Cream
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "has whipped cream: " + hasWhippedCream);

        //Figure out if user wants Chocolate topping
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        Log.v("MainActivity", "Add Chocolate Topping: " + hasChocolate);

        // Calculates Price
        int price  = calculatePrice();

        // Display the order summary on the screen
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
        displayMessage(priceMessage);
    }


    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * create a summary of our order
     *
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @return pricMessage
     */
private String createOrderSummary(String name,  int price, boolean addWhippedCream, boolean addChocolate) {
    String priceMessage = "Name: " + name;
    priceMessage += "\nThank you for ordering " + quantity + " Coffees!";  //I used the escape key \n to put info on a new line
    priceMessage += "\nAdd Whipped Cream? " + addWhippedCream;
    priceMessage += "\nAdd Chocolate Topping? " + addChocolate;
    priceMessage += "\nAmount Due: $" + price;
    priceMessage += "\n\nYour order will be right up!"; //Double \n escape key for w line separation
    return priceMessage;
}


    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }



    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);

    }


}