package inter;

import symbols.*;

public class For extends Stmt{
    Expr expr;
    Stmt stmt2, stmt3;

    public For(){
        expr = null;
        stmt2 = null;
        stmt3 = null;
    }

    public void init(Expr x, Stmt s2, Stmt s3) {
        expr = x;
        stmt2 = s2;
        stmt3 = s3;
        if (expr.type != Type.Bool)
            expr.error("Se requiere una expresion booleana en for");
    }

    public void gen(int b, int a) {
        after = a;
        expr.jumping(0, a);

        int label = newlabel();
        emitlabel(label);
        stmt3.gen(label, b);
        stmt2.gen(label, b);
        emit("goto L" + b);
    }
}
