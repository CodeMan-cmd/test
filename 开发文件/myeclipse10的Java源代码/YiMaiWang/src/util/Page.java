package util;

public class Page {
     private  int dangqianyema;
     private  int meiyetiaoshu;
     private  int zongyeshu;
     private  int zongjilushu;
     private  int qishiyeshu;
     
      //起始页数
     public int getQishiyeshu() {
    	 if(this.dangqianyema>this.zongyeshu && this.zongyeshu!=0){
    		 return (this.zongjilushu-1)*this.getMeiyetiaoshu();
    	 }
		return  (this.getDangqianyema()-1)*this.getMeiyetiaoshu();
				}
	public void setQishiyeshu(int qishiyeshu) {
		this.qishiyeshu = qishiyeshu;
	}
	//当前页码
     public int getDangqianyema() {
    	 if(this.dangqianyema==0){
    		 return 1;
    	 }
    	 if(this.dangqianyema>=this.getZongyeshu() && this.getZongyeshu()!=0){
    		 return this.getZongyeshu();
    	 }
 		return dangqianyema;
 	}
 	public void setDangqianyema(int dangqianyema) {
 		
 		this.dangqianyema = dangqianyema;
 	}
     //每页条数
	public int getMeiyetiaoshu() {
		 if(this.meiyetiaoshu==0){
		 }
		return 1;
	}
	
	public void setMeiyetiaoshu(int meiyetiaoshu) {
	
		this.meiyetiaoshu = meiyetiaoshu;
	}
	//总页数
	public int getZongyeshu() {
		return this.getZongjilushu()%this.getMeiyetiaoshu()==0?this.getZongjilushu()/this.getMeiyetiaoshu():
			this.getZongjilushu()/this.getMeiyetiaoshu()+1;
	}
	public void setZongyeshu(int zongyeshu) {
		this.zongyeshu = zongyeshu;
	}
	//总记录数
	public int getZongjilushu() {
		return zongjilushu;
	}
	public void setZongjilushu(int zongjilushu) {
		this.zongjilushu = zongjilushu;
	}
     
}
