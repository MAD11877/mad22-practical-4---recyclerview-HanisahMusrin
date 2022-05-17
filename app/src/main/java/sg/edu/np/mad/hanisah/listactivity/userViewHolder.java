package sg.edu.np.mad.hanisah.listactivity;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class userViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView desc;

    public userViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textView3);
        desc = itemView.findViewById(R.id.textView5);
    }
}