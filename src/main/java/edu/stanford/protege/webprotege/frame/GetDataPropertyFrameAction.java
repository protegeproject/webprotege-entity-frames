package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLDataProperty;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */


@JsonTypeName("webprotege.frames.GetDataPropertyFrame")
public record GetDataPropertyFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                         @JsonProperty("subject") OWLDataProperty subject) implements ProjectRequest<GetDataPropertyFrameResult> {

    public static final String CHANNEL = "webprotege.frames.GetDataPropertyFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
