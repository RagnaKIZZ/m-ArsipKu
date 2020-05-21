package ahmedt.m_arsipku.Helper;

public class Server {

    private static String URL="http://arsipku.airnavindonesia.co.id/smileApiNew/public";

    public static final String getURL_BadgeIndicator = URL+"/getAllCount";
    public static String login_URL=URL+"/user/login";
    public static final String getURL_SuratMasuk=URL+"/getSuratDinas";
    public static final String getURL_SuratTerkirim=URL+"/getSuratDinasTerkirim";
    public static final String getURL_NotaMasuk = URL+"/getNotaDinas";
    public static final String getURL_DetailNotaMasuk = URL+"/getNotaDinas/DetailNota";
    public static final String getURL_DetailSuratTerkirim = URL+"/getsuradinasDetail";
    public static final String getURL_DetailDispo = URL+"/getDetailDispo";
    public static final String getURL_NotaTerkirim = URL+"/getNotaDinasTerkirim";
    public static final String getURL_SuratDisposisiMasuk = URL + "/getSuratDisposisiMasuk";
    public static final String getURL_SuratDisposisiKeluar = URL + "/getSuratDisposisiKeluar";
    public static final String getURL_NotaDisposisiKeluar = URL + "/getNotaDisposisiKeluar";
    public static final String getURL_NotaDisposisiMasuk = URL + "/getNotaDisposisiMasuk";
    public static final String getURL_DataNomor = URL + "/getDataNomor";
    public static final String getURL_MemoTerkirim = URL + "/getMemoTerkirim";
    public static final String  getURL_MemoMasuk    = URL + "/getMemoMasuk";
    public static final String download_path="http://arsipku.airnavindonesia.co.id/lampiran/";
//    public static String getUserData_URL=URL+"/get_detail_data";

    public static final String imgURL = "https://e-chain.airnavindonesia.co.id/resources/pegawai/dokumen/";

}
