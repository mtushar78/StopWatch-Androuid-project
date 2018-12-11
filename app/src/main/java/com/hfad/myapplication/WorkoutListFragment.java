package com.hfad.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {


    public WorkoutListFragment() {

    }
    static interface WorkoutListListner{
        void onItemClicked(long id);
    }
    private WorkoutListListner workoutListListner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        String[] name= new String[Workout.workouts.length];

        for(int i=0;i<name.length;i++){
            name[i]=Workout.workouts[i].getName();
        }
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(inflater.getContext(), android.R.layout.simple_list_item_1,name);
        setListAdapter(arrayAdapter);

        return inflater.inflate(R.layout.fragment_workout_list, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.workoutListListner= (WorkoutListListner) context;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        if(workoutListListner !=null){
            workoutListListner.onItemClicked(id);
        }
    }
}
