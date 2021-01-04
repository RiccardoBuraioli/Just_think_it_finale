package entity;

public class CaritasUser {

    private int id;
    private String nomeCaritas;
    private String password;
    private String indirizzoCaritas;
    private String tipologia;
    private String recapitoTelefonico;
    private String email;
    private String citta;
    private static final String tableName = "caritas";


    public CaritasUser() {
    }

    public CaritasUser(String nomeCaritas, String passwordCaritas, String indirizzoCaritas, String tipologia, String recapitoTelefonico, String email, String citta) {
        this.nomeCaritas = nomeCaritas;
        this.password = passwordCaritas;
        this.indirizzoCaritas = indirizzoCaritas;
        this.tipologia = tipologia;
        this.recapitoTelefonico = recapitoTelefonico;
        this.email = email;
        this.citta = citta;
    }
    
    public String getCitta() {
    	return citta;
    }
    
    public void setCitta( String newcity) {
    	this.citta = newcity;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) this.id = id;

    }

    public String getNomeCaritas() {
        return nomeCaritas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzoCaritas() {
        return indirizzoCaritas;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getRecapitoTelefonico() {
        return recapitoTelefonico;
    }

    public String getEmail() {
        return email;
    }

    public void setNomeCaritas(String nomeCaritas) {
        this.nomeCaritas = nomeCaritas;
    }

    public void setIndirizzoCaritas(String indirizzoCaritas) {
        this.indirizzoCaritas = indirizzoCaritas;
    }

    public void setTipologia(String string) {
        this.tipologia = string;
    }

    public void setRecapitoTelefonico(String recapitoTelefonico) {
        this.recapitoTelefonico = recapitoTelefonico;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTableName() {
        return tableName;
    }

    @Override
    public String toString() {
        return "CaritasUser{" +
                "id=" + id +
                ", nomeCaritas='" + nomeCaritas + '\'' +
                ", password='" + password + '\'' +
                ", indirizzoCaritas='" + indirizzoCaritas + '\'' +
                ", tipologia='" + tipologia + '\'' +
                ", recapitoTelefonico='" + recapitoTelefonico + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}