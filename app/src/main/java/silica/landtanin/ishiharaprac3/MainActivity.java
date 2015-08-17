package silica.landtanin.ishiharaprac3;

import android.media.MediaPlayer;
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
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private ImageView ishiharaPic;
    private RadioGroup choiceRadioGroup;
    private RadioButton choice1, choice2, choice3, choice4;
    private Button AnsButton;
    private int radioAnInt,indexAnInt,scoreAnInt;
    private MyModel objMyModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind widget
        bindWidget();

        //Create Button Controller
        buttonController();

        //Create Button Radio controller
        radioController();

        //About MyModel
        aboutMyModel();

    }

    private void aboutMyModel() {
        objMyModel = new MyModel();
        objMyModel.setOnMyModelChangeListener(new MyModel.OnMyModelChangeListener() {
            @Override
            public void onMyModelChangeListener(MyModel myModel) {

                //Change view
                changeView(myModel.getModelAnInt());//changeView will change picture and change choice

            }//event, when interface change it will sent a value to this field(MyModel)
        });
    }

    private void changeView(int modelAnInt) {

        //change image
        int intDrawable[] = {R.drawable.ishihara_01, R.drawable.ishihara_02, R.drawable.ishihara_03,
                R.drawable.ishihara_04, R.drawable.ishihara_05, R.drawable.ishihara_06,
                R.drawable.ishihara_07, R.drawable.ishihara_08, R.drawable.ishihara_09,
                R.drawable.ishihara_10};

        ishiharaPic.setImageResource(intDrawable[modelAnInt]);

        //change choice
        int intTimes[] = new int[10];
        intTimes[0] = R.array.times1;
        intTimes[1] = R.array.times2;
        intTimes[2] = R.array.times3;
        intTimes[3] = R.array.times4;
        intTimes[4] = R.array.times5;
        intTimes[5] = R.array.times6;
        intTimes[6] = R.array.times7;
        intTimes[7] = R.array.times8;
        intTimes[8] = R.array.times9;
        intTimes[9] = R.array.times10;

        String strChoice[] = new String[4];//4 slots for 4 choices
        strChoice = getResources().getStringArray(intTimes[modelAnInt]);
        choice1.setText(strChoice[0]);
        choice2.setText(strChoice[1]);
        choice3.setText(strChoice[2]);
        choice4.setText(strChoice[3]);
    } //Change View

    private void buttonController() {

        AnsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //sound effect
                MediaPlayer buttonMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                buttonMediaPlayer.start();

                //check zero
                checkZero();



            }//event of statement
        });//Statement in method

    }//button controller

    private void radioController() {

        choiceRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                //sound effect
                MediaPlayer radioMediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.phonton1);
                radioMediaPlayer.start();

                //Setup radio
                switch (i) {

                    case R.id.radioButton1:
                        radioAnInt = 1;
                        break;

                    case R.id.radioButton2:
                        radioAnInt = 2;
                        break;

                    case R.id.radioButton3:
                        radioAnInt = 3;
                        break;

                    case R.id.radioButton4:
                        radioAnInt = 4;
                        break;

                    default:
                        radioAnInt = 0;
                        break;

                }

            }//event
        });

    }

    private void checkZero() {

        if (radioAnInt == 0) {

            Toast.makeText(MainActivity.this, "Please select your answer", Toast.LENGTH_SHORT).show();

        } else {
            //check score
            checkScore();
            
            //check times
            checkTimes();

        }

    }//checkZero

    private void checkTimes() {
        if (indexAnInt == 9) {

            IntentToShowScore();
        }

        else {

            //increase indexAnInt
            indexAnInt++;

            //Controller call view
            questionTextView.setText(Integer.toString(indexAnInt+1)+". What is this?");

            //Controller call model
            objMyModel.setModelAnInt(indexAnInt);//this is where we sent value to model, this is also a setter of controller

        }

    }//check times

    private void IntentToShowScore() {
        Intent objIntent = new Intent(MainActivity.this,ShowScoreActivity.class);
        objIntent.putExtra("Score", scoreAnInt);
        startActivity(objIntent);
        finish();

    }//intent to show score

    private void checkScore() {
        int intAnswertrue[] = {1, 2, 3, 1, 2, 3, 1, 2, 4, 4};

        if (radioAnInt == intAnswertrue[indexAnInt]) {

            scoreAnInt++;

        } //score record


    }//check score

    private void bindWidget() {
        questionTextView = (TextView) findViewById(R.id.head2);
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
