package com.sdaacademy.jawny.daniel.pizzaofflinewroclaw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.street_name)
    AutoCompleteTextView mStreetName;

    @BindView(R.id.street_number)
    AutoCompleteTextView mStreetNumber;

    @BindView(R.id.result)
    TextView result;

    @BindView(R.id.result_layout)
    ViewGroup resultView;

    private String[] numbers = new String[100];
    private String[] streetsArray = new String[40];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
        loadResources();
        setAdapters();
    }

    @OnClick(R.id.image_button)
    public void search(View view) {
        String name = mStreetName.getText().toString();
        String nr = mStreetNumber.getText().toString();
        if (!name.isEmpty() && !nr.isEmpty()) {
            resultView.setVisibility(View.VISIBLE);
            result.setText(String.format("Ulica: %s Nr: %s", name, nr));
        }
    }

    private void init() {
        resultView.setVisibility(View.GONE);
    }

    private void loadResources() {
        streetsArray = getResources().getStringArray(R.array.streets);
        for (int i = 1; i <= 100; i++) {
            numbers[i - 1] = Integer.toString(i);
        }
    }

    private void setAdapters() {
        mStreetName.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, streetsArray));
        mStreetNumber.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numbers));
    }
}