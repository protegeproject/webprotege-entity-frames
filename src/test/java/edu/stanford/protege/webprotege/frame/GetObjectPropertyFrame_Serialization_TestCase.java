package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.entity.OWLObjectPropertyData;
import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;


import java.io.IOException;


import static edu.stanford.protege.webprotege.frame.TestUtils.mockOWLObjectProperty;
import static edu.stanford.protege.webprotege.frame.TestUtils.mockProjectId;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
@JsonTest
@Import(WebprotegeOwlApiJacksonApplication.class)
public class GetObjectPropertyFrame_Serialization_TestCase {

    @Autowired
    JacksonTester<GetObjectPropertyFrameAction> actionTester;

    @Autowired
    JacksonTester<GetObjectPropertyFrameResult> resultTester;

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new GetObjectPropertyFrameAction(mockProjectId(),
                                                         mockOWLObjectProperty());
        var json = actionTester.write(action);
        assertThat(json).hasJsonPathValue("projectId");
        assertThat(json).hasJsonPathValue("subject");

    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new GetObjectPropertyFrameResult(TestUtils.mockProjectId(),
                                                      ObjectPropertyFrame.get(
                OWLObjectPropertyData.get(mockOWLObjectProperty(), ImmutableMap.of(), false),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of(),
                ImmutableSet.of()
        ));
        var json = resultTester.write(result);
        assertThat(json).hasJsonPathValue("projectId");
        assertThat(json).hasJsonPathValue("frame");


    }
}