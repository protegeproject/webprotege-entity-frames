package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;


import java.io.IOException;


import static edu.stanford.protege.webprotege.frame.TestUtils.mockOWLAnnotationProperty;
import static edu.stanford.protege.webprotege.frame.TestUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class UpdateAnnotationPropertyFrame_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new UpdateAnnotationPropertyFrameAction(
                mockProjectId(),
                PlainAnnotationPropertyFrame.get(
                        mockOWLAnnotationProperty(),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        ImmutableSet.of()
                ),
                PlainAnnotationPropertyFrame.get(
                        mockOWLAnnotationProperty(),
                        ImmutableSet.of(),
                        ImmutableSet.of(),
                        ImmutableSet.of()
                )
        );
        
    }
}