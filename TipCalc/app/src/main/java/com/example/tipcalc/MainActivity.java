package com.example.tipcalc;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText totval;
    private EditText percentage;
    private TextView tip;
    private EditText people;
    private TextView split;
    private RadioGroup rgroup;
    private RadioButton ten;
    private RadioButton fifteen;
    private RadioButton twenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        totval = findViewById(R.id.totval);
        percentage = findViewById(R.id.percentage);
        tip = findViewById(R.id.tip);
        people = findViewById(R.id.people);
        split = findViewById(R.id.split);
        ten = findViewById(R.id.ten);
        fifteen=findViewById(R.id.fifteen);
        twenty =findViewById(R.id.twenty);
        rgroup = findViewById(R.id.rgroup);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void enter(View v) {
        String input = totval.getText().toString();
        double total = Double.parseDouble(input);
        double perc= 0;
        if (ten.isChecked()) {
            perc = 10;
        } else if (fifteen.isChecked()) {
            perc = 15;
        } else if (twenty.isChecked()) {
            perc = 20;
        }else{
            String p = percentage.getText().toString();
            perc = Double.parseDouble(p);
        }
         double tiptot = total + (total * (perc / 100));
            tip.setText(tiptot+ "");
        String input2 = people.getText().toString();
        double num = Double.parseDouble(input2);
        double person = tiptot/num;
        split.setText(person+"");
    }
}