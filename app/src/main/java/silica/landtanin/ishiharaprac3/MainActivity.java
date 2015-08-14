package silica.landtanin.ishiharaprac3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private ImageView ishiharaPic;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1, choice2, choice3, choice4;
    private Button AnsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind widget
        bindWidget();

        //Create Button Controller
        buttonController();

    }

    private void buttonController() {

        AnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });//Statement in method

    }//button controller

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.head1);
        ishiharaPic = (ImageView) findViewById(R.id.imageView);
        choiceRadioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        choice1 = (RadioButton) findViewById(R.id.radioButton1);
        choice2 = (RadioButton) findViewById(R.id.radioButton2);
        choice3 = (RadioButton) findViewById(R.id.radioButton3);
        choice4 = (RadioButton) findViewById(R.id.radioButton4);
        AnsButton = (Button) findViewById(R.id.AnsButton);
    }//bind widget

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
