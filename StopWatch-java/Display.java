import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Display extends JPanel {

    class Time {
        int millisec;
        int seconds;
        int minutes;

        Time(int millisec, int seconds, int minutes) {
            this.millisec = millisec;
            this.seconds = seconds;
            this.minutes = minutes;
        }
    }

    Time currentTime = new Time(0, 0, 0);

    JPanel timePanel;
    JPanel buttonPanel;
    JTextField headerField;

    Timer stopwatch = new Timer(100, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentTime.millisec++;
            if (currentTime.millisec == 10) {
                currentTime.millisec = 0;
                currentTime.seconds++;
                if (currentTime.millisec < 10) {
                    set_time(millisecpanel, currentTime.millisec);
                } else {
                    millisecpanel.setText(String.valueOf(currentTime.millisec));
                }
                if (currentTime.seconds == 60) {
                    currentTime.seconds = 0;
                    currentTime.minutes++;
                    if (currentTime.seconds < 10) {
                        set_time(secondpanel, currentTime.seconds);
                    } else {
                        secondpanel.setText(String.valueOf(currentTime.seconds));
                    }
                    if (currentTime.minutes < 10) {
                        set_time(minutepanel, currentTime.minutes);
                    } else {
                        minutepanel.setText(String.valueOf(currentTime.minutes));
                    }
                } else {
                    if (currentTime.seconds < 10) {
                        set_time(secondpanel, currentTime.seconds);
                    } else {
                        secondpanel.setText(String.valueOf(currentTime.seconds));
                    }
                }
            } else {
                if (currentTime.millisec < 10) {
                    set_time(millisecpanel, currentTime.millisec);
                } else {
                    millisecpanel.setText(String.valueOf(currentTime.millisec));
                }
            }
        }
    });

    void set_time(JButton comp,int time){
        String timeString=String.format("%02d", time);
        comp.setText(timeString);
    }

    JButton millisecpanel;
    JButton secondpanel;
    JButton minutepanel;

    JButton startButton;
    JButton resetButton;

    Display() {
        setBackground(Color.gray);
        setLayout(new BorderLayout());

        headerField = new JTextField("Stopwatch");
        headerField.setFont(new Font("Arial", Font.BOLD, 30));
        headerField.setHorizontalAlignment(JTextField.CENTER);

        timePanel = new JPanel();
        timePanel.setLayout(new GridLayout(1, 3, 5, 4));
        timePanel.setBackground(Color.gray);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2,10,10));

        millisecpanel = new JButton();
        set_time(millisecpanel, 0);
        millisecpanel.setFont(new Font("Verdana", Font.BOLD, 40));
        millisecpanel.setBackground(Color.pink);

        minutepanel = new JButton();
        set_time(minutepanel, 0);
        minutepanel.setFont(new Font("Verdana", Font.BOLD, 40));
        minutepanel.setBackground(Color.pink);

        secondpanel = new JButton();
        set_time(secondpanel, 0);
        secondpanel.setFont(new Font("Verdana", Font.BOLD, 40));
        secondpanel.setBackground(Color.pink);

        timePanel.add(minutepanel);
        timePanel.add(secondpanel);
        timePanel.add(millisecpanel);

        startButton = new JButton("Start");
        startButton.setFont(new Font("Arial",Font.PLAIN,20));
        startButton.addActionListener(new StartListener());

        resetButton = new JButton("Reset");
        resetButton.setFont(new Font("Arial", Font.PLAIN, 20));
        resetButton.addActionListener(new ResetListener());

        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        add(headerField, BorderLayout.NORTH);
        add(timePanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    class StartListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();
            if (source == "Start") {
                stopwatch.start();
                startButton.setText("Stop");
            } else if (source == "Stop") {
                stopwatch.stop();
                startButton.setText("Start");
            }
        }
    }

    class ResetListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            stopwatch.stop();
            startButton.setText("Start");
            currentTime.millisec = 0;
            currentTime.seconds = 0;
            currentTime.seconds = 0;
            set_time(millisecpanel, currentTime.millisec);
            set_time(secondpanel, currentTime.seconds);
            set_time(minutepanel, currentTime.minutes);
        }

    }

}