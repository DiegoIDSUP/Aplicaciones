package app.aplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityPalindromo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palindromo);
        final ListView lvlista = findViewById(R.id.LVlista);
        final EditText pttexto = findViewById(R.id.PTtexto);
        final Button btnnext = findViewById(R.id.btnnext);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pttexto.getText().toString().isEmpty()){
                    String palabra = pttexto.getText().toString().toLowerCase();
                    String arbalap = "";
                    String[] sep = palabra.split("");
                    for (int i = sep.length - 1; i >= 0; i--) {
                        arbalap = arbalap + sep[i];
                    }
                    int moda = 0, contm = 0, cont = 0;
                    for (int i = 0; i < sep.length; i++) {
                        cont = 0;
                        for (int j = 0; j < sep.length; j++) {
                            if (sep[i].equals(sep[j])) {
                                cont++;
                            }
                        }
                        if (cont > contm) {
                            moda = i;
                            contm = cont;
                        }
                    }
                    String[] Datos;
                    if (palabra.equals(arbalap)) {
                        lvlista.setAdapter(new ArrayAdapter<String>(ActivityPalindromo.this, android.R.layout.simple_list_item_1, new String[]{"Es Un Palindromo", "Longitud: " + palabra.length(), "Alrevez: " + arbalap, "Moda: " + sep[moda]}));
                    } else {
                        lvlista.setAdapter(new ArrayAdapter<String>(ActivityPalindromo.this, android.R.layout.simple_list_item_1, new String[]{"No Es Un Palindromo", "Longitud: " + palabra.length(), "Alrevez: " + arbalap, "Moda: " + sep[moda]}));
                    }
                    pttexto.setText("");
                }else{
                    Toast.makeText(ActivityPalindromo.this,"Campos Vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
