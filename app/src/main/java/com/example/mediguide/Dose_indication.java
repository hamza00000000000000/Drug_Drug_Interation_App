package com.example.mediguide;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

public class Dose_indication extends AppCompatActivity {
    private TextView title_bar_txt , drug_name_tv, drugs_info_tv;
    private ImageButton backbtn;
    private TextInputLayout inputLayout_txt;
    private MaterialAutoCompleteTextView searched_drugs_auto_tv;
    private String drugName;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dose_indication_and_disease_info_activity);
        title_bar_txt = findViewById(R.id.title_bar_txt);
        inputLayout_txt = findViewById(R.id.drugs_TIL);
        searched_drugs_auto_tv = findViewById(R.id.auto_complete_TV);
        drug_name_tv = findViewById(R.id.searched_txt);
        drugs_info_tv = findViewById(R.id.searched_result_txt);


        inputLayout_txt.setHint("Drugs");
        title_bar_txt.setText("Dose Indication");



        backbtn = findViewById(R.id.back_btn);
        backbtn.setOnClickListener(view -> {
            startActivity(new Intent(Dose_indication.this , DashBoard.class));
            finish();
        });

        searched_drugs_auto_tv.setOnKeyListener((view, keycode, keyEvent) -> {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER)
            {
                drugName = searched_drugs_auto_tv.getText().toString();
                if (drugName.trim().isEmpty())
                {
                    Toast.makeText(this, "Please Enter the Dose name", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    drug_name_tv.setText(drugName);
                    searched_drugs_auto_tv.setText("");
                    drugs_info_tv.setText(R.string.disease_string);
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
        startActivity(new Intent(Dose_indication.this, DashBoard.class));
    }
}