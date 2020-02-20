package ahmedt.m_arsipku.SplashScreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.pixplicity.easyprefs.library.Prefs;

import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.Login.LoginActivity;
import ahmedt.m_arsipku.Main.MainActivity;
import ahmedt.m_arsipku.R;

public class SplashActivity extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    private ImageView img_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        img_splash = findViewById(R.id.img_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Prefs.getString(PrefsClass.USERNAME,"").matches("")){
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }else{
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
//                    final KProgressHUD hud = new KProgressHUD(SplashActivity.this);
//                    Utils.showProgressBar(hud, null, null, false);
//                    AndroidNetworking.post(Server.getUserData_URL)
//                            .addHeaders("Authorization",Prefs.getString(PrefsClass.TOKEN, ""))
//                            .build()
//                            .getAsOkHttpResponseAndObject(DataUserModel.class, new OkHttpResponseAndParsedRequestListener<DataUserModel>() {
//                                @Override
//                                public void onResponse(Response okHttpResponse, DataUserModel response) {
//                                    hud.dismiss();
//                                    if (okHttpResponse.isSuccessful()){
//                                        if (response.getStatus()==200){
//                                            Prefs.putString(PrefsClass.ID_SO, response.getData().getIdSo());
//                                            Prefs.putString(PrefsClass.NAMA, response.getData().getNama());
//                                            Prefs.putString(PrefsClass.EMAIL, response.getData().getEmail());
//                                            Prefs.putString(PrefsClass.USERNAME, response.getData().getUsername());
//                                            Prefs.putString(PrefsClass.KODE_JABATAN, response.getData().getKodeJabatan());
//                                            Prefs.putString(PrefsClass.JABATAN, response.getData().getJabatan());
//                                            Prefs.putString(PrefsClass.INDEX, response.getData().getIndex());
//                                            Prefs.putString(PrefsClass.ID_CABANG, response.getData().getIdCabang());
//                                            Prefs.putString(PrefsClass.NAMA_CABANG, response.getData().getNamaCabang());
//                                            Prefs.putString(PrefsClass.GROUP_MENU, response.getData().getGroupmenu());
//                                            Prefs.putString(PrefsClass.FOTO, Server.imgURL+response.getData().getUsername()+"/"+response.getData().getUsername()+".jpg");
//                                            Prefs.putString(PrefsClass.ID_SEK, response.getData().getIdSek());
//                                            Prefs.putString(PrefsClass.ID_PH, response.getData().getIdPh());
//                                            Prefs.putString(PrefsClass.PTS_PH, response.getData().getPtsPh());
//                                            Prefs.putString(PrefsClass.JABATAN_SEK, response.getData().getJabatansek());
//                                            Prefs.putString(PrefsClass.JABATAN_PH, response.getData().getJabatanph());
//                                            Prefs.putString(PrefsClass.GROUP_MENU_SEK, response.getData().getGroupmenusek());
//                                            Prefs.putString(PrefsClass.GROUP_MENU_PH, response.getData().getGroupmenuph());
//                                            Prefs.putString(PrefsClass.GROUP_PARAM, response.getData().getGroupmenu());
//                                            Prefs.putString(PrefsClass.ID_PARAM, response.getData().getIdSo());
//
//                                            startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                                            finish();
//                                        }else{
//                                            Toast.makeText(SplashActivity.this, "Token Invalid", Toast.LENGTH_SHORT).show();
//                                            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                                            finish();
//                                        }
//                                    }
//                                }
//
//                                @Override
//                                public void onError(ANError anError) {
//                                    hud.dismiss();
//                                    Log.d(TAG, "onError: "+anError.getErrorDetail().toString());
//                                    Toast.makeText(SplashActivity.this, "Jaringan bermasalah", Toast.LENGTH_SHORT).show();
//                                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
//                                    finish();
//
//                                }
//                            });
                }
            }
        },2000);
        



    }
}
