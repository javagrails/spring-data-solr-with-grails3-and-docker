package normal

import grails.gorm.transactions.Transactional
import org.springframework.data.domain.PageRequest
import spring.style.service.dto.SolrBlogDTO

@Transactional
class GrailsBlogService {
    def springBlogService

    /*@Override
    public String toString() {
        return "SolrBlogDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", score=" + score +
                ", imageUrl='" + imageUrl + '\'' +
                ", cities=" + cities +
                ", price=" + price +
                ", fetchedDate=" + fetchedDate +
                ", lastModified=" + lastModified +
                '}';
    }*/

    def saveSomeBlogInSolr() {

        (8..9).each { item ->
            String docId = item.toString()
            String docTitle = 'Document_title_'+docId
            String docUrl = 'http://www.open.com/Document_url_'+docId
            String docDescription = 'Document_description_'+docId
            String docImageUrl = 'http://placehold.it/50x50'
            Set<String> docCities = ["Dhaka", "Tangail", "Dhanbari", "Madhupur"]
            Set<Long> docCityIds = [20, 22, 23, 25]
            Double docPrice = Math.random()*2.9
            Date fetchedDate = new Date().minus(5)
            Date lastModified = new Date().plus(5)


            SolrBlogDTO doc = new SolrBlogDTO()
            doc.setId(docId)
            doc.setTitle(docTitle)
            doc.setUrl(docUrl)
            doc.setDescription(docDescription)
            doc.setScore(Math.random().longValue())
            doc.setImageUrl(docImageUrl)
            doc.setCities(docCities)
            doc.setCityIds(docCityIds)
            doc.setPrice(docPrice)
            doc.setFetchedDate(fetchedDate)
            doc.setLastModified(lastModified)

            println(doc)
            springBlogService.blogSearchRepository.save(doc)
        }

        /*
        http://localhost:8983/solr/blogs/select?q=*:*

        {
          "responseHeader":{
            "status":0,
            "QTime":0,
            "params":{
              "q":"*:*"}},
          "response":{"numFound":10,"start":0,"docs":[
              {
                "id":"1",
                "title":["Document_title_1"],
                "url":["http://www.open.com/Document_url_1"],
                "description":["Document_description_1"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_1"],
                "url_str":["http://www.open.com/Document_url_1"],
                "title_str":["Document_title_1"],
                "_version_":1592224779385962496,
                "description_str":["Document_description_1"],
                "image_url_str":["http://www.open.com/Document_image_url_1"]},
              {
                "id":"2",
                "title":["Document_title_2"],
                "url":["http://www.open.com/Document_url_2"],
                "description":["Document_description_2"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_2"],
                "url_str":["http://www.open.com/Document_url_2"],
                "title_str":["Document_title_2"],
                "_version_":1592224780808880128,
                "description_str":["Document_description_2"],
                "image_url_str":["http://www.open.com/Document_image_url_2"]},
              {
                "id":"3",
                "title":["Document_title_3"],
                "url":["http://www.open.com/Document_url_3"],
                "description":["Document_description_3"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_3"],
                "url_str":["http://www.open.com/Document_url_3"],
                "title_str":["Document_title_3"],
                "_version_":1592224781666615296,
                "description_str":["Document_description_3"],
                "image_url_str":["http://www.open.com/Document_image_url_3"]},
              {
                "id":"4",
                "title":["Document_title_4"],
                "url":["http://www.open.com/Document_url_4"],
                "description":["Document_description_4"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_4"],
                "url_str":["http://www.open.com/Document_url_4"],
                "title_str":["Document_title_4"],
                "_version_":1592224785532715008,
                "description_str":["Document_description_4"],
                "image_url_str":["http://www.open.com/Document_image_url_4"]},
              {
                "id":"5",
                "title":["Document_title_5"],
                "url":["http://www.open.com/Document_url_5"],
                "description":["Document_description_5"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_5"],
                "url_str":["http://www.open.com/Document_url_5"],
                "title_str":["Document_title_5"],
                "_version_":1592224785541103616,
                "description_str":["Document_description_5"],
                "image_url_str":["http://www.open.com/Document_image_url_5"]},
              {
                "id":"6",
                "title":["Document_title_6"],
                "url":["http://www.open.com/Document_url_6"],
                "description":["Document_description_6"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_6"],
                "url_str":["http://www.open.com/Document_url_6"],
                "title_str":["Document_title_6"],
                "_version_":1592224785549492224,
                "description_str":["Document_description_6"],
                "image_url_str":["http://www.open.com/Document_image_url_6"]},
              {
                "id":"7",
                "title":["Document_title_7"],
                "url":["http://www.open.com/Document_url_7"],
                "description":["Document_description_7"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_7"],
                "url_str":["http://www.open.com/Document_url_7"],
                "title_str":["Document_title_7"],
                "_version_":1592224785561026560,
                "description_str":["Document_description_7"],
                "image_url_str":["http://www.open.com/Document_image_url_7"]},
              {
                "id":"8",
                "title":["Document_title_8"],
                "url":["http://www.open.com/Document_url_8"],
                "description":["Document_description_8"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_8"],
                "url_str":["http://www.open.com/Document_url_8"],
                "title_str":["Document_title_8"],
                "_version_":1592224785567318016,
                "description_str":["Document_description_8"],
                "image_url_str":["http://www.open.com/Document_image_url_8"]},
              {
                "id":"9",
                "title":["Document_title_9"],
                "url":["http://www.open.com/Document_url_9"],
                "description":["Document_description_9"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_9"],
                "url_str":["http://www.open.com/Document_url_9"],
                "title_str":["Document_title_9"],
                "_version_":1592224785574658048,
                "description_str":["Document_description_9"],
                "image_url_str":["http://www.open.com/Document_image_url_9"]},
              {
                "id":"10",
                "title":["Document_title_10"],
                "url":["http://www.open.com/Document_url_10"],
                "description":["Document_description_10"],
                "score":[0],
                "image_url":["http://www.open.com/Document_image_url_10"],
                "url_str":["http://www.open.com/Document_url_10"],
                "title_str":["Document_title_10"],
                "_version_":1592224785580949504,
                "description_str":["Document_description_10"],
                "image_url_str":["http://www.open.com/Document_image_url_10"]}]
          }}

        */

    }

    def searchBlog() {
        println('******************************** searchBlog Start **************************************')

        List<SolrBlogDTO> result0  = springBlogService.searchByTitle("_7")
        List<SolrBlogDTO> result1  = springBlogService.blogSearchRepository.findByTitleContaining("_8")
        List<SolrBlogDTO> result2  = springBlogService.blogSearchRepository.findByAllFields("image_url_1", new PageRequest(0, 10))
        List<SolrBlogDTO> result3 = springBlogService.blogSearchRepository.findByAllFields("image_url_2", new PageRequest(0, 10))

        println('springBlogService.searchByTitle = result0 = '+result0.size())
        println('springBlogService.blogSearchRepository.findByTitleContaining = result1 = '+result1.size())
        println('springBlogService.blogSearchRepository.findByAllFields = result2 = '+result2.size())
        println('springBlogService.blogSearchRepository.findByAllFields = result3 = '+result3.size())

        println('******************************** searchBlog End **************************************')

    }

    def serviceMethod() {

    }
}
