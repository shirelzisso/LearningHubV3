package LearningPath;

import java.util.List;

public abstract class LearningPathConfig {

  public String pathName;
  List<LearningBlock> learningBlocks;

  protected boolean isValidLearningBlock(LearningBlock learningBlock){
    return isValidTopic(learningBlock.getTopic()) && isValidURL(learningBlock.getURL());
  }

  private boolean isValidURL(String url) {
    if (url!=null && url.length()<=100) {
      return true;
    }
    System.out.printf("Error: URL is empty, longer than 100 chars or not a valid url");
    return false;
  }

  private boolean isValidTopic(String topic) {
    if (topic!=null && topic.length()<=30) {
      return true;
    }
    System.out.printf("Error: topic is empty or longer than 30 chars!");
    return false;
  }

  protected boolean isValidPathName(String pathName) {
    return pathName != null && !pathName.isEmpty();
  }


  protected void addLearningBlock(LearningBlock learningBlock){
    learningBlocks.add(learningBlock);
  }

  protected void printLearningBlocks(){
    if(hasLearningBlocks()){
      printAllLearningBlocks();
      return;
    }
    System.out.printf("Learning Path is still empty\n");
  }

  protected List<LearningBlock> getLearningBlocks(){
    return learningBlocks;
  }

  private void printAllLearningBlocks() {
    System.out.println("Here are all your learning blocks is the format: <Topic> <URL>");
    for (LearningBlock learningBlock : learningBlocks) {
      System.out.println(learningBlock.getTopic() + " " + learningBlock.getURL());
    }
    System.out.printf("\n");
  }

  private boolean hasLearningBlocks() {
    return learningBlocks!=null && !learningBlocks.isEmpty();
  }


}
