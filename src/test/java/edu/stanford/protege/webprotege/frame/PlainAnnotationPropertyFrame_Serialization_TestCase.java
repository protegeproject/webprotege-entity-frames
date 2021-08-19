package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;

import edu.stanford.protege.webprotege.jackson.WebprotegeOwlApiJacksonApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.context.annotation.Import;


import java.io.IOException;

import static edu.stanford.protege.webprotege.frame.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(WebprotegeOwlApiJacksonApplication.class)
public class PlainAnnotationPropertyFrame_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainEntityFrame> tester;

    private PlainAnnotationPropertyFrame plainAnnotationPropertyFrame;

    @BeforeEach
    public void setUp() throws Exception {
        var subject = mockOWLAnnotationProperty();
        var propertyValues = ImmutableSet.of(
                PlainPropertyAnnotationValue.get(mockOWLAnnotationProperty(), mockLiteral())
        );
        var domains = ImmutableSet.of(mockIRI());
        var ranges = ImmutableSet.of(mockIRI());
        plainAnnotationPropertyFrame = PlainAnnotationPropertyFrame.get(subject, propertyValues, domains, ranges);
        var json = tester.write(plainAnnotationPropertyFrame);
        assertThat(json).hasJsonPathValue("subject");
        assertThat(json).hasJsonPathValue("propertyValues");
        assertThat(json).hasJsonPathValue("domains");
        assertThat(json).hasJsonPathValue("ranges");
    }

    @Test
    public void shouldSerializePlainAnnotationPropertyFrame() throws IOException {
        
    }
}
