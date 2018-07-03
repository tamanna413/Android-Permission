package com.example.user.androidpermissions;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.androidPermissions.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private EditText num = findViewById ( R.id.num ), Message;
    private Button button;
    private int REQUEST_CODE_SMS = 123;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main);

        Message= findViewById ( R.id.text );
        button= findViewById ( R.id.bttn );

        String[] permission = {Manifest.permission.SEND_SMS};


        if (ActivityCompat.checkSelfPermission ( this, permission[0] ) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions ( MainActivity.this, permission, REQUEST_CODE_SMS );

        }
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                String phone = num.getText ().toString ().trim ();
                String message = Message.getText ().toString ().trim ();

                SmsManager manager = SmsManager.getDefault ();
                Random r = new Random ();
                int i1 = r.nextInt ( 9999 - 1111 ) + 1111;
                String messageNumber = i1 + "";

                manager.sendTextMessage ( phone, null, message, null, null );


                Intent intent = new Intent ( MainActivity.this, Main2Activity.class );
                intent.putExtra ( "message", messageNumber );
                startActivity ( intent );
            }

        } );


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult ( requestCode, permissions, grantResults );

        if(requestCode == REQUEST_CODE_SMS){

            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Toast.makeText ( MainActivity.this, "permission granted", Toast.LENGTH_SHORT ).show ();

                //show your tast permission mil gaya

            }else{
                Toast.makeText ( MainActivity.this,"Not granted",Toast.LENGTH_SHORT ).show ();

                //show denied toast
            }

        }

    }
}
