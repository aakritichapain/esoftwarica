package com.aakriti.esoftwarica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.aakriti.esoftwarica.ui.home.HomeFragment;

import java.util.List;

public class StudentsActivity extends RecyclerView.Adapter<StudentsActivity.studentViewHolder> {

    Context mContext;
    List<Students>studentsList;

    public StudentsActivity(Context mContext, List<Students>studentsList){
        this.mContext=mContext;
        this.studentsList=studentsList;
    }

    @NonNull
    @Override
    public studentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_students,parent,false);
        return  new studentViewHolder(view);

    }
//
    @Override
    public void onBindViewHolder(@NonNull studentViewHolder holder, final int position) {
        final Students students=studentsList.get(position);
        holder.tvName.setText(students.getName());
        holder.tvAddress.setText(students.getAddress());
        holder.tvGender.setText(students.getGender());
        holder.tvAge.setText(Integer.toString(students.getAge()));



        holder.imgRemove.setImageDrawable(mContext.getResources().getDrawable(R.drawable.delete));
        String gender=students.getGender();
        if (gender=="male") {

            holder.imgProfile.setImageResource(R.drawable.male);
        }
        else if(gender=="female"){
            holder.imgProfile.setImageResource(R.drawable.female);
        }
        else {
            holder.imgProfile.setImageDrawable(mContext.getResources().getDrawable(R.drawable.female));
        }

        holder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"hi"+students.getName(),Toast.LENGTH_SHORT).show();
            }
        });

        holder.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Students stu=studentsList.get(position);
                studentsList.remove(position);
                notifyItemRemoved(position);
                Toast.makeText(mContext,"Removed:"+stu.getName(),Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    public class studentViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvAddress,tvAge,tvGender;
        ImageView imgProfile,imgRemove;

        public studentViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.tvname);
            tvAddress=itemView.findViewById(R.id.tvaddress);
            tvAge=itemView.findViewById(R.id.tvage);
            tvGender=itemView.findViewById(R.id.tvgender);
            imgProfile=itemView.findViewById(R.id.imgprofile);
            imgRemove=itemView.findViewById(R.id.imgremove);

        }
    }
}
