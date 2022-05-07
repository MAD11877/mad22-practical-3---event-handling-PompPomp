package sg.edu.np.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    User newUser = new User("Joe Jim", "Hi there! I am a certified psychiatrist in the field of CyberSecurity and I am over qualified to be of service to you!", 12, false);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title = findViewById(R.id.title);
        title.setText(newUser.Name);

        TextView desc = findViewById(R.id.description);
        desc.setText(newUser.Description);
        initialise(newUser);

        int ranInt = getIntent().getIntExtra("ranInt", 1);
        if (ranInt != 1){
            title.setText(newUser.Name + " " + String.valueOf(ranInt));
        }
    }

    @Override
    protected void onStart(){
        super.onStart();

        Button followButton = findViewById(R.id.fbutton);
        followButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                if (followButton.getText() == "Follow"){
                    followButton.setText("UnFollow");
                    newUser.Followed = true;

                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();

                }
                else{
                    followButton.setText("Follow");
                    newUser.Followed = false;
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        Button NGButton = findViewById(R.id.NGButton);

        NGButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numGenerator = new Intent(MainActivity.this, ListActivity.class );
                numGenerator.putExtra("test", 100);
                startActivityForResult(numGenerator, 1);
            }
        });

        Button messageButton = findViewById(R.id.mbutton);

        messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent groupChat = new Intent(MainActivity.this, MessageGroup.class );
                startActivity(groupChat);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    public void initialise(User user) {
        Button followButton = findViewById(R.id.fbutton);
        if (user.Followed) {
            followButton.setText("UnFollow");
        } else {
            followButton.setText("Follow");
        }
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        TextView title = findViewById(R.id.title);
//        if (requestCode == 1) {
//            if(resultCode == RESULT_OK) {
//                int ranInt = getIntent().getIntExtra("ranInt", 1);
//                if (ranInt != 1){
//                    title.setText(newUser.Name + " " + String.valueOf(ranInt));
//                }
//            }
//        }
//    }
}