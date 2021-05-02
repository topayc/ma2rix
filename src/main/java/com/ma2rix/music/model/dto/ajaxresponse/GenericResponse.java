package com.ma2rix.music.model.dto.ajaxresponse;

import java.util.ArrayList;


/**
 * 각종 ajax 를 통한 페이지 리스트 요청에 대한 응답 객체 
 * 각 리스트 항목은 Generic 타입을 이용하여, 다양한 항목에 대한 응답을 생성할 수 있도록 함.
 */
public class GenericResponse<T> extends AjaxResultBase {
	
	private int currentPage;
	private int totalPage;
	private int totalRow;
	private int currentRowCount;
	private int listType;
	
	private ArrayList<T> objects;

	public GenericResponse() {
		super();
	}

	public GenericResponse(int resultCode, String value, String message) {
		super(resultCode, value, message);
	}

	public GenericResponse(int currentPage, int totalPage, int totalRow,
			int currentRowCount, int listType, ArrayList<T> objects) {
		super();
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.totalRow = totalRow;
		this.currentRowCount = currentRowCount;
		this.listType = listType;
		this.objects = objects;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getCurrentRowCount() {
		return currentRowCount;
	}

	public void setCurrentRowCount(int currentRowCount) {
		this.currentRowCount = currentRowCount;
	}

	public int getListType() {
		return listType;
	}

	public void setListType(int listType) {
		this.listType = listType;
	}

	public ArrayList<T> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<T> objects) {
		this.objects = objects;
	}

	
	
}
