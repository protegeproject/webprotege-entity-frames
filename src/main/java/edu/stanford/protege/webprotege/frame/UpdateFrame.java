package edu.stanford.protege.webprotege.frame;

import org.semanticweb.owlapi.model.OWLEntity;

/**
 * Matthew Horridge
 * Stanford Center for Biomedical Informatics Research
 * 2021-08-31
 */
public interface UpdateFrame {

    PlainEntityFrame from();

    PlainEntityFrame to();
}
