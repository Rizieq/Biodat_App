package com.rizieq.crudappbiodataretrofit.model;

import java.util.List;

public class ResponseModel {

    String kode, pesan;

    List<ModelData> result;

    public List<ModelData> getResult() {
        return result;
    }

    public void setResult(List<ModelData> result) {
        this.result = result;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
