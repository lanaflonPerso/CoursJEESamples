/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beansHoucem;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Houcem
 */
@ManagedBean(name = "addBean")
@SessionScoped
public class Add implements Serializable
    {
    static List<String> culture;
    static List<String> culture3;
    static List<String> culture4;
    String selectedQues;
    int value;
    public int getValue()
        {
        return value;
        }
    public void setValue(int value)
        {
        this.value = value;
        }
    public String getKeywordResp()
        {
        return keywordResp;
        }
    public void setKeywordResp(String keywordResp)
        {
        this.keywordResp = keywordResp;
        }
    String keywordResp;
    public List<String> getQuest()
        {
        return quest;
        }
    public String getSelectedQues()
        {
        return selectedQues;
        }
    public void setSelectedQues(String selectedQues)
        {
        this.selectedQues = selectedQues;
        }
    public void setQuest(List<String> quest)
        {
        this.quest = quest;
        }
    static List<String> quest;
    public List<String> getCulture2()
        {
        return culture2;
        }
    public void setCulture2(List<String> culture2)
        {
        this.culture2 = culture2;
        }
    static List<String> culture2;
    String selectedCar;
    static String selectedCar2;
    public String getSelectedCar2()
        {
        return selectedCar2;
        }
    public void setSelectedCar2(String selectedCar2)
        {
        this.selectedCar2 = selectedCar2;
        }
    static DocumentsController x;
    public List<String> getVariable()
        {
        return variable;
        }
    public DocumentsController getX()
        {
        return x;
        }
    public void setX(DocumentsController x)
        {
        this.x = x;
        }
    public void setVariable(List<String> variable)
        {
        this.variable = variable;
        }
    static List<String> variable;
    public String getSelectedCar()
        {
        return selectedCar;
        }
    public void setSelectedCar(String selectedCar)
        {
        this.selectedCar = selectedCar;
        }
    public List<String> getCarsSmall()
        {
        return this.variable;
        }
    @PostConstruct
    public static void initList()
        {
        x = new DocumentsController();
        variable = new ArrayList<String>();
        culture = new ArrayList<String>();
        culture2 = new ArrayList<String>();
        culture3 = new ArrayList<String>();
        culture4 = new ArrayList<String>();
        quest = new ArrayList<String>();

        try
            {
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            PreparedStatement ps = con.prepareStatement("select code from culture");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                {
                culture.add(rs.getString(1));
                culture2.add(rs.getString(1));
                culture3.add(rs.getString(1));
                culture4.add(rs.getString(1));
                }
            PreparedStatement ps2 = con.prepareStatement("select VariableName from variables where ValueType='Crowdsourcing value'");
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next())
                {
                variable.add(rs2.getString(1));
                }
            PreparedStatement ps3 = con.prepareStatement("select text from game_question_local where cultureCode='en'");
            ResultSet rs3 = ps3.executeQuery();
            while (rs3.next())
                {
                quest.add(rs3.getString(1));
                }
            con.close();
            }
        catch (SQLException ex)
            {
            }
        catch (ClassNotFoundException ex)
            {
            }
        }
    public void refresh()
        {
        initList();
        }
    public List<String> getCulture3()
        {
        return culture3;
        }
    public void setCulture3(List<String> culture3)
        {
        this.culture3 = culture3;
        }
    public List<String> getCulture4()
        {
        return culture4;
        }
    public void setCulture4(List<String> culture4)
        {
        this.culture4 = culture4;
        }
    public List<String> getCulture()
        {
        return culture;
        }
    public void setCulture(List<String> culture)
        {
        this.culture = culture;
        }
    public String getKeyword()
        {
        return keyword;
        }
    public void setKeyword(String keyword)
        {
        this.keyword = keyword;
        }
    public int getTime()
        {
        return time;
        }
    public void setTime(int time)
        {
        this.time = time;
        }
    public boolean isAllow()
        {
        return allow;
        }
    public void setAllow(boolean allow)
        {
        this.allow = allow;
        }
    public void ex()
        {
        int i = 0;
        int length = 0;
        length = culture.size();
        ResultSet generatedKeys = null;
        int key = -1;
        int varID = -1;
        try
            {
            System.out.println("******** ADD QUESTION ********");
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            System.out.println("select VariableID from variables where ValueType='Crowdsourcing value' and VariableName='" + getSelectedCar() + "' ");
            PreparedStatement ps = con.prepareStatement("select VariableID from variables where ValueType='Crowdsourcing value' and VariableName='" + getSelectedCar() + "' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                {
                varID = rs.getInt(1);
                }
            System.out.println("INSERT INTO game_question (keyword,variableID,userResponseAllowed,timeBetweenResponses) VALUES('" + keyword + "'," + varID + "," + allow + "," + time + ")");
            PreparedStatement st = (PreparedStatement) con.prepareStatement("INSERT INTO game_question (keyword,variableID,userResponseAllowed,timeBetweenResponses) VALUES('" + keyword + "'," + varID + "," + allow + "," + time + ")", Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next())
                {
                key = generatedKeys.getInt(1);
                }
            while (i < length)
                {
                System.out.println(culture2.get(i) + " equal " + culture.get(i) + " ?");
                if (!culture2.get(i).equals(culture.get(i)))
                    {
                    System.out.println("INSERT INTO game_question_local (questionID,cultureCode,text) VALUES(" + key + ",'" + culture2.get(i) + "','" + culture.get(i) + "')");
                    st.executeUpdate("INSERT INTO game_question_local (questionID,cultureCode,text) VALUES(" + key + ",'" + culture2.get(i) + "','" + culture.get(i) + "')");
                    }

                i++;
                }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Question Added", ""));

            con.close();
            System.out.println("******** ************* ********");
            }
        catch (SQLException ex)
            {
            }
        catch (ClassNotFoundException ex)
            {
            }
        initList();


        }
    public void addAnswer()
        {
        int i = 0;
        int length = 0;
        length = culture.size();
        ResultSet generatedKeys = null;
        int key = -1;
        int quesID = -1;
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Answer Added", getSelectedQues() + culture3.get(0) + culture4.get(0)));

        try
            {
            System.out.println("******** ADD ANSWERS ********");
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/odm", "Capocasale", "TGUp38y4");
            System.out.println("select questionID from game_question_local where text='" + getSelectedQues() + "' ");
            PreparedStatement ps = con.prepareStatement("select questionID from game_question_local where text='" + getSelectedQues() + "' ");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                {
                quesID = rs.getInt(1);
                }
            System.out.println("INSERT INTO game_possible_response (questionID,keyword,value) VALUES(" + quesID + ",'" + keywordResp + "'," + value + ")");
            PreparedStatement st = (PreparedStatement) con.prepareStatement("INSERT INTO game_possible_response (questionID,keyword,value) VALUES(" + quesID + ",'" + keywordResp + "'," + value + ")", Statement.RETURN_GENERATED_KEYS);
            st.executeUpdate();
            generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next())
                {
                key = generatedKeys.getInt(1);
                }
            while (i < length)
                {
                System.out.println(culture.get(i) + " equal " + culture2.get(i) + " ?");
                if (!culture.get(i).equals(culture2.get(i)))
                    {
                    System.out.println("INSERT INTO game_possible_response_local (possibleResponseID,cultureCode,text) VALUES(" + key + ",'" + culture4.get(i) + "','" + culture3.get(i) + "')");
                    st.executeUpdate("INSERT INTO game_possible_response_local (possibleResponseID,cultureCode,text) VALUES(" + key + ",'" + culture4.get(i) + "','" + culture3.get(i) + "')");
                    }

                i++;
                }

            con.close();
            }
        catch (SQLException ex)
            {
            }
        catch (ClassNotFoundException ex)
            {
            }
        initList();
       
        System.out.println("******** ************* ********");
        }
    String keyword;
    int time;
    boolean allow;
    }
