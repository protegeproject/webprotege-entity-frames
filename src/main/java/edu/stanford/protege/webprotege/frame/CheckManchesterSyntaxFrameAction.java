package edu.stanford.protege.webprotege.frame;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.common.collect.ImmutableSet;

import edu.stanford.protege.webprotege.common.ProjectId;
import edu.stanford.protege.webprotege.common.Request;
import edu.stanford.protege.webprotege.entity.OWLEntityData;
import org.semanticweb.owlapi.model.OWLEntity;

/**
 * @author Matthew Horridge, Stanford University, Bio-Medical Informatics Research Group, Date: 18/03/2014
 */
@JsonTypeName("CheckManchesterSyntax")
public record CheckManchesterSyntaxFrameAction(ProjectId projectId,
                                               OWLEntity subject,
                                               String from,
                                               String to,
                                               ImmutableSet<OWLEntityData> freshEntities)implements Request<CheckManchesterSyntaxFrameResult>, HasFreshEntities {


    public static final String CHANNEL = "webprotege.frames.CheckManchesterSyntax";

    @JsonCreator
    public static CheckManchesterSyntaxFrameAction create(@JsonProperty("projectId") ProjectId projectId,
                                                   @JsonProperty("subject") OWLEntity subject,
                                                   @JsonProperty("from") String from,
                                                   @JsonProperty("to") String to,
                                                   @JsonProperty("freshEntities") ImmutableSet<OWLEntityData> freshEntities) {
        return new CheckManchesterSyntaxFrameAction(projectId, subject, from, to, freshEntities);
    }

    @Override
    public String getChannel() {
        return CHANNEL;
    }
}
