package spring.style.repository.search;

import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import spring.style.service.dto.SolrBlogDTO;

import java.util.List;

// http://www.baeldung.com/spring-data-solr
// https://github.com/mscharhag/Spring-data-solr-example/blob/master/src/main/java/com/mscharhag/solr/repository/BookRepository.java
// https://stackoverflow.com/questions/40819235/how-are-solr-fields-mapped-in-spring-data-solr
// https://stackoverflow.com/questions/31180494/mapping-ignorable-fields-in-solr-to-use-in-spring-data

public interface BlogSearchRepository extends SolrCrudRepository<SolrBlogDTO, String> {

    //SolrResultPage<SolrAppleDTO> findByAllFields(String term, Pageable pageable);
    //SolrResultPage<SolrAppleDTO> findByAllFields(String term, Pageable pageable);
    List<SolrBlogDTO> findByTitleContaining(String term);


    @Highlight(prefix = "<em>", postfix = "</em>", fields = {"id", "title_s", "url_s", "description_s", "score_l", "image_url_s"})
    //@Query(value = "_text_:?0")
    @Query("id:*?0* OR title_s:*?0* OR image_url_s:*?0* OR score_l:*?0*")
    List<SolrBlogDTO> findByAllFields(String term, Pageable pageable);


}

