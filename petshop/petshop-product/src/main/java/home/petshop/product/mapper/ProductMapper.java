package home.petshop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.Product;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductDetailVo;
import home.petshop.product.vo.ProductRightVo;
import home.petshop.product.vo.ProductVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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
    public interface ProductMapper extends BaseMapper<Product> {

        //獲取產品id,title,price,img 用於顯示首頁熱門商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p " +
                "LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status IS NULL OR pm.status!=0 " +
                "ORDER BY p.click_count DESC LIMIT 0,8")
        public List<ProductVo> getPopularProduct();

        //獲取產品id,title 用於顯示右側熱門商品欄
        @Select("SELECT p.id,p.title,pm.status FROM product p " +
                "LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status IS NULL OR pm.status!=0 " +
                "ORDER BY p.click_count DESC LIMIT 0,5")
        public List<ProductRightVo> getRightPopularProduct();


        //獲取飼料商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%food%'")
        public List<ProductVo> getFoodProduct();

        //獲取零食商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%snack%'")
        public List<ProductVo> getSnackProduct();

        //獲取罐罐商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%can%'")
        public List<ProductVo> getCanProduct();

        //獲取玩具商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%toy%'")
        public List<ProductVo> getToyProduct();

        //獲取美容商品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%pretty%'")
        public List<ProductVo> getPrettyProduct();

        //獲取外出用品
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%outdoor%'")
        public List<ProductVo> getOutdoorProduct();

        //獲取飼料(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%food%' LIMIT 0,8")
        public List<ProductVo> getDogFoodProduct();

        //獲取零食(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%snack%' LIMIT 0,8")
        public List<ProductVo> getDogSnackProduct();

        //獲取罐罐(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%can%' LIMIT 0,8")
        public List<ProductVo> getDogCanProduct();

        //獲取玩具(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%toy%' LIMIT 0,8")
        public List<ProductVo> getDogToyProduct();

        //獲取外出商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%outdoor%' LIMIT 0,8")
        public List<ProductVo> getDogOutdoorProduct();

        //獲取美容商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%pretty%' LIMIT 0,8")
        public List<ProductVo> getDogPrettyProduct();

         //獲取飼料(貓)
         @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%food%' LIMIT 0,8")
         public List<ProductVo> getCatFoodProduct();

         //獲取零食(貓)
         @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%snack%' LIMIT 0,8")
         public List<ProductVo> getCatSnackProduct();

         //獲取罐罐(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%can%' LIMIT 0,8")
         public List<ProductVo> getCatCanProduct();

        //獲取玩具(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%toy%' LIMIT 0,8")
        public List<ProductVo> getCatToyProduct();

        //獲取外出商品(貓)
         @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%outdoor%' LIMIT 0,8")
         public List<ProductVo> getCatOutdoorProduct();

        //獲取美容商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%pretty%' LIMIT 0,8")
        public List<ProductVo> getCatPrettyProduct();

        //獲取完整熱門商品(按照點擊次數排序)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p " +
                "LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status IS NULL OR pm.status!=0 " +
                "ORDER BY p.click_count DESC")
        public List<ProductVo> getAllPopularProduct();

        //獲取完整飼料商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%food%'")
        public List<ProductVo> getAllDogFoodProduct();

        //獲取完整零食商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%snack%'")
        public List<ProductVo> getAllDogSnackProduct();

        //獲取完整罐罐商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%can%'")
        public List<ProductVo> getAllDogCanProduct();

        //獲取完整玩具商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%toy%'")
         public List<ProductVo> getAllDogToyProduct();

        //獲取完整外出商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%dog%outdoor%'")
         public List<ProductVo> getAllDogOutdoorProduct();

        //獲取完整美容商品(狗)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                 "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                 "p.img like '%dog%pretty%'")
         public List<ProductVo> getAllDogPrettyProduct();

         //獲取完整飼料商品(貓)
         @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%food%'")
         public List<ProductVo> getAllCatFoodProduct();

        //獲取完整零食商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%snack%'")
        public List<ProductVo> getAllCatSnackProduct();

        //獲取完整罐罐商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%can%'")
        public List<ProductVo> getAllCatCanProduct();

        //獲取完整玩具商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%toy%'")
        public List<ProductVo> getAllCatToyProduct();

        //獲取完整外出商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%outdoor%'")
        public List<ProductVo> getAllCatOutdoorProduct();

        //獲取完整美容商品(貓)
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0) AND " +
                "p.img like '%cat%pretty%'")
         public List<ProductVo> getAllCatPrettyProduct();

        //根據商品id獲取商品詳情
        @Select("SELECT id,title,price,content,img FROM product\n" +
                "WHERE id=#{id}")
        public ProductDetailVo getProductDetail(Integer id);

        //進入商品詳情頁後該商品click_count+1
        @Update("UPDATE product set click_count=#{clickCount} WHERE id=#{productId}")
        public int addClickCount(@Param("clickCount") Integer clickCount , @Param("productId") Integer productId);

        //根據productId獲取countClick
        @Select("SELECT click_count FROM product WHERE id=#{productId}")
        public Integer selectClickCountById(Integer productId);


        //獲得所有商品(不包含特價商品)-->完成搜索業務需求
        @Select("SELECT p.id,p.title,p.price,p.img,p.click_count,pm.status,pm.price AS oprice " +
                "FROM product p LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status IS NULL OR pm.status!=0")
        public List<CommodityVo> selectAllProduct();

        //所有商品數量(不包含特價商品)
        @Select("SELECT count(*) " +
                "FROM product p LEFT JOIN promotion pm ON p.id=pm.product_id " +
                "WHERE pm.status IS NULL OR pm.status!=0")
        public Integer AllProductCount();

        //獲得所有商品(不包含特價商品)-->優化product模塊模糊查詢需求
        @Select("SELECT p.id,p.title,p.price,p.img,pm.status FROM product p LEFT JOIN " +
                "promotion pm ON p.id=pm.product_id WHERE (pm.status IS NULL OR pm.status!=0)")
        public List<ProductVo> selectAllProductVo();


    }
