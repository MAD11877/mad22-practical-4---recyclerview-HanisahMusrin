package sg.edu.np.mad.hanisah.listactivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class userAdapter extends RecyclerView.Adapter<userViewHolder>{
    ArrayList<User> data;

    public userAdapter(ArrayList<User> input) {
        data = input;
    }

    public userViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view, parent, false);
        return new userViewHolder(item);
    }
    public void onBindViewHolder(userViewHolder holder, int position) {
        String namevar = data.get(position).name;
        holder.name.setText(namevar);

        String descvar = data.get(position).description;
        holder.desc.setText(descvar);
    }
    public int getItemCount()
    {
        return data.size();
    }
}



