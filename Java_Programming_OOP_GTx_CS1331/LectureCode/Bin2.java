public class Bin2<T> {
  private T content1;
  private T content2;

  public Bin2(T content1, T content2) {
    this.content1 = content1;
    this.content2 = content2;
  }

  public T getContent1() {
    return content1;
  }

  public T getContent2() {
    return content2;
  }

  public void setContent1(T content1) {
    this.content1 = content1;
  }

  public void setContent2(T content2) {
    this.content2 = content2;
  }

  public static void main(String[] args) {
    Bin2<String> test = new Bin2<>("I'm a basic String", "short and stout");
  }
}
