package com.rizieq.crudappbiodataretrofit.model;


import com.google.gson.annotations.SerializedName;


public class ModelData {

	@SerializedName("usia")
	private String usia;

	@SerializedName("nama")
	private String nama;

	@SerializedName("id")
	private String id;

	@SerializedName("domisili")
	private String domisili;

	public void setUsia(String usia){
		this.usia = usia;
	}

	public String getUsia(){
		return usia;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setDomisili(String domisili){
		this.domisili = domisili;
	}

	public String getDomisili(){
		return domisili;
	}
}