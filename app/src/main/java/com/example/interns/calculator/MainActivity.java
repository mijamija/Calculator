package com.example.interns.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView screen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=(TextView) findViewById(R.id.textView);
        screen.setText("");

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
            if((temp.charAt(temp.length()-1) != '+')&&(temp.charAt(temp.length()-1) != '-')
                &&(temp.charAt(temp.length()-1) != '*')&&(temp.charAt(temp.length()-1) != '/')
                &&(temp.charAt(temp.length()-1) != '.'))
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
        String temp=screen.getText().toString();

        if(temp != "")
        if((temp.charAt(temp.length()-1) != '+')&&(temp.charAt(temp.length()-1) != '-')
                &&(temp.charAt(temp.length()-1) != '*')&&(temp.charAt(temp.length()-1) != '/')
                &&(temp.charAt(temp.length()-1) != '.'))
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

    public void Dot(View view)
    {
        Button button = (Button) view;
        String temp = screen.getText().toString();
        if(temp != "")
        {
            if((temp.charAt(temp.length()-1) != '+')&&(temp.charAt(temp.length()-1) != '-')
                    &&(temp.charAt(temp.length()-1) != '*')&&(temp.charAt(temp.length()-1) != '/')
                    &&(temp.charAt(temp.length()-1) != '.'))
            {
                if(isThereDot(temp))
                    screen.setText(temp + button.getText().toString());
            }
        }
    }

    public boolean isThereDot(String string)
    {
        boolean flagDot=false;

        for(int i=string.length()-1;i>=0;i--)
        {
            if(((string.charAt(i) == '+')||(string.charAt(i) == '-')||(string.charAt(i) == '*')||(string.charAt(i) == '+'))
                    &&flagDot==false)
                return true;
            if(string.charAt(i)=='.' && flagDot==false)
                flagDot=true;
            if(string.charAt(i)=='.' && flagDot==true)
                return false;
        }
        return true;
    }

    public boolean isOnlyNumber(String string)
    {
        for(int i=0;i<string.length();i++)
        {
            if((string.charAt(i) < '0' || string.charAt(i) > '9')&& string.charAt(i) != '.')
                return false;
        }
        return true;
    }

    public String calculate(String string)
    {
        double number1,number2,resultDouble;
        int k;
        String result;

        for(int i=0;;i++)
        {
            if((string.charAt(i)<'0' || string.charAt(i)>'9') && string.charAt(i) != '.')
            {
                number1=Double.parseDouble(string.substring(0,i));
                k=i;
                break;
            }
        }

        number2=Double.parseDouble(string.substring(k+1,string.length()));

        if(string.charAt(k)=='+')
            resultDouble=number1+number2;
        else if(string.charAt(k)=='-')
            resultDouble=number1-number2;
        else if(string.charAt(k)=='*')
            resultDouble=number1*number2;
        else
        {
            if(number2==0)
            {
                Toast.makeText(this, "Don't devide with zero!!!", Toast.LENGTH_SHORT).show();
                return string.substring(0,string.length()-1);
            }
            else
            resultDouble = number1 / number2;
        }

        result=""+resultDouble;

        return result;
    }
}
