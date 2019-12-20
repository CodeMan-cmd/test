package utils;

public class Page {
	// 每页显示条数
	final private int pageShowNumber = 3;
	// 当前页数
	private int nowPageNumber;
	// 总页数
	private int pagesCount;
	// 起始条数
	private int sqlLimitStartNumber;

	public Page() {
		init();
	}

	public void init() {
	}

	@Override
	public String toString() {
		return "Page{" + "pageShowNumber=" + pageShowNumber
				+ ", nowPageNumber=" + nowPageNumber + ", pagesCount="
				+ pagesCount + ", sqlLimitStartNumber=" + sqlLimitStartNumber
				+ '}';
	}

	// 获取每页显示条数
	public int getPageShowNumber() {
		return pageShowNumber;
	}

	// 获得当前页数
	public int getNowPageNumber() {
		return nowPageNumber;
	}

	// 设置当前页数
	public void setNowPageNumber(int nowPageNumber) {
		if (nowPageNumber <= 0)
			nowPageNumber = 1;
		if (nowPageNumber > pagesCount && pagesCount > 0)
			nowPageNumber = pagesCount;
		this.sqlLimitStartNumber = (nowPageNumber - 1) * pageShowNumber;
		this.nowPageNumber = nowPageNumber;
	}

	public int getPagesCount() {
		return pagesCount;
	}

	// 设置总页数
	public void setPagesCount(final int pagesCount) {
		this.pagesCount = (int) Math.ceil((double) pagesCount / pageShowNumber);
	}

	// 获得起始条数
	public int getSqlLimitStartNumber() {
		return sqlLimitStartNumber;
	}

	public void setSqlLimitStartNumber(int sqlLimitStartNumber) {
		this.sqlLimitStartNumber = sqlLimitStartNumber;
	}
}
