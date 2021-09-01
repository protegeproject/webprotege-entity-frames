package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */


@JsonTypeName("GetAnnotationPropertyFrame")
public record GetAnnotationPropertyFrameAction(@JsonProperty("subject") OWLAnnotationProperty subject,
                                               @JsonProperty("projectId") ProjectId projectId) implements ProjectRequest<GetAnnotationPropertyFrameResult> {

    public static final String CHANNEL = "webprotege.frames.GetAnnotationPropertyFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
