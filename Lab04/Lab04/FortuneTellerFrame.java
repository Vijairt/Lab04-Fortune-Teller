import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private final ArrayList<String> fortunes = new ArrayList<>();
    private final JTextArea fortuneArea = new JTextArea(10, 30);
    private int lastIndex = -1;
    private final Random rand = new Random();

    public FortuneTellerFrame() {
        super("Fortune Teller");

        // Toolkit and Frame settings
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int width = screenSize.width * 3 / 4;
        int height = screenSize.height / 2;
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fonts
        Font titleFont = new Font("Serif", Font.BOLD, 36);
        Font textFont = new Font("SansSerif", Font.PLAIN, 18);
        Font buttonFont = new Font("SansSerif", Font.BOLD, 20);

        // Top Panel: Title + Image
        ImageIcon icon = new ImageIcon("Fortune.png");
        JLabel titleLabel = new JLabel("Fortune Teller", icon, JLabel.CENTER);
        titleLabel.setFont(titleFont);
        titleLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        titleLabel.setVerticalTextPosition(SwingConstants.BOTTOM);
        JPanel topPanel = new JPanel();
        topPanel.add(titleLabel);

        // Middle Panel: Scrollable TextArea
        fortuneArea.setEditable(false);
        fortuneArea.setFont(textFont);
        JScrollPane scrollPane = new JScrollPane(fortuneArea);
        JPanel middlePanel = new JPanel();
        middlePanel.add(scrollPane);

        // Bottom Panel: Buttons
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);

        // Layout Setup
        setLayout(new BorderLayout());
        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Add fortunes
        loadFortunes();

        // Button Listeners using Java 8 Lambdas
        readButton.addActionListener(e -> showNewFortune());
        quitButton.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    private void loadFortunes() {
        fortunes.add("You will find a quarter on the ground.");
        fortunes.add("Your shoelace will remain tied all day!");
        fortunes.add("Beware of pigeons wearing sunglasses.");
        fortunes.add("Don't trust the guy selling 'real dragons'.");
        fortunes.add("A potato will bring you unexpected joy.");
        fortunes.add("You’ll remember a funny joke... but forget the punchline.");
        fortunes.add("Today is a good day to skip laundry.");
        fortunes.add("Someone will compliment your socks.");
        fortunes.add("Your coffee will be just the right temperature.");
        fortunes.add("Today you avoid stepping on any LEGO bricks.");
        fortunes.add("A mysterious cat will follow you today.");
        fortunes.add("You’ll solve a problem just by taking a nap.");
    }

    private void showNewFortune() {
        int index;
        do {
            index = rand.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        fortuneArea.append(fortunes.get(index) + "\n");
    }
}
