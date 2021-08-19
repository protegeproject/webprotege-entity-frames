package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableSet;
import edu.stanford.protege.webprotege.entity.OWLClassData;
import edu.stanford.protege.webprotege.entity.OWLNamedIndividualData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 15/01/15
 */
@SpringBootTest
public class NamedIndividualFrame_TestCase {


    private NamedIndividualFrame namedIndividualFrame;

    private NamedIndividualFrame otherNamedIndividualFrame;

    @Mock
    private OWLNamedIndividualData subject;

    private ImmutableSet<OWLClassData> types;

    @Mock
    private OWLClassData typeA, typeB;

    @Mock
    private PropertyValue propertyValue;

    private ImmutableSet<PropertyValue> propertyValueList;


    private ImmutableSet<OWLNamedIndividualData> sameIndividuals;

    @Mock
    private OWLNamedIndividualData individualA, individualB;

    @BeforeEach
    public void setUp() throws Exception {
        types = ImmutableSet.of(typeA, typeB);
        sameIndividuals = ImmutableSet.of(individualA, individualB);
        propertyValueList = ImmutableSet.of(propertyValue);
        namedIndividualFrame = NamedIndividualFrame.get(subject, types, propertyValueList, sameIndividuals);
        otherNamedIndividualFrame = NamedIndividualFrame.get(subject, types, propertyValueList, sameIndividuals);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(namedIndividualFrame, is(equalTo(namedIndividualFrame)));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(namedIndividualFrame, is(not(equalTo(null))));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(namedIndividualFrame, is(equalTo(otherNamedIndividualFrame)));
    }

    @Test
    public void shouldHaveSameHashCodeAsOther() {
        assertThat(namedIndividualFrame.hashCode(), is(otherNamedIndividualFrame.hashCode()));
    }

    @Test
    public void shouldGenerateToString() {
        assertThat(namedIndividualFrame.toString(), startsWith("NamedIndividualFrame"));
    }

    @Test
    public void shouldReturnSupplied_Subject() {
        assertThat(namedIndividualFrame.getSubject(), is(subject));
    }

    @Test
    public void shouldReturnSupplied_Types() {
        assertThat(namedIndividualFrame.getClasses(), is(types));
    }

    @Test
    public void shouldReturnSupplied_PropertyValues() {
        assertThat(ImmutableSet.copyOf(namedIndividualFrame.getPropertyValues()), is(propertyValueList));
    }

    @Test
    public void shouldReturnSupplied_SameIndividuals() {
        assertThat(namedIndividualFrame.getSameIndividuals(), is(sameIndividuals));
    }
}