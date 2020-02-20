package ahmedt.m_arsipku.DetailSuratMasuk;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ahmedt.m_arsipku.R;


/**
 * A custom adapter to use with the RecyclerView widget.
 */
public class DetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private ArrayList<DetailModel> modelList;

    private OnItemClickListener mItemClickListener;


    public DetailAdapter(Context context, ArrayList<DetailModel> modelList) {
        this.mContext = context;
        this.modelList = modelList;
    }

    public void updateList(ArrayList<DetailModel> modelList) {
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_file, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        //Here you can fill your row view
        if (holder instanceof ViewHolder) {
            final DetailModel model = getItem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            String lampiran = model.getLampiran();

            if (lampiran.toLowerCase().contains("nota")|lampiran.toLowerCase().contains("surat")|lampiran.toLowerCase().contains("disposisi")){
                genericViewHolder.card_bg.setCardBackgroundColor(Color.RED);
            }
            genericViewHolder.itemTxtMessage.setText(model.getLampiran());
        }
    }


    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    private DetailModel getItem(int position) {
        return modelList.get(position);
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position, DetailModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTxtMessage;
        private CardView card_bg;


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
            this.card_bg = (CardView) itemView.findViewById(R.id.card_bg);
            this.itemTxtMessage = (TextView) itemView.findViewById(R.id.txt_item_file);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mItemClickListener.onItemClick(itemView, getAdapterPosition(), modelList.get(getAdapterPosition()));


                }
            });

        }
    }

}

