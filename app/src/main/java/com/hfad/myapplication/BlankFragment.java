package com.hfad.myapplication;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private long workoutId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view=getView();

        if(view !=null){
            TextView textView=view.findViewById(R.id.titleText);
            TextView description=view.findViewById(R.id.desText);

            Workout workout= Workout.workouts[(int)workoutId];
            textView.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }

    public void setWorkoutId(long workoutId) {
        Log.d("WorkoutID", String.valueOf(workoutId));
        this.workoutId = workoutId;
    }
}
