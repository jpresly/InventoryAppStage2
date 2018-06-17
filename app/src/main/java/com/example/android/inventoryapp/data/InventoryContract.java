package com.example.android.inventoryapp.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public final class InventoryContract {

    public static final String LOG_TAG = InventoryProvider.class.getSimpleName();

    private InventoryContract() {}

    /**
     * The "Content authority" is a name for the entire content provider. A convenient
     * string to use for the content authority is the package name for the app, which is
     * guaranteed to be unique on the device
     */
    public static final String CONTENT_AUTHORITY = "com.example.android.inventoryapp";

    /**
     * Use CONTENT AUTHORITY to create the base of all URI's which apps will use to
     * contact the content provider
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URIs)
     */
    public static final String PATH_INVENTORY = "products";

    /**
     * Inner class that defines constant values for the products database table
     * Each entry in the table represents a single product
     */

    public static abstract class InventoryEntry implements BaseColumns {

        /** The content URI to access the product data in the provider */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INVENTORY);

        /** The MIME type of the {@link #CONTENT_URI} for a list of products */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORY;

        /** The MIME type of the {@link #CONTENT_URI} for a single product */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INVENTORY;

        /**
         * Name of database table for inventory
         */
        public final static String TABLE_NAME = "inventory";

        /**
         * Unique ID number for the product, type INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Product Name, type TEXT
         */
        public final static String COLUMN_PRODUCT_NAME = "name";

        /**
         * Price of the product, type INTEGER
         */
        public final static String COLUMN_PRICE = "price";

        /**
         * Quantity of the product, type INTEGER
         */
        public final static String COLUMN_QUANTITY = "quantity";

        /**
         * Supplier Name, type INTEGER
         */
        public final static String COLUMN_SUPPLIER_NAME = "supplier";

        /**
         * Supplier Phone Number, type TEXT
         */
        public final static String COLUMN_SUPPLIER_PHONE = "phonenumber";

        /**
         * Possible values for the supplier of the product
         */
        public final static int SUPPLIER_UNKNOWN = 0;
        public final static int SUPPLIER_PENGUIN = 1;
        public final static int SUPPLIER_AMAZON = 2;
        public final static int SUPPLIER_WATERSTONES = 3;

        /**
         * Returns whether or not the given supplier is {@link #SUPPLIER_UNKNOWN}, {@link #SUPPLIER_PENGUIN},
         * {@link #SUPPLIER_AMAZON} or {@link #SUPPLIER_WATERSTONES}
         */
        public static boolean isValidSupplier(int supplier) {
            if (supplier == SUPPLIER_UNKNOWN || supplier == SUPPLIER_PENGUIN || supplier == SUPPLIER_AMAZON
                    || supplier == SUPPLIER_WATERSTONES) {
                return true;
            }
            return false;
        }
    }
}
