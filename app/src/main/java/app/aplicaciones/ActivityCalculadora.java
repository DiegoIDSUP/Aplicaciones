package app.aplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ActivityCalculadora extends AppCompatActivity implements View.OnClickListener {
    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btns,btnr,btnx,btnd,btnp,btnpor,btni,btnpunto;
    TextView tvresultado;
    List<Float> numeros = new ArrayList<Float>();
    String txt;
    int operador=0,block=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        tvresultado = findViewById(R.id.TVresultado);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btns = findViewById(R.id.btns);
        btnr = findViewById(R.id.btnr);
        btnx = findViewById(R.id.btnx);
        btnd = findViewById(R.id.btnd);
        btnp = findViewById(R.id.btnp);
        btnpor = findViewById(R.id.btnpor);
        btni = findViewById(R.id.btni);
        btnpunto = findViewById(R.id.btnpunto);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btns.setOnClickListener(this);
        btnr.setOnClickListener(this);
        btnx.setOnClickListener(this);
        btnd.setOnClickListener(this);
        btnp.setOnClickListener(this);
        btnpor.setOnClickListener(this);
        btni.setOnClickListener(this);
        btnpunto.setOnClickListener(this);
    }

    public void operacion(int o, float numero){
        if(block==0){
            txt = "0";
            numeros.add(numero);
            if (numeros.size() == 2) {
                switch (operador) {
                    case 1:
                        numero = numeros.get(0) + numeros.get(1);
                        break;
                    case 2:
                        numero = numeros.get(0) - numeros.get(1);
                        break;
                    case 3:
                        numero = numeros.get(0) * numeros.get(1);
                        break;
                    case 4:
                        numero = numeros.get(0) / numeros.get(1);
                        break;
                    case 5:
                        numero = (float) Math.pow(numeros.get(0), numeros.get(1));
                        break;
                }
                numeros.clear();
                numeros.add(numero);
                txt = Float.toString(numero);
                if (numero % 1 == 0) {
                    txt = Integer.toString((int) numero);
                }
                block = 1;
            }
        }
        operador=o;
    }

    @Override
    public void onClick(View v) {
        txt=tvresultado.getText().toString();
        try {
            if (Float.parseFloat(tvresultado.getText().toString()) == 0) {
                txt = "";
            }
        }catch(NumberFormatException d){}
        if(block==1){
            if(v.getId()==R.id.btn0 || v.getId()==R.id.btn1 || v.getId()==R.id.btn2 || v.getId()==R.id.btn3 || v.getId()==R.id.btn4 || v.getId()==R.id.btn5 || v.getId()==R.id.btn6 || v.getId()==R.id.btn7 || v.getId()==R.id.btn8 || v.getId()==R.id.btn9 || v.getId()==R.id.btnpunto){
                txt = "";
                block = 0;
            }
        }
        switch (v.getId()){
            case R.id.btn0:
                txt=txt+"0";
                break;
            case R.id.btn1:
                txt=txt+"1";
                break;
            case R.id.btn2:
                txt=txt+"2";
                break;
            case R.id.btn3:
                txt=txt+"3";
                break;
            case R.id.btn4:
                txt=txt+"4";
                break;
            case R.id.btn5:
                txt=txt+"5";
                break;
            case R.id.btn6:
                txt=txt+"6";
                break;
            case R.id.btn7:
                txt=txt+"7";
                break;
            case R.id.btn8:
                txt=txt+"8";
                break;
            case R.id.btn9:
                txt=txt+"9";
                break;
            case R.id.btns:
                operacion(1,Float.parseFloat(txt));
                break;
            case R.id.btnr:
                operacion(2,Float.parseFloat(txt));
                break;
            case R.id.btnx:
                operacion(3,Float.parseFloat(txt));
                break;
            case R.id.btnd:
                operacion(4,Float.parseFloat(txt));
                break;
            case R.id.btnp:
                operacion(5,Float.parseFloat(txt));
                break;
            case R.id.btnpor:
                if(numeros.size() == 1){
                    float porcent=numeros.get(0)*(Float.parseFloat(txt)/100);
                    operacion(0,porcent);
                }
                break;
            case R.id.btni:
                operacion(0,Float.parseFloat(txt));
                break;
            case R.id.btnpunto:
                txt=txt+".";
                break;
        }
        tvresultado.setText(txt);
    }
}
