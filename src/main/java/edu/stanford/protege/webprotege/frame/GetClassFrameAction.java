package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLClass;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("GetClassFrame")
public record GetClassFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                  @JsonProperty("subject") OWLClass subject) implements Request<GetClassFrameResult> {

    @Override
    public String getChannel() {
        return "frames.GetClassFrame";
    }
}
