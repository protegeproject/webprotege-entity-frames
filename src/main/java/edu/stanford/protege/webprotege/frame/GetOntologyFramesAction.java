package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/07/15
 */
public record GetOntologyFramesAction(ProjectId projectId) implements Request<GetOntologyFramesResult> {

    @Override
    public String getChannel() {
        return "frames.GetOntologyFrames";
    }
}
