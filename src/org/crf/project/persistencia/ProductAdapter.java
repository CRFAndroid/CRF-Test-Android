/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package org.crf.project.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ProductAdapter {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "name";
	public static final String KEY_PRICE = "price";
	public static final String KEY_COST = "cost";
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static final String PRODUCT_TABLE = "products";
	public static final String DATABASE_CREATE =
		"create table products (_id integer primary key autoincrement, "
		+ "name text not null, "
		+ "price text not null, "
		+ "cost text not null);";
	

	private final Context mCtx;

	public ProductAdapter(Context ctx) {
		this.mCtx = ctx;
		mDbHelper = new DatabaseHelper(mCtx);
		mDb = mDbHelper.getWritableDatabase();
	}


	public void close() {
		mDbHelper.close();
	}

	public long createProduct(ContentValues initialValues) {
		return mDb.insert(PRODUCT_TABLE, null, initialValues);
	}

	public boolean deleteProduct(long rowId) {
		return mDb.delete(PRODUCT_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	public Cursor fetchProducts() {
		return mDb.query(PRODUCT_TABLE, new String[] {KEY_ROWID, KEY_NAME, KEY_PRICE, KEY_COST}, null, null, null, null, null);
	}

	public Cursor fetchProduct(long rowId) throws SQLException {
		Cursor mCursor = mDb.rawQuery("Select * from "+PRODUCT_TABLE+ " where "+KEY_ROWID+ " = " +rowId, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;

	}

	public boolean updateProduct(long rowId, ContentValues values) {
		return mDb.update(PRODUCT_TABLE, values, KEY_ROWID + "=" + rowId, null) > 0;
	}
}

