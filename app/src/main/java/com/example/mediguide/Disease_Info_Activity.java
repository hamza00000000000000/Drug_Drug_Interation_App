package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

public class Disease_Info_Activity extends AppCompatActivity {

    private TextView title_bar_txt , disease_name_tv , disease_info_tv;
    private MaterialAutoCompleteTextView searched_disease_auto_tv;
    private TextInputLayout inputLayout_txt;
    private ImageButton backbtn;
    private String diseaseName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dose_indication_and_disease_info_activity);
        title_bar_txt = findViewById(R.id.title_bar_txt);
        inputLayout_txt = findViewById(R.id.drugs_TIL);
        searched_disease_auto_tv = findViewById(R.id.auto_complete_TV);
        disease_name_tv =findViewById(R.id.searched_txt);
        disease_info_tv = findViewById(R.id.searched_result_txt);



        inputLayout_txt.setHint("type here");
        title_bar_txt.setText("Disease Information");

        backbtn = findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Disease_Info_Activity.this , DashBoard.class));
                finish();
            }
        });


        searched_disease_auto_tv.setOnKeyListener((view, keycode, keyEvent) -> {
            if(keyEvent.getAction() == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER)
            {
                diseaseName = searched_disease_auto_tv.getText().toString();
                if(diseaseName.trim().isEmpty())
                {
                    Toast.makeText(this, "Please Enter Disease Name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    searched_disease_auto_tv.setText("");
                    disease_name_tv.setText(diseaseName);
                    disease_info_tv.setText(R.string.disease_string);
                    InputMethodManager close_keyboard = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    close_keyboard.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY , 0);
                }

                return true;
            }
            return false;
        });

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Disease_Info_Activity.this, DashBoard.class));
    }

}