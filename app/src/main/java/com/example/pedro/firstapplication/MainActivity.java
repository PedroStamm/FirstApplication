package com.example.pedro.firstapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String default_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        default_text = getString(R.string.default_text);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Contact Overwatch!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener(){
                    public void onItemSelected(AdapterView<?> spin, View v, int i, long id){
                        String selected = spin.getSelectedItem().toString().toLowerCase();
                        Log.d("Selected", selected);
                        ImageView imageView = (ImageView) findViewById(R.id.heroView);
                        if(selected.equals("mercy")) {
                            imageView.setImageResource(R.drawable.mercy);
                        } else if (selected.equals("soldier")) {
                            imageView.setImageResource(R.drawable.soldier);
                        } else {
                            imageView.setImageResource(R.drawable.reaper);
                        }
                    }

                    public void onNothingSelected(AdapterView<?> parent){}
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

    public void sendMessage(View view) {
        TextView myView = (TextView) findViewById(R.id.textView);
        EditText input_text = (EditText) findViewById(R.id.edit_message);
        String message = input_text.getText().toString();
        String placeholder = default_text+" "+message+".";
        myView.setText(placeholder);
    }
}
