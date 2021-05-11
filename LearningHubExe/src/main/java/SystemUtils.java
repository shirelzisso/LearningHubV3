import java.util.Scanner;

public class SystemUtils {

  public static int inputIntValue() {
    Scanner in = new Scanner(System.in);
    for(int i=0 ; i<3 ;i++){
      try{
        return Integer.parseInt(in.next());
      }catch (Exception e){
        System.out.println("This is not a valid int value, please try again!");
      }
    }
    return -1;
  }


  public static String inputStringValue() {
    Scanner in = new Scanner(System.in);
    for(int i=0 ; i<3 ;i++){
      try{
        return in.next();
      }catch (Exception e){
        System.out.println("This is not a valid String value, please try again : ");
      }
    }
    return null;
  }

  public static Double inputDoubleValue() {
    Scanner in = new Scanner(System.in);
    for(int i=0 ; i<3 ;i++){
      try{
        return Double.valueOf(in.next());
      }catch (Exception e){
        System.out.println("This is not a valid int value, please try again!");
      }
    }
    return -1.0;
  }
}
