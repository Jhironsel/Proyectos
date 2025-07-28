package sur.softsurena.jfilechooser;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public final class FileChooserDemo2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private final JTextArea log;
    private final String newline = System.getProperty("line.separator");

    public FileChooserDemo2() {
        super("FileChooserDemo2");

        JButton sendButton = new JButton("Attach");
        sendButton.addActionListener(new AttachListener());

        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        JScrollPane logScrollPane = new JScrollPane(log);

        Container contentPane = getContentPane();
        contentPane.add(sendButton, BorderLayout.NORTH);
        contentPane.add(logScrollPane, BorderLayout.CENTER);
    }

    private class AttachListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fc = new JFileChooser();

            fc.addChoosableFileFilter(new ImageFilter());
            fc.setFileView(new ImageFileView());
            fc.setAccessory(new ImagePreview(fc));

            int returnVal = fc.showDialog(FileChooserDemo2.this,
                                                   "Attach");

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                log.append("Attaching file: " + file.getName() + "." + newline);
            } else {
                log.append("Attachment cancelled by user." + newline);
            }
        }
    }

    public static void main(String s[]) {
        JFrame frame = new FileChooserDemo2();

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

        frame.pack();
        frame.setVisible(true);
    }
}
