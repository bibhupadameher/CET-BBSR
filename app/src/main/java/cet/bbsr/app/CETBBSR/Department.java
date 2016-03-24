package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class Department extends AppCompatActivity {
ListView lv;
    TextView tv1,tv2;
    ImageButton im1,im2;
    TabHost tabs;
    public float   lastX;
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN: {
                lastX = event.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = event.getX();

                // if left to right swipe on screen
                if (lastX < currentX) {

                    tabs.setCurrentTabByTag("tag2");
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    tabs.setCurrentTabByTag("tag1");
                }

                break;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department);
           lv=(ListView)findViewById(R.id.listView7);
        tv2=(TextView)findViewById(R.id.textView8);
        tv1=(TextView)findViewById(R.id.textView21);
        im1=(ImageButton)findViewById(R.id.imageButton23);
        im2=(ImageButton)findViewById(R.id.imageButton24);
       String dept[]={"\t\t Architecture Engineering\t \n" , " \t\tBiotechnology\t \n" , " \t\tCivil Engineering\t \n" , " \t\tComputer Science & Application (MCA)\t \n" , " \t\tComputer Science & Engineering\t \n" , " \t\tElectrical Engineering\t \n" , " \t\tFashion & Apparel Technology\t \n" , " \t\tInformation Technology\t \n" , " \t\tInstrumentation & Electronics Engineering\t \n" , " \t\tMechanical Engineering\t \n" , " \t\tTextile Engineering\t \n" , " \t\tMathematics & Humanities\t \n" , " \t\tPhysics\t \n" , " \t\tChemistry\t"};
         tabs = (TabHost) findViewById(R.id.tabHost8);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PRINCIPAL");
        tabs.addTab(spec);

        TabHost.TabSpec speca = tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab2);
        speca.setIndicator("DEPARTMENT");
        tabs.addTab(speca);

        ArrayAdapter<String> ad2=new CustomAdapter(this,dept);
        lv.setAdapter(ad2);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Department.this, DepartmentView.class);
                i.putExtra("key", position);
                startActivity(i);
            }
        });
        tv1.setText("Principal \n" +
                "B.E.(Distn.)(NIT,Surat)\n " +
                "M.Tech.(IIT,Kharagpur) \n" +
                "Ph.D. (Utkal University)\n" +
                "MIEEE,FIE(I),MIAENG,LMISTE ");
        tv2.setText("Dear Students,\n" +
                "\n" +
                "College of Engineering and Technology has been a pool of meritorious students consistently for many years. And hence it has always tried to facilitate quality engineering education to equip and enrich young men and women to meet global challenges in development, innovation and application of technology in the service of humanity.\n" +
                "\n" +
                "Ever since its inception, a strong commitment to excellence in teaching and research has made CET, Bhubaneswar one of the top most colleges in Odisha. Its rich academic tradition has always attracted the most talented students who later contribute to the progress of the society.\n" +
                "\n" +
                "I would like to acknowledge the students for their consistent hard work due to which this college has been able to become the first and foremost choice of the aspiring engineers of Odisha. Let me also at the same time acknowledge the great alumni power, the present and the past faculty members of the institution who have built up this institution to high acclaim.\n" +
                "With the guidance of teachers and of the college’s administrative staff, I hope the students will reach their port of dreams, sailing with the wind and sometimes against it; but sail they must and not drift or lie at anchor.\n" +
                " \n" +
                "Thanking You,\n" +
                "Prof. Prashant Kumar Patra\n" +
                "Principal");
          im1.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                call();
              }
          });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email=new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,new String[]{"principalcet@cet.edu.in"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email,"choose an email client"));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_department, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" +  "9437189863"));
        startActivity(callIntent);
    }
}
