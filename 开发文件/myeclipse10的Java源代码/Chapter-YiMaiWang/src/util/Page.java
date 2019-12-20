package util;

public class Page {
	private int zongyeshu;
	private int zongjiluhsu;
	private int meiyexianshitioashu;
	private int dangqianyeshu;
	private int qishitiaoshu;

	public int getZongyeshu() {
		return this.getZongjiluhsu()%this.getMeiyexianshitioashu()==0?this.getZongjiluhsu()/this.getMeiyexianshitioashu():
			this.getZongjiluhsu()/this.getMeiyexianshitioashu()+1;
	}

	public void setZongyeshu(int zongyeshu) {
		this.zongyeshu = zongyeshu;
	}

	public int getZongjiluhsu() {
		return zongjiluhsu;
	}

	public void setZongjiluhsu(int zongjiluhsu) {
		this.zongjiluhsu = zongjiluhsu;
	}

	public int getMeiyexianshitioashu() {
		if (this.meiyexianshitioashu==0) {
			return 5;
		}
		return meiyexianshitioashu;
	}

	public void setMeiyexianshitioashu(int meiyexianshitioashu) {
		this.meiyexianshitioashu = meiyexianshitioashu;
	}

	public int getDangqianyeshu() {
		if (this.dangqianyeshu==0) {
			return 1;
		}
		return dangqianyeshu;
	}

	public void setDangqianyeshu(int dangqianyeshu) {
		this.dangqianyeshu = dangqianyeshu;
	}

	public int getQishitiaoshu() {
		return (this.getDangqianyeshu()-1)*this.getMeiyexianshitioashu();
	}

	public void setQishitiaoshu(int qishitiaoshu) {
		this.qishitiaoshu = qishitiaoshu;
	}

}