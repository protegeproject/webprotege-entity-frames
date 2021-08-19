package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.WebProtegeCommonConfiguration;
import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;


import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-08
 */
@JsonTest
@Import({WebprotegeOwlApiJacksonApplication.class, WebProtegeCommonConfiguration.class})
public class ClassFrame_Serialization_TestCase {


    @Autowired
    private JacksonTester<ClassFrame> tester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    public void shouldSerializeFrame() throws IOException {
        var frame = ClassFrame.get(TestUtils.mockOWLClassData(),
                                                ImmutableSet.of(),
                                                ImmutableSet.of());
        var json = tester.write(frame);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("propertyValues");
        assertThat(json).hasJsonPath("classes");
    }

    @Test
    void shouldDeserializeFrame() throws IOException {
        var json = """
                {
                    "type" : "ClassFrame",
                    "subject" : {
                        "type" : "OWLClassData",
                        "entity" : {
                            "iri" : "http://www.example.org/A",
                            "type" : "owl:Class"
                        },
                        "shortForms" : []
                    },
                    "propertyValues" : [],
                    "classes" : []
                }
                """;
        var parsed = tester.parse(json);
        var parsedFrame = parsed.getObject();
        assertThat(parsedFrame.getSubject().getEntity()).isEqualTo(dataFactory.getOWLClass(IRI.create("http://www.example.org/A")));
    }

}
