package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;

/**
 * Author: Matthew Horridge<br>
 * Stanford University<br>
 * Bio-Medical Informatics Research Group<br>
 * Date: 23/04/2013
 */


@JsonTypeName("UpdateObjectPropertyFrame")
public record UpdateObjectPropertyFrameAction(@JsonProperty("projectId") ProjectId projectId,
                                              @JsonProperty("from") PlainObjectPropertyFrame from,
                                              @JsonProperty("to") PlainObjectPropertyFrame to) implements Request<UpdateObjectPropertyFrameResult> {

    public static final String CHANNEL = "webprotege.frames.UpdateObjectPropertyFrame";

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}