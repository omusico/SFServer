package com.miaoyou.ipc;


import java.io.Serializable;

/**
 *
 * @author 305027939
 */
public class UrpCmd implements Serializable {

	private static final long serialVersionUID = 226422123015823989L;


	private int cmdID;
    private int dLen;
    private String data;

	public int getCmdID() {
		return cmdID;
	}
	public void setCmdID(int cmdID) {
		this.cmdID = cmdID;
	}
	public int getdLen() {
		return dLen;
	}
	public void setdLen(int dLen) {
		this.dLen = dLen;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


   
  
    
    
    
}
