package net.bandung.bean;

public class PostBean {

    private int pid;
    private String judul;
    private String isi;
    private String gambar;
    private String longi;
    private String lati;
        
    
    public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public String getIsi() {
		return isi;
	}
	public void setIsi(String isi) {
		this.isi = isi;
	}	
	public String getGambar() {
		return gambar;
	}
	public void setGambar(String gambar) {
		this.gambar = gambar;
	}	
	public String getLong() {
		return longi;
	}
	public void setLong(String longi) {
		this.longi = longi;
	}	
	public String getLat() {
		return lati;
	}
	public void setLat(String lati) {
		this.lati = lati;
	}	
}