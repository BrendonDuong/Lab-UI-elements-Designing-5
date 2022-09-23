package com.example.labuielementsdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SignUpActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText username,email,phone,datetime,password,confirmpassword;
    boolean passwordVisible;

    RadioGroup radioGroup;
    RadioButton radioButton;
    CheckBox Checkphotography,Checkplay,Checkcode,Checkreadandwrite,Checkcookandeat,Checkgarden,Checktravel,Checkwatchandlisten;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        phone=findViewById(R.id.phone);
        datetime=findViewById(R.id.datetime);
        datetime.setInputType(InputType.TYPE_NULL);
        password=findViewById(R.id.pass);
        confirmpassword=findViewById(R.id.comfirmpass);

        //Hide and Show Password
        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=password.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            //set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        //Hide and Show Confirm Password
        confirmpassword.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if (event.getAction()==MotionEvent.ACTION_UP){
                    if (event.getRawX()>=confirmpassword.getRight()-confirmpassword.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=confirmpassword.getSelectionEnd();
                        if (passwordVisible){
                            //set drawable image here
                            confirmpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            //for hide confirmpassword
                            confirmpassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            //set drawable image here
                            confirmpassword.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            //for show confirmpassword
                            confirmpassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;
                        }
                        confirmpassword.setSelection(selection);
                        return true;
                    }
                }

                return false;
            }
        });

        //Back Button (Back to SignIn page)
        findViewById(R.id.imageBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        //Text: Sign in (Back to SignIn page)
        findViewById(R.id.textSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onBackPressed();
            }
        });

        //Spinner: Country 1
        spinner=findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //Radio box (Radio Group and Radio Button) 1
        radioGroup=findViewById(R.id.radioGroup);

        //DateTimePicker 1
        datetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateTimeDialog(datetime);
            }
        });

        //Check box
        Checkphotography=findViewById(R.id.check_photography);
        Checkplay=findViewById(R.id.check_play);
        Checkcode=findViewById(R.id.check_code);
        Checkreadandwrite=findViewById(R.id.check_readandwrite);
        Checkcookandeat=findViewById(R.id.check_cookandeat);
        Checkgarden=findViewById(R.id.check_garden);
        Checktravel=findViewById(R.id.check_travel);
        Checkwatchandlisten=findViewById(R.id.check_watchandlisten);

        Checkphotography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkphotography.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkphotography.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkphotography.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkplay.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkplay.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkplay.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkcode.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkcode.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkcode.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkreadandwrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkreadandwrite.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkreadandwrite.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkreadandwrite.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkcookandeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkcookandeat.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkcookandeat.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkcookandeat.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkgarden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkgarden.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkgarden.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkgarden.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checktravel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checktravel.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checktravel.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checktravel.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        Checkwatchandlisten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Checkwatchandlisten.isChecked()){
                    Toast.makeText(SignUpActivity.this,"Selected Checkbox: " + Checkwatchandlisten.getText(),Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(SignUpActivity.this,"Unselected Checkbox: " + Checkwatchandlisten.getText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Radio box (Radio Group and Radio Button) 2
    public void checkButton (View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton=findViewById(radioId);

        Toast.makeText(this,"Selected Radio Button: " + radioButton.getText(),Toast.LENGTH_SHORT).show();

    }

    //DateTimePicker 2
    private void showDateTimeDialog(EditText datetime) {
        Calendar calendar =Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dateOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dateOfMonth);

                TimePickerDialog.OnTimeSetListener timeSetListener=new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        datetime.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                };
                new TimePickerDialog(SignUpActivity.this,timeSetListener,calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        };
        new DatePickerDialog(SignUpActivity.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    //Spinner: Country 2
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    //Spinner: Country 3
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}