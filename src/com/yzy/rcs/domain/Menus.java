package com.yzy.rcs.domain;
/**
 * 菜单实体类
 * **/
public class Menus {
	
	//菜单项的标识（PK）
	private Integer mid;  
	//每个菜单项目对应的父节点ID
	private Integer pmid; 
	//菜单节点的名字
	private String mname; 
	//菜单节点发送请求的URL
	private String url;   
	//////////////////////////////////////////////
	private Integer open; //菜单节点默认是否展开
	//如果没有子节点，是否按照父节点效果显示
	private Integer isParent; 
	//点击菜单项发送请求，响应数据的显示位置
	private String target;
	//菜单项目的自定义图标
	private String icon; 
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public Integer getPmid() {
		return pmid;
	}
	public void setPmid(Integer pmid) {
		this.pmid = pmid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getOpen() {
		return open;
	}
	public void setOpen(Integer open) {
		this.open = open;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	

}
