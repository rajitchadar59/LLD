import java.util.*;

interface Subject{

    void subscribe(Observer ob);
    void unsubscribe(Observer ob);

    void notifyChanges(String title);
}


interface Observer{
    void notified(String title);
}


class Subscriber implements Observer{
  
   String name;
   

  public Subscriber(String name) {
    this.name = name;
  }


  @Override
  public void notified(String title){
    System.out.println("Hello "+name+" new video uploded notified : "+title);
  }
}


class YoutubeChannel implements  Subject{
    List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer ob) {
        this.subscribers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        this.subscribers.remove(ob);
    }

    @Override
    public void notifyChanges(String title) {
       for(Observer ob : this.subscribers){
        ob.notified(title);
       }
    }

}


public class ObserverPattern {
    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel();

        Observer aman = new Subscriber("aman");
        Observer raman = new Subscriber("raman");

        channel.subscribe(aman);
        channel.subscribe(raman);
        channel.notifyChanges("learn design pattern ");
        channel.notifyChanges("DSA java ");
    }

 
}
