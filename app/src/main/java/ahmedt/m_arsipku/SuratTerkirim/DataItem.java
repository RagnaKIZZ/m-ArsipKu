package ahmedt.m_arsipku.SuratTerkirim;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("jenis_surat")
	private String jenisSurat;

	@SerializedName("id_berkas")
	private String idBerkas;

	@SerializedName("tertuju")
	private String tertuju;

	@SerializedName("status_sent")
	private String statusSent;

	@SerializedName("kode_jabatan")
	private String kodeJabatan;

	@SerializedName("tembusan")
	private String tembusan;

	@SerializedName("sifat_surat")
	private String sifatSurat;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("idcabang_tembusan")
	private String idcabangTembusan;

	@SerializedName("kodekla")
	private String kodekla;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("idcabang_tertuju")
	private String idcabangTertuju;

	@SerializedName("berita")
	private String berita;

	@SerializedName("tgl_sent")
	private String tglSent;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("lampiran")
	private String lampiran;

	@SerializedName("dari")
	private String dari;

	@SerializedName("id")
	private String id;

	public void setJenisSurat(String jenisSurat){
		this.jenisSurat = jenisSurat;
	}

	public String getJenisSurat(){
		return jenisSurat;
	}

	public void setIdBerkas(String idBerkas){
		this.idBerkas = idBerkas;
	}

	public String getIdBerkas(){
		return idBerkas;
	}

	public void setTertuju(String tertuju){
		this.tertuju = tertuju;
	}

	public String getTertuju(){
		return tertuju;
	}

	public void setStatusSent(String statusSent){
		this.statusSent = statusSent;
	}

	public String getStatusSent(){
		return statusSent;
	}

	public void setKodeJabatan(String kodeJabatan){
		this.kodeJabatan = kodeJabatan;
	}

	public String getKodeJabatan(){
		return kodeJabatan;
	}

	public void setTembusan(String tembusan){
		this.tembusan = tembusan;
	}

	public String getTembusan(){
		return tembusan;
	}

	public void setSifatSurat(String sifatSurat){
		this.sifatSurat = sifatSurat;
	}

	public String getSifatSurat(){
		return sifatSurat;
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

	public void setIdcabangTembusan(String idcabangTembusan){
		this.idcabangTembusan = idcabangTembusan;
	}

	public String getIdcabangTembusan(){
		return idcabangTembusan;
	}

	public void setKodekla(String kodekla){
		this.kodekla = kodekla;
	}

	public String getKodekla(){
		return kodekla;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setIdcabangTertuju(String idcabangTertuju){
		this.idcabangTertuju = idcabangTertuju;
	}

	public String getIdcabangTertuju(){
		return idcabangTertuju;
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

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"jenis_surat = '" + jenisSurat + '\'' + 
			",id_berkas = '" + idBerkas + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",status_sent = '" + statusSent + '\'' + 
			",kode_jabatan = '" + kodeJabatan + '\'' + 
			",tembusan = '" + tembusan + '\'' + 
			",sifat_surat = '" + sifatSurat + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",idcabang_tembusan = '" + idcabangTembusan + '\'' + 
			",kodekla = '" + kodekla + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",idcabang_tertuju = '" + idcabangTertuju + '\'' + 
			",berita = '" + berita + '\'' + 
			",tgl_sent = '" + tglSent + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",lampiran = '" + lampiran + '\'' + 
			",dari = '" + dari + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}