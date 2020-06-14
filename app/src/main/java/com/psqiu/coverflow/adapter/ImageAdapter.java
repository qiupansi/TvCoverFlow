package com.psqiu.coverflow.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.psqiu.coverflow.HomeInfo;
import com.psqiu.coverflow.utils.BitmapUtil;
import com.psqiu.coverflow.utils.ImageCacheUtil;

import java.io.InputStream;
import java.util.List;

public class ImageAdapter extends FancyCoverFlowAdapter {
	private Context context;
	private List<HomeInfo> filmList;
	 ImageCacheUtil cacheUtil;

	public ImageAdapter(Context context, List<HomeInfo> filmList) {
		this.context = context;
		this.filmList = filmList;
		cacheUtil = new ImageCacheUtil(context);
//		this.options = options;
//		this.imageLoader = imageLoader;
	}

	@Override
	public int getCount() {
		return Integer.MAX_VALUE;
	}

	@Override
	public Object getItem(int position) {
		return filmList.get(position % filmList.size());
//		return position;
	}

	@Override
	public long getItemId(int position) {
		return position % filmList.size();
//		return position;
	}

	@Override
	public View getCoverFlowItem(int position, View convertView,
                                 ViewGroup parent) {
		ImageView imageView = (ImageView) convertView;
		if (imageView == null) {
			imageView = new ImageView(context);
		}
		Resources re = context.getResources();
		int resId = filmList.get(position % filmList.size()).getRs();
		InputStream is = re.openRawResource(resId);
//		InputStream is = re.openRawResource(mImagesId[position%mImagesId.length]);
		BitmapDrawable mapdraw = new BitmapDrawable(is);
		Bitmap bitmap = mapdraw.getBitmap();
		if (cacheUtil.getBitmap(resId + "") == null) {
			cacheUtil.putBitmap(resId + "", bitmap);
		}
		Bitmap bmap = cacheUtil.getBitmap(resId + "");

		imageView.setImageBitmap(BitmapUtil.createReflectedBitmap(bmap));
//		imageView.setImageBitmap(bitmap);

//		imageView.setLayoutParams(new Gallery.LayoutParams(350, 590));
		imageView.setLayoutParams(new Gallery.LayoutParams(350, 590));

		imageView.setScaleType(ScaleType.FIT_XY);
		imageView.setAdjustViewBounds(true);
		return imageView;
	}



}