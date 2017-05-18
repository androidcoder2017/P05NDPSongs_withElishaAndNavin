package sg.edu.rp.c347.p05ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    int requestCodes = 1;
    ListView lv;
    ArrayList<Songs> songs;
    CustomAdapter customAdapter;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        DBHelper db = new DBHelper(SecondActivity.this);

        songs = new ArrayList<Songs>();
        lv = (ListView)findViewById(R.id.lv);
        btn = (Button)findViewById(R.id.button);
        customAdapter = new CustomAdapter(SecondActivity.this, R.layout.row, songs);


        songs.addAll(db.getAllNotes());
        lv.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
        db.close();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SecondActivity.this);
                songs.clear();
                songs.addAll(db.getSongsWith5Stars());
                customAdapter.notifyDataSetChanged();
                db.close();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
                Songs data = songs.get(position);


                i.putExtra("data", data);
                startActivityForResult(i, requestCodes);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == this.requestCodes ) {
            DBHelper db = new DBHelper(SecondActivity.this);
            songs = db.getAllNotes();
            customAdapter = new CustomAdapter(SecondActivity.this, R.layout.row, songs);
            lv.setAdapter(customAdapter);
        }
    }
}
