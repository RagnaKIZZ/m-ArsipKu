package ahmedt.m_arsipku.Helper;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.kaopiz.kprogresshud.KProgressHUD;

import ahmedt.m_arsipku.R;

public class Utils {
    public static void showProgressBar(KProgressHUD hud, String title, String detail, Boolean cancelable){

        if(title==null){
            title = "Loading";
        }
        if (detail==null){
            detail = "Please Wait";
        }
        hud.setLabel(title);
        hud .setDetailsLabel(detail);
        hud.setDimAmount(0.4f);
        hud.setCancellable(cancelable);
        hud.show();
    }

    public static void LoadImage(final Context context, final ProgressBar pb, String url, final ImageView img){
        Glide.with(context)
                .load(url)
                .disallowHardwareConfig()
                .timeout(20000)
                .centerCrop()
               .listener(new RequestListener<Drawable>() {
                   @Override
                   public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                       pb.setVisibility(View.GONE);
                       Log.d(String.valueOf(context), "onLoadFailed: "+target);
                       Toast.makeText(context, "Gambar gagal dimuat"+"\n "+"periksa sambungan", Toast.LENGTH_SHORT).show();
                       img.setImageResource(R.drawable.ic_person_black_24dp);
                       return false;
                   }

                   @Override
                   public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                       pb.setVisibility(View.GONE);
                       return false;
                   }
               })
                .into(img);
    }

}
