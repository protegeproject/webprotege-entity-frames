package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import edu.stanford.protege.webprotege.common.Response;

@JsonTypeName("webprotege.frames.UpdateNamedIndividualFrame")
public record UpdateNamedIndividualFrameResult(NamedIndividualFrame updatedFrame) implements Response {

}
