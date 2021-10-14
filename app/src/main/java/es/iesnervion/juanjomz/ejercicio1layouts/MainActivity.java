package es.iesnervion.juanjomz.ejercicio1layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSumOpt,btnSubsOpt,btnMultOpt,btnDivOpt,btnDelete,btnDot,btnResult;
    TextView txtNumbersResult;
    double result;
    int lastButtonPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button[] ArrayOfNumberButtons= new Button[]{findViewById(R.id.btnNumber0),findViewById(R.id.btnNumber1),
        findViewById(R.id.btnNumber2),findViewById(R.id.btnNumber3),findViewById(R.id.btnNumber4),
        findViewById(R.id.btnNumber5),findViewById(R.id.btnNumber6),findViewById(R.id.btnNumber7), findViewById(R.id.btnNumber8),findViewById(R.id.btnNumber9),findViewById(R.id.btnDot)};
        Button[] ArrayOfOperationsButtons=new Button[]{findViewById(R.id.btnSubsOpt),findViewById(R.id.btnSubsOpt),findViewById(R.id.btnMultOpt),findViewById(R.id.btnDivOpt)};
        result=0;
        lastButtonPressed=0;
        btnDelete=findViewById(R.id.btnDelete);
        btnResult=findViewById(R.id.btnResult);
        txtNumbersResult=findViewById(R.id.txtNumbersResult);
        btnDelete.setOnClickListener(x->delete());
        btnResult.setOnClickListener(x->showResult());
        for(Button b:ArrayOfNumberButtons){
            b.setOnClickListener(x->showNumber(x));
        }
        for(Button b:ArrayOfOperationsButtons){
            b.setOnClickListener(this);
        }
    }



    public void showNumber(View btn){
        txtNumbersResult.setText(txtNumbersResult.getText().toString()+((Button)btn).getText());
    }

    @Override
    public void onClick(View v){
        int id=0;
        if(v==null){
            id= lastButtonPressed;
        }else{
            id=v.getId();
        }
        switch(id){
            case R.id.btnDivOpt:{makeDivision();}break;
            case R.id.btnMultOpt:{makeMultiplication();}break;
            case R.id.btnSubsOpt:{makeSubstraction();}break;
            case R.id.btnSumOpt:{makeSum();}break;
        }
    }

    public void showResult(){
        if(lastButtonPressed!=0) {
            onClick(null);
            txtNumbersResult.setText(String.valueOf(result));
        }
    }
    public void makeSum(){
        lastButtonPressed=R.id.btnSumOpt;
        result+=Double.parseDouble(txtNumbersResult.getText().toString());
        txtNumbersResult.setText("");
    }
    public void makeSubstraction(){
        lastButtonPressed = R.id.btnSubsOpt;
        if(result!=0) {
            result-=Double.parseDouble(txtNumbersResult.getText().toString());
        }else{
            result=Double.parseDouble(txtNumbersResult.getText().toString());
        }
        txtNumbersResult.setText("");
    }
    public void makeMultiplication(){
        lastButtonPressed = R.id.btnMultOpt;
        if(result!=0) {
            result*=Double.parseDouble(txtNumbersResult.getText().toString());
        }else{
            result=Double.parseDouble(txtNumbersResult.getText().toString());
        }
        txtNumbersResult.setText("");
    }
    public void makeDivision(){
        lastButtonPressed = R.id.btnDivOpt;
        if(result!=0) {
            result/=Double.parseDouble(txtNumbersResult.getText().toString());
        }else{
            result=Double.parseDouble(txtNumbersResult.getText().toString());
        }
        txtNumbersResult.setText("");}

        public void delete(){
        int longitudDeCadena=txtNumbersResult.getText().toString().length();//para ahorrarme una llamade de más al método
            if(longitudDeCadena>0){
                txtNumbersResult.setText(txtNumbersResult.getText().toString().substring(longitudDeCadena-1));
            }
        }
}