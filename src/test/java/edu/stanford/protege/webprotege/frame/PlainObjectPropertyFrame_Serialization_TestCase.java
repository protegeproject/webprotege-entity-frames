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
public class PlainObjectPropertyFrame_Serialization_TestCase {

    @Autowired
    private JacksonTester<PlainEntityFrame> tester;

    private PlainObjectPropertyFrame plainObjectPropertyFrame;

    @BeforeEach
    public void setUp() throws Exception {
        var subject = mockOWLObjectProperty();
        var parents = ImmutableSet.of(mockOWLObjectProperty(), mockOWLObjectProperty());
        var propertyValues = ImmutableSet.of(
                PlainPropertyAnnotationValue.get(mockOWLAnnotationProperty(), TestUtils.mockLiteral())
        );
        var domains = ImmutableSet.of(mockOWLClass());
        var ranges = ImmutableSet.of(mockOWLClass());
        var inverses = ImmutableSet.of(mockOWLObjectProperty());
        var characteristics = ImmutableSet.of(ObjectPropertyCharacteristic.FUNCTIONAL, ObjectPropertyCharacteristic.INVERSE_FUNCTIONAL);
        plainObjectPropertyFrame = PlainObjectPropertyFrame.get(subject, propertyValues, characteristics, domains, ranges, inverses);
        var json = tester.write(plainObjectPropertyFrame);
        assertThat(json).hasJsonPathValue("subject");
        assertThat(json).hasJsonPathValue("propertyValues");
        assertThat(json).hasJsonPathValue("domains");
        assertThat(json).hasJsonPathValue("ranges");
        assertThat(json).hasJsonPathValue("inverses");
        assertThat(json).hasJsonPathValue("characteristics");
    }

    @Test
    public void shouldSerializePlainObjectPropertyFrame() throws IOException {
        
    }

}
