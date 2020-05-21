package ahmedt.m_arsipku.SuratDisposisiKeluar.CariSuratDisposisiKeluar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.OkHttpResponseAndParsedRequestListener;
import com.pixplicity.easyprefs.library.Prefs;

import java.util.ArrayList;

import ahmedt.m_arsipku.DetailDispo.DetailActivity;
import ahmedt.m_arsipku.Helper.PrefsClass;
import ahmedt.m_arsipku.Helper.Server;
import ahmedt.m_arsipku.R;
import ahmedt.m_arsipku.SuratDisposisiKeluar.DataItem;
import ahmedt.m_arsipku.SuratDisposisiKeluar.SuratDisposisiKeluarAdapter;
import ahmedt.m_arsipku.SuratDisposisiKeluar.SuratDisposisiKeluarModel;
import okhttp3.Response;


public class CariSuratDisposisiKeluarActivity extends AppCompatActivity{

    private RecyclerView recyclerView;


    private Toolbar toolbar;

    private SwipeRefreshLayout swipeRefreshRecyclerList;
    private SuratDisposisiKeluarAdapter mAdapter;
    private static final String TAG = "CariNotaDisposisiKeluarActivity";

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
    private String key_intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // ButterKnife.bind(this);
        findViews();
        initToolbar("");

        Intent intent = getIntent();
        key_intent = intent.getStringExtra("query");

        final String id_so = Prefs.getString(PrefsClass.ID_PARAM,"");
        setAdapter(id_so, key_intent);




        swipeRefreshRecyclerList.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do your stuff on refresh
                        if (swipeRefreshRecyclerList.isRefreshing())
                        {
                            refreshLayout(id_so, key_intent);
                        }
            }
        });

        btn_loadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                btn_loadMore.setVisibility(View.GONE);
                progressBar_footer.setVisibility(View.VISIBLE);
                loadMore(id_so, currentPage, key_intent);
            }
        });

        btn_reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_reload.setVisibility(View.GONE);
                setAdapter(id_so, key_intent);
            }
        });

    }

    private void refreshLayout(String id_so, String key) {
        AndroidNetworking.post(Server.getURL_SuratDisposisiKeluar)
                .addBodyParameter("id_so", id_so)
                .addBodyParameter("page", "1")
                .addBodyParameter("key", key)
                .setTag("getSuratDisposisiKeluar")
                .build()
                .getAsOkHttpResponseAndObject(SuratDisposisiKeluarModel.class, new OkHttpResponseAndParsedRequestListener<SuratDisposisiKeluarModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, SuratDisposisiKeluarModel response) {
                        if (okHttpResponse.isSuccessful()){
                            swipeRefreshRecyclerList.setRefreshing(false);
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
                                    items.setId(response.getData().get(i).getId());
                                    items.setIdBerkas(response.getData().get(i).getIdBerkas());
                                    items.setIdCabang(response.getData().get(i).getIdCabang());
                                    items.setDari(response.getData().get(i).getDari());
                                    items.setFileAttach(response.getData().get(i).getFileAttach());
                                    items.setPerihal(response.getData().get(i).getPerihal());
                                    items.setTglSurat(response.getData().get(i).getTglSurat());
                                    items.setTertuju(response.getData().get(i).getTertuju());
                                    items.setTglSent(response.getData().get(i).getTglSent());
                                    items.setFileDisposisi(response.getData().get(i).getFileDisposisi());
                                    items.setAsalSurat(response.getData().get(i).getAsalSurat());
                                    items.setNoAgenda(response.getData().get(i).getNoAgenda());
                                    items.setTerimaTgl(response.getData().get(i).getTerimaTgl());
                                    items.setNoRefSurat(response.getData().get(i).getNoRefSurat());
                                    items.setItemDispo(response.getData().get(i).getItemDispo());
                                    items.setAllTertuju(response.getData().get(i).getAllTertuju());
                                    items.setIsiDisposisi(response.getData().get(i).getIsiDisposisi());
                                    items.setKlasifikasi(response.getData().get(i).getKlasifikasi());
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
                                if (modelList.isEmpty()){
                                    imgError.setImageResource(R.drawable.no_mail);
                                    txtError.setText("Tidak Ada Data");
                                    imgError.setVisibility(View.VISIBLE);
                                    txtError.setVisibility(View.VISIBLE);
                                    btn_reload.setVisibility(View.VISIBLE);
                                    txtOps.setVisibility(View.VISIBLE);
                                }else {
                                    Toast.makeText(CariSuratDisposisiKeluarActivity.this, "Tidak bisa memuat data", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        progressBar.setVisibility(View.GONE);
                        swipeRefreshRecyclerList.setRefreshing(false);
                        if (modelList.isEmpty()){
                            imgError.setImageResource(R.drawable.meteorology);
                            txtError.setText("Jaringan atau Server Bermasalah");
                            imgError.setVisibility(View.VISIBLE);
                            txtError.setVisibility(View.VISIBLE);
                            btn_reload.setVisibility(View.VISIBLE);
                            txtOps.setVisibility(View.VISIBLE);
                        }else {
                            Toast.makeText(CariSuratDisposisiKeluarActivity.this, "Tidak bisa memuat data", Toast.LENGTH_SHORT).show();

                        }
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
        mAdapter = new SuratDisposisiKeluarAdapter(CariSuratDisposisiKeluarActivity.this, modelList);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        mAdapter.SetOnItemClickListener(new SuratDisposisiKeluarAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, DataItem model) {
                //handle item click events here
                Intent i = new Intent(CariSuratDisposisiKeluarActivity.this, DetailActivity.class);
                i.putExtra("id_dispo", model.getId());
                i.putExtra("dispo", "keluar");
                startActivity(i);
            }
        });
    }

    public void initToolbar(String title) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(title);
    }


    private void setAdapter(String id_so, String key) {
        progressBar.setVisibility(View.VISIBLE);
        swipeRefreshRecyclerList.setVisibility(View.GONE);
        AndroidNetworking.post(Server.getURL_SuratDisposisiKeluar)
                .addBodyParameter("id_so", id_so)
                .addBodyParameter("page", "1")
                .addBodyParameter("key", key)
                .setTag("getSuratDisposisiKeluar")
                .build()
                .getAsOkHttpResponseAndObject(SuratDisposisiKeluarModel.class, new OkHttpResponseAndParsedRequestListener<SuratDisposisiKeluarModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, SuratDisposisiKeluarModel response) {
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
                                    items.setId(response.getData().get(i).getId());
                                    items.setIdBerkas(response.getData().get(i).getIdBerkas());
                                    items.setIdCabang(response.getData().get(i).getIdCabang());
                                    items.setDari(response.getData().get(i).getDari());
                                    items.setFileAttach(response.getData().get(i).getFileAttach());
                                    items.setPerihal(response.getData().get(i).getPerihal());
                                    items.setTglSurat(response.getData().get(i).getTglSurat());
                                    items.setTertuju(response.getData().get(i).getTertuju());
                                    items.setTglSent(response.getData().get(i).getTglSent());
                                    items.setFileDisposisi(response.getData().get(i).getFileDisposisi());
                                    items.setAsalSurat(response.getData().get(i).getAsalSurat());
                                    items.setNoAgenda(response.getData().get(i).getNoAgenda());
                                    items.setTerimaTgl(response.getData().get(i).getTerimaTgl());
                                    items.setNoRefSurat(response.getData().get(i).getNoRefSurat());
                                    items.setItemDispo(response.getData().get(i).getItemDispo());
                                    items.setAllTertuju(response.getData().get(i).getAllTertuju());
                                    items.setIsiDisposisi(response.getData().get(i).getIsiDisposisi());
                                    items.setKlasifikasi(response.getData().get(i).getKlasifikasi());
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

    private void loadMore(String id_so, int page, String key){
        AndroidNetworking.post(Server.getURL_SuratDisposisiKeluar)
                .addBodyParameter("id_so", id_so)
                .addBodyParameter("page", String.valueOf(page))
                .addBodyParameter("key", key)
                .setTag("getSuratDisposisiKeluar_load")
                .build()
                .getAsOkHttpResponseAndObject(SuratDisposisiKeluarModel.class, new OkHttpResponseAndParsedRequestListener<SuratDisposisiKeluarModel>() {
                    @Override
                    public void onResponse(Response okHttpResponse, SuratDisposisiKeluarModel response) {
                        if (okHttpResponse.isSuccessful()){
                            progressBar_footer.setVisibility(View.GONE);
                            if (response.getCode()==200){
                                for (int i = 0; i<response.getData().size(); i++) {
                                    final DataItem items = new DataItem();
                                    items.setId(response.getData().get(i).getId());
                                    items.setIdBerkas(response.getData().get(i).getIdBerkas());
                                    items.setIdCabang(response.getData().get(i).getIdCabang());
                                    items.setDari(response.getData().get(i).getDari());
                                    items.setFileAttach(response.getData().get(i).getFileAttach());
                                    items.setPerihal(response.getData().get(i).getPerihal());
                                    items.setTglSurat(response.getData().get(i).getTglSurat());
                                    items.setTertuju(response.getData().get(i).getTertuju());
                                    items.setTglSent(response.getData().get(i).getTglSent());
                                    items.setFileDisposisi(response.getData().get(i).getFileDisposisi());
                                    items.setAsalSurat(response.getData().get(i).getAsalSurat());
                                    items.setNoAgenda(response.getData().get(i).getNoAgenda());
                                    items.setTerimaTgl(response.getData().get(i).getTerimaTgl());
                                    items.setNoRefSurat(response.getData().get(i).getNoRefSurat());
                                    items.setItemDispo(response.getData().get(i).getItemDispo());
                                    items.setAllTertuju(response.getData().get(i).getAllTertuju());
                                    items.setIsiDisposisi(response.getData().get(i).getIsiDisposisi());
                                    items.setKlasifikasi(response.getData().get(i).getKlasifikasi());
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
                        Toast.makeText(CariSuratDisposisiKeluarActivity.this, "Jaringan atau Server Bermasalah", Toast.LENGTH_SHORT).show();
                    }
                });
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

}
