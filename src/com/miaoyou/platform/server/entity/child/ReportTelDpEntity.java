package com.miaoyou.platform.server.entity.child;

import com.miaoyou.platform.server.entity.Departmenttb;

public class ReportTelDpEntity {
	private Departmenttb departmenttb;
	private int finishActual;
	private int finishPlan;
    private String finishActualPercent;
	private int cancel;
	private String cancelPercent;
	private int overdue;
	private String overduePercent;
	public Departmenttb getDepartmenttb() {
		return departmenttb;
	}
	public void setDepartmenttb(Departmenttb departmenttb) {
		this.departmenttb = departmenttb;
	}
	public String getFinishActualPercent() {
		return finishActualPercent;
	}
	public void setFinishActualPercent(String finishActualPercent) {
		this.finishActualPercent = finishActualPercent;
	}
	public String getCancelPercent() {
		return cancelPercent;
	}
	public void setCancelPercent(String cancelPercent) {
		this.cancelPercent = cancelPercent;
	}
	public String getOverduePercent() {
		return overduePercent;
	}
	public void setOverduePercent(String overduePercent) {
		this.overduePercent = overduePercent;
	}
	public int getFinishActual() {
		return finishActual;
	}
	public void setFinishActual(int finishActual) {
		this.finishActual = finishActual;
	}
	public int getFinishPlan() {
		return finishPlan;
	}
	public void setFinishPlan(int finishPlan) {
		this.finishPlan = finishPlan;
	}
	public int getCancel() {
		return cancel;
	}
	public void setCancel(int cancel) {
		this.cancel = cancel;
	}
	public int getOverdue() {
		return overdue;
	}
	public void setOverdue(int overdue) {
		this.overdue = overdue;
	}
}
