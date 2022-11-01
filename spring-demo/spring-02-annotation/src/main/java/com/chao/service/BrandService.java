package com.chao.service;

/**
 * @author Eliot
 */
public interface BrandService {
     void selectAll();

     void selectById(int id);

     boolean checkUrlPassword(String url,String password);
}
