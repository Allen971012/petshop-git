package home.petshop.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import home.petshop.commons.model.Tag;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
public interface ITagService extends IService<Tag> {

    /*
    獲取數據庫所有tag對象
     */
    List<Tag> getTags();
}
