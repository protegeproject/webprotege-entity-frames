package edu.stanford.protege.webprotege.frame;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.semanticweb.owlapi.model.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 12/01/15
 */
@SpringBootTest
public class ObjectPropertyCharacteristic_TestCase {

    @Mock
    private OWLDataFactory dataFactory;

    @Mock
    private OWLObjectPropertyExpression propertyExpression;

    @Mock
    private Set<OWLAnnotation> annotations;


    @Test
    public void shouldCreateFunctionalObjectProperty() {
        OWLFunctionalObjectPropertyAxiom expectedAxiom = mock(OWLFunctionalObjectPropertyAxiom.class);
        when(dataFactory.getOWLFunctionalObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        ObjectPropertyCharacteristic characteristic = ObjectPropertyCharacteristic.FUNCTIONAL;
        OWLFunctionalObjectPropertyAxiom result = characteristic.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLFunctionalObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }
    
    @Test
    public void shouldCreateInverseFunctionalObjectProperty() {
        OWLInverseFunctionalObjectPropertyAxiom expectedAxiom = mock(OWLInverseFunctionalObjectPropertyAxiom.class);
        when(dataFactory.getOWLInverseFunctionalObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLInverseFunctionalObjectPropertyAxiom result = ObjectPropertyCharacteristic.INVERSE_FUNCTIONAL.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLInverseFunctionalObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }
    
    @Test
    public void shouldCreateSymmetricObjectProperty() {
        OWLSymmetricObjectPropertyAxiom expectedAxiom = mock(OWLSymmetricObjectPropertyAxiom.class);
        when(dataFactory.getOWLSymmetricObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLSymmetricObjectPropertyAxiom result = ObjectPropertyCharacteristic.SYMMETRIC.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLSymmetricObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }

    @Test
    public void shouldCreateAsymmetricObjectProperty() {
        OWLAsymmetricObjectPropertyAxiom expectedAxiom = mock(OWLAsymmetricObjectPropertyAxiom.class);
        when(dataFactory.getOWLAsymmetricObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLAsymmetricObjectPropertyAxiom result = ObjectPropertyCharacteristic.ASYMMETRIC.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLAsymmetricObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }

    @Test
    public void shouldCreateReflexiveObjectProperty() {
        OWLReflexiveObjectPropertyAxiom expectedAxiom = mock(OWLReflexiveObjectPropertyAxiom.class);
        when(dataFactory.getOWLReflexiveObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLReflexiveObjectPropertyAxiom result = ObjectPropertyCharacteristic.REFLEXIVE.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLReflexiveObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }

    @Test
    public void shouldCreateIrreflexiveObjectProperty() {
        OWLIrreflexiveObjectPropertyAxiom expectedAxiom = mock(OWLIrreflexiveObjectPropertyAxiom.class);
        when(dataFactory.getOWLIrreflexiveObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLIrreflexiveObjectPropertyAxiom result = ObjectPropertyCharacteristic.IRREFLEXIVE.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLIrreflexiveObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }

    @Test
    public void shouldCreateTransitiveObjectProperty() {
        OWLTransitiveObjectPropertyAxiom expectedAxiom = mock(OWLTransitiveObjectPropertyAxiom.class);
        when(dataFactory.getOWLTransitiveObjectPropertyAxiom(propertyExpression, annotations)).thenReturn(expectedAxiom);
        OWLTransitiveObjectPropertyAxiom result = ObjectPropertyCharacteristic.TRANSITIVE.createAxiom(propertyExpression, annotations, dataFactory);
        verify(dataFactory).getOWLTransitiveObjectPropertyAxiom(propertyExpression, annotations);
        assertThat(result, is(expectedAxiom));
    }
}
