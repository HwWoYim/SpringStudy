package com.kim.biz.controller;

// 정확한 경로를 반환해준다.
public class ViewResolver {
	public String prefix; // 의존관계 => DI => setter 주입
	public String suffix; // 의존관계 => DI => setter 주입
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		// Spring에서 제공하는 코드
		return prefix + viewName + suffix;
	}
}
