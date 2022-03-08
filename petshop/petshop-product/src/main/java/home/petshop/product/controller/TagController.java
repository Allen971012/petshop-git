package home.petshop.product.controller;


import home.petshop.commons.model.Tag;
import home.petshop.commons.vo.R;
import home.petshop.product.service.ITagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/v1/tag")
@Slf4j
public class TagController {

    @Autowired
    private ITagService tagService;

    //獲取所有tag對象
    @GetMapping("")
    public R<List<Tag>> tags(){
        List<Tag> tags = tagService.getTags();
        log.debug("tags:{}",tags);
        return R.ok(tags);
    }
}
