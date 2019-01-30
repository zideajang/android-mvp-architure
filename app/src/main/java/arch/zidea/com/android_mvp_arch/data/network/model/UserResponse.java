package arch.zidea.com.android_mvp_arch.data.network.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

    @SerializedName("login")
    private String login;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;

    public UserResponse(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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
}
