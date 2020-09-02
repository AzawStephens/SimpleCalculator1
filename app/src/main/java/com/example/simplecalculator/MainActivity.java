package com.example.simplecalculator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public void clickedNumber(View button)
{
    TextView display = findViewById(R.id.displayTextView);
    int numberOnButton = Integer.parseInt(button.getTag().toString());
    switch(numberOnButton){
        case(1):
        {
            display.append("1");
            break;
        }
        case(2):
        {
            display.append("2");
            break;
        }
        case(3):
        {
            display.append("3");
            break;
        } case(4):
        {
            display.append("4");
            break;
        } case(5):
        {
            display.append("5");
            break;
        } case(6):
        {
            display.append("6");
            break;
        } case(7):
        {
            display.append("7");
            break;
        } case(8):
        {
            display.append("8");
            break;
        } case(9):
        {
            display.append("9");
            break;
        }
        case(0):
        {
            display.append("0");
            break;
        }
        case(11):
        {
            display.append("+");
            break;
        }
        case(12):
        {
            display.append("-");
            break;
        }
        case(13):
        {
            display.append("*");
            break;
        }
        case(14):
        {
            display.append("/");
            break;
        }
        case(16):
        {
            display.setText("");
            break;
        }
    }
}

@RequiresApi(api = Build.VERSION_CODES.N)
public void Equals(View equalsButton)
{
    TextView display = findViewById(R.id.displayTextView);
    String whatsOnTheDisplay = display.getText().toString();
    int answer = 0;

    if(whatsOnTheDisplay.contains("+"))
    {
        String[] chars = whatsOnTheDisplay.split("\\+");
        for(String sequence : chars)
        {
            int number = Integer.parseInt(sequence);
            answer+= number;
        }
        display.setText(String.valueOf(answer));
    }if(whatsOnTheDisplay.contains("-"))
    {
        String[] chars = whatsOnTheDisplay.split("-");

        int total;
        int number = Integer.parseInt(chars[0]);
        int secondNum = Integer.parseInt(chars[1]);
        answer =   number - secondNum;
        if(chars.length > 2)
        {
            for(int i = 2; i < chars.length; ++i)
            {
                total = answer-Integer.parseInt(chars[i]);
                answer = total;
            }
        }
        display.setText(String.valueOf(answer));
    }if(whatsOnTheDisplay.contains("*"))
    {
        int answerHere = 1;
        String[] chars = whatsOnTheDisplay.split("\\*");
        for(String sequence : chars)
        {
            int number = Integer.parseInt(sequence);
            answerHere *= number;
        }
        display.setText(String.valueOf(answerHere));
    }if(whatsOnTheDisplay.contains("/"))
    {
        String[] chars = whatsOnTheDisplay.split("/");
        double numberOne = Double.parseDouble(chars[0]);
        double numberTwo = Double.parseDouble(chars[1]);
        double answerHere = numberOne / numberTwo;
        double total;
        if(chars.length > 2)
        {
            for(int i = 2; i< chars.length;++i)
            {
                total = answerHere / Double.parseDouble(chars[i]);
                answerHere = total;
            }
        }
        display.setText(String.valueOf(answerHere));
    }
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}