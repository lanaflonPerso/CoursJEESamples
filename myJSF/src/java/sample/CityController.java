/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import javax.annotation.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.UserTransaction;
import sample.util.JsfUtil;
import sample.util.PagingInfo;

/**
 *
 * @author nabil.ouerhani
 */
public class CityController {

    public CityController() {
        pagingInfo = new PagingInfo();
        converter = new CityConverter();
    }
    private City city = null;
    private List<City> cityItems = null;
    private CityFacade jpaController = null;
    private CityConverter converter = null;
    private PagingInfo pagingInfo = null;
    @Resource
    private UserTransaction utx = null;
    @PersistenceUnit(unitName = "myJSFPU")
    private EntityManagerFactory emf = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(getJpaController().count());
        }
        return pagingInfo;
    }

    public CityFacade getJpaController() {
        if (jpaController == null) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            jpaController = (CityFacade) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "cityJpa");
        }
        return jpaController;
    }

    public SelectItem[] getCityItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), false);
    }

    public SelectItem[] getCityItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(getJpaController().findAll(), true);
    }

    public City getCity() {
        if (city == null) {
            city = (City) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCity", converter, null);
        }
        if (city == null) {
            city = new City();
        }
        return city;
    }

    public String listSetup() {
        reset(true);
        return "city_list";
    }

    public String createSetup() {
        reset(false);
        city = new City();
        return "city_create";
    }

    public String create() {
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().create(city);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("City was successfully created.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("city_detail");
    }

    public String editSetup() {
        return scalarSetup("city_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        city = (City) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCity", converter, null);
        if (city == null) {
            String requestCityString = JsfUtil.getRequestParameter("jsfcrud.currentCity");
            JsfUtil.addErrorMessage("The city with id " + requestCityString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String cityString = converter.getAsString(FacesContext.getCurrentInstance(), null, city);
        String currentCityString = JsfUtil.getRequestParameter("jsfcrud.currentCity");
        if (cityString == null || cityString.length() == 0 || !cityString.equals(currentCityString)) {
            String outcome = editSetup();
            if ("city_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit city. Try again.");
            }
            return outcome;
        }
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().edit(city);
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("City was successfully updated.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String remove() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCity");
        Integer id = new Integer(idAsString);
        try {
            utx.begin();
        } catch (Exception ex) {
        }
        try {
            Exception transactionException = null;
            getJpaController().remove(getJpaController().find(id));
            try {
                utx.commit();
            } catch (javax.transaction.RollbackException ex) {
                transactionException = ex;
            } catch (Exception ex) {
            }
            if (transactionException == null) {
                JsfUtil.addSuccessMessage("City was successfully deleted.");
            } else {
                JsfUtil.ensureAddErrorMessage(transactionException, "A persistence error occurred.");
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (Exception ex) {
            }
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<City> getCityItems() {
        if (cityItems == null) {
            getPagingInfo();
            cityItems = getJpaController().findRange(new int[]{pagingInfo.getFirstItem(), pagingInfo.getFirstItem() + pagingInfo.getBatchSize()});
        }
        return cityItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "city_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "city_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        city = null;
        cityItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        City newCity = new City();
        String newCityString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCity);
        String cityString = converter.getAsString(FacesContext.getCurrentInstance(), null, city);
        if (!newCityString.equals(cityString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }
    
}
