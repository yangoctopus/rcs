package com.yzy.rcs.vo;

import com.yzy.rcs.domain.Emodel;

public class EmodelVo extends Emodel {
	
	private String[] xaxis=new String[12]; //x轴
	private Double[] yayis=new Double[12]; //y轴


	public String[] getXaxis() {
		return xaxis;
	}
	public void setXaxis(String[] xaxis) {
		this.xaxis = xaxis;
	}
	public Double[] getYayis() {
		return yayis;
	}
	public void setYayis(Double[] yayis) {
		this.yayis = yayis;
	}

}
