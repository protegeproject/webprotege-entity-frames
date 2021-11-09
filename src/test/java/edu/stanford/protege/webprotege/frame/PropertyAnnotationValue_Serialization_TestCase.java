package edu.stanford.protege.webprotege.frame;


import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static edu.stanford.protege.webprotege.frame.TestUtils.mockOWLAnnotationProperty;
import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class PropertyAnnotationValue_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainPropertyAnnotationValue> tester;

    private PlainPropertyAnnotationValue propertyValue;

    @BeforeEach
    public void setUp() throws Exception {
        propertyValue = PlainPropertyAnnotationValue.get(mockOWLAnnotationProperty(),
                                                         TestUtils.mockLiteral());
    }

    @Test
    public void shouldSerializePropertyValue() throws IOException {
        var json = tester.write(propertyValue);
        System.out.println(json.getJson());
        assertThat(json).hasJsonPathValue("property");
        assertThat(json).hasJsonPathValue("value");
    }

    @Test
    void shouldDeserializePropertyValue() throws IOException {
        var json = """
                {
                    "@type"    : "PropertyAnnotationValue",
                    "property" : {
                        "@type":"AnnotationProperty",
                        "iri":"http://example.org/p"
                    },
                    "value"    : {
                        "value" : "Hello"
                    }
                }
                """;
        var parsed = tester.parse(json);
        var pv = parsed.getObject();
        assertThat(pv.getProperty().getIRI().toString()).isEqualTo("http://example.org/p");
        assertThat(pv.getValue()).isInstanceOfAny(OWLLiteral.class);

    }
}
