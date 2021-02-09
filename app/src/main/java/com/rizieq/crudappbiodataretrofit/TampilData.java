package com.rizieq.crudappbiodataretrofit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.rizieq.crudappbiodataretrofit.adapter.AdapterData;
import com.rizieq.crudappbiodataretrofit.api.ApiRequestBiodata;
import com.rizieq.crudappbiodataretrofit.api.Retroserver;
import com.rizieq.crudappbiodataretrofit.model.ListItem;
import com.rizieq.crudappbiodataretrofit.model.ModelData;
import com.rizieq.crudappbiodataretrofit.model.ResponseModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TampilData extends AppCompatActivity {

    private RecyclerView mRecycler;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mManager;
    private List<ModelData> mItems = new ArrayList<>();
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);

        pd = new ProgressDialog(this);
        mRecycler = findViewById(R.id.recyclerTemp);
        mManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecycler.setLayoutManager(mManager);

        pd.setMessage("Loading ...");
        pd.setCancelable(false);
        pd.show();


        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<ResponseModel> getdata = api.getBiodata();
        getdata.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                pd.hide();
                Log.d("RETRO","RESPONSE: "+response.body().getKode());
                mItems = response.body().getResult();
                mAdapter = new AdapterData(mItems,TampilData.this);
                mRecycler.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                pd.hide();
                Log.d("RETRO","FAILED : respon gagal ");
            }
        });

    }
}
