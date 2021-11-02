package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */
@JsonTypeName("webprotege.frames.GetClassFrame")
public record GetClassFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                  @JsonProperty("subject") OWLClass subject) implements ProjectRequest<GetClassFrameResult> {

    public static final String CHANNEL = "webprotege.frames.GetClassFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
