package TokoFarda;
public class session {
    private static String U_id;
    private static String U_Username;
    private static String U_email;
    private static String KodeBarang;
    private static String idUser;
    private static String idSupplier;
    private static String KodeTransaksi;
    private static String SisaBayar;
    private static String Kembalian;
    private static String Kurang;
    private static String KodeTransaksiBeli;
    private static String email;
    private static String Id_JenisBarang;
    private static int stok;
    private static String idHutang;

    public static String getIdHutang() {
        return idHutang;
    }

    public static void setIdHutang(String idHutang) {
        session.idHutang = idHutang;
    }

    public static String getId_JenisBarang() {
        return Id_JenisBarang;
    }

    public static void setId_JenisBarang(String Id_JenisBarang) {
        session.Id_JenisBarang = Id_JenisBarang;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        session.email = email;
    }

    public static String getKurang() {
        return Kurang;
    }

    public static void setKurang(String Kurang) {
        session.Kurang = Kurang;
    }

    public static String getKodeTransaksiBeli() {
        return KodeTransaksiBeli;
    }

    public static void setKodeTransaksiBeli(String KodeTransaksiBeli) {
        session.KodeTransaksiBeli = KodeTransaksiBeli;
    }

    public static String getKembalian() {
        return Kembalian;
    }

    public static void setKembalian(String Kembalian) {
        session.Kembalian = Kembalian;
    }

    public static String getIdSupplier() {
        return idSupplier;
    }

    public static void setIdSupplier(String idSupplier) {
        session.idSupplier = idSupplier;
    }
    
    public static String getSisaBayar() {
        return SisaBayar;
    }

    public static void setSisaBayar(String SisaBayar) {
        session.SisaBayar = SisaBayar;
    }

    public static String getKodeTransaksi() {
        return KodeTransaksi;
    }

    public static void setKodeTransaksi(String KodeTransaksi) {
        session.KodeTransaksi = KodeTransaksi;
    }

    public static int getStok() {
        return stok;
    }

    public static void setStok(int stok) {
        session.stok = stok;
    }
    
    public static String getIdUser() {
        return idUser;
    }

    public static void setIdUser(String idUser) {
        session.idUser = idUser;
    }

    public static String getKodeBarang() {
        return KodeBarang;
    }

    public static void setKodeBarang(String KodeBarang) {
        session.KodeBarang = KodeBarang;
    }
    
    public static String getU_Username() {
        return U_Username;
    }

    public static void setU_Username(String U_Username) {
        session.U_Username = U_Username;
    }

    public static String getU_email() {
        return U_email;
    }

    public static void setU_email(String U_email) {
        session.U_email = U_email;
    }
    
    public static String getU_Id() {
        return U_id;
    }
    
    public static void setU_id(String U_id){
        session.U_id = U_id;
    }
    
}
