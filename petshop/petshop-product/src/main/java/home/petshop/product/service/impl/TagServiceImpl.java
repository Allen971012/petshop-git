package home.petshop.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import home.petshop.product.mapper.TagMapper;
import home.petshop.commons.model.Tag;
import home.petshop.product.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author home
 * @since 2021-12-27
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Autowired
    private TagMapper tagMapper;

    //tag緩存集合
    private final List<Tag> tags = new CopyOnWriteArrayList<>();

    //獲取數據庫所有tag對象
    public List<Tag> getTags() {
        if(tags.isEmpty()){
            synchronized (tags){
                if(tags.isEmpty()){
                    tags.addAll(tagMapper.getTags());
                }
            }
        }
        return tags;
    }
}
