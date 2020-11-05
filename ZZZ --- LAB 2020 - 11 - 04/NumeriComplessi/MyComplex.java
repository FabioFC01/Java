public class MyComplex {
    private double re;
    private double im;

    public MyComplex (){
        re = 0;
        im = 0;
    }

    public MyComplex (double aRe, double aIm){
        re = aRe;
        im = aIm;
    }

    public double re () {
        return re;
    }

    public double im () {
        return im;
    }

    public MyComplex add (MyComplex b){
        //z = z1 + z2 = x1 + x2 + i(y1 + y2).
        MyComplex c = new MyComplex(this.re + b.re , this.im + b.im);
        return c;
    }

    public MyComplex sub (MyComplex b){
        //z = z1 - z2 = x1 - x2 + i(y1 - y2)
        MyComplex c = new MyComplex(this.re - b.re , this.im - b.im);
        return c;
    }
    
    public MyComplex mult (MyComplex b){
        //z = z1 * z2 = x1 * x2 - y1 * y2 + i*(x1 * y2 + x2 * y1)
        MyComplex c = new MyComplex (((this.re * b.re) - (this.im * b.im)  ), (this.re * b.re) + (this.im * b.im));
        return c;
    }

    public double mod (){
        //|z| * |z| = x * x + y * y.
        return (re*re) + (im*im) ;
    }

    public MyComplex conj (){
        //Si dice complesso coniugato di z il numero complesso z^= x - i*y. Proprieta': z * z^ = |z| * |z|
        MyComplex c = new MyComplex(re, (-1) * im);
        return c;
    }

    public MyComplex inv (){
        //1/z = x /(|z|*|z|) - i * y / (|z|*|z|), per z diverso da 0
        //1/z = z^ / (z^ * z) = z^ / (|z| * |z|) = x /(|z|*|z|) - i * y / (|z|*|z|)

        if(this.re == 0 && this.im == 0){
            throw new IllegalArgumentException();
        }

        MyComplex c = new MyComplex ((re)/(this.mod()*this.mod()), (im) / (this.mod()*this.mod()) );
        return c;
    }

    public MyComplex div (MyComplex b){
        //z1/z2 = z1 * 1/z2, per z2 diverso da zero

        if(b.re == 0 && b.im == 0){
            throw new IllegalArgumentException();
        }

        MyComplex c = new MyComplex();
        c = this.mult(b.inv());

        return c;
    }

    public String toString (){
        String res = "Re :  " + re + "   , Im :   " + im;
        return res;
    }
}   