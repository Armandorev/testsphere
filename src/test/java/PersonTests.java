import net.sinoriel.testsphere.classes.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.junit.Assert.assertThat;

/**
 * Created by armandosanchezmedina on 09/11/2015.
 */
public class PersonTests {
    @Test
    public void shouldGeneratePerson() throws Exception {
        assertThat(new Person.PersonBuilder().build(), CoreMatchers.instanceOf(Person.class));
    }
}
