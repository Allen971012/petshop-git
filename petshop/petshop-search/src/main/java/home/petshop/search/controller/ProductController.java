package home.petshop.search.controller;

import com.github.pagehelper.PageInfo;
import home.petshop.search.service.IProductService;
import home.petshop.search.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {

    @Resource
    private IProductService productService;
    /*
    按照種類返回所有商品
     */
    @GetMapping("/type")
    public List<ProductVo> getProductByFood(String type){
        List<ProductVo> products = productService.getProductByType(type);
        return products;
    }

    /*
    按照多種種類返回所有商品
     */
    @GetMapping("types")
    public List<ProductVo> getProductsByType(String type01 , String type02){
        List<ProductVo> products = productService.getProductsByType(type01,type02);
        return products;
    }
}
