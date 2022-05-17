package sg.edu.np.mad.hanisah.listactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<User> userList;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creating the alert
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Profile");
        builder.setMessage("MADness");
        builder.setCancelable(true);
        builder.setPositiveButton("VIEW", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                int random_int = randomInt(10000);

                //transferring data to next activity
                Intent activityName = new Intent(MainActivity.this, PracWeek2.class);
                activityName.putExtra("RandomInt", random_int);
                startActivity(activityName);
                //setContentView(R.layout.pracweek2);
            }
        });
        builder.setNegativeButton("CLOSE", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
            }
        });

        userList = initialiseData();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //set adapter
        userAdapter mAdapter = new userAdapter(userList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        /*making the img interactable
        ImageView img = findViewById(R.id.imageView3);
        img.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View V)
            {
                AlertDialog alert = builder.create();
                alert.show();
            }
        });*/
    }

    public int randomInt(int ceiling)
    {
        int min = 0;
        int max = ceiling;

        //Generate random int value from 0 to 100
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }
    public ArrayList<User> initialiseData()
    {
        ArrayList<String> nameList = new ArrayList<String>();
        ArrayList<String> descList = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
        {
            nameList.add("Name"+randomInt(10000));
            descList.add("Description "+randomInt(10000));
        }

        int i = 1;
        ArrayList<User> userList = new ArrayList<User>();
        for ( String name : nameList)
        {
            User u = new User();
            u.id = i;
            u.description = descList.get(randomInt(descList.size()-1));
            u.name = nameList.get(randomInt(nameList.size()-1));
            if (randomInt(1) == 1)
            {
                u.followed = true;
            }
            else
            {
                u.followed = false;
            }
            userList.add(u);
            i = i + 1;
        }
        for ( Object user : userList)
        {
            User u = (User) user;
            System.out.println(u.name);
        }
        return userList;
    }
}