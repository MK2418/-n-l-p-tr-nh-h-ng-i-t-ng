public abstract class Dodunghoctap {
    protected String MSP;
    protected String Ten;
    protected int SL;
    protected int DonGia;
    protected String DVTinh;

    public Dodunghoctap(String MSP, String Ten, int SL, int DonGia, String DVTinh) {
        this.MSP = MSP;
        this.Ten = Ten;
        this.SL = SL;
        this.DonGia = DonGia;
        this.DVTinh = DVTinh;
    }

    public Dodunghoctap() {
    }

    // Get
    public String getMSP() {
        return MSP;
    }

    public String getTen() {
        return Ten;
    }

    public int getSL() {
        return SL;
    }

    public int getDonGia() {
        return DonGia;
    }

    public String getDVTinh() {
        return DVTinh;
    }

    // set
    public void setMSP(String MSP) {
        this.MSP = MSP;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }

    public void setDVTinh(String DVTinh) {
        this.DVTinh = DVTinh;
    }

    public abstract void Nhap();

    public abstract void Xuat();
}
