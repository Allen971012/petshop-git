package home.petshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import home.petshop.product.mapper.PromotionMapper;
import home.petshop.commons.model.Promotion;
import home.petshop.product.service.IPromotionService;
import home.petshop.commons.service.ServiceException;
import home.petshop.product.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionMapper, Promotion> implements IPromotionService {

    @Autowired
    private PromotionMapper promotionMapper;

    /*
    獲取首頁特價商品
     */
    public List<PromotionVo> getIndexPromotionProduct() {
        List<PromotionVo> promotionVos = promotionMapper.getIndexPromotionProduct();
        return promotionVos;
    }

    /*
    獲取右側特價商品
     */
    public List<ProductRightVo> getRightPromotion() {
        List<ProductRightVo> products = promotionMapper.getRightPromotion();
        return products;
    }

    /*
    獲取全部特價商品
     */
    public PageInfo<PromotionVo> getAllPromotionProduct(Integer pageNum , Integer pageSize) {
        List<PromotionVo> products = promotionMapper.getAllPromotionProduct();
        return new PageInfo<PromotionVo>(products);
    }

    /*
    詳細特價商品
     */
    public PromotionDetailVo getPromotionDetail(Integer id) {
        if(id==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PromotionDetailVo p = promotionMapper.getPromotionDetail(id);
        return p;
    }

    /*
    返回特價商品數量
     */
    public Integer getPromotionCount() {
        Integer count = promotionMapper.getPromotionCount();
        return count;
    }

    /*
    返回全部特價商品->search模塊存到ES
     */
    public PageInfo<CommodityVo> getPromotions(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CommodityVo> promotionsVo = promotionMapper.getAllPromotionsProduct();
        return new PageInfo<>(promotionsVo);
    }
}
