package home.petshop.product.controller;


import com.github.pagehelper.PageInfo;
import home.petshop.commons.vo.R;
import home.petshop.product.service.IPromotionService;
import home.petshop.product.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@RestController
@RequestMapping("/v1/promotion")
public class PromotionController {

    @Autowired
    private IPromotionService promotionService;
    /*
    返回首頁8個特價商品
     */
    @GetMapping("")
    public R<List<PromotionVo>> getIndexPromotionProduct(){
        List<PromotionVo> promotionVos = promotionService.getIndexPromotionProduct();
        return R.ok(promotionVos);
    }

    /*
    返回右側5個特價商品
     */
    @GetMapping("/right")
    public R<List<ProductRightVo>> getRightPromotion(){
        List<ProductRightVo> products = promotionService.getRightPromotion();
        return R.ok(products);
    }

    /*
    返回詳細特價商品
     */
    @GetMapping("/detail/{id}")
    public R<PromotionDetailVo> getPromtionDetail(@PathVariable Integer id){
        if(id==null){
            return R.invalidRequest("id不能為空");
        }
        PromotionDetailVo p = promotionService.getPromotionDetail(id);
        return R.ok(p);
    }

    /*
    返回全部特價商品
     */
    @GetMapping("/all")
    public R<PageInfo<PromotionVo>> getAllPromotionProduct(Integer pageNum){
        if(pageNum==null){
            pageNum = 1;
        }
        Integer pageSize = 16;
        PageInfo<PromotionVo> products = promotionService.getAllPromotionProduct(pageNum,pageSize);
        return R.ok(products);
    }

    /*
    返回全部特價商品->提供給search模塊
     */
    @GetMapping("/page")
    public List<CommodityVo> getAllPromotion(Integer pageNum , Integer pageSize){
        PageInfo<CommodityVo> pageInfo = promotionService.getPromotions(pageNum,pageSize);
        return pageInfo.getList();
    }

    /*
    返回特價商品數量
     */
    @GetMapping("/page/count")
    public Integer getAllPromotionCount(Integer pageSize){
        Integer count = promotionService.getPromotionCount();
        return count%pageSize==0 ? count/pageSize : count/pageSize+1;
    }
}
