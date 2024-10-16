import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
  public static void main(String[] args) throws Exception {
    int[] arr = { 2, 1, 3, 4, 1 };
    List<Number> list = new ArrayList<Number>();
    
    for(int i = 0; i<arr.length - 1; i++)
    {
      for(int j = i +1; j < arr.length; j++)
      {
        list.add(arr[i] + arr[j])  ;
      }
    }
    System.out.println(list.toString());
  }
}
