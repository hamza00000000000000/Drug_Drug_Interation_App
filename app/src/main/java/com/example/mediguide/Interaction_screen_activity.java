package com.example.mediguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.MaterialAutoCompleteTextView;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Interaction_screen_activity extends AppCompatActivity {

    MaterialAutoCompleteTextView drug_Auto_Com_TV;
    Button check_interaction , clear_btn;
    static ListView listView;
    private TextView result_txt;
    private ImageButton backbtn;
    static ArrayList<Data_Model> medicines_list;
    ArrayAdapter<String> auto_complete_Adapter ;
    static Adapter listview_Adapter;
    String medicines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interaction_screen_activity);
        drug_Auto_Com_TV = findViewById(R.id.drugs);
        check_interaction = findViewById(R.id.check_interaction);
        clear_btn = findViewById(R.id.clear_btn);
        result_txt = findViewById(R.id.result_txt);
//        ActionBar actionbar = getSupportActionBar();
//        actionbar.setTitle("Drug Interaction");
//        actionbar.setDisplayHomeAsUpEnabled(true);
//        actionbar.setDisplayShowHomeEnabled(true);


        backbtn = findViewById(R.id.back_btn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Interaction_screen_activity.this , DashBoard.class));
                finish();
            }
        });


        listView = findViewById(R.id.listView);

        medicines_list = new ArrayList<Data_Model>();
        String[] names = getResources().getStringArray(R.array.names);

        auto_complete_Adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
        drug_Auto_Com_TV.setAdapter(auto_complete_Adapter);

        if (medicines_list.isEmpty())
        {
            Toast.makeText(this, "List is empty", Toast.LENGTH_SHORT).show();
        }
        
        drug_Auto_Com_TV.setOnKeyListener((view, keycode, keyEvent) -> {
            if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && keycode == KeyEvent.KEYCODE_ENTER)
            {

                medicines = drug_Auto_Com_TV.getText().toString().trim();

                if(medicines_list.size() == 5)
                {
                    Toast.makeText(Interaction_screen_activity.this, "Sorry! we can check interactions for at most 5 drugs", Toast.LENGTH_SHORT).show();
                    InputMethodManager close_keyboard = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
                    close_keyboard.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY , 0);
                }

                else
                {
                    if(medicines.isEmpty())
                    {
                        Toast.makeText(Interaction_screen_activity.this, "Pleas Enter Medicine", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        medicines_list.add(new Data_Model(medicines , R.drawable.remove_icon));
                        listview_Adapter = new Adapter(Interaction_screen_activity.this , medicines_list);
                        //listview_Adapter = new ArrayAdapter<String> (Interaction_screen_activity.this, R.layout.data_model, medicines_list);
                        listView.setPadding(10 , 10, 10, 10);
                        listView.setAdapter(listview_Adapter);
                        listView.setBackground(getResources().getDrawable(R.drawable.list_view));
                        result_txt.setText("");
                        drug_Auto_Com_TV.setText("");
                      //Toast.makeText(Interaction_screen_activity.this, "Size of ArrayList is : "+medicines_list.size(), Toast.LENGTH_SHORT).show();
                    }
                }
                return true;
            }
           return false;
        });
        
        
        check_interaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result_txt.setText(R.string.result);
                clear_drugs_list();
            }
        });

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               clear_drugs_list();

            }
        });

    }

    private void clear_drugs_list()
    {
        medicines_list.clear();
        listView.setPadding(0,0,0,0);
        listView.setBackground(null);
        listView.setAdapter(null);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Interaction_screen_activity.this, DashBoard.class));
    }

//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case android.R.id.home:
//                startActivity(new Intent(Interaction_screen_activity.this , DashBoard.class));
//                finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }


}