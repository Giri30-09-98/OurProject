package com.example.prohelpr.workers;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prohelpr.R;

import java.util.List;

public class WorkersBookingDataAdapter extends RecyclerView.Adapter<WorkersBookingDataAdapter.WorkersBookingDataViewHolder> {
    List<booking_model> booking_models;
    Context ctx;

    public WorkersBookingDataAdapter(List<booking_model> models, Context ctx) {
        this.booking_models = models;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public WorkersBookingDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WorkersBookingDataViewHolder(LayoutInflater.from(ctx)
                .inflate(R.layout.workers_booking_data_adapter,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull WorkersBookingDataViewHolder holder, int position) {
        holder.obj_w_name_booking.setText(booking_models.get(position).w_name);
        holder.obj_category_booking.setText(booking_models.get(position).w_category);
        holder.obj_charge_booking.setText(booking_models.get(position).charge);


        holder.obj_contact_booking.setText(booking_models.get(position).contact);
        holder.obj_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s_worker_name= booking_models.get(position).getW_name();
                String s_category= booking_models.get(position).getW_category();
                String s_charge= booking_models.get(position).getCharge();


                String s_contact= booking_models.get(position).getContact();





                Intent intent=new Intent(ctx,worker_booking_data.class);
                intent.putExtra("key_w_name",s_worker_name);
                intent.putExtra("key_w_category",s_category);
                intent.putExtra("key_w_amount",s_charge);


                intent.putExtra("key_w_contact",s_contact);






                ctx.startActivity(intent);

            }
        });
        /*holder.obj_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

    }

    @Override
    public int getItemCount() {
        return booking_models.size();
    }

    public class WorkersBookingDataViewHolder extends RecyclerView.ViewHolder {
        TextView obj_w_name_booking,obj_category_booking,obj_charge_booking,obj_contact_booking;
        Button obj_save,obj_cancel;

        public WorkersBookingDataViewHolder(@NonNull View itemView) {
            super(itemView);

            obj_w_name_booking=itemView.findViewById(R.id.w_name_booking);
            obj_category_booking=itemView.findViewById(R.id.category_booking);
            obj_charge_booking=itemView.findViewById(R.id.charge_booking);


            obj_contact_booking=itemView.findViewById(R.id.contact_booking);
            obj_save=itemView.findViewById(R.id.save_booking);
            //obj_cancel=itemView.findViewById(R.id.cancel_booking);
        }
    }
}