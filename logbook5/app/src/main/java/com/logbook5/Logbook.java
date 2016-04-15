package com.logbook5;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Logbook extends AppCompatActivity {

    EditText width,height,cost;
    TextView area,total;
    Button cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logbook);
        initUI();
    }

    private void initUI(){
        width = (EditText)findViewById(R.id.width);
        height = (EditText)findViewById(R.id.height);
        cost = (EditText)findViewById(R.id.cost);

        area = (TextView)findViewById(R.id.txtArea);
        total = (TextView)findViewById(R.id.txtTotal);

        cal = (Button)findViewById(R.id.cal);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void calculate(){
        int width,height,cost;
        try {
            width = this.width.getText()!=null?Integer.parseInt(this.width.getText().toString()):0;
        }catch (Exception e){
            width = 0;
        }
        try {
            height = this.height.getText()!=null?Integer.parseInt(this.height.getText().toString()):0;
        }catch (Exception e){
            height = 0;
        }
        try {
            cost = this.cost.getText()!=null?Integer.parseInt(this.cost.getText().toString()):0;
        }catch (Exception e){
            cost = 0;
        }

        area.setText(String.valueOf(width*height));
        total.setText(String.valueOf(width*height*cost));
    }
}
