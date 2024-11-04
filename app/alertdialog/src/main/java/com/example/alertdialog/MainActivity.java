package com.example.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonDefine = findViewById(R.id.buttonDefine);

        LayoutInflater inflater = getLayoutInflater();
        View definedView = inflater.inflate(R.layout.self_defined, null, false);
        buttonDefine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(R.mipmap.ic_launcher);
                builder.setTitle("ANDROID APP");
                builder.setView(definedView);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText1 = definedView.findViewById(R.id.editTextText1);
                        EditText editText2 = definedView.findViewById(R.id.editTextText2);
                        String str = editText1.getText().toString().trim();
                        String str1 = editText2.getText().toString().trim();
                        Toast.makeText(MainActivity.this, "username" + str, Toast.LENGTH_SHORT).show();
                        Toast.makeText(MainActivity.this, "passward" + str1, Toast.LENGTH_SHORT).show();
                    }

                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
}