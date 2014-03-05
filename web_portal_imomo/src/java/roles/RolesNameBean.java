/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package roles;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Raphaël
 */
@ManagedBean(name = "rolesBean")
@ApplicationScoped
public class RolesNameBean
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    public String roleAdmin;
    public String roleGameUsers;
    public String rolePbwb;
    public String roleResearch;
    public String roleImomoTeam;
    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public RolesNameBean()
        {
        }
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    @PostConstruct
    public void init()
        {
        roleAdmin = RoleFilter.roleAdmin;
        roleGameUsers = RoleFilter.roleGameUsers;
        rolePbwb = RoleFilter.rolePbwb;
        roleResearch = RoleFilter.roleResearch;
        roleImomoTeam = RoleFilter.roleImomoTeam;
        }
    public String getRoleAdmin()
        {
        return roleAdmin;
        }
    public String getRoleGameUsers()
        {
        return roleGameUsers;
        }
    public String getRolePbwb()
        {
        return rolePbwb;
        }
    public String getRoleResearch()
        {
        return roleResearch;
        }
    public String getRoleImomoTeam()
        {
        return roleImomoTeam;
        }
    }
