package managedBeans;

import entities.GamePossibleResponseLocal;
import entities.GamePossibleResponseLocalPK;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managedBeans.util.JsfUtil;

@ManagedBean(name = "gamePossibleResponseLocalController")
@SessionScoped
public class GamePossibleResponseLocalController extends AbstractController<GamePossibleResponseLocal> implements Serializable
    {
    @EJB
    private sessionBeans.GamePossibleResponseLocalFacade ejbFacade;
    private GamePossibleResponseLocal gamePossibleResponseLocalTranslation;

    public GamePossibleResponseLocalController()
        {
            super(GamePossibleResponseLocal.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }

    public GamePossibleResponseLocal getGamePossibleResponseLocalTranslation(Integer possibleResponseID, String code) {
        return gamePossibleResponseLocalTranslation;
    }

    public void setGamePossibleResponseLocalTranslation(GamePossibleResponseLocal gamePossibleResponseLocalTranslation) {
        this.gamePossibleResponseLocalTranslation = gamePossibleResponseLocalTranslation;
    }
    
    //todo getAnswer (param id)
    public List<GamePossibleResponseLocal> getallPossibleResponseLocal(Integer possibleResponseID){
        return ejbFacade.getallPossibleResponseLocal(possibleResponseID);
    }
    
    @Override
    public String create(){
//        current.setQuestionID(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());                
//        current.setCultureCode("en");

        GamePossibleResponseLocalPK newPK = new GamePossibleResponseLocalPK();
        newPK.setPossibleResponseID(GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID());        
        newPK.setCultureCode("en");
        
        current.setGamePossibleResponseLocalPK(newPK);
        
        System.out.println("*************** newGamePossibleResponseLocal ************** ");
//        System.out.println("questionID : " + current.getQuestionID());
//        System.out.println("cultureCode : " + current.getCultureCode());        
        System.out.println("text : " + current.getText());         
        System.out.println("*************** ******* ************** ");

        try
            {
            System.out.println("Create GamePossibleResponseLocal");                     
            getFacade().create(current);

            JsfUtil.addSuccessMessage("New translation created");
            prepareCreate();
            return "";
            }
        catch (Exception e)
            {
              JsfUtil.addErrorMessage(e.getMessage());              
            return null;
            }
        }
    public String createSW(){
//        current.setQuestionID(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());                
//        current.setCultureCode("en");

        GamePossibleResponseLocalPK newPK = new GamePossibleResponseLocalPK();
        newPK.setPossibleResponseID(GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID());        
        newPK.setCultureCode("sw");
        
        current.setGamePossibleResponseLocalPK(newPK);
        
        System.out.println("*************** newGamePossibleResponseLocal ************** ");
//        System.out.println("questionID : " + current.getQuestionID());
//        System.out.println("cultureCode : " + current.getCultureCode());        
        System.out.println("text : " + current.getText());         
        System.out.println("*************** ******* ************** ");

        try
            {
            System.out.println("Create GamePossibleResponseLocal");                     
            getFacade().create(current);

            JsfUtil.addSuccessMessage("New translation created");
            prepareCreate();
            return "";
            }
        catch (Exception e)
            {
              JsfUtil.addErrorMessage(e.getMessage());              
            return null;
            }
        }
    
    @Override
    public String delete(String path){
        
        GamePossibleResponseLocal x = ejbFacade.getGamePossibleResponseLocalTranslation(GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID(), "en");

        System.out.println("responseID: " + GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID());
        System.out.println("x: " + x);
        try{
            getFacade().remove(x);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));

            return path + "List";
        }
        catch (Exception e){
           JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
           return null;               
        }
    }
    
    public String deleteSW(String path){
        
        GamePossibleResponseLocal x = ejbFacade.getGamePossibleResponseLocalTranslation(GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID(), "sw");

        System.out.println("responseID: " + GamePossibleResponseController.selectedPossibleResponse.getPossibleResponseID());
        System.out.println("x: " + x);
        try{
            getFacade().remove(x);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));

            return path + "List";
        }
        catch (Exception e){
           JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
           return null;               
        }
    }
    }
