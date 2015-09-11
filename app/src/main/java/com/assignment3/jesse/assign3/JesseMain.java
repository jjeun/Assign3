/*
    Author: Jesse Jeun
    Date: Sept 11, 2015
    Description: Class for the Main page that will direct the users to either Darpan or Max page
                    based on which button is pressed.
 */

package com.assignment3.jesse.assign3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class JesseMain extends AppCompatActivity {

    private static final String TAG = "MainActivityTag"; // Declarging TAG variable for logging purposes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jesse_main);

        // Darpan button Listener
        Button dButton = (Button) findViewById(R.id.darpanButton);
        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Let's see what Darpan is doing!", Toast.LENGTH_SHORT).show(); // Creates Darpan "Toast" message
                Log.v(TAG, "Darpan Button Pressed");  // Log's that Darpan button was pressed.
                sendToDarpanScreen();                 // Calling method to send to Darpan screen
            }
        });

        // Max button Listener
        Button mButton = (Button) findViewById(R.id.maxButton);
        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Let's see what Max is doing!", Toast.LENGTH_SHORT).show(); // Creates Max "Toast" message
                Log.v(TAG, "Max Button Pressed");   // Log's that Max button was pressed.
                sendToMaxScreen();                  // Calling method to send to Max screen
            }
        });

    }

    // sendToDarpanScreen() method that will send user to Darpan_Activity when Darpan button is clicked
    public void sendToDarpanScreen(){

        Intent intent = new Intent(this, Darpan.class);  // declaring and initializing intent for Darpan activity
        startActivity(intent);          // starting Darpan activity

    }

    // sendToMaxScreen() method that will send user to Max_Activity when Max button is clicked
    public void sendToMaxScreen(){

        Intent intent = new Intent(this, Max.class);    // declaring and initializing intent for Max activity
        startActivity(intent);          // starting Max activity

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
