package ahmedt.m_arsipku.Main;

import android.app.ActivityOptions;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;
import java.util.List;

import ahmedt.m_arsipku.DaftarNomor.DataNomorActivity;
import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.Helper.Utils;
import ahmedt.m_arsipku.Login.LoginActivity;
import ahmedt.m_arsipku.MemoMasuk.MemoMasukActivity;
import ahmedt.m_arsipku.MemoTerkirim.MemoTerkirimActivity;
import ahmedt.m_arsipku.NotaDisposisiKeluar.NotaDisposisiKeluarActivity;
import ahmedt.m_arsipku.NotaDisposisiMasuk.NotaDisposisiMasukActivity;
import ahmedt.m_arsipku.NotaMasuk.NotaMasukActivity;
import ahmedt.m_arsipku.NotaTerkirim.NotaTerkirimActivity;
import ahmedt.m_arsipku.Profiles.ProfilesActivity;
import ahmedt.m_arsipku.R;
import ahmedt.m_arsipku.SuratDisposisiKeluar.SuratDisposisiKeluarActivity;
import ahmedt.m_arsipku.SuratDisposisiMasuk.SuratDisposisiMasukActivity;
import ahmedt.m_arsipku.SuratMasuk.SuratMasukActivity;
import ahmedt.m_arsipku.SuratTerkirim.SuratTerkirimActivity;
import me.leolin.shortcutbadger.ShortcutBadger;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private LinearLayout    cv_kotak_surat, cv_terkirim_surat, cv_dispos_masuk_surat,
                            cv_dispos_keluar_surat, cv_kotak_nota, cv_terkirim_nota, cv_dispos_masuk_nota,
                            cv_dispos_keluar_nota, cv_kotak_memo, cv_terkirim_memo, bc_header;
    private CardView        cv_daftarnomor, cv_memo, badge_surat, badge_sd, badge_nota, badge_nd;
    private DrawerLayout    drawerLayout;
    private ImageView       foto;
    private TextView        nama, txtB1, txtB2, txtB3, txtB4;
    private NavigationView  navigationView;
    private Toolbar         toolbar;
    private Spinner         head_spinner;
    private View            headerView;
    private ProgressBar     pb;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_new2);

            findView();
            setMenu();
            clickCardView();
            setNavbar();
            setContent();
            showBadge(Prefs.getString(PrefsClass.ID_PARAM, ""));
            Log.d(TAG, "onCreate: "+Prefs.getString(PrefsClass.FOTO,""));
    }

    @Override
    protected void onResume() {
        super.onResume();

//        setMsgDays();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            //jika navbarnya sudah tertutup maka akan menjalankan printah onbackpressednya
            LogOut();
        }
    }

    private void LogOut(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        // set title dialog
        alertDialogBuilder.setTitle("Ingin Keluar dari Aplikasi?");
        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar")
                .setIcon(R.drawable.ic_exit_to_app_black_24dp)
                .setCancelable(true)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NO_HISTORY);
                        Prefs.clear();
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();
        // menampilkan alert dialog
        alertDialog.show();

    }

    private void setNavbar(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void findView(){

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout    = findViewById(R.id.drawer_layout);
        navigationView  = findViewById(R.id.nav_view);


        //inisiasi cardview
        cv_daftarnomor          = findViewById(R.id.cv_daftar_nomor);
        cv_kotak_surat          = findViewById(R.id.cv_kotak_surat);
        cv_terkirim_surat       = findViewById(R.id.cv_terkirim_surat);
        cv_dispos_masuk_surat   = findViewById(R.id.cv_dispos_masuk_surat);
        cv_dispos_keluar_surat  = findViewById(R.id.cv_dispos_keluar_surat);
        cv_kotak_nota           = findViewById(R.id.cv_kotak_nota);
        cv_terkirim_nota        = findViewById(R.id.cv_terkirim_nota);
        cv_dispos_masuk_nota    = findViewById(R.id.cv_dispos_masuk_nota);
        cv_dispos_keluar_nota   = findViewById(R.id.cv_dispos_keluar_nota);
        cv_memo                 = findViewById(R.id.cv_memo);
        cv_kotak_memo           = findViewById(R.id.cv_kotak_memo);
        cv_terkirim_memo        = findViewById(R.id.cv_terkirim_memo);
        badge_surat             = findViewById(R.id.badge_1);
        badge_sd                = findViewById(R.id.badge_2);
        badge_nota              = findViewById(R.id.badge_3);
        badge_nd                = findViewById(R.id.badge_4);
        txtB1                   = findViewById(R.id.txt_badge_1);
        txtB2                   = findViewById(R.id.txt_badge_2);
        txtB3                   = findViewById(R.id.txt_badge_3);
        txtB4                   = findViewById(R.id.txt_badge_4);

        headerView = navigationView.getHeaderView(0);

        nama            = headerView.findViewById(R.id.nama_header);
        head_spinner    = headerView.findViewById(R.id.spinner_jabatan);
        foto            = headerView.findViewById(R.id.foto_header);
        pb              = headerView.findViewById(R.id.pb_img);
        foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ProfilesActivity.class);

                View sharedView = foto;
                String transitionName = getString(R.string.foto_trans);
                ActivityOptions transOpt = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    transOpt = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, sharedView, transitionName);
                    startActivity(i, transOpt.toBundle());
                }else{
                    startActivity(new Intent(MainActivity.this, ProfilesActivity.class));
                }

            }
        });
    }

    private void setMenu(){
        if (Prefs.getString(PrefsClass.GROUP_PARAM, "").equals("1")){
            cv_daftarnomor.setVisibility(View.GONE);

            cv_kotak_surat.setVisibility(View.VISIBLE);
            cv_terkirim_surat.setVisibility(View.VISIBLE);
            cv_dispos_masuk_surat.setVisibility(View.VISIBLE);
            cv_dispos_keluar_surat.setVisibility(View.VISIBLE);

            cv_kotak_nota.setVisibility(View.VISIBLE);
            cv_terkirim_nota.setVisibility(View.VISIBLE);
            cv_dispos_masuk_nota.setVisibility(View.VISIBLE);
            cv_dispos_keluar_nota.setVisibility(View.VISIBLE);

            cv_memo.setVisibility(View.GONE);
            cv_kotak_memo.setVisibility(View.GONE);
            cv_terkirim_memo.setVisibility(View.GONE);

        }else  if (Prefs.getString(PrefsClass.GROUP_PARAM, "").equals("2")){

            cv_daftarnomor.setVisibility(View.GONE);

            cv_kotak_surat.setVisibility(View.GONE);
            cv_terkirim_surat.setVisibility(View.GONE);
            cv_dispos_masuk_surat.setVisibility(View.VISIBLE);
            cv_dispos_keluar_surat.setVisibility(View.VISIBLE);

            cv_kotak_nota.setVisibility(View.VISIBLE);
            cv_terkirim_nota.setVisibility(View.VISIBLE);
            cv_dispos_masuk_nota.setVisibility(View.VISIBLE);
            cv_dispos_keluar_nota.setVisibility(View.VISIBLE);

            cv_memo.setVisibility(View.GONE);
            cv_kotak_memo.setVisibility(View.GONE);
            cv_terkirim_memo.setVisibility(View.GONE);

        } else  if (Prefs.getString(PrefsClass.GROUP_PARAM, "").equals("3")){

            cv_daftarnomor.setVisibility(View.GONE);

            cv_kotak_surat.setVisibility(View.GONE);
            cv_terkirim_surat.setVisibility(View.GONE);
            cv_dispos_masuk_surat.setVisibility(View.VISIBLE);
            cv_dispos_keluar_surat.setVisibility(View.VISIBLE);

            cv_kotak_nota.setVisibility(View.GONE);
            cv_terkirim_nota.setVisibility(View.VISIBLE);
            cv_dispos_masuk_nota.setVisibility(View.VISIBLE);
            cv_dispos_keluar_nota.setVisibility(View.VISIBLE);

            cv_memo.setVisibility(View.VISIBLE);
            cv_kotak_memo.setVisibility(View.VISIBLE);
            cv_terkirim_memo.setVisibility(View.GONE);

        }else  if (Prefs.getString(PrefsClass.GROUP_PARAM, "").equals("4")){

            cv_daftarnomor.setVisibility(View.GONE);

            cv_kotak_surat.setVisibility(View.GONE);
            cv_terkirim_surat.setVisibility(View.GONE);
            cv_dispos_masuk_surat.setVisibility(View.VISIBLE);
            cv_dispos_keluar_surat.setVisibility(View.GONE);

            cv_kotak_nota.setVisibility(View.GONE);
            cv_terkirim_nota.setVisibility(View.GONE);
            cv_dispos_masuk_nota.setVisibility(View.VISIBLE);
            cv_dispos_keluar_nota.setVisibility(View.GONE);

            cv_memo.setVisibility(View.VISIBLE);
            cv_kotak_memo.setVisibility(View.GONE);
            cv_terkirim_memo.setVisibility(View.VISIBLE);

        }
    }

    private void clickCardView(){

        cv_daftarnomor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, DataNomorActivity.class));
            }
        });

        cv_kotak_surat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge_surat.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, SuratMasukActivity.class));

            }
        });

        cv_terkirim_surat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SuratTerkirimActivity.class));
            }
        });
        cv_dispos_masuk_surat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge_sd.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, SuratDisposisiMasukActivity.class));

            }
        });
        cv_dispos_keluar_surat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SuratDisposisiKeluarActivity.class));
            }
        });

        cv_kotak_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge_nota.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, NotaMasukActivity.class));

            }
        });
        cv_terkirim_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotaTerkirimActivity.class));
            }
        });
        cv_dispos_masuk_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge_nd.setVisibility(View.GONE);
                startActivity(new Intent(MainActivity.this, NotaDisposisiMasukActivity.class));
            }
        });
        cv_dispos_keluar_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NotaDisposisiKeluarActivity.class));
            }
        });


        cv_kotak_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemoMasukActivity.class));
            }
        });
        cv_terkirim_memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MemoTerkirimActivity.class));
            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem menuItem) {

                    switch (menuItem.getItemId()){
                        case R.id.menu_profiles:
                            Intent i = new Intent(MainActivity.this, ProfilesActivity.class);
                            View sharedView = foto;
                            String transitionName = getString(R.string.foto_trans);
                            ActivityOptions transOpt = null;
                            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                                transOpt = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, sharedView, transitionName);
                                startActivity(i, transOpt.toBundle());
                            }else{
                            startActivity(new Intent(MainActivity.this, ProfilesActivity.class));
                        }
                            break;
                        case R.id.menu_logout:
                            drawerLayout.closeDrawer(GravityCompat.START);
                            LogOut();
                            break;
                    }
        return true;
    }

    private void addItemSpinner(){

        String jabatan ,jabatan_sek, jabatan_ph, pts_ph;

        jabatan     = Prefs.getString(PrefsClass.JABATAN,"");
        jabatan_ph  = Prefs.getString(PrefsClass.JABATAN_SEK,"");
        jabatan_sek = Prefs.getString(PrefsClass.JABATAN_PH,"");
        pts_ph      = Prefs.getString(PrefsClass.PTS_PH,"");

        List<String> list = new ArrayList<>();

        if (jabatan_ph.matches("") && jabatan_sek.matches("")){
            list.add(jabatan);
        } else if (jabatan_sek.matches("")){
            list.add(jabatan);
            list.add(pts_ph+" "+jabatan_ph);
        }else if (jabatan_ph.matches("")){
            list.add(jabatan);
            list.add(pts_ph+" "+jabatan_sek);
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(MainActivity.this,R.layout.custom_spinner_layout, list);
        head_spinner.setAdapter(dataAdapter);
        head_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String menuParam, idParam;
                switch (position){
                    case 0:
                        menuParam   = Prefs.getString(PrefsClass.GROUP_MENU,"");
                        idParam     = Prefs.getString(PrefsClass.ID_SO,"");

                        Prefs.putString(PrefsClass.GROUP_PARAM,menuParam);
                        Prefs.putString(PrefsClass.ID_PARAM, idParam);

                        Log.d("GRUP PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.GROUP_PARAM,""));
                        Log.d("ID PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.ID_PARAM,""));
                        setMenu();
                        showBadge(Prefs.getString(PrefsClass.ID_PARAM, ""));
//                        Toast.makeText(MainActivity.this, "Jabatan telah terganti, mohon refresh data", Toast.LENGTH_LONG).show();
                        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                            drawerLayout.closeDrawer(GravityCompat.START);
                        }
                        break;
                    case 1:
                        if (Prefs.getString(PrefsClass.GROUP_MENU_SEK,"").equals("")){
                            menuParam   = Prefs.getString(PrefsClass.GROUP_MENU_PH,"");
                            idParam     = Prefs.getString(PrefsClass.ID_PH,"");

                            Prefs.putString(PrefsClass.GROUP_PARAM,menuParam);
                            Prefs.putString(PrefsClass.ID_PARAM,idParam);

                            Log.d("GRUP PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.GROUP_PARAM,""));
                            Log.d("ID PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.ID_PARAM,""));
                        }else{
                            menuParam   = Prefs.getString(PrefsClass.GROUP_MENU_PH,"");
                            idParam     = Prefs.getString(PrefsClass.ID_SEK,"");

                            Prefs.putString(PrefsClass.GROUP_PARAM,menuParam);
                            Prefs.putString(PrefsClass.ID_PARAM,idParam);

                            Log.d("GRUP PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.GROUP_PARAM,""));
                            Log.d("ID PARAM", "onItemSelected: "+Prefs.getString(PrefsClass.ID_PARAM,""));
                        }
                        setMenu();
                        showBadge(Prefs.getString(PrefsClass.ID_PARAM, ""));
//                        Toast.makeText(MainActivity.this, "Jabatan telah terganti, mohon refresh data", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        }

        private void setContent(){
        //panggil nama dan jabatan
        nama.setText(Prefs.getString(PrefsClass.NAMA, ""));
//        txt_msg_nama.setText(Prefs.getString(PrefsClass.NAMA,""));

        //set foto di header navbar
        Utils.LoadImage(MainActivity.this, pb, Prefs.getString(PrefsClass.FOTO,""),foto);
        addItemSpinner();

        setActionBarTitle("");

        }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void showBadge(String id){
        KProgressHUD hud = new KProgressHUD(this);
        Utils.showProgressBar(hud, null, null, false);
        AndroidNetworking.post(Server.getURL_BadgeIndicator)
                .addBodyParameter("id_so", id)
                .build()
                .getAsOkHttpResponseAndObject(BadgeModel.class, new OkHttpResponseAndParsedRequestListener<BadgeModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, BadgeModel response) {
                        if (okHttpResponse.isSuccessful()){
                            hud.dismiss();
                            String b1,b2,b3,b4;
                            b1 = response.getData().getSuratMasuk();
                            b2 = response.getData().getSuratDisposisi();
                            b3 = response.getData().getNotaDinas();
                            b4 = response.getData().getNotaDisposisi();

                            int i1,i2,i3,i4, total;
                            i1 = Integer.parseInt(b1);
                            i2 = Integer.parseInt(b2);
                            i3 = Integer.parseInt(b3);
                            i4 = Integer.parseInt(b4);
                            total = i1+i2+i3+i4;

                            if (!b1.equals("0")){
                                txtB1.setText(b1);
                                badge_surat.setVisibility(View.VISIBLE);
                            }else{
                                badge_surat.setVisibility(View.GONE);
                            }

                            if (!b2.equals("0")){
                                txtB2.setText(b2);
                                badge_sd.setVisibility(View.VISIBLE);
                            }else{
                                badge_sd.setVisibility(View.GONE);
                            }

                            if (!b3.equals("0")){
                                txtB3.setText(b3);
                                badge_nota.setVisibility(View.VISIBLE);
                            }else {
                                badge_nota.setVisibility(View.GONE);
                            }

                            if (!b4.equals("0")){
                                txtB4.setText(b4);
                                badge_nd.setVisibility(View.VISIBLE);
                            }else {
                                badge_nd.setVisibility(View.GONE);
                            }

//                            if (total > 0){
//                                ShortcutBadger.applyCount(MainActivity.this, total);
//                            }
                        }

                    }

                    @Override
                    public void onError(ANError anError) {
                        hud.dismiss();
                    }
                });
    }
}


