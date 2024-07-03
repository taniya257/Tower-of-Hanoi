import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class TowerOfHanoiGUI extends JPanel {
    private Stack<Integer>[] towers;
    private int numberOfDisks;

    public TowerOfHanoiGUI(int numberOfDisks) {
        this.numberOfDisks = numberOfDisks;
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        for (int i = numberOfDisks; i > 0; i--) {
            towers[0].push(i);
        }
        setPreferredSize(new Dimension(600, 400));
    }

    private void solve(int n, int startPeg, int auxPeg, int endPeg) {
        if (n == 1) {
            moveDisk(startPeg, endPeg);
            return;
        }
        solve(n - 1, startPeg, endPeg, auxPeg);
        moveDisk(startPeg, endPeg);
        solve(n - 1, auxPeg, startPeg, endPeg);
    }

    private void moveDisk(int startPeg, int endPeg) {
        towers[endPeg].push(towers[startPeg].pop());
        repaint();
        try {
            Thread.sleep(500); // Pause to show the movement
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int pegWidth = 10;
        int pegHeight = 200;
        int diskHeight = 20;

        // Draw pegs
        for (int i = 0; i < 3; i++) {
            int x = width / 4 * (i + 1);
            int y = height / 2;
            g.fillRect(x, y - pegHeight / 2, pegWidth, pegHeight);
        }

        // Draw disks
        for (int i = 0; i < 3; i++) {
            Stack<Integer> tower = towers[i];
            int x = width / 4 * (i + 1);
            int y = height / 2 + pegHeight / 2 - diskHeight;
            for (Integer disk : tower) {
                int diskWidth = disk * 20;
                g.fillRect(x - diskWidth / 2, y, diskWidth, diskHeight);
                y -= diskHeight;
            }
        }
    }

    public static void main(String[] args) {
        int numberOfDisks = 4; // You can change the number of disks
        TowerOfHanoiGUI panel = new TowerOfHanoiGUI(numberOfDisks);

        JFrame frame = new JFrame("Tower of Hanoi");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(() -> panel.solve(numberOfDisks, 0, 1, 2)).start();
    }
}
