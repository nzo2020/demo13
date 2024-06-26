package com.example.demo13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double num = 0, result = 0;
    String action="+";
    EditText etn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn1 = findViewById(R.id.etn1);
    }
    public void calcResult(){
        if (isValidNum()){
            if (action!="=") {
                num = Double.parseDouble(etn1.getText().toString());
            }else{
                num=0;
            }
            if (action=="+"){
                result=result+num;
            }
            if (action=="-"){
                result=result-num;
            }
            if (action=="*"){
                result=result*num;
            }
            if (action=="/" ){
                if (num!=0){
                    result=result/num;
                }else{
                    Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
                    result=0;
                    action="+";
                }
            }
        }else{
            Toast.makeText(this, "wrong input", Toast.LENGTH_SHORT).show();
            result=0;
            num=0;
            action="+";
        }




    }

    public boolean isValidNum(){
            String input = etn1.getText().toString();

            return !((input.equals("")) ||
                    (input.equals("-") )||
                    (input.equals(".")) ||
                    (input.equals("+")) ||
                    (input.equals("-.")));
    }

    public void clickedAdd(View view) {
        if (!etn1.getText().toString().isEmpty()){
            calcResult();
            etn1.setText("");
        }
        action="+";
    }

    public void clickedSub(View view) {
        if (!etn1.getText().toString().isEmpty()){
            calcResult();
            etn1.setText("");
        }
        action="-";
    }

    public void clickedMul(View view) {
        if (!etn1.getText().toString().isEmpty()) {
            calcResult();
            etn1.setText("");
        }
        action="*";
    }

    public void clickedDiv(View view) {
        if (!etn1.getText().toString().isEmpty()) {
            calcResult();
            etn1.setText("");
        }
        action="/";
    }

    public void clickedAc(View view) {
        result = 0;
        num=0;
        action="+";
        etn1.setText("");
    }

    public void clickedEqual(View view) {
        if (!etn1.getText().toString().isEmpty()) {
            num = Double.parseDouble(etn1.getText().toString());
            calcResult();
        }
        etn1.setText(String.valueOf(result));
        action = "=";
    }



    public void clicked7(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}


