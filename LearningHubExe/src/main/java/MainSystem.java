import LearningPath.Topics;
import User.User;
import java.util.HashMap;
import java.util.Scanner;

public class MainSystem {

  HashMap<String, User> users;
  SystemUtils systemUtils = new SystemUtils();
  int initUserInput;

  public void main(){
    users = new HashMap<String, User>();
    do{
      initAction();
    }while (initUserInput !=-1);
  }

  private void initAction() {
    initActionText();

    System.out.printf("Your choice: ");
    initUserInput = systemUtils.inputIntValue();

    switch (initUserInput){
      case 1:
        login();
        break;
      case 2:
        register();
        break;
      case 3:
        getTopicsRatings();
        break;
      default:
        return;
    }

  }

  private void getTopicsRatings() {
    String[] topicsNames = getAllTopicsNames();
    if(topicsNames!=null && topicsNames.length>0 && users!=null && !users.isEmpty()){
      for(String topicName : topicsNames){
        Double ratingSum = 0.0;
        int ratedCount = 0;
        for(String userKey : users.keySet()){
          User user = users.get(userKey);
          Double rating = user.getTopicRating(topicName);
          if(rating>=0){
            ratingSum+=rating;
            ratedCount++;
          }
        }
        printTopicRating(topicName, ratingSum, ratedCount);
      }
    }
  }

  private void printTopicRating(String topicName, Double ratingSum, int ratedCount) {
    if(ratedCount>0){
      System.out.println("Rating of topic " + topicName + " is : " + ratingSum/
          new Double(ratedCount));
    }else {
      System.out.println(topicName + " has not been rated by any user yet!");
    }
  }

  private String[] getAllTopicsNames() {
    Topics topics = new Topics();
    return topics.getTopics();
  }

  private void register() {
    String username, password;
    System.out.printf("Insert Username: ");
    username = SystemUtils.inputStringValue();
    System.out.printf("Insert password: ");
    password = SystemUtils.inputStringValue();

    if(!users.containsKey(username)){
      User user = new User();
      user.initUserAction(username, password);
      users.put(username, user);
      System.out.println("User created successfully");
    }else{
      System.out.println("User already exists");
    }
  }

  private void initActionText() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Please choose action by number :");
    System.out.println("1. Login");
    System.out.println("2. Register");
    System.out.println("3. Get Topics Rating");
    System.out.println("-1. Exit");
  }

  private void login() {
    User user = getUser();
    if(user!=null){
      userActions(user);
    }else{
      System.out.println("Login unsuccessful");
    }
  }

  private void userActions(User user) {
    int choice = -1;
    do{
      userActionsText();
      System.out.printf("Your choice: ");
      choice = SystemUtils.inputIntValue();
      switch (choice){
        case 1:
          addLearningPath(user);
          break;
        case 2:
          getAllLearningPaths(user);
          break;
        case 3:
          chooseLearningPath(user);
          break;
        case 4:
          rateTopic(user);
          break;
        case -1:
          return;
        default:
          System.out.println("try Again:)");
    }
    }while(choice!=-1);
  }



  private void rateTopic(User user) {
    String topic;
    Double rating;
    System.out.println("Here's a list of all topics, choose one then rate it:");
    user.printAllTopicsNames();
    System.out.println("Insert topic name:");
    topic = SystemUtils.inputStringValue();
    System.out.println("Insert rating (number between 0-10):");
    rating = SystemUtils.inputDoubleValue();
    user.setRating(topic, rating);
  }

  private void chooseLearningPath(User user) {
    String choice;
    System.out.println("please choose one of the learning paths by name :");
    user.printAllLearningPathsNamesAction();
    System.out.printf("Your choice: ");
    choice = SystemUtils.inputStringValue();
    if(user.isValidLearningPath(choice)){
      learningPathAction(user, choice);
      System.out.println("Block added successfully");
      return;
    }
    System.out.println("Error: Invalid learning path!");
  }

  private void learningPathAction(User user, String pathName) {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Please choose action by number :");
    System.out.println("1. Add block to path");
    System.out.println("2. Get all blocks in path");
    System.out.println("-1. return");

    System.out.printf("Your choice: ");
    int choice = SystemUtils.inputIntValue();

    switch (choice){
      case 1:
        addBlockToPath(user, pathName);
        break;
      case 2:
        getAllBlocksInPath(user, pathName);
        break;
      default:
        return;
    }
  }

  private void getAllBlocksInPath(User user, String pathName) {
    user.printAllBlocksInLearningPathByName(pathName);
  }

  private void addBlockToPath(User user, String pathName) {
    String topic, url;
    System.out.printf("Insert block topic: ");
    topic = SystemUtils.inputStringValue();
    System.out.printf("Insert block URL: ");
    url = SystemUtils.inputStringValue();
    user.addNewBlockToLearningPathByName(pathName, topic, url);
  }

  private void getAllLearningPaths(User user) {
    System.out.println("Here are all your learning paths :");
    user.printAllLearningPathsNamesAction();
  }

  private void addLearningPath(User user) {
    System.out.printf("\nPlease insert new paths name :");
    String pathName = SystemUtils.inputStringValue();
    user.addNewLearningPathAction(pathName);
  }

  private void userActionsText() {
    System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("Please choose action by number :");
    System.out.println("1. Add learning path");
    System.out.println("2. Get all Learning paths");
    System.out.println("3. Choose Learning path");
    System.out.println("4. Rate Topic");
    System.out.println("-1. Logout");
  }

  private User getUser() {
    String username, password;
    System.out.printf("Insert Username: ");
    username = SystemUtils.inputStringValue();
    System.out.printf("Insert password: ");
    password = SystemUtils.inputStringValue();

    if(users.containsKey(username)){
      User user = users.get(username);
      if(user.isCorrectPassword(password)){
        return user;
      }
    }
    return null;
  }
}
