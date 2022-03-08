package home.petshop.search;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class ESTests {

    @Resource
    private ElasticsearchOperations elasticsearchOperations;

    @Test
    public void hello(){
        log.debug("{}",elasticsearchOperations);
    }
}
