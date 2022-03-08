package home.petshop.search.service.impl;

import com.github.pagehelper.PageInfo;
import home.petshop.search.mapper.CommodityRepository;
import home.petshop.search.service.ICommodityService;
import home.petshop.search.utils.Pages;
import home.petshop.search.vo.CommodityVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;

@Service
@Slf4j
public class CommodityServiceImpl implements ICommodityService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CommodityRepository commodityRepository;

    public void sync() {
        String url = "http://product-service/v1/product/page/count?pageSize={1}";
        int pageSize = 10;
        Integer pages = restTemplate.getForObject(url,Integer.class , pageSize);
        log.debug("total pages:{}",pages);
        for(int i=1 ; i<=pages ; i++){
            url = "http://product-service/v1/product/page?pageNum={1}&pageSize={2}";
            CommodityVo[] products = restTemplate.getForObject(url,CommodityVo[].class,i,pageSize);
            commodityRepository.saveAll(Arrays.asList(products));
            log.debug("save page:{}",i);
            log.debug("一般商品存儲完畢");
        }
        url = "http://product-service/v1/promotion/page/count?pageSize={1}";
        pages = restTemplate.getForObject(url,Integer.class,pageSize);
        log.debug("total pages:{}",pages);
        for(int i=1 ; i<=pages ; i++){
            url = "http://product-service/v1/promotion/page?pageNum={1}&pageSize={2}";
            CommodityVo[] promotions = restTemplate.getForObject(url,CommodityVo[].class,i,pageSize);
            commodityRepository.saveAll(Arrays.asList(promotions));
            log.debug("save page:{}",i);
            log.debug("特價商品存儲完畢");
        }
    }


    public PageInfo<CommodityVo> search(String title, Integer pageNum, Integer pageSize) {
        if(pageNum==null){
            pageNum=1;
        }
        if(pageSize==null){
            pageSize=16;
        }
        int page = pageNum-1;
        int size = pageSize;
        Pageable pageable = PageRequest.of(page,size);
        Page<CommodityVo> p = commodityRepository.queryAllByParams(title,pageable);
        return Pages.pageInfo(p);
    }
}
