package cet.bbsr.app.CETBBSR;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TabHost;
import android.widget.TextView;
/**
 * Created by SM ROCKS on 12/27/2015.
 */
public class   About extends AppCompatActivity {
    ListView l1;
   TextView tv;
    ImageButton im1,im2,im3;
  Button b1,b2,b3;
   String p;
    TabHost tabs;
    public float   lastX;
    String vv="The College of Engineering & Technology, Bhubaneswar was established by the Government of Odisha in 1981 to meet the growing technical man power need in the State. It was a Constituent College of the Odisha University of Agriculture & Technology, Bhubaneswar since inception. After creation of a Technical University for Odisha State, the College has become a Constituent College of Biju Patnaik University of Technology (BPUT), Odisha with effect from 09th July, 2002 as per section-37(1) of BPUT Act, 2002.\n" +
            " \n" +
            " \t\t \n" +
            " \t\n" +
            "The College is located in the Techno-campus (an area of more than 100 Acres) at Kalinga Nagar, Bhubaneswar about 2.0 Kms. away from Khandagiri-Udayagiri caves. The College was shifted to the new Techno Campus in March, 2001. A full-fledged branch of Syndicate Bank is operating in the college campus. At present, students are residing in the Ladies Hostel (KCHR) of 500 capacity and a Boys Hostel (RHR) of 500 capacity inside the campus. Boys are also staying in a rented Hostel very near to Campus. The construction of another Ladies Hostel and Boys Hostel, Academic & Administrative Blocks with four-stored buildings, Bank ATM facility, Sports complex (gym), etc. are under full swing. Limited numbers of faculty quarters are available inside the campus.\n" +
            " \n" +
            "The College offers a five-year Under Graduate degree courses in Architecture (B.Arch.) and four-years B.Tech. degree in Biotechnology, Civil Engineering, Computer Science & Engineering, Electrical Engineering, Fashion & Apparel Technology, Information Technology, Instrumentation & Electronics Engineering, Mechanical Engineering and Textile Engineering. A three year Post Graduate course, Master in Computer Application (MCA) is also offered. In addition to the above courses M.Tech. courses in Structural Engineering (in the Department of Civil Engineering), Computer Science & Engineering, Information Technology and Industrial Engineering & Management (in Mechanical Engineering Department) have been running from Academic Year 2005-06. Master degree programme in Architecture i.e. M.Arch. has been running from the academic session 2007-08.\n" +
            " \n" +
            "In the academic year 2013-14, three new PG prgrammes are running  i.e. M.Tech. in Power System Engineering (in the Department of Electrical Engineering), Electronics & Instrumentation Engineering (in the Department of Instrumentation & Electronics Engineering), Biotechnology  (in the Department of Biotechnology) and 02-years M.Sc. in Applied Chemistry (in Chemistry Department) are introduced from the current academic year 2014-15.\n" +
            " \n" +
            "In the current academic year 2014-15, Odisha State Govt. introduced nine new PG prgrammes i.e. M.Tech. in Water Resources Engineering (in the Department of Civil Engineering), Geotechnical Engineering (in the Department of Civil Engineering), Power Electronics & Drives (in the Department of Electrical Engineering),   Energy System Engineering (in the Department of Electrical Engineering), Electronics & Communication Engineering (in the Department of Instrumentation & Electronics Engineering), Signal Processing Engineering (in the Department of Instrumentation & Electronics Engineering), Thermal Engineering (in the Department of Mechanical Engineering), Design & Dynamics (in the Department of Mechanical  Engineering),Textile Chemical Processing  (in the Department of Textile Engineering). Also four numbers of Integrated courses like 05-years Integrated M.Sc. in Mathematics and Computing, 02-years M.Sc. in Mathematics and Computing, 05-years Integrated M.Sc. in Applied Physics, 02-years M.Sc. in Applied Physics and 05-years Integrated M.Sc. in Applied Chemistry are introduced from the current academic year 2014-15.\n" +
            " \n" +
            "Students are admitted into this College through JEE conducted by the Govt. of India/Odisha. Student intake for the academic year 2013-14 has been increased from 517 to 957 i.e. in B.Tech. Mechanical Engg. from 45 to 120, B.Tech. Electrical Engg. from 45 to 120, B.Tech. I&E Engg. from 30 to 120 and B.Tech. Civil Engg. from 30 to 120 considering the need of technical manpower in the State.";
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
        setContentView(R.layout.about);
        tabs = (TabHost) findViewById(R.id.tabHost6);
        tv=(TextView)findViewById(R.id.textView16);
        im1=(ImageButton)findViewById(R.id.imageButton20);
        im3=(ImageButton)findViewById(R.id.imageButton21);
        im2=(ImageButton)findViewById(R.id.imageButton22);
        l1=(ListView)findViewById(R.id.listView6);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button10);
        b3=(Button)findViewById(R.id.button11);
        String devlop[] = {"BIBHUPADA MEHER\n"+"Android App Admin","RUTURAJ MOHANTY\n"+" Database Admin ","SOMESH BOSE\n"+"Android App","LALUPRASAD LENKA\n"+"Website","AVISHEK DAS\n"+"Website","ASUTOSH HOTA\n"+"Content","RONIT MOHANTY\n"+"Graphics"};
       final String fac[] = {"https://www.facebook.com/bibhupada.meher","https://www.facebook.com/profile.php?id=100007028059285&fref=ts","https://www.facebook.com/somesh.bose.505?fref=ts", "https://www.facebook.com/laluprasad.lenka.3?fref=ts","https://www.facebook.com/profile.php?id=100006505362384&fref=ts","https://www.facebook.com/asutosh.hota?fref=ts","https://www.facebook.com/ronit.mohanty.3?fref=ts"};
        final String mob[]={"7381885658","9658763292","9040118425","8895498815","8908904383","91247 33741","8984478588"};
        final String eml[]={"bibhupada.meher@gmail.com"," kanha95@gmail.com" , "smartsomebose635@gmail.com","laluprasad.lenka95@gmail.com","avishek060796@gmail.com","asutosh.hota@gmail.com","" };
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("ABOUT");
        tabs.addTab(spec);

        TabHost.TabSpec speca = tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab2);
        speca.setIndicator("BRAIN BOX");
        tabs.addTab(speca);
       tv.setText(vv);
        im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About.this, Brower.class);
                i.putExtra("key", "http://cet.edu.in/");
                startActivity(i);
            }
        });
        im2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About.this, Brower.class);
                i.putExtra("key", "https://en.wikipedia.org/wiki/College_of_Engineering_and_Technology,_Bhubaneswar");
                startActivity(i);
            }
        });
        im3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(About.this, Brower.class);
                i.putExtra("key", "https://www.facebook.com/CETBhubaneswar-121094121241690/");
                startActivity(i);
            }
        });
       ArrayAdapter<String> ad1 = new CustomAdapter(this, devlop);
        l1.setAdapter(ad1);
         l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                       @Override
                                       public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                                           PopupMenu popup = new PopupMenu(About.this, view);
                                           popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                                           popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                                                public boolean onMenuItemClick(MenuItem item) {

                                                                                    String k = (String) item.getTitle();
                                                                                    if (k.equals("call")) {
                                                                                        p = mob[position];
                                                                                        call();
                                                                                    } else if (k.equals("facebook")) {
                                                                                        Intent i = new Intent(About.this, Brower.class);
                                                                                        i.putExtra("key", fac[position]);
                                                                                        startActivity(i);
                                                                                    } else {
                                                                                        Intent email = new Intent(Intent.ACTION_SEND);
                                                                                        email.putExtra(Intent.EXTRA_EMAIL, new String[]{eml[position]});
                                                                                        email.setType("message/rfc822");
                                                                                        startActivity(Intent.createChooser(email, "choose an email client"));
                                                                                    }
                                                                                    return true;
                                                                                }
                                                                            }

                                           );

                                           popup.show();
                                       }
                                   }

         );
        b1.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View v) {
                                      Intent i = new Intent(About.this, Brower.class);
                                      i.putExtra("key", "http://goo.gl/forms/28LJpkdYDS");
                                      startActivity(i);
                                  }
                              }

        );
        b2.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View v) {
                                      Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                                      sharingIntent.setType("text/plain");
                                      String shareBody = " Notice,events,hot-buttons about the most happening college of BBSR?YOU,RE just at the RIGHT Place.DOWNLOAD & explore MORE!  https://play.google.com/store/apps/details?id=cet.bbsr.app.CETBBSR";
                                      sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Download CET-BBSR app");
                                      sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
                                      startActivity(Intent.createChooser(sharingIntent, "Share via"));
                                  }
                              }

        );
        b3.setOnClickListener(new View.OnClickListener()

                              {
                                  @Override
                                  public void onClick(View v) {


                                      Uri uri = Uri.parse("market://details?id=" + "cet.bbsr.app.CETBBSR");
                                      Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                                      // To count with Play market backstack, After pressing back button,
                                      // to taken back to our application, we need to add following flags to intent.
                                      goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                              Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                                              Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                                      try {
                                          startActivity(goToMarket);
                                      } catch (ActivityNotFoundException e) {
                                          startActivity(new Intent(Intent.ACTION_VIEW,
                                                  Uri.parse("http://play.google.com/store/apps/details?id=" + "cet.bbsr.app.CETBBSR")));
                                      }
                                  }
                              }

        );

         }
    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" +p));
        startActivity(callIntent);
    }
    }