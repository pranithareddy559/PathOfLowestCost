package com.kata.pranitha.pathoflowestcost;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button submitButton;
    public AlertDialog.Builder alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText= (EditText)findViewById(R.id.path_input);
        submitButton= (Button)findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSubmitButtonClick();
            }
        });
    }
    private void onSubmitButtonClick()
    {
        String inputText = editText.getText().toString();
        PathResult pathResult=PathCalculationUtils.calculateLowestCostPath(inputText);
        if(pathResult!=null)
        {
            displayResult(getString(R.string.result_title),String.valueOf(pathResult.isValidPath)+"\n"+String.valueOf(pathResult.lowestCost)+"\n"+String.valueOf(pathResult.lowestCostPath));
        }
        else
        {
            displayResult(getString(R.string.invalid_input_title),getString(R.string.invalid_input_msg));
        }
    }

    private void displayResult(String title,String message)
    {
       alertDialog= new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }
}
