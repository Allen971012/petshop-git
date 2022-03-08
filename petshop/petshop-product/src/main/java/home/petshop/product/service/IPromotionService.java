package home.petshop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import home.petshop.commons.model.Promotion;
import home.petshop.product.vo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
public interface IPromotionService extends IService<Promotion> {

    /*
    用於顯示首頁特價商品
     */
    List<PromotionVo> getIndexPromotionProduct();

    /*
    顯示右側特價商品
     */
    List<ProductRightVo> getRightPromotion();

    /*
    用於顯示全部特價商品
     */
    PageInfo<PromotionVo> getAllPromotionProduct(Integer pageNum , Integer pageSize);

    /*
    顯示特價詳細商品
     */
    PromotionDetailVo getPromotionDetail(Integer id);

    /*
    返回特價商品數量
     */
    Integer getPromotionCount();

    /*
    返回全部特價商品->search模塊存到ES
     */
    PageInfo<CommodityVo> getPromotions(Integer pageNum , Integer pageSize);
}
