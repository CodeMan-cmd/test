package pojo;

public class Easybuy_product {
	private int id;					//主键
	private String name;            //名称
	private String description;		//描述
	private double price;			//价格
	private int stock;				//库存
	////////////categoryLevel1Id
	private int categoryLeve11Id;	//分类1
	private int categoryLeve12Id;	//分类2
	private int categoryLeve13Id;	//分类3
	private String fileName;		//文件名称
	private int isDelete;			//是否删除
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getCategoryLeve11Id() {
		return categoryLeve11Id;
	}
	public void setCategoryLeve11Id(int categoryLeve11Id) {
		this.categoryLeve11Id = categoryLeve11Id;
	}
	public int getCategoryLeve12Id() {
		return categoryLeve12Id;
	}
	public void setCategoryLeve12Id(int categoryLeve12Id) {
		this.categoryLeve12Id = categoryLeve12Id;
	}
	public int getCategoryLeve13Id() {
		return categoryLeve13Id;
	}
	public void setCategoryLeve13Id(int categoryLeve13Id) {
		this.categoryLeve13Id = categoryLeve13Id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	public Easybuy_product(int id, String name, String description,
			double price, int stock, int categoryLeve11Id,
			int categoryLeve12Id, int categoryLeve13Id, String fileName,
			int isDelete) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.categoryLeve11Id = categoryLeve11Id;
		this.categoryLeve12Id = categoryLeve12Id;
		this.categoryLeve13Id = categoryLeve13Id;
		this.fileName = fileName;
		this.isDelete = isDelete;
	}
	public Easybuy_product() {
		super();
	}
}
