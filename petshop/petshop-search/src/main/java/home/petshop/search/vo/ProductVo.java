package home.petshop.search.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Document(indexName = "product")
public class ProductVo implements Serializable {

    @Id
    private Integer id;

    @Field(type = FieldType.Text , analyzer="ik_smart",searchAnalyzer="ik_smart")
    private String title;

    @Field(type = FieldType.Integer)
    private Integer price;

    @Field(type = FieldType.Text , analyzer="simple",searchAnalyzer="simple")
    private String img;

    @Field(type = FieldType.Integer)
    private Integer status;
}
