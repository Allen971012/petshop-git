package home.petshop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.Promotion;
import home.petshop.product.vo.*;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author home
* @since 2021-12-27
*/
    @Repository
    public interface PromotionMapper extends BaseMapper<Promotion> {

        /*
        查詢首頁特價商品
         */
        @Select("SELECT pm.id,pm.product_id,pm.expiredate,pm.status,pm.price," +
                "p.title,p.price AS oprice,p.img FROM promotion pm " +
                "LEFT JOIN product p ON pm.product_id=p.id " +
                "LIMIT 0,8")
        public List<PromotionVo> getIndexPromotionProduct();

        /*
        查詢首頁右側特價商品
         */
        @Select("SELECT p.id,p.title,pm.status,pm.product_id FROM product p " +
                "LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status=0 LIMIT 0,5")
        public List<ProductRightVo> getRightPromotion();

        /*
        獲取完整特價商品
         */
        @Select("SELECT pm.id,pm.product_id,pm.expiredate,pm.status,pm.price, " +
                "p.title,p.price AS oprice,p.img FROM promotion pm " +
                "LEFT JOIN product p ON pm.product_id=p.id")
        public List<PromotionVo> getAllPromotionProduct();


        /*
        獲取特價商品詳細資訊
         */
        @Select("SELECT p.id,p.title,p.price AS oprice,p.img,p.content,pm.price " +
                "FROM product p LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE p.id=#{id}")
        public PromotionDetailVo getPromotionDetail(Integer id);

        /*
        獲取特價商品數量
         */
        @Select("SELECT count(*) FROM promotion pm " +
                "LEFT JOIN product p ON pm.product_id=p.id")
        public Integer getPromotionCount();


    /*
    獲取完整特價商品
     */
    @Select("SELECT p.id,p.title,p.price,p.img,p.click_count,pm.status,pm.price AS oprice " +
            "FROM promotion pm " +
            "LEFT JOIN product p ON pm.product_id=p.id")
    public List<CommodityVo> getAllPromotionsProduct();











    }
