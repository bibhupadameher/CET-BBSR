package cet.bbsr.app.CETBBSR;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.webkit.ConsoleMessage;
import android.webkit.DownloadListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.Toast;

import java.io.File;

public class Notice extends AppCompatActivity {
  ImageButton ib[];
    ImageView im;
    final Activity activity = this;
    public Uri imageUri;
    private static final int FILECHOOSER_RESULTCODE   = 2888;
    private ValueCallback<Uri> mUploadMessage;
    private Uri mCapturedImageURI = null;
    private WebView wv;
    ProgressBar Pbar;
    Animation vanish;


    TabHost tabs;
   /* public float   lastX;
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
    }*/



  /*  @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (wv.canGoBack()) {
                          if(wv.getUrl().equals("http://www.vernetpirates.com/test2.php")){
                              new AlertDialog.Builder(this)
                                      .setIcon(R.drawable.loggg)
                                      .setTitle("Closing Session")
                                      .setMessage("DO YOU REALLY WANT TO LEAVE !!!!?")
                                      .setPositiveButton("YES", new DialogInterface.OnClickListener()
                                      {
                                          @Override
                                          public void onClick(DialogInterface dialog, int which) {
                                              finish();
                                          }

                                      })
                                      .setNegativeButton("NO", null)
                                      .show();
                          } else {
                       wv.loadUrl("http://www.vernetpirates.com/test2.php");  }
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }


   */


    @Override
    public void onBackPressed() {
        if (wv.getUrl().equals("http://notices.cetb.in/") || wv.getUrl().equals("file:///android_asset/pop.html") || wv.getUrl().equals("http://172.16.0.1:8090/httpclient.html")) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.loggg)
                    .setTitle("Exit !")
                    .setMessage("Are you sure You want to quit ?")
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }

                    })
                    .setNegativeButton("NO", null)

                    .show();
        }else {
            tabs.setCurrentTab(0);
            wv.loadUrl("http://notices.cetb.in/");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.noti);
        wv = (WebView) findViewById(R.id.webView2);
        im=(ImageView)findViewById(R.id.imageView);
        im.setImageResource(R.drawable.webb);
       Pbar = (ProgressBar) findViewById(R.id.progressBar3);

        ImageButton b1=(ImageButton)findViewById(R.id.imageButton88);
        ImageButton b3=(ImageButton)findViewById(R.id.imageButton87);


        ib=new ImageButton[13];
        ib[0]=(ImageButton)findViewById(R.id.imageButton);
        ib[1]=(ImageButton)findViewById(R.id.imageButton2);
        ib[2]=(ImageButton)findViewById(R.id.imageButton3);
        ib[3]=(ImageButton)findViewById(R.id.imageButton6);
        ib[4]=(ImageButton)findViewById(R.id.imageButton9);
        ib[5]=(ImageButton)findViewById(R.id.imageButton10);
        ib[6]=(ImageButton)findViewById(R.id.imageButton11);
        ib[7]=(ImageButton)findViewById(R.id.imageButton12);
       /* ib[8]=(ImageButton)findViewById(R.id.imageButton7);
        ib[10]=(ImageButton)findViewById(R.id.imageButton13);
        ib[12]=(ImageButton)findViewById(R.id.imageButton15);  */


        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setSupportZoom(true);
        wv.getSettings().setLoadWithOverviewMode(true);
        wv.getSettings().setUseWideViewPort(true);

        wv.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);


                findViewById(R.id.imageView).setVisibility(View.GONE);


                findViewById(R.id.webView2).setVisibility(View.VISIBLE);
            }



            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                wv.loadUrl("file:///android_asset/pop.html");
            }


        });
        wv.loadUrl("http://notices.cetb.in/");


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Notice.this,Upload.class);

                startActivity(i);
               ;

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this,Brower.class);
                i.putExtra("key", "http://cetevents.esy.es/");
                startActivity(i);

            }
        });



        wv.setDownloadListener(new DownloadListener() {

            public void onDownloadStart(String url, String userAgent,
                                        String contentDisposition, String mimetype,
                                        long contentLength) {
                DownloadManager.Request request = new DownloadManager.Request(
                        Uri.parse(url));

                String fileName = URLUtil.guessFileName(url, contentDisposition, mimetype);

                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED); //Notify client once download is completed!
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);
                DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
                dm.enqueue(request);
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");
                Toast.makeText(getApplicationContext(), "Downloading File",
                        Toast.LENGTH_LONG).show();

            }
        });


        wv.setWebChromeClient(new WebChromeClient() {


            public void openFileChooser(ValueCallback<Uri> uploadMsg, String acceptType) {


                mUploadMessage = uploadMsg;

                try {



                    File imageStorageDir = new File(
                            Environment.getExternalStoragePublicDirectory(
                                    Environment.DIRECTORY_PICTURES)
                            , "AndroidExampleFolder");

                    if (!imageStorageDir.exists()) {

                        imageStorageDir.mkdirs();
                    }


                    File file = new File(
                            imageStorageDir + File.separator + "IMG_"
                                    + String.valueOf(System.currentTimeMillis())
                                    + ".jpg");

                    mCapturedImageURI = Uri.fromFile(file);


                    final Intent captureIntent = new Intent(
                            MediaStore.ACTION_IMAGE_CAPTURE);

                    captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, mCapturedImageURI);

                    Intent i = new Intent(Intent.ACTION_GET_CONTENT);
                    i.addCategory(Intent.CATEGORY_OPENABLE);
                    i.setType("*/*");


                    Intent chooserIntent = Intent.createChooser(i, "file choser");


                    chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS
                            , new Parcelable[]{captureIntent});


                    startActivityForResult(chooserIntent, FILECHOOSER_RESULTCODE);

                } catch (Exception e) {
                    Toast.makeText(getBaseContext(), "Exception:" + e,
                            Toast.LENGTH_LONG).show();
                }

            }


            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                openFileChooser(uploadMsg, "");
            }


            public void openFileChooser(ValueCallback<Uri> uploadMsg,
                                        String acceptType,
                                        String capture) {

                openFileChooser(uploadMsg, acceptType);
            }



            public boolean onConsoleMessage(ConsoleMessage cm) {

                onConsoleMessage(cm.message(), cm.lineNumber(), cm.sourceId());
                return true;
            }

            public void onConsoleMessage(String message, int lineNumber, String sourceID) {

            }

            public void onProgressChanged(WebView view, int progress) {
                if (progress < 100 && Pbar.getVisibility() == ProgressBar.GONE) {
                    Pbar.setVisibility(ProgressBar.VISIBLE);

                }
                Pbar.setProgress(progress);
                if (progress == 100) {
                    Pbar.setVisibility(ProgressBar.GONE);

                }

            }




        });






         tabs=(TabHost) findViewById(R.id.tabHost);
        tabs.setup();
        final TabHost.TabSpec spec=tabs.newTabSpec("tag1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("NOTICE");
        tabs.addTab(spec);

        TabHost.TabSpec  speca=tabs.newTabSpec("tag2");
        speca.setContent(R.id.tab2);
        speca.setIndicator("HOME");
        tabs.addTab(speca);


        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if(tabId.equals("tag1")) {

                    wv.loadUrl("http://notices.cetb.in/");

                }

            }
        });






               ib[0].setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent i = new Intent(Notice.this, Department.class);
                         startActivity(i);
                     }
                 });

        ib[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this, Ebook.class);
                startActivity(i);
            }
        });

        ib[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this,Brower.class);
                i.putExtra("key", "http://results.bput.ac.in/");
                startActivity(i);
            }
        });

        ib[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this, Club.class);
                startActivity(i);
            }
        });

        ib[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Notice.this,Brower.class);
                i.putExtra("key","http://cet.hol.es/");

                startActivity(i);
            }
        });

        ib[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this,Brower.class);
                i.putExtra("key","http://xtasy.cetb.in/");

                startActivity(i);
            }
        });

        ib[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // Intent i = new Intent(Notice.this,Brower.class);
             //  i.putExtra("key", "file:///android_asset/holiday.html");

              //  startActivity(i);

                Intent i = new Intent(Notice.this, Notices.class);
                startActivity(i);
            }
        });

        ib[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notice.this, About.class);
                startActivity(i);
            }
        });



    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {

        if(requestCode==FILECHOOSER_RESULTCODE)
        {

            if (null == this.mUploadMessage) {
                return;

            }

            Uri result=null;

            try{
                if (resultCode != RESULT_OK) {

                    result = null;

                } else {


                    result = intent == null ? mCapturedImageURI : intent.getData();
                }
            }
            catch(Exception e)
            {
                Toast.makeText(getApplicationContext(), "activity :"+e,
                        Toast.LENGTH_LONG).show();
            }

            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;

        }

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
