package User;

import org.apache.commons.lang.StringUtils;

public class Credentials {

  private String Username;
  private String Password;

  public int setCredentialsAction(String username, String password) {
    if(isValidUsername(username) && isValidPassword(password)){
      Username = username;
      Password = password;
      return 0;
    }
    return -1;
  }

  private boolean isValidPassword(String password) {
    if(password!=null && password.length()<20)
      return true;
    System.out.println("Error : empty or invalid password");
    return false;
  }

  private boolean isValidUsername(String username) {
    if(username!=null && username.length()<20)
      return true;
    System.out.println("Error : empty or invalid password");
    return false;
  }

  public boolean isCorrect(String password){
    return StringUtils.equals(password, this.Password);
  }

  public boolean changePassword(String newPassword){
    this.Password = newPassword;
    return true;
  }
}
