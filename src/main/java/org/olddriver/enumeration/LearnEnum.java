package org.olddriver.enumeration;
/**
 * 
 * enum 笔记
 *
 */
public enum LearnEnum {
	/*
	 * 枚举
	 * 使用enum关键字声明的类就是枚举类
	 * 枚举类中包含一组枚举值
	 * 
	 * 枚举类的声明格式
	 * modifier	enum	EnumName{
	 * 		EnumValue,EnumValue,...;
	 * }
	 * 
	 * 枚举类特点
	 * 使用enum关键字声明的枚举类是Enum类的子类
	 * 
	 * 枚举值特点
	 * 枚举值是枚举类的子类对象，采用匿名内部类的方式创建
	 * 当使用默认父类构造器进行初始化，参数列表可以省略
	 * 当不需为枚举值定义特有成员，{}可以省略
	 * 枚举值默认public static final修饰，要求枚举值名称大写
	 * 
	 * values方法
	 * 编译器会在枚举类中添加一个静态values方法，通过values方法可以获取包含所有枚举值的数组
	 * Enum类中不含此方法
	 * 
	 * 静态导入
	 * 使用静态导入，可以将枚举类中的所有枚举值导入到指定类中
	 * 之后能够通过枚举值名称直接使用枚举值，不便于阅读
	 * 
	 * 枚举类中构造器
	 * 可以在枚举类中定义构造器，用于子类对象初始化
	 * 当在枚举类中定义构造器，可能会影响枚举值的定义格式（即当枚举类中无默认构造器，
	 * 枚举值后的参数列表不能省略）
	 * 枚举类中构造器必须private修饰
	 * 通过枚举类的构造器可以为枚举类中成员变量赋值
	 * 
	 * 枚举类中成员方法
	 * 可以在枚举类中定义成员方法，或对父类中方法进行覆盖
	 * 
	 * 枚举类中成员变量
	 * 可以在枚举类中定义成员变量，成员变量的值通过构造器注入
	 * 
	 * 枚举类中抽象方法
	 * 枚举类中可以定义抽象方法，定义枚举值时在{}中给出抽象方法实现
	 * 不同枚举值可以定义不同实现
	 * 
	 * 枚举类已经继承Enum类，不能再继承其他类，但可以实现多个接口
	 * 
	 * EnumSet
	 * 配合枚举值使用的集合
	 * 集合中的元素必须是同一枚举类中的枚举值
	 * 
	 * EnumMap
	 * 配合枚举值使用的映射表
	 * 映射表中key必须来自同一个枚举类
	 */
	SUNDAY("0","星期日"){
		public void doSomething() {
			System.out.println("星期日");
		}
	},
	MONDAY("1","星期一"){
		public void doSomething() {
			System.out.println("星期一");
			System.out.println("星期一");
		}
	},
	TUESDAY("2","星期二"){
		public void doSomething() {
			System.out.println("星期二");
			System.out.println("星期二");
			System.out.println("星期二");
		}
	},
	WEDNESDAY("3","星期三"){
		public void doSomething() {
			System.out.println("星期三");
			System.out.println("星期三");
			System.out.println("星期三");
			System.out.println("星期三");
		}
	},
	THURSDAY("4","星期四"){
		public void doSomething() {
			System.out.println("星期四");
			System.out.println("星期四");
			System.out.println("星期四");
			System.out.println("星期四");
			System.out.println("星期四");
		}
	},
	FRIDAY("5","星期五"){
		public void doSomething() {
			System.out.println("星期五");
			System.out.println("星期五");
			System.out.println("星期五");
			System.out.println("星期五");
			System.out.println("星期五");
			System.out.println("星期五");
		}
	},
	SATURDAY("6","星期六"){
		public void doSomething() {
			System.out.println("星期六");
			System.out.println("星期六");
			System.out.println("星期六");
			System.out.println("星期六");
			System.out.println("星期六");
			System.out.println("星期六");
			System.out.println("星期六"); 
		}
	};
	
	private String index;
	private String value;
	private LearnEnum(String index,String value) {
		this.index = index;
		this.value = value;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public abstract void doSomething();
	
}
