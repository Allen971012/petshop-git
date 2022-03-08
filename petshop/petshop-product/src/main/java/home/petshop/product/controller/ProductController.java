package home.petshop.product.controller;


import com.github.pagehelper.PageInfo;
import home.petshop.commons.model.Product;
import home.petshop.commons.vo.R;
import home.petshop.product.service.IProductService;
import home.petshop.product.service.IPromotionService;
import home.petshop.product.vo.CommodityVo;
import home.petshop.product.vo.ProductDetailVo;
import home.petshop.product.vo.ProductRightVo;
import home.petshop.product.vo.ProductVo;
import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private IPromotionService promotionService;

    //獲取首頁熱門商品
    @GetMapping("/popular")
    public R<List<ProductVo>> getPopularProduct(){
        List<ProductVo> products = productService.getIndexPopular();
        return R.ok(products);
    }

    //獲取右側熱門商品導航
    @GetMapping("/popular/right")
    public R<List<ProductRightVo>> getRightPopularProduct(){
        List<ProductRightVo> products = productService.getRightPopular();
        return R.ok(products);
    }

    //根據參數type獲取商品
    @GetMapping("/{type}")
    public R<ProductVo> getProductByType(@PathVariable String type ,Integer pageNum){
        log.debug("type:{}",type);
        if(pageNum==null){
            pageNum=1;
        }
        Integer pageSize = 16;
        if("food".equals(type)) {
            PageInfo<ProductVo> products = productService.getFoodProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("snack".equals(type)){
            PageInfo<ProductVo> products = productService.getSnackProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("can".equals(type)){
            PageInfo<ProductVo> products = productService.getCanProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("toy".equals(type)){
            PageInfo<ProductVo> products = productService.getToyProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("outdoor".equals(type)){
            PageInfo<ProductVo> products = productService.getOutdoorProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("pretty".equals(type)){
            PageInfo<ProductVo> products = productService.getPrettyProduct(pageNum, pageSize);
            return R.ok(products);
        }else if("populars".equals(type)){
            PageInfo<ProductVo> products = productService.getAllPopularProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogfood".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogFoodProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogsnack".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogSnackProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogcan".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogCanProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogtoy".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogToyProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogoutdoor".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogOutdoorProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("dogpretty".equals(type)){
            PageInfo<ProductVo> products = productService.getAllDogPrettyProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("catfood".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatFoodProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("catsnack".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatSnackProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("catcan".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatCanProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("cattoy".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatToyProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("catoutdoor".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatOutdoorProduct(pageNum,pageSize);
            return R.ok(products);
        }else if("catpretty".equals(type)){
            PageInfo<ProductVo> products = productService.getAllCatPrettyProduct(pageNum,pageSize);
            return R.ok(products);
        }
        return R.unprocesableEntity("type為空");
    }

    //根據貓狗獲取food
    @GetMapping("/food/{species}")
    public R<ProductVo> getProductBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogFoodProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatFoodProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //根據貓狗獲取snack
    @GetMapping("/snack/{species}")
    public R<ProductVo> getSnackBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogSnackProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatSnackProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //根據貓狗獲取can
    @GetMapping("/can/{species}")
    public R<ProductVo> getCanBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogCanProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatCanProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //根據貓狗獲取toy
    @GetMapping("/toy/{species}")
    public R<ProductVo> getToyBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogToyProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatToyProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //根據貓狗獲取outdoor
    @GetMapping("/outdoor/{species}")
    public R<ProductVo> getOutdoorBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogOutdoorProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatOutdoorProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //根據貓狗獲取美容商品
    @GetMapping("/pretty/{species}")
    public R<ProductVo> getPrettyBySpecies(@PathVariable String species){
        if("dog".equals(species)){
            List<ProductVo> products = productService.getDogPrettyProduct();
            return R.ok(products);
        }else if("cat".equals(species)){
            List<ProductVo> products = productService.getCatPrettyProduct();
            return R.ok(products);
        }
        return R.unprocesableEntity("species為空");
    }

    //獲取前端參數id返回產品詳情
    @GetMapping("/detail/{id}")
    public R<ProductDetailVo> getProductDetail(@PathVariable Integer id){
        if(id==null){
            return R.invalidRequest("id不能為空");
        }
        ProductDetailVo product = productService.getProductDetail(id);
        return R.ok(product);
    }

    //獲取productId增加該商品clickCount
    @GetMapping("/addClickCount/{id}")
    public R addClickCountById(@PathVariable Integer id){
        log.debug("進入ProductController addClickCount");
        if(id==null){
            return R.invalidRequest("id不能為空");
        }
        productService.addClickCount(id);
        return R.ok("clickCount+1");
    }

    //返回數據頁數
    @GetMapping("/page/count")
    public Integer pageCount(Integer pageSize){
        Integer count = productService.getAllProductCount();
        return count%pageSize==0 ? count/pageSize : count/pageSize+1;
    }

    //返回一頁數據(商品)
    @GetMapping("/page")
    public List<CommodityVo> products(Integer pageNum , Integer pageSize){
        PageInfo<CommodityVo> pageInfo = productService.getProducts(pageNum,pageSize);
        return pageInfo.getList();
    }

    //返回一頁數據(productVo)-->優化查詢使用
    @GetMapping("/page/productVo")
    public List<ProductVo> productVos(Integer pageNum , Integer pageSize){
        PageInfo<ProductVo> pageInfo = productService.getProductVos(pageNum,pageSize);
        return pageInfo.getList();
    }





}
