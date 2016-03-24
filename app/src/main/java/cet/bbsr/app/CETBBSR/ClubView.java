package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by SM ROCKS on 12/27/2015.
 */

public class  ClubView  extends AppCompatActivity {


  TextView b;
    ImageView im;
    TextView Tv,tvv;
    ImageButton im1,im2,im3,im4;
    ListView l1;
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
        setContentView(R.layout.clubview);
        Bundle bundle = getIntent().getExtras();
        String p = bundle.getString("key");
        b=(TextView)findViewById(R.id.button5);
        im=(ImageView)findViewById(R.id.imageView2);
        Tv=(TextView)findViewById(R.id.textView10);
        tvv=(TextView)findViewById(R.id.textView12);
        im1=(ImageButton)findViewById(R.id.imageButton16);
        im2=(ImageButton)findViewById(R.id.imageButton17);
        im3=(ImageButton)findViewById(R.id.imageButton18);
        im4=(ImageButton)findViewById(R.id.imageButton19);
        l1=(ListView)findViewById(R.id.listView3);
        final int k;
        if(p.equals("Zairza"))k=0;
        else if (p.equals("Energy club"))k=1;
        else if (p.equals("SAE"))k=2;
        else if (p.equals("ASME-CET"))k=3;
        else if (p.equals("E-Cell"))k=4;
        else if (p.equals("CETADEL"))k=5;
        else if (p.equals("Arpeggio"))k=6;
        else if (p.equals("The Amuza"))k=7;
        else if (p.equals("CET Rising"))k=8;
        else if (p.equals("NSS"))k=9;
        else if (p.equals("TDA"))k=10;
        else if (p.equals("BIOZO"))k=11;
        else if (p.equals("PHOTOFACTORY"))k=12;
        else if (p.equals("SPIRITUAL CLUB"))k=13;
        else if (p.equals("SPORTS CLUB"))k=14;
        else k=15;
          if(k==0||k==1){im3.setVisibility(View.VISIBLE);}
          else im3.setVisibility(View.INVISIBLE);
          String sp[]= new String[16];
          int id[]={R.drawable.zaa,R.drawable.zbb,R.drawable.zc,R.drawable.zd,R.drawable.ze,R.drawable.zf,R.drawable.zgg,R.drawable.zh,R.drawable.zii,R.drawable.zj,R.drawable.hab,R.drawable.haa,R.drawable.mad,R.drawable.hac,R.drawable.had};
        sp[0]="Zairza, The technical club of CET is a self motivated platform for the technically interested students.\n" + "It was established in the year of 2005 by a group of students who wanted to do something different beyond the syllabus. Zairza was made the official and the only technical club of CET in the year 2007.The initial vision of this club was to envisage conducive platform to explore student’s talent in the field of technology irrespective of any discrimination of any branch.\n" + "\n" + "Zairza was started in 2005 by Ronak Kumar Samantray as an Technical club for sharing the knowledge of software among interested students and come up with innovative ideas for the challenges in the field of information technology. Later Sruti Ranjan Sahoo an electronics hobbyist with little knowledge of robotics started a new wing of Robotics envisioned of automating the real life challenges. Later they both worked together to make it an official technical club of CET in 2007.\n" ;
        sp[1]="The Energy Club of College of Engineering & Technology, Bhubaneswar is a student organization started by students of the Department of Electrical Engg.\n" + "\n" + "Mission\n" + "The aim and vision of the Energy Club is essentially three-pronged:\n" + "a. To bring together CET students, scholars, alumni and professors of all levels irrespective of discipline, who are interested in energy conservation and sustainability issues.\n" + "b. To facilitate students to involve in various activities related to power scenario and enhancement ,energy auditing and monitoring of power quality in CET campus and ensure that it becomes, energy-efficient and more sustainable.\n" + "c. To initiate, promote and support all technical and non-technical endeavors such as projects, competitions, workshops, awareness drives etc. So that there can be efficient usage of energy, awareness and sustainability at their core.\n" + "\n" + "Description\n" + "The College of Engineering & Technology, Bhubaneswar is a home to some of the brightest and most aware young technical minds of India. It is these minds that will carry the country in the next century and the question of energy is undoubtedly one of the largest questions they will have to address. With the increasing demand for ENERGY, effective management and conservation of the same has become the need of the hour .Consequently, there are many students in the campus highly conscious and concerned about the future of energy and sustainability. However, such students are separated by virtue of belonging to different disciplines and years. It is the need for a common platform for such students to come together and turn their concern into action, which brought the Energy Club into existence. A group of energy conscious students with the backing of the faculty and professors decided to start a formal Club that would make energy awareness and action it's priority and combine the ideas and concern of students across campus into tangible steps towards energy conservation and sustainability.\n" + "\n" +"A new wing of our club, UDAAN that concerns with aero-modelling has been started from January 2014.";
        sp[2]="";
        sp[3]="under construction";
        sp[4]="under construction";
        sp[5]="OUR WINGS\n" +"CETQUIZZITE\n" + "The quizzing wing of cetadel where the budding quizzards of CET rule the roost.\n" + "\n" + "CET RISING\n" + "Our Success Stories. For Cetizens,Of Cetians,By Cetards.\n" + "\n" + "VOIX\n" + "The debating wing of Cetadel. The Place where your voices strike,cut,stand and lastly are heard.";
        sp[6]="ARPEGGIO is the official music club of CET-Bhubaneswar. It is one of the most active club in the college. The club was revived in 2014 and given a different color by introducing many strings of music like vocals, guitars, keyboards, drums and many more. The prime motto of this club is not only to group musicians, but also music enthusiasts and build a music-friendly environment in college. The club encourages young musicians to interact with each other and gives them an appropriate jam pad. It enables us students to utilize our free time productively and do something what we as music enthusiasts are passionate about.\n" + "\n" + "The club recognizes exceptional talent and promotes it in the right direction. The students in the executive body arrange practice sessions for intra as well as inter collegiate events. \n" + "\n" + " \n" + "\n" + "Arpeggio CET-B is mentored and headed by our PIC, Cultural Dr.  Kanhu Charan Bhuyan sir. Among students, the team is lead by 2 Club Coordinators, followed by 20 core members  who are helped by 50 students  in the organization of various events and activities. Several other Bands and alumni are associated with Arpeggio CET-B at various levels";
        sp[7]="Amuza, the official dramatics society of CET is a group of acting enthusiasts who perform acts based on raging social issues. Amuza performs enactments such as Nukkad Nataks(Street Play), Theatre Plays, Mimicry, Stand-up comedies and Mime plays and have amazed crowds within and outside the college. In all, Amuza aims to provide a platform where team spirit moulds talent and dedication into a beautiful result called success.";
        sp[8]="under construction";
        sp[9]="under construction";
        sp[10]="under construction";
        sp[11]="under construction";
        sp[12]="under construction";
        sp[13]="under construction";
        sp[14]="under construction";
        sp[15]="under construction";


         String add[] =new String[16];
        add[0]="Zairza Room , SAC\n" + "CET, BBSR";
        add[1]="Ground floor, Lab Biulding\n" + "CET, BBSR";
        add[2]="CET, BBSR";
        add[3]="CET, BBSR";
        add[4]="CET, BBSR";
        add[5]="CET, BBSR";
        add[6]="Cultural Room, SAC\n" + "CET, BBSR";
        add[7]="Cultural Room, SAC\n" +"CET, BBSR";
        add[8]="CET, BBSR";
        add[9]="CET, BBSR";
        add[10]="CET, BBSR";
        add[11]="CET, BBSR";
        add[12]="CET, BBSR";
        add[13]="CET, BBSR";
        add[14]="CET, BBSR";
        add[15]="CET, BBSR";



        tabs = (TabHost) findViewById(R.id.tabHost4);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("HOME");
        tabs.addTab(spec);
        TabHost.TabSpec speca = tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab2);
        speca.setIndicator("CONTACT");
        tabs.addTab(speca);

        final String web1[]={"http://zairza.cetb.in/","http://energyclub.cetb.in/","","","","http://cetadel.cetb.in/","http://arpeggio.cetb.in/","http://amuza.cetb.in/","","","","","","",};
        final String  web2[]={"http://zairza.in/","http://energyclubcetb.in/"};
        final String web3[]={"https://www.facebook.com/zairza.cetb?_rdr=p","https://www.facebook.com/energyclubcetb","","","https://www.facebook.com/Ecellcetb/?fref=ts","https://www.facebook.com/cetadel2/?fref=ts","https://www.facebook.com/arpeggiocetb","https://www.facebook.com/TheAmuza","https://www.facebook.com/CetRising/?fref=ts","https://www.facebook.com/nsscetb/?fref=ts","","","","",""};
        String coor[][]={{"Pankaj Shukla" , "Anubhav Routray", "Shubham Prasad" },{"Dibya Sundar","Padarabinda Samal"},{},{},{},{"Anirban Pati","Tanuja Pattnaik"},{"Ranjan Kumar","Shubhakanta Udgata"},{"Abhijeet Tripathy","Anish Tripathy"},{},{},{},{},{},{},{}};


        ArrayAdapter<String> ad1=new ArrayAdapter<String>(ClubView.this,android.R.layout.simple_list_item_1,coor[k]);
        l1.setAdapter(ad1);
        im.setImageResource(id[k]);
        b.setText(p);
       Tv.setText(sp[k]);
        tvv.setText(add[k]);
        im4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClubView.this, Brower.class);
                i.putExtra("key", web3[k]);
                startActivity(i);
            }
        });

        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClubView.this, Brower.class);
                i.putExtra("key","https://www.google.co.in/maps/place/College+of+Engineering+and+Technology/@20.2749251,85.7759597,17.67z/data=!4m2!3m1!1s0x3a19a7f9d486f7c3:0xde71ead59307dcca?hl=en");
                startActivity(i);
            }
        });

        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClubView.this, Brower.class);
                i.putExtra("key",web1[k]);
                startActivity(i);
            }
        });

        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ClubView.this, Brower.class);
                i.putExtra("key",web2[k]);
                startActivity(i);
            }
        });

        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String n= (String) parent.getItemAtPosition(position);
                String w = null;
                if(n.equals("Pankaj Shukla")) w="https://www.facebook.com/pankaj.shukla.1420";
                else if(n.equals("Anubhav Routray")) w="https://www.facebook.com/abranubhav";
                else if(n.equals("Shubham Prasad")) w="https://www.facebook.com/shubham2192";
                else if(n.equals("Dibya Sundar")) w="https://www.facebook.com/profile.php?id=100003947561396";
                else if(n.equals("Padarabinda Samal")) w="https://www.facebook.com/padarabinda.samal";
                else if(n.equals("Anirban Pati")) w="https://www.facebook.com/pati.anirban";
                else if(n.equals("Tanuja Pattnaik")) w="https://www.facebook.com/tanuja.pattnaik.14?fref=ts";
                else if(n.equals("Ranjan Kumar")) w="https://www.facebook.com/kumarranjan.1701?fref=ts";
                else if(n.equals("Shubhakanta Udgata")) w="https://www.facebook.com/shubhakanta.udgata?fref=ts";
                else if(n.equals("Abhijeet Tripathy")) w="https://www.facebook.com/tripathyabhijeet72";
                else if(n.equals("Anish Tripathy")) w="https://www.facebook.com/anish.anss";
                Intent i = new Intent(ClubView.this, Brower.class);
                i.putExtra("key",w);
                startActivity(i);

            }
        });

    }
}