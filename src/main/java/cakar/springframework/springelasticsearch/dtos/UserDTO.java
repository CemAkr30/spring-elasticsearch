package cakar.springframework.springelasticsearch.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String ad;
    private String soyad;
    private String email;
    private String telefon;
    private String adres;
}
