package home.petshop.product;

import com.github.pagehelper.PageInfo;
import home.petshop.commons.model.Product;
import home.petshop.commons.model.Tag;
import home.petshop.commons.model.User;
import home.petshop.product.service.IProductService;
import home.petshop.product.service.IPromotionService;
import home.petshop.product.service.ITagService;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductVo;
import home.petshop.product.vo.PromotionVo;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class ServiceTests {

    @Resource
    private ITagService tagService;

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private IPromotionService promotionService;

    @Resource
    private IProductService productService;

    @Test
    public void testGetTags(){
        List<Tag> tags = tagService.getTags();
        tags.forEach(tag -> log.debug("Tags:{}",tag));
    }

    @Test
    public void testGetIndexPromotion(){
        List<PromotionVo> promotions = promotionService.getIndexPromotionProduct();
        promotions.forEach(promotionVo -> log.debug("promotionVo:{}",promotionVo));
    }

    @Test
    public void testRibbon(){
        String url = "http://sys-service/v1/auth/users";
        User user = restTemplate.getForObject(url,User.class);
        log.debug("user:{}",user);
    }

    @Test
    public void testGetProduct(){
        PageInfo<CommodityVo> pageInfo = productService.getProducts(1,10);
        pageInfo.getList().forEach(product -> log.debug("{}",product));
        log.debug("{}",pageInfo);
    }

    @Test
    public void testGetAllProductCount(){
        Integer count = productService.getAllProductCount();
        log.debug("count:{}",count);
    }

    @Test
    public void testGetPromotion(){
        PageInfo<CommodityVo> pageInfo = promotionService.getPromotions(1,10);
        pageInfo.getList().forEach(product -> log.debug("{}",product));
        log.debug("{}",pageInfo);
    }

    @Test
    public void testGetProductVos(){
        PageInfo<ProductVo> pageInfo = productService.getProductVos(1,10);
        pageInfo.getList().forEach(product -> log.debug("{}",product));
        log.debug("{}",pageInfo);
    }

    @Test
    public void test(){
        String type01 = "cat";
        String type02 = "food";
        Integer pageNum = 1;
        Integer pageSize = 10;
        PageInfo<ProductVo> foods = productService.getProductsByTypePage(type01,type02,pageNum,pageSize);
        foods.getList().forEach(productVo -> log.debug("product:{}",productVo));
    }

    @Test
    public void test02(){
        String type01 = "dog";
        String type02 = "food";
        List<ProductVo> productVos = productService.getProductsByType(type01,type02);
        productVos.forEach(productVo -> log.debug("product:{}",productVo));
    }

    @Test
    public void test03(){
        PageInfo<ProductVo> pageInfo = productService.getFoodProduct(3,16);
        log.debug("pageinfo:{}",pageInfo);
        pageInfo.getList().forEach(productVo -> log.debug("product:{}",productVo));
    }
}
