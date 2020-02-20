package ahmedt.m_arsipku.Login.LoginModel;


import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("jabatanph")
	private String jabatanph;

	@SerializedName("groupmenusek")
	private String groupmenusek;

	@SerializedName("jabatan")
	private String jabatan;

	@SerializedName("kode_jabatan")
	private String kodeJabatan;

	@SerializedName("index")
	private String index;

	@SerializedName("id_ph")
	private String idPh;

	@SerializedName("jabatansek")
	private String jabatansek;

	@SerializedName("id_sek")
	private String idSek;

	@SerializedName("id_cabang")
	private String idCabang;

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("id_so")
	private String idSo;

	@SerializedName("groupmenu")
	private String groupmenu;

	@SerializedName("nama_cabang")
	private String namaCabang;

	@SerializedName("groupmenuph")
	private String groupmenuph;

	@SerializedName("email")
	private String email;

	@SerializedName("pts_ph")
	private String ptsPh;

	@SerializedName("username")
	private String username;

	public void setJabatanph(String jabatanph){
		this.jabatanph = jabatanph;
	}

	public String getJabatanph(){
		return jabatanph;
	}

	public void setGroupmenusek(String groupmenusek){
		this.groupmenusek = groupmenusek;
	}

	public String getGroupmenusek(){
		return groupmenusek;
	}

	public void setJabatan(String jabatan){
		this.jabatan = jabatan;
	}

	public String getJabatan(){
		return jabatan;
	}

	public void setKodeJabatan(String kodeJabatan){
		this.kodeJabatan = kodeJabatan;
	}

	public String getKodeJabatan(){
		return kodeJabatan;
	}

	public void setIndex(String index){
		this.index = index;
	}

	public String getIndex(){
		return index;
	}

	public void setIdPh(String idPh){
		this.idPh = idPh;
	}

	public String getIdPh(){
		return idPh;
	}

	public void setJabatansek(String jabatansek){
		this.jabatansek = jabatansek;
	}

	public String getJabatansek(){
		return jabatansek;
	}

	public void setIdSek(String idSek){
		this.idSek = idSek;
	}

	public String getIdSek(){
		return idSek;
	}

	public void setIdCabang(String idCabang){
		this.idCabang = idCabang;
	}

	public String getIdCabang(){
		return idCabang;
	}

	public void setNama(String nama){
		this.nama = nama;
	}

	public String getNama(){
		return nama;
	}

	public void setFoto(String foto){
		this.foto = foto;
	}

	public String getFoto(){
		return foto;
	}

	public void setIdSo(String idSo){
		this.idSo = idSo;
	}

	public String getIdSo(){
		return idSo;
	}

	public void setGroupmenu(String groupmenu){
		this.groupmenu = groupmenu;
	}

	public String getGroupmenu(){
		return groupmenu;
	}

	public void setNamaCabang(String namaCabang){
		this.namaCabang = namaCabang;
	}

	public String getNamaCabang(){
		return namaCabang;
	}

	public void setGroupmenuph(String groupmenuph){
		this.groupmenuph = groupmenuph;
	}

	public String getGroupmenuph(){
		return groupmenuph;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setPtsPh(String ptsPh){
		this.ptsPh = ptsPh;
	}

	public String getPtsPh(){
		return ptsPh;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"jabatanph = '" + jabatanph + '\'' + 
			",groupmenusek = '" + groupmenusek + '\'' + 
			",jabatan = '" + jabatan + '\'' + 
			",kode_jabatan = '" + kodeJabatan + '\'' + 
			",index = '" + index + '\'' + 
			",id_ph = '" + idPh + '\'' + 
			",jabatansek = '" + jabatansek + '\'' + 
			",id_sek = '" + idSek + '\'' + 
			",id_cabang = '" + idCabang + '\'' + 
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",id_so = '" + idSo + '\'' + 
			",groupmenu = '" + groupmenu + '\'' + 
			",nama_cabang = '" + namaCabang + '\'' + 
			",groupmenuph = '" + groupmenuph + '\'' + 
			",email = '" + email + '\'' + 
			",pts_ph = '" + ptsPh + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}