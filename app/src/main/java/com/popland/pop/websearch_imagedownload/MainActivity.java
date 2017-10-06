package com.popland.pop.websearch_imagedownload;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView IV;
EditText EDT;
ImageButton IB;
TextView TV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IV = (ImageView)findViewById(R.id.IV);
        EDT = (EditText)findViewById(R.id.EDT);
        IB = (ImageButton)findViewById(R.id.IB);
        TV = (TextView)findViewById(R.id.TV);

        IV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EDT.setVisibility(View.VISIBLE);
                IB.setVisibility(View.VISIBLE);
            }
        });

        IB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = EDT.getText().toString() + " png transparent background";
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                //intent.setType("image/*");
                intent.setData(Uri.parse("https://www.google.com/search?safe=active&tbm=isch&q="+search));
                startActivityForResult(intent,999);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if( requestCode==999 && resultCode==RESULT_OK){
            String kq = data.getDataString();
            TV.setText(kq);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
