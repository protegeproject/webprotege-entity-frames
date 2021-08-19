
package edu.stanford.protege.webprotege.frame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLOntologyID;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OntologyFrame_TestCase {

    private OntologyFrame frame;

    private final OWLOntologyID subject = new OWLOntologyID();

    @Mock
    private PropertyValueList propertyValues;

    private final String shortForm = "The shortForm";

    @BeforeEach
    public void setUp()
        throws Exception
    {
        frame = new OntologyFrame(subject, propertyValues, shortForm);
    }


    @Test
    public void shouldReturnSupplied_shortForm() {
        assertThat(frame.getShortForm(), is(this.shortForm));
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(frame, is(frame));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(frame.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(frame, is(new OntologyFrame(subject, propertyValues, shortForm)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_subject() {
        assertThat(frame, is(not(new OntologyFrame(new OWLOntologyID(), propertyValues, shortForm))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_propertyValues() {
        assertThat(frame, is(not(new OntologyFrame(subject, mock(PropertyValueList.class), shortForm))));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_shortForm() {
        assertThat(frame, is(not(new OntologyFrame(subject, propertyValues, "String-ed7172d0-40e4-4cec-ad6d-8ca1bceae7d1"))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(frame.hashCode(), is(new OntologyFrame(subject, propertyValues, shortForm).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(frame.toString(), startsWith("OntologyFrame"));
    }

    @Test
    public void should_getPropertyValueList() {
        assertThat(frame.getPropertyValueList(), is(propertyValues));
    }

    @Test
    public void should_getSignature() {
        Set<OWLEntity> entitySet = new HashSet<>();
        entitySet.add(mock(OWLEntity.class));
        when(propertyValues.getSignature()).thenReturn(entitySet);
        assertThat(frame.getSignature(), is(propertyValues.getSignature()));
    }

}
