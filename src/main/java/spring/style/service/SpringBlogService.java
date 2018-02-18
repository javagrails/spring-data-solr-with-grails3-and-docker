package spring.style.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.SolrResultPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.style.repository.search.BlogSearchRepository;
import spring.style.service.dto.SolrBlogDTO;

import java.util.List;

// https://docs.grails.org/latest/guide/services.html

@Service
@Transactional
public class SpringBlogService {

    private final BlogSearchRepository blogSearchRepository;

    public SpringBlogService(BlogSearchRepository blogSearchRepository) {
        this.blogSearchRepository = blogSearchRepository;
    }

    @Transactional(readOnly = true)
    public List<SolrBlogDTO> searchByTitle(String query) {
        List<SolrBlogDTO> result = blogSearchRepository.findByTitleContaining(query);
        System.out.println("SpringBlogService.searchByTitle found ["+result.size()+"] results.");
        return result;

        // SolrBlogDTO{id='7', title='Document_title_7', url='http://www.open.com/Document_url_7', description='Document_description_7', score=0, imageUrl='http://www.open.com/Document_image_url_7'}
    }

    @Transactional(readOnly = true)
    public List<SolrBlogDTO> search(String query) {
        List<SolrBlogDTO> result = blogSearchRepository.findByAllFields(query, new PageRequest(0, 10));
        System.out.println("SpringBlogService.search found ["+result.size()+"] results.");
        return result;
    }
}

