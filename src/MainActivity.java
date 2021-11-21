package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Game game; 
    private String question; 
    private String answer;
    private int score = 0; 
    private int qNum = 1; 

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ask(); 
    }

    private void ask()
    {
        if (qNum <= 9)
        {
            game = new Game();  
            String qa = game.qa();  

            String q = qa.substring(0, qa.indexOf("\n") + 1); 
            String ans = qa.substring(qa.indexOf("\n") + 1);

            ((TextView) findViewById(R.id.question)).setText(q); 
            question = q; 
            answer = ans; 
        }

        else
        {
            ((TextView) findViewById(R.id.question)).setText(question);
        }
    }

    public void onDone(View v)
    {
        String prevUserAns = ((EditText) findViewById(R.id.answer)).getText().toString(); 

        String showInLog = String.format("%s", "Q#" + qNum + ": " + question + "Your answer: "
                           + prevUserAns.toUpperCase() + "\nThe correct answer: " + answer); 

        TextView log = findViewById(R.id.log); //var log for log textview to avoid long concat below

        log.setText(showInLog + "\n\n" + log.getText()); //PREpend string to log entry

        if (prevUserAns.equalsIgnoreCase(answer))
        {
            score++;
            ((TextView) findViewById(R.id.score)).setText("SCORE = " + score); 
        }

        ((EditText) findViewById(R.id.answer)).setText(""); 

        qNum++;
        ((TextView) findViewById(R.id.qNum)).setText("Q# " + qNum); 

        ask(); 

       if (qNum == 10)
        {
            ((TextView) findViewById(R.id.qNum)).setText("GAME OVER!");

            Button btn = findViewById(R.id.done);
            btn.setEnabled(false);  
          //  finish();
        }
    }
}
