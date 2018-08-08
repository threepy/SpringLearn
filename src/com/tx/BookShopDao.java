package com.tx;

public interface BookShopDao {
    //根据书号获取单价
    public int findBookPriceByIsbn(String isbn);

    //根据书号更新库存
    public void updateBookStock(String isbn);

    //更新用户的账户余额
    public void updateUserAccount(String username, int price);
}
