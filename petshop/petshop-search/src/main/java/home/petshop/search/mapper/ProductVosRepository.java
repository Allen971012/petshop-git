package home.petshop.search.mapper;

import home.petshop.search.vo.ProductVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;




@Repository
public interface ProductVosRepository extends ElasticsearchRepository<ProductVo,Integer> {

    @Query("{\n" +
            "    \"match\": {\n" +
            "      \"img\": \"?0\"\n" +
            "    }\n" +
            "  }")
    Page<ProductVo> queryProductVoByType(String type , Pageable pageable);

    @Query("{\n" +
            "    \"bool\": {\n" +
            "      \"must\": [\n" +
            "        {\"match\": {\"img\": \"?0\"}},\n" +
            "        {\"match\": {\"img\": \"?1\"}}\n" +
            "      ]\n" +
            "    }\n" +
            "  }")
    Page<ProductVo> queryProductsVoByType(String type01 , String type02 , Pageable pageable);
}
