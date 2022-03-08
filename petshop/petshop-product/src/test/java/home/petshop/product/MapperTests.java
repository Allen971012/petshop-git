package home.petshop.product;

import home.petshop.commons.model.Product;
import home.petshop.product.mapper.ProductMapper;
import home.petshop.product.mapper.PromotionMapper;
import home.petshop.product.mapper.TagMapper;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductVo;
import home.petshop.product.vo.PromotionsVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private PromotionMapper promotionMapper;

    @Resource
    private TagMapper tagMapper;

    @Test
    public void testMapper(){
        log.debug("{}",productMapper);
        log.debug("{}",promotionMapper);
        log.debug("{}",tagMapper);
    }

    @Test
    public void testGetAllProduct(){
        List<CommodityVo> products = productMapper.selectAllProduct();
        products.forEach(product -> log.debug("{}",product));
    }

    @Test
    public void testAllProductCount(){
        Integer count = productMapper.AllProductCount();
        log.debug("count:{}",count);
    }

    @Test
    public void testAllPromotionCount(){
        List<CommodityVo> promotions = promotionMapper.getAllPromotionsProduct();
        promotions.forEach(promotionsVo -> log.debug("{}",promotionsVo));
    }

    @Test
    public void testGetAllProductVo(){
        List<ProductVo> product = productMapper.selectAllProductVo();
        product.forEach(productVo -> log.debug("product:{}",productVo));
    }
}
