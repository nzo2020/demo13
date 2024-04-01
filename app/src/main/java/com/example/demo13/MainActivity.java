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
    Button bt1, bt2, bt3, bt4, bt5, bt6;
    EditText etn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etn1 = findViewById(R.id.etn1);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);
        bt5 = findViewById(R.id.bt5);
        bt6 = findViewById(R.id.bt6);
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
            if (action=="/"){
                result=result/num;
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
        int countP=0;
        if(input.charAt(0)=='-' || (input.charAt(0)<='9' && input.charAt(0)>='0')|| (input.charAt(0)=='.')){
            if (input.charAt(0)=='.'){
                countP++;
            }
            for(int j=1; j<input.length(); j++){
                if (input.charAt(j)>'9' || input.charAt(j)<'0'){
                    return false;
                }
                if (input.charAt(j)=='.'){
                    countP++;
                }
                if (countP>1){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    public void clickedAdd(View view) {
        calcResult();
        etn1.setText("");
        action="+";
    }

    public void clickedSub(View view) {
        calcResult();
        etn1.setText("");
        action="-";
    }

    public void clickedMul(View view) {
        calcResult();
        etn1.setText("");
        action="*";
    }

    public void clickedDiv(View view) {
        calcResult();
        etn1.setText("");
        action="/";
    }

    public void clickedAc(View view) {
        result = 0;
        num=0;
        action="+";
        etn1.setText("");
    }

    public void clickedEqual(View view) {
        num = Double.parseDouble(etn1.getText().toString());
        calcResult();
        etn1.setText(String.valueOf(result));
        action="=";
    }


    public void clicked7(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("result", String.valueOf(result));
        startActivity(intent);
    }
}


