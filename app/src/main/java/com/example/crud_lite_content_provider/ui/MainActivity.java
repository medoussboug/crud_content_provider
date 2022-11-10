package com.example.crud_lite_content_provider.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

import com.example.crud_lite_content_provider.R;
import com.example.crud_lite_content_provider.data.ShoppingListContract;
import com.example.crud_lite_content_provider.data.entity.ShoppingItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView l;
    private ShoppingItemsAdapter adapter;
//    private ShoppingItemViewModel shoppingItemViewModel;

    private final Uri CONTENT_URI = Uri.parse("content://com.example.shopping_list/shopping_list");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ShoppingItem> shoppingItems = new ArrayList<>();
        String[] projection = new String[] {
                ShoppingListContract.ShoppingListEntry._ID,
                ShoppingListContract.ShoppingListEntry.COLUMN_NAME_NAME,
                ShoppingListContract.ShoppingListEntry.COLUMN_NAME_AMOUNT
        };
        Cursor cursor = getContentResolver().query(CONTENT_URI, projection, null, null, "name");
        while (cursor.moveToNext()) {
            shoppingItems.add(new ShoppingItem(cursor.getString(1), cursor.getInt(2)));
        }
        cursor.close();

        adapter = new ShoppingItemsAdapter(shoppingItems, this);
        l = findViewById(R.id.rvShoppingItems);
        l.setAdapter(adapter);
    }
}