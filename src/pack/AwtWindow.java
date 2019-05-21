import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class AwtWindow extends Frame {
    String keymsg = "LR7 Java AWT";
    String mousemsg = "";
    int mouseX = 30, mouseY = 30;



    public AwtWindow() {
        addKeyListener(new MyKeyAdapter(this));
        addWindowListener(new AwtWindowAdapter());
        addMouseListener(new MyMouseAdapter(this));
    }

    public static void main(String[] args) {
        AwtWindow awwin = new AwtWindow();
        awwin.setSize(300, 200);
        awwin.setTitle("Уведомление");

        Button OK = new Button("OK");
        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dialog();
            }
        });
        Panel panel = new Panel();
        panel.add(OK);
        awwin.add(panel);
        awwin.setVisible(true);}


    public static void Dialog(){
        AwtWindow awwin1 = new AwtWindow();
        awwin1.setSize(200, 100);
        awwin1.setTitle("Подтверждение");
        Label l=new Label("Вы точно хотите выйти?");
        Button OK1 = new Button("OK");
        OK1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        Button Cancel = new Button("Отмена");
        Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                awwin1.setVisible(false);
            }
        });
        Panel pane2 = new Panel();
        pane2.add(l);
        pane2.add(OK1);
        pane2.add(Cancel);
        awwin1.add(pane2);
        awwin1.setVisible(true);
    }

    class MyKeyAdapter extends KeyAdapter {
        AwtWindow awtWindow;
        public MyKeyAdapter(AwtWindow awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void keyTyped(KeyEvent ke) {
            awtWindow.keymsg +=ke.getKeyChar();
            awtWindow.repaint();
        }
    }


    class MyMouseAdapter extends MouseAdapter {
        AwtWindow awtWindow;
        public MyMouseAdapter(AwtWindow awtWindow) {
            this.awtWindow = awtWindow;
        }

        public void mousePressed(MouseEvent me) {
            awtWindow.mouseX = me.getX();
            awtWindow.mouseY = me.getY();
            awtWindow.mousemsg = "Mouse Down at " + awtWindow.mouseX + ", " + awtWindow.mouseY;
            awtWindow.repaint();
        }
    }
}

class AwtWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}