package com.example.demo.domain;

/**
 * 购物项
 */
public class CartItem {
    //商品
    private Goods goods;

    //小计
    private Double subtotal;

    //数量
    private Integer count;

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getSubtotal() {
        return count * Double.parseDouble(goods.getPrice());
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public CartItem(Goods goods,Integer count) {
        this.goods = goods;
        this.count = count;
    }
}
