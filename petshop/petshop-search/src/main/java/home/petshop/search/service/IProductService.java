package home.petshop.search.service;

import com.github.pagehelper.PageInfo;
import home.petshop.search.vo.ProductVo;

import java.util.List;

public interface IProductService {
    /*
    同步product到ES
     */
    void sync();


    /*
    按照type查詢商品
     */
    List<ProductVo> getProductByType(String type);

    /*
    兩個type查詢商品
     */
    List<ProductVo> getProductsByType(String type01 , String type02);
}
