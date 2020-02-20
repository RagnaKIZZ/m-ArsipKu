package ahmedt.m_arsipku.SuratMasuk;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DataItem implements Parcelable {

	@SerializedName("asal_naskah")
	private String asalNaskah;

	@SerializedName("password")
	private String password;

	@SerializedName("id_berkas")
	private String idBerkas;

	@SerializedName("tgl_naskah")
	private String tglNaskah;

	@SerializedName("tgl_reg")
	private String tglReg;

	@SerializedName("id")
	private String id;

	@SerializedName("no_asal_naskah")
	private String noAsalNaskah;

	@SerializedName("file_attach")
	private String fileAttach;

	@SerializedName("sifat_surat")
	private String sifatSurat;

	@SerializedName("perihal")
	private String perihal;

	@SerializedName("status")
	private String status;

	protected DataItem(Parcel in) {
		asalNaskah = in.readString();
		password = in.readString();
		idBerkas = in.readString();
		tglNaskah = in.readString();
		tglReg = in.readString();
		id = in.readString();
		noAsalNaskah = in.readString();
		fileAttach = in.readString();
		sifatSurat = in.readString();
		perihal = in.readString();
		status = in.readString();
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

	public void setAsalNaskah(String asalNaskah){
		this.asalNaskah = asalNaskah;
	}

	public String getAsalNaskah(){
		return asalNaskah;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setIdBerkas(String idBerkas){
		this.idBerkas = idBerkas;
	}

	public String getIdBerkas(){
		return idBerkas;
	}

	public void setTglNaskah(String tglNaskah){
		this.tglNaskah = tglNaskah;
	}

	public String getTglNaskah(){
		return tglNaskah;
	}

	public void setTglReg(String tglReg){
		this.tglReg = tglReg;
	}

	public String getTglReg(){
		return tglReg;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setNoAsalNaskah(String noAsalNaskah){
		this.noAsalNaskah = noAsalNaskah;
	}

	public String getNoAsalNaskah(){
		return noAsalNaskah;
	}

	public void setFileAttach(String fileAttach){
		this.fileAttach = fileAttach;
	}

	public String getFileAttach(){
		return fileAttach;
	}

	public void setSifatSurat(String sifatSurat){
		this.sifatSurat = sifatSurat;
	}

	public String getSifatSurat(){
		return sifatSurat;
	}

	public void setPerihal(String perihal){
		this.perihal = perihal;
	}

	public String getPerihal(){
		return perihal;
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
			"asal_naskah = '" + asalNaskah + '\'' + 
			",password = '" + password + '\'' + 
			",id_berkas = '" + idBerkas + '\'' + 
			",tgl_naskah = '" + tglNaskah + '\'' + 
			",tgl_reg = '" + tglReg + '\'' + 
			",id = '" + id + '\'' + 
			",no_asal_naskah = '" + noAsalNaskah + '\'' + 
			",file_attach = '" + fileAttach + '\'' + 
			",sifat_surat = '" + sifatSurat + '\'' + 
			",perihal = '" + perihal + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(asalNaskah);
		dest.writeString(password);
		dest.writeString(idBerkas);
		dest.writeString(tglNaskah);
		dest.writeString(tglReg);
		dest.writeString(id);
		dest.writeString(noAsalNaskah);
		dest.writeString(fileAttach);
		dest.writeString(sifatSurat);
		dest.writeString(perihal);
		dest.writeString(status);
	}
}