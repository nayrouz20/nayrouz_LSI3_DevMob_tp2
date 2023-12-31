package com.example.weslati_nayrouz_tp1.view;

import static android.os.Build.VERSION_CODES.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weslati_nayrouz_tp1.R;
import com.example.weslati_nayrouz_tp1.controller.Controller;

public class MainActivity extends AppCompatActivity {

    private TextView age=null,res=null;
    //private TextVien tvage;tvresult;
    private SeekBar sbage =null;
    //private SeekBar sbage;
    private RadioGroup rbGrp=null;
    private RadioButton rboui=null,rbnon=null;
    private EditText vm=null;
    private Button btn= null;
    private boolean jeuner;
    private final int REQUEST_CODE = 1;

    Controller controller = Controller.getInstance();
    @Override
    //public void main
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();


        sbage.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("information", "onProgressChanged:"+progress);
                age.setText("Votre age : "+sbage.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Start tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    private void init(){

        age = (TextView) findViewById(R.id.age);
        sbage =(SeekBar) findViewById(R.id.sbage);
        btn= (Button) findViewById(R.id.btn);
        vm= (EditText) findViewById(R.id.vm);
        // rbGrp=(RadioGroup) findViewById(R.id.rbGrp);
        rbnon=(RadioButton)findViewById(R.id.rbnon);
        rboui=(RadioButton)findViewById(R.id.rboui);
        res= (TextView) findViewById(R.id.trResult);
    }
    public void calculer(View v){

        int age;
        double vM;
        boolean veriAge=false,verifValeur=false;

        if(sbage.getProgress() != 0){
            veriAge=true;
        }else {
            Toast.makeText(this, "Veuillez vérifier votre age", Toast.LENGTH_SHORT).show();
        }
        if (!vm.getText().toString().isEmpty()){
            verifValeur=true;
        }else{
            Toast.makeText(this, "Veuillez vérifier votr valeur muserée", Toast.LENGTH_LONG).show();
        }
        if (veriAge && verifValeur){
            age = sbage.getProgress();
            vM = Double.valueOf(vm.getText().toString());
            if(rboui.isChecked()){
                if (age>=13){
                    if(vM < 5.0){
                        res.setText("Niveau de glycemie est bas");
                    }else if (vM >= 5.0 && vM <= 7.2){
                        res.setText("Niveau de glycemie est normale");
                    }else {
                        res.setText("Niveau de glycemie est trop elevée");
                    }
                } else if (age >= 6 && age <= 12) {
                    if (vM < 5.0){
                        res.setText("Niveau de glycemie est trop bas");
                    } else if (vM >= 5.0 && vM<=10.0) {
                        res.setText("Niveau de glycemie est normale");
                    }else {
                        res.setText("Niveau de glycemie est trop elevée");
                    }
                }else{
                    if (vM < 5.5){
                        res.setText("Niveau de glycemie est trop bas");
                    } else if (vM >= 5.5 && vM <= 10.0) {
                        res.setText("Niveau de glycemie est normale");
                    }else {
                        res.setText("Niveau de glycemie est trop elevée");
                    }
                }

            } else if (vM < 10.5) {
                res.setText("Niveau de glycemmie est normale");
            }else {
                res.setText("Niveau de glycemie est elevée");
            }
            // useraction view vers controller 2/2
            controller.createPt(age, (float) vM, rboui.isChecked());
            //notify controller vers view 2/2

            Intent intent = new Intent(MainActivity.this, ConsultActivity.class);
            intent.putExtra("result",Controller.getInstance().getResponse());
            startActivityForResult(intent, REQUEST_CODE);
        }
    }
    protected void onActiviyResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_CODE)
            if(resultCode == RESULT_CANCELED)
                Toast.makeText(MainActivity.this, "Erreur", Toast.LENGTH_SHORT).show();
    }
}