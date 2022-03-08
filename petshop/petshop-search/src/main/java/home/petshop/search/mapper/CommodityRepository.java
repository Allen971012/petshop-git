package home.petshop.search.mapper;

import home.petshop.search.vo.CommodityVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommodityRepository extends ElasticsearchRepository<CommodityVo,Integer> {
    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"should\": [\n" +
            "        {\"match\": {\"title\": \"?0\"}}\n" +
            "      ]\n" +
            "    }\n" +
            "  }")
    public Page<CommodityVo> queryAllByParams(String title , Pageable pageable);
}
