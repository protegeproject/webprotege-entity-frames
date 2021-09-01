package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.ProjectRequest;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("UpdateNamedIndividualFrame")
public record UpdateNamedIndividualFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                               @JsonProperty("from") PlainNamedIndividualFrame from,
                                               @JsonProperty("to") PlainNamedIndividualFrame to) implements ProjectRequest<UpdateNamedIndividualFrameResult>, UpdateFrame {

    public static final String CHANNEL = "webprotege.frames.UpdateNamedIndividualFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
