package com.wangxin.ssm.product.controller;

import com.wangxin.ssm.product.model.Product;
import com.wangxin.ssm.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/productlist")
    public String productList(Model model){
        //调⽤服务接⼝,获得数据
        List<Product> list = productService.findAllProduct();
        //把数据放进model,传递给⻚⾯展现
        model.addAttribute("productlist",list);
        //跳转到展现⻚⾯f
        return "/jsp/product/product_list";
    }
    @GetMapping("/toproductadd")
    public String toProductAdd(Model model){
        //跳转到添加⻚⾯
        return "/jsp/product/product_add";
    }
    @PostMapping("/productadd")
    public String productAdd(Product product, Model model){
        //调⽤服务接⼝,添加数据
        productService.addProduct(product);
        //重定向到列表url
        return "redirect:productlist";
    }
    //响应修改按钮
    @GetMapping("/toproductedit")
    public String toProductEdit(int productId,Model model){
        //调⽤服务接⼝,通过id查询获得数据
        Product product = productService.findProductById(productId);
        //把数据放进model,传递给⻚⾯展现
        model.addAttribute("product", product);
        //跳转到修改⻚⾯
        return "/jsp/product/product_edit";
    }
    //响应修改页面的保存按钮
    @PostMapping("/productedit")
    public String productEdit(Product product, Model model){
        //调⽤服务接⼝,更新数据
        productService.updateProduct(product);
        //重定向到列表url
        return "redirect:productlist";
    }
    @RequestMapping("/productdelete")
    public String productDelete(int productId){
        //调⽤服务接⼝,删除
        productService.deleteProduct(productId);
        //重定向到列表url
        return "redirect:productlist";
    }
}
