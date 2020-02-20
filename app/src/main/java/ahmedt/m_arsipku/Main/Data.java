package ahmedt.m_arsipku.Main;


import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("suratDisposisi")
	private String suratDisposisi;

	@SerializedName("notaDisposisi")
	private String notaDisposisi;

	@SerializedName("suratMasuk")
	private String suratMasuk;

	@SerializedName("notaDinas")
	private String notaDinas;

	public void setSuratDisposisi(String suratDisposisi){
		this.suratDisposisi = suratDisposisi;
	}

	public String getSuratDisposisi(){
		return suratDisposisi;
	}

	public void setNotaDisposisi(String notaDisposisi){
		this.notaDisposisi = notaDisposisi;
	}

	public String getNotaDisposisi(){
		return notaDisposisi;
	}

	public void setSuratMasuk(String suratMasuk){
		this.suratMasuk = suratMasuk;
	}

	public String getSuratMasuk(){
		return suratMasuk;
	}

	public void setNotaDinas(String notaDinas){
		this.notaDinas = notaDinas;
	}

	public String getNotaDinas(){
		return notaDinas;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"suratDisposisi = '" + suratDisposisi + '\'' + 
			",notaDisposisi = '" + notaDisposisi + '\'' + 
			",suratMasuk = '" + suratMasuk + '\'' + 
			",notaDinas = '" + notaDinas + '\'' + 
			"}";
		}
}