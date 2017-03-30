package com.example.rahul.question_answer_forum;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PortfolioPage extends AppCompatActivity {
    ListView listView;
    String[] myList;
    @BindView(R.id.text_welcome) TextView tvWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_page);
        ButterKnife.bind(this);
        myList = getResources().getStringArray(R.array.port_options);
        listView = (ListView) findViewById(R.id.port_list_view);
        String usernameTV = getIntent().getStringExtra("username");
        tvWelcome.setText("Welcome " + usernameTV);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String clickLogout = listView.getItemAtPosition(listView.getPositionForView(view)).toString();
                if (listView.getPositionForView(view) == 6) {
                    Intent intent = new Intent(PortfolioPage.this, LoginPage.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(PortfolioPage.this, clickLogout, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
