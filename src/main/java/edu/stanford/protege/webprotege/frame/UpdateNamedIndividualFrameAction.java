package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.*;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 20/02/2013
 */


@JsonTypeName("webprotege.frames.UpdateNamedIndividualFrame")
public record UpdateNamedIndividualFrameAction(@JsonProperty("changeRequestId") ChangeRequestId changeRequestId,
                                               @JsonProperty("projectId") ProjectId projectId,
                                               @JsonProperty("from") PlainNamedIndividualFrame from,
                                               @JsonProperty("to") PlainNamedIndividualFrame to) implements ProjectRequest<UpdateNamedIndividualFrameResult>, UpdateFrame, ContentChangeRequest {

    public static final String CHANNEL = "webprotege.frames.UpdateNamedIndividualFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
