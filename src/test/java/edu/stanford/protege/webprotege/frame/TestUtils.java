package edu.stanford.protege.webprotege.frame;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.UserId;
import edu.stanford.protege.webprotege.entity.*;
import org.semanticweb.owlapi.model.*;
import org.semanticweb.owlapi.vocab.XSDVocabulary;
import uk.ac.manchester.cs.owl.owlapi.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-17
 */
public class TestUtils {

    private static int counter = 0;

    private static synchronized int nextInt() {
        return counter++;
    }

    public static IRI mockIRI() {
        return IRI.create("http://stuff.com/I" + nextInt());
    }

    public static ProjectId mockProjectId() {
        return ProjectId.valueOf(UUID.randomUUID().toString());
    }

    public static OWLClass mockOWLClass() {
        return new OWLClassImpl(mockIRI());
    }

    public static OWLObjectProperty mockOWLObjectProperty() {
        return new OWLObjectPropertyImpl(mockIRI());
    }

    public static OWLDataProperty mockOWLDataProperty() {
        return new OWLDataPropertyImpl(mockIRI());
    }

    public static OWLAnnotationProperty mockOWLAnnotationProperty() {
        return new OWLAnnotationPropertyImpl(mockIRI());
    }

    public static OWLNamedIndividual mockOWLNamedIndividual() {
        return new OWLNamedIndividualImpl(mockIRI());
    }

    public static OWLDatatype mockOWLDatatype() {
        return new OWLDatatypeImpl(mockIRI());
    }

    public static OWLOntologyID mockOWLOntologyID() {
        return new OWLOntologyID(IRI.create("http://example.org/test", "http://example.org/test/v1"));
    }

    public static OWLLiteral mockLiteral() {
        counter = counter + 1;
        return new OWLLiteralImpl("Literal" + counter, "", new OWLDatatypeImpl(XSDVocabulary.STRING.getIRI()));
    }

    public static OWLNamedIndividualData mockOWLNamedIndividualData() {
        return OWLNamedIndividualData.get(mockOWLNamedIndividual(), ImmutableList.of(), false);
    }

    public static OWLDatatypeData mockOWLDatatypeData() {
        return OWLDatatypeData.get(mockOWLDatatype(), ImmutableList.of(), true);
    }

    public static OWLLiteralData mockOWLLiteralData() {
        return OWLLiteralData.get(mockLiteral());
    }

    public HasSignature mockHasSignature(OWLEntity ... entities) {
        HasSignature hasSignature = mock(HasSignature.class);
        when(hasSignature.getSignature()).thenReturn(new HashSet<OWLEntity>(Arrays.asList(entities)));
        return hasSignature;
    }

    public static UserId mockUserId() {
        return UserId.valueOf("User" + nextInt());
    }

    public static OWLClassData mockOWLClassData() {
        return OWLClassData.get(mockOWLClass(), ImmutableMap.of(), false);
    }

    public static OWLObjectPropertyData mockOWLObjectPropertyData() {
        return OWLObjectPropertyData.get(mockOWLObjectProperty(), ImmutableMap.of(), false);
    }

    public static OWLDataPropertyData mockOWLDataPropertyData() {
        return OWLDataPropertyData.get(mockOWLDataProperty(), ImmutableMap.of(), false);
    }

    public static OWLAnnotationPropertyData mockOWLAnnotationPropertyData() {
        return OWLAnnotationPropertyData.get(mockOWLAnnotationProperty(), ImmutableMap.of(), false);
    }
}
