package sg.edu.rp.c347.p05ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etSongname, etSingers, etYear;
    RadioGroup rgStars;
    Button insert, show;
    ArrayAdapter<Songs> songs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etSongname = (EditText)findViewById(R.id.etSong);
        etSingers = (EditText)findViewById(R.id.etSingers);
        etYear = (EditText)findViewById(R.id.etYear);
        rgStars = (RadioGroup)findViewById(R.id.rgStar);
        insert = (Button)findViewById(R.id.buttInsert);
        show = (Button)findViewById(R.id.buttShow);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DBHelper dbh = new DBHelper(MainActivity.this);

                int selected = rgStars.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selected);

                long row_affected = dbh.insertSong(etSongname.getText().toString(), etSingers.getText().toString(),  Integer.parseInt(etYear.getText().toString()),Integer.parseInt(rb.getText().toString()));
                dbh.close();
//                Toast.makeText(getBaseContext(), "Inserted", Toast.LENGTH_SHORT).show();


            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), SecondActivity.class);
                startActivity(i);

            }
        });


    }

}
