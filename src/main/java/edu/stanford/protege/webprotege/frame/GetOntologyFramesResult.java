package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableList;
import edu.stanford.protege.webprotege.common.Response;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 25/07/15
 */
@JsonTypeName("webprotege.frames.GetOntologyFrames")
public record GetOntologyFramesResult(ImmutableList<OntologyFrame> frames) implements Response {

}
