package cakar.springframework.springelasticsearch.repositories;

import cakar.springframework.springelasticsearch.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface UserRepository extends ElasticsearchRepository<User, String> {

    @Query("{\"match\": {\"ad\": {\"query\": \"?0\"}}}")
    Page<User> findByName(String ad, Pageable pageable);
}
