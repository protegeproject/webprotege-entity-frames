package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;
import uk.ac.manchester.cs.owl.owlapi.OWLClassImpl;

import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-31
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class GetClassFrameAction_Tests {

    @Autowired
    private JacksonTester<GetClassFrameAction> tester;

    @Test
    void shouldSerializeAction() throws IOException {
        var cls = new OWLClassImpl(IRI.create("http://example.org/A"));
        var action = new GetClassFrameAction(ProjectId.generate(),
                                             cls);
        var json = tester.write(action);
        System.out.println(json);
    }
}
