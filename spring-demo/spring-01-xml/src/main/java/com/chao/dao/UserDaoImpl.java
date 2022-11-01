package com.chao.dao;

public class UserDaoImpl implements UserDao{
    private String databaseName;

    public UserDaoImpl(String databaseName) {
        this.databaseName = databaseName;
    }

    @Override
    public void say() {
        System.out.println("UserDao say..."+databaseName);
    }
}
