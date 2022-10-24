package com.wangxin.ssm.product.service.impl;

import com.wangxin.ssm.product.dao.ProductMapper;
import com.wangxin.ssm.product.model.Product;
import com.wangxin.ssm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper mapper;

    @Override
    public void addProduct(Product product) {
        mapper.addProduct(product);
    }

    @Override
    public void deleteProduct(int productId) {
        mapper.deleteProduct(productId);
    }

    @Override
    public void updateProduct(Product product) {
        mapper.updateProduct(product);
    }

    @Override
    public Product findProductById(int productId) {
        return mapper.findProductById(productId);
    }

    @Override
    public List<Product> findAllProduct() {
        return mapper.findAllProduct();
    }
}
