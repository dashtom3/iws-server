package com.xj.iws.common.utils;

/**
 * Created by XiaoJiang01 on 2017/5/12.
 */
public class Page {
    private int numberPerPage;
    private int currentPage;
    private int currentNumber;

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public Page() {
    }

    public Page(int numberPerPage, int currentPage, int totalNumber, int totalPage) {

        this.numberPerPage = numberPerPage;
        this.currentPage = currentPage;
    }

    public int getNumberPerPage() {

        return numberPerPage;
    }

    public void setNumberPerPage(int numberPerPage) {
        this.numberPerPage = numberPerPage;
        if (currentPage != 0){
            currentNumber = (currentPage-1)*numberPerPage;
        }
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
        if (numberPerPage != 0){
            currentNumber = (currentPage-1)*numberPerPage;
        }
    }
}
