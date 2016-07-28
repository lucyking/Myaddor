package com.example.myadder;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.webkit.WebView;

public class MainActivity extends Activity implements OnClickListener{
	Button btn0=null;
	int res1,res2;
    int res3;
	char char4_1[],char4_2[];
	static int radix=10;
	//android:inputType="numberSigned"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
		//setContentView(R.layout.activity_main);
		setContentView(R.layout.hex_main);
		btn0=(Button)findViewById(R.id.button1);
    	btn0.setOnClickListener(this);
    	
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.button1:
			EditText edtxt1=(EditText)findViewById(R.id.editText1);
	    	EditText edtxt2=(EditText)findViewById(R.id.editText2);
	    	if(edtxt1.getText().toString().length()==0)
	    		res1=0;
	    	else
	    	{
			    try {res1=Integer.parseInt(edtxt1.getText().toString(),radix);
			         //((TextView) findViewById(R.id.textView1)).setText("");
			    }catch (Exception e){
			    	res1=0;
			    	//((TextView) findViewById(R.id.textView1)).setText("Segmentfault");
			    }
	    	}
	    	
			if(edtxt2.getText().toString().length()==0)
				res2=0;
			else
			{
	    	    try {res2=Integer.parseInt(edtxt2.getText().toString(),radix);
	    	    //((TextView) findViewById(R.id.textView1)).setText("");
	    	    }catch (Exception e){
	    	    	res2=0;
	    	    	//((TextView) findViewById(R.id.textView1)).setText("Segmentfault");
	    	    }
	    	    }
			res3=res1+res2;
			
			String resault=res3+"";
			//res3=Integer.parseInt(resault, radix); // [bin|dec|hex]'s transform   
			//resault=res3+"";
			
			String Hexult=Integer.toHexString(res3);
			String binstring =Integer.toBinaryString(res3);
			//int a = Hexult.length();
		
			if(radix==2){			
			((TextView) findViewById(R.id.TextView01)).setText(resault);
			((TextView) findViewById(R.id.TextView02)).setText(Hexult); //Hex-resault
			((TextView) findViewById(R.id.TextView03)).setText(">"+binstring);
			}
			else if(radix==10){
				((TextView) findViewById(R.id.TextView01)).setText(">"+resault);
				((TextView) findViewById(R.id.TextView02)).setText(Hexult); //Hex-resault
				((TextView) findViewById(R.id.TextView03)).setText(binstring);
				
			}
			else if(radix==16){
				((TextView) findViewById(R.id.TextView01)).setText(resault);
				((TextView) findViewById(R.id.TextView02)).setText(">"+Hexult); //Hex-resault
				((TextView) findViewById(R.id.TextView03)).setText(binstring);
			}
			return;
		default:
    		return;
		}
		
	}
   
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.item1){ 
        	radix=2;
        	setContentView(R.layout.activity_main);  // reset keyboard map for HEX 
        	((TextView) findViewById(R.id.TextView01)).setText("0");
			((TextView) findViewById(R.id.TextView02)).setText("0"); //Hex-resault
			((TextView) findViewById(R.id.TextView03)).setText(">0");
			
            btn0=(Button)findViewById(R.id.button1);
        	btn0.setOnClickListener(this);
            return true;
        }
        
        else if(id == R.id.item2){
        	radix=10;
        	setContentView(R.layout.activity_main);  // reset keyboard map for HEX 
        	((TextView) findViewById(R.id.TextView01)).setText(">0");
			((TextView) findViewById(R.id.TextView02)).setText("0"); //Hex-resault
			((TextView) findViewById(R.id.TextView03)).setText("0");
			
        	btn0=(Button)findViewById(R.id.button1);
        	btn0.setOnClickListener(this);
        	return true;
        }
        else if(id == R.id.item3){
        	radix=16;
        	setContentView(R.layout.hex_main);  // reset keyboard map for HEX 
        	((TextView) findViewById(R.id.TextView01)).setText("0");
			((TextView) findViewById(R.id.TextView02)).setText(">0"); //Hex-resault
			((TextView) findViewById(R.id.TextView03)).setText("0");
        	
        	btn0=(Button)findViewById(R.id.button1);
        	btn0.setOnClickListener(this);
        	return true;
        }
        
        
        
        return super.onOptionsItemSelected(item);
    }


}
