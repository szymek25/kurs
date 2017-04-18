package pl.kobietydokodu.koty.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Photo {
	
	@Id
	private String orginalName;
	private String uuid;
	private long size;
	private byte[] byteSize;
	private String mimeType;
	@OneToOne
	private Kot kot;
	
	
	public String getOrginalName() {
		return orginalName;
	}
	public void setOrginalName(String orginalName) {
		this.orginalName = orginalName;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long bs) {
		this.size = bs;
	}
	public Kot getKot() {
		return kot;
	}
	public void setKot(Kot kot) {
		this.kot = kot;
	}
	public byte[] getByteSize() {
		return byteSize;
	}
	public void setByteSize(byte[] byteSize) {
		this.byteSize = byteSize;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}


}
