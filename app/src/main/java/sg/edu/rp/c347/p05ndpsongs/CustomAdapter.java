package sg.edu.rp.c347.p05ndpsongs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15004557 on 18/5/2017.
 */

public class CustomAdapter extends ArrayAdapter<Songs> {

    Context context;
    ArrayList<Songs> songs;
    int resource;
    ImageView iv1, iv2, iv3, iv4, iv5, albumArt;
    TextView year, songName, songArtist;

    public CustomAdapter(Context context, int resource, ArrayList<Songs> notes) {
        super(context, resource, notes);
        this.context = context;
        this.songs = notes;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);

        //Match the UI components with Java variables
        year = (TextView) rowView.findViewById(R.id.tvYear);
        songName = (TextView) rowView.findViewById(R.id.tvSongName);
        songArtist = (TextView) rowView.findViewById(R.id.tvArtistName);

        iv1 = (ImageView) rowView.findViewById(R.id.onestar);
        iv2 = (ImageView) rowView.findViewById(R.id.twostar);
        iv3 = (ImageView) rowView.findViewById(R.id.threestar);
        iv4 = (ImageView) rowView.findViewById(R.id.fourstar);
        iv5 = (ImageView) rowView.findViewById(R.id.fivestar);

        Songs song = songs.get(position);
        year.setText(song.getYear());
        songName.setText(song.getSongTitle());
        songArtist.setText(song.getSingers());
        albumArt.setImageResource(R.drawable.ic_library_music);
        //Check if the property for starts >= 5, if so, "light" up the stars
        if (song.getStar() == 5) {
            iv5.setImageResource(android.R.drawable.btn_star_big_on);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStar() == 4) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_on);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStar() == 3) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_on);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else if (song.getStar() == 2) {
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_on);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        else{
            iv5.setImageResource(android.R.drawable.btn_star_big_off);
            iv4.setImageResource(android.R.drawable.btn_star_big_off);
            iv3.setImageResource(android.R.drawable.btn_star_big_off);
            iv2.setImageResource(android.R.drawable.btn_star_big_off);
            iv1.setImageResource(android.R.drawable.btn_star_big_on);
        }
        return rowView;
    }

}
