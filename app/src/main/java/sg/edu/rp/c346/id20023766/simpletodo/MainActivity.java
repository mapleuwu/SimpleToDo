package sg.edu.rp.c346.id20023766.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button addbtn;
    Button clearbtn;
    ListView lvToDo;

    ArrayList<String> altask;
    ArrayAdapter<String> aatask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);
        addbtn = findViewById(R.id.BtnAdd);
        clearbtn = findViewById(R.id.BtnClear);
        lvToDo = findViewById(R.id.listview);

        altask = new ArrayList<>();


        aatask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, altask);
        lvToDo.setAdapter(aatask);

        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usertask = et.getText().toString();
                altask.add(usertask);
                aatask.notifyDataSetChanged();
                et.setText("");
            }
        });

        clearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                altask.clear();
                aatask.notifyDataSetChanged();
            }
        });
    }
}