## How to use spring-data-solr with grails-3.3.2 and solr in docker for development purpose

##### 1. Include Spring Data Solr lib in gradle dependencies in build.gradle file

    dependencies {
        compile group: 'org.springframework.boot', name: 'spring-boot-starter-data-solr', version: '1.5.9.RELEASE'
    }

##### 2. Write 2 files for docker solr configuration like below
    1. spring-data-solr-with-grails3-and-docker/grails-app/conf/docker/solr.yml
    2. spring-data-solr-with-grails3-and-docker/src/main/java/spring/style/config/SolrConfiguration.java

##### 3. Write a SolrCrudRepository class and inject like below
    1. spring-data-solr-with-grails3-and-docker/src/main/java/spring/style/repository/search/BlogSearchRepository.java
    2. beans = {
           springBlogService(spring.style.service.SpringBlogService)
       }

##### 4. Now look on below 2 Controller and Service
    1. Controller :: ExploreController.groovy, Service :: GrailsBlogService.groovy 
    2. Run grails app as it is and hit url [ http://localhost:8080/explore/index ] 
    3. After that browse [ http://localhost:8983/solr/#/blogs/query ] 
    4. Now you will see your data saved in solr server as json 
    5. (^_^) Before run grails app please follow point (5 _ below) to create solr blogs collection 

##### 5. Using Docker to simplify development (optional)

You can use Docker to improve your grails-with-solr development experience. A number of docker-compose configuration are available in the **[ grails-app/conf/docker/ ]** folder to launch required third party services.
For example, to start a solr in a docker container, run: below command from the project root.

    docker-compose -f grails-app/conf/docker/solr.yml up -d

or

    docker-compose -f grails-app/conf/docker/solr.yml up

To stop it and remove the container, run:

    docker-compose -f grails-app/conf/docker/solr.yml up down
    
After running the solr successfully, we have to create/delete solr collection using below command from any location of terminal.

Create Collection [ grailscol, blogs ] in solr(at docker)

    docker exec -it --user=solr grails-solr bin/solr create_core -c grailscol
    docker exec -it --user=solr grails-solr bin/solr create_core -c blogs
    
Delete Collection [ grailscol, blogs ] from solr(at docker)

    docker exec -it --user=solr grails-solr bin/solr delete -c grailscol
    docker exec -it --user=solr grails-solr bin/solr delete -c blogs
   





