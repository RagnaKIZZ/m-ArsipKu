package ahmedt.m_arsipku.DaftarNomor.CariDataNomor;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ahmedt.m_arsipku.DaftarNomor.DataItem;
import ahmedt.m_arsipku.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class CariDataNomorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "DataNomorAdap";

    private Context mContext;
    private ArrayList<DataItem> modelList;

    private OnItemClickListener mItemClickListener;


    public CariDataNomorAdapter(Context context, ArrayList<DataItem> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<DataItem> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_list_2, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final DataItem model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            String nosur = model.getNoSurat();
            String jabter = model.getFileAttach();
            String perihal = model.getSttsDistribusi();
            String stts    = model.getSttspakai();
            String tertuju = model.getTertuju();

            if (nosur != null){
                if (nosur.length()>=35){
                    nosur = nosur.substring(0,32)+("...");
                }else if (nosur.isEmpty()){
                    nosur = "[menunggu nomor surat]";
                }
            }else {
                nosur = "[menunggu nomor surat]";
            }

            if (!jabter.isEmpty()){
                jabter = "File Surat";
            }else{
                jabter = "Tidak Ada";
            }

            if (perihal != null){
                if (perihal.equals("1")){
                    perihal = "Distribusikan";
                }else if (perihal.equals("0")){
                    perihal = "Tidak di Distribusikan";
                }
            }else {
                perihal = "";
            }

            if (stts.equals("1")){
                genericViewHolder.relative.setBackgroundResource(R.drawable.bayangan);
                genericViewHolder.itemTxtTitle.setTextColor(Color.GRAY);
            }else{

            }

            if (tertuju.equals("")){
                tertuju = "";
            }else {
                tertuju = "Tertuju : "+tertuju;
            }

            genericViewHolder.itemTxtTitle.setText(nosur);
            genericViewHolder.itemTxtMessage.setText(jabter);
            genericViewHolder.itemTxtPerihal.setText(perihal);
            genericViewHolder.itemTxtStts.setText(tertuju);
            //to catch time
            String time = model.getTglbermohon();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try{
                Date date = format.parse(time);
                SimpleDateFormat format1 = new SimpleDateFormat("dd MMM yyyy/h:mm a");
                String realTime = format1.format(date);
                genericViewHolder.itemTxtTanggal.setText(realTime);
            }catch(Exception e){
                Log.d(TAG, "onBindViewHolder: "+e.getMessage());
            }


        }
    }


    @Override
    public int getItemCount() {

        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private DataItem getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, DataItem model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView itemTxtTitle;
        private TextView itemTxtMessage;
        private TextView itemTxtTanggal;
        private TextView itemTxtPerihal;
        private TextView itemTxtStts;
        private RelativeLayout relative;


        // @BindView(R.id.img_user)
        // ImageView imgUser;
        // @BindView(R.id.item_txt_title)
        // TextView itemTxtTitle;
        // @BindView(R.id.item_txt_message)
        // TextView itemTxtMessage;
        // @BindView(R.id.radio_list)
        // RadioButton itemTxtMessage;
        // @BindView(R.id.check_list)
        // CheckBox itemCheckList;
        public ViewHolder(final View itemView) {
            super(itemView);

            // ButterKnife.bind(this, itemView);
            this.itemTxtTitle = (TextView) itemView.findViewById(R.id.item_txt_title);
            this.itemTxtMessage = (TextView) itemView.findViewById(R.id.item_txt_message);
            this.itemTxtPerihal = (TextView) itemView.findViewById(R.id.item_txt_perihal);
            this.itemTxtTanggal = (TextView) itemView.findViewById(R.id.item_txt_tanggal);
            this.itemTxtStts    = (TextView) itemView.findViewById(R.id.item_txt_stts);
            this.relative       = (RelativeLayout) itemView.findViewById(R.id.container_item);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));


                }
            });

        }
    }

}

