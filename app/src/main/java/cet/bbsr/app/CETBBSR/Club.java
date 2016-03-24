package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



/**
 * Created by SM ROCKS on 12/26/2015.
 */
public class  Club  extends AppCompatActivity {
   ListView l1;
  TextView b1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.club);
        l1=(ListView)findViewById(R.id.listView);
         String tech[]={"Zairza",   "Energy club" ,"SAE",  "ASME-CET","E-Cell","CETADEL","Arpeggio", "The Amuza", "CET Rising", "NSS","TDA","BIOZO","PHOTOFACTORY","SPIRITUAL CLUB","SPORTS CLUB"};

          b1=(TextView)findViewById(R.id.button2);

         b1.setText("THE  CLUBS OF CET-BBSR");
        ArrayAdapter<String> ad1=new CustomAdapter(this,tech);
         l1.setAdapter(ad1);

          l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
              @Override
              public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                  Intent i = new Intent(Club.this, ClubView.class);
                  i.putExtra("key", (String) parent.getItemAtPosition(position));
                  startActivity(i);

              }
          });


    }
}