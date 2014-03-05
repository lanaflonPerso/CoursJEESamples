/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beansHoucem;

/**
 *
 * @author Houcem
 */
import static beansHoucem.Add.culture;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@SessionScoped
@ManagedBean(name = "documentController")
public class DocumentsController implements Serializable
    {
    private Selected selectedDocument;
    private TreeNode root;
    private List<TreeNode> Fr;
    public DocumentsController()
        {
        root = new DefaultTreeNode("root", null);
        ArrayList<TreeNode> T = new ArrayList<TreeNode>();
        ArrayList<TreeNode> T2 = new ArrayList<TreeNode>();
        String var = "-";
        int i = 0;
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            String q = "select game_question_local.text,game_question.questionID,userResponseAllowed,keyword,timeBetweenResponses,game_question_local.cultureCode,variableID from game_question,game_question_local where game_question_local.questionID=game_question.questionID and game_question_local.cultureCode='en'";
            String q2 = "select game_possible_response_local.text,game_possible_response.possibleResponseID,keyword,game_possible_response.value from game_possible_response,game_possible_response_local where questionID=? and cultureCode=? and game_possible_response.possibleResponseID=game_possible_response_local.possibleResponseID";
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            PreparedStatement ps3 = con.prepareStatement("select VariableName from variables where variableID=?");
            PreparedStatement ps4 = con.prepareStatement("select text from game_question_local where questionID=?");
            PreparedStatement ps5 = con.prepareStatement("select text from game_possible_response_local where possibleResponseID=?");
            PreparedStatement ps2 = con.prepareStatement(q2);
//Q
            while (rs.next())
                {
                ps3.setInt(1, rs.getInt(7));
                ResultSet rs3 = ps3.executeQuery();
                while (rs3.next())
                    {
                    var = rs3.getString(1);
                    }
                List<String> Question = new ArrayList<String>();

                ps4.setInt(1, rs.getInt(2));
                ResultSet rs4 = ps4.executeQuery();
                while (rs4.next())
                    {
                    Question.add(rs4.getString(1));
                    }

                T.add(new DefaultTreeNode(new Selected(rs.getString(1), rs.getInt(2), "q", rs.getBoolean(3) + "", rs.getString(4), rs.getString(5), rs.getString(6), "-", var, Question), root));
                ps2.setInt(1, rs.getInt(2));
                ps2.setString(2, rs.getString(6));
                ResultSet rs2 = ps2.executeQuery();
//R               

                while (rs2.next())
                    {
                    List<String> Reponse = new ArrayList<String>();

                    ps5.setInt(1, rs2.getInt(2));
                    ResultSet rs5 = ps5.executeQuery();
                    while (rs5.next())
                        {
                        Reponse.add(rs5.getString(1));
                        }
                    T2.add(new DefaultTreeNode(new Selected(rs2.getString(1), rs2.getInt(2), "r", "-", rs2.getString(3), "-", "-", rs2.getDouble(4) + "", "-", Reponse), T.get(i)));
                    }
                i++;
                }
            con.close();
            }
        catch (ClassNotFoundException ex)
            {
            }
        catch (SQLException ex)
            {
            }

        }
    public TreeNode getRoot()
        {
        return root;
        }
    public Selected getSelectedDocument()
        {
        return selectedDocument;
        }
    public void setSelectedDocument(Selected selectedDocument)
        {
        this.selectedDocument = selectedDocument;
        }
    public void delete()
        {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Message", getSelectedDocument().type + getSelectedDocument().x + getSelectedDocument().ID));

        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            Statement s = con.createStatement();
            if (getSelectedDocument().type.equals("q"))
                {
                System.out.println("****** DELETE QUESTION ********");
                System.out.println("" + getSelectedDocument().ID);
                String queryDeleteGamePossibleResponse = "DELETE FROM game_possible_response WHERE questionID = " + getSelectedDocument().ID;
                String queryDeleteGameResponse = "DELETE FROM game_response WHERE questionID=" + getSelectedDocument().ID;
                String queryDeleteGameQuestionLocal = "DELETE FROM game_question_local WHERE questionID=" + getSelectedDocument().ID;
                String queryDeleteGameQuestion = "DELETE FROM game_question WHERE questionID=" + getSelectedDocument().ID;
                s.execute(queryDeleteGameResponse);
                s.execute(queryDeleteGamePossibleResponse);
                s.execute(queryDeleteGameQuestionLocal);
                s.execute(queryDeleteGameQuestion);
                System.out.println("******** ************* ********");
                }
            else if (getSelectedDocument().type.equals("r"))
                {
                System.out.println("****** DELETE RESPONSE ********");
                System.out.println("" + getSelectedDocument().ID);
                s.execute("Delete from game_response where possibleResponseID=" + getSelectedDocument().ID + "");
                s.execute("Delete from game_possible_response where possibleResponseID=" + getSelectedDocument().ID + "");
                s.execute("Delete from game_possible_response_local where possibleResponseID=" + getSelectedDocument().ID + "");
                System.out.println("******** ************* ********");
                }
            //rafraichir le tableau
            Add.initList();
            con.close();
            context.addMessage(null, new FacesMessage("Answer deleted"));
            }
        catch (ClassNotFoundException ex)
            {
            System.out.println(ex.toString());
            }
        catch (SQLException ex)
            {
            System.out.println(ex.toString());
            }
        }
    public void editanswer()
        {
        FacesContext context = FacesContext.getCurrentInstance();
        int i = 0;
        int length = getSelectedDocument().text.size();
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            Statement st = con.createStatement();
            Double x = Double.parseDouble(getSelectedDocument().val);

            System.out.println("val = " + x);

            while (i < length)
                {
                System.out.println("****** EDIT ANSWERS ********");
                System.out.println("UPDATE game_possible_response_local SET text = '" + getSelectedDocument().text.get(i) + "' where possibleResponseID=" + getSelectedDocument().ID + " and cultureCode='" + culture.get(i) + "'");
                st.executeUpdate("UPDATE game_possible_response_local SET text = '" + getSelectedDocument().text.get(i) + "' where possibleResponseID=" + getSelectedDocument().ID + " and cultureCode='" + culture.get(i) + "'");
                i++;
                }
            System.out.println("UPDATE game_possible_response SET keyword = '" + getSelectedDocument().key + "',value=" + x + " where possibleResponseID=" + getSelectedDocument().ID + "");
            st.executeUpdate("UPDATE game_possible_response SET keyword = '" + getSelectedDocument().key + "',value=" + x + " where possibleResponseID=" + getSelectedDocument().ID + "");
            Add.initList();
            con.close();
            context.addMessage(null, new FacesMessage("Answer updated"));


            }
        catch (ClassNotFoundException ex)
            {
            System.out.println(ex.toString());
            context.addMessage(null, new FacesMessage("Error"));

            }
        catch (SQLException ex)
            {
            System.out.println(ex.toString());
            context.addMessage(null, new FacesMessage("Error"));
            }
        catch (Exception e)
            {
            System.out.println(e.toString());
            context.addMessage(null, new FacesMessage("Error"));
            }
        System.out.println("******** ************* ********");

        }
    public void editques()
        {
        FacesContext context = FacesContext.getCurrentInstance();
        int varID;
        int i = 0;
        int length = getSelectedDocument().text.size();
        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            Statement st = con.createStatement();
            String q = "select VariableID from variables where VariableName='" + getSelectedDocument().variable + "' and ValueType='Crowdsourcing value'";
            System.out.println(q);
            PreparedStatement ps = con.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            if (rs.first())
                {
                System.out.println("****** EDIT QUESTIONS ********");
                varID = rs.getInt(1);
                while (i < length)
                    {
                    System.out.println("UPDATE game_question_local SET text = '" + getSelectedDocument().text.get(i) + "' where questionID=" + getSelectedDocument().ID + " and cultureCode='" + culture.get(i) + "'");
                    st.executeUpdate("UPDATE game_question_local SET text = '" + getSelectedDocument().text.get(i) + "' where questionID=" + getSelectedDocument().ID + " and cultureCode='" + culture.get(i) + "'");
                    i++;
                    }
                System.out.println("UPDATE game_question SET variableID=" + varID + ",keyword = '" + getSelectedDocument().key + "',timeBetweenResponses=" + getSelectedDocument().time + ",userResponseAllowed=" + getSelectedDocument().allow + " where questionID=" + getSelectedDocument().ID + "");
                st.executeUpdate("UPDATE game_question SET variableID=" + varID + ",keyword = '" + getSelectedDocument().key + "',timeBetweenResponses=" + getSelectedDocument().time + ",userResponseAllowed=" + getSelectedDocument().allow + " where questionID=" + getSelectedDocument().ID + "");
                Add.initList();
                con.close();
                context.addMessage(null, new FacesMessage("Question updated"));
                }
            }
        catch (ClassNotFoundException ex)
            {
            System.out.println(ex.toString());
            context.addMessage(null, new FacesMessage("Error"));
            }
        catch (SQLException ex)
            {
            System.out.println(ex.toString());
            context.addMessage(null, new FacesMessage("Error"));
            }
        catch (Exception e)
            {
            System.out.println(e.toString());
            context.addMessage(null, new FacesMessage("Error"));
            }
        System.out.println("******** ************* ********");
        }
    }
