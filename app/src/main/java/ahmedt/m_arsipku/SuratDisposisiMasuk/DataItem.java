package ahmedt.m_arsipku.SuratDisposisiMasuk;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("id_disposisi")
	private String idDisposisi;

	@SerializedName("password")
	private String password;

	@SerializedName("tgl_sent")
	private String tglSent;

	@SerializedName("tipedisposisi")
	private String tipedisposisi;

	@SerializedName("dari")
	private String dari;

	@SerializedName("no_ref_surat")
	private String noRefSurat;

	@SerializedName("id")
	private String id;

	@SerializedName("klasifikasi")
	private String klasifikasi;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("nama_jabatan")
	private String namaJabatan;

	@SerializedName("status")
	private String status;

	public void setIdDisposisi(String idDisposisi){
		this.idDisposisi = idDisposisi;
	}

	public String getIdDisposisi(){
		return idDisposisi;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
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

	public void setDari(String dari){
		this.dari = dari;
	}

	public String getDari(){
		return dari;
	}

	public void setNoRefSurat(String noRefSurat){
		this.noRefSurat = noRefSurat;
	}

	public String getNoRefSurat(){
		return noRefSurat;
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

	public void setNamaJabatan(String namaJabatan){
		this.namaJabatan = namaJabatan;
	}

	public String getNamaJabatan(){
		return namaJabatan;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"id_disposisi = '" + idDisposisi + '\'' + 
			",password = '" + password + '\'' + 
			",tgl_sent = '" + tglSent + '\'' + 
			",tipedisposisi = '" + tipedisposisi + '\'' + 
			",dari = '" + dari + '\'' + 
			",no_ref_surat = '" + noRefSurat + '\'' + 
			",id = '" + id + '\'' + 
			",klasifikasi = '" + klasifikasi + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",nama_jabatan = '" + namaJabatan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}