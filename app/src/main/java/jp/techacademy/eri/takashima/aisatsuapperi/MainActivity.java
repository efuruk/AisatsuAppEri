package jp.techacademy.eri.takashima.aisatsuapperi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.TimePicker;
import java.util.Calendar;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mTextView;
    private int hourOfDay;
    private int minute;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.TextView);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            if (hourOfDay >=2 && hourOfDay < 10){
                TextView textView = (TextView) findViewById(R.id.TextView);
                textView.setText("おはよう");
            } else if(hourOfDay >= 10 && hourOfDay <18) {
                TextView textView = (TextView) findViewById(R.id.TextView);
                textView.setText("こんにちは");
            } else if (hourOfDay >=18 || hourOfDay <=1) {
                TextView textView = (TextView) findViewById(R.id.TextView);
                textView.setText("こんばんは");
            }
        } else if (v.getId() == R.id.button2) {
            showTimePickerDialog();
        }
    }
    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hour, int minute) {
                        Log.d("UI-PARTS", String.valueOf(hour) + ":" + String.valueOf(minute));
                 hourOfDay = hour;}
                },
                13, //初期値（時間）
                0, //初期値（分）
                true);
        timePickerDialog.show();
    }


}
