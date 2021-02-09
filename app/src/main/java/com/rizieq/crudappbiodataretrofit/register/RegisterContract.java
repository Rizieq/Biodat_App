package com.rizieq.crudappbiodataretrofit.register;

public interface RegisterContract {

    interface View{
        void onSuccess(String message);
        void onFailed(String message);
        void onFailure();
    }

    interface Presenter{
        void addRegister(String nama, String usia, String domisili);
    }
}
