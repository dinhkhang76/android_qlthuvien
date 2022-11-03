package com.ledinhkhang.qltv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ledinhkhang_activityLogin extends AppCompatActivity {
    Button btn;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ledinhkhang_login);

        btn = findViewById(R.id.btDangNhap);
        email = findViewById(R.id.etSoLuong);
        password = findViewById(R.id.etPassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString();
                String mk = password.getText().toString();
                if(mail.equals("dinhkhang") && mk.equals("123456") )
                {
                    Intent intent = new Intent(ledinhkhang_activityLogin.this, ledinhkhang_activitymain.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(),"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                    
                    Toast.makeText(getApplicationContext(),"Xin chào, Lê Đình Khang",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(ledinhkhang_activityLogin.this, "Tài khoản hoặc mật khẩu không đúng!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}