package ahmedt.m_arsipku.DetailDispo.DetailDispoModel;


import com.google.gson.annotations.SerializedName;


public class TertujuItem{

	@SerializedName("tgl_read")
	private String tglRead;

	@SerializedName("tipe_tertuju")
	private String tipeTertuju;

	@SerializedName("nama_jabatan")
	private String namaJabatan;

	@SerializedName("status")
	private String status;

	public void setTglRead(String tglRead){
		this.tglRead = tglRead;
	}

	public String getTglRead(){
		return tglRead;
	}

	public void setTipeTertuju(String tipeTertuju){
		this.tipeTertuju = tipeTertuju;
	}

	public String getTipeTertuju(){
		return tipeTertuju;
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
			"TertujuItem{" + 
			"tgl_read = '" + tglRead + '\'' + 
			",tipe_tertuju = '" + tipeTertuju + '\'' + 
			",nama_jabatan = '" + namaJabatan + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}