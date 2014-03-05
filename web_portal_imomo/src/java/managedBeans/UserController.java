    package managedBeans;

import entities.Role;
import entities.User;
import entities.UserRole;
import managedBeans.util.JsfUtil;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ManagedBean(name = "userController")
@SessionScoped
public class UserController extends AbstractController<User> implements Serializable
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    @EJB
    private sessionBeans.UserFacade ejbUser;
    private UIInput inputHtmlPassword;
    private UIInput inputHtmlConfirmPassword;
    private String confirmPassword;
    private List<User> listFilteredUsers; //this list is used in UserAdmin page to contain the results of the filter in DataTable
    private String newPassword;
    private List<String> listRoles; //this list
    private Short GameUserProfLevel;

    @EJB
    private sessionBeans.RoleFacade ejbRole;
    @EJB
    private sessionBeans.UserRoleFacade ejbUserRole;

    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public UserController()
        {
        super(User.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbUser);
        }
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    @Override
    public String create()
        {
        String userHashedPassword = tools.Tools.hashPassword(current.getPassword());
        current.setPassword(userHashedPassword);
        System.out.println("*************** newUser ************** ");
        System.out.println("nickname : " + current.getNickname());
        System.out.println("firstname : " + current.getFirstname());
        System.out.println("lastname : " + current.getLastname());
        System.out.println("password : " + current.getPassword());
        System.out.println("phone : " + current.getPhoneNb());
        System.out.println("culture :" + current.getCulture());
        System.out.println("gsmTerminalID : " + current.getGsmTerminalID());
        System.out.println("*************** ******* ************** ");
        //This username lets us to get the User object in order to get the ID of the new user
        String username = current.getNickname();

        try
            {
            System.out.println("Create user");
            getFacade().create(current);

            //Management of roles for the user
            User user = ejbUser.getUser(username); //this object is necessary to create the UserRole object later
            UserRole userRole = new UserRole();
            userRole.setRole("game_users");
            userRole.setUserID(user);
            System.out.println("Create userRole");
            ejbUserRole.create(userRole);
            user.getUserRoleList().add(userRole);



            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/i18n").getString("involvedUserCreated"));
            prepareCreate();
            return "";
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/i18n").getString("involvedUserNotCreated"));
            return null;
            }
        }
    @Override
    public String update(String path){
        System.out.println("in update()");
        try{
            System.out.println("in update()->try");
            //The old password is changed
            if (!this.newPassword.equals("")){
                this.current.setPassword(tools.Tools.hashPassword(this.newPassword));
            }

            //all the roles of current user are deleted
            ejbUserRole.deleteRoles(current);
            current.getUserRoleList().clear();
            //the new roles are created here
            for (String strRole : this.listRoles){
                UserRole userRole = new UserRole();
                userRole.setUserID(current);
                userRole.setRole(strRole);
                current.getUserRoleList().add(userRole);
                ejbUserRole.create(userRole);
            }
            try{
                System.out.println("in try, before edit current");
                getFacade().edit(current);
                System.out.println("in try, after edit current");
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemUpdated"));
                return path + "List";
            }
            catch (Exception e){
                System.out.println("in catch, instead of edit current");
                JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
                return null;
            }

//            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemUpdated"));
//            return path + "List";
        }
        catch (Exception e){
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
        }
    /*-----------------------------------
     get
     ------------------------------------*/
    public UIInput getInputHtmlPassword()
        {
        return inputHtmlPassword;
        }
    public UIInput getInputHtmlConfirmPassword()
        {
        return inputHtmlConfirmPassword;
        }
    public String getConfirmPassword()
        {
        return confirmPassword;
        }
    public List<Role> getRoles()
        {
        return ejbRole.getRoles();
        }
    public List<User> getListFilteredUsers()
        {
        return listFilteredUsers;
        }
    public String getNewPassword()
        {
        return newPassword;
        }
    public List<String> getListRoles()
        {
        if (listRoles == null)
            {
            listRoles = new LinkedList<String>();
            }
        List<UserRole> list = ejbUserRole.getUserRoleList(current);
        listRoles.clear();
        for (UserRole userRole : list)
            {
            listRoles.add(userRole.getRole());
            }
        return listRoles;
        }
    public List<String> getListRoles(User user)
        {
        List<String> list = new LinkedList<String>();
        for (UserRole userRole : ejbUserRole.getUserRoleList(user))
            {
            list.add(userRole.getRole());
            }
        return list;
        }
    /*-----------------------------------
     set
     ------------------------------------*/
    public void setListRoles(List<String> listRoles)
        {
        this.listRoles = listRoles;
        }
    public void setNewPassword(String newPassword)
        {
        this.newPassword = newPassword;
        }
    public void setListFilteredUsers(List<User> listFilteredUsers)
        {
        this.listFilteredUsers = listFilteredUsers;
        }
    public void setConfirmPassword(String confirmPassword)
        {
        this.confirmPassword = confirmPassword;
        }
    public void setInputHtmlPassword(UIInput inputHtmlPassword)
        {
        this.inputHtmlPassword = inputHtmlPassword;
        }
    public void setInputHtmlConfirmPassword(UIInput inputHtmlConfirmPassword)
        {
        this.inputHtmlConfirmPassword = inputHtmlConfirmPassword;
        }
    
    public Short getGameUserProfLevel(Integer userID) {
        return GameUserProfLevel;
    }

    public void setGameUserProfLevel(Short GameUserProfLevel) {
        this.GameUserProfLevel = GameUserProfLevel;
    }
    
    /*-----------------------------------
     FacesValidator
     ------------------------------------*/

    @FacesValidator("usernameValidator")
    public static class UsernameValidator implements Validator
        {
        @Override
        public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
            {
            UserController controller = (UserController) context.getApplication().getELResolver().getValue(context.getELContext(), null, "userController");
            String username = (String) value;
            if (username.matches("^\\S*[ ]{1,}\\S*$"))
                {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/resources/i18n").getString("involvedInvalidUsername"), null));
                }
            if (controller.ejbUser.exists(username))
                {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/resources/i18n").getString("involvedUsernameAlreadyExistError"), null));
                }
            }
        }

    @FacesValidator("confirmPasswordValidator")
    public static class ConfirmPasswordValidator implements Validator
        {
        @Override
        public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException
            {
            String password = (String) value;
            String confirm = (String) component.getAttributes().get("involvedConfirmPassword");
            if (password == null || confirm == null)
                {
                return; // Just ignore and let required="true" do its job.
                }
            if (!password.equals(confirm))
                {
                throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, ResourceBundle.getBundle("/resources/i18n").getString("involvedPasswordNotEqualsError"), null));
                }
            }
        }
}
