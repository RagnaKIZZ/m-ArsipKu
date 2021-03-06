package ahmedt.m_arsipku.DetailNotaMasuk;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel.TembusanItem;
import ahmedt.m_arsipku.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class DetailTembusanTAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "DetailTembusanTAdapter";

    private Context mContext;
    private ArrayList<TembusanItem> modelList;


    public DetailTembusanTAdapter(Context context, ArrayList<TembusanItem> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<TembusanItem> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tertuju_tembusan, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final TembusanItem model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            if (!model.getNamaJabatan().isEmpty()){
                genericViewHolder.itemTxtMessage.setText(model.getNamaJabatan());
                genericViewHolder.itemTxtStts.setText(model.getStatus());
                if (model.getStatus().toLowerCase().equals("unread")){
                    genericViewHolder.itemTxtStts.setTextColor(Color.RED);
                    genericViewHolder.itemTglRead.setVisibility(View.GONE);
                }else {
                    genericViewHolder.itemTxtStts.setTextColor(Color.GREEN);
                    genericViewHolder.itemTglRead.setVisibility(View.VISIBLE);
                    String tgRead = model.getTglRead();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try{
                        Date date = format.parse(tgRead);
                        SimpleDateFormat format1 = new SimpleDateFormat("dd MMM yyyy h:mm a");
                        String realTime = format1.format(date);
                        genericViewHolder.itemTglRead.setText(realTime);
                    }catch(Exception e){
                        Log.d(TAG, "onBindViewHolder: "+e.getMessage());
                    }
                }
            }else{
                genericViewHolder.itemTxtMessage.setText("Tidak Ada");
            }
        }
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }


    private TembusanItem getItem(int position) {
        return modelList.get(position);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTxtMessage;
        private TextView itemTxtStts;
        private TextView itemTglRead;


        public ViewHolder(final View itemView) {
            super(itemView);

            this.itemTxtMessage = (TextView) itemView.findViewById(R.id.item_txt_message);
            this.itemTxtStts    = (TextView) itemView.findViewById(R.id.item_txt_stts);
            this.itemTglRead    = (TextView) itemView.findViewById(R.id.item_txt_tgl_read);

        }
    }

}

