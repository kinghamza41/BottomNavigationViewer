package com.hamza.bottomnavigationviewer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
//Other Activity Data
public class CustomSwipeAdapter extends PagerAdapter {
    private int[] image_resource = {R.drawable.sample_1,
            R.drawable.sample_2, R.drawable.sample_3, R.drawable.sample_4};
    private Context ctx;
    private LayoutInflater inflater;

    public CustomSwipeAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return image_resource.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == (LinearLayout) o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = inflater.inflate(R.layout.swipe_layout, container,
                false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_view);
/*
        TextView textView = (TextView) item_view.findViewById(R.id.image_counter);
*/
        imageView.setImageResource(image_resource[position]);
/*
        textView.setText("GOOD BYE FAMILY");
*/
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout) object);
    }
}

