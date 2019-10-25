package com.palex.pool.View.pool;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PoolUpdateFilterView {

    public Long id;

    public String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    public Date begin;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    public Date end;

    public String isActive;

}
