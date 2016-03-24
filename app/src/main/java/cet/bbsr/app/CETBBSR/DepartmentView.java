package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SM ROCKS on 1/13/2016.
 */

public class DepartmentView extends AppCompatActivity {
   TextView t1,t2,t3;
    ImageView im;
    ListView li;
    String cal;
    TabHost tabs;
    int p,q;
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

  int kk[][]={{0,0,0},{0,0,1,0,0,0},{0,0,0,0,1,0,0,1,1,1,1,1,1,1,1,1,1},{0,0,1,0,0,0,1,1},{1,0,0,0,0,0,0,1,1,1,1,0,1,1,1,},{0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0},{0,0,1,1,1},{0,0,0,1,0,0,1,1,1},{0,0,1,0,0,0,0,0,1,1,1,0,1},{0,0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,1,1},{0,0,0,0,0},{0,1,1,1,1,1,1,0,0,0,1,1,0},{1,1,1},{0,0,0,1}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departmentview);
        Bundle bundle = getIntent().getExtras();
         p = bundle.getInt("key");
      int image[]={R.drawable.aaa,R.drawable.abb,R.drawable.acc,R.drawable.x,R.drawable.add,R.drawable.aee,R.drawable.aff,R.drawable.agg,R.drawable.ahh,R.drawable.aii,R.drawable.ajj,R.drawable.akk,R.drawable.all,R.drawable.amm};
        String dept[]={" Architecture Engineering\t \n" , " Biotechnology\t \n" , " Civil Engineering\t \n" , " Computer Science & Application (MCA)\t \n" , " Computer Science & Engineering\t \n" , " Electrical Engineering\t \n" , " Fashion & Apparel Technology\t \n" , " Information Technology\t \n" , " Instrumentation & Electronics Engineering\t \n" , " Mechanical Engineering\t \n" , " Textile Engineering\t \n" , " Mathematics & Humanities\t \n" , " Physics\t \n" , " Chemistry\t"};


        t1=(TextView)findViewById(R.id.textView3);
        t2=(TextView)findViewById(R.id.textView4);
        t3=(TextView)findViewById(R.id.textView41);
        im=(ImageView)findViewById(R.id.imageView8);
        li=(ListView)findViewById(R.id.listView8);
        tabs = (TabHost) findViewById(R.id.tabHost9);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("DEPARTMENT");
        tabs.addTab(spec);

        TabHost.TabSpec speca = tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab2);
        speca.setIndicator("FACULTY");
        tabs.addTab(speca);
       String st[]={"The plan of study of the Dept. of Architecture was established 1988 and provides an introduction in to the discipline of design and physical planning in response to human needs, cultural values and technological concerns. The students explore graphics in the state of art computer labs equipped with software like AutoCAD 2005, 3d max6 Draw12, Photoshop7 etc and display their works in the well equipped studios and pore through an extensive collection of magazines, journals. Facilities like modern scanners copiers, CAD tools and complete photography lab are with in the reach of the students. They work closely with a faculty specializing in urban design, landscape architecture, city planning, architectural conservation etc. In the past few years the dept has organized major events like the national association of student of architecture (NASA), Zonal NASA conventions and a Kodak sponsored workshop on the Architecture Photography. Renowned architects of national repute and distinguished professors among the leading technical institutes, such as IIT, SPA, New Delhi visit the dept regularly to attend seminars and conduct workshop. The students forum of the dept takes active participation in the celebrating events like World Photography Day, World Habitat Day, Earth Day etc. It also exclusively maintains a frequently changing exhibits section. This Department offer M.Arch. course.",
       "The Department of Biotechnology was established in the year 2007-2008 academic session with a B.Tech. Biotechnology with intake capacity of 30 students. At present department have operational microbiology, biochemistry and molecular biology and Plant Tissue culture laboratories with advanced equipments. The department is in process of setting up bioinformatics lab shortly. At present one research project from UGC-DAE CSR, Kolkata, on bioremeditation of hexavalent chromium using stress tolerant microbes isolated from chromite mine environments of Orissa is being implemented by Dr. Thatoi, HOD and another project on assessment of Nutritional and medicinal potential of Indigenious mushrooms Similipal Bioresphere Reserve, Orissa has been sanctioned by Dept. Of Science and Technology, Govt. of Orissa to HOD, Dr. Thatoi.",
       "The Department was established in 1981 with the inception of the college. The Department boasts of a faculty that specializes in the fields of structure engineering, earthquake engineering, facture mechanics, hydrology, water resources, foundation engineering, transportation engineering, construction management, entrepreneurship and environmental engineering. The labs are fully equipped to enhance the knowledge of the student, periodic field trips and visits to various project sites are arranged. Special lectures and seminars are held on a frequent basis to help them tailor in their particular areas of interest. The department maintains the environmental citizenship cell of the college and distributes work on the government funded projects among its student. The department also undertakes consultancy work and martial testing in its well equipped labs for various organizations. This Department offer M.Tech. in Structural Engineering with effect from 2005.",
       "The Department established in 1993 and it offer Master in Computer Applications (MCA). MCA course has been designed to generate quality System Analyst and software professionals. Specialized topics offered are Robotics, Computer Communication and distributed Processing, Image Processing, Object Oriented Programming, Simulation Modeling, Distributed and object oriented Database systems and natural language processing, Parallel Computing, Internet and Multimedia information system Design, Neural networks and fuzzy systems. The department lays stress on the practical and application based aspects through laboratories, seminars, group discussions, viva-voce and project work, keeping pace with the growth in computer technology. Students are given scope to conduct experiments on innovative ideas. With the need of changing technology the department up-dates the standard of its syllabi and staff orientation through continuous feedback interactions and exchange of ideas with industries and other institutions, staff training and motivational seminars.\n",
       "The Department of Computer Science & Engineering since its introduction in 2001 has taken several steps towards development and come a long way in establishing itself a department which commands both respect and importance. It is equipped with sophisticated laboratories and well qualified faculties who are not only technically skilled but also professionally competent. Faculty members have obtained recognition through publication at the national and international level in the areas of neural networks, pattern recognition and image processing etc. The chief co-ordinator has undertaken the AICTE project on MODROB, Govt. Teacher’s training program for Dept. of Higher Education. Govt. of Orissa. Apart from classroom teaching, students are made adept in the sessional at the digital logic design lab, microprocessor lab, computer network and internet lab. The students have a 12-hour guide access to the Internet lab and are given a free hand in using the services of printers and scanners. The department also conducts seminars on a regular basis which helps the students in keeping pace with recent developments in the field of information science. The students of this++ department have undertaken project assignments in developing software for college timetable, student attendance registers, library information system which helps them to gain practical knowledge in real world problem. This Department offer M.Tech. in Computer Science & Engineering.",
       "The Department of Electrical Engineering was started in the year 1982. The department focuses on utilizing its unbound resources to craft creative solutions to real world problem. The students are updated on the cutting edge technologies motivated by the faculty to pursue higher education. Our students have extended their brilliant academic record in various institutions of higher learning like IISC, IITs, IIMs etc. Software engineering is minutely interwoven in the curriculum with the students working in the CAD/CAM/CAE as well as C, C++, VB. The students of electrical engg undertake project work focused on latest development in core and associated electrical domain such as electric drives, static controllers, power system operation and control, VAR compensation, optimization technique applied to electrical system, CAD/CAM, telecommunication network, microprocessor and microcontroller based system, PLC based system, Instrumentation & measurement based system, VLSI & embedded system and some software related field. Students show their creative and innovative idea in laboratory and project work beyond the specified syllabus. The students are exposed to industrial environment during their summer training after 2nd and 3rd year in various reputed organizations like Rourkela Steel plant, National Aluminum Company, Hindalco, NTPC, TTPS, Gridco and many more. Students participate in various national level techno cultural activities and bring laurels for the institution as well as for the department. Techno cultural activities are organized by the Electrical Engg. Student Society (EESS) in the name of ‘URZAA’ annually with the active support & guidance of faculty members of the department.. The faculty members participate in Govt. sponsored project work in the field of Electrical Engg. The dept. of electrical engg is striving hard to impact quality teaching so as to make the students confident enough in shouldering their duties and responsibilities as power engineer in binding the nation.",
       "College of Engineering & Technology (CET), one of the leading Technical institution of Eastern Part of India have a reputation of producing world-class engineers. Looking at the enormous potential of Garment & Fashion Designing in the present century, CET has well planned in this race by adding a new dimension by introducing B. Tech course in Fashion Technology in to its credit with a vision to exploit and expose the creativity of young talented Fashion Technocrats in the globe. The unique Traditional designs of Garments & Lifestyle of India have been greatly appreciated globally. In this context Fashion Designers have a great role to play. Department of fashion Technology is one of the leading department of college of engineering and Technology. The design of the course structure aims at producing highly trained professionals, who will have the right expertise to guide the garment industry for using high technology and better designing skills, consistency in product quality, price and services, which have a great bearing on importers as well as home markets. Also the constant interaction with the garment industry instills in the students, the confidence in their own ability to keep up with the competitive industrial world.",
       "The Department of Information Technology was established in 2001. The curriculum of B.Tech (Information Technology) is the most updated to meet the global standard. Latest development in the field of IT such as J2EE, Bio-informatics, Microelectronics, VLSI design, Data Mining and Data warehousing are offers as electives to student who are not far always for the real world situation. The very innovative and unique course of study has also ensure that the top ranking student of the state opt to be indicted in to this branch. The guidance too comes from a team of dedicated and highly qualified faculty members.The students have access to the computer lab which has a state of art software .Also to develop the communicative skill of students, the department conducts regular seminars and group discussion which are frequently attended by experts from industries.",
       "The Department of Instrumentation and Electronics Engineering was established in 1992. It is equipped with sophisticated laboratories and well qualified faculty. The students are made adept in the sessional at the microprocessors and pc lab, process control and instrumentation and device lab. These labs provide facilities for microprocessors and computer based temperature, pressure, flow and level. Control Engg. Lab adds to the further expertise in electrical, mechanical and electromechanical application based experiments. The dept. also possesses an in house computer hardware lab& PC lab. It has many 8bit/12bit/32bit processor based computer that are connected in the both Linux and Windows NT operating system environment. Other software package like PSPICE, MATLAB, VISUAL STUDIO, JAVA etc. are used for computer aided projects. These help the student in keeping pace with the recent developments in the field of information since and engg. And at the same time enhancing and strengthening their knowledge by designing packages required to solve real life problem. The faculty specializes in the field of process control & instrumentation, telecommunication engg. Digital system, automation engineering, biomedical instrumentation, artificial intelligence, microelectronics, electronic communication system etc.",
       "The Department of Mechanical Engineering is one of the earliest department established in 1981 . It has faculty specialized in the field of machine design and dynamics, production engg.,industrial engineering & management, thermal engg. The Mechanical Lab is equipped with FFT analyzers, vibration and acoustic instrument from diagnostic instruments (UK). CAD/CAM lab has HP workstations, Core2Duo based computers, laser printers and scanners, software both for designing and programming like NISA, ANYSYS, MASTERCAM, AutoCAD2005, Tk Solver, MATLAB, CAFIMS. The mechanical lab has also facilitates in different domains like heat transfer, heat power, refrigeration & air conditioning, Hydraulic machines, IC engines, Machine dynamics and material testing etc. Mechanical workshop has various types of lathes (HMT, NC, CNC), Milling (HMT), Drilling, shaping, grinding machines, etc. Flexible manufacturing labs in corporated CNC systems, Robot and Machine vision system. The welding shop consists of gas welding, arc welding and TIG & MIG welding equipments. The material testing lab is equipped with universal testing machine, hardness testing machine, etc. The department has carried out number of AICTE funded projects.",
       "The B.Tech programme in Textile Engineering was introduced at Institute of Textile Technology, Choudwar in the year 1994-95. Subsequently, this Degree stream in Textile Engineering was merged with College of Engineering & Technology (CET), Bhubaneswar as a Department of Textile Engineering with effect from 1st January 2007 by the decision of State Govt. vide Resolution No. 17277/I dtd.17.11.06 of Industries Department, Govt. of Orissa in view of starting a B.Tech in Bio-Technology course at College of Engineering & Technology, Bhubaneswar The Department of Textile Engineering, CET-Bhubaneswar presently conducts undergraduate programme in Textile Engineering with the objective of imparting comprehensive knowledge in all the facets of textile manufacturing which include Yarn manufacturing, Fabric Manufacturing (Woven and Knitted), Garment manufacturing, Textile Chemical Processing, Textile testing, Quality assurance, Mill management and Computer applications. In order to expose the students into the industrial environment of the textile Industries, four weeks of Industrial training is incorporated compulsorily as a part of the curriculum. Project work with a Thesis in the final year is also mandatory for completion of the Course for each student under the guidance of a faculty member.",
       "comming soon", "comming soon", "comming soon"};
        im.setImageResource(image[p]);
        t1.setText("Department of" + dept[p]);
        t3.setText("Department of"+dept[p]);
        t2.setText(st[p]);


        final String lec[][]={{"   Mr.   Sangram Mohanty \n" + "\t Head of the Department\n" , "     Dr.  Hara Narayan Dash \n" + "     Reader\t \n" , "     Mr.  Partha Pratim Karmakar    \n" + "\tReader\n" + "\t"},
                {"\tMr.   Madhabananda Pattanaik\n" + "\t  Head of the Department\n" ,"\t Mr.  Sripad Chandan Patnaik\n" + "     Lecturer\t \n" ,"\t Dr.  Mrs. Supriya Dash    \n" +"\t Lecturer\n" ,"\t Mr.  Swagat Kumar Das    \n" + "     Lecturer\n" ,"\t Dr.  Suraj Kumar Nayak     \n" + "\t Lecturer\n" ,"\t Mr.  B Baliyarsingh   \n" + "     Lecturer"},
                {"Dr.   Falguni Baliarsingh \n" + "Head of the Department\n" ,"Dr.  Prof. Pravat Kumar Parhi \n" + "Professor\t \n" ,"Dr.  Hemant Kumar Dash   \n" + "Associate Professor\n" ,"Dr.  Umesh Mishra      \n" + "Associate Professor\n" , "Mrs.  Sabita Dash \n" + "Associate Professor\n" ,"Dr.  Deba Prakash Satapathy    \n" + "Assistant Professor\n" , "Mr.  Pramod Kumar Behera    \n" + "Assistant Professor\n" ,"Ms.  Pramodini Sahu   \n" + "Assistant Professor\n" , "Ms.  Swetalina Nath  \n" + "Assistant Professor\n" ,"Ms.  Benazeer Sultana   \n" + "Assistant Professor\n" ,"Ms.  Chhabirani Tudu    \n" + "Assistant Professor\n" ,"Ms.  Rosalin Dalai    \n" + "Assistant Professor\n" , "Ms.  Siprarani Pradhan  \n" + "Assistant Professor\n" , "Mrs.  Madhusmita Mishra  \n" + "Lecturer\n" ,"Ms.  Madhusmita Mishra   \n" + "Lecturer\n" ," Mrs.  Subhasri Panda  \n" + "Lecturer\n" ,"Mrs.  Soumya Prakash     \n" + "Lecturer\n"},
                {"Dr.   Jibitesh Mishra \n" + " Head of the Department\n" ," Dr.  Ranjan Kumar Dash     \n" +" Associate Professor\n" ,"Mrs.  Swarnalata Pati     \n" + "  Assistant Professor\n" , "  Mr.  Debasis Gountia     \n" + " Assistant Professor\n" , " Mr.  Manjit Kumar Nayak     \n" + " Assistant Professor\n" ," Mr.  Subasish Mohapatra\n" + " Assistant Professor \n" ,"Mrs.  Susmita Pal    \n" + "Lecturer\n" ,"Mrs.  Rojalin Mallick   \n" + " Lecturer"},
                {"Mrs.   Swarna Lata Pati\n" + "  Head of the Department\n" , "Dr.  Prof. Prashanta Kumar Patra     \t\n" + " Professor\n" ,"Dr.  Pradip Kumar Sahu   \n" + " Assistant Professor\n" ,"Mr.  Manoranjan Panda  \n" + "Lecturer\n" ,"Mr.  Ashis Kumar Mishra     \n" + "Lecturer\n" ,"Mr.  Tapan Kumar Nayak     \n" + "Lecturer\n" ,"Mr.  Amitav Mahapatra     \n" + "Lecturer\n" , "Mrs.  Pranati Mishra    \n" + "Lecturer\n" ,"Mrs.  Subhalaxmi Das     \n" + "Lecturer\n" ,"Mrs.  Sanjukta Mohanty     \n" + "Lecturer\n" ,"Mrs.  Sweta Acharya     \n" + "Lecturer\n" ,"Mr.  Tapas Kumar Choudhury    \n" + "Lecturer\n" , "Ms.  Jyotirmayee Routray    \n" + "Lecturer\n" ,"Mrs.  Subhadarshini Mohanty    \n" + "Lecturer\n" , "Mrs.  Meenakshi Pant     \n" + "Lecturer "},
                {"Dr.   Ranjan Kumar Jena    \n" + "Head of the Department\n" ,"Dr.  Prasanta Kumar Satpathy     \n" + "Professor\n" ,"Dr.  Durgesh Prasad Bagarty    \n" + "Associate Professor\n" ,"Mr.  Abhimanyu Mohapatra    \n" + "Associate Professor\n" ,"Dr.  Meera Viswavandya    \n" + "Associate Professor \n" ,"Mr.  Kamlesh Chandra Rout    \n" + "Assistant Professor\n" , "Mr.  Rudra Narayan Pradhan    \t \n" + "Assistant Professor\n" ,"Mr.  Chakrapani Ghadai     \t \n" + "Assistant Professor\n" ,"Mr.  Ranjib Behera     \n" + "Assistant Professor\n" ,"Ms.  Jasmine Hansda    \n" + "Assistant Professor\n" , "Mr.  Neelakantha Guru    \n" + "Assistant Professor\n" , "Mr.  Santanu Sen     \t\n" + "Assistant Professor\n" , "Mr.  Dipak Ranjan Swain     \n" + "Assistant Professor\n" , "Mr.  Anjan Kumar Sahoo   \n" + "Assistant Professor\n" , "Ms.  Samikshya Mishra    \n" + "Assistant Professor\n" , "Ms.  Moningi Srivalli   \n" + "Assistant Professor\n" ,"Ms.  Sudipta Mohanty    \n" + "Assistant Professor\n" ,"Ms.  Twinkle Kisku     \n" + "Assistant Professor\n" ,"Ms.  Minakhi Behera   \n" + "Assistant Professor\n" , "Mr.  Samarjit Patnaik   \t\n" + "Assistant Professor \n" ,"Mrs.  Rashmirekha Nayak   \n" + "Lecturer\n","Ms.  Aditi Mohapatra    \n" + "Lecturer\n" ,"Mrs.  Mita Behera    \n" + "Lecturer\n" , "Mr.  Narottam Maharana     \n" + "Lecturer\n" ,"Mr.  Prasanta Kumar Rana   \n" + "Lecturer"},
                {"Dr.   Asimananda Khandual\n" + "Head of the Department\n" ,"Mr.  Madhaba Nanda Pattanaik   \n" + "Assistant Professor\n" , "Mrs.  Bijaylaxmi Sahu   \n" + "Lecturer\n" ," Mrs.  Madhusmita Das    \n" + "Lecturer\n" ,"Ms.  Kirti Ghosh     \t\n" + "Lecturer"},
                {"Dr.   Ranjan Kumar Dash  \n" + "Head of the Department\n" , "Dr.  Jibitesh Mishra   \n" + "Associate Professor\n" ,"Mr.  Sanjit Kumar Dash   \n" + "Lecturer\n" ,"Mrs.  Jayshree Dev    \n" + "Lecturer\n" , "Mr.  Debi Prasad Mishra   \n" + "Lecturer\n" , "Mr.  J. Chandrakanta Badajena     \n" + "Lecturer\n" ,"Mrs.  Rajalaxmi Padhy    \t\n" + "Lecturer\n" ,"Ms.  Swati Lipsa   \n" + "Lecturer\n" ,"Mrs.  Rupa Madhuri Paanaik      \n" + "Lecturer"},
                {"Dr.   Sribatsa Behera \n" + "Head of the Department\n" ,"Dr.  Chandrabhanu Mishra     \n" +"Associate Professor\n" , "Dr.  Aruna Tripathy   \n" + " Associate Professor\n" , "Mr.  Tapas Kumar Patra     \n" + " Assistant Professor\n" , " Dr.  Kanhu Charan Bhuyan     \n" + " Assistant Professor\n" , " Dr.  Madhab Chandra Tripathy     \n" + " Assistant Professor\n" ," Mr.  Jagannath Sethi    \n" + " Assistant Professor\n" , " Mr.  Sushanta Kumar Sahu     \n" + " Assistant Professor\n" ," Ms.  Abhyarthana Bisoyi   \n" + " Assistant Professor\n" ," Ms.  Rashmi Rekha Sahoo   \n" + " Assistant Professor\n" ," Ms.  Soumyashree Mangaraj   \n" + " Assistant Professor\n" ," Mr.  Debi Prasad Dash   \n" + " Assistant Professor\n" ," Ms.  Satyabhama Dash    \n" + "  Assistant Professor"},
                {"Dr.   Rati Ranjan Dash \n" + " Head of the Department\n" ,"Dr.  Loknath Panda   \n" + "Professor\n" , "Dr.  Prashant Kumar Satpathy    \n" + " Associate Professor\n" , " Dr.  Ranjit Kumar Das    \n" + "Associate Professor\n" , "Dr.  Ashok Mohanty     \n" + "Associate Professor\n" , "Dr.  Saroj Kumar Pradhan    \n" + "Associate Professor\n" , "Dr.  Ramesh Kumar Mallik    \n" + "Associate Professor \n" ,"Dr.  Pramod Kumar Parida    \n" + "Assistant Professor\n" , "Ms.  Sarmistha Parija     \n" + "Assistant Professor\n" , "Mr.  Santosh Maharana    \n" + "Assistant Professor\n" , "Dr.  Sudhansu Sekhar Sahoo     \n" + "Assistant Professor\n" , "Mr.  Ashok Kumar Barik    \n" + "Assistant Professor\n" ,"Mr.  Priya Ranjan Mallick     \n" + "Assistant Professor\n" , "Mr.  Bishnu Narayana Mohapatra     \n" + "Assistant Professor\n" ,"Mrs.  Soumya Trupti Sahoo    \n" + "Assistant Professor\n" , "Ms.  Runu Das   \t\n" +"Assistant Professor\n" , "Ms.  Smitanjali Behera     \n" +"Assistant Professor\n" ,"Ms.  Rasmita Parida     \n" + "Assistant Professor"},
                {"Dr.   Bibhu Prasad Dash\n" + "Head of the Department\n" , "Mr.  Kedarnath Das    \n" + "Assistant Professor\n" ,"Mr.  Aswini Kumar Dash    \n" + "Assistant Professor\n" , "Dr.  Asimananda Khandual    \n" + "Assistant Professor\n" , "Mr.  Sujit Kumar Acharya     \n" + " Lecturer"},
                {"Dr.   Minakshi Prasad Mishra  \n" + "  Head of the Department\n" ,"Dr.  Geetanjali Pradhan    \n" + "Assistant Professor\n" ,"Mrs.  Sthitapragna Tripathy    \n" + " Lecturer\n" ," Mrs.  Mita Sharma     \n" + "Lecturer\n" ,"Mrs.  Sagarika Biswal     \n" + "Lecturer\n" ,"Mrs.  Swagatika Das    \t\n" + "Lecturer\n" , "Dr.  (Mrs.) Sasmita Mishra    \n" + "Lecturer\n" ,"Mr.  Shreemanta Kumar Tripathy    \n" + "Lecturer\n" ,"Mr.  Sudhansu Sekhar Routray    \n" + "Lecturer\n" ,"Mr.  Bipin Bihari Dash    \t\n" + "Lecturer\n" ,"Mrs.  Sangeeta Dash    \n" + "Lecturer\n" ,"Ms.  Sai Rashmi Patra    \n" + "Lecturer\n","Dr.  Prasanna Kumar Mishra    \n" + "Lecturer"},
                {"Dr.   Babita Ojha  \n" + "  Head of the Department\n" ,"Ms.  Rizwana Khanum     \n" + "Lecturer\n" ,"Mrs.  Pratima Beura   \n" + "Lecturer"},
                {"Dr.   Bigyan Ranjan Das  \n" + "   Head of the Department\n","Dr.  Achyuta Nanda Acharya     \n" + " Associate Professor\n" , "Mr.  Biswajeet Samantaray    \n" + " Lecturer\n" ,"Ms.  Rasmita Kumari Sahu     \n" + " Lecturer"}};



        ArrayAdapter<String> ad2=new CustomAdapter(this,lec[p]);
        li.setAdapter(ad2);


           final String phone[][]={{" 9338202668",  "9438421789" ,"9437101328  "},
                   { "=", "8895084630","9437287797", "9040251794", "9437155632",  "9437155632 "},
                   {"9437136441",  "9437176889","9437280304",  "9437019410" ,"9437374185","9861761399","9937667809","7381016151","7540889826","9861350815","9439860601","9861429643","=", "9778760027","8763003679", "9437812454","8763554678"},
                   {"9337830226","9437360517", "9437101903","9437229338","9692268809","9437319132", "9437389327","9778574484"},
                   {"=", "9437189863",  "9437141295","9437205692" , "9437528657",  "9337661692","9937383858","9861160918","8763003065","7894590307", "9439317628","9861611672","9778178506"  ,"8895348397"  ,"9437158656"},
                   {"9437040077","9437136445",  "9437536771",  "8895274047",  "9437271790", "9778811437", "9937113432", "9937403991","9778429611", "8875500778","9658342905","9692362384","9437171236" ,"9937998133","8908028823",   "9668866744", "9861197798", "9555130996",  "8895638889","9438488168",   "9937579562","9778584441", "9337289048",  "9438048782","7205580124"},
                   {"=", "9437131796", "9337448088", "8908541775","9040175399"},
                   {"9437360517",  "9337830226","9437990892","9437106071","9438435574","9861009135","9658243671","9861309979", "9438051444"},
                   {"9437420486" ,"9438730805",  "9438708280","9438020131","9861371196"  ,"9437159368","9692001046", "9861146370",  "9437885898",  "9439850854", "9778848302",  "8093326112", "9438491806"},
                   {"9437040814","9861232953","9439339219", "9438012367","9438180389","9668124770", "9861048277",  "9437131795","9861285100","9861272248", "9337645056","7873971418","9938748080","7735430820", "9776784974", "9853366983","8908943376","7504616167"},
                   {"9437385554","9861234960", "9437449510","7381059050", "9853325245"},
                   {"9861089261","9437922496","8984239381","9853560479", "9437221002", "9438042656","9439364945","9853309284","9437004523","9437366599","9040012579","9338225346","9437211153"},
                   {"9861387760", "9438747108",  "9937040432"},
                   {"9437182654","9437273851", "9437229745","9439325568"}};

        final String emaill[][]={{"=" ,"hndash@cet.edu.in"   ,"ppkarmakar@cet.edu.in"},
                {"=",  "scpattnaik@cet.edu.in",  "dashsupriya08@gmail.com",  "das.swagat@gmail.com",  "surajnayak3@gmail.com",  "amu7bio@rediffmail.com"},
                {"=",  "pkparhi@cet.edu.in",  "hkdash@cet.edu.in",  "="  ,"sabitadash06@gmail.com",  "dpsatapathy@cet.edu.in",  "pramodbeheraiitkgp@gmail.com" , "pramodini.sahu@gmail.com",  "swetalinace@cet.edu.in" , "benazeerce@cet.edu.in",  "chhabiranice@cet.edu.in",  "rosalin.iitk@gmail.com", "srpradhance@cet.edu.in",  "madhusmitamishraa@gmail.com",  "mishramadhusmita1986@gmail.com",  "subhasri81@yahoo.com",  "soumyaprakash0312@gmail.com"},
                {"=", "rkdash@cet.edu.in",  "spati@cet.edu.in", "dgountia@gmail.com",  "manjitcsa@cet.edu.in",  "smohapatra@cet.edu.in",  "susmitapl@yahoo.com",  "rojalinmallick@gmail.com"},
                {"=", "=", "pradip@cet.edu.in",  "mpanda@cet.edu.in",  "akmishracse@cet.edu.in",    "tapannayakcse@cet.edu.in",  "amitavmahapatracse@cet.edu.in",  "pranatimishracse@cet.edu.in", "sdascse@cet.edu.in",  "smohantycse@cet.edu.in",   "sacharyacse@cet.edu.in",  "tkchoudhurycse@cet.edu.in",    "jroutraycse@cet.edu.in","sdmohantycse@cet.edu.in"  ,"meenakshikandpal14@gmail.com"},
                {"rkjena@cet.edu.in",  "pksatpathy_ee@cet.edu.in",   "dpbagarty@cet.edu.in",  "amohapatra@cet.edu.in",   "mviswavandya@cet.edu.in",   "kcrout@cet.edu.in",  "rudranarayan@cet.edu.in",  "eecghadai@cet.edu.in",  "eeranjib@cet.edu.in",  "jasmine_hansda@yahoo.co.in",  "neelakanthaguru@gmail.com" , "sen.santanu072@gmail.com",  "dipu_best@yahoo.com",   "anjank.sahoo@gmail.com",  "samikshya.mishra3@gmail.com",  "m_srivalli@rediffmail.com",  "widusudipta@yahoo.co.in", "=", "minakhibehera1@gmail.com", "patnaik.samarjit@gmail.com",  "r.rashmi06@rediffmail.com", "mp3.aditi@gmail.com",  "behera.mita@gmail.com",   "nmigit25@gmail.com",  "prasanta.rana@gmail.com"},
                {"="," mnpattanaik@cet.edu.in",  "bijaylaxmi.cet@gmail.com",  "madhusmita.cet@gmail.com",  "kirtighosh1989@gmail.com"},
                {"=",  "jmishra@cet.edu.in", "skdash@cet.edu.in", "j1_d02@yahoo.co.in",  "dpmishra.07@gmail.com", "chand.cet@gmail.com",  "padhyrajalaxmi123@gmail.com",   "swatilipsa@gmail.com",  "rupamadhuri.mr@gmail.com"},
                {"sbehera@cet.edu.in"   ,"cmishra@cet.edu.in",  "atripathy@cet.edu.in",  "tkpatra@cet.edu.in",  "kcbhuyan@cet.edu.in",  "mctripathy@cet.edu.in",  "iejsethi@cet.edu.in",  "sushantaie@cet.edu.in",  "ieabisoyi@cet.edu.in",  "rrsahooie@cet.edu.in",   "smangarajie@cet.edu.in",  "dpdashie@cet.edu.in", "sdashie@cet.edu.in "},
                {"rrdash@cet.edu.in" , "lnpanda@yahoo.com",  "premdamayanti@yahoo.com",  "rkdas@cet.edu.in",  "amohanty01@yahoo.com",   "skpradhan@cet.edu.in", "rkmallik@cet.edu.in",  "pkparida@cet.edu.in",  "sarmistha_parija@yahoo.com",  "santha_ruby@yahoo.com",  "sudhansu@cet.edu.in",  "ashok_iit@hotmail.com",  "priyaranjan.mech@gmail.com",  "bnm.uce@gmail.com",  "sahoo.soumya1@gmail.com",  "runu_mech14@yahoo.com",  "sbeherame@cet.edu.in",  "rparidame@cet.edu.in"},
                {" bpdash@cet.edu.in",  "kndas@cet.edu.in",  "ashwinidash26@rediffmail.com",  "asimte@cet.edu.in"  ,"sujitkumaracharya@yahoo.co.in"},
                {"minakshiprasadmishra@gmail.com",  "geetanjalipradhan68@gmail.com",   "sthitiforu@gmail.com",  "mitasharma08@gmail.com",  "iamsagarika2005@gmail.com",   "swagatika.das@rediffmail.com",  "sasmita.gita@gmail.com",  "srimantrd@gmail.com",  "sudhansu31@gmail.com", "bbdasheng@gmail.com",  "sangitashree79@Gmail.com",  "sairashmi.p@gmail.com",    "mishrapkdr@gmail.com"},
                {"babitaojhacet@gmail.com" , "rkguddi077@gmail.com",  "pratimabeura123@gmail.com "},
                {"bigyandas07@gmail.com",  "anacharya@cet.edu.in",  "biswajit@cet.edu.in",   "rasmita.mita@gmail.com"}};


        li.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                q= position;
                PopupMenu popup = new PopupMenu(DepartmentView.this, view);
                popup.getMenuInflater().inflate(R.menu.popup_menu2, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                     public boolean onMenuItemClick(MenuItem item) {
                                                         Toast.makeText(DepartmentView.this,   item.getTitle(), Toast.LENGTH_SHORT).show();
                                                         String k = (String) item.getTitle();
                                                         if (k.equals("call")) {
                                                             if (phone[p][position].equals("=")) {
                                                                 Toast.makeText(DepartmentView.this, "phone no not available", Toast.LENGTH_SHORT).show();
                                                             } else {
                                                                cal=phone[p][position];
                                                                 call();
                                                             }
                                                         } else {
                                                             if (emaill[p][position].equals("=")) {
                                                                 Toast.makeText(DepartmentView.this, "email not available", Toast.LENGTH_SHORT).show();
                                                             } else {
                                                                 Intent email = new Intent(Intent.ACTION_SEND);
                                                                 email.putExtra(Intent.EXTRA_EMAIL, new String[]{emaill[p][position]});
                                                                 email.setType("message/rfc822");
                                                                 startActivity(Intent.createChooser(email, "choose an email client"));
                                                             }
                                                         }
                                                         return true;
                                                     }
                                                 }

                );

                    popup.show();
                }
            });
}
    public void call() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + cal));
        startActivity(callIntent);
    }
}