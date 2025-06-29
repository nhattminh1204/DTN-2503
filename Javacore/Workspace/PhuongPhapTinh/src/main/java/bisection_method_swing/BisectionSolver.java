package bisection_method_swing;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Lớp này thực hiện thuật toán chia đôi để tìm nghiệm gần đúng của phương trình f(x) = 0
 */
public class BisectionSolver {

    /**
     * Lớp con để lưu thông tin kết quả của mỗi bước lặp
     */
    public static class KetQuaBuoc {
        public final int buoc;      // số thứ tự bước lặp
        public final double a, b;   // khoảng [a, b] hiện tại
        public final double p;      // trung điểm của a và b
        public final double f_p;    // giá trị f(p)
        public final double saiSo;  // sai số hiện tại (b - a)

        public KetQuaBuoc(int buoc, double a, double b, double p, double f_p, double saiSo) {
            this.buoc = buoc;
            this.a = a;
            this.b = b;
            this.p = p;
            this.f_p = f_p;
            this.saiSo = saiSo;
        }
    }

    private final String hamSo;           // biểu thức hàm f(x) dưới dạng chuỗi
    private final double epsilon;         // sai số cho phép
    private final Expression bieuThuc;    // đối tượng biểu diễn biểu thức toán học

    public BisectionSolver(String hamSo, double epsilon) {
        if (epsilon <= 0) {
            throw new IllegalArgumentException("Sai số epsilon phải lớn hơn 0");
        }
        this.hamSo = hamSo;
        this.epsilon = epsilon;
        this.bieuThuc = new ExpressionBuilder(hamSo)
                .variables("x")
                .build(); // phân tích chuỗi biểu thức
    }

    // Hàm tính giá trị của f(x)
    private double tinhGiaTri(double x) {
        return bieuThuc.setVariable("x", x).evaluate();
    }

    /**
     * Giải phương trình f(x) = 0 bằng phương pháp chia đôi trên khoảng [a, b]
     */
    public List<KetQuaBuoc> giai(double a, double b) {
        if (a >= b) {
            throw new IllegalArgumentException("Giá trị a phải nhỏ hơn b");
        }

        double fa = tinhGiaTri(a);
        double fb = tinhGiaTri(b);

        // Kiểm tra điều kiện bắt buộc: f(a) và f(b) phải trái dấu
        if (fa * fb >= 0) {
            throw new IllegalArgumentException("f(a) và f(b) phải trái dấu!");
        }

        List<KetQuaBuoc> ketQua = new ArrayList<>();
        int buoc = 0;

        // Lặp đến khi khoảng [a, b] nhỏ hơn epsilon
        while ((b - a) >= epsilon) {
            double p = (a + b) / 2.0;      // Tính trung điểm
            double f_p = tinhGiaTri(p);    // Tính f(p)
            double saiSo = b - a;          // Sai số hiện tại

            buoc++;
            ketQua.add(new KetQuaBuoc(buoc, a, b, p, f_p, saiSo)); // Lưu lại bước này

            // Kiểm tra f(a)*f(p) để xác định nửa nào chứa nghiệm
            if (fa * f_p < 0) {
                b = p;
                fb = f_p;
            } else {
                a = p;
                fa = f_p;
            }
        }

        // Ghi lại bước cuối sau khi kết thúc vòng lặp
        double pn = (a + b) / 2.0;
        double fpn = tinhGiaTri(pn);
        double saiSoCuoi = b - a;

        ketQua.add(new KetQuaBuoc(++buoc, a, b, pn, fpn, saiSoCuoi));

        return ketQua;
    }

    /**
     * Định dạng số theo độ chính xác epsilon (ví dụ: 0.00000001)
     */
    public static String dinhDangSo(double giaTri, double epsilon) {
        if (giaTri == (long) giaTri) {
            return String.format("%d", (long) giaTri); // Là số nguyên
        }
        int soChuSoThapPhan = Math.max(0, (int) Math.ceil(-Math.log10(epsilon))) + 1;
        BigDecimal bd = BigDecimal.valueOf(giaTri)
                .setScale(soChuSoThapPhan, RoundingMode.HALF_UP)
                .stripTrailingZeros();
        return bd.toPlainString();
    }
}
