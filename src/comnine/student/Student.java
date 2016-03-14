package comnine.student;
import java.lang.String;
public class Student {
    int _id;//与所建立的表对应
	String Name;
	int Number;
    int Chinese;
    int Math;
   int  English;
    int b;
	public Student(String name,int Number,int Chinese,int Math,int  English){
		this.Name=Name;
		this.Number=Number;
		this.Chinese=Chinese;
		this.Math=Math;
		this.English=English;
	}
	public Student(){
		
	}
}
