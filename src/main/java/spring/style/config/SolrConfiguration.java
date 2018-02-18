package spring.style.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

import java.net.MalformedURLException;

// https://stackoverflow.com/questions/24988335/spring-data-missing-property-error-when-initialising-the-solr-repository

@Configuration
//@EnableJpaRepositories(basePackages="spring.style.repository")
@EnableSolrRepositories(basePackages = "spring.style.repository.search", multicoreSupport = true, schemaCreationSupport = true)
public class SolrConfiguration implements EnvironmentAware {

    private final Logger log = LoggerFactory.getLogger(SolrConfiguration.class);

    private RelaxedPropertyResolver propertyResolver;

    @Override
    public void setEnvironment(Environment environment) {
        this.propertyResolver = new RelaxedPropertyResolver(environment, ENV_SOLR);
    }

    private static final String ENV_SOLR = "spring.data.solr.";
    private static final String SOLR_HOST = "host";
    private static final String SOLR_ALTERNATE_HOST = "alternate-host";
    private static final String ZK_HOST = "zk-host";

    public static final String SOLR_HOST_DEFAULT = "http://localhost:8983/solr";
    public static final String SOLR_HOST_DEFAULT_IP = "http://127.0.0.1:8983/solr";
    public static final String ZK_HOST_DEFAULT = "localhost:9983";

    @Bean
    public SolrClient solrClient() throws MalformedURLException {

        String solrHost = this.propertyResolver.getProperty(SOLR_HOST, SOLR_HOST_DEFAULT);
        String zkHost = this.propertyResolver.getProperty(ZK_HOST, ZK_HOST_DEFAULT);
        String alternateHost = this.propertyResolver.getProperty(SOLR_ALTERNATE_HOST, SOLR_HOST_DEFAULT_IP);
        log.debug("starting solr with params: {}, {} and {}", solrHost, zkHost, alternateHost);

        HttpSolrClient httpSolrClient = new HttpSolrClient(solrHost);
        HttpClientUtil.setMaxConnections(httpSolrClient.getHttpClient(), 500);
        HttpClientUtil.setMaxConnectionsPerHost(httpSolrClient.getHttpClient(), 100);
        httpSolrClient.setAllowCompression(true);
        httpSolrClient.setParser(new XMLResponseParser());
        httpSolrClient.setFollowRedirects(true);
        httpSolrClient.setUseMultiPartPost(true);

        return httpSolrClient;
    }

    @Bean
    public SolrOperations solrTemplate() throws MalformedURLException {
        return new SolrTemplate(solrClient());
    }

}
