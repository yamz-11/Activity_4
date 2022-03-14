package com.example.activity_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Deklarasi Variabel Untuk Button
    Button btnlogin;

    //Deklarasi Variabel Untuk EditText
    EditText edemail, edpassword;

    String nama, password;
    String isiNama = "Wira";
    String isiPass = "123";

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //method untuk menapilkan menu
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(MainActivity.this, DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnLogin dengan componen button pada Layout
        btnlogin=findViewById(R.id.btSignin);

        //Menghubungkan variabel edemail dengan componen button pada Layout
        edemail=findViewById(R.id.edEmail);

        //Menghubungkan variabel edpassword dengan componen button pada Layout
        edpassword=findViewById(R.id.edPassword);

        //membuat fungsi onclick pada button btnLogin
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                if(nama.isEmpty() ){
                    edemail.setError("Email Diperlukan");
                }
                else if(password.isEmpty()){
                    edpassword.setError("Password Diperlukan");
                }

                else{
                    if(!nama.equals(isiNama) && !password.equals(isiPass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Email atau Password Salah!",Toast.LENGTH_LONG);
                        t.show();
                    }
                    else if(!nama.equals(isiNama)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Username Salah!",Toast.LENGTH_LONG);
                        t.show();
                    }
                    else if(!password.equals(isiPass)){
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Password Salah!",Toast.LENGTH_LONG);
                        t.show();
                    }

                    else{
                        Bundle b = new Bundle();

                        b.putString("a", nama.trim());

                        b.putString("b", password.trim());

                        Intent i = new Intent(getApplicationContext(), home.class);

                        i.putExtras(b);

                        startActivity(i);
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses", Toast.LENGTH_LONG);

                        t.show();

                        edemail.getText().clear();
                        edpassword.getText().clear();

                    }

                }
            }
        });

    }
}