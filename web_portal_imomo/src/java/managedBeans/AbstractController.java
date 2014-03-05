/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import managedBeans.util.JsfUtil;
import managedBeans.util.PaginationHelper;
import sessionBeans.AbstractFacade;

/**
 *
 * @author Raphaël
 */
public abstract class AbstractController<T>
    {
    /*-------------------------------------------------------------------------------------
     Attributs
     --------------------------------------------------------------------------------------*/
    protected T current;
    protected Class<T> itemClass;
    protected DataModel items = null;
    protected AbstractFacade<T> ejbFacade;
    protected PaginationHelper pagination;
    protected int selectedItemIndex;
    /*-------------------------------------------------------------------------------------
     Constructor
     --------------------------------------------------------------------------------------*/
    public AbstractController()
        {
        }
    public AbstractController(Class<T> itemClass)
        {
        this.itemClass = itemClass;
        }
    /*-------------------------------------------------------------------------------------
     Methods public
     --------------------------------------------------------------------------------------*/
    public String create(String path)
        {
        try
            {
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemCreated"));
            return prepareCreate(path);
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
            }
        }
    public String create()
        {
        return this.create("");
        }
    public String read(String path)
        {
        return path + "View";
        }
    public String read()
        {
        return this.read("");
        }
    public String update(String path)
        {
        try
            {
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemUpdated"));
            return path + "View";
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
            }
        }
    public String update()
        {
        return this.update("");
        }
    public String delete(String path)
        {
        try
            {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));
            return path + "List";
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            return null;
            }
        }
    public String delete()
        {
        return this.delete("");
        }
    public String destroy(String path)
        {
        current = (T) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return path + "List";
        }
    public String destroy()
        {
        return this.destroy("");
        }
    public String prepareList(String path)
        {
        recreateModel();
        return path + "List";
        }
    public String prepareList()
        {
        return this.prepareList("");
        }
    public String prepareView(String path)
        {
        current = (T) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return path + "View";
        }
    public String prepareView()
        {
        return this.prepareView("");
        }
    public String prepareEdit(String path)
        {
        current = (T) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return path + "Edit";
        }
    public String prepareEdit()
        {
        return this.prepareEdit("");
        }
    public String prepareCreate(String path)
        {
        System.out.println("preparateCreate");
        T newItem;
        try
            {
            newItem = itemClass.newInstance();
            this.current = newItem;
            selectedItemIndex = -1;
            System.out.println("end");
            return path + "Create";
            }
        catch (InstantiationException ex)
            {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        catch (IllegalAccessException ex)
            {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            }
        return null;
        }
    public String prepareCreate()
        {
        return this.prepareCreate("");
        }
    public String destroyAndView(String path)
        {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0)
            {
            return path + "View";
            }
        else
            {
            // all items were removed - go back to list
            recreateModel();
            return path + "List";
            }
        }
    public String destroyAndView()
        {
        return this.destroyAndView("");
        }
    public String next(String path)
        {
        getPagination().nextPage();
        recreateModel();
        return path + "List";
        }
    public String next()
        {
        return this.next("");
        }
    public String previous(String path)
        {
        getPagination().previousPage();
        recreateModel();
        return path + "List";
        }
    public String previous()
        {
        return this.previous("");
        }
    /*-----------------------------------
     get
     ------------------------------------*/
    public List<T> getList()
        {
        List<T> list = ejbFacade.findAll();
        return list;
        }
    public T getSelected()
        {
        if (current == null)
            {
            T newItem;
            try
                {
                newItem = itemClass.newInstance();
                this.current = newItem;
                selectedItemIndex = -1;
                }
            catch (InstantiationException ex)
                {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            catch (IllegalAccessException ex)
                {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                }
            }
        return current;
        }
    public T getNewSelected()
        {
        current = null;
        return this.getSelected();
        }
    public PaginationHelper getPagination()
        {
        if (pagination == null)
            {
            pagination = new PaginationHelper(10)
                {
                @Override
                public int getItemsCount()
                    {
                    return getFacade().count();
                    }
                @Override
                public DataModel createPageDataModel()
                    {
                    return new ListDataModel(getFacade().findRange(new int[]
                        {
                        getPageFirstItem(), getPageFirstItem() + getPageSize()
                        }));
                    }
                };
            }
        return pagination;
        }
    public DataModel getItems()
        {
        if (items == null)
            {
            items = getPagination().createPageDataModel();
            }
        return items;
        }
    public SelectItem[] getItemsAvailableSelectMany()
        {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
        }
    public SelectItem[] getItemsAvailableSelectOne()
        {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
        }
    public T getCurrent()
        {
        return current;
        }
    /*-----------------------------------
     set
     ------------------------------------*/
    public void setCurrent(T current)
        {
        this.current = current;
        }
    public void setFacade(AbstractFacade<T> ejbFacade)
        {
        this.ejbFacade = ejbFacade;
        }
    /*-------------------------------------------------------------------------------------
     Methods protected
     --------------------------------------------------------------------------------------*/
    protected AbstractFacade<T> getFacade()
        {
        return ejbFacade;
        }
    /*-------------------------------------------------------------------------------------
     Methods private
     --------------------------------------------------------------------------------------*/
    private void performDestroy()
        {
        try
            {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/resources/Bundle").getString("ItemDeleted"));
            }
        catch (Exception e)
            {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/resources/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    private void updateCurrentItem()
        {
        int count = getFacade().count();
        if (selectedItemIndex >= count)
            {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count)
                {
                pagination.previousPage();
                }
            }
        if (selectedItemIndex >= 0)
            {
            current = getFacade().findRange(new int[]
                {
                selectedItemIndex, selectedItemIndex + 1
                }).get(0);
            }
        }
    private void recreateModel()
        {
        items = null;
        }
    private void recreatePagination()
        {
        pagination = null;
        }
    }
