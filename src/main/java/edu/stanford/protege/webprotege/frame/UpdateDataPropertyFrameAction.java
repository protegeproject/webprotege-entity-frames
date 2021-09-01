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
 * Date: 23/04/2013
 */


@JsonTypeName("UpdateDataPropertyFrame")
public record UpdateDataPropertyFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                            @JsonProperty("from") PlainDataPropertyFrame from,
                                            @JsonProperty("to") PlainDataPropertyFrame to) implements ProjectRequest<UpdateDataPropertyFrameResult>, UpdateFrame {

    public static final String CHANNEL = "webprotege.frames.UpdateDataPropertyFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
