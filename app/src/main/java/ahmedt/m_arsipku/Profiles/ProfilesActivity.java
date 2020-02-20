package ahmedt.m_arsipku.Profiles;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.pixplicity.easyprefs.library.Prefs;

import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.Helper.Utils;
import ahmedt.m_arsipku.R;

public class ProfilesActivity extends AppCompatActivity {
    private TextView txt_nama, txt_email, txt_jabatan, txt_jabatanph, txt_cabang;
    private ImageView img_foto;
    private Toolbar toolbar;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profiles);

        findView();
        setActionBarTitle("Profil");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
                default:
                    return super.onOptionsItemSelected(item);
        }

    }

    private void findView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt_nama = findViewById(R.id.txt_nama_profiles);
        txt_email = findViewById(R.id.txt_email_profiles);
        txt_jabatan = findViewById(R.id.txt_jabatan_profiles);
        txt_jabatanph = findViewById(R.id.txt_jabatan_ph_profiles);
        txt_cabang = findViewById(R.id.txt_cabang_profiles);

        img_foto = findViewById(R.id.img_profiles);
        pb = findViewById(R.id.pb_profil);

        txt_nama.setText(Prefs.getString(PrefsClass.NAMA, ""));
        txt_email.setText(Prefs.getString(PrefsClass.EMAIL, ""));
        txt_jabatan.setText(Prefs.getString(PrefsClass.JABATAN, ""));
        if (Prefs.getString(PrefsClass.JABATAN_PH,"").matches("")&&Prefs.getString(PrefsClass.JABATAN_SEK,"").matches("")){
            txt_jabatanph.setText("-");
        }else if (Prefs.getString(PrefsClass.JABATAN_PH,"").matches("")){
            txt_jabatanph.setText(Prefs.getString(PrefsClass.JABATAN_SEK,""));
        }else if (Prefs.getString(PrefsClass.JABATAN_SEK,"").matches("")){
            txt_jabatanph.setText(Prefs.getString(PrefsClass.JABATAN_PH,""));
        }
        txt_cabang.setText(Prefs.getString(PrefsClass.NAMA_CABANG, ""));
        Utils.LoadImage(this, pb, Prefs.getString(PrefsClass.FOTO,""), img_foto);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}
