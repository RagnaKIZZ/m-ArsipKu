package ahmedt.m_arsipku.DetailDispo.DetailDispoModel;


import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("id_berkas")
	private String idBerkas;

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

	@SerializedName("no_agenda")
	private String noAgenda;

	@SerializedName("isi_disposisi")
	private String isiDisposisi;

	@SerializedName("tipedisposisi")
	private String tipedisposisi;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("id")
	private String id;

	@SerializedName("klasifikasi")
	private String klasifikasi;

	@SerializedName("lainnya")
	private String lainnya;

	@SerializedName("nama_jabatan")
	private String namaJabatan;

	public void setIdBerkas(String idBerkas){
		this.idBerkas = idBerkas;
	}

	public String getIdBerkas(){
		return idBerkas;
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

	public void setNoAgenda(String noAgenda){
		this.noAgenda = noAgenda;
	}

	public String getNoAgenda(){
		return noAgenda;
	}

	public void setIsiDisposisi(String isiDisposisi){
		this.isiDisposisi = isiDisposisi;
	}

	public String getIsiDisposisi(){
		return isiDisposisi;
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

	public void setNamaJabatan(String namaJabatan){
		this.namaJabatan = namaJabatan;
	}

	public String getNamaJabatan(){
		return namaJabatan;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"id_berkas = '" + idBerkas + '\'' + 
			",terima_tgl = '" + terimaTgl + '\'' + 
			",no_ref_surat = '" + noRefSurat + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",file_disposisi = '" + fileDisposisi + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",asal_surat = '" + asalSurat + '\'' + 
			",no_agenda = '" + noAgenda + '\'' + 
			",isi_disposisi = '" + isiDisposisi + '\'' + 
			",tipedisposisi = '" + tipedisposisi + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",id = '" + id + '\'' + 
			",klasifikasi = '" + klasifikasi + '\'' + 
			",lainnya = '" + lainnya + '\'' + 
			",nama_jabatan = '" + namaJabatan + '\'' + 
			"}";
		}
}