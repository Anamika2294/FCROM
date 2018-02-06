package com.fcrom.dmart.in.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fcrom.dmart.in.Activity.Trip.TripReceiveListActivity;
import com.fcrom.dmart.in.R;
import com.fcrom.dmart.in.Utils.Logger;
import com.fcrom.library.Model.Trip.TripList;

import java.util.List;

import static com.fcrom.library.Constant.API_urls.context;


/**
 * Created by Nitish.Gaikwad on 15-02-2017.
 */

public class TripsAdapter extends RecyclerView.Adapter<TripsAdapter.Holder> {
    private static final String TAG ="TripsAdapter" ;
    Context mContext;
    // List<ShipmentDetail> datalist;
    List<TripList> datalist;//= new ArrayList<Shipment>();
    //List<Shipment> arraylist;//= new ArrayList<Shipment>();
    View view;
    Holder viewHolder1;
    int position;

    public TripsAdapter(Context context,List<TripList> listReceiveOrder) {

        this.mContext = context;
        this.datalist = listReceiveOrder;

    }

    @Override
    public TripsAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(context).inflate(R.layout.trips_list_item,parent,false);

        viewHolder1 = new Holder(view);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {

        this.position=position;

        holder.tv_tripno.setPaintFlags(holder.tv_tripno.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

 //       Logger.log("TripSize",""+datalist.size());



        holder.tv_vehicleno.setText(datalist.get(position).getVehicleNumber());
//        holder.tv_ordercount.setText(datalist.get(i).getTotalOrders());
        holder.tv_tripno.setText(datalist.get(position).getTripId());
        holder.tv_drivername.setText(datalist.get(position).getDriverPhone());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                   // Logger.log(TAG,"datalistsize"+datalist.get(holder.getAdapterPosition()).getCrateList().size()+" Position"+position);
                    if(datalist.get(holder.getAdapterPosition()).getCrateList().size()>0 && datalist.get(holder.getAdapterPosition()).getCrateList() !=null && !datalist.get(holder.getAdapterPosition()).getCrateList().isEmpty()){
                        Intent intent = new Intent(mContext, TripReceiveListActivity.class);
                        intent.putExtra("position",holder.getAdapterPosition());
                        Logger.log(TAG,"______--- "+holder.getAdapterPosition());
                        ((Activity) mContext).startActivityForResult(intent,1111);
                        //((Activity) mContext).startActivityForResult(intent,1111);
                    }





            }
        });

        Logger.log(TAG,"GetScannedCount"+getScannedCrateCount());
        holder.tv_cratecount.setText(""+getScannedCrateCount()+"/"+datalist.get(position).getCrateList().size());
    }

    public int getScannedCrateCount(){

        int count=0;
        for(int i=0;i<datalist.get(position).getCrateList().size();i++){
           if(datalist.get(position).getCrateList().get(i).getIsscanned()){
               count++;
           }
        }
        return  count;
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }


    public class Holder extends RecyclerView.ViewHolder {
        TextView tv_cratecount, tv_vehicleno, tv_ordercount, tv_tripno, tv_drivername;
        ImageView iv_call;

        public Holder(View itemView) {
            super(itemView);
            tv_cratecount = (TextView) view.findViewById(R.id.tv_cratecount);
            tv_vehicleno = (TextView) view.findViewById(R.id.tv_vehicleno);
            tv_tripno = (TextView) view.findViewById(R.id.tv_tripno);
            tv_drivername = (TextView) view.findViewById(R.id.tv_drivername);
            tv_tripno = (TextView) view.findViewById(R.id.tv_tripno);
            iv_call = (ImageView) view.findViewById(R.id.iv_call);


        }
    }

    public  void onActivityResult(int requestCode, int resultCode, Intent data) {
        Logger.log("MyAdapter", "onActivityResult");
    }

}


