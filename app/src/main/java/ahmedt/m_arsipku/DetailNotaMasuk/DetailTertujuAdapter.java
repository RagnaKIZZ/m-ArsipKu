package ahmedt.m_arsipku.DetailNotaMasuk;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel.TertujuItem;
import ahmedt.m_arsipku.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class DetailTertujuAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<TertujuItem> modelList;


    public DetailTertujuAdapter(Context context, ArrayList<TertujuItem> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<TertujuItem> modelList) {
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
            final TertujuItem model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;
            genericViewHolder.itemTxtMessage.setText(model.getNamaJabatan());
            genericViewHolder.itemTxtStts.setVisibility(View.GONE);
            genericViewHolder.itemTglRead.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }


    private TertujuItem getItem(int position) {
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

