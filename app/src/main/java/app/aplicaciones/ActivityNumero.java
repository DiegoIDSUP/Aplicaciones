package app.aplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityNumero extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero);
        final EditText pttexto = findViewById(R.id.PTnumero);
        final Button btnamigo = findViewById(R.id.btnamigo);
        final ListView lvinfo = findViewById(R.id.LVinfo);

        btnamigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pttexto.getText().toString().isEmpty()) {
                    int num = Integer.parseInt(pttexto.getText().toString()), numa = 0, numc = 0, skip = 18;
                    String sum = "", suma = "";
                    for (int i = 1; num / i >= 2; i++) {
                        if ((num % i) == 0) {
                            numa = numa + i;
                            if (sum.length() >= skip) {
                                sum = sum + "\n";
                                skip = skip + 18;
                            }
                            sum = sum + i + "+";
                        }
                    }
                    skip = 18;
                    try {
                        sum = sum.substring(0, sum.length() - 1);
                    }catch (Exception e){}
                    for (int i = 1; numa / i >= 2; i++) {
                        if ((numa % i) == 0) {
                            numc = numc + i;
                            if (suma.length() >= skip) {
                                suma = suma + "\n";
                                skip = skip + 18;
                            }
                            suma = suma + i + "+";
                        }
                    }
                    try {
                        suma = suma.substring(0, suma.length() - 1);
                    }catch (Exception e){}
                    if (numc == num) {
                        lvinfo.setAdapter(new ArrayAdapter<String>(ActivityNumero.this, android.R.layout.simple_list_item_1, new String[]{"Su Amigo Es: " + numa, sum + "=" + numa, suma + "=" + numc}));
                    }
                    if (numc != num) {
                        lvinfo.setAdapter(new ArrayAdapter<String>(ActivityNumero.this, android.R.layout.simple_list_item_1, new String[]{"No Tiene Numero Amigo", sum + "=" + numa, suma + "=" + numc}));
                    }
                    pttexto.setText("");
                }else{
                    Toast.makeText(ActivityNumero.this,"Campos Vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
