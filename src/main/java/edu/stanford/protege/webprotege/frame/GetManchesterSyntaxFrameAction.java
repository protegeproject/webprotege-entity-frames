package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
@JsonTypeName("GetManchesterSyntaxFrame")
public record GetManchesterSyntaxFrameAction(ProjectId projectId,
                                             OWLEntity subject) implements Request<GetManchesterSyntaxFrameResult> {

    @Override
    public String getChannel() {
        return "frames.GetManchesterSyntaxFrame";
    }
}
