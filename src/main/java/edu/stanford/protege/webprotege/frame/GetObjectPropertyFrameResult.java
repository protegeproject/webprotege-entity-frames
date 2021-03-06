package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 28 Jul 16
 */


@JsonTypeName("webprotege.frames.GetObjectPropertyFrame")
public record GetObjectPropertyFrameResult(ProjectId projectId, @JsonProperty("frame") ObjectPropertyFrame frame) implements Response {

}
