//���ַ����Ŀո�ɾ��,ͳ���ַ������ظ����ֵ��Ӵ��ĸ���
package pm1;

public class Demo1 {
	public static void main(String[] args) {
		String str="      ƶ      ��           ";
		System.out.println(myTrim(str));
		str="abcjavabcjavajavphpjavaandjva";
		String target="java";
		getCount(str,target);
	}
	public static String myTrim(String str){
		//ת�����ַ�����
		char[] arr=str.toCharArray();
		int min=0,max=arr.length-1;
		while(true){
			if(arr[min]==' '){
				min++;
			}
			else{
				break;
			}
		}
		while(true){
			if(arr[max]==' '){
				max--;
			}
			else{
				break;
			}
		}
		return str.substring(min, max+1);
	}
	public static void getCount(String str,String target){
		int count=0;
		int num=0;
		while((num=str.indexOf(target, num))!=-1){
			count++;
			num=num+target.length();
			
		}
		System.out.println(count);
	}

}
