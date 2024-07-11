package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.jackson.OWLAnnotationValueDeserializationConverter;
import edu.stanford.protege.webprotege.jackson.OWLAnnotationValueProxy;
import edu.stanford.protege.webprotege.jackson.OWLAnnotationValueSerializationConverter;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAnnotationValue;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-03-31
 */
@AutoValue
@JsonTypeName(PlainPropertyAnnotationValue.PROPERTY_ANNOTATION_VALUE)
public abstract class PlainPropertyAnnotationValue extends PlainPropertyValue {

    public static final String PROPERTY_ANNOTATION_VALUE = "PropertyAnnotationValue";

    @Nonnull
    public static PlainPropertyAnnotationValue get(@Nonnull OWLAnnotationProperty property,
                                                   @Nonnull OWLAnnotationValue annotationValue,
                                                   @Nonnull State state) {
        return new AutoValue_PlainPropertyAnnotationValue(property,
                                                          annotationValue,
                                                          state);
    }

    @Nonnull
    @JsonCreator
    public static PlainPropertyAnnotationValue get(@Nonnull @JsonProperty(PROPERTY) OWLAnnotationProperty property,
                                                   @Nonnull @JsonProperty(VALUE) OWLAnnotationValue annotationValue) {
        return get(property, annotationValue, State.ASSERTED);
    }


    @Nonnull
    public static PlainPropertyAnnotationValue get(@Nonnull @JsonProperty(PROPERTY) OWLAnnotationProperty property,
                                                   @Nonnull @JsonProperty(VALUE) OWLAnnotationValueProxy annotationValueProxy) {

        return get(property, annotationValueProxy.toAnnotationValue(), State.ASSERTED);
    }

    @Nonnull
    @Override
    public abstract OWLAnnotationProperty getProperty();


    @JsonSerialize(converter = OWLAnnotationValueSerializationConverter.class)
    @JsonDeserialize(converter = OWLAnnotationValueDeserializationConverter.class)
    @Nonnull
    @Override
    public abstract OWLAnnotationValue getValue();

    @Nonnull
    @Override
    public abstract State getState();

    @Override
    public <R> R accept(PlainPropertyValueVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Nonnull
    @Override
    public PlainPropertyAnnotationValue withState(State state) {
        return get(getProperty(), getValue(), state);
    }

    @Override
    public boolean isLogical() {
        return false;
    }
    @Override
    public boolean isAnnotation() {
        return true;
    }
}
