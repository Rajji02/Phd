package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.IdClass;

import org.springframework.stereotype.Component;

//@IdClass(value =)
public class EmployeeKeys implements Serializable{
private int adharid;
private int eid;
public EmployeeKeys(int adharid, int eid) {
	super();
	this.adharid = adharid;
	this.eid = eid;
}
public EmployeeKeys() {
	super();
	// TODO Auto-generated constructor stub
}
public int getAdharid() {
	return adharid;
}
public void setAdharid(int adharid) {
	this.adharid = adharid;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}

}
