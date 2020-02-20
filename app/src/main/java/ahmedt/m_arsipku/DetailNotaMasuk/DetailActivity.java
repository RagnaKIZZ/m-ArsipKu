package ahmedt.m_arsipku.DetailNotaMasuk;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.pixplicity.htmlcompat.HtmlCompat;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel.DetailNotaMasukModel;
import ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel.TembusanItem;
import ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel.TertujuItem;
import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.R;
import ahmedt.m_arsipku.SuratMasuk.DataItem;
import okhttp3.Response;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    public static String FILE_NOTA = "file_nota";
    private static final int REQUEST_PERMISSION_CODE = 1000;
    String param_act,txt_isi_1,txt_isi_2,txt_isi_3,txt_isi_4,txt_isi_5,txt_isi_6,txt_isi_7,lampiran, id_nota, nota_param;
    private TextView  txtD1, txtD2, txtD3, txtD4, txtD5, txtD6, txtD7, txtD8;
    private TextView txtI1, txtI2, txtI3, txtI4, txtI5, txtI6,  txtI7, txtI8;
    private RecyclerView rv, rv2, rv3;
    private Toolbar toolbar;
    private DetailAdapter mAdapter;
    private DetailTertujuAdapter mAdapter_2;
    private DetailTembusanAdapter mAdapter_3;
    private DetailTertujuTAdapter mAdapter_a;
    private DetailTembusanTAdapter mAdapter_b;
    private ArrayList<DetailModel> modelLampiran = new ArrayList<>();
    private ArrayList<TertujuItem> modelTertuju = new ArrayList<>();
    private ArrayList<TembusanItem> modelTembusan = new ArrayList<>();
    private LinearLayout linearLayout;
    private ProgressBar progressBar;
    private Button      btn_reload, btn_download;
    private ImageView   imgError;
    private TextView    txtError;
    private TextView    txtOps;
    private RelativeLayout layoutError;

    private DownloadManager manager;
    private String filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_nota_masuk);
        Intent intent = getIntent();
        id_nota = intent.getStringExtra("id_nota");
        nota_param = intent.getStringExtra("nota");
        findview();
        initToolbar();
        initTertuju();
        initTembusan();
        getData(id_nota);


    }

    private void findview(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        txtD1 = (TextView) findViewById(R.id.txt_detil_1);
        txtD2 = (TextView) findViewById(R.id.txt_detil_2);
        txtD3 = (TextView) findViewById(R.id.txt_detil_3);
        txtD4 = (TextView) findViewById(R.id.txt_detil_4);
        txtD5 = (TextView) findViewById(R.id.txt_detil_5);
        txtD6 = (TextView) findViewById(R.id.txt_detil_6);
        txtD7 = (TextView) findViewById(R.id.txt_detil_7);
        txtD8 = (TextView) findViewById(R.id.txt_detil_8);
        txtI1 = (TextView) findViewById(R.id.txt_isi_1);
        txtI2 = (TextView) findViewById(R.id.txt_isi_2);
        txtI3 = (TextView) findViewById(R.id.txt_isi_3);
        txtI4 = (TextView) findViewById(R.id.txt_isi_4);
        txtI5 = (TextView) findViewById(R.id.txt_isi_5);
        txtI6 = (TextView) findViewById(R.id.txt_isi_6);
        txtI7 = (TextView) findViewById(R.id.txt_isi_7);
        txtI8 = (TextView) findViewById(R.id.txt_isi_8);
        imgError = (ImageView) findViewById(R.id.img_eror1);
        txtOps   = (TextView) findViewById(R.id.txt_error_parent);
        txtError = (TextView) findViewById(R.id.txt_error1);
        btn_reload = (Button) findViewById(R.id.btn_reload);
        layoutError = (RelativeLayout) findViewById(R.id.layout_message);
        rv    = (RecyclerView) findViewById(R.id.rv_lampiran);
        rv2   = (RecyclerView) findViewById(R.id.rv_tertuju);
        rv3   = (RecyclerView) findViewById(R.id.rv_tembusan);
        progressBar = (ProgressBar) findViewById(R.id.progbar1);
        linearLayout = (LinearLayout) findViewById(R.id.linear_lay);
        btn_download = (Button) findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadData(FILE_NOTA);
            }
        });
        if (rv.getVisibility() == View.VISIBLE){
            mAdapter = new DetailAdapter(DetailActivity.this, modelLampiran);
            rv.setHasFixedSize(true);
            // use a linear layout manager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(mAdapter);
        }
        btn_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_reload.setVisibility(View.GONE);
                getData(id_nota);
            }
        });
    }

    private void initTertuju(){
        if (nota_param.equals("masuk")){
            mAdapter_2 = new DetailTertujuAdapter(DetailActivity.this, modelTertuju);
            rv2.setAdapter(mAdapter_2);
        }else{
            mAdapter_a = new DetailTertujuTAdapter(DetailActivity.this, modelTertuju);
            rv2.setAdapter(mAdapter_a);
        }
        rv2.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv2.setLayoutManager(layoutManager);
        rv2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void initTembusan(){
        if (nota_param.equals("masuk")){
            mAdapter_3 = new DetailTembusanAdapter(DetailActivity.this, modelTembusan);
            rv3.setAdapter(mAdapter_3);
        }else {
            mAdapter_b = new DetailTembusanTAdapter(DetailActivity.this, modelTembusan);
            rv3.setAdapter(mAdapter_b);
        }
        rv3.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv3.setLayoutManager(layoutManager);
        rv3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private void getData(String id){
        progressBar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.GONE);
        AndroidNetworking.post(Server.getURL_DetailNotaMasuk)
                .addBodyParameter("id_nota", id)
                .setTag("detail_nota_masuk")
                .build()
                .getAsOkHttpResponseAndObject(DetailNotaMasukModel.class, new OkHttpResponseAndParsedRequestListener<DetailNotaMasukModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, DetailNotaMasukModel response) {
                        if (okHttpResponse.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            imgError.setVisibility(View.GONE);
                            txtError.setVisibility(View.GONE);
                            btn_reload.setVisibility(View.GONE);
                            txtOps.setVisibility(View.GONE);
                            layoutError.setVisibility(View.GONE);
                            if (response.getCode()==200){
                                linearLayout.setVisibility(View.VISIBLE);
                                for (int i = 0; i < response.getTertuju().size(); i++) {
                                    final TertujuItem tertujuItem = new TertujuItem();
                                    tertujuItem.setNamaJabatan(response.getTertuju().get(i).getNamaJabatan());
                                    tertujuItem.setStatus(response.getTertuju().get(i).getStatus());
                                    modelTertuju.add(tertujuItem);
                                }
                                if (nota_param.equals("masuk")){
                                    mAdapter_2.updateList(modelTertuju);
                                }else{
                                    mAdapter_a.updateList(modelTertuju);
                                }
                                for (int i = 0; i < response.getTembusan().size(); i++) {
                                    final TembusanItem tembusanItem = new TembusanItem();
                                    tembusanItem.setNamaJabatan(response.getTembusan().get(i).getNamaJabatan());
                                    tembusanItem.setStatus(response.getTembusan().get(i).getStatus());
                                    modelTembusan.add(tembusanItem);
                                }
                                if (nota_param.equals("masuk")){
                                    mAdapter_3.updateList(modelTembusan);
                                }else{
                                    mAdapter_b.updateList(modelTembusan);
                                }
                                txt_isi_1 = response.getData().getTglSurat();
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                try{
                                    Date date = format.parse(txt_isi_1);
                                    SimpleDateFormat format1 = new SimpleDateFormat("dd-MMMM-yyyy");
                                    String realTime = format1.format(date);
                                    txtI1.setText(realTime);
                                }catch(Exception e){
                                    Log.d(TAG, "onBindViewHolder: "+e.getMessage());
                                }
                                txtI2.setText(response.getData().getNoSurat());
                                txtI3.setText(response.getData().getNamaJabatan());
                                txtI6.setText(response.getData().getPerihal());
                                if (!response.getData().getBerita().isEmpty()){
                                    txt_isi_7 = response.getData().getBerita();
                                    Spanned fromHtml = HtmlCompat.fromHtml(DetailActivity.this, txt_isi_7, 0);
                                    txtI7.setMovementMethod(LinkMovementMethod.getInstance());
                                    txtI7.setText(fromHtml);
                                }else{
                                    txtI7.setText("Tidak Ada");
                                }
                                lampiran = response.getData().getFileAttach();
                                if (lampiran.isEmpty()){
                                    txtI8.setVisibility(View.VISIBLE);
                                    lampiran = "Tidak Ada";
                                    txtI8.setText(lampiran);
                                    rv.setVisibility(View.GONE);
                                }
                                if (!lampiran.isEmpty() && !lampiran.contains("|")){
                                    rv.setVisibility(View.VISIBLE);
                                    txtI8.setVisibility(View.GONE);
                                    DetailModel model = new DetailModel();
                                    model.setLampiran(lampiran);
                                    modelLampiran.add(model);
                                }else{
                                    txtI8.setVisibility(View.GONE);
                                    rv.setVisibility(View.VISIBLE);
                                    String[] aryLampiran = lampiran.split("\\|");
                                    for(String data : aryLampiran){
                                        DetailModel model = new DetailModel();
                                        model.setLampiran(data);
                                        modelLampiran.add(model);
                                    }
                                }
                                mAdapter.SetOnItemClickListener(new DetailAdapter.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(View view, int position, DetailModel model) {
                                        //handle item click events here
                                        downloadData(model.getLampiran());
                                    }
                                });
                                FILE_NOTA = response.getData().getFileNotadinas();
                            }else{
                                layoutError.setVisibility(View.VISIBLE);
                                imgError.setVisibility(View.VISIBLE);
                                txtError.setVisibility(View.VISIBLE);
                                btn_reload.setVisibility(View.VISIBLE);
                                txtOps.setVisibility(View.VISIBLE);
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        progressBar.setVisibility(View.GONE);
                        layoutError.setVisibility(View.VISIBLE);
                        imgError.setVisibility(View.VISIBLE);
                        txtError.setVisibility(View.VISIBLE);
                        btn_reload.setVisibility(View.VISIBLE);
                        txtOps.setVisibility(View.VISIBLE);
                    }
                });
    }

    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Detail Nota Dinas");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void downloadData(String lamp){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            //diatas marshmellow kudu ada ijin
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                    PackageManager.PERMISSION_DENIED){
                //kalo ga di ijinin
                String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                //show pop up dialog
                requestPermissions(permission, REQUEST_PERMISSION_CODE);
            }else{
                    startDownloading(lamp);
            }
        }else{
            //dibawah marshmellow langsung download
            startDownloading(lamp);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    private void startDownloading(String lam) {
        String url = Server.download_path+lam;

        filename = url.substring(url.lastIndexOf("/")+1);
        Log.d(TAG, "startDownloading: "+url);

        //download request
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        //allow type of network to download
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE|DownloadManager.Request.NETWORK_WIFI);
        request.setTitle(filename);
        request.setDescription("Mengunduh File...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+filename);
        manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    //handle permission result

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    if (lampiran.contains("|")){
                        DetailModel model = new DetailModel();
                        startDownloading(model.getLampiran());
                    }else
                    {
                        startDownloading(lampiran);
                    }
                }else{
                    Toast.makeText(this, "Permission Denied..!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
