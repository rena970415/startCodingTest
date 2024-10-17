import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      String dirs = "ULLURRDLLU";

      System.out.println(solution(dirs));
    }
    // 범위를 벗어났는지 확인
    private static boolean isValidedMove(int x, int y)
    {
      if (0 <= x && x < 11 && 0 <= y && y < 11) {
        return true;
      } else {
        return false;
      }
    }
    // 좌표를 결정 할 해시맵
    private static final HashMap<Character, int[]> location = new HashMap<>();
    
    private static void initLocation()
    {
      location.put('U', new int[] { 0, 1 });
      location.put('D', new int[] { 0, -1 });
      location.put('L', new int[] { -1, 0 });
      location.put('R', new int[] { 1, 0 });
    }

    public static int solution(String dirs)
    {
      initLocation();
      int x = 5;
      int y = 5;
      HashSet<String> answer = new HashSet<>(); // 겹치는 좌표를 하나로 처리하기 위해

      for (int i = 0; i < dirs.length(); i++)
      {
        int[] offset = location.get(dirs.charAt(i));

        int nx = x + offset[0];
        int ny = x + offset[1];

        if(!isValidedMove(nx, ny))
          continue;
        answer.add(x + " " + y + " " + nx + " " + ny);
        answer.add(nx + " " + ny + " " + x + " " + y);

        x = nx;
        y = ny;

      }

      return answer.size() / 2;
    }

}
