package sg.edu.np.mad.hanisah.listactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class PracWeek2 extends AppCompatActivity{
    public boolean followStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pracweek2);

        //receives information from previous activity
        Intent receivingEnd = getIntent();

        String username = receivingEnd.getStringExtra("userName");
        TextView tv1 = findViewById(R.id.textView);
        tv1.setText(username);

        followStatus = receivingEnd.getBooleanExtra("followStatus", false);

        int userID = receivingEnd.getIntExtra("userID",0);

        //initialise follow button
        Button followBtn = findViewById(R.id.button);

        if (followStatus == true)
        {
            followBtn.setText("UNFOLLOW");
        }
        else
        {
            followBtn.setText("FOLLOW");
        }

        //interactability of follow button
        followBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (followBtn.getText() == "FOLLOW")
                {
                    followStatus = true;
                    followBtn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                    return;
                }
                followStatus = false;
                followBtn.setText("FOLLOW");
                Toast.makeText(getApplicationContext(),"Unfollowed", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        //interactability of message button
        Button msgBtn = findViewById(R.id.button2);
        msgBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent activityName2 = new Intent(PracWeek2.this, MessageGroup.class);
                startActivity(activityName2);
            }
        });
    }
}