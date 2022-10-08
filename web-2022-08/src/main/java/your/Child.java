package your;

import my.PackageClass;

public class Child extends PackageClass{
	
	Child() {
//		a = 1; // 접근 제한자가 생략되어 있어서 같은 클래스거나 같은 패키지여야 사용 가능.
		b = 2;
		c = 3;
	}

}
