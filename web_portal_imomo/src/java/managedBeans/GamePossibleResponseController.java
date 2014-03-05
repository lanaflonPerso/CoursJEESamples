package managedBeans;

import beans.AnswerContainer;
import beans.PossibleResponseContainer;
import entities.GamePossibleResponse;
import entities.GameQuestion;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import managedBeans.util.JsfUtil;

@ManagedBean(name = "gamePossibleResponseController")
@SessionScoped
public class GamePossibleResponseController extends AbstractController<GamePossibleResponse> implements Serializable
    {
    @EJB
    private sessionBeans.GamePossibleResponseFacade ejbFacade;
    @EJB
    private sessionBeans.GameQuestionFacade ejbGameQuestionFacade;    
    @EJB
    private sessionBeans.GamePossibleResponseLocalFacade ejbGamePossibleResponseLocalFacade;

    private AnswerContainer selectedAnswerContainer;
    
    public static GamePossibleResponse selectedPossibleResponse;

  
    public GamePossibleResponseController()
        {
            super(GamePossibleResponse.class);
        }
    @PostConstruct
    public void init()
        {
        super.setFacade(ejbFacade);
        }

    public GamePossibleResponse getSelectedPossibleResponse() {
        return selectedPossibleResponse;
    }

    public void setSelectedPossibleResponse(GamePossibleResponse selectedPossibleResponse) {
        this.selectedPossibleResponse = selectedPossibleResponse;
    }
    
    public List <PossibleResponseContainer> getAllPossibleResponse() {
        return ejbFacade.getAllPossibleResponse();
    }

    public AnswerContainer getSelectedAnswerContainer() {
        return selectedAnswerContainer;
    }

    public void setSelectedAnswerContainer(AnswerContainer selectedAnswerContainer) {
        this.selectedAnswerContainer = selectedAnswerContainer;
    }
                    
    public String create()
        {          
                    
        current.setQuestionID(GameQuestionController.selectedQuestionContainer.getGameQuestion());
        
        System.out.println("*************** newAnswer ************** ");
        System.out.println("questionID : " + current.getQuestionID().getQuestionID());
        System.out.println("keyword : " + current.getKeyword());        
        System.out.println("value : " + current.getValue());        
        System.out.println("*************** ******* ************** ");

        try
            {
            System.out.println("Create answer");
            getFacade().create(current);

            JsfUtil.addSuccessMessage("New answer created");
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
        public String update(String path)
        {
        System.out.println("in GPRController update()");            
        try
            {
            System.out.println("in GPRController update() try"); 
          
            // TODO manage translations!
           
            getFacade().edit(this.selectedPossibleResponse);

            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemUpdated"));
            return path + "List";
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
            }
        }
            
   @Override
    public String delete(String path){
        try{
            if (ejbFacade.getNumberOfUserAnswers(this.selectedPossibleResponse.getPossibleResponseID()) == 0){ 
                ejbGamePossibleResponseLocalFacade.deleteTranslations(this.selectedPossibleResponse.getPossibleResponseID());
                getFacade().remove(this.selectedPossibleResponse);
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));
                return path + "List";
            }
            else {
                JsfUtil.addErrorMessage("This answer cannot be deleted because one or more user answers are associated to it.");
                return path + "List";
            }
        }
        catch (Exception e){
           JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
           return null;               
        }
    }
   
       public void test(Integer answerID) {
        System.out.println("test function PRController, should display some info");         
        try {
             System.out.println("in try");
             System.out.println("answer ID this.:" + this.selectedPossibleResponse.getPossibleResponseID());
             System.out.println("question ID:" + this.selectedPossibleResponse.getQuestionID().getQuestionID());
             System.out.println("keyword:" + this.selectedPossibleResponse.getKeyword());
             System.out.println("value: " + this.selectedPossibleResponse.getValue());             
         }catch (Exception e) {
             System.out.println("in catch");             
        }
    }

    }

