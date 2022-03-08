package home.petshop.search.service.impl;

import com.github.pagehelper.PageInfo;
import home.petshop.search.mapper.ProductVosRepository;
import home.petshop.search.service.IProductService;
import home.petshop.search.utils.Pages;
import home.petshop.search.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private ProductVosRepository productVosRepository;

    public void sync() {
        String url = "http://product-service/v1/product/page/count?pageSize={1}";
        Integer pageSize = 10;
        Integer pages = restTemplate.getForObject(url,Integer.class,pageSize);
        log.debug("共有:{}頁",pages);
        for(int i=1 ; i<=pages ; i++){
            url = "http://product-service/v1/product/page/productVo?pageNum={1}&pageSize={2}";
            ProductVo[] productVos = restTemplate.getForObject(url,ProductVo[].class,i,pageSize);
            productVosRepository.saveAll(Arrays.asList(productVos));
            log.debug("save page:{}",i);
        }
    }

    /*
    按照type查詢商品
     */
    public List<ProductVo> getProductByType(String type) {
        Pageable pageable = PageRequest.of(0,200);
        Page<ProductVo> page = productVosRepository.queryProductVoByType(type , pageable);
        PageInfo<ProductVo> pageInfo = Pages.pageInfo(page);
        List<ProductVo> products = pageInfo.getList();
        return products;
    }

    /*
    兩個type查詢商品
     */
    public List<ProductVo> getProductsByType(String type01, String type02) {
        Pageable pageable = PageRequest.of(0,200);
        Page<ProductVo> page = productVosRepository.queryProductsVoByType(type01,type02,pageable);
        PageInfo<ProductVo> pageInfo = Pages.pageInfo(page);
        List<ProductVo> products = pageInfo.getList();
        return products;
    }
}
