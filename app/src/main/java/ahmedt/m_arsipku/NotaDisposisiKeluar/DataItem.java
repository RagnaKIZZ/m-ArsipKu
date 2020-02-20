package ahmedt.m_arsipku.NotaDisposisiKeluar;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("id_berkas")
	private String idBerkas;

	@SerializedName("tertuju")
	private String tertuju;

	@SerializedName("terima_tgl")
	private String terimaTgl;

	@SerializedName("no_ref_surat")
	private String noRefSurat;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("file_disposisi")
	private String fileDisposisi;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("asal_surat")
	private String asalSurat;

	@SerializedName("item_dispo")
	private String itemDispo;

	@SerializedName("no_agenda")
	private String noAgenda;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("password")
	private String password;

	@SerializedName("all_tertuju")
	private String allTertuju;

	@SerializedName("isi_disposisi")
	private String isiDisposisi;

	@SerializedName("tgl_sent")
	private String tglSent;

	@SerializedName("tipedisposisi")
	private String tipedisposisi;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("dari")
	private String dari;

	@SerializedName("id")
	private String id;

	@SerializedName("klasifikasi")
	private String klasifikasi;

	@SerializedName("lainnya")
	private String lainnya;

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

	public void setTerimaTgl(String terimaTgl){
		this.terimaTgl = terimaTgl;
	}

	public String getTerimaTgl(){
		return terimaTgl;
	}

	public void setNoRefSurat(String noRefSurat){
		this.noRefSurat = noRefSurat;
	}

	public String getNoRefSurat(){
		return noRefSurat;
	}

	public void setFileAttach(String fileAttach){
		this.fileAttach = fileAttach;
	}

	public String getFileAttach(){
		return fileAttach;
	}

	public void setFileDisposisi(String fileDisposisi){
		this.fileDisposisi = fileDisposisi;
	}

	public String getFileDisposisi(){
		return fileDisposisi;
	}

	public void setPerihal(String perihal){
		this.perihal = perihal;
	}

	public String getPerihal(){
		return perihal;
	}

	public void setAsalSurat(String asalSurat){
		this.asalSurat = asalSurat;
	}

	public String getAsalSurat(){
		return asalSurat;
	}

	public void setItemDispo(String itemDispo){
		this.itemDispo = itemDispo;
	}

	public String getItemDispo(){
		return itemDispo;
	}

	public void setNoAgenda(String noAgenda){
		this.noAgenda = noAgenda;
	}

	public String getNoAgenda(){
		return noAgenda;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setAllTertuju(String allTertuju){
		this.allTertuju = allTertuju;
	}

	public String getAllTertuju(){
		return allTertuju;
	}

	public void setIsiDisposisi(String isiDisposisi){
		this.isiDisposisi = isiDisposisi;
	}

	public String getIsiDisposisi(){
		return isiDisposisi;
	}

	public void setTglSent(String tglSent){
		this.tglSent = tglSent;
	}

	public String getTglSent(){
		return tglSent;
	}

	public void setTipedisposisi(String tipedisposisi){
		this.tipedisposisi = tipedisposisi;
	}

	public String getTipedisposisi(){
		return tipedisposisi;
	}

	public void setTglSurat(String tglSurat){
		this.tglSurat = tglSurat;
	}

	public String getTglSurat(){
		return tglSurat;
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

	public void setKlasifikasi(String klasifikasi){
		this.klasifikasi = klasifikasi;
	}

	public String getKlasifikasi(){
		return klasifikasi;
	}

	public void setLainnya(String lainnya){
		this.lainnya = lainnya;
	}

	public String getLainnya(){
		return lainnya;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"id_berkas = '" + idBerkas + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",terima_tgl = '" + terimaTgl + '\'' + 
			",no_ref_surat = '" + noRefSurat + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",file_disposisi = '" + fileDisposisi + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",asal_surat = '" + asalSurat + '\'' + 
			",item_dispo = '" + itemDispo + '\'' + 
			",no_agenda = '" + noAgenda + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",password = '" + password + '\'' + 
			",all_tertuju = '" + allTertuju + '\'' + 
			",isi_disposisi = '" + isiDisposisi + '\'' + 
			",tgl_sent = '" + tglSent + '\'' + 
			",tipedisposisi = '" + tipedisposisi + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",dari = '" + dari + '\'' + 
			",id = '" + id + '\'' + 
			",klasifikasi = '" + klasifikasi + '\'' + 
			",lainnya = '" + lainnya + '\'' + 
			"}";
		}
}