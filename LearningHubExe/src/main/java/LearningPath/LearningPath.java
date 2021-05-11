package LearningPath;

import java.util.LinkedList;
import java.util.List;

public class LearningPath extends LearningPathConfig{

  public LearningPath() {
    learningBlocks = new LinkedList<LearningBlock>();
  }

  public int setLearningPathNameAction(String pathName){
    if(isValidPathName(pathName)){
      this.pathName = pathName;
      return 0;
    }
    System.out.printf("Error: learning path name is empty or invalid!");
    return -1;
  }

  public int addNewLearningBlockAction(String topic, String url){
    LearningBlock newLearningBlock = new LearningBlock(topic, url);
    if(isValidLearningBlock(newLearningBlock)){
      addLearningBlock(newLearningBlock);
      return 0;
    }
    return -1;
  }

  public void printLearningBlocksAction(){
    printLearningBlocks();
  }
}
