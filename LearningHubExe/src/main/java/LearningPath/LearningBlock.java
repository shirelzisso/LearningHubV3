package LearningPath;

public class LearningBlock implements java.io.Serializable{
  private String topic;
  private String URL;

  public LearningBlock(String topic, String URL) {
    this.topic = topic;
    this.URL = URL;
  }

  public String getTopic() {
    return topic;
  }

  public String getURL() {
    return URL;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }
}
