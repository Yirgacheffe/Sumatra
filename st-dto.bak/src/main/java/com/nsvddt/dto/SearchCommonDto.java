package cn.com.nsv.ejb.dto;


public class SearchCommonDto implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    private String sortId;

    private String sortOrder;

    private Integer start = 0;

    private Integer pageSize = 10;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
