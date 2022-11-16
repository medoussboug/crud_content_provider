package com.example.crud_lite_content_provider.ui;

import static com.example.crud_lite_content_provider.data.PersonContract.PersonContractEntry.TABLE_NAME;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crud_lite_content_provider.R;
import com.example.crud_lite_content_provider.data.PersonContract;
import com.example.crud_lite_content_provider.data.entity.Person;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String AUTHORITY = "com.idk.test.provider.crud";
    private static final Uri CONTENT_URI = Uri.parse("content://com.idk.test.provider.crud/person");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.btLoad);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Person> personList = new ArrayList<>();
                Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, "_id");
                if(cursor == null) {
                    Toast.makeText(getApplicationContext(), "null",Toast.LENGTH_LONG).show();
                } else {
                    while (cursor.moveToNext()) {
                        personList.add(new Person(cursor.getLong(0) ,cursor.getString(1), cursor.getString(2)));
                    }
                    cursor.close();
                    Toast.makeText(getApplicationContext(), personList.toString(),Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}