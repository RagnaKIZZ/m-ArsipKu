package ahmedt.m_arsipku.DaftarNomor;


import com.google.gson.annotations.SerializedName;


public class DataItem{

	@SerializedName("tgldigunakan")
	private String tgldigunakan;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("stts_distribusi")
	private String sttsDistribusi;

	@SerializedName("id_listnomor")
	private String idListnomor;

	@SerializedName("tertuju")
	private String tertuju;

	@SerializedName("tipesurat")
	private String tipesurat;

	@SerializedName("id_so")
	private String idSo;

	@SerializedName("iddata")
	private String iddata;

	@SerializedName("no_surat")
	private String noSurat;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("sttspakai")
	private String sttspakai;

	@SerializedName("tglbermohon")
	private String tglbermohon;

	public void setTgldigunakan(String tgldigunakan){
		this.tgldigunakan = tgldigunakan;
	}

	public String getTgldigunakan(){
		return tgldigunakan;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setSttsDistribusi(String sttsDistribusi){
		this.sttsDistribusi = sttsDistribusi;
	}

	public String getSttsDistribusi(){
		return sttsDistribusi;
	}

	public void setIdListnomor(String idListnomor){
		this.idListnomor = idListnomor;
	}

	public String getIdListnomor(){
		return idListnomor;
	}

	public void setTertuju(String tertuju){
		this.tertuju = tertuju;
	}

	public String getTertuju(){
		return tertuju;
	}

	public void setTipesurat(String tipesurat){
		this.tipesurat = tipesurat;
	}

	public String getTipesurat(){
		return tipesurat;
	}

	public void setIdSo(String idSo){
		this.idSo = idSo;
	}

	public String getIdSo(){
		return idSo;
	}

	public void setIddata(String iddata){
		this.iddata = iddata;
	}

	public String getIddata(){
		return iddata;
	}

	public void setNoSurat(String noSurat){
		this.noSurat = noSurat;
	}

	public String getNoSurat(){
		return noSurat;
	}

	public void setFileAttach(String fileAttach){
		this.fileAttach = fileAttach;
	}

	public String getFileAttach(){
		return fileAttach;
	}

	public void setSttspakai(String sttspakai){
		this.sttspakai = sttspakai;
	}

	public String getSttspakai(){
		return sttspakai;
	}

	public void setTglbermohon(String tglbermohon){
		this.tglbermohon = tglbermohon;
	}

	public String getTglbermohon(){
		return tglbermohon;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"tgldigunakan = '" + tgldigunakan + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",stts_distribusi = '" + sttsDistribusi + '\'' + 
			",id_listnomor = '" + idListnomor + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",tipesurat = '" + tipesurat + '\'' + 
			",id_so = '" + idSo + '\'' + 
			",iddata = '" + iddata + '\'' + 
			",no_surat = '" + noSurat + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",sttspakai = '" + sttspakai + '\'' + 
			",tglbermohon = '" + tglbermohon + '\'' + 
			"}";
		}
}