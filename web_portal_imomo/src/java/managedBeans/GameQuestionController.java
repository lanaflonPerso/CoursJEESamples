package managedBeans;

import beans.AnswerContainer;
import beans.PossibleResponseContainer;
import beans.QuestionContainer;
import entities.GamePossibleResponse;
import entities.GamePossibleResponseLocal;
import entities.GameQuestion;
import entities.GameQuestionLocal;
import entities.GameQuestionLocalPK;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import sessionBeans.GamePossibleResponseFacade;

@ManagedBean(name = "gameQuestionController")
@SessionScoped
public class GameQuestionController extends AbstractController<GameQuestion> implements Serializable {

    public PossibleResponseContainer selectedContainer;
    private TreeNode selectedNode;
    public static QuestionContainer selectedQuestionContainer;
    public PossibleResponse selectedPossibleResponse;
    public AnswerContainer selectedAnswerContainer;

    public GameQuestionController() {
        super(GameQuestion.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public QuestionContainer getSelectedQuestionContainer() {
        return selectedQuestionContainer;
    }

    public void setSelectedQuestionContainer(QuestionContainer selectedQuestionContainer) {
        this.selectedQuestionContainer = selectedQuestionContainer;
    }
    
    public AnswerContainer getSelectedAnswerContainer() {
        return selectedAnswerContainer;
    }

    public void setSelectedAnswerContainer(AnswerContainer selectedAnswerContainer) {
        this.selectedAnswerContainer = selectedAnswerContainer;
    }
    
    public PossibleResponse getSelectedPossibleResponse() {
        return selectedPossibleResponse;
    }

    public void setSelectedPossibleResponse(PossibleResponse selectedPossibleResponse) {
        this.selectedPossibleResponse = selectedPossibleResponse;
    }
    
    @EJB
    private sessionBeans.GameQuestionFacade ejbFacade;
    @EJB
    private sessionBeans.GameQuestionLocalFacade ejbGameQuestionLocalFacade;
    @EJB
    private sessionBeans.GamePossibleResponseFacade ejbPossibleResponseFacade;
    @EJB
    private sessionBeans.GamePossibleResponseLocalFacade ejbPossibleResponseLocalFacade;
    
    
//    private TreeNode root;

    public PossibleResponseContainer getSelectedContainer() {
        return selectedContainer;
    }

    public void setSelectedContainer(PossibleResponseContainer selectedContainer) {
        this.selectedContainer = selectedContainer;
    }
    
//    public TreeNode getSelectedNode() {
//        return selectedNode;
//    }
//
//    public void setSelectedNode(TreeNode selectedNode) {
//        this.selectedNode = selectedNode;
//    }
   
    @Override
    public String create(){  
        System.out.println("*************** newQuestion ************** ");
        System.out.println("keyword : " + current.getKeyword());
        System.out.println("variableID : " + current.getVariableID().getVariableID());
        System.out.println("user response allowed : " + current.getUserResponseAllowed());
//        System.out.println("time between responses : " + current.getTimeBetweenResponses());    
        System.out.println("*************** ******* ************** ");

//        String questionKeyword = current.getKeyword(); // will need it later to get the new question's ID
        if (current.getVariableID().getVariableID() < 0){
            JsfUtil.addErrorMessage("Please select a variable");
        }
        try{
            System.out.println("Create question");
            getFacade().create(current);
                        
            //Management of question locals
//            GameQuestion gameQuestion = ejbFacade.getGameQuestion(questionKeyword); //this object is necessary to create the UserRole object later
//            GameQuestionLocalPK gameQuestionLocalPK = new GameQuestionLocalPK();
//            gameQuestionLocalPK.setQuestionID(gameQuestion.getQuestionID());
//            
//            //TODO something to link GameQuestionLocalPK with GameQuestionLocal
//            System.out.println("Create GameQuestionLocal EN");
//            ejbGameQuestionLocalFacade.create(gameQuestionLocal);
//            ejbUserRole.create(userRole);

//            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/i18n").getString("involvedUserCreated"));
            JsfUtil.addSuccessMessage("New question created");
            prepareCreate();            
            return "";
            }
        catch (Exception e)
            {
//            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/i18n").getString("involvedUserNotCreated"));
              JsfUtil.addErrorMessage(e.getMessage());              
            return null;
            }
        }

        @Override
        public String update(String path)
        {
        System.out.println("in GQController update()");            
        try
            {
            System.out.println("in GQController update() try"); 
            System.out.println("userResponseAllowed:" + this.selectedQuestionContainer.getGameQuestion().getUserResponseAllowed());
//            Boolean x = this.selectedQuestionContainer.getGameQuestion().getUserResponseAllowed();
//            if (this.selectedQuestionContainer.getGameQuestion().getUserResponseAllowed()){
//                System.out.println("in GQController update() try if");                
//                x = true;
//                this.selectedQuestionContainer.getGameQuestion().setUserResponseAllowed(true);
//            }
//            else{
//                System.out.println("in GQController update() try else");
//                x = false;
//                this.selectedQuestionContainer.getGameQuestion().setUserResponseAllowed(false);
//            }            
//            
            // TODO manage translations!
                      
            
            getFacade().edit(this.selectedQuestionContainer.getGameQuestion());

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
                List <GamePossibleResponse> list = ejbFacade.getGamePossibleResponse(this.selectedQuestionContainer.getGameQuestion().getQuestionID());
                Integer testVar = 0;
                
                for (GamePossibleResponse gpr : list){                    
                    if (ejbPossibleResponseFacade.getNumberOfUserAnswers(gpr.getPossibleResponseID()) != 0){
                        testVar = 1;
                    } 
                }
                
                if (testVar == 1){ // if there is at least 1 user answer, don't delete the question
                    JsfUtil.addErrorMessage("This question cannot be deleted because one or more user answers are associated to it.");
                }
                else{                     
                    for (GamePossibleResponse gpr : list){
                        ejbPossibleResponseLocalFacade.deleteTranslations(gpr.getPossibleResponseID()); // delete GPRL
                        ejbPossibleResponseFacade.remove(gpr); // delete GPR
                    }
                    ejbGameQuestionLocalFacade.deleteTranslations(this.selectedQuestionContainer.getGameQuestion().getQuestionID()); // delete GQL
                    getFacade().remove(this.selectedQuestionContainer.getGameQuestion()); // delete GQ
                    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));
                }

                return path + "List";
            }
            
            catch (Exception e){
               JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
               return null;               
            }
        }
                
    public List<QuestionContainer> getAllQuestion() {
        return ejbFacade.getAllQuestion();
    }
    
    public List<GamePossibleResponse> getallPossibleResponse() {
        return ejbFacade.getallPossibleResponse();
    }
    
    public List<GamePossibleResponse> getGamePossibleResponse(Integer idQuestion) {
        return ejbFacade.getGamePossibleResponse(idQuestion);
    }
    
    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseLocal(Integer gameQuestion) {
        return ejbFacade.getGamePossibleResponseLocal(gameQuestion);
    }
    
    public List<List<GamePossibleResponseLocal>> getGamePossibleResponseL(Integer gameQuestion, Integer gamePossibleResponseID) {
        return ejbFacade.getGamePossibleResponseL(gameQuestion, gamePossibleResponseID);
    }

//    public void onCellEdit(CellEditEvent event) {
//        ejbFacade.onCellEdit(event);
//    }
//
//    public TreeNode getRoot() {
//        root = new DefaultTreeNode("root", null); //set root
//
//        List<GameQuestion> gameQuestionList = ejbFacade.getQuestions();
//
//        for (GameQuestion gq : gameQuestionList) {
//            TreeNode gameQuestion = new DefaultTreeNode(new PossibleResponseContainer(gq, ejbFacade.getGameQuestionLocal(gq)), root);
//            createNode(gq.getQuestionID(), gameQuestion);
//        }
//
//        return root;
//    }

//    private List<DefaultTreeNode> createNode(Integer idParent, TreeNode parent) {
//        List<List<GamePossibleResponseLocal>> gameResponseList = ejbPossibleResponseFacade.getGamePossibleResponseLocal(idParent);
//        List<DefaultTreeNode> listDefaultTreeNode = new ArrayList<DefaultTreeNode>();
//        for (List<GamePossibleResponseLocal> gpr : gameResponseList) {
//            listDefaultTreeNode.add(new DefaultTreeNode(new PossibleResponseContainer(ejbFacade.getGamePossibleResponse(idParent), gpr), parent));
//        }
//        return listDefaultTreeNode;
//    }
  
    public void test(Integer questionID) {
        System.out.println("test function, should display some info");         
        try {
             System.out.println("in try");         
             System.out.println("question ID with this:" + this.selectedQuestionContainer.getGameQuestion().getQuestionID());
             System.out.println("variable ID:" + this.selectedQuestionContainer.getGameQuestion().getVariableID().getVariableID());
             System.out.println("question keyword:" + this.selectedQuestionContainer.getGameQuestion().getKeyword());
             System.out.println("question time: " + this.selectedQuestionContainer.getGameQuestion().getTimeBetweenResponses());
             System.out.println("answer allowed: " + this.selectedQuestionContainer.getGameQuestion().getUserResponseAllowed());
         }catch (Exception e) {
             System.out.println("in catch");             
        }        
    }

    public void createAnswer() {
        System.out.println("createAnswer function");         
        try {
             System.out.println("in try");         
             System.out.println("question ID:" + this.selectedQuestionContainer.getGameQuestion().getQuestionID());
             GamePossibleResponse gpr = new GamePossibleResponse();
             gpr.setQuestionID(this.selectedQuestionContainer.getGameQuestion());
             gpr.setKeyword("");             
             gpr.setValue(0.0);
             ejbPossibleResponseFacade.create(gpr);             
         }catch (Exception e) {
             System.out.println("in catch");                
        }
        
    }
    
     public void reset() {
        RequestContext.getCurrentInstance().reset("addQuestionForm:addquestion");
     }            
        
//    public void onNodeSelect(NodeSelectEvent event) {  
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().getData().getClass().getName());         
//        FacesContext.getCurrentInstance().addMessage(null, message);  
//        toto();
//    }      
}