package sg.edu.rp.c347.p05ndpsongs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etSongname, etSingers, etYear;
    RadioGroup rgStars;
    Button insert, show;


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
             String data =  etSongname.getText().toString() + etSingers.getText().toString() + etYear.getText().toString() + rgStars.getCheckedRadioButtonId();

                rgStars.getCheckedRadioButtonId();
                DBHelper dbh = new DBHelper(MainActivity.this);
               // long row_affected = dbh.insertSong(data);
                dbh.close();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
