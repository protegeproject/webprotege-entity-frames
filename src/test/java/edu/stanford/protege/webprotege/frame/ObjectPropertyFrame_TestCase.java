package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.entity.OWLClassData;
import edu.stanford.protege.webprotege.entity.OWLObjectPropertyData;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.Mockito.mock;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/01/15
 */
@SpringBootTest
public class ObjectPropertyFrame_TestCase {

    @Mock
    private OWLObjectPropertyData subject;

    private ImmutableSet<OWLClassData> domains;

    private ImmutableSet<OWLClassData> ranges;

    private ImmutableSet<PropertyAnnotationValue> annotations;

    private ImmutableSet<OWLObjectPropertyData> inverses;

    private ImmutableSet<ObjectPropertyCharacteristic> characteristics;

    private ObjectPropertyFrame objectPropertyFrame;

    private ObjectPropertyFrame otherObjectPropertyFrame;

    @Mock
    private OWLAnnotationProperty annotationProperty;

    @Mock
    private PropertyAnnotationValue annotationValue;

    @Mock
    private OWLClassData domain;

    @Mock
    private OWLClassData range;

    @Mock
    private OWLObjectPropertyData inverse;

    @BeforeEach
    public void setUp() throws Exception {
        annotations = ImmutableSet.of(annotationValue);
        domain = mock(OWLClassData.class);
        domains = ImmutableSet.of(domain);
        ranges = ImmutableSet.of(range);
        inverses = ImmutableSet.of(inverse);
        characteristics = ImmutableSet.of(ObjectPropertyCharacteristic.FUNCTIONAL,
                                           ObjectPropertyCharacteristic.INVERSE_FUNCTIONAL);
        objectPropertyFrame = ObjectPropertyFrame.get(
                subject,
                annotations,
                domains,
                ranges,
                inverses,
                characteristics
        );

        otherObjectPropertyFrame = ObjectPropertyFrame.get(
                subject,
                annotations,
                domains,
                ranges,
                inverses,
                characteristics
        );
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(objectPropertyFrame, is(equalTo(objectPropertyFrame)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(objectPropertyFrame, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(objectPropertyFrame, is(equalTo(otherObjectPropertyFrame)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(objectPropertyFrame.hashCode(), is(otherObjectPropertyFrame.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(objectPropertyFrame.toString(), startsWith("ObjectPropertyFrame"));
    }

    @Test
    public void shouldReturnSuppliedSubject() {
        assertThat(objectPropertyFrame.getSubject(), is(subject));
    }

    @Test
    public void shouldReturnSuppliedAnnotations() {
        assertThat(objectPropertyFrame.getAnnotationPropertyValues(), is(annotations));
    }

    @Test
    public void shouldReturnSuppliedDomains() {
        assertThat(objectPropertyFrame.getDomains(), is(domains));
    }

    @Test
    public void shouldReturnSuppliedRanges() {
        assertThat(objectPropertyFrame.getRanges(), is(ranges));
    }

    @Test
    public void shouldReturnSuppliedCharacteristics() {
        assertThat(objectPropertyFrame.getCharacteristics(), is(characteristics));
    }
}