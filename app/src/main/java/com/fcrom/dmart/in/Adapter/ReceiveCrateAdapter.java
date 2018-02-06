package com.fcrom.dmart.in.Adapter;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fcrom.dmart.in.R;
import com.fcrom.dmart.in.Utils.Logger;
import com.fcrom.library.Model.Trip.CrateList;

import java.util.List;

import static com.fcrom.library.Constant.API_urls.context;

/**
 * Created by anamika.chavan on 02-02-2018.
 */
public class ReceiveCrateAdapter extends RecyclerView.Adapter<ReceiveCrateAdapter.Holder> {
    Context mContext;
    List<CrateList> datalist;
    View view;
    Holder viewHolder1;
    String TAG = "ReceiveCrateAdapter";
    public ReceiveCrateAdapter(Context context, List<CrateList> listCrate) {

        this.mContext = context;
        this.datalist = listCrate;

    }

    @Override
    public ReceiveCrateAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.crate_receive_listitem,parent,false);

        viewHolder1 = new ReceiveCrateAdapter.Holder(view);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ReceiveCrateAdapter.Holder holder, int position) {
        holder.orderno.setText(datalist.get(position).getCrateId());
        holder.consignment_no.setText(datalist.get(position).getConsignmentId());
        Logger.log(TAG,"---isScanned----"+datalist.get(position).getIsscanned());
        if(datalist.get(position).getIsscanned()){
            holder.iv_indicator.setBackgroundResource(R.drawable.circle_green);

        } else{
            holder.iv_indicator.setBackgroundResource(R.drawable.circle_red);
        }

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView orderno, status, consignment_no;
        ImageView iv_indicator;

        public Holder(View itemView) {
            super(itemView);
            orderno = (TextView) itemView.findViewById(R.id.orderno);
            consignment_no = (TextView) itemView.findViewById(R.id.consignment_no);
            status = (TextView) itemView.findViewById(R.id.status);
            iv_indicator = (ImageView) itemView.findViewById(R.id.iv_indicator);

        }
    }
}
