package cn.itcast.em.sdk.vo;

import java.util.Collections;
import java.util.List;

public class PageResult<T> {

    private Integer total = 0;//总记录数
    private Integer pageSize = 0; //页面大小
    private Integer pageCount = 0; //总页数
    private Integer page = 0; //当前页码
    private List<T> items = Collections.emptyList(); //数据列表

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageResult{");
        sb.append("total=").append(total);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", pageCount=").append(pageCount);
        sb.append(", page=").append(page);
        sb.append(", items=").append(items);
        sb.append('}');
        return sb.toString();
    }
}