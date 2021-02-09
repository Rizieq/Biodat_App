package com.rizieq.crudappbiodataretrofit.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rizieq.crudappbiodataretrofit.MainActivity;
import com.rizieq.crudappbiodataretrofit.R;
import com.rizieq.crudappbiodataretrofit.model.ModelData;

import java.util.List;

// todo selanjutnya

public class AdapterData extends RecyclerView.Adapter<AdapterData.MyViewHolder> {

    private List<ModelData> mList;
    private Context context;

    public AdapterData(List<ModelData> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterData.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layoutlist,viewGroup, false);
        MyViewHolder holder = new MyViewHolder(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterData.MyViewHolder myViewHolder, int i) {
        ModelData modelData = mList.get(i);
        myViewHolder.nama.setText(modelData.getNama());
        myViewHolder.usia.setText(modelData.getUsia());
        myViewHolder.domisili.setText(modelData.getDomisili());
        myViewHolder.dm = modelData;

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama, domisili, usia;
        ModelData dm;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nama = itemView.findViewById(R.id.tvNama);
            usia = itemView.findViewById(R.id.tvUsia);
            domisili = itemView.findViewById(R.id.tvDomisili);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent goInput = new Intent(context, MainActivity.class);
                    goInput.putExtra("id",dm.getId());
                    goInput.putExtra("nama",dm.getNama());
                    goInput.putExtra("usia",dm.getUsia());
                    goInput.putExtra("domisili",dm.getDomisili());

                    context.startActivity(goInput);
                }
            });


        }
    }
}
