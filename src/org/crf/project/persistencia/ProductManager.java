package org.crf.project.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ProductManager {
	
	ProductAdapter productAdapter;
	
	
	public ProductManager(Context context){
		productAdapter = new ProductAdapter(context);
	}
	
	public long createProduct(Product product){
		ContentValues productContentValues = convertProductInContentValues(product);
		return productAdapter.createProduct(productContentValues);
	}
	
	public Product getProductById(long id){
		Cursor productCursor = productAdapter.fetchProduct(id);
		return convertCursorInProduct(productCursor);
	}

	private ContentValues convertProductInContentValues(Product product) {
		ContentValues contentValues = new ContentValues();
		contentValues.put(ProductAdapter.KEY_NAME, product.getName());
		contentValues.put(ProductAdapter.KEY_PRICE, product.getPrice());
		contentValues.put(ProductAdapter.KEY_COST, product.getCost());
		return contentValues;
	}
	
	private Product convertCursorInProduct(Cursor cursor) {
		Product product = new Product();
		product.setId(cursor.getLong(cursor.getColumnIndex(ProductAdapter.KEY_ROWID)));
		product.setName(cursor.getString(cursor.getColumnIndex(ProductAdapter.KEY_NAME)));
		product.setPrice(cursor.getDouble(cursor.getColumnIndex(ProductAdapter.KEY_PRICE)));
		product.setCost(cursor.getDouble(cursor.getColumnIndex(ProductAdapter.KEY_COST)));
		cursor.close();
		return product;
	}
	
	

}
