package sur.softsurena.metodos;

import lombok.Getter;
import org.testng.annotations.Test;

/**
 *
 * @author jhironsel
 */
@Getter
@Test(
        dependsOnGroups = "init"
)
public class M_DoctorNGTest {

    @Test(
            enabled = false,
            priority = 0,
            description = ""
    )
    public void testSomeMethod() {
    }
}