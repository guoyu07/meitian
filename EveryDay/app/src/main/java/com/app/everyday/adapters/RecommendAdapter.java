package com.app.everyday.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.models.RecommendModel;
import com.app.everyday.utils.ImageUtils;

import java.util.ArrayList;

/**
 * Author：YJQ on 2016/1/14 15:00
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class RecommendAdapter extends BaseAdapter {

    private final int TYPE1 = 0;//小图
    private final int TYPE2 = 1;//大图
    private final int TYPE1_COUNT = 2;
    ArrayList<RecommendModel.ResultEntity> resultEntities;
    private Context mContext;
    private LayoutInflater inflater;

    public RecommendAdapter(Context mContext, ArrayList<RecommendModel.ResultEntity> resultEntities) {
        this.mContext = mContext;
        this.resultEntities = resultEntities;
        inflater = LayoutInflater.from(mContext);
        this.resultEntities = resultEntities;
    }

    @Override
    public int getViewTypeCount() {
        return TYPE1_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        //判断item的类型
      /* for(RecommendModel.ResultEntity.ImageEntity imageEntity: resultEntities.get(position).getImage()){
           if(imageEntity.getType()==4){
               return TYPE2;
           }else{
               return TYPE1;
           }
       }*/
        if (resultEntities.get(position).getImage().size() > 0 && resultEntities.get(position).getImage().get(0).getType() == 4) {
            return TYPE2;

        } else {
            return TYPE1;
        }
    }

    @Override
    public int getCount() {
        return resultEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return resultEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1 = null;
        ViewHolder2 viewHolder2 = null;
        int type = getItemViewType(position);
        if (convertView == null) {
            switch (type) {
                case TYPE1:
                    viewHolder1 = new ViewHolder1();
                    convertView = inflater.inflate(R.layout.item_recommend1, null);
                    viewHolder1.mIv1 = (ImageView) convertView.findViewById(R.id.iv1);
                    viewHolder1.mIv_title = (TextView) convertView.findViewById(R.id.iv_title);
                    viewHolder1.mIv_catagory_name = (TextView) convertView.findViewById(R.id.iv_catagory_name);
                    viewHolder1.mTv_author_name = (TextView) convertView.findViewById(R.id.tv_author_name);
                    viewHolder1.mTv_number = (TextView) convertView.findViewById(R.id.tv_number);
                    convertView.setTag(viewHolder1);
                    break;
                case TYPE2:
                    viewHolder2 = new ViewHolder2();
                    convertView = inflater.inflate(R.layout.item_recommend2, null);
                    viewHolder2.mIv1 = (ImageView) convertView.findViewById(R.id.iv1);
                    viewHolder2.mIv_title = (TextView) convertView.findViewById(R.id.iv_title);
                    viewHolder2.mIv_catagory_name = (TextView) convertView.findViewById(R.id.iv_catagory_name);
                    viewHolder2.mTv_author_name = (TextView) convertView.findViewById(R.id.tv_author_name);
                    viewHolder2.mTv_number = (TextView) convertView.findViewById(R.id.tv_number);
                    convertView.setTag(viewHolder2);
                    break;
            }
        } else {
            switch (type) {
                case TYPE1:
                    viewHolder1 = (ViewHolder1) convertView.getTag();
                    break;
                case TYPE2:
                    viewHolder2 = (ViewHolder2) convertView.getTag();
                    break;

            }
        }
        //data
        switch (type) {
            case TYPE1:
                ImageUtils.getInstance().loadWebImage(mContext, viewHolder1.mIv1, resultEntities.get(position).getImage().get(0).getUrl());
                viewHolder1.mIv_title.setText(resultEntities.get(position).getArticle().getTitle());
                viewHolder1.mIv_catagory_name.setText(resultEntities.get(position).getCategory().getName());
                viewHolder1.mTv_author_name.setText(resultEntities.get(position).getAuthor().getName());
                viewHolder1.mTv_number.setText(String.valueOf(resultEntities.get(position).getArticle().getArticleStats().getRead()));
                break;
            case TYPE2:
                ImageUtils.getInstance().loadWebImage(mContext, viewHolder2.mIv1, resultEntities.get(position).getImage().get(0).getUrl());
                viewHolder2.mIv_title.setText(resultEntities.get(position).getArticle().getTitle());
                viewHolder2.mIv_catagory_name.setText(resultEntities.get(position).getCategory().getName());
                viewHolder2.mTv_author_name.setText(resultEntities.get(position).getAuthor().getName());
                viewHolder2.mTv_number.setText(String.valueOf(resultEntities.get(position).getArticle().getArticleStats().getRead()));
                break;

        }

        return convertView;
    }

    class ViewHolder1 {
        private ImageView mIv1;
        private TextView mIv_title;
        private TextView mIv_catagory_name;
        private TextView mLine;
        private TextView mTv_author_name;
        private TextView mTv_number;
    }

    class ViewHolder2 {
        private ImageView mIv1;
        private TextView mIv_title;
        private TextView mIv_catagory_name;
        private TextView mLine;
        private TextView mTv_author_name;
        private TextView mTv_number;
    }
}
