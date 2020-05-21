package ahmedt.m_arsipku.Detail;

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
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.R;
import ahmedt.m_arsipku.SuratMasuk.DataItem;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private static final int REQUEST_PERMISSION_CODE = 1000;
    String param_act,txt_isi_1,txt_isi_2,txt_isi_3,txt_isi_4,txt_isi_5,txt_isi_6,lampiran;
    private TextView  txtD1, txtD2, txtD3, txtD4, txtD5, txtD6, txtD7;
    private TextView txtI1, txtI2, txtI3, txtI4, txtI5,  txtI7, txtI8;
    private RecyclerView rv;
    private Toolbar toolbar;
    private DetailAdapter mAdapter;
    private ArrayList<DetailModel> modelLampiran = new ArrayList<>();

    private long enq;
    private DownloadManager manager;
    private String uri, filename;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        findview();
        initToolbar();
        paramAuth();


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
        txtI1 = (TextView) findViewById(R.id.txt_isi_1);
        txtI2 = (TextView) findViewById(R.id.txt_isi_2);
        txtI3 = (TextView) findViewById(R.id.txt_isi_3);
        txtI4 = (TextView) findViewById(R.id.txt_isi_4);
        txtI5 = (TextView) findViewById(R.id.txt_isi_5);
        txtI7 = (TextView) findViewById(R.id.txt_isi_7);
        txtI8 = (TextView) findViewById(R.id.txt_isi_8);
//        cv2   = (CardView) findViewById(R.id.cv_detil_2);
//        cv3   = (CardView) findViewById(R.id.cv_detil_3);
//        cv4   = (CardView) findViewById(R.id.cv_detil_4);
//        cv5   = (CardView) findViewById(R.id.cv_detil_5);
//        cv6   = (CardView) findViewById(R.id.cv_detil_6);
//        cv7   = (CardView) findViewById(R.id.cv_detil_7);
        rv    = (RecyclerView) findViewById(R.id.rv_lampiran);
        if (rv.getVisibility() == View.VISIBLE){
            mAdapter = new DetailAdapter(DetailActivity.this, modelLampiran);

            rv.setHasFixedSize(true);
            // use a linear layout manager
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rv.setLayoutManager(layoutManager);
            rv.setAdapter(mAdapter);
            mAdapter.SetOnItemClickListener(new DetailAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position, DetailModel model) {
                    //handle item click events here
                    downloadData(model.getLampiran());
                }
            });
        }
    }

    private void paramAuth(){
        Intent intent = getIntent();
        param_act = intent.getStringExtra("param");
        Log.d(TAG, "onCreate: "+param_act);
        if (param_act.equals("surat_masuk")){
            DataItem dataItem   = intent.getParcelableExtra("data_item");
            txt_isi_1   = dataItem.getAsalNaskah();
            txt_isi_2   = dataItem.getNoAsalNaskah();
            txt_isi_3   = dataItem.getTglNaskah();
            txt_isi_4   = dataItem.getPerihal();
            txt_isi_5   = dataItem.getSifatSurat();
            if (txt_isi_6.isEmpty()){
                txt_isi_6 = "Tidak Ada";
            }


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
            txtD1.setText("Asal Surat");
            txtI1.setText(txt_isi_1);
            txtD2.setText("No Ref Surat");
            txtI2.setText(txt_isi_2);
            txtD3.setText("Tanggal Surat");
            txtD4.setText("Perihal");
            txtI4.setText(txt_isi_4);
            txtD5.setText("Sifat");
            txtI5.setText(txt_isi_5);
            txtD6.setText("File Terlampir");
            txtD7.setText("Berkasan");
            txtI7.setText(txt_isi_6);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            try{
                Date date = format.parse(txt_isi_3);
                SimpleDateFormat format1 = new SimpleDateFormat("dd-MMMM-yyyy");
                String realTime = format1.format(date);
                txtI3.setText(realTime);
            }catch(Exception e){
                Log.d(TAG, "onBindViewHolder: "+e.getMessage());
            }
        }
//        else if(param_act.equals("surat_terkirim")){
//            ahmedt.m_arsipku.SuratTerkirim.DataItem dataItem  = intent.getParcelableExtra("data_item");
//            txt_isi_1   = dataItem.getNoSurat();
//            txt_isi_2       = dataItem.getJabatanTertuju();
//            txt_isi_3    = dataItem.getTglSurat();
//            txt_isi_4      = dataItem.getPerihal();
//            txt_isi_5        = dataItem.getSifatSurat();
//            txt_isi_6       = dataItem.getBerita();
//            lampiran     = dataItem.getFileAttach();
//            String attc  = dataItem.getFileSuratDinas();
//
//            if (txt_isi_1==null){
//                txt_isi_1 = "Menunggu Nomor Surat";
//            }
//            if (txt_isi_2.isEmpty()){
//                txt_isi_2 = "Tidak Ada";
//            }
//            if (txt_isi_4.isEmpty()){
//                txt_isi_4 = "Tidak Ada";
//            }
//            if (txt_isi_5.isEmpty()){
//                txt_isi_5 = "Tidak Ada";
//            }
//            if (txt_isi_6.isEmpty()){
//                txt_isi_6 = "Tidak Ada";
//            }
//            if (lampiran.isEmpty() && attc.isEmpty()){
//                txtI8.setVisibility(View.VISIBLE);
//                lampiran = "Tidak Ada";
//                txtI8.setText(lampiran);
//                rv.setVisibility(View.GONE);
//            }
//            if (!lampiran.isEmpty() && !attc.isEmpty()){
//                String fileAttc = lampiran+"|"+attc;
//                txtI8.setVisibility(View.GONE);
//                rv.setVisibility(View.VISIBLE);
//                String[] aryLampiran = fileAttc.split("\\|");
//                for(String data : aryLampiran){
//                    DetailModel model = new DetailModel();
//                    model.setLampiran(data);
//                    modelLampiran.add(model);
//                }
//            }else if (lampiran.isEmpty() && !attc.isEmpty() && attc.contains("|")){
//                txtI8.setVisibility(View.GONE);
//                String[] aryLampiran = attc.split("\\|");
//                for(String data : aryLampiran){
//                    DetailModel model = new DetailModel();
//                    model.setLampiran(data);
//                    modelLampiran.add(model);
//                }
//            }else if (lampiran.isEmpty() && !attc.isEmpty() && !attc.contains("|")){
//                txtI8.setVisibility(View.GONE);
//                DetailModel model = new DetailModel();
//                model.setLampiran(attc);
//                modelLampiran.add(model);
//            }else if (attc.isEmpty() && !lampiran.isEmpty() && lampiran.contains("|")){
//                txtI8.setVisibility(View.GONE);
//                String[] aryLampiran = lampiran.split("\\|");
//                for(String data : aryLampiran){
//                    DetailModel model = new DetailModel();
//                    model.setLampiran(data);
//                    modelLampiran.add(model);
//            }
//            }else if (attc.isEmpty()&& !lampiran.isEmpty() && !lampiran.contains("|")){
//                txtI8.setVisibility(View.GONE);
//                DetailModel model = new DetailModel();
//                model.setLampiran(lampiran);
//                modelLampiran.add(model);
//            }
//            txtD1.setText("Nomor Surat");
//            txtI1.setText(txt_isi_1);
//            txtD2.setText("Tujuan");
//            txtI2.setText(txt_isi_2);
//            txtD3.setText("Tanggal Surat");
//            txtD4.setText("Perihal");
//            txtI4.setText(txt_isi_4);
//            txtD5.setText("Sifat");
//            txtI5.setText(txt_isi_5);
//            txtD6.setText("File Terlampir & Surat Dinas Keluar");
//            txtD7.setText("Berita");
//            if (!txt_isi_6.isEmpty()){
//                Spanned fromHtml = HtmlCompat.fromHtml(DetailActivity.this, txt_isi_6, 0);
//                txtI7.setMovementMethod(LinkMovementMethod.getInstance());
//                txtI7.setText(fromHtml);
//            }
//
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//            try{
//                Date date = format.parse(txt_isi_3);
//                SimpleDateFormat format1 = new SimpleDateFormat("dd-MMMM-yyyy");
//                String realTime = format1.format(date);
//                txtI3.setText(realTime);
//            }catch(Exception e){
//                Log.d(TAG, "onBindViewHolder: "+e.getMessage());
//            }
//        }

        Log.d(TAG, "onCreate: "+txt_isi_4);
    }

    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
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
        enq = manager.enqueue(request);
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
