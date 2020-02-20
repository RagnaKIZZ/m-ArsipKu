package ahmedt.m_arsipku.MemoTerkirim;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


public class DataItem implements Parcelable {

	@SerializedName("alamat_surat")
	private String alamatSurat;

	@SerializedName("penulis")
	private String penulis;

	@SerializedName("tertuju")
	private String tertuju;

	@SerializedName("arsip")
	private String arsip;

	@SerializedName("jabatan_tembusan")
	private String jabatanTembusan;

	@SerializedName("rahasia")
	private String rahasia;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("nama_pengirim")
	private String namaPengirim;

	@SerializedName("logo_surat")
	private String logoSurat;

	@SerializedName("jabatan_pengirim")
	private String jabatanPengirim;

	@SerializedName("ttd_pengirim")
	private String ttdPengirim;

	@SerializedName("berita")
	private String berita;

	@SerializedName("tgl_sent")
	private String tglSent;

	@SerializedName("file_memo")
	private String fileMemo;

	@SerializedName("dari")
	private String dari;

	@SerializedName("id")
	private String id;

	@SerializedName("id_berkas")
	private String idBerkas;

	@SerializedName("status_sent")
	private String statusSent;

	@SerializedName("id_konsep")
	private String idKonsep;

	@SerializedName("foot_name")
	private String footName;

	@SerializedName("jabatan_tertuju")
	private String jabatanTertuju;

	@SerializedName("tembusan")
	private String tembusan;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("revisikonsep")
	private String revisikonsep;

	@SerializedName("konsep")
	private String konsep;

	@SerializedName("alamat_cabang")
	private String alamatCabang;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("lampiran")
	private String lampiran;

	@SerializedName("nama_cabang")
	private String namaCabang;

	@SerializedName("jenis_nd")
	private String jenisNd;

	protected DataItem(Parcel in) {
		alamatSurat = in.readString();
		penulis = in.readString();
		tertuju = in.readString();
		arsip = in.readString();
		jabatanTembusan = in.readString();
		rahasia = in.readString();
		idCabang = in.readString();
		namaPengirim = in.readString();
		logoSurat = in.readString();
		jabatanPengirim = in.readString();
		ttdPengirim = in.readString();
		berita = in.readString();
		tglSent = in.readString();
		fileMemo = in.readString();
		dari = in.readString();
		id = in.readString();
		idBerkas = in.readString();
		statusSent = in.readString();
		idKonsep = in.readString();
		footName = in.readString();
		jabatanTertuju = in.readString();
		fileAttach = in.readString();
		perihal = in.readString();
		revisikonsep = in.readString();
		konsep = in.readString();
		alamatCabang = in.readString();
		tglSurat = in.readString();
		noSurat = in.readString();
		lampiran = in.readString();
		namaCabang = in.readString();
		jenisNd = in.readString();
	}

	public static final Creator<DataItem> CREATOR = new Creator<DataItem>() {
		@Override
		public DataItem createFromParcel(Parcel in) {
			return new DataItem(in);
		}

		@Override
		public DataItem[] newArray(int size) {
			return new DataItem[size];
		}
	};

	public DataItem() {

	}

	public void setAlamatSurat(String alamatSurat){
		this.alamatSurat = alamatSurat;
	}

	public String getAlamatSurat(){
		return alamatSurat;
	}

	public void setPenulis(String penulis){
		this.penulis = penulis;
	}

	public String getPenulis(){
		return penulis;
	}

	public void setTertuju(String tertuju){
		this.tertuju = tertuju;
	}

	public String getTertuju(){
		return tertuju;
	}

	public void setArsip(String arsip){
		this.arsip = arsip;
	}

	public String getArsip(){
		return arsip;
	}

	public void setJabatanTembusan(String jabatanTembusan){
		this.jabatanTembusan = jabatanTembusan;
	}

	public String getJabatanTembusan(){
		return jabatanTembusan;
	}

	public void setRahasia(String rahasia){
		this.rahasia = rahasia;
	}

	public String getRahasia(){
		return rahasia;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setNamaPengirim(String namaPengirim){
		this.namaPengirim = namaPengirim;
	}

	public String getNamaPengirim(){
		return namaPengirim;
	}

	public void setLogoSurat(String logoSurat){
		this.logoSurat = logoSurat;
	}

	public String getLogoSurat(){
		return logoSurat;
	}

	public void setJabatanPengirim(String jabatanPengirim){
		this.jabatanPengirim = jabatanPengirim;
	}

	public String getJabatanPengirim(){
		return jabatanPengirim;
	}

	public void setTtdPengirim(String ttdPengirim){
		this.ttdPengirim = ttdPengirim;
	}

	public String getTtdPengirim(){
		return ttdPengirim;
	}

	public void setBerita(String berita){
		this.berita = berita;
	}

	public String getBerita(){
		return berita;
	}

	public void setTglSent(String tglSent){
		this.tglSent = tglSent;
	}

	public String getTglSent(){
		return tglSent;
	}

	public void setFileMemo(String fileMemo){
		this.fileMemo = fileMemo;
	}

	public String getFileMemo(){
		return fileMemo;
	}

	public void setDari(String dari){
		this.dari = dari;
	}

	public String getDari(){
		return dari;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setIdBerkas(String idBerkas){
		this.idBerkas = idBerkas;
	}

	public String getIdBerkas(){
		return idBerkas;
	}

	public void setStatusSent(String statusSent){
		this.statusSent = statusSent;
	}

	public String getStatusSent(){
		return statusSent;
	}

	public void setIdKonsep(String idKonsep){
		this.idKonsep = idKonsep;
	}

	public String getIdKonsep(){
		return idKonsep;
	}

	public void setFootName(String footName){
		this.footName = footName;
	}

	public String getFootName(){
		return footName;
	}

	public void setJabatanTertuju(String jabatanTertuju){
		this.jabatanTertuju = jabatanTertuju;
	}

	public String getJabatanTertuju(){
		return jabatanTertuju;
	}

	public void setTembusan(String tembusan){
		this.tembusan = tembusan;
	}

	public String getTembusan(){
		return tembusan;
	}

	public void setFileAttach(String fileAttach){
		this.fileAttach = fileAttach;
	}

	public String getFileAttach(){
		return fileAttach;
	}

	public void setPerihal(String perihal){
		this.perihal = perihal;
	}

	public String getPerihal(){
		return perihal;
	}

	public void setRevisikonsep(String revisikonsep){
		this.revisikonsep = revisikonsep;
	}

	public String getRevisikonsep(){
		return revisikonsep;
	}

	public void setKonsep(String konsep){
		this.konsep = konsep;
	}

	public String getKonsep(){
		return konsep;
	}

	public void setAlamatCabang(String alamatCabang){
		this.alamatCabang = alamatCabang;
	}

	public String getAlamatCabang(){
		return alamatCabang;
	}

	public void setTglSurat(String tglSurat){
		this.tglSurat = tglSurat;
	}

	public String getTglSurat(){
		return tglSurat;
	}

	public void setNoSurat(String noSurat){
		this.noSurat = noSurat;
	}

	public String getNoSurat(){
		return noSurat;
	}

	public void setLampiran(String lampiran){
		this.lampiran = lampiran;
	}

	public String getLampiran(){
		return lampiran;
	}

	public void setNamaCabang(String namaCabang){
		this.namaCabang = namaCabang;
	}

	public String getNamaCabang(){
		return namaCabang;
	}

	public void setJenisNd(String jenisNd){
		this.jenisNd = jenisNd;
	}

	public String getJenisNd(){
		return jenisNd;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"alamat_surat = '" + alamatSurat + '\'' + 
			",penulis = '" + penulis + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",arsip = '" + arsip + '\'' + 
			",jabatan_tembusan = '" + jabatanTembusan + '\'' + 
			",rahasia = '" + rahasia + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",nama_pengirim = '" + namaPengirim + '\'' + 
			",logo_surat = '" + logoSurat + '\'' + 
			",jabatan_pengirim = '" + jabatanPengirim + '\'' + 
			",ttd_pengirim = '" + ttdPengirim + '\'' + 
			",berita = '" + berita + '\'' + 
			",tgl_sent = '" + tglSent + '\'' + 
			",file_memo = '" + fileMemo + '\'' + 
			",dari = '" + dari + '\'' + 
			",id = '" + id + '\'' + 
			",id_berkas = '" + idBerkas + '\'' + 
			",status_sent = '" + statusSent + '\'' + 
			",id_konsep = '" + idKonsep + '\'' + 
			",foot_name = '" + footName + '\'' + 
			",jabatan_tertuju = '" + jabatanTertuju + '\'' + 
			",tembusan = '" + tembusan + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",revisikonsep = '" + revisikonsep + '\'' + 
			",konsep = '" + konsep + '\'' + 
			",alamat_cabang = '" + alamatCabang + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",lampiran = '" + lampiran + '\'' + 
			",nama_cabang = '" + namaCabang + '\'' + 
			",jenis_nd = '" + jenisNd + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(alamatSurat);
		dest.writeString(penulis);
		dest.writeString(tertuju);
		dest.writeString(arsip);
		dest.writeString(jabatanTembusan);
		dest.writeString(rahasia);
		dest.writeString(idCabang);
		dest.writeString(namaPengirim);
		dest.writeString(logoSurat);
		dest.writeString(jabatanPengirim);
		dest.writeString(ttdPengirim);
		dest.writeString(berita);
		dest.writeString(tglSent);
		dest.writeString(fileMemo);
		dest.writeString(dari);
		dest.writeString(id);
		dest.writeString(idBerkas);
		dest.writeString(statusSent);
		dest.writeString(idKonsep);
		dest.writeString(footName);
		dest.writeString(jabatanTertuju);
		dest.writeString(fileAttach);
		dest.writeString(perihal);
		dest.writeString(revisikonsep);
		dest.writeString(konsep);
		dest.writeString(alamatCabang);
		dest.writeString(tglSurat);
		dest.writeString(noSurat);
		dest.writeString(lampiran);
		dest.writeString(namaCabang);
		dest.writeString(jenisNd);
	}
}