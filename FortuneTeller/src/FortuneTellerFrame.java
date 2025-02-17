import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final JTextArea fortuneTextArea;
    private final ArrayList<String> fortunes;
    private int lastFortuneIndex = -1;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        setSize(screenSize.width * 3 / 4, screenSize.height * 3 / 4);
        setLocationRelativeTo(null);

        // Top panel
        JPanel topPanel = new JPanel();
        ImageIcon icon = new ImageIcon("fortune_teller.png"); // Ensure the image is in project directory
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel);

        // Middle panel
        JPanel middlePanel = new JPanel();
        fortuneTextArea = new JTextArea(10, 50);
        fortuneTextArea.setFont(new Font("SansSerif", Font.PLAIN, 18));
        fortuneTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneTextArea);
        middlePanel.add(scrollPane);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        readFortuneButton.setFont(new Font("SansSerif", Font.BOLD, 20));
        JButton quitButton = new JButton("Quit");
        quitButton.setFont(new Font("SansSerif", Font.BOLD, 20));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);

        // Add panels to frame
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortune list
        fortunes = new ArrayList<>();
        fortunes.add("You will have a great day!");
        fortunes.add("Luck is on your side today.");
        fortunes.add("Expect an unexpected surprise!");
        fortunes.add("A smile will bring you joy.");
        fortunes.add("Beware of a mysterious message.");
        fortunes.add("Your hard work will soon pay off.");
        fortunes.add("A dream will soon come true.");
        fortunes.add("You will make a new friend.");
        fortunes.add("Adventure awaits you!");
        fortunes.add("A pleasant surprise is in store for you.");
        fortunes.add("You will receive good news soon.");
        fortunes.add("Trust your instincts today.");

        // Button actions using Java 8 Lambda expressions
        readFortuneButton.addActionListener((ActionEvent e) -> displayFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void displayFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        fortuneTextArea.append(fortunes.get(index) + "\n");
    }
}
