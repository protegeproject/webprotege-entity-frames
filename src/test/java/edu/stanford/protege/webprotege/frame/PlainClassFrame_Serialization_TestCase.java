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

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
@Import(WebprotegeOwlApiJacksonApplication.class)
public class PlainClassFrame_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainEntityFrame> tester;

    private PlainClassFrame plainClassFrame;

    @BeforeEach
    public void setUp() throws Exception {
        var subject = TestUtils.mockOWLClass();
        var parents = ImmutableSet.of(TestUtils.mockOWLClass(), TestUtils
                .mockOWLClass());
        var propertyValues = ImmutableSet.<PlainPropertyValue>of(
                PlainPropertyClassValue.get(TestUtils.mockOWLObjectProperty(), TestUtils.mockOWLClass())
        );
        plainClassFrame = PlainClassFrame.get(subject, parents, propertyValues);
        var json = tester.write(plainClassFrame);
        assertThat(json).hasJsonPathValue("subject");
        assertThat(json).hasJsonPathValue("propertyValues");
        assertThat(json).hasJsonPathValue("parents");
    }

    @Test
    public void shouldSerializePlainClassFrame() throws IOException {
        
    }
}
