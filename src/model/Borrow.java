/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.time.LocalDate;
import java.io.Serializable;

/**
 *
 * @author Huy Hoàng
 */
import java.util.Date;

public class Borrow implements Serializable {
	private String idReader;
	private String idBook;
	private Date lendDate;
	private Date dueDate;
	private String overtime;

    public Borrow(String idBorrow, String idReader1, String idBook1) {
    }

    public Borrow(String idReader, String idBook, Date lendDate, Date dueDate, String overtime) {
        this.idReader = idReader;
        this.idBook = idBook;
        this.lendDate = lendDate;
        this.dueDate = dueDate;
        this.overtime = overtime;
    }


    public String getIdReader() {
        return idReader;
    }

    public void setIdReader(String idReader) {
        this.idReader = idReader;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    @Override
    public String toString() {
        return "Borrow{" + "idReader=" + idReader + ", idBook=" + idBook + ", lendDate=" + lendDate + ", dueDate=" + dueDate + ", overtime=" + overtime + '}';
    }

  
}
