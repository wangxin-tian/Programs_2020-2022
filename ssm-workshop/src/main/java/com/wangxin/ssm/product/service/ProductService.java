package com.wangxin.ssm.product.service;

import com.wangxin.ssm.product.model.Product;

import java.util.List;

public interface ProductService {
    //添加
    public void addProduct(Product product);
    //删除
    public void deleteProduct(int productId);
    //修改
    public void updateProduct(Product product);
    // 通过id查询
    public Product findProductById(int productId);
    //查询所有
    public List<Product> findAllProduct();
}
