package com.rizieq.crudappbiodataretrofit.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ListItem {

	@SerializedName("result")
	private List<ModelData> result;

	@SerializedName("code")
	private int kode;

	public void setResult(List<ModelData> result){
		this.result = result;
	}

	public List<ModelData> getResult(){
		return result;
	}

	public void setKode(int kode){
		this.kode = kode;
	}

	public int getKode(){
		return kode;
	}
}