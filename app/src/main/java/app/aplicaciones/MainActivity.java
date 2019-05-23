package app.aplicaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnpalindromo,btnnumero,btncalculadora,btnlista,btnreproductor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnpalindromo = findViewById(R.id.btnpalindromo);
        btnnumero = findViewById(R.id.btnnumero);
        btncalculadora = findViewById(R.id.btncalculadora);
        btnlista = findViewById(R.id.btnlista);
        btnreproductor = findViewById(R.id.btnreproductor);
        
        btnpalindromo.setOnClickListener(this);
        btnnumero.setOnClickListener(this);
        btncalculadora.setOnClickListener(this);
        btnlista.setOnClickListener(this);
        btnreproductor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent window = null;
        switch (v.getId()){
            case R.id.btnpalindromo:
                window = new Intent(MainActivity.this,ActivityPalindromo.class);
                break;
            case R.id.btnnumero:
                window = new Intent(MainActivity.this,ActivityNumero.class);
                break;
            case R.id.btncalculadora:
                window = new Intent(MainActivity.this,ActivityCalculadora.class);
                break;
            case R.id.btnlista:
                window = new Intent(MainActivity.this,ActivityLista.class);
                break;
            case R.id.btnreproductor:
                window = new Intent(MainActivity.this,ActivityNumero.class);
                break;
        }
        startActivity(window);
    }
}
