package com.rizieq.crudappbiodataretrofit.register;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rizieq.crudappbiodataretrofit.R;
import com.rizieq.crudappbiodataretrofit.TampilData;

public class RegisterActivity extends AppCompatActivity implements RegisterContract.View {

    RegisterPresenter registerPresenter;
    EditText nama, usia, domisili;
    Button btnRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nama = findViewById(R.id.edt_nama_reg);
        usia = findViewById(R.id.edt_usia_reg);
        domisili = findViewById(R.id.edt_domisili_reg);

        btnRegister = findViewById(R.id.btn_reg);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPresenter.addRegister(nama.getText().toString(),usia.getText().toString(),domisili.getText().toString());
                startActivity(new Intent(RegisterActivity.this, TampilData.class));
            }
        });



    }

    @Override
    public void onSuccess(String message) {
        Toast.makeText(this, "Berhasil", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailed(String message) {
        Toast.makeText(this, "Gagal", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {
        Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();

    }
}
