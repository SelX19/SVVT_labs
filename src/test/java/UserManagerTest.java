import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    //test both branches

    //test when true:
    @Test
    public void CheckTokenTrue() {
        UserManager userManager = new UserManager();
        String validToken = "GfkLXyk4EJef8NGZ";
        assertTrue(userManager.checkToken(validToken));
    }

    //test when false:
    @Test
    public void CheckTokenFalse() {
        UserManager userManager = new UserManager();
        String validToken = "LsfniOkwqlMpoY";
        assertFalse(userManager.checkToken(validToken));
    }
}