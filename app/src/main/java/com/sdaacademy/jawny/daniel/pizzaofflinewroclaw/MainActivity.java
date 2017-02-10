package com.sdaacademy.jawny.daniel.pizzaofflinewroclaw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView streetName;
    private AutoCompleteTextView streetNumber;
    private String[] numbers = new String[100];
    private String[] streetsArray = new String[40];
    private TextView result;
    private ViewGroup resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadResources();
        bindViews();
        init();
        setAdapters();
    }

    private void bindViews() {
        streetName = (AutoCompleteTextView) findViewById(R.id.streetName);
        streetNumber = (AutoCompleteTextView) findViewById(R.id.streetNumber);
        resultView = (ViewGroup) findViewById(R.id.resultLayout);
        result = (TextView) findViewById(R.id.result);
    }

    private void init() {
        resultView.setVisibility(View.GONE);
    }

    private void setAdapters() {
        streetName.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, streetsArray));
        streetNumber.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, numbers));
    }

    private void loadResources() {
        streetsArray = getResources().getStringArray(R.array.streets);
        for (int i = 1; i <= 100; i++) {
            numbers[i - 1] = Integer.toString(i);
        }
    }

    public void search(View view) {
        String name = streetName.getText().toString();
        String nr = streetNumber.getText().toString();
        if (!name.isEmpty() && !nr.isEmpty()) {
            resultView.setVisibility(View.VISIBLE);
            result.setText(String.format("Ulica: %s Nr: %s", name, nr));
        }
    }
}