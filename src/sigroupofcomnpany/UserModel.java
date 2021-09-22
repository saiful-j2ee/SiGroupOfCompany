/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sigroupofcomnpany;

/**
 *
 * @author MD.Saiful Islam
 */
public class UserModel {
    private int id;
    private String username;
    private String password;
    private String userrole;

    public UserModel(int id, String username, String password, String userrole) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userrole = userrole;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
