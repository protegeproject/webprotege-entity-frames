package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.WebProtegeCommonConfiguration;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
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
@Import({WebProtegeJacksonApplication.class, WebProtegeCommonConfiguration.class})
public class DataPropertyFrame_Serialization_TestCase {

    @Autowired
    private JacksonTester<DataPropertyFrame> tester;

    @Autowired
    private OWLDataFactory dataFactory;

    @Test
    public void shouldSerializeFrame() throws IOException {
        var frame = DataPropertyFrame.get(TestUtils.mockOWLDataPropertyData(),
                                                ImmutableSet.of(),
                                                ImmutableSet.of(),
                                          ImmutableSet.of(),
                                          false);
        var json = tester.write(frame);
        assertThat(json).hasJsonPath("subject");
        assertThat(json).hasJsonPath("propertyValues");
        assertThat(json).hasJsonPath("domains");
        assertThat(json).hasJsonPath("ranges");
        assertThat(json).hasJsonPath("functional");
    }

    @Test
    void shouldDeserializeFrame() throws IOException {
        var json = """
                {
                    "type" : "DataPropertyFrame",
                    "subject" : {
                        "type" : "OWLDataPropertyData",
                        "iri"  : "http://www.example.org/x",
                        "shortForms" : []
                    },
                    "propertyValues" : [],
                    "domains" : [],
                    "ranges"  : [],
                    "functional" : true
                }
                """;
        var parsed = tester.parse(json);
        var parsedFrame = parsed.getObject();
        assertThat(parsedFrame.getSubject().getEntity()).isEqualTo(dataFactory.getOWLDataProperty(IRI.create("http://www.example.org/x")));
    }
}
