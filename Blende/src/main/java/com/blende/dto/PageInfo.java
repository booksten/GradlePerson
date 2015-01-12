package com.blende.dto;

public class PageInfo {

	public PageInfo(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
    }

    private int page;
    private int pageSize;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSkip(){
        return pageSize*(page - 1);
    }
}
