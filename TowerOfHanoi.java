public class TowerOfHanoi {
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
        TowerOfHanoi towersOfHanoi = new TowerOfHanoi();
        int numberOfDisks = 3; // You can change the number of disks
        towersOfHanoi.solve(numberOfDisks, "A", "B", "C");
    }
}
