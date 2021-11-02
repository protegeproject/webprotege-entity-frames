package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/07/15
 */
@JsonTypeName("webprotege.frames.GetOntologyFrames")
public record GetOntologyFramesAction(ProjectId projectId) implements ProjectRequest<GetOntologyFramesResult> {

    public static final String CHANNEL = "webprotege.frames.GetOntologyFrames";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
