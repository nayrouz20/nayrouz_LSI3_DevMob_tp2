package com.example.weslati_nayrouz_tp1.view;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.weslati_nayrouz_tp1.R;

public class ConsultActivity extends AppCompatActivity {
    private TextView tvResponse;
    private Button btnReturn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        init();

        Intent intent=getIntent();
        String reponse = intent.getStringExtra("result");
        tvResponse.setText(reponse);

        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent();
                if(reponse!=null)
                    setResult(RESULT_OK, intent);
                else
                    setResult(RESULT_CANCELED, intent);
            }
        });

    }

    private void init(){
        tvResponse=(TextView)findViewById(R.id.tvReponse);
        btnReturn=(Button) findViewById(R.id.btnReturn);
    }
}