package com.simsapi.model.res;

import lombok.Data;

import java.util.List;

@Data
public class StudentPersonalResult<T,C> {
    List<T> studentRows;
    List<C> courseRows;
    private Double average;
}
