package hu.vmarci94.example;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.Random;

@ManagedBean
@SessionScoped
@Getter
@Setter
public class UserNumberBean {

  private int randomInt;
  private int userNumber;

  @ManagedProperty(value="1")
  private int minimum;
  @ManagedProperty(value="10")
  private int maximum;

  public UserNumberBean(){
    //DefCtor
  }

  @PostConstruct
  public void init(){
    findNewNumber();
  }

  private void findNewNumber() {
    Random randomGR = new Random();
    randomInt = minimum
            +
            randomGR.nextInt(maximum
                    - minimum);
    System.out.println("Number: " + randomInt);
  }

  public String getResponse() {
    if (userNumber == randomInt) {
      findNewNumber();
      return "Yay! You got it!";
    } else {
      return "Sorry, it is not " + userNumber;
    }
  }


}
