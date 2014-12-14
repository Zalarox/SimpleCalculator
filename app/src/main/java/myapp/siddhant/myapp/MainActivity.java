package myapp.siddhant.myapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btnSubmit(View view) {
        float result=0;
        EditText num1 = (EditText) findViewById(R.id.numOne);
        EditText num2 = (EditText) findViewById(R.id.numTwo);
        String num1s = num1.getText().toString();
        String num2s = num2.getText().toString();
        float n1 = Float.parseFloat(num1s);
        float n2 = Float.parseFloat(num2s);

        EditText resultField = (EditText) findViewById(R.id.tbxResult);

        if(((RadioButton) findViewById(R.id.rbSum)).isChecked())
            result = n1+n2;
        else if(((RadioButton) findViewById(R.id.rbDifference)).isChecked())
            result = n1-n2;
        else if(((RadioButton) findViewById(R.id.rbProduct)).isChecked())
            result = n1*n2;
        else if(((RadioButton) findViewById(R.id.rbDivision)).isChecked())
            result = n1/n2;
        else
            result=0;

        Switch s = (Switch) findViewById(R.id.switchInteger);
        if(s.isChecked()) {
            result = Math.round(result);
        }

        String msg = "The result is " + result;
        resultField.setText(msg);

        int precision;
        EditText p = (EditText) findViewById(R.id.tbxPrecision);
        if(!p.getText().toString().equals("")){
            precision = Integer.parseInt(p.getText().toString());
        } else {
            precision = 0;
        }

        if( precision > 6 || precision < 0){
            Toast t = Toast.makeText(getApplicationContext(), "Precision should be up to 6 decimal places", Toast.LENGTH_SHORT);
            t.show();
            p.setText("");
        } else {
            resultField.setText(msg);
        }
    }

    public void onClick_checkBox(View view) {

        EditText p = (EditText) findViewById(R.id.tbxPrecision);
        CheckBox cb = (CheckBox) view;
        if(cb.isChecked()){
            p.setEnabled(true);
            p.setFocusable(true);
            p.setClickable(true);
            p.setCursorVisible(true);
            p.setFocusableInTouchMode(true);
        } else {
            p.setEnabled(false);
            p.setFocusable(false);
            p.setClickable(false);
            p.setCursorVisible(false);
            p.setFocusableInTouchMode(false);
            p.setText("");
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
