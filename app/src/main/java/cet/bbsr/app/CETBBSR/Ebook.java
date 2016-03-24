package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * Created by SM ROCKS on 12/27/2015.
 */


public class   Ebook extends AppCompatActivity {
    ListView l1, l2;
    Button b1,b2;
    Spinner sp,sp2;
    TextView tv;
    int k,z;
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
        setContentView(R.layout.ebook);
        l1 = (ListView) findViewById(R.id.listView4);
        l2 = (ListView) findViewById(R.id.listView5);
        sp=(Spinner)findViewById(R.id.spinner);
        sp2=(Spinner)findViewById(R.id.spinner2);
        tv=(TextView)findViewById(R.id.textView17);

        final String p="The e-library is a huge collection of  of e-books i.e consists of Text books,solution books,programming books,syllabus and bput lecture notes and a collection of video tutorials which consists of syllabus as well as programming tutorials. This small effort has been made by us to make ebooks easily available.you can suggest for any ebook or video tutorial by below link and send any books or notes through upload section or by a email to devloper team.";

        b1=(Button)findViewById(R.id.button7);
        b2=(Button)findViewById(R.id.button8);

        String col[]={"Select","Syllabus","Text Book","Reference Book","BPUT Lecture Note","Programming Book"};
        String col2[]={"Course","Programming"};
        final String ebook[][]={{" Btech First Year(all branch)\n" , " Architecture Engineering\t\n" , " \tBio-Technology\t \n" , " \tCivil Engineering\t \n" , " \tComputer Science & Application (MCA)\t \n" , " \tComputer Science & Engineering\t \n" , " \tElectrical Engineering\t \n" , " \tFashion & Apparel Technology\t \n" , " \tInformation Technology\t \n" , " \tInstrumentation & Electronics Engineering\t \n" , " \tMechanical Engineering\t \n" , " \tTextile Engineering\t "},

                        {"Advanced Engineering Mathematics 10th Edition\n" ,
                        "\tAlexander Chajes  Principles of Structural Stabil\n" ,
                        "\tAndrew Pytel  Jaan Kiusalaas  Ishan Sharma Engin\n" ,
                        "\tascii table characters\n" ,
                        "\tC by Denish Ritchie \n" ,
                        "\tC++ For DUMMIES\n" ,
                        "\tdata structures with c  by schaum series_2\n" ,
                        "\tDatabase System Concepts [6th Edition] - [Abraham Silberschatz, Henry F. Korth, S. Sudarshan\n" ,
                        "\tDiscrete Mathematics and Its Applications 7th Edition Rosen\n" ,
                        "\tElectric Machinery\n" ,
                        "\tElectric Power Transformer Engineering\n" ,
                        "\telectric power systems\n" ,
                        "\tElectrical Engineer Portable Handbook_0071418202\n" ,
                        "\tElectrical Power Systems Quality Second Edition\n" ,
                        "\tElectronic Devices and Circuit Theory 11th Ed\n" ,
                        "\tElementary Surveying - An Introduction to Geomatics 13th ed - E. Ghilani, P. Wolf (Pearson, 2012) BBS\n" ,
                        "\tfirst courses on power electronic and drives\n" ,
                        "\tflaganan handbook of transformer design applications\n" ,
                        "\tFluid Mechanics and Hydraulic Machines By BS Publications\n" ,
                        "\tFundamentals of Database Management Systems 2ed [2011]\n" ,
                        "\tFundamentals of Database Systems, 6th Edition\n" ,
                        "\tIntroduction to Algorithms 3rd Edition - Thomas H. Cormen, Charles E. Leiserson, R\n" ,
                        "\tjava the complete reference 7th edition\n" ,
                        "\tlet us c\n" ,
                        "\tlet us c++ yashwant kanetkar\n" ,
                        "\tMANAGEMENT PRACTICES AND ORGANISATIONAL BEHAVIOUR  DMGT402_e_book - Shrivastava - IBRG\n" ,
                        "\tManufacturing Technology 3e by p n rao\n" ,
                        "\tMastering-Algorithms\n" ,
                        "\tNumerical Methods for Engineers, Sixth Edition\n" ,
                        "\tOOP C++\n" ,
                        "\toops balaguruswamy\n" ,
                        "\tRosen Discrete Mathematics and Its Applications 7th Edition\n" ,
                        "\tstrength of material by r k bansal\n" ,
                        "\tSystem Programming with C and Unix - Adam Hoover\n" ,
                        "\tSystem Software An Introduction to Systems Programming - Leland Beck, Third Edition\n" ,
                        "\tsystems programming by donovan\n" ,
                        "\tSystems Programming [2015]\n" ,
                        "\tTheory Of Machines- 3E - By Rattan\n" ,
                        "\tthinking in java\n" ,
                        "\tThomas L. Floyd-Digital Fundamentals-Prentice Hall (2014)\n" ,
                        "\tTocci Digital Systems Principles and Applications 10th Edition\n" ,
                        "\tUnderstanding Electric Power Systems "},

                               {"boylestad solution manual electronic devices and circuit theory 10th edit\n" ,
                                "\tDiscrete Mathematics and Its Applications [7th Edition] - Kenneth H. Rosen Students Solutions Guidel\n" ,
                                "\tNumerical Methods for Engineers, Sixth Edition, solution manual\n" ,
                                "\tThermodynamics P K Nag Exercise problems - Solved\n" ,
                                "\tProgramming In ANSI C - Balagurusamy  Solutions with Flowchart & Programs\n" ,
                                "\tlet us c solutions"},

                      { "\tAdvance Control Systems\t\n" ,
                        "\tAnalog Electronics Circuit\t\n" ,
                        "\tControl Systems\t\n" ,
                        "\tDigial Switching and Telecommunication Network (7th Semester)\t\n" ,
                        "\tElectrical and Electronics Measurement\t\n" ,
                        "\tDigial Switching and Telecommunication Network (5th Semester)\t\n" ,
                        "\tManagerial Economics\t\n" ,
                        "\tMicroprocessors\t\n" ,
                        "\tNetwork Theory\t\n" ,
                        "\tProduct Design\t\n" ,
                        "\tNon Conventional Energy Sources\t\n" ,
                        "\tPower Plant Engineering\t\n" ,
                        "\tNetwork Theory (BEES2211, Electrical)\n" ,
                        "\tPower Plant Engineering\t\t\n" ,
                        "\tAnalog Electronics Circuit\t\n" ,
                        "\tSignal and System\t\n" ,
                        "\tElectrical and Electronics Measurement\t\n" ,
                        "\tEstimation, Costing & Professional Practice\t\t\n" ,
                        "\tKnitting\t\n" ,
                        "\tGarment Processing\t\n" ,
                        "\tTransportation Engineering\t\n" ,
                        "\tIntroduction to Physical Metallurgy and Engineering Materials\t\t\n" ,
                        "\tAnalog Communication Technques\t\n" ,
                        "\tMass Transfer - I\t\n" ,
                        "\tEnglish Communication Skills\t\n" ,
                        "\tFundamentals of Bio Medical Engineering\t\n" ,
                        "\tOrganisational Behaviour\t\n" ,
                        "\tEngineering Economics and Costing\t\n" ,
                        "\tMathematics - III"
                      }


                ,{   "Android Application Development for For Dummies\n" ,
                 "Ankit Fadia Hacking Guide\n" ,
                "Beginning Programming with Java For Dummies, 3rd Edition\n" ,
                "Beginning Programming with Python For Dummies\n" ,
                "Building Skills in OO Design Python\n" ,
                "c programming in linux\n" ,
                "Getting Started With Arduino 2ndEdition\n" ,
                "Hacking for Dummies 4th Edition\n" ,
                "Hacking with Kali\n" ,
                "Head First Servlets and JSP 2nd Edition - OReilly\n" ,
                "head first java second edition\n" ,
                "HTML5 For Dummies\n" ,
                "HTML5 Programming with JavaScript For Dummies\n" ,
                "Introduction to programming and the c language\n" ,
                "Learn Java for Android Development\n" ,
                "Linux All in One For Dummies  5th Edition (2)\n" ,
                "Programming PHP, 3rd Edition\n" ,
                "Programming Ruby, 2nd Edition\n" ,
                "programming python 4th edition\n" ,
                "Python For Dummies\n" ,
                "python pocket reference fourth edition\n" ,
                "Python Programming\n" ,
                "PythonBook\n" ,
                "structured programming with c-plus-plus\n" ,
                "The Art of Assembly Language, 2nd Edition"
              }
        };

       final String ebookloc[][]={
               {"https://files.acrobat.com/a/preview/186fc760-1759-4e99-86f8-ea85cc7c2e1b\n" ,
               "\thttps://files.acrobat.com/a/preview/160491f2-210a-4002-ad2c-5da59c89e7dd\n" ,
               "\thttps://files.acrobat.com/a/preview/335d7063-374f-4582-a2eb-a416b066b468\n" ,
               "\thttps://files.acrobat.com/a/preview/9e45f079-bb69-4f17-99ea-26f67faac757\n" ,
               "\thttps://files.acrobat.com/a/preview/039abba7-91a3-4179-adea-8104124ca34f\n" ,
               "\thttps://files.acrobat.com/a/preview/f30e5a18-4ff3-4fcd-be12-151b6584843e\n" ,
               "\thttps://files.acrobat.com/a/preview/cfe9e625-c4c7-4edb-82bd-3e7904f37cde\n" ,
               "\thttps://files.acrobat.com/a/preview/97608973-d9bd-4394-a61b-9bf587eca84e\n" ,
               "\thttps://files.acrobat.com/a/preview/b855697d-f53b-476e-b31a-4a23e1fcf813\n" ,
               "\thttps://files.acrobat.com/a/preview/96559dad-d7c7-4f43-9351-d6337cfeeb9e\n" ,
               "\thttps://files.acrobat.com/a/preview/2cf8fae9-84fa-49c8-819b-080ef82dde89\n" ,
               "\thttps://files.acrobat.com/a/preview/5462039f-387c-4720-8b54-692e7788bd7b"},

                       {"https://files.acrobat.com/a/preview/8ed7f31a-4981-4f57-966a-73d9410924f4\n" ,
                       "https://files.acrobat.com/a/preview/3983986c-58f7-48ea-9f0c-997cabadc71f\n" ,
                       "https://files.acrobat.com/a/preview/1107b1ca-d3a6-4f2f-a800-e02659770179\n" ,
                       "https://files.acrobat.com/a/preview/a2def044-c3db-4a41-8c0b-ebbfc2a53b17\n" ,
                       "https://files.acrobat.com/a/preview/5d5c7a21-f733-4d32-9322-9ba2c581859d\n" ,
                       "https://files.acrobat.com/a/preview/dea8a742-90c5-4f17-a463-41b6c8b0a57f\n" ,
                       "https://files.acrobat.com/a/preview/06afd1c1-0a3b-4477-a96b-cc098819058d\n" ,
                       "https://files.acrobat.com/a/preview/f3f73adc-141c-4335-bb55-8560488040fc\n" ,
                       "https://files.acrobat.com/a/preview/e283f783-1f8f-4d89-987c-68b2a405458e\n" ,
                       "https://files.acrobat.com/a/preview/f7a519ac-961f-4f36-b1a4-8196b280384e\n" ,
                       "https://files.acrobat.com/a/preview/4266fee5-9c30-466e-925e-7be1f53e0f38\n" ,
                       "https://files.acrobat.com/a/preview/881a4099-3899-4dbc-a701-f687e502a3a6\n" ,
                       "https://files.acrobat.com/a/preview/1dcfa29b-5597-499e-aed2-fc857bcc6b81\n" ,
                       "https://files.acrobat.com/a/preview/786e9017-7799-4464-83fa-1d87dda79394\n" ,
                       "https://files.acrobat.com/a/preview/fe6d99cc-868a-4b69-ace6-27e63969259b\n" ,
                       "https://files.acrobat.com/a/preview/0bc29e35-df97-4f7f-a396-00440c8625c4\n" ,
                       "https://files.acrobat.com/a/preview/aa03809a-10f9-4530-9cae-bd51f9634438\n" ,
                       "https://files.acrobat.com/a/preview/c66f32b3-68d0-4ee0-9537-34287ac6572c\n" ,
                       "https://files.acrobat.com/a/preview/d2d25c30-2d11-4589-87d7-6ed6401182ef\n" ,
                       "https://files.acrobat.com/a/preview/201f944c-5ec2-403f-af16-e927ace03e4a\n" ,
                       "https://files.acrobat.com/a/preview/ba005082-de54-4d4e-9a90-73ee3277ae0f\n" ,
                       "https://files.acrobat.com/a/preview/28e73d58-7f00-46bf-82d7-7dc74329744c\n" ,
                       "https://files.acrobat.com/a/preview/9b80dab5-66f2-4a1a-a44b-3a4f88cc3c6b\n" ,
                       "https://files.acrobat.com/a/preview/fb0ed034-7058-41e1-b8f4-f5243b5e8683\n" ,
                       "https://files.acrobat.com/a/preview/fb545aa3-6fd6-47b4-81dd-8cf35854f4fc\n" ,
                       "https://files.acrobat.com/a/preview/1353f62f-3e4d-427b-b016-faf148fbdcb2\n" ,
                       "https://files.acrobat.com/a/preview/4f023e6b-0193-4cfb-94e0-34c07afbdcf1\n" ,
                       "https://files.acrobat.com/a/preview/e5c9dcc5-e762-4055-991c-b6814622bb27\n" ,
                       "https://files.acrobat.com/a/preview/faf7ad64-5fe4-4b80-a67b-439e891a06a1\n" ,
                       "https://files.acrobat.com/a/preview/7f8d1b23-093f-4b49-96d3-37232158a119\n" ,
                       "https://files.acrobat.com/a/preview/3aed6475-caba-4198-80f0-5f754107dd14\n" ,
                       "https://files.acrobat.com/a/preview/9e7599fd-7183-416f-b3c5-b3f09007e900\n" ,
                       "https://files.acrobat.com/a/preview/215f42a7-0e31-4b99-a73b-75e539775f61\n" ,
                       "https://files.acrobat.com/a/preview/844dc561-2729-490e-99b9-b300c651b616\n" ,
                       "https://files.acrobat.com/a/preview/7248adb1-cc71-4e8e-8875-ed294d3b62e2\n" ,
                       "https://files.acrobat.com/a/preview/924d048b-2110-4602-aded-3847d0ddcb0b\n" ,
                       "https://files.acrobat.com/a/preview/ff4e3cad-bac6-4cf1-83ed-b44a9d968bf7\n" ,
                       "https://files.acrobat.com/a/preview/5e27b639-8063-4c80-a212-85793855f3e8\n" ,
                       "https://files.acrobat.com/a/preview/b39ac546-6c8e-43e5-88b0-2624340c6474\n" ,
                       "https://files.acrobat.com/a/preview/59185b98-8f66-4e4d-a0c3-255718c1fe41\n" ,
                       "https://files.acrobat.com/a/preview/c8d006ba-7144-4893-a3b2-c0a145c058de\n" ,
                       "https://files.acrobat.com/a/preview/4efe42a9-f8a2-471c-bf83-06ef59102177"},

                               {"https://files.acrobat.com/a/preview/ddce74b5-b690-425b-ad72-ddecd73c4fb0\n" ,
                                "\thttps://files.acrobat.com/a/preview/3b2a498f-a379-4d66-8f8c-3822e0fb3c99\n" ,
                                "\thttps://files.acrobat.com/a/preview/01e3b932-35c3-4ba3-adcb-8da96ad22562\n" ,
                                "\thttps://files.acrobat.com/a/preview/d7af7983-c5b2-4b3f-a52d-dda5ceb2c9a6\n" ,
                                "\thttps://files.acrobat.com/a/preview/9d76775d-7d6f-4cd1-985a-02b9a3837cd2\n" ,
                                "\thttps://files.acrobat.com/a/preview/00c97bf2-d94a-46eb-9a89-0e2a3d53db11"},

                      {"https://files.acrobat.com/a/preview/99355515-ed21-4eb9-a40f-6427361f06e9\n" ,
                       "\thttps://files.acrobat.com/a/preview/3a03991d-9f0c-4183-8f3c-92b41a1aee34\n" ,
                       "\thttps://files.acrobat.com/a/preview/f9dbfda6-928c-4376-bcd6-d827171132db\n" ,
                       "\thttps://files.acrobat.com/a/preview/b77d278e-5ec8-4d1c-9e73-24b1521c44fa\n" ,
                       "\thttps://files.acrobat.com/a/preview/6783d59b-a86d-4428-96f6-5d741d040e48\n" ,
                       "\thttps://files.acrobat.com/a/preview/c019c20b-f374-4685-a490-6c0057522386\n" ,
                       "\thttps://files.acrobat.com/a/preview/35bd853d-5d79-4837-a631-e438ecba2874\n" ,
                       "\thttps://files.acrobat.com/a/preview/f76d5f60-5cb5-4dd3-b566-28a333d18480\n" ,
                       "\thttps://files.acrobat.com/a/preview/86f9f749-9d21-40a4-b37b-c83ae1465260\n" ,
                       "\thttps://files.acrobat.com/a/preview/be9a1e3d-8033-47cb-a5ba-d261566ce211\n" ,
                       "\thttps://files.acrobat.com/a/preview/16dd4b2e-5133-45c7-bbdf-a635198c3b75\n" ,
                       "\thttps://files.acrobat.com/a/preview/d58ba6dd-0c1c-4486-9fec-248e87c1d166\n" ,
                       "\thttps://files.acrobat.com/a/preview/60f81c39-51ba-42bb-947b-6e8eea5251f0\n" ,
                       "\thttps://files.acrobat.com/a/preview/791a81a7-7f41-4d0b-b3b8-0d9004d2de70\n" ,
                       "\thttps://files.acrobat.com/a/preview/d56124aa-2c5d-46dc-9655-e2c2b26867b8\n" ,
                       "\thttps://files.acrobat.com/a/preview/9c45e56e-811e-461c-a71d-dc18a62216c9\n" ,
                       "\thttps://files.acrobat.com/a/preview/5f297719-8787-43df-9afe-2e0065f58e50\n" ,
                       "\thttps://files.acrobat.com/a/preview/02f087e2-473a-4066-b97d-7a75f3e3d2b7\n" ,
                       "\thttps://files.acrobat.com/a/preview/3568cdb2-3b71-442b-bc07-005680969940\n" ,
                       "\thttps://files.acrobat.com/a/preview/b6282955-d2cd-434d-8871-8d07573c37d1\n" ,
                       "\thttps://files.acrobat.com/a/preview/4934317a-f49b-4545-816f-dd8ead67d32a\n" ,
                       "\thttps://files.acrobat.com/a/preview/4167d936-7176-42c4-9ba8-f95447701935\n" ,
                       "\thttps://files.acrobat.com/a/preview/1cbf3ba1-9a32-497c-a996-5c832b6466b8\n" ,
                       "\thttps://files.acrobat.com/a/preview/011084f4-3ca5-4187-9abc-00ad4d8d8f04\n" ,
                       "\thttps://files.acrobat.com/a/preview/7ee008d3-5c5d-48a3-a555-26326b87b0f5\n" ,
                       "\thttps://files.acrobat.com/a/preview/ddbf94f7-f7df-4731-90c1-528c6d9fe680\n" ,
                       "\thttps://files.acrobat.com/a/preview/e6db3760-ae23-4275-82b9-1e59ad5d3e4c\n" ,
                       "\thttps://files.acrobat.com/a/preview/0d4d6297-defa-4423-9c58-925c736611a3\n" ,
                       "\thttps://files.acrobat.com/a/preview/179a6b20-8d3e-4c85-b007-0902b6929762"},


                       {"https://files.acrobat.com/a/preview/727de3a7-3b21-4384-9938-6dac8e67d461\n" ,
                       "https://files.acrobat.com/a/preview/f9cd780d-5723-45af-9795-2757ef2ffea7\n" ,
                       "https://files.acrobat.com/a/preview/3c818202-5431-4c44-9150-2f9055c004b6\n" ,
                       "https://files.acrobat.com/a/preview/7e4f095e-7fd7-4f59-a4b4-7bfcd28624a0\n" ,
                       "https://files.acrobat.com/a/preview/f781894f-2901-4d87-9301-d936dac987a3\n" ,
                       "https://files.acrobat.com/a/preview/ebf949c7-e2ee-41c9-a72e-3546ea7a6cc9\n" ,
                       "https://files.acrobat.com/a/preview/09465505-4e91-41cf-b322-5dc7755efdff\n" ,
                       "https://files.acrobat.com/a/preview/74ab9d4c-0077-45d5-8eec-74365befb358\n" ,
                       "https://files.acrobat.com/a/preview/7b86567b-06f9-43b6-aab8-dbf451cb238c\n" ,
                       "https://files.acrobat.com/a/preview/7bdc39b6-2a1b-4c85-b414-04f137673eb2\n" ,
                       "https://files.acrobat.com/a/preview/5cbf793e-c3f4-4731-80d2-7156efe853d1\n" ,
                       "https://files.acrobat.com/a/preview/55e6b34d-8b5f-434c-be72-9abbf7a81bba\n" ,
                       "https://files.acrobat.com/a/preview/c0f7a1eb-2c20-4589-a7bb-a51c0a2a7bb2\n" ,
                       "https://files.acrobat.com/a/preview/cbe6e00d-b20d-414f-9235-a49d23d837c7\n" ,
                       "https://files.acrobat.com/a/preview/53feb999-677c-4b81-9096-81f3ce0c2e6e\n" ,
                       "https://files.acrobat.com/a/preview/e142a5b3-7715-4619-bdef-8e92d1b98f8a\n" ,
                       "https://files.acrobat.com/a/preview/603b284c-a584-4b94-9dfb-09bba786bc34\n" ,
                       "https://files.acrobat.com/a/preview/1db8e0e3-988f-4d2a-9876-9cd8cba149e6\n" ,
                       "https://files.acrobat.com/a/preview/ce981391-0c53-42c0-b29c-ace18c28a405\n" ,
                       "https://files.acrobat.com/a/preview/637a4655-9386-4023-b661-86a20d83db84\n" ,
                       "https://files.acrobat.com/a/preview/4403271c-3ec4-42fe-9aef-7cfa79b8aa26\n" ,
                       "https://files.acrobat.com/a/preview/893c2125-96cb-440b-b4d5-cfe6475bfd2a\n" ,
                       "https://files.acrobat.com/a/preview/02512402-8229-4c6c-9ca5-1c8d43a5b8b4\n" ,
                       "https://files.acrobat.com/a/preview/a7da5093-1a81-4e8a-ac03-09cdbe78fa4e\n" ,
                       "https://files.acrobat.com/a/preview/237b32c1-8e61-42b5-9552-c9c7ed249a96"}};

        final String video[][]={{"Chemistry Lectures\n" ,
                "Civil Engineering\n" ,
                "Electrical Engineering\n" ,
                "Mathematics Tutorials\n" ,
                "Mechanical Engineering\n" ,
                "Physics\n" ,
                "Biotechnology Engineering\n" ,
                "Computer Science/IT Engineering\n" ,
                "Business & Management\n" ,
                "Humanities and Social Science"},
                {"C Programming Tutorial\n" ,
                        "C++ Programming Tutorial\n" ,
                        "Java Programming Tutorials\n" ,
                        "Mysql& Database Tutorial\n" ,
                        "Data Structures and Algorithms Lectures\n" ,
                        "Design and Analysis of Algorithms Lecture\n" ,
                        "Photoshop Tutorial\n" ,
                        "Git&github Tutorial\n" ,
                        "XHTML & CSS\n" ,
                        "Ruby Tutorials\n" ,
                        "HTML5 Tutorials\n" ,
                        "Javascript Tutorials\n" ,
                        "visual Basics"}};

        final String video1[][]={{"http://www.tawkaw.com/index.php/courses/chemistry-and-chemical-engineering\n" ,
                "http://www.tawkaw.com/index.php/courses/civil-engineering\n" ,
                "http://www.tawkaw.com/index.php/courses/electrical-engineering\n" ,
                "http://www.tawkaw.com/index.php/courses/mathematics\n" ,
                "http://www.tawkaw.com/index.php/courses/mechanical-engineering\n" ,
                "http://www.tawkaw.com/index.php/courses/physics\n" ,
                "http://www.tawkaw.com/index.php/courses/biology-and-biotechnology\n" ,
                "http://www.tawkaw.com/index.php/courses/computer-science-and-engineering\n" ,
                "http://www.tawkaw.com/index.php/courses/management-and-business\n" ,
                "http://www.tawkaw.com/index.php/courses/humanities-and-social-sciences"},
                {"https://www.youtube.com/watch?v=2NWeucMKrLI&list=PL6gx4Cwl9DGAKIXv8Yr6nhGJ9Vlcjyymq\n" ,
                        "https://www.youtube.com/watch?v=tvC1WCdV1XU&list=PLAE85DE8440AA6B83\n" ,
                        "https://www.youtube.com/watch?v=Hl-zzrqQoSE&list=PLFE2CE09D83EE3E28\n" ,
                        "https://www.youtube.com/watch?v=zWg7U0OEAoE&list=PLBF3763AF2E1C572F\n" ,
                        "https://www.youtube.com/watch?v=5Y8Lfsreeck&list=PL7DC83C6B3312DF1E\n" ,
                        "https://www.youtube.com/watch?v=givuYd_cKm0&list=PL6gx4Cwl9DGD25IGk9Xf7oC3wiT9gC75x\n" ,
                        "https://www.youtube.com/watch?v=cEGIFZDyszA&list=PL6gx4Cwl9DGAKWClAD_iKpNC0bGHxGhcx\n" ,
                        "https://www.youtube.com/watch?v=cqszz_OfAFQ&list=PLC1322B5A0180C946\n" ,
                        "https://www.youtube.com/watch?v=WJlfVjGt6Hg&list=PL1512BD72E7C9FFCA\n" ,
                        "https://www.youtube.com/watch?v=Mp0f0zTPLec&list=PL081AC329706B2953\n" ,
                        "https://www.youtube.com/watch?v=yQaAGmHNn9s&list=PL46F0A159EC02DF82\n" ,
                        "https://www.youtube.com/watch?v=mM3zB3QWuv8&list=PLC601DEA22187BBF1"}};


         tabs = (TabHost) findViewById(R.id.tabHost5);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab2);
        spec.setIndicator("EBOOK");
        tabs.addTab(spec);

        TabHost.TabSpec speca = tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab1);
        speca.setIndicator("VIDEO");
        tabs.addTab(speca);
      //  ArrayAdapter<String> ad2=new ArrayAdapter<String>(Ebook.this,android.R.layout.simple_list_item_1,video);
     //   l2.setAdapter(ad2);

        ArrayAdapter<String> ad=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(ad);

        ArrayAdapter<String> ad2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,col2);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(ad2);



      sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              if (position == 0) {
                  l1.setVisibility(View.GONE);
                  tv.setVisibility(View.VISIBLE);
                  tv.setText(p);

              } else {
                  k = position - 1;
                  l1.setVisibility(View.VISIBLE);
                  tv.setVisibility(View.GONE);
                  ArrayAdapter<String> ad1 = new ArrayAdapter<String>(Ebook.this, android.R.layout.simple_list_item_1, ebook[position - 1]);
                  l1.setAdapter(ad1);
              }
          }

          @Override
          public void onNothingSelected(AdapterView<?> parent) {

          }
      });


        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                z = position;
                final ArrayAdapter<String> ad2 = new ArrayAdapter<String>(Ebook.this, android.R.layout.simple_list_item_1, video[position]);
                l2.setAdapter(ad2);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ebook.this, Brower.class);
                i.putExtra("key", "http://goo.gl/forms/3C49mkVbXv");
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Ebook.this, Brower.class);
                i.putExtra("key", "http://goo.gl/forms/3lRWq3qStM");
                startActivity(i);
            }
        });
        l1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Ebook.this, Brower.class);
                i.putExtra("key", ebookloc[k][position]);
                startActivity(i);

            }
        });
        l2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(Ebook.this, Brower.class);
                i.putExtra("key", (video1[z][position]));
                startActivity(i);

            }
        });


    }




}