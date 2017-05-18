package sg.edu.rp.c347.p05ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

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


//        for (int i = 0; i < songData.size(); i++) {
//            Log.d("Database Content", i +". "+songData.get(i));
//
//
//            songs.add(new Songs(i, songData.get(i).getSongTitle(), songData.get(i).getSingers(), songData.get(i).getYear(), songData.get(i).getStar() ));
//        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(SecondActivity.this);
                db.getSongsWith5Stars();
                db.close();
            }
        });



    }
}
