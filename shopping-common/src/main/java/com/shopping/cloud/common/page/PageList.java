package com.shopping.cloud.common.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 彭宁
 * @Descritioon: 分页类
 * @Date: 2017/11/13 10:41
 **/
@ApiModel(value = "分页")
public class PageList<T> implements Serializable {

    private static final long serialVersionUID = -2949497622293336316L;

    /**
     * 当前页 默认1
     */
    @ApiModelProperty("当前页 默认1")
    private Integer currentPage;
    /**
     * 总记录数
     */
    @ApiModelProperty("总记录数")
    private int totalCount;
    /**
     * 总页数
     */
    @ApiModelProperty("总页数")
    private int totalPage;
    /**
     * 页大小
     */
    @ApiModelProperty("页大小")
    private Integer pageSize;
    /**
     * 当前页中存放的数据
     */
    @ApiModelProperty("当前页中存放的数据")
    private List<T> records = new ArrayList<T>();

    /**
     * 开始
     */
    @ApiModelProperty("开始")
    private int startIndex;

    /**
     * 构造方法，构造空数
     */
    public PageList() {
        this(1,0, 10, new ArrayList<T>());
    }

    /**
     * 带参数构造方法
     * @param currentPage
     *         当前页
     * @param totalCount
     * 			总记录行数
     * @param pageSize
     * 			当前页大中
     * @param records
     * 			当前页记录数据
     */
    public PageList(Integer currentPage, int totalCount, int pageSize, List<T> records){
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.records = records;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        if(currentPage == null || currentPage < 1) currentPage = 1;
        this.currentPage = currentPage;
        this.startIndex = (this.currentPage - 1) * pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if(pageSize == null || pageSize < 1) pageSize = 10;
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        if(this.totalCount % pageSize == 0){
            totalPage = totalCount / pageSize;
        }else{
            totalPage = totalCount / pageSize + 1;
        }
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public int getStartIndex() {
        return startIndex;
    }
}

