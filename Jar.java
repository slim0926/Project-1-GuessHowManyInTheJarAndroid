import java.util.Random;

public class Jar {
  private String mItemName;
  private int mMaxNum;
  private int mAnswer;
  
  public Jar(String itemName, int maxNum) {
    mItemName = itemName;
    mMaxNum = maxNum;
    fillJar();
  }
  
  public void fillJar() {
    Random random = new Random();
    mAnswer = random.nextInt(mMaxNum) + 1;
  }
  
  public String getItemName() {
    return mItemName;
  }
  
  public int getMaxNum() {
    return mMaxNum;
  }
  
  public int getAnswer() {
    return mAnswer;
  }
}