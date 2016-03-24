package cet.bbsr.app.CETBBSR;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by SM ROCKS on 2/6/2016.
 */
public class CustomAdapter extends ArrayAdapter<String>{
   int k;
    int g;
    int z;
    DepartmentView x;
    int logo[][]={  {R.drawable.zaa,R.drawable.zbb,R.drawable.zc,R.drawable.zd,R.drawable.ze,R.drawable.zf,R.drawable.zgg,R.drawable.zh,R.drawable.zii,R.drawable.zj,R.drawable.hab,R.drawable.haa,R.drawable.mad,R.drawable.hac,R.drawable.had},
            {R.drawable.aaa,R.drawable.abb,R.drawable.acc,R.drawable.x,R.drawable.add,R.drawable.aee,R.drawable.aff,R.drawable.agg,R.drawable.ahh,R.drawable.aii,R.drawable.ajj,R.drawable.akk,R.drawable.all,R.drawable.amm},
            {R.drawable.fab,R.drawable.fac,R.drawable.faa,R.drawable.fad,R.drawable.fae,R.drawable.faf,R.drawable.fas}};

    public CustomAdapter(Context context, String[] data) {
        super(context,R.layout.customview, data);

        if(data[0].equals("Zairza")){
            k=0;

        }

        else if(data[0].equals("\t\t Architecture Engineering\t \n"))
            k=1;
        else if(data[0].equals("   Mr.   Sangram Mohanty \n" + "\t Head of the Department\n")||data[0].equals("\tMr.   Madhabananda Pattanaik\n" + "\t  Head of the Department\n")||data[0].equals("Dr.   Falguni Baliarsingh \n" + "Head of the Department\n")||data[0].equals("Dr.   Jibitesh Mishra \n" + " Head of the Department\n")||data[0].equals("Mrs.   Swarna Lata Pati\n" + "  Head of the Department\n")||data[0].equals("Dr.   Ranjan Kumar Dash  \n" + "Head of the Department\n")||data[0].equals("\n" + "\t Mr.   Sangram Mohanty \n" + "\t Head of the Department\n")||data[0].equals("Dr.   Ranjan Kumar Jena    \n" + "Head of the Department\n")||data[0].equals("Dr.   Asimananda Khandual\n" + "Head of the Department\n")||data[0].equals("Dr.   Sribatsa Behera \n" + "Head of the Department\n")||data[0].equals("Dr.   Rati Ranjan Dash \n" + " Head of the Department\n")||data[0].equals("Dr.   Bibhu Prasad Dash\n" + "Head of the Department\n")||data[0].equals("Dr.   Minakshi Prasad Mishra  \n" + "  Head of the Department\n")||data[0].equals("Dr.   Babita Ojha  \n" + "  Head of the Department\n")||data[0].equals("Dr.   Bigyan Ranjan Das  \n" + "   Head of the Department\n"))
        {
           k=11;
            g=R.drawable.iaxx;

            /* z=x.kk[x.p][x.q];
             if(z==0){
                 g=R.drawable.iah;
             }else {
                 g=R.drawable.iadd;
            } */

        }
        else if(data[0].equals("BIBHUPADA MEHER\n"+"Android App Admin"))
        {
            k=2;

        }

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater bm= LayoutInflater.from(getContext());
        View customview= bm.inflate(R.layout.customview, parent, false);

        String pi= getItem(position);
        TextView  tv=(TextView)customview.findViewById(R.id.textView2);
        ImageView im=(ImageView)customview.findViewById(R.id.imageView7);
         tv.setText(pi);
        if(k<10)
          im.setImageResource(logo[k][position]);
         else
          im.setImageResource(g);
        return customview;
    }
}
