package com.example.trialapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    char letter = 'X';
    Button[][] arr = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        arr[0][0] = findViewById(R.id.button);
        arr[0][1] = findViewById(R.id.button2);
        arr[0][2] = findViewById(R.id.button3);
        arr[1][0] = findViewById(R.id.button4);
        arr[1][1] = findViewById(R.id.button5);
        arr[1][2] = findViewById(R.id.button6);
        arr[2][0] = findViewById(R.id.button7);
        arr[2][1] = findViewById(R.id.button8);
        arr[2][2] = findViewById(R.id.button9);
    }
    public void reset(View v) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j].setClickable(true);
                arr[i][j].setBackgroundColor(Color.rgb(0, 0, 0));
                arr[i][j].setText(" ");
            }
        }
        TextView txt = findViewById(R.id.textView);
        txt.setText("X's TURN");
        letter = 'X';
        txt = findViewById(R.id.textView2);
        txt.setText("TIC TAC TOE");
    }
    public void pause(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(arr[i][j]!=null) {
                    arr[i][j].setClickable(false);
                }
            }
        }
    }
    public void move(View v) {
//        if(winner('X')){
//                TextView message = findViewById(R.id.textView2);
//                message.setText("X is the Winner !");
//                pause();
//        }
//        else if(winner('O')){
//                TextView message = findViewById(R.id.textView2);
//                message.setText("O is the Winner !");
//                pause();
//        }
        try {
            Button B = (Button) v;
            Log.d("kjkr", String.valueOf(letter));
            B.setText(String.valueOf(letter));
            if (letter == 'X') {
                letter = 'O';
                B.setBackgroundColor(Color.rgb(200, 50, 50));
                TextView txt = findViewById(R.id.textView);
                txt.setText("O's TURN");
            } else if (letter == 'O') {
                letter = 'X';
                B.setBackgroundColor(Color.rgb(50, 50, 200));
                TextView txt = findViewById(R.id.textView);
                txt.setText("X's TURN");
            }
            B.setClickable(false);
            if (winner('X')) {
                TextView message = findViewById(R.id.textView2);
                message.setText("X is the Winner !");
                pause();
            } else if (winner('O')) {
                TextView message = findViewById(R.id.textView2);
                message.setText("O is the Winner !");
                pause();
            }
        }catch(Exception e){
            Log.d("kjkr1234",e.toString());
        }
    }

    public boolean winner(char c) {
        char txt[][] = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                txt[i][j] = arr[i][j].getText().charAt(0);
            }
        }
        if (txt[0][0]==txt[1][1]&&txt[1][1]==txt[2][2]&&txt[2][2]==c) {
            return true;
        }
        else if((txt[0][2] == txt[1][1] && txt[1][1] == txt[2][0] && txt[2][0] == c)){
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (txt[i][0]==txt[i][1]&&txt[i][1]==txt[i][2]&&txt[i][2]==c)
                return true;
            if (txt[0][i]==txt[1][i]&&txt[1][i]==txt[2][i]&&txt[2][i]==c)
                return true;
        }
        return false;
    }
}
