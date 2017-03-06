package com.example.interns.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=(TextView) findViewById(R.id.textView);

    }

    public void youClickedNumber(View view)
    {
        Button button = (Button) view;
        screen.setText(screen.getText().toString() + button.getText().toString());
    }

    public void youClickedOperator(View view)
    {
        Button button = (Button) view;
        String temp = screen.getText().toString();
        if(temp != "")
        {
            if((temp.substring(temp.length()-1) != "+")&&(temp.substring(temp.length()-1) != "-")
                &&(temp.substring(temp.length()-1) != "*")&&(temp.substring(temp.length()-1) != "/")
                &&(temp.substring(temp.length()-1) != "."))
            {
                if(isOnlyNumber(temp))
                    screen.setText(temp + button.getText().toString());
                else
                {
                    screen.setText(calculate(temp));
                }
            }
        }

    }

    public void Equal(View view)
    {
        screen.setText(calculate(screen.getText().toString()));
    }

    public void Clear(View view)
    {
        screen.setText("");
    }

    public void Delete(View view)
    {
        String temp=screen.getText().toString();
        if(screen.getText().toString() != "")
        {
            screen.setText(temp.substring(0,temp.length()-1));
        }
    }

    public boolean isOnlyNumber(String string)
    {
        for(int i=0;i<string.length();i++)
        {
            if(string.charAt(i) < 0 || string.charAt(i) > 9)
                return false;
        }
        return true;
    }

    public String calculate(String string)
    {
        int number1,number2;
        String temp="", result="";

        for(int i=0;i<string.length();i++)
        {
            
        }

        return result;
    }
}
