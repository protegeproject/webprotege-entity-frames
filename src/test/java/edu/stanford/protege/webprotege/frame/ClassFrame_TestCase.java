package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.entity.OWLClassData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/01/15
 */
@SpringBootTest
public class ClassFrame_TestCase {


    private ClassFrame classFrame;

    private ClassFrame otherClassFrame;

    @Mock
    private OWLClassData subject;

    @Mock
    private OWLClassData cls;

    @Mock
    private PropertyValue propertyValue;


    private ImmutableSet<OWLClassData> classes;

    private ImmutableSet<PropertyValue> propertyValues;

    @BeforeEach
    public void setUp() throws Exception {
        classes = ImmutableSet.of(cls);
        propertyValues = ImmutableSet.of(propertyValue);
        classFrame = ClassFrame.get(subject, classes, propertyValues);
        otherClassFrame = ClassFrame.get(subject, classes, propertyValues);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(classFrame, is(equalTo(classFrame)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(classFrame, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(classFrame, is(equalTo(otherClassFrame)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(classFrame.hashCode(), is(otherClassFrame.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(classFrame.toString(), startsWith("ClassFrame"));
    }

    @Test
    public void shouldReturnSuppliedSubject() {
        assertThat(classFrame.getSubject(), is(subject));
    }

    @Test
    public void shouldReturnSuppliedPropertyValues() {
        assertThat(classFrame.getPropertyValues(), hasItems(propertyValue));
    }
}