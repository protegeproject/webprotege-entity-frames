package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.context.annotation.Import;


import java.io.IOException;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-04-06
 */
@JsonTest
@Import(WebprotegeOwlApiJacksonApplication.class)
public class CheckManchesterSyntaxFrame_Serialization_TestCase {

    @Test
    public void shouldSerializeAction() throws IOException {
        var action = CheckManchesterSyntaxFrameAction.create(ProjectId.generate(),
                                                             TestUtils.mockOWLClass(),
                                                             "From",
                                                             "To",
                                                             ImmutableSet.of());


    }

    @Test
    public void shouldSerializeResult() throws IOException {
        var result = new CheckManchesterSyntaxFrameResult(ManchesterSyntaxFrameParseResult.CHANGED, null);

    }
}
