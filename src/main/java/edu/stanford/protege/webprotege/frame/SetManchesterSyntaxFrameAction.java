package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import org.semanticweb.owlapi.model.OWLEntity;

import java.util.Set;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
public record SetManchesterSyntaxFrameAction(ProjectId projectId,
                                            OWLEntity subject,
                                            String fromRendering,
                                            String toRendering,
                                            Set<OWLEntityData> freshEntities,
                                            String commitMessage) implements Request<SetManchesterSyntaxFrameResult> {

    @Override
    public String getChannel() {
        return "frames.SetManchesterSyntaxFrame";
    }
}


