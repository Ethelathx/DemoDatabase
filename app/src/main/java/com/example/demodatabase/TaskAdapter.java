package com.example.demodatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvID;
    private TextView tvDesc;
    private TextView tvDate;


    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);
        //Store the task that is passed to this adapter
        task = objects;
        //Store Context object as we need use it later
        this.context = context;
    }



    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Get the TextView object
        tvID = (TextView) rowView.findViewById(R.id.tvID);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        tvDesc = (TextView) rowView.findViewById(R.id.tvDesc);

        //The parameter "position" is the index of row ListView
        //is requesting. We get back the food at same index
        Task currentTask = task.get(position);

        //Set TextView to show food
        tvID.setText(""+currentTask.getId());
        tvDate.setText(currentTask.getDate());
        tvDesc.setText(currentTask.getDescription());


        //Return View to ListView
        return rowView;
    }

}
