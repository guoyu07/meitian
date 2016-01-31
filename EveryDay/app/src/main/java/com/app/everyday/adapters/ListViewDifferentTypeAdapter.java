package com.app.everyday.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.everyday.R;
import com.app.everyday.models.TopicModel;
import com.app.everyday.utils.ImageUtils;
import com.app.everyday.views.CircleImageView;

import java.util.ArrayList;

/**
 * Author：YJQ on 2016/1/13 11:43
 * Eamil：yujiaqi@fenzotech.com
 * Description:
 */
public class ListViewDifferentTypeAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<TopicModel.ResultEntity.ActivityEntity> activityEntities;
    ArrayList<TopicModel.ResultEntity.PostEntity> postEntities;
    ArrayList<TopicModel.ResultEntity.UserEntity> userEntities;
    private LayoutInflater inflater;
    private Bundle bundle;//不同item 分别显示的数据条数
    private final int TYPE_ONE=0;
    private final int TYPE_TWO=1;
    private final int TYPE_THREE=2;
    private final int TYPE_COUNT=3;


    public ListViewDifferentTypeAdapter(Context context,ArrayList<TopicModel.ResultEntity.ActivityEntity> activityEntities,
                                        ArrayList<TopicModel.ResultEntity.PostEntity> postEntities,
                                        ArrayList<TopicModel.ResultEntity.UserEntity> userEntities,
                                        Bundle bundle) {
        this.mContext=context;
        this.activityEntities=activityEntities;
        this.inflater=LayoutInflater.from(context);
        this.bundle=bundle;
        this.postEntities=postEntities;
        this.userEntities=userEntities;
    }

    /**
     * 根据position返回相应的Item
     */
    @Override
    public int getItemViewType(int position) {
        if(position < bundle.getInt("TYPE1_COUNT")){
            return TYPE_ONE;
        }else if(position== bundle.getInt("TYPE1_COUNT")+ bundle.getInt("TYPE3_COUNT")){
            return TYPE_TWO;//最后
        }
        return TYPE_THREE;
    }

    /**
     * 该方法返回多少个不同的布局
     */
    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getCount() {
        return bundle.getInt("TYPE1_COUNT")+bundle.getInt("TYPE3_COUNT")+1;
    }

    @Override
    public Object getItem(int position) {
        return activityEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder1 viewHolder1=null;
        ViewHolder2 viewHolder2=null;
        ViewHolder3 viewHolder3=null;
        int type=getItemViewType(position);
        if(convertView==null){
            switch (type){
                case TYPE_ONE:
                    viewHolder1=new ViewHolder1();
                    convertView=inflater.inflate(R.layout.item_topic1,null);
                    viewHolder1.tv_tipic_flag=(TextView)convertView.findViewById(R.id.tv_tipic_flag);
                    viewHolder1.iv_topic=(ImageView)convertView.findViewById(R.id.iv_topic);
                    viewHolder1.tv_time=(TextView)convertView.findViewById(R.id.tv_time);
                    viewHolder1.tv_people=(TextView)convertView.findViewById(R.id.tv_people);
                    viewHolder1.btn_join=(Button)convertView.findViewById(R.id.btn_join);
                    convertView.setTag(viewHolder1);
                   break;
                case TYPE_TWO:
                    viewHolder2=new ViewHolder2();
                    convertView=inflater.inflate(R.layout.item_topic2,null);
                    viewHolder2.tv_history=(TextView)convertView.findViewById(R.id.tv_history);
                    viewHolder2.tv1=(TextView)convertView.findViewById(R.id.tv1);
                    viewHolder2.tv2=(TextView)convertView.findViewById(R.id.tv2);
                    viewHolder2.tv3=(TextView)convertView.findViewById(R.id.tv3);
                    viewHolder2.iv1=(ImageView)convertView.findViewById(R.id.iv1);
                    viewHolder2.iv2=(ImageView)convertView.findViewById(R.id.iv2);
                    viewHolder2.iv3=(ImageView)convertView.findViewById(R.id.iv3);
                    convertView.setTag(viewHolder2);
                    break;
                case TYPE_THREE:
                    viewHolder3=new ViewHolder3();
                    convertView=inflater.inflate(R.layout.item_topic3,null);
                    viewHolder3.iv_cover=(ImageView)convertView.findViewById(R.id.iv_cover);
                    viewHolder3.iv_user=(CircleImageView)convertView.findViewById(R.id.iv_user);
                    viewHolder3.tv_user_name=(TextView)convertView.findViewById(R.id.tv_user_name);
                    viewHolder3.tv_title=(TextView)convertView.findViewById(R.id.tv_title);
                    convertView.setTag(viewHolder3);
                    break;
            }
        }else {
           switch (type){
               case TYPE_ONE:
                   viewHolder1=(ViewHolder1)convertView.getTag();
                   break;
               case TYPE_TWO:
                   viewHolder2=(ViewHolder2)convertView.getTag();
                   break;
               case TYPE_THREE:
                   viewHolder3=(ViewHolder3)convertView.getTag();
                   break;
           }
        }
        //data
        switch (type){
            case TYPE_ONE:
                viewHolder1.tv_tipic_flag.setText(activityEntities.get(position).getTitle());
                viewHolder1.tv_time.setText("时间01.08-02.06");
                viewHolder1.tv_people.setText("参与人数"+activityEntities.get(position).getActivityStats().getParticipator()+"人");
                ImageUtils.getInstance().loadWebImage(mContext,viewHolder1.iv_topic,activityEntities.get(position).getImage());
                viewHolder1.btn_join.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                break;
            case TYPE_TWO:
                /*ImageUtils.getInstance().loadWebImage(mContext,viewHolder2.iv1,activityEntities.get(position).getImage());
                ImageUtils.getInstance().loadWebImage(mContext,viewHolder2.iv2,activityEntities.get(position+1).getImage());
                ImageUtils.getInstance().loadWebImage(mContext,viewHolder2.iv3,activityEntities.get(position+2).getImage());*/
                break;
            case TYPE_THREE:
                viewHolder3.tv_user_name.setText(userEntities.get(position - bundle.getInt("TYPE1_COUNT")).getLoginNickname());
                viewHolder3.tv_title.setText("#" + activityEntities.get(position).getTitle());
                ImageUtils.getInstance().loadWebImage(mContext, viewHolder3.iv_user, userEntities.get(position - bundle.getInt("TYPE1_COUNT")).getLoginAvatar());
                if(postEntities.get(position-bundle.getInt("TYPE1_COUNT")).getMedia().size()>1) {
                    ImageUtils.getInstance().loadWebImage(mContext, viewHolder3.iv_cover, postEntities.get(position - bundle.getInt("TYPE1_COUNT")).getMedia().get(1).getOriginalUrl());
                }else{
                    ImageUtils.getInstance().loadWebImage(mContext, viewHolder3.iv_cover, activityEntities.get(position).getBackgroundImage());
                }
                    break;
        }

        return convertView;
    }

    class ViewHolder1{
        ImageView iv_topic;
        TextView tv_tipic_flag;
        TextView tv_time;
        TextView tv_people;
        Button btn_join;
    }
    class ViewHolder2{
        TextView tv_history;
        ImageView iv1;
        TextView tv1;
        ImageView iv2;
        TextView tv2;
        ImageView iv3;
        TextView tv3;
    }
    class ViewHolder3{
        ImageView iv_user;
        TextView tv_user_name;
        TextView tv_title;
        ImageView iv_cover;
    }

}
