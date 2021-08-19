
package edu.stanford.protege.webprotege.frame;

import edu.stanford.protege.webprotege.common.ProjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
public class GetOntologyFramesAction_TestCase {

    private GetOntologyFramesAction action;

    private ProjectId projectId = ProjectId.generate();

    @BeforeEach
    public void setUp()
        throws Exception
    {
        action = new GetOntologyFramesAction(projectId);
    }

    @Test
    public void shouldBeEqualToSelf() {
        assertThat(action, is(action));
    }

    @Test
    public void shouldNotBeEqualToNull() {
        assertThat(action.equals(null), is(false));
    }

    @Test
    public void shouldBeEqualToOther() {
        assertThat(action, is(new GetOntologyFramesAction(projectId)));
    }

    @Test
    public void shouldNotBeEqualToOtherThatHasDifferent_projectId() {
        assertThat(action, is(not(new GetOntologyFramesAction(ProjectId.generate()))));
    }

    @Test
    public void shouldBeEqualToOtherHashCode() {
        assertThat(action.hashCode(), is(new GetOntologyFramesAction(projectId).hashCode()));
    }

    @Test
    public void shouldImplementToString() {
        assertThat(action.toString(), startsWith("GetOntologyFramesAction"));
    }

}
