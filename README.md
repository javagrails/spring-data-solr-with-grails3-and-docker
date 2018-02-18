## How to use spring-data-solr with grails-3.3.2 and solr in docker for development purpose

##### Using Docker to simplify development (optional)

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
   





