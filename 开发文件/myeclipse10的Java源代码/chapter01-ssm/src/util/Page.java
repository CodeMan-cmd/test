package util;

public class Page {

	private int zongyeshu;
	private int zongjilushu;
	private int meiyexianshitiaoshu=5;
	private int dangqianyeshu=1;
	private int qishitiaoshu;
	
	
	
	public int getQishitiaoshu() {
		if(this.dangqianyeshu>this.zongyeshu&&this.zongyeshu!=0){
			return (this.zongyeshu-1)*this.getMeiyexianshitiaoshu();
		}
		
		
		return (this.getDangqianyeshu()-1)*this.getMeiyexianshitiaoshu();
	}
	public void setQishitiaoshu(int qishitiaoshu) {
		this.qishitiaoshu = qishitiaoshu;
	}
	public int getZongyeshu() {
		return this.getZongjilushu()%this.getMeiyexianshitiaoshu()==0?this.getZongjilushu()/this.getMeiyexianshitiaoshu():
			this.getZongjilushu()/this.getMeiyexianshitiaoshu()+1;
	}
	public void setZongyeshu(int zongyeshu) {
		this.zongyeshu = zongyeshu;
	}
	public int getZongjilushu() {
		return zongjilushu;
	}
	public void setZongjilushu(int zongjilushu) {
		this.zongjilushu = zongjilushu;
	}
	public int getMeiyexianshitiaoshu() {
		if(this.meiyexianshitiaoshu==0){
			return 5;
		}
		return meiyexianshitiaoshu;
	}
	public void setMeiyexianshitiaoshu(int meiyexianshitiaoshu) {
		this.meiyexianshitiaoshu = meiyexianshitiaoshu;
	}
	public int getDangqianyeshu() {
		
		if(this.dangqianyeshu>this.zongyeshu&&this.zongyeshu!=0){
			return zongyeshu;
		}
		return dangqianyeshu;
	}
	public void setDangqianyeshu(int dangqianyeshu) {
		this.dangqianyeshu = dangqianyeshu;
	}
	
	
}
