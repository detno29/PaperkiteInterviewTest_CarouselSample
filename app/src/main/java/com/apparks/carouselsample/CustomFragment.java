package com.apparks.carouselsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by longdao on 12/03/16.
 */
public class CustomFragment extends Fragment {
    public static Fragment newInstance(MainActivity context, int pos, float scale, float opacity) {
        Bundle b = new Bundle();
        b.putInt("pos", pos);
        b.putFloat("scale", scale);
        b.putFloat("opacity", opacity);

        return Fragment.instantiate(context, CustomFragment.class.getName(), b);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (container == null) {
            return null;
        }

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(300, 300);
        LinearLayout fragmentLL  = (LinearLayout) inflater.inflate(R.layout.mf, container, false);
        int pos   = this.getArguments().getInt("pos");

        TextView tv  = (TextView) fragmentLL.findViewById(R.id.text);
        tv.setText("Image " +  pos );

        ImageView iv = (ImageView) fragmentLL.findViewById(R.id.pagerImg);
        //iv.setAlpha(_opacity);
        iv.setLayoutParams(layoutParams);
        iv.setImageResource(MainActivity.mainActivityCtx.coverUrl[pos] );
        iv.setPadding(10, 10, 10, 10);

        CustomLinearLayout root = (CustomLinearLayout) fragmentLL.findViewById(R.id.root);
        float _opacity = this.getArguments().getFloat("opacity");
        float scale   = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);
        root.setAlpha(_opacity);

        CustomLinearLayout root2 = (CustomLinearLayout) fragmentLL.findViewById(R.id.root);
        //float _opacity = this.getArguments().getFloat("opacity");
        //float scale   = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);
        root.setAlpha(_opacity);

        CustomLinearLayout root3 = (CustomLinearLayout) fragmentLL.findViewById(R.id.root);
        //float _opacity = this.getArguments().getFloat("opacity");
        //float scale   = this.getArguments().getFloat("scale");
        root.setScaleBoth(scale);
        root.setAlpha(_opacity);

        return fragmentLL;
    }
}
