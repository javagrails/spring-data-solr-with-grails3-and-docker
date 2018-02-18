package spring.style.service.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SolrDocument(solrCoreName = "blogs")
public class SolrBlogDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Field // solr => "id":"9",
    private String id;

    @Field("title_s") // solr => "title_s":"Document_title_9",
    private String title;

    @Field("url_text") // solr => "url_text":["http://www.open.com/Document_url_9"],
    private String url; // solr creates extra filed => "url_text_str":["http://www.open.com/Document_url_9"],

    @Field("description_txt") // solr => "description_txt":["Document_description_9"],
    private String description;

    @Field("score_l") // solr => "score_l":0,
    private Long score;

    @Field("imageUrl_t") // solr => "imageUrl_t":["http://placehold.it/50x50"],
    private String imageUrl; // solr creates extra filed => "imageUrl_t_str":["http://placehold.it/50x50"],

    @Field("cities_ss") // solr => "cities_ss":["Dhaka", "Tangail", "Dhanbari", "Madhupur"],
    private Set<String> cities = new HashSet<>();

    @Field("cityIds_ls") // solr => "cityIds_ls":[20, 22, 23, 25],
    private Set<Long> cityIds = new HashSet<>();

    @Field("price_d") // solr => "price_d":1.78524962298035,
    private Double price;

    @Field("fetchedDate_dt") // solr =>"fetchedDate_dt":"2018-02-10T20:44:15.757Z",
    private Date fetchedDate;

    @Field("lastModified_dt") // solr => "lastModified_dt":"2018-02-20T20:44:15.757Z",
    private Date lastModified;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<String> getCities() {
        return cities;
    }

    public void setCities(Set<String> cities) {
        this.cities = cities;
    }

    public Set<Long> getCityIds() {
        return cityIds;
    }

    public void setCityIds(Set<Long> cityIds) {
        this.cityIds = cityIds;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getFetchedDate() {
        return fetchedDate;
    }

    public void setFetchedDate(Date fetchedDate) {
        this.fetchedDate = fetchedDate;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SolrBlogDTO that = (SolrBlogDTO) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(title, that.title)
                .append(url, that.url)
                .append(description, that.description)
                .append(score, that.score)
                .append(imageUrl, that.imageUrl)
                .append(cities, that.cities)
                .append(cityIds, that.cityIds)
                .append(price, that.price)
                .append(fetchedDate, that.fetchedDate)
                .append(lastModified, that.lastModified)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(title)
                .append(url)
                .append(description)
                .append(score)
                .append(imageUrl)
                .append(cities)
                .append(cityIds)
                .append(price)
                .append(fetchedDate)
                .append(lastModified)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "SolrBlogDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", imageUrl='" + imageUrl + '\'' +
                ", cities=" + cities +
                ", cityIds=" + cityIds +
                ", price=" + price +
                ", fetchedDate=" + fetchedDate +
                ", lastModified=" + lastModified +
                '}';
    }
}
