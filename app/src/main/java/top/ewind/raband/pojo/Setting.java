package top.ewind.raband.pojo;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "setting")
public class Setting {

    @Column(name = "id", isId = true)
    private int id;

    @Column(name = "name")
    public String name;

    @Column(name = "value")
    private String value;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
