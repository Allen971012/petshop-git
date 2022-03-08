package home.petshop.search;

import home.petshop.search.mapper.CommodityRepository;
import home.petshop.search.mapper.ProductVosRepository;
import home.petshop.search.vo.CommodityVo;
import home.petshop.search.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@Slf4j
public class MapperTests {

    @Resource
    private CommodityRepository commodityRepository;

    @Resource
    private ProductVosRepository productVosRepository;

    @Test
    public void testMapper(){
        Pageable pageable = PageRequest.of(1,10);
        Page<CommodityVo> page = commodityRepository.queryAllByParams("犬",pageable);
        page.forEach(commodityVo -> log.debug("commodity:{}",commodityVo));
    }

    @Test
    public void testQueryProductByFood(){
        Pageable pageable = PageRequest.of(0,40);
        Page<ProductVo> page = productVosRepository.queryProductVoByType("food",pageable);
        page.forEach(productVo -> log.debug("product:{}",productVo));
    }

    @Test
    public void testQueryProductByType(){
        Pageable pageable = PageRequest.of(0,200);
        Page<ProductVo> page = productVosRepository.queryProductsVoByType("dog","food",pageable);
        page.forEach(productVo -> log.debug("product:{}",productVo));
    }





}
