package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.semanticweb.owlapi.model.OWLPrimitive;
import org.semanticweb.owlapi.model.OWLProperty;

import javax.annotation.Nonnull;

import static edu.stanford.protege.webprotege.frame.PlainPropertyAnnotationValue.PROPERTY_ANNOTATION_VALUE;
import static edu.stanford.protege.webprotege.frame.PlainPropertyClassValue.PROPERTY_CLASS_VALUE;
import static edu.stanford.protege.webprotege.frame.PlainPropertyDatatypeValue.PROPERTY_DATATYPE_VALUE;
import static edu.stanford.protege.webprotege.frame.PlainPropertyIndividualValue.PROPERTY_INDIVIDUAL_VALUE;
import static edu.stanford.protege.webprotege.frame.PlainPropertyLiteralValue.PROPERTY_LITERAL_VALUE;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-03-31
 */
@JsonSubTypes({
        @JsonSubTypes.Type(value = PlainPropertyClassValue.class, name = PROPERTY_CLASS_VALUE),
        @JsonSubTypes.Type(value = PlainPropertyIndividualValue.class, name = PROPERTY_INDIVIDUAL_VALUE),
        @JsonSubTypes.Type(value = PlainPropertyLiteralValue.class, name = PROPERTY_LITERAL_VALUE),
        @JsonSubTypes.Type(value = PlainPropertyDatatypeValue.class, name = PROPERTY_DATATYPE_VALUE),
        @JsonSubTypes.Type(value = PlainPropertyAnnotationValue.class, name = PROPERTY_ANNOTATION_VALUE)
})
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
public abstract class PlainPropertyValue {

    public static final String PROPERTY = "property";

    public static final String VALUE = "value";

    @JsonProperty(PROPERTY)
    @Nonnull
    public abstract OWLProperty getProperty();

    @JsonProperty(VALUE)
    @Nonnull
    public abstract OWLPrimitive getValue();

    @JsonIgnore
    @Nonnull
    public abstract State getState();

    public abstract <R> R accept(PlainPropertyValueVisitor<R> visitor);

    @JsonIgnore
    public abstract boolean isAnnotation();

    @JsonIgnore
    @Nonnull
    public abstract PlainPropertyValue withState(State state);

    @JsonIgnore
    public abstract boolean isLogical();

}
