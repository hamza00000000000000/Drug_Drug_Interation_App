package com.example.mediguide;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Data_Model> {

    ArrayList<Data_Model> arrayList = Interaction_screen_activity.medicines_list; // to get arraylist from the interaction_screen_activity
    ListView listView = Interaction_screen_activity.listView;
    public Adapter(Activity context , ArrayList<Data_Model> dataModels)
    {
        super(context , 0 , dataModels);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if(view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.data_model , parent , false);
        }

        Data_Model medicine_model = getItem(position);

        TextView medicine_name = view.findViewById(R.id.medicine_name_txt);
        medicine_name.setText(medicine_model.getMedicine_name());
        ImageView remove_img = view.findViewById(R.id.remove_icon);
        remove_img.setImageResource(medicine_model.getRemove_img());


        // TO delete item from listview as well arraylist
        remove_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(position); // remove clicked item from the listview
                if(arrayList.isEmpty())
                {
                    listView.setPadding(0 , 0, 0,0);
                    listView.setBackground(null);
                }
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
