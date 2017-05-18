package sg.edu.rp.c347.p05ndpsongs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    TextView tvID;
    EditText etTitle,etSingers, etYears;
    RadioGroup rg;
    Button btnUpdate, btnDelete, btnCancel;

    Songs data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        tvID = (TextView)findViewById(R.id.tvID);
        etSingers = (EditText)findViewById(R.id.etSingers);
        etTitle = (EditText)findViewById(R.id.etTitle);
        etYears = (EditText)findViewById(R.id.etYear);
        rg = (RadioGroup)findViewById(R.id.radiogroup);
        btnUpdate = (Button)findViewById(R.id.buttonUpdate);
        btnDelete = (Button)findViewById(R.id.buttonDelete);
        btnCancel = (Button)findViewById(R.id.buttonCancel);

        int selected = rg.getCheckedRadioButtonId();
        final RadioButton rb = (RadioButton)findViewById(selected);

        final Intent i = getIntent();
        data = (Songs) i.getSerializableExtra("data");
        tvID.setText("Song ID:" + data.getId());


        etTitle.setText(data.getSongTitle());
        etSingers.setText(data.getSingers());
        etYears.setText("" + data.getYear());
        int stars = data.getYear();


        if (stars == 1) {
            rb.setChecked(true);
        } else if (stars == 2) {
            rb.setChecked(true);
        } else if (stars == 3) {
            rb.setChecked(true);
        } else if (stars == 4) {
            rb.setChecked(true);
        } else if (stars == 5) {
            rb.setChecked(true);
        }


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                data.setSingers(etSingers.getText().toString());
                data.setSongtitle(etTitle.getText().toString());
                data.setYear(Integer.parseInt(etYears.getText().toString()));

                dbh.updateSong(data);
                dbh.close();
                setResult(RESULT_OK, i);
                finish();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(ThirdActivity.this);
                dbh.deleteSong(data.getId());
                dbh.close();
                setResult(RESULT_OK, i);

                finish();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, i);
                finish();
            }
        });

    }
}
