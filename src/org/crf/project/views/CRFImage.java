package org.crf.project.views;


import org.crf.project.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CRFImage extends LinearLayout implements OnLongClickListener{

	private CharSequence toastMessage;
	private CharSequence footNoteMessage;
	private Drawable image;
	private Context cxt;
	private TextView footNoteText;
	private ImageView brightImage;
	
	public CRFImage(Context context) {
		super(context);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.crf_image,this);
		this.setOnLongClickListener(this);
		cxt = context;
		
	}

	public CRFImage(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.crf_image,this);
		
		this.setOnLongClickListener(this);
		cxt = context;
		
		/** We initialize the elements form our UI because we are going to modify them **/
		
		footNoteText = (TextView) findViewById(R.id.footnote);
		brightImage = (ImageView) findViewById(R.id.image);
		
		/** We get the attributes from the XML file attrs.xml **/
		TypedArray styleAttributes = context.obtainStyledAttributes(attrs, R.styleable.CRFImage);
		toastMessage = styleAttributes.getString(R.styleable.CRFImage_message_string);
		image = styleAttributes.getDrawable(R.styleable.CRFImage_crf_image);
		footNoteMessage = styleAttributes.getString(R.styleable.CRFImage_footnote_string);
		
		footNoteText.setText(footNoteMessage);
		brightImage.setBackgroundDrawable(image);

	}
	
	@Override
	public boolean onLongClick(View arg0) {
		
		Toast.makeText(cxt, toastMessage, Toast.LENGTH_LONG).show();
		
		return false;
	}
	

}
