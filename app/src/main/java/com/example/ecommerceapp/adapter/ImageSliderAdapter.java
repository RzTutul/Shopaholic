package com.example.ecommerceapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerceapp.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<ImageSliderAdapter.SliderAdapterVH> {

    Context context;


    int images[];
    String title[];

    public ImageSliderAdapter(Context context, int[] images, String[] title) {
        this.context = context;
        this.images = images;
        this.title = title;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_image_row, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, final int position) {
      viewHolder.imageViewBackground.setBackgroundResource(images[position]);

       viewHolder.textViewDescription.setText(title[position]);

       viewHolder.imageViewBackground.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();
           }
       });
    }

    @Override
    public int getCount() {
        return images.length;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;
        TextView textViewDescription;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.image);
            textViewDescription = itemView.findViewById(R.id.titile);
            this.itemView = itemView;
        }
    }
}
