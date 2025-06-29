package bisection_method_swing;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

/**
 * Giao diện đồ họa Swing cho việc nhập hàm số, khoảng [a, b], epsilon và hiển thị kết quả chia đôi
 */
public class App extends JFrame {

    // Các ô nhập liệu cho người dùng
    private final JTextField txtHam = new JTextField("x*x - 2");     // Hàm f(x)
    private final JTextField txtA = new JTextField("1");             // Giá trị a
    private final JTextField txtB = new JTextField("2");             // Giá trị b
    private final JTextField txtEpsilon = new JTextField("1e-10");   // Sai số ε

    // Bảng kết quả và nút giải
    private final DefaultTableModel tableModel;
    private final JTable bangKetQua;
    private final JButton btnGiai = new JButton("Giải");

    public App() {
        setTitle("Phương pháp Chia Đôi - Bisection Method");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 640);
        setLocationRelativeTo(null); // Căn giữa cửa sổ

        // Giao diện hiện đại (Nimbus Look & Feel)
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        // Panel chính chứa toàn bộ giao diện
        JPanel panelChinh = new JPanel(new BorderLayout(15, 15));
        panelChinh.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        setContentPane(panelChinh);

        // Tiêu đề chính
        JLabel lblTieuDe = new JLabel("Giải Phương Trình Bằng Phương Pháp Chia Đôi", SwingConstants.CENTER);
        lblTieuDe.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTieuDe.setForeground(new Color(33, 97, 140));
        panelChinh.add(lblTieuDe, BorderLayout.NORTH);

        // Panel nhập liệu
        JPanel panelNhapLieu = new JPanel();
        panelNhapLieu.setLayout(new BoxLayout(panelNhapLieu, BoxLayout.X_AXIS));
        panelChinh.add(panelNhapLieu, BorderLayout.PAGE_START);

        // Thêm các ô nhập và nút
        panelNhapLieu.add(createInputGroup("Hàm f(x):", 140, txtHam));
        panelNhapLieu.add(Box.createHorizontalStrut(20));
        panelNhapLieu.add(createInputGroup("a:", 40, txtA));
        panelNhapLieu.add(Box.createHorizontalStrut(20));
        panelNhapLieu.add(createInputGroup("b:", 40, txtB));
        panelNhapLieu.add(Box.createHorizontalStrut(20));
        panelNhapLieu.add(createInputGroup("Sai số ε:", 80, txtEpsilon));
        panelNhapLieu.add(Box.createHorizontalStrut(30));
        panelNhapLieu.add(btnGiai);

        // Cấu hình nút "Giải"
        btnGiai.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnGiai.setBackground(new Color(33, 97, 140));
        btnGiai.setForeground(Color.WHITE);
        btnGiai.addActionListener(e -> xuLyGiaiPhuongTrinh());

        // Bảng hiển thị kết quả
        String[] tieuDeCot = {"n", "an", "bn", "pn", "f(pn)", "e"};
        tableModel = new DefaultTableModel(tieuDeCot, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        bangKetQua = new JTable(tableModel);
        cauHinhBang();

        // Thêm bảng vào scroll pane
        JScrollPane cuonBang = new JScrollPane(bangKetQua);
        cuonBang.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(33, 97, 140), 1),
                "Kết quả các bước tính",
                0, 0,
                new Font("Segoe UI", Font.BOLD, 16),
                new Color(33, 97, 140)
        ));
        panelChinh.add(cuonBang, BorderLayout.CENTER);
    }

    // Tạo nhóm gồm label + textfield
    private JPanel createInputGroup(String labelText, int labelWidth, JTextField textField) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(labelWidth, 26));
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        panel.add(label, BorderLayout.WEST);

        textField.setFont(new Font("Consolas", Font.PLAIN, 14));
        textField.setPreferredSize(new Dimension(120, 26));
        panel.add(textField, BorderLayout.CENTER);
        return panel;
    }

    // Cấu hình hiển thị bảng kết quả
    private void cauHinhBang() {
        bangKetQua.setFont(new Font("Consolas", Font.PLAIN, 14));
        bangKetQua.setRowHeight(28);

        JTableHeader header = bangKetQua.getTableHeader();
        header.setBackground(new Color(210, 230, 255));
        header.setForeground(new Color(33, 97, 140));
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < bangKetQua.getColumnCount(); i++) {
            bangKetQua.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        // Màu nền xen kẽ dòng
        bangKetQua.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!isSelected) {
                    c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 250, 255));
                }
                return c;
            }
        });
    }

    // Hàm xử lý khi nhấn nút "Giải"
    private void xuLyGiaiPhuongTrinh() {
        tableModel.setRowCount(0); // Xóa kết quả cũ
        try {
            // Đọc và chuyển dữ liệu từ người dùng
            String ham = txtHam.getText().trim();
            double a = Double.parseDouble(txtA.getText().trim());
            double b = Double.parseDouble(txtB.getText().trim());
            double epsilon = Double.parseDouble(txtEpsilon.getText().trim());

            // Gọi thuật toán chia đôi
            BisectionSolver solver = new BisectionSolver(ham, epsilon);
            List<BisectionSolver.KetQuaBuoc> ketQua = solver.giai(a, b);

            // Hiển thị kết quả lên bảng
            for (BisectionSolver.KetQuaBuoc buoc : ketQua) {
                tableModel.addRow(new Object[]{
                        buoc.buoc,
                        solver.dinhDangSo(buoc.a, epsilon),
                        solver.dinhDangSo(buoc.b, epsilon),
                        solver.dinhDangSo(buoc.p, epsilon),
                        solver.dinhDangSo(buoc.f_p, epsilon),
                        solver.dinhDangSo(buoc.saiSo, epsilon)
                });
            }

            // Hiển thị nghiệm gần đúng cuối cùng
            if (!ketQua.isEmpty()) {
                double nghiemGanDung = ketQua.get(ketQua.size() - 1).p;
                String nghiemDangDungFormatted = BisectionSolver.dinhDangSo(nghiemGanDung, epsilon);
                JOptionPane.showMessageDialog(this,
                        "Nghiệm gần đúng: x ≈ " + nghiemDangDungFormatted,
                        "Kết quả", JOptionPane.INFORMATION_MESSAGE);
            }


        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số thực.", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException | ArithmeticException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Lỗi tính toán", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi không xác định: " + ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Hàm khởi động chương trình
    public void khoiDong() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        App gd = new App();
        gd.khoiDong();
    }
}

