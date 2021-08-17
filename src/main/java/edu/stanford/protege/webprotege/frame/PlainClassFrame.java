package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableSet;
import org.semanticweb.owlapi.model.OWLClass;

import javax.annotation.Nonnull;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2020-03-31
 */
@AutoValue

@JsonTypeName(PlainClassFrame.CLASS_FRAME)
public abstract class PlainClassFrame extends PlainEntityFrame {


    public static final String CLASS_FRAME = "ClassFrame";

    @JsonCreator
    @Nonnull
    public static PlainClassFrame get(@Nonnull @JsonProperty(SUBJECT) OWLClass subject,
                                      @Nonnull @JsonProperty(PARENTS) ImmutableSet<OWLClass> classEntries,
                                      @Nonnull @JsonProperty(PROPERTY_VALUES) ImmutableSet<PlainPropertyValue> propertyValues) {

        return new AutoValue_PlainClassFrame(subject,
                                             classEntries,
                                             propertyValues);
    }

    public static PlainClassFrame empty(@Nonnull OWLClass subject) {
        return get(subject, ImmutableSet.of(), ImmutableSet.of());
    }

    /**
     * Gets the subject of this class frame.
     *
     * @return The subject.  Not {@code null}.
     */
    @Nonnull
    @Override
    @JsonProperty(SUBJECT)
    public abstract OWLClass getSubject();

    @JsonProperty(PARENTS)
    @Nonnull
    public abstract ImmutableSet<OWLClass> getParents();

    /**
     * Gets the {@link PropertyValue}s in this frame.
     *
     * @return The (possibly empty) set of property values in this frame. Not {@code null}.  The returned set is unmodifiable.
     */
    @Nonnull
    public abstract ImmutableSet<PlainPropertyValue> getPropertyValues();

    @Nonnull
    @Override
    public PlainClassFrame toPlainFrame() {
        return this;
    }
}
