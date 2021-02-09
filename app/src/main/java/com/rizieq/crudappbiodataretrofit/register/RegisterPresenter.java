package com.rizieq.crudappbiodataretrofit.register;

import android.widget.Toast;

import com.rizieq.crudappbiodataretrofit.api.ApiRequestBiodata;
import com.rizieq.crudappbiodataretrofit.api.Retroserver;
import com.rizieq.crudappbiodataretrofit.model.ResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterPresenter implements RegisterContract.Presenter {

    RegisterContract.View view;

    public RegisterPresenter(RegisterContract.View view) {
        this.view = view;
    }

    @Override
    public void addRegister(String nama, String usia, String domisili) {

        ApiRequestBiodata api = Retroserver.getClient().create(ApiRequestBiodata.class);
        Call<ResponseModel> sendbio = api.sendBiodata(nama, usia, domisili);
        sendbio.enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                String kode = response.body().getKode();

                if (kode.equals("1")){
                    view.onSuccess(response.toString());
                } else {
                    view.onFailed(response.toString());
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                view.onFailure();

            }
        });

    }
}
