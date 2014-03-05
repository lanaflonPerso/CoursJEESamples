package managedBeans;

import beans.NewsContainer;
import entities.GameNews;
import entities.GameNewsLocal;
import entities.GameNewsLocalPK;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.validation.ValidationException;
import javax.validation.ConstraintViolationException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import managedBeans.util.JsfUtil;
import org.primefaces.context.RequestContext;

@ManagedBean(name = "gameNewsController")
@SessionScoped
public class GameNewsController extends AbstractController<GameNews> implements Serializable {
    public static NewsContainer selectedNewsContainer;

    public GameNewsController() {
        super(GameNews.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
 
    public NewsContainer getSelectedNewsContainer() {
        return selectedNewsContainer;
    }

    public void setSelectedNewsContainer(NewsContainer selectedNewsContainer) {
        this.selectedNewsContainer = selectedNewsContainer;
    }  
  
    @EJB
    private sessionBeans.GameNewsFacade ejbFacade;
    @EJB
    private sessionBeans.GameNewsLocalFacade ejbGameNewsLocalFacade;

    @Override
    public String create(){  
        try{
            System.out.println("Create news");
            Date date = new Date();
            SimpleDateFormat sdfutc = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            sdfutc.setTimeZone(TimeZone.getTimeZone("UTC"));
            System.out.println("sdf: " + sdfutc);
            
            SimpleDateFormat sdflocal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");            
            System.out.println("sdf: " + sdflocal);
            
            String dateInDatabaseFormat = sdfutc.format(date);
            System.out.println("dateInDatabaseFormat: " + dateInDatabaseFormat);
            Date d1 = sdflocal.parse(dateInDatabaseFormat);
            System.out.println("Date read from database: " + d1);

            current = null;
            current = new GameNews();            
            current.setDateTimeUTC(d1);
                        
            System.out.println("datetimeutc: " + current.getDateTimeUTC());
            getFacade().create(current);            
            JsfUtil.addSuccessMessage("News created");
            prepareCreate();            
            return "";
        }
        catch (Exception e){
            JsfUtil.addErrorMessage(e.getMessage());              
            return null;
        }
    }
    
        @Override
        public String delete(String path){
            try{
                ejbGameNewsLocalFacade.deleteTranslations(this.selectedNewsContainer.getGameNews().getNewsID()); // delete Game News Locals
                getFacade().remove(this.selectedNewsContainer.getGameNews()); // delete Game News
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));
                return path + "news";
            }            
            catch (Exception e){
               JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
               return null;               
            }
        }
                
    public List<NewsContainer> getAllNews() {
        return ejbFacade.getAllNews();
    }
    
    public void test(Integer newsID) {
        System.out.println("test function, should display some info");         
        try {
             System.out.println("in try");         
             System.out.println("news ID with this:" + this.selectedNewsContainer.getGameNews().getNewsID());
             System.out.println("datetimeUTC:" + this.selectedNewsContainer.getGameNews().getDateTimeUTC());             
         }catch (Exception e) {
             System.out.println("in catch");             
        }        
    }

//     public void reset() {
//        RequestContext.getCurrentInstance().reset("addQuestionForm:addquestion");
//     }                   
}