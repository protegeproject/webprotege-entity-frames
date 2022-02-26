package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.common.ChangeRequestId;
import edu.stanford.protege.webprotege.jackson.WebProtegeJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;


import java.io.IOException;


import static edu.stanford.protege.webprotege.frame.TestUtils.mockOWLClass;
import static edu.stanford.protege.webprotege.frame.TestUtils.mockProjectId;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-07
 */
@JsonTest
@Import(WebProtegeJacksonApplication.class)
public class UpdateClassFrame_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = new UpdateClassFrameAction(ChangeRequestId.generate(),
                                                mockProjectId(),
                                                PlainClassFrame.get(
                                                           mockOWLClass(),
                                                           ImmutableSet.of(),
                                                           ImmutableSet.of()
                                                   ),
                                                PlainClassFrame.get(
                                                           mockOWLClass(),
                                                           ImmutableSet.of(),
                                                           ImmutableSet.of()
                                                   ));
        
    }
}