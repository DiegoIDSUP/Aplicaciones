package app.aplicaciones;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ActivityLista extends AppCompatActivity {
    ArrayAdapter<String> lista;
    ArrayAdapter<Button> btndelete;
    ArrayAdapter<Button> btnedit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        final EditText ptadd = findViewById(R.id.PTadd);
        final Button btnadd=findViewById(R.id.btnadd);
        final Button btneditar=findViewById(R.id.btneditar);
        final Button btnborrar=findViewById(R.id.btnborrar);
        final ListView lvlist = findViewById(R.id.LVlist);
        final int[] pos = new int[1];
        lista = new ArrayAdapter<String>(ActivityLista.this,android.R.layout.simple_list_item_1);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ptadd.getText().toString().isEmpty()){
                    lista.add(ptadd.getText().toString());
                    lista.notifyDataSetChanged();
                    lvlist.setAdapter(lista);
                    ptadd.setText("");
                }else{
                    Toast.makeText(ActivityLista.this,"Campos Vacios", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ptadd.getText().toString().isEmpty()) {
                    lvlist.setVisibility(View.VISIBLE);
                    btnadd.setVisibility(View.VISIBLE);
                    btneditar.setVisibility(View.INVISIBLE);
                    lista.remove(lista.getItem(pos[0]));
                    lista.insert(ptadd.getText().toString(), pos[0]);
                    lista.notifyDataSetChanged();
                    lvlist.setAdapter(lista);
                    ptadd.setText("");
                }else{
                    Toast.makeText(ActivityLista.this,"Campos Vacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvlist.setVisibility(View.VISIBLE);
                btnadd.setVisibility(View.VISIBLE);
                btneditar.setVisibility(View.INVISIBLE);
                lista.remove(lista.getItem(pos[0]));
                lista.notifyDataSetChanged();
                lvlist.setAdapter(lista);
                ptadd.setText("");
            }
        });

        lvlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                lvlist.setVisibility(View.INVISIBLE);
                btnadd.setVisibility(View.INVISIBLE);
                btneditar.setVisibility(View.VISIBLE);
                btnborrar.setVisibility(View.VISIBLE);
                ptadd.setText(lista.getItem(position));
                pos[0] = position;
            }
        });
    }
}
