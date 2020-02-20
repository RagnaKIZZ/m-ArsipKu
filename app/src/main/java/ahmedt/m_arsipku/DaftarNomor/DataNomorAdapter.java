package ahmedt.m_arsipku.DaftarNomor;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class DataNomorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = "DataNomorAdap";

    private Context mContext;
    private ArrayList<DataItem> modelList;

    private OnItemClickListener mItemClickListener;


    public DataNomorAdapter(Context context, ArrayList<DataItem> modelList) {
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

            String stts_pakai    = model.getSttspakai();

            if (nosur != null){
                if (nosur.length()>=35){
                    nosur = nosur.substring(0,32)+("...");
                }else if (nosur.isEmpty()){
                    nosur = "[menunggu nomor surat]";
                }
            }else {
                nosur = "[menunggu nomor surat]";
            }

            if (stts_pakai.equals("1")){
                genericViewHolder.itemTxtStts.setText("Sudah Terpakai");
                genericViewHolder.itemTxtTitle.setTextColor(Color.GRAY);
                genericViewHolder.itemTxtTanggal.setTextColor(Color.GRAY);
            }else if (stts_pakai.equals("0")){
                genericViewHolder.itemTxtStts.setText("Belum Terpakai");
                genericViewHolder.itemTxtTitle.setTextColor(Color.BLACK);
                genericViewHolder.itemTxtTanggal.setTextColor(Color.BLACK);
            }

//            if (model.getSttsDistribusi() != null){
//                String stts = model.getSttsDistribusi();
//                if (stts.equals("1")){
//                    genericViewHolder.itemTxtStts.setText("Sudah Terpakai");
//                }else{
//                    genericViewHolder.itemTxtTitle.setTextColor(Color.BLACK);
//                    genericViewHolder.itemTxtTanggal.setTextColor(Color.BLACK);
//                    genericViewHolder.itemTxtStts.setText("Belum Terpakai");
//                }
//
//            }
            genericViewHolder.itemTxtTitle.setText(nosur);
            genericViewHolder.itemTxtMessage.setVisibility(View.GONE);
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

