package ahmedt.m_arsipku.NotaMasuk;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("id_notadinas")
	private String idNotadinas;

	@SerializedName("tertuju")
	private String tertuju;

	@SerializedName("kode_jabatan")
	private String kodeJabatan;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("rahasia")
	private String rahasia;

	@SerializedName("password")
	private String password;

	@SerializedName("tgl_sent")
	private String tglSent;

	@SerializedName("tgl_surat")
	private String tglSurat;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("dari")
	private String dari;

	@SerializedName("id")
	private String id;

	@SerializedName("nama_jabatan")
	private String namaJabatan;

	@SerializedName("status")
	private String status;

	public void setIdNotadinas(String idNotadinas){
		this.idNotadinas = idNotadinas;
	}

	public String getIdNotadinas(){
		return idNotadinas;
	}

	public void setTertuju(String tertuju){
		this.tertuju = tertuju;
	}

	public String getTertuju(){
		return tertuju;
	}

	public void setKodeJabatan(String kodeJabatan){
		this.kodeJabatan = kodeJabatan;
	}

	public String getKodeJabatan(){
		return kodeJabatan;
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

	public void setRahasia(String rahasia){
		this.rahasia = rahasia;
	}

	public String getRahasia(){
		return rahasia;
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
			"id_notadinas = '" + idNotadinas + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",kode_jabatan = '" + kodeJabatan + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",rahasia = '" + rahasia + '\'' + 
			",password = '" + password + '\'' + 
			",tgl_sent = '" + tglSent + '\'' + 
			",tgl_surat = '" + tglSurat + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",dari = '" + dari + '\'' + 
			",id = '" + id + '\'' + 
			",nama_jabatan = '" + namaJabatan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}