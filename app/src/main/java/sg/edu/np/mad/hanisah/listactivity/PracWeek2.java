package sg.edu.np.mad.hanisah.listactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PracWeek2 extends AppCompatActivity{
    private boolean followVar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pracweek2);

        //load name and desc from User object
        User u = new User();
        String name = u.name;
        String description = u.description;

        //receives information from previous activity
        Intent receivingEnd = getIntent();
        int randomInt = receivingEnd.getIntExtra("RandomInt", 0);
        TextView tv1 = findViewById(R.id.textView);
        tv1.setText("MAD " + randomInt);

        //interactability of follow button
        Button followBtn = findViewById(R.id.button);
        followBtn.setText("FOLLOW");
        followBtn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (followBtn.getText().toString() == "FOLLOW")
                {
                    followVar = true;
                    followBtn.setText("UNFOLLOW");
                    Toast.makeText(getApplicationContext(),"Followed", Toast.LENGTH_SHORT).show();
                    return;
                }
                followVar = false;
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