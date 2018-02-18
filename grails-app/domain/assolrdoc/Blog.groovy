package assolrdoc

import org.apache.solr.client.solrj.beans.Field
import org.springframework.data.annotation.Id
import org.springframework.data.solr.core.mapping.SolrDocument

@SolrDocument(solrCoreName = "blogs")
class Blog {

    @Id
    @Field
    Long id;

    @Field("title_s")
    String title;

    @Field("url_text")
    String url;

    @Field("description_txt")
    String description;

    @Field("score_l")
    Long score;

    @Field("imageUrl_t")
    String imageUrl;

    @Field("cities_ss")
    Set<String> cities = new HashSet<>();

    @Field("cityIds_ls")
    Set<Long> cityIds = new HashSet<>();

    @Field("price_d")
    Double price;

    @Field("fetchedDate_dt")
    Date fetchedDate;

    @Field("lastModified_dt")
    Date lastModified;

    static constraints = {
    }
}
