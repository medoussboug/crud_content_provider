//package com.example.crud_lite_content_provider.data.repository;
//
//import static android.provider.BaseColumns._ID;
//
//import android.app.Application;
//import android.content.ContentResolver;
//import android.database.Cursor;
//import android.net.Uri;
//
//import com.example.crud_lite_content_provider.data.entity.ShoppingItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ShoppingItemRepository {
//    private final ContentResolver contentResolver;
//    private final Uri CONTENT_URI = Uri.parse("content://com.example.shopping_list/shopping_list");
//
//    public ShoppingItemRepository(Application application) {
//        this.contentResolver = application.getContentResolver();
//    }
//
//    public List<ShoppingItem> getShoppingItems() {
//        List<ShoppingItem> shoppingItems = new ArrayList<>();
//        Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, "name");
//        while (cursor.moveToNext()) {
//            shoppingItems.add(new ShoppingItem(cursor.getString(1), cursor.getInt(2)));
//        }
//        cursor.close();
//        return shoppingItems;
//    }
//}
