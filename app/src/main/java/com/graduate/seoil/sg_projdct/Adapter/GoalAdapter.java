package com.graduate.seoil.sg_projdct.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.graduate.seoil.sg_projdct.PlanInformationActivity;
import com.graduate.seoil.sg_projdct.Model.Goal;
import com.graduate.seoil.sg_projdct.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.ViewHolder> {

    private Context mContext;
    private List<Goal> mGoals;

    private JSONArray jsonArray;
    private JSONObject jsonObject;

    FirebaseUser fuser;

    public GoalAdapter(Context mContext, List<Goal> mGoals) {
        this.mGoals = mGoals;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public GoalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.goallist_item, viewGroup, false);
        return new GoalAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GoalAdapter.ViewHolder viewHolder, int i) {
        final Goal goal = mGoals.get(i);
        viewHolder.goal_title.setText(goal.getTitle());
        viewHolder.goal_percentage.setText(String.valueOf(goal.getPercent_status()));
        if (goal.getTime_status() == 0) {
            viewHolder.goal_percentage.setText("00:00");
        } else {
            viewHolder.goal_percentage.setText(String.valueOf(goal.getPercent_status()));
        }


        fuser = FirebaseAuth.getInstance().getCurrentUser();

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(mContext, PlanInformationActivity.class);
                    Bundle bundle = new Bundle();

                    bundle.putString("goal_title", goal.getTitle());
                    bundle.putInt("goal_time", goal.getPlan_time());

                    intent.putExtras(bundle);

                    mContext.startActivity(intent);
                }
        });
    }

    @Override
    public int getItemCount() {
        return mGoals.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView goal_title;
        public TextView goal_percentage;
        public TextView goal_play_time;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            goal_title= itemView.findViewById(R.id.goalList_title);
            goal_percentage = itemView.findViewById(R.id.plan_percentage);
            goal_play_time = itemView.findViewById(R.id.plan_now_time);

        }
    }

}