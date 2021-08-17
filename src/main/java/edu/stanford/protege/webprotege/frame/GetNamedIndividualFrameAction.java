package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("GetNamedIndividualFrame")
public record GetNamedIndividualFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                            @JsonProperty("subject") OWLNamedIndividual subject) implements Request<GetNamedIndividualFrameResult> {

    @Override
    public String getChannel() {
        return "frames.GetNamedIndividualFrame";
    }
}
