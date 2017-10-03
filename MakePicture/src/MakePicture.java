import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 
 * @author Jizhongkai
 *
 */
public class MakePicture {
    public static void main(String[] args) {
        new MakePicture();
    }
    String str = new String();
    String strl = new String();
    String strj = new String();
    static String strw = new String();
    String[] s1 = new String[] { "red", "white", "black", "blue" };
    ImageIcon img0 = new ImageIcon(str);
    ImageIcon img1, img2;
    ImageIcon img3 = new ImageIcon(strl);
    JTextField jw, jh, qx, qy, js, jx, jy;
    JButton cq = new JButton("确认");
    JComboBox<String> jcb = new JComboBox<String>(s1);
    public MakePicture() {
        JFrame f = new JFrame("图片处理器");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        JPanel jPanel = new JPanel(new GridLayout(4, 1, 5, 10));
        final JButton dimg = new JButton("打开图片");
        JButton jimg = new JButton("裁剪图片");
        JButton blimg = new JButton("图片大小");
        JButton zhimg = new JButton("添加水印");
        jPanel.add(dimg);
        jPanel.add(jimg);
        jPanel.add(blimg);
        jPanel.add(zhimg);
        jPanel.setBounds(15, 10, 200, 250);
        f.add(jPanel);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(screenSize.width / 2 - 250 / 2,
                screenSize.height / 2 - 300 / 2);
        f.setResizable(false);
        f.setSize(250, 300);
        f.setLocation(300, 100);
        f.setVisible(true);
        /* 裁剪图片 */
        jimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                final JFrame jf = new JFrame("裁剪图片");
//              jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.add(new caijian("裁剪的高", "裁剪的宽"));
                cq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        // 裁剪图片函数
                        int x = Integer.valueOf(qx.getText()).intValue();
                        int y = Integer.valueOf(qy.getText()).intValue();
                        int width = Integer.valueOf(jw.getText()).intValue();
                        int height = Integer.valueOf(jh.getText()).intValue();
                        try {
                            cropImage(str, str, x, y, width, height, strw);
                            jf.dispose();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                jf.setLocation(screenSize.width / 2 - 530 / 2,
                        screenSize.height / 2 - 500 / 2);
                jf.setSize(530, 500);
                jf.setLocation(300, 100);
                jf.setVisible(true);
            }
        });
        /* 倍率放缩 */
        blimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                final JFrame jf = new JFrame("倍率放缩");
//              jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.add(new caijian("放缩的倍数"));
                cq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        int bei = Integer.valueOf(jw.getText()).intValue();
                        boolean f = true;
                        if (bei < 0) {
                            bei = 0 - bei;
                            f = false;
                        }
                        scale(str, str, bei, f);
                        jf.dispose();
                    }
                });
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                jf.setLocation(screenSize.width / 2 - 500 / 2,
                        screenSize.height / 2 - 500 / 2);
                jf.setSize(500, 500);
                jf.setLocation(300, 100);
                jf.setVisible(true);
            }
        });
        /* 添加文字 */
        zhimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                final JFrame jf = new JFrame("添加文字");
//              jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jf.add(new caijian("输入"));
                cq.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // TODO Auto-generated method stub
                        String ss = jw.getText();
                        int size = Integer.valueOf(js.getText()).intValue();
                        int x = Integer.valueOf(jx.getText()).intValue();
                        int y = Integer.valueOf(jy.getText()).intValue();
                        tianp(ss, str, str, size, x, y, strj);
                        jf.dispose();
                    }
                });
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                jf.setLocation(screenSize.width / 2 - 500 / 2,
                        screenSize.height / 2 - 500 / 2);
                jf.setSize(500, 500);
                jf.setLocation(300, 100);
                jf.setVisible(true);
            }
        });
        dimg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                JFileChooser jfc = new JFileChooser();
//              jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                jfc.showDialog(new JLabel(), "确认");
                File file = jfc.getSelectedFile();
                String f = file.getName();
                strw = f.substring(f.lastIndexOf(".") + 1);
                if (e.getSource() == dimg) {
                    str = file.getAbsolutePath();
                    img0 = new ImageIcon(str);
                    img0.setImage(img0.getImage().getScaledInstance(150, 150,
                            Image.SCALE_DEFAULT));
                }
            }
        });
    }
    class caijian extends JPanel {
        public caijian(String s1, String s2) {
            JLabel tp = new JLabel(img0);
            jw = new JTextField();
            jw.setPreferredSize(new Dimension(60, 30));
            jh = new JTextField();
            jh.setPreferredSize(new Dimension(60, 30));
            qx = new JTextField();
            qx.setPreferredSize(new Dimension(30, 30));
            qy = new JTextField();
            qy.setPreferredSize(new Dimension(30, 30));
            JLabel th = new JLabel(s2);
            JLabel tw = new JLabel(s1);
            JLabel qi = new JLabel("起点");
            JPanel jp = new JPanel();
            JPanel jp01 = new JPanel();
            JPanel jp02 = new JPanel();
            JPanel jp03 = new JPanel();
            JPanel jp04 = new JPanel();
            jp04.add(qi);
            jp04.add(qx);
            jp04.add(qy);
            jp01.add(tw);
            jp01.add(jw);
            jp02.add(th);
            jp02.add(jh);
            jp03.add(cq);
            jp.setLayout(new GridLayout(1, 4));
            jp.add(jp04);
            jp.add(jp01);
            jp.add(jp02);
            jp.add(jp03);
            JPanel jp2 = new JPanel();
            jp2.add(new JLabel("图片"), FlowLayout.LEFT);
            jp2.add(tp);
            setLayout(new BorderLayout());
            add(jp, BorderLayout.NORTH);
            add(jp2, BorderLayout.CENTER);
        }
        public caijian(String s1) {
            JLabel tw = new JLabel(s1);
            JPanel jp = new JPanel();
            JPanel jp01 = new JPanel();
            JPanel jp02 = new JPanel();
            JPanel jp03 = new JPanel();
            jp03.add(cq);
            JLabel tp = new JLabel(img0);
            JPanel jp2 = new JPanel();
            jw = new JTextField();
            js = new JTextField();
            jx = new JTextField();
            jy = new JTextField();
            JPanel jp04 = new JPanel();
            JPanel jp05 = new JPanel();
            JPanel jp3 = new JPanel();
            jx.setPreferredSize(new Dimension(30, 30));
            jy.setPreferredSize(new Dimension(30, 30));
            if (s1 == "输入") {
                jw.setPreferredSize(new Dimension(340, 30));
                jp05.add(new JLabel("位置起点"));
                jp05.add(jx);
                jp05.add(jy);
                jp02.add(tw);
                jp02.add(jw);
                jp04.setLayout(new GridLayout(1, 2));
                jp04.add(new JLabel("大小"));
                jp04.add(js);
                js.setPreferredSize(new Dimension(40, 30));
                jp3.add(jp04);
                jp3.add(jp05);
                jp3.add(jcb);
                jp3.add(jp03);
                jcb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        strj = (String) jcb.getSelectedItem();
                    }
                });
                jp.setLayout(new GridLayout(2, 1));
                jp.add(jp02);
                jp.add(jp3);
            } else {
                jw.setPreferredSize(new Dimension(60, 30));
                jh = new JTextField();
                jh.setPreferredSize(new Dimension(60, 30));
                jp01.add(tw);
                if (s1 == "放缩的倍数") {
                    jp02.add(new JLabel("正数放大，负数缩小"));
                    jp01.add(jw);
                } else {
                    jp01.add(jx);
                    jp01.add(jy);
                }
                jp.setLayout(new GridLayout(1, 3));
                jp.add(jp01);
                jp.add(jp02);
                jp.add(jp03);
            }
            jp2.add(new JLabel("图片"), FlowLayout.LEFT);
            jp2.add(tp);
            setLayout(new BorderLayout());
            add(jp, BorderLayout.NORTH);
            add(jp2, BorderLayout.CENTER);
        }
    }
    class pinjie extends JPanel {
        public pinjie() {
            setLayout(new BorderLayout());
            JButton jb = new JButton("选择另一个图片");
            JPanel jk0 = new JPanel();
            final JPanel jk = new JPanel();
            JLabel jl0 = new JLabel(img0);
            jk0.setLayout(new BorderLayout());
            jk0.add(jl0, BorderLayout.CENTER);
            jk0.setPreferredSize(new Dimension(250, 500));
            jk0.add(cq, BorderLayout.SOUTH);
            add(jk0, BorderLayout.WEST);
            jk.setLayout(new BorderLayout());
            // jk.add(jb, constraints);
            jk.add(jb, BorderLayout.SOUTH);
            final JLabel jl1 = new JLabel(img1);
            jk.add(jl1, BorderLayout.CENTER);
            jb.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    JFileChooser jfc = new JFileChooser();
                    jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    jfc.showDialog(new JLabel(), "确认");
                    // jfc.showSaveDialog(null);
                    File file = jfc.getSelectedFile();
                    strl = file.getAbsolutePath();
                    img1 = new ImageIcon(strl);
                    img1.setImage(img1.getImage().getScaledInstance(150, 150,
                            Image.SCALE_DEFAULT));
                    jl1.setIcon(img1);
                }
            });
            jk.setPreferredSize(new Dimension(250, 500));
            add(jk, BorderLayout.EAST);
        }
    }
    /* 按点裁剪 */
    public void cropImage(String srcPath, String toPath, int x, int y,
            int width, int height, String Format) throws IOException {
        FileInputStream fis = null;
        ImageInputStream iis = null;
        try {
            // 读取图片文件
            fis = new FileInputStream(srcPath);
            Iterator it = ImageIO.getImageReadersByFormatName(Format);
            ImageReader reader = (ImageReader) it.next();
            // 获取图片流
            iis = ImageIO.createImageInputStream(fis);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            // 定义一个矩形
            Rectangle rect = new Rectangle(x, y, width, height);
            // 提供一个 BufferedImage，将其用作解码像素数据的目标。
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0, param);
            // 保存新图片
            ImageIO.write(bi, Format, new File(toPath));
            xianshi(toPath);
            return;
        } finally {
            if (fis != null)
                fis.close();
            if (iis != null)
                iis.close();
        }
    }
    /* 倍率放缩 */
    public final static void scale(String srcImageFile, String result,
            int scale, boolean flag) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
            int width = src.getWidth(); // 得到源图宽
            int height = src.getHeight(); // 得到源图长
            if (flag) {// 放大
                width = width * scale;
                height = height * scale;
            } else {// 缩小
                width = width / scale;
                height = height / scale;
            }
            Image image = src.getScaledInstance(width, height,
                    Image.SCALE_DEFAULT);
            BufferedImage tag = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics g = tag.getGraphics();
            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
            g.dispose();
            ImageIO.write(tag, strw, new File(result));// 输出到文件流
            xianshi(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /* 添加文字 */
    public final static void tianp(String pressText, String srcImageFile,
            String destImageFile, int size, int x, int y, String strj) {
        try {
            File img = new File(srcImageFile);
            Image src = ImageIO.read(img);
            int width = src.getWidth(null);
            int height = src.getHeight(null);
            BufferedImage image = new BufferedImage(width, height,
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D g = image.createGraphics();
            g.drawImage(src, 0, 0, width, height, null);
            if (strj == "red")
                g.setColor(Color.red);
            else if (strj == "blue")
                g.setColor(Color.blue);
            else if (strj == "black")
                g.setColor(Color.black);
            else
                g.setColor(Color.white);
            g.setFont(new Font("隶书", Font.BOLD, size));
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,
                    .8f));
            // 在指定坐标绘制水印文字
            g.drawString(pressText, (width - ((pressText.length()) * size)) / 2
                    + x, (height - size) / 2 + y);
            g.dispose();
            ImageIO.write((BufferedImage) image, "JPEG",
                    new File(destImageFile));// 输出到文件流
            xianshi(destImageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /* 显示图片 */
    public static void xianshi(String S) {
        ImageIcon ik = new ImageIcon(S);
        ik.setImage(ik.getImage().getScaledInstance(450, 450,
                Image.SCALE_DEFAULT));
        final JFrame jf0 = new JFrame("新图片");
//      jf0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jpk = new JPanel();
        JPanel jpk1 = new JPanel();
        JPanel jpk2 = new JPanel();
        jpk.setLayout(new BorderLayout());
        JButton cq1 = new JButton("确定");
        jpk1.add(cq1);
        cq1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                jf0.setVisible(false);
            }
        });
        jpk2.add(new JLabel(ik));
        jpk.add(jpk1, BorderLayout.NORTH);
        jpk.add(jpk2, BorderLayout.CENTER);
        jf0.add(jpk);
        jf0.setSize(600, 600);
        jf0.setLocation(300, 100);
        jf0.setVisible(true);
    }
}