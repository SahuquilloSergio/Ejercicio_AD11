package ad11;

public class Producto {
    
    public String cod;
    public String des;
    public int pre;

    public Producto() {
    }

    public Producto(String cod, String des, int pre) {
        this.cod = cod;
        this.des = des;
        this.pre = pre;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getPre() {
        return pre;
    }

    public void setPre(int pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "Producto: " + "cod=" + cod + ", des=" + des + ", pre=" + pre;
    }
    
    
}
