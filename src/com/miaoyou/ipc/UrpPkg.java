package com.miaoyou.ipc;


import java.io.Serializable;

/**
 *
 * @author 305027939
 */
public class UrpPkg implements Serializable{


	private static final long serialVersionUID = -8555933562117686697L;
	private int seqID;
    private int cmdFlag;
    private UrpCmd cmd;



	public int getSeqID() {
		return seqID;
	}

	public void setSeqID(int seqID) {
		this.seqID = seqID;
	}

	public int getCmdFlag() {
		return cmdFlag;
	}

	public void setCmdFlag(int cmdFlag) {
		this.cmdFlag = cmdFlag;
	}

	/**
     * @return the cmd
     */
    public UrpCmd getCmd() {
        return cmd;
    }

    /**
     * @param cmd the cmd to set
     */
    public void setCmd(UrpCmd cmd) {
        this.cmd = cmd;
    }
    
    @Override
    public String toString(){
       return seqID+","+cmdFlag+","+cmd.getCmdID()+","+cmd.getdLen()+","+cmd.getData();
    }
    
}
