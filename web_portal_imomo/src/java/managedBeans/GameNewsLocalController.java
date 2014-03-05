package managedBeans;

import entities.GameNewsLocal;
import entities.GameNewsLocalPK;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managedBeans.util.JsfUtil;

@ManagedBean(name = "gameNewsLocalController")
@SessionScoped
public class GameNewsLocalController extends AbstractController<GameNewsLocal> implements Serializable
    {
    @EJB
    private sessionBeans.GameNewsLocalFacade ejbFacade;
    @EJB
    private sessionBeans.CultureFacade ejbCultureFacade;   
    
    private GameNewsLocal gameNewsLocalTranslation;

   
    public GameNewsLocalController()
        {
            super(GameNewsLocal.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }
    
    public GameNewsLocal getGameNewsLocalTranslation(Integer newsID, String code) {
        return gameNewsLocalTranslation;
    }

    public void setGameNewsLocalTranslation(GameNewsLocal gameNewsLocalTranslation) {
        this.gameNewsLocalTranslation = gameNewsLocalTranslation;
    }
    
    @Override
    public String create(){

        GameNewsLocalPK newPK = new GameNewsLocalPK();
        newPK.setNewsID(GameNewsController.selectedNewsContainer.getGameNews().getNewsID());                
        newPK.setCultureCode("en");
        
        current.setGameNewsLocalPK(newPK);
        
        try
            {
            System.out.println("Create GameNewsLocal");                     
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

        GameNewsLocalPK newPK = new GameNewsLocalPK();
        newPK.setNewsID(GameNewsController.selectedNewsContainer.getGameNews().getNewsID());
        newPK.setCultureCode("sw");
        
        current.setGameNewsLocalPK(newPK);
        
        try
            {
            System.out.println("Create GameNewsLocal");                     
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
        
        GameNewsLocal x = ejbFacade.getGameNewsLocalTranslation(GameNewsController.selectedNewsContainer.getGameNews().getNewsID(), "en");
        System.out.println("newsID: " + GameNewsController.selectedNewsContainer.getGameNews().getNewsID());
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
        
        GameNewsLocal x = ejbFacade.getGameNewsLocalTranslation(GameNewsController.selectedNewsContainer.getGameNews().getNewsID(), "sw");
        System.out.println("newsID: " + GameNewsController.selectedNewsContainer.getGameNews().getNewsID());
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
