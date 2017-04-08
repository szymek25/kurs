package pl.kobietydokodu.koty.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Atachment {
	
	@Id
	private String orginalName;
	private String uuid;
	private long size;
	
	
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
	

}
