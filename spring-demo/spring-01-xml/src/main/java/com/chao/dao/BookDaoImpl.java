package com.chao.dao;

public class BookDaoImpl implements BookDao{
    /**
     * setter简单类型注入
     */
    private int connectionNum;
    @Override
    public void say() {
        System.out.println("BookDao say..."+connectionNum);
    }

    public void setConnectionNum(int connectionNum) {
        this.connectionNum = connectionNum;
    }
}
