package cakar.springframework.springelasticsearch.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@Document(indexName = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Field(name = "id", type = FieldType.Keyword)
    private String id;
    @Field(name = "ad", type = FieldType.Text)
    private String ad;
    @Field(name = "soyad", type = FieldType.Text)
    private String soyad;
    @Field(name = "email", type = FieldType.Text)
    private String email;
    @Field(name = "telefon", type = FieldType.Text)
    private String telefon;
    @Field(name = "adres", type = FieldType.Text)
    private String adres;

}
