package com.logbook4;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class NameEntry extends Activity {
    private EditText mNameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_entry);

        Button theButton = (Button) findViewById(R.id.Press);
        Button theButton1 = (Button) findViewById(R.id.Dont);
        theButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                handleButtonClick();
            }
        });
        theButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dontpressme();
            }
        });

    }

    private void handleButtonClick() {

        //mNameText.setText("button was clicked");
        AlertDialog.Builder builder = new AlertDialog.Builder(NameEntry.this, R.style.AlertDialogStyle);
        builder.setTitle("");
        builder.setMessage("button was clicked");
        builder.setPositiveButton("OK", null);
//            builder.setNegativeButton("Cancel", null);
        builder.show();
    }
    private void Dontpressme()
    {
        Intent i = new Intent(this, dontpressme.class);
        startActivity(i);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_name_entry, menu);
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
