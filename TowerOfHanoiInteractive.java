import java.util.Scanner;

public class TowerOfHanoiInteractive {
    public void solve(int n, String startPeg, String auxPeg, String endPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + startPeg + " to " + endPeg);
            return;
        }
        solve(n - 1, startPeg, endPeg, auxPeg);
        System.out.println("Move disk " + n + " from " + startPeg + " to " + endPeg);
        solve(n - 1, auxPeg, startPeg, endPeg);
    }

    public static void main(String[] args) {
        int numberOfDisks = 4;
        TowerOfHanoiInteractive towersOfHanoi = new TowerOfHanoiInteractive();
        towersOfHanoi.solve(numberOfDisks, "A", "B", "C");
    }
}
