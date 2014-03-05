package managedBeans;

import entities.GameQuestionLocal;
import entities.GameQuestionLocalPK;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managedBeans.util.JsfUtil;

@ManagedBean(name = "gameQuestionLocalController")
@SessionScoped
public class GameQuestionLocalController extends AbstractController<GameQuestionLocal> implements Serializable
    {
    @EJB
    private sessionBeans.GameQuestionLocalFacade ejbFacade;
    @EJB
    private sessionBeans.CultureFacade ejbCultureFacade;   
    
    private GameQuestionLocal gameQuestionLocalTranslation;

   
    public GameQuestionLocalController()
        {
            super(GameQuestionLocal.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
    
    public GameQuestionLocal getGameQuestionLocalTranslation(Integer questionID, String code) {
        return gameQuestionLocalTranslation;
    }

    public void setGameQuestionLocalTranslation(GameQuestionLocal gameQuestionLocalTranslation) {
        this.gameQuestionLocalTranslation = gameQuestionLocalTranslation;
    }
    
    @Override
    public String create(){

        GameQuestionLocalPK newPK = new GameQuestionLocalPK();
        newPK.setQuestionID(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());
        newPK.setCultureCode("en");
        
        current.setGameQuestionLocalPK(newPK);
        
        System.out.println("*************** newGameQuestionLocal ************** ");
//        System.out.println("questionID : " + current.getQuestionID());
//        System.out.println("cultureCode : " + current.getCultureCode());        
        System.out.println("text : " + current.getText());         
        System.out.println("*************** ******* ************** ");

        try
            {
            System.out.println("Create GameQuestionLocal");                     
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

        GameQuestionLocalPK newPK = new GameQuestionLocalPK();
        newPK.setQuestionID(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());
        newPK.setCultureCode("sw");
        
        current.setGameQuestionLocalPK(newPK);
        
        System.out.println("*************** newGameQuestionLocal ************** ");
//        System.out.println("questionID : " + current.getQuestionID());
//        System.out.println("cultureCode : " + current.getCultureCode());        
        System.out.println("text : " + current.getText());         
        System.out.println("*************** ******* ************** ");

        try
            {
            System.out.println("Create GameQuestionLocal");                     
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
        
        GameQuestionLocal x = ejbFacade.getGameQuestionLocalTranslation(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID(), "en");
//        this.current = x;
        System.out.println("questionID: " + GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());
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
        
        GameQuestionLocal x = ejbFacade.getGameQuestionLocalTranslation(GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID(), "sw");
//        this.current = x;
        System.out.println("questionID: " + GameQuestionController.selectedQuestionContainer.getGameQuestion().getQuestionID());
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
