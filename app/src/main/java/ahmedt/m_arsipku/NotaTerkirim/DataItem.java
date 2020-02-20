package ahmedt.m_arsipku.NotaTerkirim;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("id_berkas")
	private String idBerkas;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("rahasia")
	private String rahasia;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("password")
	private String password;

	@SerializedName("file_notadinas")
	private String fileNotadinas;

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

	public void setIdBerkas(String idBerkas){
		this.idBerkas = idBerkas;
	}

	public String getIdBerkas(){
		return idBerkas;
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

	public void setFileNotadinas(String fileNotadinas){
		this.fileNotadinas = fileNotadinas;
	}

	public String getFileNotadinas(){
		return fileNotadinas;
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
			"id_berkas = '" + idBerkas + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",rahasia = '" + rahasia + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",password = '" + password + '\'' + 
			",file_notadinas = '" + fileNotadinas + '\'' + 
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