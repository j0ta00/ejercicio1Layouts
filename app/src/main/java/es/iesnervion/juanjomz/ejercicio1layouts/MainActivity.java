package es.iesnervion.juanjomz.ejercicio1layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    Button btnSumOpt,btnSubsOpt,btnMultOpt,btnDivOpt,btnNumber1,
    btnNumber2,btnNumber3,btnNumber4,btnNumber5,btnNumber6,btnNumber7,
    btnNumber8, btnNumber9,btnNumber0;
    EditText txtNumbersResult;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}