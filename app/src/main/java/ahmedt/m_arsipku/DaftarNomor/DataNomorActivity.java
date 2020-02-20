package ahmedt.m_arsipku.DaftarNomor;

import android.Manifest;
import android.app.Dialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;

import ahmedt.m_arsipku.DaftarNomor.CariDataNomor.CariDataNomorActivity;
import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.Helper.Utils;
import ahmedt.m_arsipku.R;
import okhttp3.Response;


public class DataNomorActivity extends AppCompatActivity{

    private RecyclerView recyclerView;


    private Toolbar toolbar;
    private static final int REQUEST_PERMISSION_CODE = 1000;
    private SwipeRefreshLayout swipeRefreshRecyclerList;
    private DataNomorAdapter mAdapter;
    private static final String TAG = "CariDataNomorActivity";

    private MenuItem item;
    private SearchView searchView;
    private ProgressBar progressBar, progressBar_footer;
    private TextView    txtError;
    private TextView    txtOps;
    private Button btn_loadMore, btn_reload;
    private ImageView imgError;
    private int currentPage=1;
    private int TotalCount;

    private ArrayList<DataItem> modelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // ButterKnife.bind(this);
        findViews();
        initToolbar("Data Nomor");
        final String id_so = Prefs.getString(PrefsClass.ID_PARAM,"");

        setAdapter(id_so);




        swipeRefreshRecyclerList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do your stuff on refresh
                        if (swipeRefreshRecyclerList.isRefreshing())
                            btn_reload.setVisibility(View.GONE);
                            setAdapter(id_so);
                            swipeRefreshRecyclerList.setRefreshing(false);
            }
        });

        btn_loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                btn_loadMore.setVisibility(View.GONE);
                progressBar_footer.setVisibility(View.VISIBLE);
                loadMore(id_so,currentPage);
            }
        });

        btn_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_reload.setVisibility(View.GONE);
                setAdapter(id_so);
            }
        });

    }

    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        swipeRefreshRecyclerList = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_recycler_list);
        imgError = (ImageView) findViewById(R.id.img_eror1);
        txtError = (TextView) findViewById(R.id.txt_error1);
        progressBar = (ProgressBar) findViewById(R.id.progbar1);
        progressBar_footer = (ProgressBar) findViewById(R.id.progress_footer);
        btn_loadMore = (Button) findViewById(R.id.btn_load_more1);
        btn_reload = (Button) findViewById(R.id.btn_reload);
        txtOps      = (TextView) findViewById(R.id.txt_error_parent);
        mAdapter = new DataNomorAdapter(DataNomorActivity.this, modelList);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new DataNomorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, final int position, DataItem model) {
                //handle item click events here
//                Intent i = new Intent(DataNomorActivity.this, DetailActivity.class);
//                i.putExtra("param", "surat_disposisi_masuk");
//                i.putExtra("data_item", modelList.get(position));
//                startActivity(i);
//                final Dialog dialog = new Dialog(DataNomorActivity.this);
//                dialog.setContentView(R.layout.layout_detail_nomor);
//                dialog.setTitle("Detail Nomor");
//
//                TextView txt1, txt2, txt3, txt4;
//                Button btn_dwnld;
//
//                txt1 = (TextView) dialog.findViewById(R.id.txt_isi_1);
//                txt2 = (TextView) dialog.findViewById(R.id.txt_isi_2);
//                txt3 = (TextView) dialog.findViewById(R.id.txt_isi_3);
//                txt4 = (TextView) dialog.findViewById(R.id.txt_isi_4);
//                btn_dwnld = (Button) dialog.findViewById(R.id.btn_download_file_nomor);
//
//                txt1.setText(modelList.get(position).getNoSurat());
//
//                if (!modelList.get(position).getFileAttach().isEmpty()){
//                    txt2.setText(modelList.get(position).getFileAttach());
//                    btn_dwnld.setVisibility(View.VISIBLE);
//                }
//
//                if (modelList.get(position).getSttsDistribusi()!=null){
//                    if (modelList.get(position).getSttsDistribusi().equals("1")){
//                        txt3.setText("Distribusikan");
//                    }else if (modelList.get(position).getSttsDistribusi().equals("0")){
//                        txt3.setText("Tidak di Distribusikan");
//                    }
//                }else {
//                    txt3.setText("");
//                }
//
//                if (!modelList.get(position).getTertuju().isEmpty()){
//                    txt4.setText(modelList.get(position).getTertuju());
//                }
//
//                btn_dwnld.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        downloadData(modelList.get(position).getFileAttach());
//                    }
//                });
//                dialog.setCancelable(true);
//               dialog.show();
            }
        });
    }

    public void initToolbar(String title) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
    }


    private void setAdapter(String id) {
        progressBar.setVisibility(View.VISIBLE);
        swipeRefreshRecyclerList.setVisibility(View.GONE);
        AndroidNetworking.post(Server.getURL_DataNomor)
                .addBodyParameter("id_so", id)
                .addBodyParameter("page", "1")
                .setTag("getDataNomor")
                .build()
                .getAsOkHttpResponseAndObject(DataNomorModel.class, new OkHttpResponseAndParsedRequestListener<DataNomorModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, DataNomorModel response) {
                        if (okHttpResponse.isSuccessful()){
                            progressBar.setVisibility(View.GONE);
                            imgError.setVisibility(View.GONE);
                            txtError.setVisibility(View.GONE);
                            btn_reload.setVisibility(View.GONE);
                            txtOps.setVisibility(View.GONE);
                            if (response.getCode()==200){
                                swipeRefreshRecyclerList.setVisibility(View.VISIBLE);
                                modelList.clear();
                                currentPage=1;
                                for (int i = 0; i < response.getData().size(); i++) {
                                    final DataItem items = new DataItem();
                                    items.setFileAttach(response.getData().get(i).getFileAttach());
                                    items.setTertuju(response.getData().get(i).getTertuju());
                                    items.setNoSurat(response.getData().get(i).getNoSurat());
                                    items.setIdListnomor(response.getData().get(i).getIdListnomor());
                                    items.setIdSo(response.getData().get(i).getIdSo());
                                    items.setSttsDistribusi(response.getData().get(i).getSttsDistribusi());
                                    items.setSttspakai(response.getData().get(i).getSttspakai());
                                    items.setTglbermohon(response.getData().get(i).getTglbermohon());
                                    items.setTgldigunakan(response.getData().get(i).getTgldigunakan());
                                    modelList.add(items);
                                }
                                TotalCount = response.getItemCount();
                                mAdapter.updateList(modelList);
                                if (modelList.size()!=TotalCount){
                                    btn_loadMore.setVisibility(View.VISIBLE);
                                }else {
                                    btn_loadMore.setVisibility(View.GONE);
                                }
                            }else{
                                imgError.setImageResource(R.drawable.no_mail);
                                txtError.setText("Tidak Ada Data");
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

                        imgError.setImageResource(R.drawable.meteorology);
                        txtError.setText("Jaringan atau Server Bermasalah");
                        imgError.setVisibility(View.VISIBLE);
                        txtError.setVisibility(View.VISIBLE);
                        btn_reload.setVisibility(View.VISIBLE);
                        txtOps.setVisibility(View.VISIBLE);
                    }
                });
    }

    private void loadMore(String id,int page){
        AndroidNetworking.post(Server.getURL_DataNomor)
                .addBodyParameter("id_so", id)
                .addBodyParameter("page", String.valueOf(page))
                .setTag("getDataNomor_load")
                .build()
                .getAsOkHttpResponseAndObject(DataNomorModel.class, new OkHttpResponseAndParsedRequestListener<DataNomorModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, DataNomorModel response) {
                        if (okHttpResponse.isSuccessful()){
                            progressBar_footer.setVisibility(View.GONE);
                            if (response.getCode()==200){
                                for (int i = 0; i<response.getData().size(); i++) {
                                    final DataItem items = new DataItem();
                                    items.setFileAttach(response.getData().get(i).getFileAttach());
                                    items.setTertuju(response.getData().get(i).getTertuju());
                                    items.setNoSurat(response.getData().get(i).getNoSurat());
                                    items.setIdListnomor(response.getData().get(i).getIdListnomor());
                                    items.setIdSo(response.getData().get(i).getIdSo());
                                    items.setSttsDistribusi(response.getData().get(i).getSttsDistribusi());
                                    items.setSttspakai(response.getData().get(i).getSttspakai());
                                    items.setTglbermohon(response.getData().get(i).getTglbermohon());
                                    items.setTgldigunakan(response.getData().get(i).getTgldigunakan());
                                    modelList.add(items);
                                }
                                }
                                TotalCount = response.getItemCount();
                                mAdapter.updateList(modelList);
                                if (modelList.size()!=TotalCount){
                                    btn_loadMore.setVisibility(View.VISIBLE);
                                }else {
                                    btn_loadMore.setVisibility(View.GONE);
                                }

                            }

                        }

                    @Override
                    public void onError(ANError anError) {
                        progressBar_footer.setVisibility(View.GONE);
                        if (currentPage>1){
                            currentPage = currentPage -1;
                        }
                        btn_loadMore.setVisibility(View.VISIBLE);
                        Toast.makeText(DataNomorActivity.this, "Jaringan atau Server Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_search, menu);
        item = menu.findItem(R.id.action_search);
        searchView = (SearchView) item.getActionView();
//        searchView.setQueryHint("Cari");
        searchView.setIconified(false);
        final EditText searchEdit = ((EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text));
        searchEdit.setTextColor(Color.WHITE);
        searchEdit.setHintTextColor(Color.GRAY);
        searchEdit.setBackgroundColor(Color.TRANSPARENT);
        searchEdit.setHint("Cari");
        searchView.setQuery("", false);
        searchView.setMaxWidth( Integer.MAX_VALUE );
        searchView.onActionViewCollapsed();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (s.length() > 0) {
                Intent i = new Intent(DataNomorActivity.this, CariDataNomorActivity.class);
                i.putExtra("query", searchEdit.getText().toString());
                startActivity(i);
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        //set event in close search button

        return true;
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

    private void startDownloading(String lam) {
        String url = Server.download_path+lam;

        String filename = url.substring(url.lastIndexOf("/")+1);
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
        DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case REQUEST_PERMISSION_CODE:{
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else{
                    Toast.makeText(this, "Permission Denied..!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
