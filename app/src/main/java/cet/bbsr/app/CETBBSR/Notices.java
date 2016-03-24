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
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.File;

public class Notices extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView im;
    final Activity activity = this;
    public Uri imageUri;
    private static final int FILECHOOSER_RESULTCODE   = 2888;
    private ValueCallback<Uri> mUploadMessage;
    private Uri mCapturedImageURI = null;
    private WebView wv;
    ProgressBar Pbar;
    Animation vanish;

  /*  @Override
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
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notices);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        wv = (WebView) findViewById(R.id.webView3);
        im=(ImageView)findViewById(R.id.imageView9);
        im.setImageResource(R.drawable.webb);
        Pbar = (ProgressBar) findViewById(R.id.progressBar4);

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


                findViewById(R.id.imageView9).setVisibility(View.GONE);


                findViewById(R.id.webView3).setVisibility(View.VISIBLE);
            }


            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                wv.loadUrl("file:///android_asset/pop.html");
            }


        });
        wv.loadUrl("http://notices.cetb.in/");
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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Notices.this, Home2.class);

                startActivity(i);
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Notices.this,Upload.class);

                startActivity(i);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
         //   super.onBackPressed();
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

                wv.loadUrl("http://notices.cetb.in/");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notices, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Academics) {
            // Handle the camera action
            Intent i = new Intent(Notices.this, Department.class);
            startActivity(i);
        } else if (id == R.id.Study_material) {
            Intent i = new Intent(Notices.this, Ebook.class);
            startActivity(i);
        } else if (id == R.id.Events) {
            Intent i = new Intent(Notices.this,Brower.class);
            i.putExtra("key", "http://cetevents.esy.es/");
            startActivity(i);
        } else if (id == R.id.Portal) {
            Intent i = new Intent(Notices.this,Upload.class);

            startActivity(i);
        }else if (id == R.id.Results) {
            Intent i = new Intent(Notices.this,Brower.class);
            i.putExtra("key", "http://results.bput.ac.in/");
            startActivity(i);
        } else if (id == R.id.Clubs) {
            Intent i = new Intent(Notices.this, Club.class);
            startActivity(i);
        } else if (id == R.id.Gallery) {
            Intent i = new Intent(Notices.this,Brower.class);
            i.putExtra("key","http://cet.hol.es/");

            startActivity(i);
        }else if (id == R.id.Fest) {
            Intent i = new Intent(Notices.this,Brower.class);
            i.putExtra("key","http://xtasy.cetb.in/");

            startActivity(i);
        } else if (id == R.id.Holiday) {
            Intent i = new Intent(Notices.this,Brower.class);
            i.putExtra("key", "file:///android_asset/holiday.html");

             startActivity(i);
        } else if (id == R.id.About) {
            Intent i = new Intent(Notices.this, About.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
