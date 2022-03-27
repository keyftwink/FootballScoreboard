package com.example.footballscoreboard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int FirstCounter = 0;
    int SecondCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addPointToFirstTeam(View view){
        TextView firstScore = findViewById(R.id.firstscore);
        FirstCounter++;
        firstScore.setText(String.valueOf(FirstCounter));
    }

    public void addPointToSecondTeam(View view){
        TextView secondScore = findViewById(R.id.secondscore);
        SecondCounter++;
        secondScore.setText(String.valueOf(SecondCounter));
    }

    public void resetScore(View view){
        FirstCounter = 0;
        SecondCounter = 0;
        resetUI();
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("Scores", new int[] {FirstCounter, SecondCounter});
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Scores")) {
            int[] scores = savedInstanceState.getIntArray("Scores");
            FirstCounter = scores[0];
            SecondCounter = scores[1];
            resetUI();
        }
    }

    protected void resetUI(){
        TextView firstScore = findViewById(R.id.firstscore);
        firstScore.setText(String.valueOf(FirstCounter));
        TextView secondScore = findViewById(R.id.secondscore);
        secondScore.setText(String.valueOf(SecondCounter));
    }
}