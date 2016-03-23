package cn.com.nsv.ejb.dto;

import java.util.ArrayList;
import java.util.List;

public class SearchResultDto implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    List<? extends Object> resultList;
    Integer totalCount = 0;
    List<String> messageList = new ArrayList<String>();

    public List<? extends Object> getResultList() {
        return resultList;
    }

    public void setResultList(List<? extends Object> resultList) {
        this.resultList = resultList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

	public List<String> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<String> messageList) {
		this.messageList = messageList;
	}
    
    

}
