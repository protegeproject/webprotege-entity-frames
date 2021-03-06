package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-03-31
 */
@AutoValue

@JsonTypeName(PlainPropertyDatatypeValue.PROPERTY_DATATYPE_VALUE)
public abstract class PlainPropertyDatatypeValue extends PlainPropertyValue {

    public static final String PROPERTY_DATATYPE_VALUE = "PropertyDatatypeValue";

    @Nonnull
    public static PlainPropertyDatatypeValue get(@Nonnull OWLDataProperty property,
                                                 @Nonnull OWLDatatype datatype,
                                                 @Nonnull State state) {
        return new AutoValue_PlainPropertyDatatypeValue(property, datatype, state);
    }

    @JsonCreator
    @Nonnull
    public static PlainPropertyDatatypeValue get(@Nonnull @JsonProperty(PROPERTY) OWLDataProperty property,
                                                 @Nonnull @JsonProperty(VALUE) OWLDatatype datatype) {
        return get(property, datatype, State.ASSERTED);
    }

    @Nonnull
    @Override
    public abstract OWLDataProperty getProperty();

    @Nonnull
    @Override
    public abstract OWLDatatype getValue();

    @Nonnull
    @Override
    public abstract State getState();

    @Override
    public <R> R accept(PlainPropertyValueVisitor<R> visitor) {
        return visitor.visit(this);
    }

    @Nonnull
    @Override
    public PlainPropertyDatatypeValue withState(State state) {
        return get(getProperty(), getValue(), state);
    }

    @Override
    public boolean isLogical() {
        return true;
    }

    @Override
    public boolean isAnnotation() {
        return false;
    }
}
