package home;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;

@Configuration
@EnableNeo4jRepositories(basePackages = "home.contact")
public class DBConfiguration extends Neo4jConfiguration {

    @Value("${database.username}")
    private String username;
    @Value("${database.password}")
    private String password;

    @Bean
    public GraphDatabaseService graphDatabaseService() {
        return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db");
    }

    @Bean
    public Neo4jServer neo4jServer() {
        return new RemoteServer("http://localhost:7474", username, password);
    }

    @Bean
    public SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new SessionFactory("home.contact");
        return sessionFactory;
    }
}
