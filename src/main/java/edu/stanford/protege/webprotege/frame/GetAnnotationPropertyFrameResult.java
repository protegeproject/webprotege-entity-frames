package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.auto.value.AutoValue;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28 Jul 16
 */
@JsonTypeName("webprotege.frames.GetAnnotationPropertyFrame")
public record GetAnnotationPropertyFrameResult(AnnotationPropertyFrame frame) implements Response {

    @JsonCreator
    public static GetAnnotationPropertyFrameResult create(@JsonProperty("frame") AnnotationPropertyFrame frame) {
        return new GetAnnotationPropertyFrameResult(frame);
    }

}
