package home.petshop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import home.petshop.commons.model.Product;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductDetailVo;
import home.petshop.product.vo.ProductRightVo;
import home.petshop.product.vo.ProductVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
public interface IProductService extends IService<Product> {

    //獲取首頁熱門商品
    public List<ProductVo> getIndexPopular();

    //獲取右側熱門商品
    public List<ProductRightVo> getRightPopular();

    //獲取飼料商品
    public PageInfo<ProductVo> getFoodProduct(Integer pageNum , Integer pageSize);

    //獲取零食商品
    public PageInfo<ProductVo> getSnackProduct(Integer pageNum , Integer pageSize);

    //獲取罐罐商品
    public PageInfo<ProductVo> getCanProduct(Integer pageNum , Integer pageSize);

    //獲取玩具商品
    public PageInfo<ProductVo> getToyProduct(Integer pageNum , Integer pageSize);

    //獲取外出用品商品
    public PageInfo<ProductVo> getOutdoorProduct(Integer pageNum , Integer pageSize);

    //獲取美容商品
    public PageInfo<ProductVo> getPrettyProduct(Integer pageNum , Integer pageSize);

    //獲取飼料商品(狗)
    public List<ProductVo> getDogFoodProduct();

    //獲取零食商品(狗)
    public List<ProductVo> getDogSnackProduct();

    //獲取罐罐商品(狗)
    public List<ProductVo> getDogCanProduct();

    //獲取玩具商品(狗)
    public List<ProductVo> getDogToyProduct();

    //獲取外出用品(狗)
    public List<ProductVo> getDogOutdoorProduct();

    //獲取美容商品(狗)
    public List<ProductVo> getDogPrettyProduct();

    //獲取飼料商品(貓)
    public List<ProductVo> getCatFoodProduct();

    //獲取零食商品(貓)
    public List<ProductVo> getCatSnackProduct();

    //獲取罐罐商品(貓)
    public List<ProductVo> getCatCanProduct();

    //獲取玩具商品(貓)
    public List<ProductVo> getCatToyProduct();

    //獲取外出用品(貓)
    public List<ProductVo> getCatOutdoorProduct();

    //獲取美容商品(貓)
    public List<ProductVo> getCatPrettyProduct();

    //獲取完整熱門商品(按照點擊排序)
    public PageInfo<ProductVo> getAllPopularProduct(Integer pageNum , Integer pageSize);

    //獲取完整飼料商品(狗)
    public PageInfo<ProductVo> getAllDogFoodProduct(Integer pageNum , Integer pageSize);

    //獲取完整零食商品(狗)
    public PageInfo<ProductVo> getAllDogSnackProduct(Integer pageNum , Integer pageSize);

    //獲取完整罐罐商品(狗)
    public PageInfo<ProductVo> getAllDogCanProduct(Integer pageNum , Integer pageSize);

    //獲取完整玩具商品(狗)
    public PageInfo<ProductVo> getAllDogToyProduct(Integer pageNum , Integer pageSize);

    //獲取完整外出商品(狗)
    public PageInfo<ProductVo> getAllDogOutdoorProduct(Integer pageNum , Integer pageSize);

    //獲取完整美容商品(狗)
    public PageInfo<ProductVo> getAllDogPrettyProduct(Integer pageNum , Integer pageSize);

    //獲取完整零食商品(貓)
    public PageInfo<ProductVo> getAllCatSnackProduct(Integer pageNum , Integer pageSize);

    //獲取完整飼料商品(貓)
    public PageInfo<ProductVo> getAllCatFoodProduct(Integer pageNum , Integer pageSize);

    //獲取完整罐罐商品(貓)
    public PageInfo<ProductVo> getAllCatCanProduct(Integer pageNum , Integer pageSize);

    //獲取完整玩具商品(貓)
    public PageInfo<ProductVo> getAllCatToyProduct(Integer pageNum , Integer pageSize);

    //獲取完整外出商品(貓)
    public PageInfo<ProductVo> getAllCatOutdoorProduct(Integer pageNum , Integer pageSize);

    //獲取完整美容商品(貓)
    public PageInfo<ProductVo> getAllCatPrettyProduct(Integer pageNum , Integer pageSize);

    //根據id獲得產品詳情
    public ProductDetailVo getProductDetail(Integer id);

    //進入商品詳情頁clickCount+1
    public void addClickCount(Integer productId);

    //返回一頁Product數據-->search功能使用
    PageInfo<CommodityVo> getProducts(Integer pageNum , Integer pageSize);

    //返回所有商品數量(不含特價商品)
    Integer getAllProductCount();

    //返回一頁Product數據-->優化product模塊模糊查詢使用
    PageInfo<ProductVo> getProductVos(Integer pageNum , Integer pageSize);

    //按照種類查詢商品(分頁)
    PageInfo<ProductVo> getProductByType(String type , Integer pageNum , Integer pageSize);

    //按照多種類查詢商品(不分頁)
    List<ProductVo> getProductsByType(String type01 , String type02);

    //按照多種種類查詢 分頁
    PageInfo<ProductVo> getProductsByTypePage(String type01 , String type02 , Integer pageNum , Integer pageSize);
}
