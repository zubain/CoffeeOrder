package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        /*int numCoffees = quantity;
        display(numCoffees);
        displayPrice(numCoffees*5);
        */
        int price = calculatePrice();
        String priceMsg = "Total: " + price + "$" + "\n" + "Thank you!";
        displayMessage(priceMsg);
        String Order = createOrderSummary(price);
        displayMessage(Order);
    }

    public String createOrderSummary(int price){
        String OrderMsg = "Kaptain Kunal" + "\n" + "Quantity: " + quantity + "\n" + "Total: " + "$" + calculatePrice() + "\n" + "Thank you!";
        return OrderMsg;
    }

    public void increment(View view) {
        quantity=quantity+1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity-1 < 0){
        }
        else {
            quantity=quantity-1;
        }
        display(quantity);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private int calculatePrice() {
        int price = quantity*5;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}