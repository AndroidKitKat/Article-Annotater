package eu.lowentropy.articleannotater;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@Configuration
@EnableMongoRepositories(basePackages = "eu.lowentropy.articleannotater.repository")
public class MongoConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "messe-basse";
    }

    @Override
    public Mongo mongo() throws Exception {
    	MongoClientURI mongoClientURI =
    			new MongoClientURI("mongodb://");
    	return new MongoClient(mongoClientURI);
    }

    @Override
    protected String getMappingBasePackage() {
        return "eu.lowentropy.articleannotater";
    }
}
