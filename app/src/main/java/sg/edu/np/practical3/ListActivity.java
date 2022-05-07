package sg.edu.np.practical3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        int number = getIntent().getIntExtra("test", -1);
        TextView numtext = findViewById(R.id.numText);
        numtext.setText(String.valueOf(number));
    }

    @Override
    protected void onStart(){
        super.onStart();

        ImageView imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(false);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int randomInt = new Random().nextInt(999999999) + 100000000;

                        Intent backPage = new Intent(ListActivity.this, MainActivity.class);
                        backPage.putExtra("ranInt", randomInt);
                        startActivity(backPage);
//                        setResult(RESULT_OK, backPage);
//                        finish();
                    }
                });
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

}