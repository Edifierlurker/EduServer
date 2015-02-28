package com.pinke.uni.mobile.protal.common.model;

import java.io.Serializable;
import java.util.List;

/**
 * 门户异步分页对象 本分页对象必须配合页面js才能完成其功能 使用方法：调用分页方法时需要设置pageNo，pageSize 返回分页方法时需要设置：totalCount，pageNo，pageSize，result
 * 查询结果存放在result里
 * 
 * @author zmk
 * 
 */
public class PageParam implements Serializable
{
    private int totalCount = 0;
    // 当前页码
    private int pageNo = 1;
    // 每页大小
    private int pageSize = 0;
    // 查询结果
    private List result;

    private int totalPage;
    // 简易分页条使用
    private int firstIndex = -1;

    /**
     * 获取起始页页码
     * 
     * @return
     */
    public int getPageNo()
    {
        return pageNo;
    }

    /**
     * 设置起始页页码
     * 
     * @param pageNo
     */
    public void setPageNo(int pageNo)
    {
        this.pageNo = pageNo;
    }

    /**
     * 获取当前页显示内容数量
     * 
     * @return
     */
    public int getPageSize()
    {
        return pageSize;
    }

    /**
     * 设置当前页显示内容数量
     * 
     * @param pageSize
     */
    public void setPageSize(int pageSize)
    {
        this.pageSize = pageSize;
    }

    /**
     * 获取记录总条数
     * 
     * @return
     */
    public int getTotalCount()
    {
        return totalCount;
    }

    /**
     * 设置记录总条数
     * 
     * @param totalCount
     */
    public void setTotalCount(int totalCount)
    {
        this.totalCount = totalCount;
    }

    /**
     * 获取第一页
     * 
     * @return
     */
    public int getFirstPage()
    {
        if (totalCount == 0)
        {
            return 0;
        }
        return 1;
    }

    /**
     * 获取总页数
     * 
     * @return
     */
    public int getTotalPage()
    {
        if (totalCount <= 0)
        {
            return 1;
        }
        if (totalCount < pageSize)
        {
            return 1;
        }
        if ((totalCount % pageSize) == 0)
        {
            return totalCount / pageSize;
        }
        return (totalCount / pageSize) + 1;
    }

    /**
     * 获取当前页起始序号，从0开始
     * 
     * @return
     */
    public int getFirstIndex()
    {
        if (firstIndex != -1)
        {
            return firstIndex;
        }
        if (pageNo <= 0 || pageSize <= 0)
        {
            return -1;
        }
        if (pageNo == 1)
        {
            return 0;
        }
        return (pageNo - 1) * pageSize;
    }

    /**
     * 供简易分页条使用，其他情况勿用
     * 
     * @param firstIndex
     */
    public void setFirstIndex(int firstIndex)
    {
        this.firstIndex = firstIndex;
    }

    /**
     * 获取当前页结束序号，序号
     * 
     * @return
     */
    public int getLastIndex()
    {
        if (pageNo <= 0 || pageSize <= 0)
        {
            return -1;
        }
        if (pageNo == 1)
        {
            return pageSize - 1;
        }
        return (pageNo * pageSize) - 1;
    }

    /**
     * 获取查询结果
     * 
     * @return
     */
    public List getResult()
    {
        return result;
    }
    
    public String toString(){
        String str = "";
        str += "_pageNo=" + pageNo;
        str += "_pageSize=" + pageSize + "_";
        return str;
    }
    

    /**
     * 设置查询结果
     * 
     * @param result
     */
    public void setResult(List result)
    {
        this.result = result;
    }

    public void setTotalPage(int totalPage)
    {
        this.totalPage = totalPage;
    }
}
