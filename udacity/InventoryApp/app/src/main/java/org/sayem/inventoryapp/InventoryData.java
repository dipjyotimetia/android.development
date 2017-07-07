package org.sayem.inventoryapp;

import android.app.Application;
import android.content.ContentValues;

import org.sayem.inventoryapp.data.DBUtils;
import org.sayem.inventoryapp.data.InventoryDetailsContract;



public class InventoryData extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        createSupplierRecord();
        createProductRecord();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


    private void createProductRecord() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "Apple");
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_QUANTITY, 208);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRICE, 99.00);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 1172);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_IMAGE_URL, "http://www.thebrandbite.com/wp-content/media/2015/07/apple-7.jpg");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryDetailsContract.ProductEntry.TABLE_NAME, contentValues);

        contentValues = new ContentValues();
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "Mango");
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_QUANTITY, 10);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRICE, 149.00);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 1169);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_IMAGE_URL, "http://kingofwallpapers.com/mango/mango-002.jpg");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryDetailsContract.ProductEntry.TABLE_NAME, contentValues);

        contentValues = new ContentValues();
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRODUCT_NAME, "Pineapple");
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_QUANTITY, 40);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_PRICE, 290.00);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_SUPPLIER_ID, 1172);
        contentValues.put(InventoryDetailsContract.ProductEntry.COLUMN_NAME_IMAGE_URL, "http://kingofwallpapers.com/pineapple/pineapple-014.jpg");
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryDetailsContract.ProductEntry.TABLE_NAME, contentValues);
    }

    private void createSupplierRecord() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_SUPPLIER_NAME,
                "Wallmart");
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_SUPPLIER_ID, 1172);
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_PHONE, 983462784);
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryDetailsContract.SupplierEntry.TABLE_NAME, contentValues);
        contentValues = new ContentValues();
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_SUPPLIER_NAME, "CoolStuff Retail");
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_SUPPLIER_ID, 1169);
        contentValues.put(InventoryDetailsContract.SupplierEntry.COLUMN_NAME_PHONE, 97654423);
        DBUtils.getInstance(this)
                .insertIntoDB(InventoryDetailsContract.SupplierEntry.TABLE_NAME, contentValues);
    }
}
