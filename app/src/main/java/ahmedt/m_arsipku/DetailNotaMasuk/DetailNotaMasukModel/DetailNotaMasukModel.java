package ahmedt.m_arsipku.DetailNotaMasuk.DetailNotaMasukModel;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class DetailNotaMasukModel{

	@SerializedName("msg")
	private String msg;

	@SerializedName("code")
	private int code;

	@SerializedName("tertuju")
	private List<TertujuItem> tertuju;

	@SerializedName("data")
	private Data data;

	@SerializedName("tembusan")
	private List<TembusanItem> tembusan;

	public void setMsg(String msg){
		this.msg = msg;
	}

	public String getMsg(){
		return msg;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setTertuju(List<TertujuItem> tertuju){
		this.tertuju = tertuju;
	}

	public List<TertujuItem> getTertuju(){
		return tertuju;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setTembusan(List<TembusanItem> tembusan){
		this.tembusan = tembusan;
	}

	public List<TembusanItem> getTembusan(){
		return tembusan;
	}

	@Override
 	public String toString(){
		return 
			"DetailNotaMasukModel{" + 
			"msg = '" + msg + '\'' + 
			",code = '" + code + '\'' + 
			",tertuju = '" + tertuju + '\'' + 
			",data = '" + data + '\'' + 
			",tembusan = '" + tembusan + '\'' + 
			"}";
		}
}