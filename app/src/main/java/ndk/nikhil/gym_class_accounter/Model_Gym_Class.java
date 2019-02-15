package ndk.nikhil.gym_class_accounter;

public class Model_Gym_Class {
    public static final String TABLE_NAME = "gym_class";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ADDRESS = "address";
    public static final String COLUMN_PHOTO = "photo";
    public static final String COLUMN_JOIN_DATE = "join_date";
    public static final String COLUMN_FEE_STRUCTURE = "fee_structure";
    public static final String COLUMN_FEE = "fee";
    // Create table SQL query
    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_NAME + " TEXT,"
                    + COLUMN_ADDRESS + " TEXT,"
                    + COLUMN_PHOTO + " TEXT,"
                    + COLUMN_JOIN_DATE + " TEXT,"
                    + COLUMN_FEE_STRUCTURE + " TEXT,"
                    + COLUMN_FEE + " TEXT"
                    + ")";
    private int id;
    private String name, address, photo, join_date, fee_structure, fee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getJoin_date() {
        return join_date;
    }

    public void setJoin_date(String join_date) {
        this.join_date = join_date;
    }

    public String getFee_structure() {
        return fee_structure;
    }

    public void setFee_structure(String fee_structure) {
        this.fee_structure = fee_structure;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }
}
