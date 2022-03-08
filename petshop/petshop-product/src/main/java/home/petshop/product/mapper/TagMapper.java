package home.petshop.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import home.petshop.commons.model.Tag;
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
    public interface TagMapper extends BaseMapper<Tag> {

        @Select("SELECT id,name FROM tag WHERE id NOT IN (1,2) ORDER BY id ASC")
        public List<Tag> getTags();
    }
