package home.petshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import home.petshop.product.mapper.ProductMapper;
import home.petshop.commons.model.Product;
import home.petshop.product.service.IProductService;
import home.petshop.commons.service.ServiceException;
import home.petshop.product.utils.PageInfoUtils;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductDetailVo;
import home.petshop.product.vo.ProductRightVo;
import home.petshop.product.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
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
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private RestTemplate restTemplate;

    //獲取首頁熱門商品
    public List<ProductVo> getIndexPopular() {
        List<ProductVo> products = productMapper.getPopularProduct();
        return products;
    }

    //獲取右側熱門商品
    public List<ProductRightVo> getRightPopular() {
        List<ProductRightVo> productRightVos = productMapper.getRightPopularProduct();
        return productRightVos;
    }

    //獲取飼料商品
    public PageInfo<ProductVo> getFoodProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("food",pageNum,pageSize);
        return products;
    }

    //獲取零食商品
    public PageInfo<ProductVo> getSnackProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("snack",pageNum,pageSize);
        return products;
    }

    //獲取罐罐商品
    public PageInfo<ProductVo> getCanProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("can",pageNum,pageSize);
        return products;
    }

    //獲取玩具商品
    public PageInfo<ProductVo> getToyProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("toy",pageNum,pageSize);
        return products;
    }

    //獲取外出用品商品
    public PageInfo<ProductVo> getOutdoorProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("outdoor",pageNum,pageSize);
        return products;
    }

    //獲取美容商品
    public PageInfo<ProductVo> getPrettyProduct(Integer pageNum, Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> products = getProductByType("pretty",pageNum,pageSize);
        return products;
    }

    //獲取飼料商品(狗)
    public List<ProductVo> getDogFoodProduct() {
        List<ProductVo> products = getProductsByType("dog","food");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取零食商品(狗)
    public List<ProductVo> getDogSnackProduct() {
        List<ProductVo> products = getProductsByType("dog","snack");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取罐罐商品(狗)
    public List<ProductVo> getDogCanProduct() {
        List<ProductVo> products = getProductsByType("dog","can");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取玩具商品(狗)
    public List<ProductVo> getDogToyProduct() {
        List<ProductVo> products = getProductsByType("dog","toy");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取外出商品(狗)
    public List<ProductVo> getDogOutdoorProduct() {
        List<ProductVo> products = getProductsByType("dog","outdoor");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取美容商品(狗)
    public List<ProductVo> getDogPrettyProduct() {
        List<ProductVo> products = getProductsByType("dog","pretty");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取飼料(貓)
    public List<ProductVo> getCatFoodProduct() {
        List<ProductVo> products = getProductsByType("cat","food");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取零食(貓)
    public List<ProductVo> getCatSnackProduct() {
        List<ProductVo> products = getProductsByType("cat","snack");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取罐罐(貓)
    public List<ProductVo> getCatCanProduct() {
        List<ProductVo> products = getProductsByType("cat","can");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取玩具(貓)
    public List<ProductVo> getCatToyProduct() {
        List<ProductVo> products = getProductsByType("cat","toy");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取美容商品(貓)
    public List<ProductVo> getCatPrettyProduct() {
        List<ProductVo> products = getProductsByType("cat","pretty");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取外出用品
    public List<ProductVo> getCatOutdoorProduct() {
        List<ProductVo> products = getProductsByType("cat","outdoor");
        List<ProductVo> productVos = products.subList(0,8);
        return productVos;
    }

    //獲取完整熱門商品(按照點擊排序)
    public PageInfo<ProductVo> getAllPopularProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> products = productMapper.getAllPopularProduct();
        return new PageInfo<ProductVo>(products);
    }

    //獲取完整飼料商品(狗)
    public PageInfo<ProductVo> getAllDogFoodProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","food",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整零食商品(狗)
    public PageInfo<ProductVo> getAllDogSnackProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","snack",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整罐罐商品(狗)
    public PageInfo<ProductVo> getAllDogCanProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","can",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整玩具商品(狗)
    public PageInfo<ProductVo> getAllDogToyProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","toy",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整外出商品(狗)
    public PageInfo<ProductVo> getAllDogOutdoorProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","outdoor",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整美容商品(狗)
    public PageInfo<ProductVo> getAllDogPrettyProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("dog","pretty",pageNum,pageSize);
        return pageInfo;
    }
    //獲取完整飼料商品(貓)
    public PageInfo<ProductVo> getAllCatFoodProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","food",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整零食商品(貓)
    public PageInfo<ProductVo> getAllCatSnackProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","snack",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整罐罐商品(貓)
    public PageInfo<ProductVo> getAllCatCanProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","can",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整玩具商品(貓)
    public PageInfo<ProductVo> getAllCatToyProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","toy",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整美容商品(貓)
    public PageInfo<ProductVo> getAllCatPrettyProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","pretty",pageNum,pageSize);
        return pageInfo;
    }

    //獲取完整外出商品(貓)
    public PageInfo<ProductVo> getAllCatOutdoorProduct(Integer pageNum , Integer pageSize) {
        if(pageNum==null || pageSize==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        PageInfo<ProductVo> pageInfo = getProductsByTypePage("cat","outdoor",pageNum,pageSize);
        return pageInfo;
    }

    //根據id獲得產品詳情
    public ProductDetailVo getProductDetail(Integer id) {
        if(id==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        ProductDetailVo product = productMapper.getProductDetail(id);
        return product;
    }

    //進入商品詳情頁clickCount+1
    public void addClickCount(Integer productId) {
        if(productId==null){
            throw ServiceException.invalidRequest("參數不能為空");
        }
        //查出目前clickCount
        Integer clickCount = productMapper.selectClickCountById(productId);
        if(clickCount==null){
            throw ServiceException.invalidRequest("clickCount不能為空");
        }
        //將clickCount+1
        clickCount += 1;
        int rows = productMapper.addClickCount(clickCount,productId);
        if(rows!=1){
            throw new ServiceException("服務器繁忙,請稍後再試");
        }
        log.debug("Service addClickCount 增加clickCount完成");
    }

    //返回一頁Product數據
    public PageInfo<CommodityVo> getProducts(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        List<CommodityVo> list = productMapper.selectAllProduct();
        return new PageInfo<>(list);
    }

    //返回所有商品數量(不含特價商品)
    public Integer getAllProductCount() {
        Integer count = productMapper.AllProductCount();
        return count;
    }

    //返回一頁Product數據-->優化product模塊模糊查詢使用
    public PageInfo<ProductVo> getProductVos(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<ProductVo> product = productMapper.selectAllProductVo();
        return new PageInfo<>(product);
    }
    /*
    按照種類查詢商品(分頁)
     */
    public PageInfo<ProductVo> getProductByType(String type , Integer pageNum , Integer pageSize) {
        if(type==null){
            type="";
        }
        String url = "http://search-service/v1/product/type?type={1}";
        ProductVo[] products = restTemplate.getForObject(url,ProductVo[].class,type);
        List<ProductVo> productVos = Arrays.asList(products);
        PageInfo<ProductVo> pageInfo = PageInfoUtils.list2PageInfo(productVos,pageNum,pageSize);
        return pageInfo;
    }

    /*
    按照種類查詢商品(不分頁)
     */
    public List<ProductVo> getProductsByType(String type01,String type02) {
        if(type01==null){
            type01="";
        }
        if(type02==null){
            type02="";
        }
        String url = "http://search-service/v1/product/types?type01={1}&type02={2}";
        ProductVo[] products = restTemplate.getForObject(url,ProductVo[].class,type01,type02);
        List<ProductVo> productVos = Arrays.asList(products);
        return productVos;
    }

    //按照多種種類查詢 分頁
    public PageInfo<ProductVo> getProductsByTypePage(String type01, String type02, Integer pageNum, Integer pageSize) {
        if(type01==null){
            type01="";
        }
        if(type02==null){
            type02="";
        }
        String url = "http://search-service/v1/product/types?type01={1}&type02={2}";
        ProductVo[] products = restTemplate.getForObject(url,ProductVo[].class,type01,type02);
        List<ProductVo> productVos = Arrays.asList(products);
        PageInfo<ProductVo> pageInfo = PageInfoUtils.list2PageInfo(productVos,pageNum,pageSize);
        return pageInfo;
    }
}
