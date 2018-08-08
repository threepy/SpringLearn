package com.tx;

import org.springframework.beans.factory.annotation.Autowired;

public class BookShopServiceImpl implements BookShopService {
    @Autowired
    private BookShopDao bookShopDao;


    @Override
    public void purchase(String username, String isbn) {

    }
}
