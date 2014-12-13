package myapp.siddhant.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick_btnSubmit(View view) {
        Button btn;
        float result=0;
        EditText num1 = (EditText) findViewById(R.id.numOne);
        EditText num2 = (EditText) findViewById(R.id.numTwo);
        btn = (Button) findViewById(R.id.btnSubmit);
        String num1s = num1.getText().toString();
        String num2s = num2.getText().toString();
        float n1 = Float.parseFloat(num1s);
        float n2 = Float.parseFloat(num2s);

        if(((CheckBox)findViewById(R.id.cbSum)).isChecked())
        result = n1+n2;

        String msg = "The result is " + result;
        Toast t = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        t.show();
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
