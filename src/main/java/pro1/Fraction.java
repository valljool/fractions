package pro1;

public class Fraction extends Number{
    private long n;
    private long d;

    public Fraction(long n, long d){
        long gcd =  Utils.gcd(n,d);
       this.n = n / gcd;
       this.d = d / gcd;
       // reduceFraction(n, d);
    }

    private void reduceFraction(Fraction fra){
        long gcd =  Utils.gcd(fra.n,fra.d);
        fra.n = fra.n /gcd;
        fra.d = fra.d / gcd;
    }
   /* private void reduceFraction(long n, long d)){
        long gcd =  Utils.gcd(n,d);
        n = n /gcd;
        d = d / gcd;
    }*/

    public static Fraction parse(String str){

        str = str.replace(" ","");
        String[] split =str.split("\\+");
        Fraction sum = new Fraction(0,1);
        for(String part: split){
            Fraction partFraction;
            if(part.contains("%")){
                partFraction = new Fraction(
                        Long.parseLong(part.replace("%","")),
                        100);

            }else{
                String[] split2= part.split("/");
                partFraction = new Fraction(Long.parseLong(split2[0]),Long.parseLong(split2[1]));
            }
            //sum = sum.addToNew(partFraction);
            sum.add(partFraction);

        }
    return sum;
    }

    private Fraction addToNew(Fraction other){
        return new Fraction(
                n*other.d + d*other.n,
                d * other.d

        );
    }

    private void add(Fraction other){
        n = n*other.d + d*other.n;
        d =  d * other.d;
        reduceFraction(this);
    }



    @Override
    public String toString(){
        return n + "/" +d;
    }

    @Override
    public int intValue() {
        return (int)n/ (int) d;
    }

    @Override
    public long longValue() {
        return n/d;
    }

    @Override
    public float floatValue() {
        return (float) n/ (float)d;
    }

    @Override
    public double doubleValue() {
        return (double) n/ (double)d;
    }
}
