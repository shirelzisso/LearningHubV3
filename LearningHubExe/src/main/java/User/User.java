package User;

import LearningPath.LearningPath;
import Utils.ActionUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import LearningPath.Topics;
import org.apache.commons.lang.StringUtils;

public class User {

  Credentials credentials;
  HashMap<String, LearningPath> learningPaths;
  ActionUtils action;
  Topics topics;

  public int initUserAction(String username, String password){
    learningPaths = new HashMap<String, LearningPath>();
    action = new ActionUtils();
    credentials = new Credentials();
    topics = new Topics();

    return credentials.setCredentialsAction(username, password);
  }

  public int addNewLearningPathAction(String pathName){
    if(isUniquePathName(pathName)){
      LearningPath newLearningPath = new LearningPath();
      return setPathInLearningPaths(pathName, newLearningPath);
    }
    System.out.printf("Error: current path name is already used!");
    return -1;
  }

  private Integer setPathInLearningPaths(String pathName, LearningPath newLearningPath) {
    if(action.isValidAction(newLearningPath.setLearningPathNameAction(pathName))){
      learningPaths.put(pathName, newLearningPath);
      return 0;
    }
    return -1;
  }

  private boolean isUniquePathName(String pathName) {
    return !isValidLearningPath(pathName);
  }

  public int printAllLearningPathsNamesAction(){
    if(learningPaths!=null && !learningPaths.isEmpty()){
      for(String pathName : learningPaths.keySet()) {
        System.out.println(pathName);
      }
      return 0;
    }
    return -1;
  }

  public List<String> getAllLearningPathsNamesAction(){
    if(learningPaths!=null && !learningPaths.isEmpty()){
      List<String> pathNamesList = new LinkedList<>();
      for(String pathName : learningPaths.keySet()) {
        pathNamesList.add(pathName);
      }
      return pathNamesList;
    }
    return null;
  }

  public LearningPath getLearningPathByNameAction(String pathName){
    if(isValidLearningPath(pathName))
      return learningPaths.get(pathName);
    return null;
  }

  public boolean isCorrectPassword(String inputPassword){
    return credentials.isCorrect(inputPassword);
  }

  public int addNewBlockToLearningPathByName(String pathName, String topic, String url){
    if(isValidLearningPath(pathName)){
      return learningPaths.get(pathName).addNewLearningBlockAction(topic, url);
    }
    System.out.println("Error: no such path!!!");
    return -1;
  }

  public void printAllBlocksInLearningPathByName(String pathName){
    if(isValidLearningPath(pathName)){
      learningPaths.get(pathName).printLearningBlocksAction();
      return;
    }
    System.out.println("Error: no such path!!!");
  }

  public boolean isValidLearningPath(String pathName) {
    if(StringUtils.isNotEmpty(pathName))
      return learningPaths.containsKey(pathName);
    return false;
  }

  public void printAllTopicsNames(){
    topics.printTopicsNames();
  }

  public void setRating(String topic, Double rating){
    topics.setTopicRating(topic, rating);
  }

  public Double getTopicRating(String topicName){
    return topics.getTopicsRating(topicName);
  }
}
