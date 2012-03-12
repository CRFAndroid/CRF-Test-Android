package org.crf.project;

import org.crf.project.persistencia.Product;
import org.crf.project.persistencia.ProductManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

public class CRFProjectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        
        
        Product product = new Product("Bimbo", 20, 10);
        ProductManager productManager = new ProductManager(this);
        productManager.createProduct(product);
        
        
        Product databaseProduct = productManager.getProductById(1);
        System.out.println("Product Name "+databaseProduct.getName());
        
        
    }
}