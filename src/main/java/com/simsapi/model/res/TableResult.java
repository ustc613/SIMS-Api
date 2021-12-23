package com.simsapi.model.res;

import lombok.Data;

import java.util.List;

@Data
public class TableResult<T> {
    private List<T> rows;
    private Integer totalCount;
    private Integer pageCount;

    public void setPageCount(Integer pageSize){
        if(pageSize==null){
            return;
        }
        if(totalCount%pageSize==0){
            this.pageCount = totalCount/pageSize;
        }else{
            this.pageCount = totalCount/pageSize+1;
        }
    }
}
