package home.petshop.search;


import com.github.pagehelper.PageInfo;
import home.petshop.search.service.ICommodityService;
import home.petshop.search.service.IProductService;
import home.petshop.search.vo.CommodityVo;
import home.petshop.search.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;


@SpringBootTest
@Slf4j
public class ServiceTests {

    @Resource
    private ICommodityService commodityService;

    @Resource
    private IProductService productService;

    @Test
    public void testSync(){
        productService.sync();
        log.debug("over");
    }

    @Test
    public void testSearch(){
        PageInfo<CommodityVo> pageInfo = commodityService.search("犬",1,16);
        pageInfo.getList().forEach(commodityVo -> log.debug("commodity:{}",commodityVo));
    }

    @Test
    public void testGetProductByFood(){
        List<ProductVo> product = productService.getProductsByType("dog","food");
        product.forEach(productVo -> log.debug("product:{}",productVo));
    }

}
