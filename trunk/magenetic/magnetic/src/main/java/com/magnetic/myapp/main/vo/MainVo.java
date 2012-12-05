/**
 * 
 */
package com.magnetic.myapp.main.vo;

import java.util.List;

/**
 * @author Administrator
 *
 */
public class MainVo {

	private String name;
	
	private String content;
	
	private List<MainVo> mainVoList;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the mainVoList
	 */
	public List<MainVo> getMainVoList() {
		return mainVoList;
	}

	/**
	 * @param mainVoList the mainVoList to set
	 */
	public void setMainVoList(List<MainVo> mainVoList) {
		this.mainVoList = mainVoList;
	}
}
