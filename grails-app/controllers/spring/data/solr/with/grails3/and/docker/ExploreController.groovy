package spring.data.solr.with.grails3.and.docker

class ExploreController {
    def springBlogService
    def grailsBlogService

    def index() {
        grailsBlogService.saveDomainBlogInSolr()
        grailsBlogService.saveSomeBlogInSolr()
        render 'Solr Index'
    }

    def index1() {
        grailsBlogService.searchBlog()
        render 'Solr Index1'
    }
    def index2() {
        println('******************************** index2 Start **************************************')

        springBlogService.searchByTitle("_3")
        springBlogService.search("Document_title_1")
        springBlogService.search("Document_title_5,0")

        println('******************************** index2 End **************************************')

        render 'Solr Index2'
    }
}
