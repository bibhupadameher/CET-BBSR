package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

public class Home2 extends AppCompatActivity {
    ImageButton ib[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ib=new ImageButton[8];
        ib[0]=(ImageButton)findViewById(R.id.imageButton);
        ib[1]=(ImageButton)findViewById(R.id.imageButton2);
        ib[2]=(ImageButton)findViewById(R.id.imageButton3);
        ib[3]=(ImageButton)findViewById(R.id.imageButton6);
        ib[4]=(ImageButton)findViewById(R.id.imageButton9);
        ib[5]=(ImageButton)findViewById(R.id.imageButton10);
        ib[6]=(ImageButton)findViewById(R.id.imageButton11);
        ib[7]=(ImageButton)findViewById(R.id.imageButton12);


        ib[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this, Department.class);
                startActivity(i);
            }
        });

        ib[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this, Ebook.class);
                startActivity(i);
            }
        });

        ib[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this,Brower.class);
                i.putExtra("key", "http://results.bput.ac.in/");
                startActivity(i);
            }
        });

        ib[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this, Club.class);
                startActivity(i);
            }
        });

        ib[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Home2.this,Brower.class);
                i.putExtra("key","http://cet.hol.es/");

                startActivity(i);
            }
        });

        ib[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this,Brower.class);
                i.putExtra("key","http://xtasy.cetb.in/");

                startActivity(i);
            }
        });

        ib[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i = new Intent(Home2.this,Brower.class);
                  i.putExtra("key", "file:///android_asset/holiday.html");

                 startActivity(i);

              //  Intent i = new Intent(Notice.this, Notices.class);
              //  startActivity(i);
            }
        });

        ib[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Home2.this, About.class);
                startActivity(i);
            }
        });


    }

}
