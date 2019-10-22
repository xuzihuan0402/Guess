package com.tom.guess;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView message;
    int secret = new Random().nextInt(10)+1;
    String TAG = MainActivity.class.getSimpleName();
    private EditText edNumber;
    private ImageView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"secret"+secret);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        edNumber = findViewById(R.id.num);
        message = findViewById(R.id.message);
        result = findViewById(R.id.result);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
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

    public void guess(View view){
        int number = Integer.parseInt(edNumber.getText().toString());
        result.setVisibility(View.VISIBLE);
        if(number <secret){
            message.setText("Bigger");
        }else if(number >secret){
            message.setText("Small");
        }else{
            message.setText("Bingo!");
            result.setImageResource(R.drawable.shock);
        }
        edNumber.setText("");

    }
}
