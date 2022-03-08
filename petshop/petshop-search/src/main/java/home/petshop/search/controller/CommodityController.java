package home.petshop.search.controller;

import com.github.pagehelper.PageInfo;
import home.petshop.commons.vo.R;
import home.petshop.search.service.ICommodityService;
import home.petshop.search.service.IProductService;
import home.petshop.search.vo.CommodityVo;
import home.petshop.search.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/v1/commodity")
public class CommodityController {

    @Resource
    private ICommodityService commodityService;

    @Resource
    private IProductService productService;

    @PostMapping("")
    public R<PageInfo<CommodityVo>> search(String title , Integer pageNum){
        if(title == null){
            title = "";
        }
        Integer pageSize = 16;
        PageInfo<CommodityVo> pageInfo = commodityService.search(title , pageNum , pageSize);
        return R.ok(pageInfo);
    }




}
