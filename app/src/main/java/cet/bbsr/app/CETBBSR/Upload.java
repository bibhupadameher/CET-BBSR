package cet.bbsr.app.CETBBSR;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by SM ROCKS on 2/10/2016.
 */

public class   Upload extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);
        Button b=(Button)findViewById(R.id.button18);
        Button b1=(Button)findViewById(R.id.button14);
        Button b2=(Button)findViewById(R.id.button4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Upload.this,Main.class);
                i.putExtra("key", "http://notices.cetb.in/admin.php");
                startActivity(i);
            }

        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Upload.this, Main.class);
                i.putExtra("key", "http://notices.cetb.in/n_user.php");
                startActivity(i);
              /*  PopupMenu popup = new PopupMenu(Upload.this,v);
                popup.getMenuInflater().inflate(R.menu.popupmenu3, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                                     public boolean onMenuItemClick(MenuItem item) {
                                                         String k = (String) item.getTitle();
                                                         if (k.equals("No Attachment file")) {
                                                             Intent i = new Intent(Upload.this, Brower.class);
                                                             i.putExtra("key", "http://notices.cetb.in/n_user.php");
                                                             startActivity(i);
                                                         } else if (k.equals("with Attachment file")) {
                                                             Intent email = new Intent(Intent.ACTION_SEND);
                                                             email.putExtra(Intent.EXTRA_EMAIL, new String[]{"cetbbsrapp@gmail.com"});
                                                             email.setType("message/rfc822");
                                                             startActivity(Intent.createChooser(email, "choose an email client"));

                                                         }
                                                         return true;
                                                     }
                                                 }


                );

                popup.show();

            } */
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://notices.cetb.in/n_user.php"));
                startActivity(intent);

            }

        });



    }
}
