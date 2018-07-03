package com.example.user.androidpermissions;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.androidPermissions.R;

public class Main2Activity extends AppCompatActivity {
    EditText OTP;
    Button button;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );

        OTP = findViewById ( R.id.OTP );
        button = findViewById ( R.id.OTPButton );

        String message = getIntent ().getStringExtra ( "message" );

        final int x = Integer.valueOf ( message );


        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String UserOTP = OTP.getText ().toString ().trim ();
                Integer y = Integer.valueOf ( UserOTP );

                if (x == y) {
                    Toast.makeText ( Main2Activity.this, "Submittted Sucessfully", Toast.LENGTH_SHORT ).show ();

                } else {

                    Toast.makeText ( Main2Activity.this, "Wrong OTP", Toast.LENGTH_SHORT ).show ();
                }
            }

        } );
    }
}
