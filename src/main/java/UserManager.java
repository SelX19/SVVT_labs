public class UserManager {

    private EmailManager emailManager;

    public UserManager() {
        this.emailManager = new EmailManager();
    }

    public boolean checkToken(String token) {
        String storedToken = "GfkLXyk4EJef8NGZ";

        if(storedToken.equals(token)) {
            try{
                this.emailManager.send("Test subject", "Test message", "mail@test.com");
                return true;
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
