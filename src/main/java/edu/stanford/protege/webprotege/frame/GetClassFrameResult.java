package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28 Jul 16
 */

@JsonTypeName("webprotege.frames.GetClassFrame")
public record GetClassFrameResult(@JsonProperty("frame") ClassFrame classFrame) implements Response {
}
