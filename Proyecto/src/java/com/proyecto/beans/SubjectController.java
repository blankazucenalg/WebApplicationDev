/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.dao.AsignaturaDAO;
import com.proyecto.model.Asignatura;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author azu
 */
@ManagedBean
@SessionScoped
public class SubjectController {

    int startId;
    int endId;
    DataModel subjects;
    AsignaturaDAO helper;
    private int recordCount = 1000;
    private int pageSize = 10;
    private Asignatura current;
    private int selectedItemIndex;

    /**
     * Creates a new instance of SubjectsController
     */
    public SubjectController() {
        helper = new AsignaturaDAO();
        startId = 1;
        endId = 1000;
    }

    public SubjectController(int startId, int endId) {
        helper = new AsignaturaDAO();
        this.startId = startId;
        this.endId = endId;
    }
    
    public Asignatura getSelected(){
        if(current == null){
            current = new Asignatura();
            selectedItemIndex = -1;
        }
        return current;
    }
    
    public DataModel getSubjects() throws Exception{
        if(subjects == null){
            subjects = new ListDataModel((List) helper.loadAll(startId, endId));
        }
        return subjects;
    }
    
    void recreateModel(){
        subjects = null;
    }
    
    public boolean isHasNextPage(){
        if(endId + pageSize <= recordCount){
            return true;
        }
        return false;
    }
    
    public boolean isHasPreviousPage(){
        if(startId - pageSize > 0){
            return true;
        }
        return false;
    }
    
    public String next() {
        startId = endId+1;
        endId = endId + pageSize;
        recreateModel();
        return "system";
    }

    public String previous() {
        startId = startId - pageSize;
        endId = endId - pageSize;
        recreateModel();
        return "system";
    }

    public int getPageSize() {
        return pageSize;
    }

    public String prepareView() throws Exception{
        current = (Asignatura) getSubjects().getRowData();
        return "system";
    }
    public String prepareList(){
        recreateModel();
        return "system";
    }
}
