package LearningPath;

import java.util.HashMap;

public class Topics {
  String[] topics = new String[] {"AI", "ML", "OOP", "TDD", "HTML"};
  HashMap<String, Double> topicsRatings;

  public String[] getTopics() {
    return topics;
  }

  public HashMap<String, Double> getTopicsRatings() {
    return topicsRatings;
  }

  public void setTopicRating(String topic, double rating){
    if(topicsRatings.containsKey(topic) && rating<=10.0 && rating>0.0){
      topicsRatings.replace(topic, rating);
      System.out.println("Rating Saved!");
      return;
    }
    System.out.println("Error : not a valid topic or rating");
  }

  public Topics() {
    topicsRatings = new HashMap<>();
    for(String topic : topics){
      topicsRatings.put(topic, -1.0);
    }
  }

  public void printTopicsNames(){
    for(String topic : topics){
      System.out.println(topic);
    }
  }

  public Double getTopicsRating(String topic){
    return topicsRatings.get(topic);
  }
}
