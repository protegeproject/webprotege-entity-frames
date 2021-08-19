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
public class PlainIndividualFrame_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainEntityFrame> tester;

    private PlainNamedIndividualFrame plainIndividualFrame;

    @BeforeEach
    public void setUp() throws Exception {
        var subject = mockOWLNamedIndividual();
        var parents = ImmutableSet.of(mockOWLClass(), mockOWLClass());
        var propertyValues = ImmutableSet.<PlainPropertyValue>of(
                PlainPropertyClassValue.get(mockOWLObjectProperty(), mockOWLClass())
        );
        var sameIndividuals = ImmutableSet.of(mockOWLNamedIndividual(), mockOWLNamedIndividual());
        plainIndividualFrame = PlainNamedIndividualFrame.get(subject, parents, sameIndividuals, propertyValues);
        var json = tester.write(plainIndividualFrame);
        assertThat(json).hasJsonPathValue("subject");
        assertThat(json).hasJsonPathValue("propertyValues");
        assertThat(json).hasJsonPathValue("parents");
        assertThat(json).hasJsonPathValue("sameIndividual");
    }

    @Test
    public void shouldSerializePlainClassFrame() throws IOException {
        
    }
}
