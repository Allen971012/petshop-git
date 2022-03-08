package home.petshop.search.service;

import com.github.pagehelper.PageInfo;
import home.petshop.search.vo.CommodityVo;

public interface ICommodityService {

    void sync();

    PageInfo<CommodityVo> search(String title , Integer pageNum , Integer pageSize);
}
