package ahmedt.m_arsipku.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.pixplicity.easyprefs.library.Prefs;

import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.Helper.Utils;
import ahmedt.m_arsipku.Login.LoginModel.LoginModel;
import ahmedt.m_arsipku.Main.MainActivity;
import ahmedt.m_arsipku.R;
import okhttp3.Response;

import static ahmedt.m_arsipku.Helper.PrefsClass.EMAIL;
import static ahmedt.m_arsipku.Helper.PrefsClass.FOTO;
import static ahmedt.m_arsipku.Helper.PrefsClass.GROUP_MENU;
import static ahmedt.m_arsipku.Helper.PrefsClass.GROUP_MENU_PH;
import static ahmedt.m_arsipku.Helper.PrefsClass.GROUP_MENU_SEK;
import static ahmedt.m_arsipku.Helper.PrefsClass.GROUP_PARAM;
import static ahmedt.m_arsipku.Helper.PrefsClass.ID_CABANG;
import static ahmedt.m_arsipku.Helper.PrefsClass.ID_PARAM;
import static ahmedt.m_arsipku.Helper.PrefsClass.ID_PH;
import static ahmedt.m_arsipku.Helper.PrefsClass.ID_SEK;
import static ahmedt.m_arsipku.Helper.PrefsClass.ID_SO;
import static ahmedt.m_arsipku.Helper.PrefsClass.INDEX;
import static ahmedt.m_arsipku.Helper.PrefsClass.JABATAN;
import static ahmedt.m_arsipku.Helper.PrefsClass.JABATAN_PH;
import static ahmedt.m_arsipku.Helper.PrefsClass.JABATAN_SEK;
import static ahmedt.m_arsipku.Helper.PrefsClass.KODE_JABATAN;
import static ahmedt.m_arsipku.Helper.PrefsClass.NAMA;
import static ahmedt.m_arsipku.Helper.PrefsClass.NAMA_CABANG;
import static ahmedt.m_arsipku.Helper.PrefsClass.PTS_PH;
import static ahmedt.m_arsipku.Helper.PrefsClass.USERNAME;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG ="LoginActivity";
    EditText user,pass;
    Button login;
    KProgressHUD hud;
    TextView w_u, w_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findView();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prefs.clear();
                String username, password;
                username = user.getText().toString();
                password = pass.getText().toString();
                w_p.setVisibility(View.GONE);
                w_u.setVisibility(View.GONE);

                if (user.getText().toString().matches( "") && pass.getText().toString().matches( "") ){
//                    user.setError("Username Tidak Boleh Kosong");
//                    pass.setError("Password Tidak Boleh Kosong");
//                    Toast.makeText(LoginActivity.this, "Username dan Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                    w_u.setText("Username Kosong!");
                    w_p.setText("Password Kosong!");
                    w_p.setVisibility(View.VISIBLE);
                    w_u.setVisibility(View.VISIBLE);
                }else if(user.getText().toString().matches( "")){
                    w_u.setText("Username Kosong!");
                    w_u.setVisibility(View.VISIBLE);
//                   user.setError("Username Tidak Boleh Kosong");
//                    Toast.makeText(LoginActivity.this, "Username tidak boleh kosong", Toast.LENGTH_LONG).show();
                } else if (pass.getText().toString().matches( "")){
                    w_p.setText("Password Kosong!");
                    w_p.setVisibility(View.VISIBLE);
//                    pass.setError("Password Tidak Boleh Kosong");
//                    Toast.makeText(LoginActivity.this, "Password tidak boleh kosong", Toast.LENGTH_LONG).show();
                }else {
                    LoginMasuk(username,password);
            }}
        });
    }

    private void LoginMasuk(String username, String password) {
        hud = new KProgressHUD(LoginActivity.this);
        Utils.showProgressBar(hud,null,null,false);
        AndroidNetworking.post(Server.login_URL)
                .addBodyParameter("username", username)
                .addBodyParameter("password", password)
                .build()
                .getAsOkHttpResponseAndObject(LoginModel.class, new OkHttpResponseAndParsedRequestListener<LoginModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, LoginModel response) {
                        if (okHttpResponse.isSuccessful()){
                            hud.dismiss();
                            if (response.getCode() == 200){
                                Prefs.putString(ID_SO, response.getData().getIdSo());
                                Prefs.putString(NAMA, response.getData().getNama());
                                Prefs.putString(EMAIL, response.getData().getEmail());
                                Prefs.putString(USERNAME, response.getData().getUsername());
                                Prefs.putString(KODE_JABATAN, response.getData().getKodeJabatan());
                                Prefs.putString(JABATAN, response.getData().getJabatan());
                                Prefs.putString(INDEX, response.getData().getIndex());
                                Prefs.putString(ID_CABANG, response.getData().getIdCabang());
                                Prefs.putString(NAMA_CABANG, response.getData().getNamaCabang());
                                Prefs.putString(GROUP_MENU, response.getData().getGroupmenu());
//                                Prefs.putString(FOTO, response.getData().getFoto());
                                String urlFoto = response.getData().getUsername();
                                if (urlFoto.length() <= 5){
                                    urlFoto = "100" + response.getData().getUsername();
                                }
                                Prefs.putString(FOTO, Server.imgURL+urlFoto+"/"+urlFoto+".jpg");
                                Prefs.putString(ID_SEK, response.getData().getIdSek());
                                Prefs.putString(ID_PH, response.getData().getIdPh());
                                Prefs.putString(PTS_PH, response.getData().getPtsPh());
                                Prefs.putString(JABATAN_SEK, response.getData().getJabatansek());
                                Prefs.putString(JABATAN_PH, response.getData().getJabatanph());
                                Prefs.putString(GROUP_MENU_SEK, response.getData().getGroupmenusek());
                                Prefs.putString(GROUP_MENU_PH, response.getData().getGroupmenuph());
                                Prefs.putString(GROUP_PARAM, response.getData().getGroupmenu());
                                Prefs.putString(ID_PARAM, response.getData().getIdSo());
                                Log.d(TAG, "onResponse: "+Prefs.getString(FOTO,""));

                                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(i);
                                finish();

                            }else {
                                w_u.setText("Username Salah!");
                                w_p.setText("Password Salah!");
                               w_p.setVisibility(View.VISIBLE);
                               w_u.setVisibility(View.VISIBLE);

                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        hud.dismiss();
                        Log.d(TAG, "onError: "+anError.getErrorDetail().toString());
                        Toast.makeText(LoginActivity.this, "Jaringan atau Server bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }



    private void findView(){
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
        w_p = findViewById(R.id.wrong_pass);
        w_u = findViewById(R.id.wrong_uid);

        user.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                w_p.setVisibility(View.GONE);
                w_u.setVisibility(View.GONE);
                return false;
            }
        });

        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                w_p.setVisibility(View.GONE);
                w_u.setVisibility(View.GONE);
                return false;
            }
        });
    }




}
