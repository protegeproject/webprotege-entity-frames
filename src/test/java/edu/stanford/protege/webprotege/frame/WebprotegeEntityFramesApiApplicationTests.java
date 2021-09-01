package edu.stanford.protege.webprotege.frame;

import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import uk.ac.manchester.cs.owl.owlapi.OWLDataFactoryImpl;

@SpringBootTest
class WebprotegeEntityFramesApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean
	OWLDataFactory dataFactory() {
		return new OWLDataFactoryImpl();
	}

}
