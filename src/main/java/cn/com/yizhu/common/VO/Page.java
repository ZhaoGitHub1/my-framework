package cn.com.yizhu.common.VO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页对象
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private int pageSize;
    private long start;
    private List<T> rows;
    private long total;

    public Page() {
        this(0L, 0L, DEFAULT_PAGE_SIZE, new ArrayList());
    }

    public Page(long start, long totalSize, int pageSize, List<T> rows) {
        this.pageSize = 20;
        this.pageSize = pageSize;
        this.start = start;
        this.total = totalSize;
        this.rows = rows;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getTotalPageCount() {
        return this.total % (long)this.pageSize == 0L ? this.total / (long)this.pageSize : this.total / (long)this.pageSize + 1L;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public List<T> getRows() {
        return this.rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public long getPageNo() {
        return this.start / (long)this.pageSize + 1L;
    }

    public boolean hasNextPage() {
        return this.getPageNo() < this.getTotalPageCount() - 1L;
    }

    public boolean hasPreviousPage() {
        return this.getPageNo() > 1L;
    }

    protected static int getStartOfPage(int pageNo) {
        return getStartOfPage(pageNo, 20);
    }

    public static int getStartOfPage(int pageNo, int pageSize) {
        return (pageNo - 1) * pageSize;
    }
}
