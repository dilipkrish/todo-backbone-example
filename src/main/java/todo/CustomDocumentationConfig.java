package todo;

import com.mangofactory.swagger.EndpointComparator;
import com.mangofactory.swagger.OperationComparator;
import com.mangofactory.swagger.configuration.DocumentationConfig;
import com.wordnik.swagger.core.DocumentationEndPoint;
import com.wordnik.swagger.core.DocumentationOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Configuration
@Import(DocumentationConfig.class)
public class CustomDocumentationConfig {
    @Bean
    public EndpointComparator endPointComparator() {
        return new NameEndPointComparator();
    }

    @Bean
    public OperationComparator operationComparator() {
        return new NameOperationComparator();
    }
}

@Component
class NameEndPointComparator implements EndpointComparator {
    @Override
    public int compare(DocumentationEndPoint first, DocumentationEndPoint second) {
        return first.getPath().compareTo(second.getPath());
    }
}

@Component
class NameOperationComparator implements OperationComparator {
    @Override
    public int compare(DocumentationOperation first, DocumentationOperation second) {
        return first.getNickname().compareTo(second.getNickname());
    }
}
