public class Game {
 
  public static void main(String[] args) {
    // Your code here
    Prompter prompter = new Prompter();
    do {
      Jar jar = new Jar(prompter.promptForItem(), prompter.promptForMaxNum());
      prompter.play(jar.getItemName(), jar.getMaxNum(), jar.getAnswer());
    } while (prompter.promptForReplay());
  }
  
}