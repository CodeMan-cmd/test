package util;

/**
 * @author Cmonesr
 * @date Wednesday 19 Jun 2019  15:26
 */

public class Pager {


    public Pager(int countDate, int currentPageNumber) {
        setCountData(countDate);
        setCurrentPageNumber(currentPageNumber);
    }

    public Pager(int countData) {
        setCountData(countData);
    }

    //    每页显示条数
    private int pageShowNumber = 3;

    public void setPageShowNumber(int pageShowNumber) {
        this.pageShowNumber = pageShowNumber;
    }

    //  SQL起始数
    private int sqlStartNumber = 0;

    public int getSqlStartNumber() {
        return sqlStartNumber;
    }

    //  当前页数
    private int currentPageNumber = 1;

    public int getCurrentPageNumber() {
        return currentPageNumber;
    }

    public void setCurrentPageNumber(int currentPageNumber) {
        if (currentPageNumber < 1) currentPageNumber = 1;
        if (currentPageNumber > totalPage) currentPageNumber = totalPage;

        sqlStartNumber = (currentPageNumber - 1) * pageShowNumber;
        this.currentPageNumber = currentPageNumber;
    }

    //    总页数
    private int totalPage = 0;

    public int getTotalPage() {
        return totalPage;
    }

    //  设置数据总条数
    public void setCountData(int countData) {
        if (countData < 1) throw new RuntimeException("util.Pager.countData Cannot be 0");
        totalPage = (int) Math.ceil((double) countData / (double) pageShowNumber);
    }
}
